package namiDonorDB;

public class Constituent {
	private int id;
	private String entryDate;
	private String DonorType;
	private String Title;
	private String FirstName;
	private String LastName;
	private String Suffix;
	private String Position;
	private String Employer;
	private String HomePhone;
	private String CellPhone;
	private String email;
	private String OrganizationName;
	private String BusinessPhone;
	private String BusinessEmail;
	private String NomailFlag;
	private String regionCode;
	private String LastContactDate;
	private int TotalGifts;
	private int GiftsThisYear;
	private int Gifts1Year;
	private int Gifts2Years;
	private int Gifts3Years;
	private String FirstGiftDate;
	private int FirstGiftAmt;
	private String LastGiftDate;
	private int LastGiftAmt;
	
	public Constituent(
			int id,
			String entryDate,
			String DonorType,
			String Title,
			String FirstName,
			String LastName,
			String Suffix,
			String Position,
			String Employer,
			String CellPhone,
			String HomePhone,
			String email,
			String OrganizationName,
			String BusinessPhone,
			String BusinessEmail,
			String NomailFlag,
			String regionCode,
			String LastContactDate,
			int TotalGifts,
			int GiftsThisYear,
			int Gifts1Year,
			int Gifts2Years,
			int Gifts3Years,
			String FirstGiftDate,
			int FirstGiftAmt,
			String LastGiftDate,
			int LastGiftAmt
			) {
		super();
		this.id = id ;
		this.entryDate = entryDate;
		this.DonorType = DonorType;
		this.Title = Title;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Suffix = Suffix;
		this.Position = Position;
		this.Employer = Employer;
		this.HomePhone = HomePhone;
		this.CellPhone = CellPhone;
		this.email = email;
		this.OrganizationName = OrganizationName;
		this.BusinessPhone = BusinessPhone;
		this.BusinessEmail = BusinessEmail;
		this.NomailFlag = NomailFlag;
		this.regionCode = regionCode;
		this.LastContactDate = LastContactDate;
		this.TotalGifts = TotalGifts;
		this.GiftsThisYear = GiftsThisYear;
		this.Gifts1Year = Gifts1Year;
		this.Gifts2Years = Gifts2Years;
		this.Gifts3Years = Gifts3Years;
		this.FirstGiftDate = FirstGiftDate;
		this.FirstGiftAmt = FirstGiftAmt;
		this.LastGiftDate = LastGiftDate;
		this.LastGiftAmt = LastGiftAmt;
	}		
		public int getID() { 
			return id;
		}
		public void setID(int id){
			this.id = id;
		}
		
		public String getEntryDate() { 
			return entryDate;
		}
		public void setEntryDate(String entryDate){
			this.entryDate = entryDate;
		}
		
		public String getDonorType() {
			return DonorType;
		}
		public void setDonorType(String DonorType){
			this.DonorType = DonorType;
	    }
		
		public String getTitle() { 
			return Title;
		}
		public void setTitle(String Title){
			this.Title = Title;
		}
		
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String FirstName){
			this.FirstName = FirstName;
		}
		
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String LastName){
			this.LastName = LastName;
		}
		
		public String getSuffix() { 
			return Suffix;
		}
		public void setSuffix(String Suffix){
			this.Suffix = Suffix;
		}
		
		public String getPosition() {
			return Position;
		}
		public void setPosition(String Position){
			this.Position = Position;
		}
		
		public String getEmployer() {
			return Employer;
		}
		public void setEmployer(String Employer){
			this.Employer = Employer;
		}
		
		public String getHomePhone() {
			return HomePhone;
		}
		public void setHomePhone(String HomePhone){
			this.HomePhone = HomePhone;
		}
		
		public String getCellPhone() {
			return HomePhone;
		}
		public void setCellPhone(String CellPhone){
			this.CellPhone = CellPhone;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email){
			this.email = email;
		}
		
		public String getOrganizationName() {
			return OrganizationName;
		}
		public void setOrganizationName(String OrganizationName){
			this.OrganizationName = OrganizationName;
		}

		public String getBusinessPhone() {
			return BusinessPhone;
		}
		public void setBusinessPhone(String BusinessPhone){
			this.BusinessPhone = BusinessPhone;
		}
		
		public String getBusinessEmail() {
			return BusinessEmail;
		}
		public void setBusinessAddress(String BusinessEmail){
			this.BusinessEmail = BusinessEmail;
		}
		
		public String getNomailFlag() {
			return NomailFlag;
		}
		public void setNomailFlag(String NomailFlag){
			this.NomailFlag = NomailFlag;
	    }
		
		public String getregionCode() {
			return regionCode;
		}
		public void setregionCode(String regionCode){
			this.regionCode = regionCode;
		}
		
		public String getLastContactDate() { 
			return LastContactDate;
		}
		public void LastContactDate(String LastContactDate){
			this.LastContactDate = LastContactDate;
		}
		
		public int getTotalGifts() { 
			return TotalGifts;
		}
		public void setTotalGifts(int TotalGifts){
			this.TotalGifts = TotalGifts;
		}
		
		public int getGiftsThisYear() { 
			return GiftsThisYear;
		}
		public void setGiftsThisYear(int GiftsThisYear){
			this.GiftsThisYear = GiftsThisYear;
		}
		
		public int getGifts1Year() { 
			return Gifts1Year;
		}
		public void setGifts1Year(int Gifts1Year){
			this.Gifts1Year = Gifts1Year;
		}
		
		public int getGifts2Years() { 
			return Gifts2Years;
		}
		public void setGifts2Years(int Gifts2Years){
			this.Gifts2Years = Gifts2Years;
		}
		
		public int getGifts3Years() { 
			return Gifts3Years;
		}
		public void setGifts3Years(int Gifts3Years){
			this.Gifts3Years = Gifts3Years;
		}
		
		public String getFirstGiftDate() { 
			return FirstGiftDate;
		}
		public void setFirstGiftDate(String FirstGiftDate){
			this.FirstGiftDate = FirstGiftDate;
		}
		
		public int getFirstGiftAmt() { 
			return FirstGiftAmt;
		}
		public void setFirstGiftAmt(int FirstGiftAmt){
			this.FirstGiftAmt = FirstGiftAmt;
		}
		
		public String getLastGiftDate() { 
			return LastGiftDate;
		}
		public void setLastGiftDate(String LastGiftDate){
			this.LastGiftDate = LastGiftDate;
		}
		
		public int getLastGiftAmt() { 
			return LastGiftAmt;
		}
		public void setLastGiftAmt(int LastGiftAmt){
			this.LastGiftAmt = LastGiftAmt;
		}
		@Override
		public String toString(){
			return String
					.format("Constituent "
							+ "[id=%s, "
							+ "entryDate=%s, "
							+ "DonorType=%s, "
							+ "Title=%s, "
							+ "FirstName=%s, "
							+ "LastName=%s, "
							+ "Suffix=%s, "
							+ "Position=%s, "
							+ "Employer=%s, "
							+ "HomePhone=%s, "
							+ "CellPhone=%s, "
							+ "Email=%s, " 
							+ "OrganizationName=%s, "
							+ "BusinessPhone=%s, "
							+ "BusinessEmail=%s, "
							+ "NomailFlag=%s, "
							+ "regionCode=%s, "
							+ "LastContactDate=%s, "
							+ "TotalGifts=%s, "
							+ "GiftsThisYear=%s, "
							+ "Gifts1Year=%s, "
							+ "Gifts2Years=%s, "
							+ "Gifts3Years=%s, "
							+ "FirstGiftDate=%s, "
							+ "FirstGiftAmt=%s, "
							+ "LastGiftDate=%s, "
							+ "LastGiftAmt=%s  "
							+ "]",
							+ id,entryDate, DonorType, Title, FirstName, LastName, Suffix, Position, Employer, 
							HomePhone, CellPhone, email, OrganizationName, BusinessPhone, BusinessEmail, NomailFlag, regionCode, 
							LastContactDate, TotalGifts,GiftsThisYear, Gifts1Year, Gifts2Years, Gifts3Years, FirstGiftDate, 
							FirstGiftAmt, LastGiftDate, LastGiftAmt);
		}

}
