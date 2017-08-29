package namiDonorDB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.mysql.jdbc.PreparedStatement;
import namiDonorDB.Constituent;

public class ConstituentDAO {
	private Connection myConn;
	
	public ConstituentDAO() throws Exception {
	
		Properties props = new Properties();
		props.load(new FileInputStream("settings.properties"));
		
		String url = props.getProperty("url");
		String user = props.getProperty("user");
		String password = props.getProperty("password");

		myConn = DriverManager.getConnection(url, user, password);
		
		System.out.println("Successful Connection to Database @: "+url);
		
	}
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
	
	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);
	}
	
	public void addConstituent(Constituent theConstituent) throws Exception {
		PreparedStatement myStmt = null;
		try {
			myStmt = (PreparedStatement) myConn.prepareStatement("insert into namiDB.constituents"
					+" (EntryDate, DonorType, Title, FirstName, LastName, Suffix, Position, Employer, HomePhone,"
					+" CellPhone, Email, OrganizationName, BusinessPhone, BusinessEmail, NoMailFlag, RegionCode, LastContactDate,"
					+" TotalGifts, GiftsThisYear, Gifts1YearAgo, Gifts2YearsAgo, Gifts3YearsAgo, FirstGiftDate,"
					+" FirstGiftAmount, LastGiftDate, LastGiftAmount"
					+"values (NULL, ?, ?, ?, ?, ?");
			myStmt.setString(2, theConstituent.getEntryDate());
			myStmt.setString(3, theConstituent.getDonorType());
			myStmt.setString(4, theConstituent.getTitle());
			myStmt.setString(5, theConstituent.getFirstName());
			myStmt.setString(6, theConstituent.getLastName());
			myStmt.setString(7, theConstituent.getSuffix());
			myStmt.setString(8, theConstituent.getPosition());
			myStmt.setString(9, theConstituent.getEmployer());
			myStmt.setString(10, theConstituent.getHomePhone());
			myStmt.setString(11, theConstituent.getCellPhone());
			myStmt.setString(12, theConstituent.getEmail());
			myStmt.setString(13, theConstituent.getOrganizationName());
			myStmt.setString(14, theConstituent.getBusinessPhone());
			myStmt.setString(15, theConstituent.getBusinessEmail());
			myStmt.setString(16, theConstituent.getNomailFlag());
			myStmt.setString(17, theConstituent.getregionCode());
			myStmt.setString(18, theConstituent.getLastContactDate());
			myStmt.setInt(19, theConstituent.getTotalGifts());
			myStmt.setInt(20, theConstituent.getGiftsThisYear());
			myStmt.setInt(21, theConstituent.getGifts1Year());
			myStmt.setInt(22, theConstituent.getGifts2Years());
			myStmt.setInt(23, theConstituent.getGifts3Years());
			myStmt.setString(24, theConstituent.getFirstGiftDate());
			myStmt.setInt(25, theConstituent.getFirstGiftAmt());
			myStmt.setString(26, theConstituent.getLastGiftDate());
			myStmt.setInt(27, theConstituent.getLastGiftAmt());

			myStmt.executeUpdate();
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public void deleteConstituent(int ID) throws SQLException {
		PreparedStatement myStmt = null; 
		try {
			//prepare statement
			myStmt = (PreparedStatement) myConn.prepareStatement("delete from namiDB.Constituents where ID = ?");
			//set param
			myStmt.setInt(1, ID);
			//execute SQL
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	}
	
	public void updateConstituent(Constituent theConstituent) throws SQLException {
		PreparedStatement myStmt = null;
		try {
			//Prepare Stmt
			myStmt = (PreparedStatement) myConn.prepareStatement(
					"UPDATE testNami.const SET EntryDate=?, DonorType=?, Title=?, FirstName=?, LastName=?, Suffix=?, "
				  + "Position=?, Employer=?, HomePhone=?, CellPhone=?, Email=?, OrganizationName=?, BusinessPhone=?, BusinessEmail=?, "
				  + "NoMailFlag=?, RegionCode=?, LastContactDate=?, TotalGifts=?, GiftsThisYear=?, Gifts1YearAgo=?, "
				  + "Gifts2YearsAgo=?, Gifts3YearsAgo=?, FirstGiftDate=?, FirstGiftAmount=? LastGiftDate=?, "
				  + "LastGiftAmount=? WHERE ID=?");
			
			//set params
			myStmt.setString(1, theConstituent.getEntryDate());
			myStmt.setString(2, theConstituent.getDonorType());
			myStmt.setString(3, theConstituent.getTitle());
			myStmt.setString(4, theConstituent.getFirstName());
			myStmt.setString(5, theConstituent.getLastName());
			myStmt.setString(6, theConstituent.getSuffix());
			myStmt.setString(7, theConstituent.getPosition());
			myStmt.setString(8, theConstituent.getEmployer());
			myStmt.setString(9, theConstituent.getHomePhone());
			myStmt.setString(10, theConstituent.getCellPhone());
			myStmt.setString(11, theConstituent.getEmail());
			myStmt.setString(12, theConstituent.getOrganizationName());
			myStmt.setString(13, theConstituent.getBusinessPhone());
			myStmt.setString(14, theConstituent.getBusinessEmail());
			myStmt.setString(15, theConstituent.getNomailFlag());
			myStmt.setString(16, theConstituent.getregionCode());
			myStmt.setString(17, theConstituent.getLastContactDate());
			myStmt.setInt(18, theConstituent.getTotalGifts());
			myStmt.setInt(19, theConstituent.getGiftsThisYear());
			myStmt.setInt(20, theConstituent.getGifts1Year());
			myStmt.setInt(21, theConstituent.getGifts2Years());
			myStmt.setInt(22, theConstituent.getGifts3Years());
			myStmt.setString(23, theConstituent.getFirstGiftDate());
			myStmt.setInt(24, theConstituent.getFirstGiftAmt());
			myStmt.setString(25, theConstituent.getLastGiftDate());
			myStmt.setInt(26, theConstituent.getLastGiftAmt());
			myStmt.setInt(27, theConstituent.getID());
			
			//Execute SQL
			myStmt.executeUpdate();
			try {
				getAllConstituents();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally { 
			close(myStmt); 
			}
	}

	public List<Constituent> getAllConstituents() throws Exception {
		List<Constituent> list =  new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM namiDB.Constituents");
			
			while(myRs.next()){
				Constituent temp = convertRowToConstituent(myRs);
				list.add(temp);
			}
			return list;
		}
		finally {
			close(myStmt,myRs);
		}
	}
	
	List<Constituent> searchConstituents(String lastName) throws Exception {
		List<Constituent> list = new ArrayList<>();
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try{
			lastName += "%";
			myStmt = (PreparedStatement) myConn.prepareStatement("SELECT * from namiDB.Constituents where LastName like ?");
			myStmt.setString(1, lastName);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()){
				Constituent temp = convertRowToConstituent(myRs);
				list.add(temp);
			}
			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	private Constituent convertRowToConstituent(ResultSet myRs) throws SQLException {
		int id = myRs.getInt("ID");
		String entryDate = myRs.getString("EntryDate");
		String DonorType = myRs.getString("DonorType");
		String Title = myRs.getString("Title");
		String FirstName = myRs.getString("FirstName");
		String LastName = myRs.getString("LastName");
		String Suffix = myRs.getString("Suffix");
		String Position = myRs.getString("Position");
		String Employer = myRs.getString("Employer");
		String HomePhone = myRs.getString("HomePhone");
		String CellPhone = myRs.getString("CellPhone");
		String email = myRs.getString("Email");
		String OrganizationName = myRs.getString("OrganizationName");
		String BusinessPhone = myRs.getString("BusinessPhone");
		String BusinessEmail = myRs.getString("BusinessEmail");
		String NomailFlag = myRs.getString("NoMailFlag");
		String regionCode = myRs.getString("RegionCode");
		String LastContactDate = myRs.getString("LastContactDate");
		int TotalGifts = myRs.getInt("TotalGifts");
		int GiftsThisYear = myRs.getInt("GiftsThisYear");
		int Gifts1Year = myRs.getInt("Gifts1YearAgo");
		int Gifts2Years = myRs.getInt("Gifts2YearsAgo");
		int Gifts3Years = myRs.getInt("Gifts3YearsAgo");
		String FirstGiftDate = myRs.getString("FirstGiftDate");
		int FirstGiftAmt = myRs.getInt("FirstGiftAmount");
		String LastGiftDate = myRs.getString("LastGiftDate");
		int LastGiftAmt = myRs.getInt("LastGiftAmount");


		
		Constituent temp = new Constituent(
				id,
				entryDate,
				DonorType,
				Title,
				FirstName,
				LastName,
				Suffix,
				Position,
				Employer,
				CellPhone,
				HomePhone,
				email,
				OrganizationName,
				BusinessPhone,
				BusinessEmail,
				NomailFlag,
				regionCode,
				LastContactDate,
				TotalGifts,
				GiftsThisYear,
				Gifts1Year,
				Gifts2Years,
				Gifts3Years,
				FirstGiftDate,
				FirstGiftAmt,
				LastGiftDate,
				LastGiftAmt
				);
		return temp;
	}
	
	public static void main(String[] args) throws Exception {
		
		ConstituentDAO dao = new ConstituentDAO();
		
		//System.out.println("Manual Print: "+dao.searchConstituents("Oddo"));

		System.out.println(dao.getAllConstituents());
	}

}
