package Bibliothek;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

/**
 * 
 */

//VS4E -- DO NOT REMOVE THIS LINE!
public class DBAusleiher extends JDialog {
	
	private Bibliothek mParent;
	private Statement stmt;
	private ResultSet rset;
	
	private String authorVN = "";
	private String authorNN = "";

	private static final long serialVersionUID = 1L;
	private JButton jOKButton;
	private JTable jAuthorTable;
	private JScrollPane jScrollPane0;



	public DBAusleiher(Bibliothek parent) {
		super(parent);
		mParent = parent;
		initComponents();
		try {
			dbAusleiherAnzeigen();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(getParent(),
				    e.getMessage(),
				    "Es konnten keine Ausleiher des Datenbanken " +
				    "Buches geladen werden",
				    JOptionPane.ERROR_MESSAGE);
			
			e.printStackTrace();
		}
		
	}
	
	public DBAusleiher(Bibliothek parent, String vn, String nn ) {
		super(parent);
		mParent = parent;
		System.out.print(vn);
		authorNN = nn;
		authorVN = vn;
		initComponents();
		
		try {
			AutorAusleiherAnzeigen();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(getParent(),
				    e.getMessage(),
				    "Keine Ausleiher für diesen Author",
				    JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	
	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJOKButton(), new Constraints(new Leading(90, 10, 10), new Leading(280, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(9, 217, 10, 10), new Leading(9, 259, 12, 12)));
		setSize(234, 313);
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJAuthorTable());
		}
		return jScrollPane0;
	}


	private JTable getJAuthorTable() {
		if (jAuthorTable == null) {
			jAuthorTable = new JTable();
			jAuthorTable.setModel(new DefaultTableModel(new Object[][] { }, new String[] { "Person" }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jAuthorTable.setEnabled(false);
			jAuthorTable.setRowHeight(20);
		}
		return jAuthorTable;
	}


	private JButton getJOKButton() {
		if (jOKButton == null) {
			jOKButton = new JButton();
			jOKButton.setText("OK");
			jOKButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					jOKButtonClicked(event);
				}
			});
		}
		return jOKButton;
	}

	private void jOKButtonClicked(MouseEvent event) {
		dispose();
	}

	/**
	 * Zeigt alle Personen an, die das Buch mit dem Titel „Datenbanken“ jemals ausgeliehen haben.
	 * Diese werden in die JTable geladen
	 * @throws SQLException
	 */
	private void dbAusleiherAnzeigen() throws SQLException{
		DefaultTableModel m = (DefaultTableModel)(jAuthorTable.getModel());
		stmt = mParent.getStatement();
		
		String query = ("SELECT DISTINCT bp.p_name " +
						"FROM bibliothek_personen bp, bibliothek_ausleihhistorie ba " +
						"WHERE bp.ausweisnr = ba.p_ausweisnr " +
						"AND ba.inventarnr IN ( SELECT bo.inventarnr " + 
                            					"FROM bibliothek_objekt bo " +
                            					"WHERE bo.titel = 'Datenbanken')");
		
		rset = stmt.executeQuery(query);
		String [] row = new String[1];
		
		System.out.println("Personen die jemals das Buch mit dem Titel \"Datenbanken\" ausgeliehen haben:");
		while (rset.next()){
			System.out.println(rset.getString(1));
			row[0] = rset.getString(1);
			m.addRow(row);

		}
	}
	
	private void AutorAusleiherAnzeigen() throws SQLException{
		DefaultTableModel m = (DefaultTableModel)(jAuthorTable.getModel());
		stmt = mParent.getStatement();
		System.out.println("Author: " + authorVN + " " + authorNN +" ");
		String query = ("SELECT bp.p_name FROM bibliothek_personen bp, bibliothek_ausleihhistorie ba " +
						"WHERE bp.ausweisnr = ba.p_ausweisnr AND ba.inventarnr IN " + 
												"(SELECT bo.inventarnr FROM bibliothek_objekt bo " +
												 "WHERE bo.inventarnr IN (SELECT boha.Inventarnr " +
    										  						  	  "FROM bibliothek_objekt_hat_autor boha " +
    										  						  	  "WHERE boha.id IN (SELECT bau.id "+
    										  						  						"FROM bibliothek_autor bau " +
    										  						  						"WHERE bau.vorname = '" + authorVN + "'" +
    										  						  						" AND bau.nachname = '" + authorNN + "'" + 
    																					")))");
    																				  
		rset = stmt.executeQuery(query);
		String [] row = new String[1];
		
		System.out.println("Personen die jemals das Buch von " + authorVN + " " + authorNN +" ausgeliehen haben:");
		while (rset.next()){
			System.out.println(rset.getString(1));
			row[0] = rset.getString(1);
			m.addRow(row);

		}
	}


	public DBAusleiher() {
		initComponents();
	}
}

/*
select bp.p_name
from bibliothek_personen bp, bibliothek_ausleihhistorie ba
where bp.ausweisnr = ba.p_ausweisnr
      and ba.inventarnr IN (select bo.inventarnr 
                            from bibliothek_objekt bo
                            where bo.titel = 'Datenbanken');*/

/*
SELECT bp.p_name 
FROM bibliothek_personen bp, bibliothek_ausleihhistorie ba
WHERE bp.ausweisnr = ba.p_ausweisnr 
AND ba.inventarnr IN ( SELECT bo.inventarnr
    					FROM bibliothek_objekt bo
    					WHERE bo.inventarnr IN(SELECT boha.Inventarnr
                                   FROM bibliothek_objekt_hat_autor boha
                                   WHERE boha.id IN (SELECT bau.id
                                                     FROM bibliothek_autor bau
                                                     WHERE bau.vorname = 'Matthias'
                                                     AND bau.nachname = 'Schubert'
                                                    )
                                  )  
          );
*/