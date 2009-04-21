package Bibliothek;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

//VS4E -- DO NOT REMOVE THIS LINE!
public class AddItem extends JDialog {

	private Bibliothek mParent;
	private DefaultTableModel tableModel;
	private Statement stmt;
	private ResultSet rset;
	
	private static final long serialVersionUID = 1L;
	private JButton jAddbtn;
	private JTextField jTitel;
	private JTextField jVerlag;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JTextPane jAuthoren;
	private JScrollPane jScrollPane0;
	private JComboBox jTyp;
	private JButton jCancelBtn;
	private JFormattedTextField jErscheinung;
	private JTextField jInventar;
	public AddItem() {
		initComponents();
	}

	public AddItem(Bibliothek parent, DefaultTableModel _tableModel) {
		super(parent);
		mParent = parent;
		tableModel = _tableModel;
		initComponents();
	}

	private void initComponents() {
		setTitle("Add Bibo Objekt");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Graphics/Blue Book Icon-128x128.png")));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(240, 240, 240));
		setModal(true);
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJLabel5(), new Constraints(new Leading(18, 10, 10), new Leading(199, 12, 12)));
		add(getJLabel2(), new Constraints(new Leading(15, 30, 10, 10), new Leading(130, 12, 12)));
		add(getJLabel4(), new Constraints(new Leading(16, 12, 12), new Leading(166, 17, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(16, 277, 336), new Leading(94, 12, 12)));
		add(getJLabel0(), new Constraints(new Leading(16, 277, 336), new Leading(60, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(16, 277, 336), new Leading(26, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(125, 297, 10, 10), new Leading(199, 77, 10, 10)));
		add(getJTitel(), new Constraints(new Leading(125, 301, 10, 10), new Leading(59, 10, 10)));
		add(getJVerlag(), new Constraints(new Leading(125, 297, 12, 12), new Leading(93, 10, 10)));
		add(getJTyp(), new Constraints(new Leading(126, 137, 10, 10), new Leading(128, 12, 12)));
		add(getJCancelBtn(), new Constraints(new Leading(330, 92, 12, 12), new Trailing(12, 233, 288)));
		add(getJAddbtn(), new Constraints(new Leading(230, 94, 12, 12), new Trailing(12, 233, 288)));
		add(getJErscheinung(), new Constraints(new Leading(125, 138, 12, 12), new Leading(165, 50, 50)));
		add(getJInventar(), new Constraints(new Leading(125, 138, 12, 12), new Leading(24, 12, 12)));
		setSize(443, 339);
	}

	private JTextField getJInventar() {
		if (jInventar == null) {
			jInventar = new JTextField();
		}
		return jInventar;
	}

	private JFormattedTextField getJErscheinung() {
		if (jErscheinung == null) {
			try {
				jErscheinung = new JFormattedTextField(new MaskFormatter("####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jErscheinung;
	}

	private JButton getJCancelBtn() {
		if (jCancelBtn == null) {
			jCancelBtn = new JButton();
			jCancelBtn.setText("Cancel");
			jCancelBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					jCancelBtnClicked(event);
				}
			});
		}
		return jCancelBtn;
	}

	private JComboBox getJTyp() {
		if (jTyp == null) {
			jTyp = new JComboBox();
			jTyp.setModel(new DefaultComboBoxModel(new Object[] { "Buch", "Zeitschrift", "H�rbuch" }));
			jTyp.setDoubleBuffered(false);
			jTyp.setBorder(null);
		}
		return jTyp;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJAuthoren());
		}
		return jScrollPane0;
	}

	private JTextPane getJAuthoren() {
		if (jAuthoren == null) {
			jAuthoren = new JTextPane();
		}
		return jAuthoren;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Erscheinungsjahr");
		}
		return jLabel4;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Authoren");
		}
		return jLabel5;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Inventar Nr.");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Typ");
		}
		return jLabel2;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Verlag");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Titel");
		}
		return jLabel0;
	}

	private JTextField getJVerlag() {
		if (jVerlag == null) {
			jVerlag = new JTextField();
		}
		return jVerlag;
	}

	private JTextField getJTitel() {
		if (jTitel == null) {
			jTitel = new JTextField();
		}
		return jTitel;
	}

	private JButton getJAddbtn() {
		if (jAddbtn == null) {
			jAddbtn = new JButton();
			jAddbtn.setText("Add");
			jAddbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					try {
						jAddbtnClicked(event);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(getParent(),
							    e.getMessage(),
							    "Objekt konnte nicht eingef�gt werden!",
							    JOptionPane.ERROR_MESSAGE);
						
						e.printStackTrace();
					}
				}
			});
		}
		return jAddbtn;
	}

	

	private void jCancelBtnClicked(MouseEvent event) {
		dispose();
	}

	private void jAddbtnClicked(MouseEvent event) throws SQLException {
		
		stmt = mParent.getStatement();
		
		String Inventar = new String(jInventar.getText());
		String Titel    = new String(jTitel.getText());
		String Verlag   = new String(jVerlag.getText());
		String Typ      = new String(jTyp.getModel().getSelectedItem().toString());
		String Erscheinung = new String(jErscheinung.getText());
		String Authoren = new String(jAuthoren.getText());
		
		String error_message = "";
		if (!Inventar.matches("[1-9]+"))      error_message = "Bitte geben Sie InventarNr noch mal ein!";
		else if  (Titel.equals(""))			  error_message = "Bitte geben Sie den Titel ein!";
		else if (Verlag.equals("")) 		  error_message = "Bitte geben Sie die Verlag ein!";
		else if (!Authoren.matches("[ ]*[a-zA-Z]+[ ]+[a-zA-Z]+([ ]*[,][ ]*[a-zA-Z]+[ ]+[a-zA-Z]+)*")) 
											  error_message = "Bitte geben Sie g�ltige Authorennamen ein!";			
		if (error_message != "") {
			JOptionPane.showMessageDialog(
					getParent(),
					error_message,
					"Error",
					JOptionPane.ERROR_MESSAGE);
					return;
		}
		
		Authoren = Authoren.replaceAll(" *, *", ",");		
		String[] AuthorenTable = Authoren.split(",");
		
		//System.out.println("AuthorenTable:");
		//System.out.println(AuthorenTable[0]);
		//System.out.println(AuthorenTable[1]);
		
		String query = ("INSERT INTO bibliothek_objekt VALUES (") +
						Inventar + ", " + 
						"'" + Titel + "', " + 
						"'" + Verlag + "', " +
						"'" + Typ + "', " +
						"TO_DATE('" + Erscheinung + "', 'YYYY'), " +
						"null" + ", " + "null)";
				
		stmt.executeQuery(query);
		
		rset = stmt.executeQuery("SELECT nachname, vorname FROM bibliothek_autor");
		int anzahl_autoren = 0;
		boolean autor_found = false;
		while ((rset.next()) && (false == autor_found)) {
			anzahl_autoren++;
			for(int i = 0; i < AuthorenTable.length; i++) {
				// author[1] = Vorname des Authors
				// author[0] = Nachname des Authors
				String[] autor =  AuthorenTable[i].split(" ");				
				if (autor.length != 2) {
					JOptionPane.showMessageDialog(
							getParent(),
							"Bitte geben Sie die Autorennamen richtig ein!",
							"Error",
							JOptionPane.ERROR_MESSAGE);
							return;
				}
				
				autor[0] = autor[0].replaceAll(" ", "");
				autor[1] = autor[1].replaceAll(" ", "");
				
				System.out.println("vorname: " + autor[0]);
				System.out.println("nachname: " + autor[1]);
				
				if ((rset.getString(1).equals(autor[1])) && (rset.getString(2).equals(autor[0]))) {
					query = "INSERT INTO bibliothek_objekt_hat_autor VALUES (" + 
									anzahl_autoren + ", " + Inventar + ")";
					stmt.executeQuery(query);
					System.out.println("autor gefunden");
					autor_found = true;
					break;
				}
			}
		}
		if (false == autor_found) {
			System.out.println("Autor nicht gefunden");
			System.out.println("Der Autor ");
			
			
			for(int i = 0; i < AuthorenTable.length; i++) {
				String[] autor =  AuthorenTable[i].split(" ");
				// insert into bib_objekt_hat_autor
				query = "INSERT INTO Bibliothek_Autor VALUES (" + 
						(anzahl_autoren+1) + ", '" + autor[1] + "', '" + autor[0] + "')";
				stmt.executeQuery(query);
				
			}
			query = "INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (" + 
					(anzahl_autoren+1) + ", " + Inventar + ")";
			stmt.executeQuery(query);
		}
		
		
		String[] row = new String[8];
		row[0] = Inventar;
		row[1] = Titel; 
		row[2] = Verlag;
		row[3] = Authoren;
		row[4] = Typ;
		row[5] = Erscheinung;
		
		tableModel.addRow(row);
		
		dispose();
	}

}
