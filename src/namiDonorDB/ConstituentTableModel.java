package namiDonorDB;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ConstituentTableModel extends AbstractTableModel{
	public static final int OBJECT_COL = -1;
	private static final int ID_COL = 0;
	private static final int entryDate_COL = 1;
	private static final int DonorType_COL = 2;
	private static final int Title_COL = 3;
	private static final int FirstName_COL = 4;
	private static final int LastName_COL = 5;
	private static final int Suffix_COL = 6;
	private static final int Position_COL = 7;
	private static final int Employer_COL = 8;
	private static final int HomePhone_COL = 9;
	private static final int CellPhone_COL = 10;
	private static final int email_COL = 11;
	private static final int OrganizationName_COL = 12;
	private static final int BusinessPhone_COL = 13;
	private static final int BusinessEmail_COL = 14;
	private static final int NomailFlag_COL = 15;
	private static final int regionCode_COL = 16;
	private static final int LastContactDate_COL = 17;
	private static final int TotalGifts_COL = 18;
	private static final int GiftsThisYear_COL = 19;
	private static final int Gifts1Year_COL = 20;
    private static final int Gifts2Years_COL = 21;
    private static final int Gifts3Years_COL = 22;
    private static final int FirstGiftDate_COL = 23;
    private static final int  FirstGiftAmount_COL = 24;
    private static final int LastGiftDate_COL = 25;
    private static final int LastGiftAmount_COL = 26;
    
    private String[] columnNames = { 
    		"ID", 
    		"Entry Date", 
    		"Donor Type", 
    		"Title", 
    		"First Name",
    		"Last Name", 
    		"Suffix", 
    		"Position",
    		"Employer",
    		"HomePhone",
    		"CellPhone",
    		"email",
    		"Organization Name", 
    		"Business Phone", 
    		"Business Address",
    		"No Mail Flag",
    		"Region Code", 
    		"Last Contact Date", 
    		"Total Gifts", 
    		"Total Gifts This Year", 
    		"Total Gifts 1 Year Ago", 
    		"Total Gifts 2 Years Ago", 
    		"Total Gifts 3 Years Ago", 
    		"First Gift Date", 
    		"First Gift Amount", 
    		"Last Gift Date", 
    		"Last Gift Amount" 
    		};
    
	private List<Constituent> constituents;
    
	public ConstituentTableModel(List<Constituent> theConstituents) {
		constituents = theConstituents;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return constituents.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Constituent tempConstituent = constituents.get(row);

		switch (col) {
		case ID_COL:
			return tempConstituent.getID();
		case entryDate_COL:
			return tempConstituent.getEntryDate();
		case DonorType_COL	:
			return tempConstituent.getDonorType();
		case Title_COL:
			return tempConstituent.getTitle();
		case FirstName_COL:
			return tempConstituent.getFirstName();
		case LastName_COL:
			return tempConstituent.getLastName();
		case Suffix_COL:
			return tempConstituent.getSuffix();
		case Position_COL:
			return tempConstituent.getPosition();
		case Employer_COL:
			return tempConstituent.getEmployer();
		case HomePhone_COL:
			return tempConstituent.getHomePhone();
		case CellPhone_COL:
			return tempConstituent.getCellPhone();
		case email_COL:
			return tempConstituent.getEmail();
		case OrganizationName_COL:
			return tempConstituent.getOrganizationName();
		case BusinessPhone_COL:	
			return tempConstituent.getBusinessPhone();
		case BusinessEmail_COL:	
			return tempConstituent.getBusinessEmail();
		case NomailFlag_COL:
			return tempConstituent.getNomailFlag();
		case regionCode_COL:
			return tempConstituent.getregionCode();
		case LastContactDate_COL:
			return tempConstituent.getLastContactDate();
		case TotalGifts_COL:
			return tempConstituent.getTotalGifts();
		case GiftsThisYear_COL:
			return tempConstituent.getGiftsThisYear();
		case Gifts1Year_COL:
			return tempConstituent.getGifts1Year();
		case Gifts2Years_COL:
			return tempConstituent.getGifts2Years();
		case Gifts3Years_COL:
			return tempConstituent.getGifts3Years();
		case FirstGiftDate_COL:
			return tempConstituent.getFirstGiftDate();
		case FirstGiftAmount_COL:
			return tempConstituent.getFirstGiftAmt();
		case LastGiftDate_COL:
			return tempConstituent.getLastGiftDate();
		case LastGiftAmount_COL: 
			return tempConstituent.getLastGiftAmt();
		default:
			return tempConstituent;
		}
	}
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}