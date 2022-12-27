import java.util.List;


public class Medicine {
	public static final int ID_LENGTH = 4;
	public static final int RACKNO_LENGTH = 13;
	public static final int COMPANYNAME_MAX_LENGTH = 40 ;
	public static final int UNITCOST_MAX_LENGHT = 5;
	public static final int QUANTITY_MAX_LENGTH = 20;
	public static final int MEDICINENAME_MAX_LENGTH = 40;
	public static final int CABNITNO_MAX_LENGHT = 5;
	public static final int SUPPLIERNAME_MAX_LENGTH = 40 ;
	public static final int SALECOST_MAX_LENGHT = 5;
	public static final int MEDICINE_DATA_BLOCK_SIZE = ID_LENGTH + RACKNO_LENGTH + COMPANYNAME_MAX_LENGTH + UNITCOST_MAX_LENGHT + QUANTITY_MAX_LENGTH + MEDICINENAME_MAX_LENGTH + CABNITNO_MAX_LENGHT + SUPPLIERNAME_MAX_LENGTH + SALECOST_MAX_LENGHT  ;



	private int _id;
	private int _rackNo;            
	private String _companyname;
	private int _unitcost;
	private int _quantity;
	private String _medicinename;
    private int _cabnıtno;
    private String _suppliername;
    private int _salecost;

	public int getId() {return _id;}
	public void setId(int id) {this._id = id;}

	public int getRackNo() {return _rackNo;}
	public void setRackNo(int rackno) {this._rackNo = rackno;}

	public String getCompanyName() {return _companyname;}
	public void setCompanyName(String CompanyName) {this._companyname = CompanyName;}

	public int getUnitCost() {return _unitcost;}
	public void setUnitCost(int unitcost) {this._unitcost = unitcost;}

	public int getQuantity() {return _quantity;}
	public void setQuantity(int quantity) {this._quantity = quantity;}
	
	public String getMedicineName() { return _medicinename;}
	public void setMedicineName(String MedicineName) {this._medicinename = MedicineName;}
	
	public int getCabnıtNo() {return _cabnıtno;}
	public void setCabnıtNo(int cabnıtno) {this._cabnıtno = cabnıtno;}
	
	public String getSupplierName() {return _suppliername;}
	public void setSupplierName(String SupplierName) {this._suppliername = SupplierName;}
	
	public int getSaleCost() {return _salecost;}
	public void setSaleCost(int salecost) {this._salecost = salecost;}
	
	

	

	public static byte[] medicineToByteArrayBlock(Medicine medicine)
	{
	int index = 0;	
	byte[] dataBuffer = new byte[MEDICINE_DATA_BLOCK_SIZE];

	//copy supplier id
	byte[] idBytes = ConversionUtility.intToByteArray(medicine.getId());
	   System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
	   index += Medicine.ID_LENGTH;
 
	byte[] racknoBytes = ConversionUtility.intToByteArray(medicine.getRackNo());
	System.arraycopy(racknoBytes, 0, dataBuffer, index, racknoBytes.length);
	index += Medicine.RACKNO_LENGTH;

	byte[] companynameBytes = ConversionUtility.stringToByteArray(medicine.getCompanyName());
	System.arraycopy(companynameBytes, 0, dataBuffer, index, companynameBytes.length);
	index += Medicine.COMPANYNAME_MAX_LENGTH;


	byte[] unitcostBytes = ConversionUtility.intToByteArray(medicine.getUnitCost());
    System.arraycopy(unitcostBytes, 0, dataBuffer, index, unitcostBytes.length);
    index += Medicine.UNITCOST_MAX_LENGHT;

    byte[] quantityBytes = ConversionUtility.intToByteArray(medicine.getQuantity());
	System.arraycopy(quantityBytes, 0, dataBuffer, index, quantityBytes.length);
    index += Medicine.QUANTITY_MAX_LENGTH;
	
	byte[] medicinenameBytes = ConversionUtility.stringToByteArray(medicine.getMedicineName());
	System.arraycopy(medicinenameBytes, 0, dataBuffer, index, medicinenameBytes.length);
	index += Medicine.MEDICINENAME_MAX_LENGTH;
	
	byte[] cabnıtnoBytes = ConversionUtility.intToByteArray(medicine.getCabnıtNo());
	System.arraycopy(cabnıtnoBytes, 0, dataBuffer, index, cabnıtnoBytes.length);
	index += Medicine.CABNITNO_MAX_LENGHT;
	
	byte[] suppliernameBytes = ConversionUtility.stringToByteArray(medicine.getSupplierName());
	System.arraycopy(suppliernameBytes, 0, dataBuffer, index, suppliernameBytes.length);
	index += Medicine.SUPPLIERNAME_MAX_LENGTH;
	
	byte[] salecostBytes = ConversionUtility.intToByteArray(medicine.getSaleCost());
	System.arraycopy(salecostBytes, 0, dataBuffer, index, salecostBytes.length);
	index += Medicine.SALECOST_MAX_LENGHT;
	

	if(index != dataBuffer.length)
	{
	throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");

	}
	return dataBuffer;

	}
	
	public static Medicine byteArrayBlockToMedicine(byte[] byteArray) {
		Medicine medicine = new Medicine();

	    if (byteArray.length != MEDICINE_DATA_BLOCK_SIZE) {
	        throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	    }

	    int index = 0;

	    // copy Medicine id
	    byte[] idBytes = new byte[Medicine.ID_LENGTH];
	    System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
	    medicine.setId(ConversionUtility.byteArrayToInteger(idBytes));
	    index += Medicine.ID_LENGTH;

	    // copy Medicine Contact No
	    byte[] racknoBytes = new byte[Medicine.RACKNO_LENGTH];
	    System.arraycopy(byteArray, index, racknoBytes, 0, racknoBytes.length);
	    medicine.setRackNo(ConversionUtility.byteArrayToInteger(racknoBytes));
	    index += Medicine.RACKNO_LENGTH;

	    // copy Medicine CompanyName
	    byte[] companynameBytes = new byte[Medicine.COMPANYNAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, companynameBytes, 0, companynameBytes.length);
	    medicine.setCompanyName(ConversionUtility.byteArrayToString(companynameBytes));
	    index += Medicine.COMPANYNAME_MAX_LENGTH;

	    // UNIT COST
	    byte[] unitcostBytes = new byte[Medicine.UNITCOST_MAX_LENGHT];
	    System.arraycopy(byteArray, index, unitcostBytes, 0, unitcostBytes.length);
	    medicine.setUnitCost(ConversionUtility.byteArrayToInteger(unitcostBytes));
	    index += Medicine.UNITCOST_MAX_LENGHT;

	    // copy Supplier name
	    byte[] quantityBytes = new byte[Medicine.QUANTITY_MAX_LENGTH];
	    System.arraycopy(byteArray, index, quantityBytes, 0, quantityBytes.length);
	    medicine.setQuantity(ConversionUtility.byteArrayToInteger(quantityBytes));
	    index += Medicine.QUANTITY_MAX_LENGTH;
	    
	    byte[] medicinenameBytes = new byte[Medicine.MEDICINENAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, medicinenameBytes, 0, medicinenameBytes.length);
	    medicine.setMedicineName(ConversionUtility.byteArrayToString(medicinenameBytes));
	    index += Medicine.MEDICINENAME_MAX_LENGTH;
	    
	    byte[] cabnıtnoBytes = new byte[Medicine.CABNITNO_MAX_LENGHT];
	    System.arraycopy(byteArray, index, cabnıtnoBytes, 0, cabnıtnoBytes.length);
	    medicine.setCabnıtNo(ConversionUtility.byteArrayToInteger(cabnıtnoBytes));
	    index += Medicine.CABNITNO_MAX_LENGHT;
	    
	    byte[] suppliernameBytes = new byte[Medicine.SUPPLIERNAME_MAX_LENGTH];
	    System.arraycopy(byteArray, index, suppliernameBytes, 0, suppliernameBytes.length);
	    medicine.setSupplierName(ConversionUtility.byteArrayToString(suppliernameBytes));
	    index += Medicine.SUPPLIERNAME_MAX_LENGTH;
	    
	    byte[] salecostBytes = new byte[Medicine.SALECOST_MAX_LENGHT];
	    System.arraycopy(byteArray, index, salecostBytes, 0, salecostBytes.length);
	    medicine.setSaleCost(ConversionUtility.byteArrayToInteger(salecostBytes));
	    index += Medicine.SALECOST_MAX_LENGHT;
	    

	    if (index != byteArray.length) {
	        throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
	    }

	    if (medicine.getId() == 0) {
	        return null;
	    } else {
	    	
	        return medicine;
	        
	    }

    }
}
