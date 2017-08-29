package namiDonorDB;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import namiDonorDB.Constituent;
import namiDonorDB.ConstituentDAO;
import namiDonorDB.ConstituentTableModel;
import javax.swing.ScrollPaneConstants;

public class searchApp extends JFrame {

	private JPanel contentPane;
	private JTextField lastName_tf;
	private JTable table;
	
	private ConstituentDAO constituentDAO;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchApp frame = new searchApp();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					//frame.setUndecorated(true);
					//frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public searchApp() {
		try {
			constituentDAO = new ConstituentDAO();
			//List<Constituent> constituents = constituentDOA.getAllConstituents();

		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
		}


		
		setTitle("Nami Donation List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterLastName = new JLabel("Enter Last Name: ");
		panel.add(lblEnterLastName);
		
		lastName_tf = new JTextField();
		panel.add(lastName_tf);
		lastName_tf.setColumns(10);
		
		
		
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get Last name from the text field
				
				//Call DAO and get constituents for the last name
				
				//If last name is empty, then get all constituents
				
				//Print out constituents
				try{
					String LastName = lastName_tf.getText();
					List<Constituent> constituents = null;
					if(LastName != null && LastName.trim().length() > 0){
						constituents = constituentDAO.searchConstituents(LastName);
						//System.out.println("Last Name = "+LastName);
					} else {
						constituents = constituentDAO.getAllConstituents();
					}
					
					//Create the model and update the table
					ConstituentTableModel model = new ConstituentTableModel(constituents);
					table.setModel(model);
				} catch(Exception exc){
					JOptionPane.showMessageDialog(searchApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		//table.getColumnModel().getColumn(1).setPreferredWidth(10000);
		
	    
		
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addConstituent dialog = new addConstituent();
				dialog.setVisible(true);
				refreshConstituentView();
				
			}
		});
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get the selected item
				int row = table.getSelectedRow();
				//make sure a row is selected
				if(row < 0){
					JOptionPane.showMessageDialog(searchApp.this, "you must select an employee", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//get the current const
				Constituent tempConstituent = (Constituent) table.getValueAt(row, ConstituentTableModel.OBJECT_COL);
				
				//create dialog
				updateConstituent dialog = new updateConstituent(searchApp.this, constituentDAO, tempConstituent, true);
				dialog.setVisible(true);
				refreshConstituentView();
				//JOptionPane.showMessageDialog(searchApp.this, "Constituent Updated Successfully", "Constituent Updated", JOptionPane.INFORMATION_MESSAGE);


			}
		});
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//get the selected row
					int row = table.getSelectedRow();
					
					//make sure a row is selected
					if(row < 0){
						JOptionPane.showMessageDialog(searchApp.this, "You must select a Constituent", 
								"Error", JOptionPane.ERROR_MESSAGE);;
						return;
					}
					//prompt the user
					int response = JOptionPane.showConfirmDialog(searchApp.this, "Delete this constituent?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if( response != JOptionPane.YES_OPTION) { 
						return; 
					} 
					//get the current employee
					Constituent tempConstituent = (Constituent) table.getValueAt(row, ConstituentTableModel.OBJECT_COL);
					constituentDAO.deleteConstituent(tempConstituent.getID());
					refreshConstituentView(); //refresh table
					JOptionPane.showMessageDialog(searchApp.this, "Constituent Deleted Successfully", "Constituent Deleted", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exc){
					JOptionPane.showMessageDialog(searchApp.this, "Error Deleting Constituent" + exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);;
				}
			}
		});
		panel_1.add(btnDelete);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsForm.main(null);			
			}
		});
		panel_1.add(btnSettings);
	}
	
	
	public void refreshConstituentView() {

		try {
			List<Constituent> constituents = constituentDAO.getAllConstituents();

			// create the model and update the "table"
			ConstituentTableModel model = new ConstituentTableModel(constituents);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(searchApp.this, "Error: ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}
	
	
	class ColumnSorter implements Comparator {
		  ColumnSorter() {
		  }

		  public int compare(Object a, Object b) {
		    if (a instanceof String && ((String) a).length() == 0) {
		      a = null;
		    }
		    if (b instanceof String && ((String) b).length() == 0) {
		      b = null;
		    }
		    if (a == null && b == null) {
		      return 0;
		    } else if (a == null) {
		      return 1;
		    } else if (b == null) {
		      return -1;
		    } else if (a instanceof Comparable) {
		      return ((Comparable) a).compareTo(b);
		    } else {
		      return a.toString().compareTo(b.toString());
		    }
		  }
	}

}
