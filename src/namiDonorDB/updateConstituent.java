package namiDonorDB;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class updateConstituent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ID_tf;
	private JTextField EntryDate_tf;
	private JTextField DonorType_tf;
	private JTextField Title_tf;
	private JTextField FirstName_tf;
	private JTextField LastName_tf;
	private JTextField Suffix_tf;
	private JTextField HomePhone_tf;
	private JTextField CellPhone_tf;
	private JTextField email_tf;
	private JTextField org_tf;
	private JTextField bphone_tf;
	private JTextField NoMailFlag_tf;
	private JTextField RegionCode_tf;
	private JTextField lastContactDate_tf;
	private JTextField totalGifts_tf;
	private JTextField GiftsThisYear_tf;
	private JTextField Gifts1Year_tf;
	private JTextField Gifts2Year_tf;
	private JTextField Gifts3Year_tf;
	private JTextField firstGiftDate_tf;
	private JTextField firstGiftAmt_tf;
	private JTextField lastGiftDate_tf;
	private JTextField lastGiftAmt_tf;
	private JTextField bemail_tf;
	private JTextField position_tf;
	
	private ConstituentDAO constituentDAO;
	private searchApp mySearchApp;
	private Constituent previousConstituent = null;
	private boolean updateMode = false;
	
	public updateConstituent(searchApp theSearchApp,
			ConstituentDAO theConstituentDAO, Constituent thePreviousConstituent, boolean theUpdateMode) {
			this();
			constituentDAO = theConstituentDAO;
			mySearchApp = theSearchApp;

			previousConstituent = thePreviousConstituent;
		
			updateMode = theUpdateMode;

		if (updateMode) {
			setTitle("Update Constituent");
			
			populateGui(previousConstituent);
		}
	}
	
	private void populateGui(Constituent theConstituent) {

		int int_id = theConstituent.getID();
		String string_id = Integer.toString(int_id);
		ID_tf.setText(string_id);
		EntryDate_tf.setText(theConstituent.getEntryDate());
		DonorType_tf.setText(theConstituent.getDonorType());
		Title_tf.setText(theConstituent.getTitle());
		FirstName_tf.setText(theConstituent.getFirstName());
		LastName_tf.setText(theConstituent.getLastName());
		Suffix_tf.setText(theConstituent.getSuffix());
		position_tf.setText(theConstituent.getPosition());
		//employeer_tf.setText(theConstituent.getEmployer());
		HomePhone_tf.setText(theConstituent.getHomePhone());
		CellPhone_tf.setText(theConstituent.getCellPhone());
		email_tf.setText(theConstituent.getEmail());
		org_tf.setText(theConstituent.getOrganizationName());
		bphone_tf.setText(theConstituent.getBusinessPhone());
		bemail_tf.setText(theConstituent.getBusinessEmail());
		NoMailFlag_tf.setText(theConstituent.getNomailFlag());
		RegionCode_tf.setText(theConstituent.getregionCode());
		lastContactDate_tf.setText(theConstituent.getLastContactDate());
		int int_totalGifts = theConstituent.getTotalGifts();
		String string_totalGifts = Integer.toString(int_totalGifts);		
		totalGifts_tf.setText(string_totalGifts);
		int int_GiftsThisYear = theConstituent.getGiftsThisYear();
		String String_GiftsThisYear = Integer.toString(int_GiftsThisYear);	
        GiftsThisYear_tf.setText(String_GiftsThisYear);
		int int_Gifts1Year = theConstituent.getGifts1Year();
		String String_Gifts1Year = Integer.toString(int_Gifts1Year);	
        GiftsThisYear_tf.setText(String_Gifts1Year);
		int int_Gifts2Year = theConstituent.getGifts2Years();
		String String_Gifts3Year = Integer.toString(int_Gifts2Year);	
        GiftsThisYear_tf.setText(String_Gifts3Year);
		int int_Gifts3Year = theConstituent.getGifts3Years();
		String string_gifts3Year = Integer.toString(int_Gifts3Year);	
        GiftsThisYear_tf.setText(string_gifts3Year);
        firstGiftDate_tf.setText(theConstituent.getFirstGiftDate());
		int int_firstGiftAmt = theConstituent.getFirstGiftAmt();
		String String_firstGiftAmt = Integer.toString(int_firstGiftAmt);	
        GiftsThisYear_tf.setText(String_firstGiftAmt);
        lastGiftDate_tf.setText(theConstituent.getLastGiftDate());
		int int_lastGiftAmt = theConstituent.getLastGiftAmt();
		String String_lastGiftAmt = Integer.toString(int_lastGiftAmt);	
        GiftsThisYear_tf.setText(String_lastGiftAmt);
		
	}
	
	public updateConstituent(searchApp theSearchApp,
			ConstituentDAO theConstituentDAO) {
		this(theSearchApp, theConstituentDAO, null, false);
	}

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			updateConstituent dialog = new updateConstituent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	//}

	/**
	 * Create the dialog.
	 */
	public updateConstituent() {
		setTitle("Add Constituent ");
		setBounds(100, 100, 830, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(6, 6, 18, 16);
		contentPanel.add(lblId);
		
		ID_tf = new JTextField();
		ID_tf.setBounds(28, 1, 91, 26);
		contentPanel.add(ID_tf);
		ID_tf.setColumns(10);
		
		JLabel lblEntryDate = new JLabel("Entry Date:");
		lblEntryDate.setBounds(131, 6, 69, 16);
		contentPanel.add(lblEntryDate);
		
		EntryDate_tf = new JTextField();
		EntryDate_tf.setBounds(203, 1, 130, 26);
		contentPanel.add(EntryDate_tf);
		EntryDate_tf.setColumns(10);
		
		JLabel lblDonorType = new JLabel("Donor Type:");
		lblDonorType.setBounds(345, 6, 77, 16);
		contentPanel.add(lblDonorType);
		
		DonorType_tf = new JTextField();
		DonorType_tf.setBounds(425, 1, 40, 26);
		contentPanel.add(DonorType_tf);
		DonorType_tf.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title: ");
		lblTitle.setBounds(6, 34, 85, 16);
		contentPanel.add(lblTitle);
		
		Title_tf = new JTextField();
		Title_tf.setBounds(92, 29, 130, 26);
		contentPanel.add(Title_tf);
		Title_tf.setColumns(10);
		
		FirstName_tf = new JTextField();
		FirstName_tf.setBounds(92, 60, 130, 26);
		contentPanel.add(FirstName_tf);
		FirstName_tf.setColumns(10);
		
		LastName_tf = new JTextField();
		LastName_tf.setBounds(92, 90, 130, 26);
		contentPanel.add(LastName_tf);
		LastName_tf.setColumns(10);
		
		Suffix_tf = new JTextField();
		Suffix_tf.setBounds(92, 120, 130, 26);
		contentPanel.add(Suffix_tf);
		Suffix_tf.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(6, 65, 85, 16);
		contentPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(6, 95, 77, 16);
		contentPanel.add(lblLastName);
		
		HomePhone_tf = new JTextField();
		HomePhone_tf.setBounds(92, 150, 130, 26);
		contentPanel.add(HomePhone_tf);
		HomePhone_tf.setColumns(10);
		
		JLabel lblSuffix = new JLabel("Suffix: ");
		lblSuffix.setBounds(6, 125, 61, 16);
		contentPanel.add(lblSuffix);
		
		CellPhone_tf = new JTextField();
		CellPhone_tf.setBounds(92, 180, 130, 26);
		contentPanel.add(CellPhone_tf);
		CellPhone_tf.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone:");
		lblHomePhone.setBounds(6, 155, 85, 16);
		contentPanel.add(lblHomePhone);
		
		email_tf = new JTextField();
		email_tf.setBounds(92, 210, 130, 26);
		contentPanel.add(email_tf);
		email_tf.setColumns(10);
		
		JLabel lblCellPhone = new JLabel("Cell Phone: ");
		lblCellPhone.setBounds(6, 185, 85, 16);
		contentPanel.add(lblCellPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(6, 215, 61, 16);
		contentPanel.add(lblEmail);
		
		JLabel lblBus = new JLabel("Organization Name:");
		lblBus.setBounds(234, 34, 130, 16);
		contentPanel.add(lblBus);
		
		org_tf = new JTextField();
		org_tf.setBounds(365, 29, 130, 26);
		contentPanel.add(org_tf);
		org_tf.setColumns(10);
		
		bphone_tf = new JTextField();
		bphone_tf.setBounds(365, 90, 130, 26);
		contentPanel.add(bphone_tf);
		bphone_tf.setColumns(10);
		
		JLabel lblBu = new JLabel("Business Phone:");
		lblBu.setBounds(234, 95, 122, 16);
		contentPanel.add(lblBu);
		
		JLabel lblNoMailFlag = new JLabel("No Mail Flag: ");
		lblNoMailFlag.setBounds(234, 155, 99, 16);
		contentPanel.add(lblNoMailFlag);
		
		NoMailFlag_tf = new JTextField();
		NoMailFlag_tf.setBounds(323, 150, 99, 26);
		contentPanel.add(NoMailFlag_tf);
		NoMailFlag_tf.setColumns(10);
		
		JLabel lblRegionCode = new JLabel("Region Code: ");
		lblRegionCode.setBounds(234, 185, 99, 16);
		contentPanel.add(lblRegionCode);
		
		RegionCode_tf = new JTextField();
		RegionCode_tf.setBounds(323, 180, 99, 26);
		contentPanel.add(RegionCode_tf);
		RegionCode_tf.setColumns(10);
		
		JLabel lblLastContactDate = new JLabel("Last Contact Date:");
		lblLastContactDate.setBounds(234, 215, 130, 16);
		contentPanel.add(lblLastContactDate);
		
		lastContactDate_tf = new JTextField();
		lastContactDate_tf.setBounds(354, 210, 130, 26);
		contentPanel.add(lastContactDate_tf);
		lastContactDate_tf.setColumns(10);
		
		JLabel lblTotalGifts = new JLabel("Total Gifts:");
		lblTotalGifts.setBounds(234, 243, 122, 16);
		contentPanel.add(lblTotalGifts);
		
		totalGifts_tf = new JTextField();
		totalGifts_tf.setBounds(354, 238, 130, 26);
		contentPanel.add(totalGifts_tf);
		totalGifts_tf.setColumns(10);
		
		JLabel lblTotalGiftsThis = new JLabel("Total Gifts This Year: ");
		lblTotalGiftsThis.setBounds(507, 6, 153, 16);
		contentPanel.add(lblTotalGiftsThis);
		
		GiftsThisYear_tf = new JTextField();
		GiftsThisYear_tf.setBounds(654, 1, 130, 26);
		contentPanel.add(GiftsThisYear_tf);
		GiftsThisYear_tf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total Gifts 1 Year Ago: ");
		lblNewLabel.setBounds(507, 34, 156, 16);
		contentPanel.add(lblNewLabel);
		
		Gifts1Year_tf = new JTextField();
		Gifts1Year_tf.setBounds(654, 29, 130, 26);
		contentPanel.add(Gifts1Year_tf);
		Gifts1Year_tf.setColumns(10);
		
		JLabel lblTotalGifts_1 = new JLabel("Total Gifts 2 Years Ago: ");
		lblTotalGifts_1.setBounds(507, 65, 153, 16);
		contentPanel.add(lblTotalGifts_1);
		
		Gifts2Year_tf = new JTextField();
		Gifts2Year_tf.setBounds(654, 60, 130, 26);
		contentPanel.add(Gifts2Year_tf);
		Gifts2Year_tf.setColumns(10);
		
		JLabel lblTotalGifts_2 = new JLabel("Total Gifts 3 Years Ago: ");
		lblTotalGifts_2.setBounds(507, 95, 153, 16);
		contentPanel.add(lblTotalGifts_2);
		
		Gifts3Year_tf = new JTextField();
		Gifts3Year_tf.setBounds(654, 90, 130, 26);
		contentPanel.add(Gifts3Year_tf);
		Gifts3Year_tf.setColumns(10);
		
		JLabel lblFirstGiftDate = new JLabel("First Gift Date: ");
		lblFirstGiftDate.setBounds(507, 125, 153, 16);
		contentPanel.add(lblFirstGiftDate);
		
		firstGiftDate_tf = new JTextField();
		firstGiftDate_tf.setBounds(654, 120, 130, 26);
		contentPanel.add(firstGiftDate_tf);
		firstGiftDate_tf.setColumns(10);
		
		JLabel lblFirstGiftAmount = new JLabel("First Gift Amount: ");
		lblFirstGiftAmount.setBounds(507, 155, 153, 16);
		contentPanel.add(lblFirstGiftAmount);
		
		firstGiftAmt_tf = new JTextField();
		firstGiftAmt_tf.setBounds(654, 150, 130, 26);
		contentPanel.add(firstGiftAmt_tf);
		firstGiftAmt_tf.setColumns(10);
		
		JLabel lblLastGiftDate = new JLabel("Last Gift Date: ");
		lblLastGiftDate.setBounds(507, 185, 142, 16);
		contentPanel.add(lblLastGiftDate);
		
		lastGiftDate_tf = new JTextField();
		lastGiftDate_tf.setBounds(654, 180, 130, 26);
		contentPanel.add(lastGiftDate_tf);
		lastGiftDate_tf.setColumns(10);
		
		JLabel lblLastGiftAmount = new JLabel("Last Gift Amount: ");
		lblLastGiftAmount.setBounds(507, 215, 153, 16);
		contentPanel.add(lblLastGiftAmount);
		
		lastGiftAmt_tf = new JTextField();
		lastGiftAmt_tf.setBounds(654, 210, 130, 26);
		contentPanel.add(lastGiftAmt_tf);
		lastGiftAmt_tf.setColumns(10);
		
		bemail_tf = new JTextField();
		bemail_tf.setBounds(365, 120, 130, 26);
		contentPanel.add(bemail_tf);
		bemail_tf.setColumns(10);
		
		JLabel bAdress_tf = new JLabel("Business Email: ");
		bAdress_tf.setBounds(234, 125, 130, 16);
		contentPanel.add(bAdress_tf);
		
		JLabel lblPosition = new JLabel("Position: ");
		lblPosition.setBounds(234, 65, 61, 16);
		contentPanel.add(lblPosition);
		
		position_tf = new JTextField();
		position_tf.setBounds(365, 60, 130, 26);
		contentPanel.add(position_tf);
		position_tf.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton submitButton = new JButton("Submit");
				submitButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Insert form entry event
						System.out.println("Button Clicked");
						String string_id = ID_tf.getText();
						string_id = "'"+string_id+"'";
						String EntryDate = EntryDate_tf.getText(); //1
						EntryDate = "'" + EntryDate +"'";
						String DonorType = DonorType_tf.getText();//2		
						DonorType = "'" + DonorType +"'";
						String title = Title_tf.getText();//3
						title = "'" + title +"'";
						String firstName = FirstName_tf.getText();//4
						firstName = "'" + firstName +"'";
						String lastName = LastName_tf.getText();//5
						lastName = "'" + lastName +"'";
						String suffix = Suffix_tf.getText();//6
						suffix = "'" + suffix +"'";
						String homePhone = HomePhone_tf.getText();//7
						homePhone = "'" + homePhone +"'";
						String cellPhone = CellPhone_tf.getText();//8
						cellPhone = "'" + cellPhone +"'";
						String email = email_tf.getText();//9
						email = "'" + email +"'";
						String org = org_tf.getText();//10
						org = "'" + org +"'";
						String bphone = bphone_tf.getText();//11
						bphone = "'" + bphone +"'";
						String bemail = bemail_tf.getText();//12
						bemail = "'" + bemail +"'";
						String noMailFlag = NoMailFlag_tf.getText();//13
						noMailFlag = "'" + noMailFlag +"'";
						String regionCode = RegionCode_tf.getText();//14
						regionCode = "'" + regionCode +"'";
						String lastContactDate = lastContactDate_tf.getText();//15
						lastContactDate = "'" + lastContactDate +"'";
						String totalGifts = totalGifts_tf.getText();//16
						totalGifts = "'" + totalGifts +"'";
						String giftsThisYear = GiftsThisYear_tf.getText();//17
						giftsThisYear = "'" + giftsThisYear +"'";
						String gifts1Year = Gifts1Year_tf.getText();//18
						gifts1Year = "'" + gifts1Year +"'";
						String gifts2Year = Gifts2Year_tf.getText();//19
						gifts2Year = "'" + gifts2Year +"'";
						String gifts3Year = Gifts3Year_tf.getText();//20
						gifts3Year = "'" + gifts3Year +"'";
						String lastGiftDate = lastGiftDate_tf.getText();//21
						lastGiftDate = "'" + lastGiftDate +"'";
						String lastGiftAmt = lastGiftAmt_tf.getText();//22
						lastGiftAmt = "'" + lastGiftAmt +"'";
						String firstGiftDate = firstGiftDate_tf.getText();//23
						firstGiftDate = "'" + firstGiftDate +"'";
						String FirstGiftAmt = firstGiftAmt_tf.getText();//24
						FirstGiftAmt = "'" + FirstGiftAmt +"'";
						String position = position_tf.getText();//25
						position = "'" + position +"'";
						
						
						try{
							
							
							
							//1. Get a connection to database
							Properties props = new Properties();
							props.load(new FileInputStream("settings.properties"));
							String url = props.getProperty("url");
							String user = props.getProperty("user");
							String password = props.getProperty("password");
						    Connection myConn = DriverManager.getConnection(url, user, password);
							
							//2. Create a statement 
							Statement myStmt = myConn.createStatement();
							
							
							//3. Execute SQL query
							String sql = "UPDATE namiDB.Constituents SET "
									
							//		+"CheckDigit = NULL," //CheckID not used as of now
									+"EntryDate = "+EntryDate+","
									+"DonorType = "+DonorType+","
									+"Title = "+title+","
									+"FirstName = "+firstName+","
						//			+ "MiddleName = NULL," //Middle Name
									+"LastName = "+lastName+","
									+"Suffix = "+suffix+","
								    +"Position = "+position+","
						/*		    + "Employer = NULL," //Employer
								    + "Title2 = NULL," //Title2
								    + "First2 = NULL,"//First2
								    + "Middle2 = NULL,"//Middle2
								    + "Last2 = NULL,"//Last2
								    + "Suffix2 = NULL,"//Suffix2
								    + "Position2 = NULL," //position2
								    + "Employer2 = NULL," //Employer2   */
								    + "HomePhone = "+homePhone+","
									+ "CellPhone = "+cellPhone+","
		               //             + "Pager = NULL," //pager
					//			    + "OtherPhone = NULL," //otherPhone
                        			+ "Email = "+email+","
 		             /*               + "HomeWebSite = NULL," //home web site
								    + "HomeFax = NULL," //home fax
							        + "WorkPhone = NULL," //work phone
								    + "WorkE_Mail = NULL," //work email
 		                            + "WorkWebSite = NULL," //work web site
								    + "HomePhone2 = NULL," //home phone2
							        + "CellPhone2 = NULL," //cell phone 2
								    + "Pager2 = NULL," //pager 2 	
								    + "OtherPhone2 = NULL," //other phone 2 
								    + "HomeE_Mail2 = NULL," //home email 2  
								    + "HomeWebSite2 = NULL," //home web site 2 
								    + "HomeFax2 = NULL," //home fax 2 
								    + "WorkPhone2 = NULL," //work phone 2  
								    + "WorkE_Mail2 = NULL," //work email 2  
								    + "WorkWebSite2 = NULL," //work web site 2 
								    + "OrganizationShortName = NULL," //org short name 2    */
								    +"OrganizationName = "+org+","
									+"BusinessPhone = "+bphone+","
							//		+"BusinessPhone2 = NULL,"//Business phone 2
									+"BusinessEmail = "+bemail+","
					/*				+"BusinessWebSite = NULL,"//Business Web site
									+"DoesMatching = NULL," //Does Matching
									+"MatchPercent = NULL," //Match Percent
									+"FaxPhone = NULL," //Fax Phone
									+"FullName = NULL," //Full Name
									+"MaidenName = NULL," //Maiden Name
									+"MaidenNameBelongsToDonor = NULL," //Maiden Name Belongs 2
									+"Salutation1 = NULL," //Salutation 1
		   						    +"Salutation2 = NULL," //Salutation 2	*/
		   						    +"NoMailFlag = "+noMailFlag+","
		   					//	    +"Anonymous = NULL," //Annon
		   				//		    +"SortKey = NULL," //Sort Key
									+"RegionCode = "+regionCode+","
					/*				+"Solicitor = NULL," //Solicitor 
									+"CapacityCode = NULL," //Capacity Code
									+"SpecialCode1 = NULL," //Special Code 1
									+"SpecialCode2 = NULL," //Special Code 2
									+"SpecialCode3 = NULL," //Special Code 3
	                                +"SpecialCode4 = NULL," //Special Code 4   */
									+"LastContactDate = "+lastContactDate+","
									+"TotalGifts = "+totalGifts+","
									+"GiftsThisYear = "+giftsThisYear+","
									+"Gifts1YearAgo = "+gifts1Year+","
									+"Gifts2YearsAgo = "+gifts2Year+","
									+"Gifts3YearsAgo = "+gifts3Year+","
									+"LastGiftDate = "+lastGiftDate+","
									+"LastGiftAmount = "+lastGiftAmt+","
									+"FirstGiftDate = "+firstGiftDate+","
									+"FirstGiftAmount = "+FirstGiftAmt+" "
							/*		+"LargestGiftDate = NULL," //Largest Gift Date
									+"LargestGiftAmount = NULL," //Largest Gift Amt
									+"RecordLastChangedDate = NULL," //Recorded Last Change Date
									+"Marked = NULL," //Marked
									+"Archived = NULL," //Archived
									+"ArchivedDate = NULL," //Archived Date
									+"Gender = NULL," //Gender 
									+"Birthday = NULL," //Birthday
									+"Race = NULL," //Race
									+"DirectoryName = NULL," //Directory Name
									+"DirectorySortKey = NULL," //Directory Sort Key
									+"LabelLine1 = NULL," //Label Line1
									+"LabelLine2 = NULL," //Label Line 2
									+"Greeting1 = NULL," //Greeting 1
									+"Greeting2 = NULL," //Greeting 2
									+"RecordType = NULL," //Record Type
									+"MakeLabelLinesFrom = NULL," //Marked Label Lines
									+"HasMemo = NULL," //Has Memo
									+"HasReminder = NULL," //Has Reminder
									+"HasLog = NULL," //Has Log
									+"HasFamily = NULL" //Has Family  */
									+"WHERE ID = "+string_id+";";
					
							//String sql = "INSERT INTO namiDB.Constituents VALUES (NULL, NULL, today, i,NULL,NULL, test, NULL, NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL )";
							
							
		
							//String sql = "INSERT INTO testNami.const VALUES (NULL,'2017-06-22','Premus','Steve','spremus18@gmail.com','$125')";
							myStmt.executeUpdate(sql);
							
							System.out.println("Insert Complete");
						//	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				

						}
						catch (Exception exc){
							exc.printStackTrace();
						}
						setVisible(false);
						dispose();
					}
				});
				
				submitButton.setActionCommand("OK");
				buttonPane.add(submitButton);
				getRootPane().setDefaultButton(submitButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
}
