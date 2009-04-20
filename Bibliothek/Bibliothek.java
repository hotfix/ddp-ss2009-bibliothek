package Bibliothek;

//import BibliothekControll;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

//VS4E -- DO NOT REMOVE THIS LINE!
public class Bibliothek extends JFrame {

	private Connection conn;
	private Statement  stmt;
	private ResultSet  rset;
	
	private static final long serialVersionUID = 1L;
	private JLabel jPortLabel;
	private JTextField jPort;
	private JLabel jDBTypeLabel;
	private JTextField jHost;
	private JLabel jUserLabel;
	private JTextField jDBType;
	private JTextField jUser;
	private JLabel jLabel5;
	private JTextField jDBName;
	private JLabel jPasswordLabel;
	private JButton jDisconnectButton;
	private JButton jConnectButton;
	private JSeparator jSeparator0;
	private JLabel jStatus;
	private JTable jBiboTable;
	private JScrollPane jScrollPane0;
	private JLabel jTableLabel;
	private JLabel jStatusLabel;
	private JButton jAdd;
	private JButton jExit;
	private JButton jDelete;
	private JLabel jAuthorLabel;
	private JTextField jAuthorTextField;
	private JButton jAuslierByAuthorAnzeigen;
	private JButton jDBAuslierAnzeigen;
	private JPasswordField jPassword;
	private JPanel jPanel0;
	private JLabel jLabel0;
	private JTextField jNachnameTextField;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public Bibliothek() {
		initComponents();
	}

	public Statement getStatement() {		
		return stmt;
	}
	
	public DefaultTableModel getTableModel() {
		return (DefaultTableModel)(jBiboTable.getModel());
	}
	
	private void initComponents() {
		setTitle("Bibliothek");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Graphics/Blue Book Icon-128x128.png")));
		setLayout(new GroupLayout());
		add(getJPort(), new Constraints(new Leading(530, 10, 10), new Leading(31, 12, 12)));
		add(getJDBTypeLabel(), new Constraints(new Leading(12, 12, 12), new Leading(63, 12, 12)));
		add(getJHost(), new Constraints(new Leading(68, 423, 12, 12), new Leading(31, 12, 12)));
		add(getJPortLabel(), new Constraints(new Leading(499, 10, 10), new Leading(33, 12, 12)));
		add(getJUserLabel(), new Constraints(new Leading(12, 12, 12), new Leading(89, 12, 12)));
		add(getJDBType(), new Constraints(new Leading(68, 124, 12, 12), new Leading(61, 12, 12)));
		add(getJUser(), new Constraints(new Leading(68, 124, 12, 12), new Leading(89, 12, 12)));
		add(getJLabel5(), new Constraints(new Leading(210, 12, 12), new Leading(63, 12, 12)));
		add(getJPasswordLabel(), new Constraints(new Leading(210, 12, 12), new Leading(91, 12, 12)));
		add(getJStatus(), new Constraints(new Leading(68, 12, 12), new Leading(6, 12, 12)));
		add(getJTableLabel(), new Constraints(new Leading(12, 84, 10, 10), new Leading(127, 12, 12)));
		add(getJStatusLabel(), new Constraints(new Leading(12, 12, 12), new Leading(6, 12, 12)));
		add(getJDBName(), new Constraints(new Leading(278, 110, 10, 10), new Leading(61, 12, 12)));
		add(getJPassword(), new Constraints(new Leading(278, 110, 10, 10), new Leading(89, 11, 11)));
		add(getJDBAuslierAnzeigen(), new Constraints(new Trailing(9, 149, 43, 680), new Leading(252, 52, 10, 10)));
		add(getJAdd(), new Constraints(new Trailing(10, 84, 43, 680), new Leading(142, 11, 11)));
		add(getJDelete(), new Constraints(new Trailing(10, 84, 43, 680), new Leading(168, 10, 10)));
		add(getJExit(), new Constraints(new Trailing(10, 86, 43, 680), new Leading(469, 11, 11)));
		add(getJScrollPane0(), new Constraints(new Bilateral(10, 167, 23), new Leading(142, 350, 11, 11)));
		add(getJDisconnectButton(), new Constraints(new Trailing(10, 294, 398), new Leading(83, 11, 11)));
		add(getJConnectButton(), new Constraints(new Trailing(10, 84, 294, 398), new Leading(51, 11, 11)));
		add(getJSeparator0(), new Constraints(new Bilateral(12, 10, 891), new Leading(119, 12, 12, 12)));
		add(getJPanel0(), new Constraints(new Trailing(10, 43, 680), new Leading(324, 127, 10, 10)));
		setSize(934, 508);
	}

	private JTextField getJNachnameTextField() {
		if (jNachnameTextField == null) {
			jNachnameTextField = new JTextField();
		}
		return jNachnameTextField;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Author Nachname:");
		}
		return jLabel0;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(new LineBorder(Color.black, 1, false));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJAuthorLabel(), new Constraints(new Leading(7, 10, 10), new Leading(8, 10, 10)));
			jPanel0.add(getJAuthorTextField(), new Constraints(new Leading(3, 132, 10, 10), new Leading(24, 10, 10)));
			jPanel0.add(getJAuslierByAuthorAnzeigen(), new Constraints(new Leading(3, 132, 10, 10), new Leading(97, 10, 10)));
			jPanel0.add(getJLabel0(), new Constraints(new Leading(7, 10, 10), new Leading(52, 10, 10)));
			jPanel0.add(getJNachnameTextField(), new Constraints(new Leading(3, 132, 10, 10), new Leading(71, 11, 11)));
		}
		return jPanel0;
	}

	private JPasswordField getJPassword() {
		if (jPassword == null) {
			jPassword = new JPasswordField();
			jPassword.setText("$r198305");
		}
		return jPassword;
	}

	private JButton getJDBAuslierAnzeigen() {
		if (jDBAuslierAnzeigen == null) {
			jDBAuslierAnzeigen = new JButton();
			jDBAuslierAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 11));
			jDBAuslierAnzeigen.setText("DB Ausleiher anzeigen");
			jDBAuslierAnzeigen.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					jDBAuslierAnzeigenMouseMouseClicked(event);
				}
			});
		}
		return jDBAuslierAnzeigen;
	}

	private JButton getJAuslierByAuthorAnzeigen() {
		if (jAuslierByAuthorAnzeigen == null) {
			jAuslierByAuthorAnzeigen = new JButton();
			jAuslierByAuthorAnzeigen.setText("Auslier anzeigen");
			jAuslierByAuthorAnzeigen.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					jAuslierByAuthorAnzeigenMouseMouseClicked(event);
				}
			});
		}
		return jAuslierByAuthorAnzeigen;
	}

	private JTextField getJAuthorTextField() {
		if (jAuthorTextField == null) {
			jAuthorTextField = new JTextField();
		}
		return jAuthorTextField;
	}

	private JLabel getJAuthorLabel() {
		if (jAuthorLabel == null) {
			jAuthorLabel = new JLabel();
			jAuthorLabel.setText("Author Vorname:");
		}
		return jAuthorLabel;
	}

	private JButton getJDelete() {
		if (jDelete == null) {
			jDelete = new JButton();
			jDelete.setText("Delete");
			jDelete.setEnabled(false);
		}
		return jDelete;
	}

	private JButton getJExit() {
		if (jExit == null) {
			jExit = new JButton();
			jExit.setText("Exit");
			jExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					try {
						jExitClicked(event);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(getParent(),
							    e.getMessage(),
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
						
						e.printStackTrace();
					}
				}
			});
		}
		return jExit;
	}

	private JButton getJAdd() {
		if (jAdd == null) {
			jAdd = new JButton();
			jAdd.setText("Add");
			jAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					jAddClicked(event);
				}
			});
		}
		return jAdd;
	}

	private JLabel getJStatusLabel() {
		if (jStatusLabel == null) {
			jStatusLabel = new JLabel();
			jStatusLabel.setText("Status");
		}
		return jStatusLabel;
	}

	private JLabel getJTableLabel() {
		if (jTableLabel == null) {
			jTableLabel = new JLabel();
			jTableLabel.setText("Bibo Objekte");
		}
		return jTableLabel;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJBiboTable());
		}
		return jScrollPane0;
	}

	private JTable getJBiboTable() {
		if (jBiboTable == null) {
			jBiboTable = new JTable();
			jBiboTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "InventarNr", "Titel", "Verlag", "Author", "Typ", "Erscheinungsjahr",
					"Ausleier", "Einrichtung", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { String.class, String.class, String.class, String.class, String.class, Object.class, String.class, String.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jBiboTable.setEnabled(false);
		}
		return jBiboTable;
	}

	private JLabel getJStatus() {
		if (jStatus == null) {
			jStatus = new JLabel();
			jStatus.setForeground(Color.red);
			jStatus.setText("Disconected");
		}
		return jStatus;
	}

	private JSeparator getJSeparator0() {
		if (jSeparator0 == null) {
			jSeparator0 = new JSeparator();
		}
		return jSeparator0;
	}

	private JButton getJConnectButton() {
		if (jConnectButton == null) {
			jConnectButton = new JButton();
			jConnectButton.setText("Connect");
			jConnectButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					try {
						jConnectClicked(event);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(getParent(),
							    e.getMessage(),
							    "Verbindung konnte nicht aufgebaut werden!",
							    JOptionPane.ERROR_MESSAGE);
						
						e.printStackTrace();
					}
				}
			});
		}
		return jConnectButton;
	}

	private JButton getJDisconnectButton() {
		if (jDisconnectButton == null) {
			jDisconnectButton = new JButton();
			jDisconnectButton.setText("Disconnect");
			jDisconnectButton.setEnabled(false);
			jDisconnectButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					try {
						jDisconnectClicked(event);
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(getParent(),
							    e.getMessage(),
							    "Error beim Trennen der Verbindung aufgetreten!",
							    JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}					
				}
			});
		}
		return jDisconnectButton;
	}

	private JLabel getJPasswordLabel() {
		if (jPasswordLabel == null) {
			jPasswordLabel = new JLabel();
			jPasswordLabel.setText("Password");
		}
		return jPasswordLabel;
	}

	private JTextField getJDBName() {
		if (jDBName == null) {
			jDBName = new JTextField();
			jDBName.setText("swt05");
		}
		return jDBName;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("DB Name");
		}
		return jLabel5;
	}

	private JTextField getJUser() {
		if (jUser == null) {
			jUser = new JTextField();
			jUser.setText("s1926305");
		}
		return jUser;
	}

	private JTextField getJDBType() {
		if (jDBType == null) {
			jDBType = new JTextField();
			jDBType.setText("JDBC");
		}
		return jDBType;
	}

	private JLabel getJUserLabel() {
		if (jUserLabel == null) {
			jUserLabel = new JLabel();
			jUserLabel.setText("User");
		}
		return jUserLabel;
	}

	private JTextField getJHost() {
		if (jHost == null) {
			jHost = new JTextField();
			jHost.setText("ora2.informatik.haw-hamburg.de");
		}
		return jHost;
	}

	private JLabel getJDBTypeLabel() {
		if (jDBTypeLabel == null) {
			jDBTypeLabel = new JLabel();
			jDBTypeLabel.setText("DB Type");
		}
		return jDBTypeLabel;
	}

	private JTextField getJPort() {
		if (jPort == null) {
			jPort = new JTextField();
			jPort.setText("1521");
		}
		return jPort;
	}

	private JLabel getJPortLabel() {
		if (jPortLabel == null) {
			jPortLabel = new JLabel();
			jPortLabel.setText("Host");
		}
		return jPortLabel;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Bibliothek frame = new Bibliothek();
				frame.setDefaultCloseOperation(Bibliothek.EXIT_ON_CLOSE);
				frame.setTitle("Bibliothek");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private String getConnectionURL() {
		return jDBType.getText()+":oracle:thin:@"+jHost.getText()+
			   ':'+jPort.getText()+':'+jDBName.getText();
	}
	
	private void disconnect() throws SQLException {
		stmt.close();
		conn.close();
	}
	
	private void jExitClicked(MouseEvent event) throws SQLException {
		if (conn!=null) {
			disconnect();
		}
		dispose();
	}

	private void loadBiboTable() throws Exception{
		
		DefaultTableModel m = getTableModel();
		//m.setRowCount(0);
		
			
		String query="SELECT bo.inventarnr, bo.titel, bo.verlag, ba.vorname, ba.nachname, bo.typ, bo.erscheinungsjahr, bo.P_Ausweisnr, bo.e_Ausweisnr "+
		 			 "FROM bibliothek_objekt bo, bibliothek_autor ba, bibliothek_objekt_hat_autor boh "+
		 			 "WHERE bo.inventarnr = boh.inventarnr AND ba.id = boh.id"; 
		  
		rset = stmt.executeQuery(query);
		
		
		String[] row = new String[8];
		
		while(rset.next()){
		
			row[0]=rset.getString(1);//Inverntarnum
			row[1]=rset.getString(2);// Titel
			row[2]=rset.getString(3);// Verlag
			row[3]=rset.getString(4) + " " + rset.getString(5); // Author
			row[4]=rset.getString(6); // Typ
			row[5]=rset.getString(7).replaceAll("-.*$",""); // Erscheinungsjahr
			row[6]=rset.getString(8);
			row[7]=rset.getString(9);
			
			/*
			if (rset.getString(8)!=null){
				int Ausweis = Integer.parseInt(rset.getString(8));
				String queryForName="SELECT P_Name "+
									"from Bibliothek_Personen " +
									"where Ausweisnr = "+Ausweis;
				//Statement  stmt2 = conn.createStatement();
				ResultSet rsetP_Name = stmt.executeQuery(queryForName);
				rsetP_Name.next();
				row[6]=rsetP_Name.getString(1);
			}
			*/
			

			/*
			queryForName="select e_name "+
	 			"from bibliothek_einrichtungen " +
	 			"where Ausweisnr = "+Integer.parseInt(rset.getString(9));
			rsetP_Name.next();
			rsetP_Name = stmt.executeQuery(queryForName);
			row[7]=rsetP_Name.getString(1);
			*/
			
			m.addRow(row);
		}
		
	}
	
	private void jConnectClicked(MouseEvent event) throws Exception {
		// load the db driver
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		// connect to the specified database
		conn = DriverManager.getConnection( getConnectionURL(),	
				          jUser.getText(), new String(jPassword.getPassword()));
		
		// create a select statement
		stmt = conn.createStatement();
		
		jStatus.setText("Connected");
		jStatus.setForeground(Color.GREEN);
		
		jConnectButton.setEnabled(false);
		jDisconnectButton.setEnabled(true);
		
		loadBiboTable();
	}

	private void jDisconnectClicked(MouseEvent event) throws Exception {

		disconnect();
		
		jStatus.setText("Disconnected");
		jStatus.setForeground(Color.RED);
		
		jConnectButton.setEnabled(true);
		jDisconnectButton.setEnabled(false);
		
		DefaultTableModel m = getTableModel();
		m.setRowCount(0);
	}

	private void jAddClicked(MouseEvent event) {
		
		if (conn!=null) {
			
			AddItem dialog = new AddItem(this);
			dialog.pack();
			//dialog.setTitle("Add Bibo Objekt");
			dialog.setVisible(true);			
		}
	}

	private void jDBAuslierAnzeigenMouseMouseClicked(MouseEvent event) {
		
		if (conn!=null) {	
			DBAusleiher dialog = new DBAusleiher(this);
			dialog.pack();
			//dialog.setTitle("Add Bibo Objekt");
			dialog.setVisible(true);			
		}
	}

	private void jAuslierByAuthorAnzeigenMouseMouseClicked(MouseEvent event) {
		String vorname = jAuthorTextField.getText();
		String nachname = jNachnameTextField.getText();
		if (conn!=null) {	
			DBAusleiher dialog = new DBAusleiher(this, vorname, nachname);
			dialog.pack();
			//dialog.setTitle("Add Bibo Objekt");
			dialog.setVisible(true);			
		}
	}

}
