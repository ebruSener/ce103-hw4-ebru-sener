   import java.util.List;

	    public class Customer {
		public static final int ID_LENGTH = 4;
		public static final int CONTACTNO_LENGTH = 13;
		public static final int EMAIL_MAX_LENGTH = 40 ;
		public static final int CITY_MAX_COUNT = 5;
		public static final int CITY_MAX_LENGTH = 20;
		public static final int NAME_MAX_LENGTH = 40;
		public static final int NAME_MAX_COUNT = 5;
		public static final int CUSTOMER_DATA_BLOCK_SIZE = ID_LENGTH + CONTACTNO_LENGTH + EMAIL_MAX_LENGTH + CITY_MAX_LENGTH + NAME_MAX_LENGTH;



		private int _id;
		private String _contactNo;
		private String _email;
		private List <String> _city;
		private List <String> _name;



		public int getId() {return _id;}
		public void setId(int id) {this._id = id;}

		public String getContactNo() { return _contactNo;}
		public void setContactNo(String contactno) {this._contactNo = contactno;}

		public String getEmail() {return _email;}
		public void setEmail(String email) {this._email = email;}

		public List <String> getCity() {return _city;}
		public void setCity(List <String> city) {this._city = city;}

		public List <String> getName() {return _name;}
		public void setName(List <String> name) {this._name = name;}

		public static byte[] customerToByteArrayBlock(Customer customer)
		{
		int index = 0;	
		byte[] dataBuffer = new byte[CUSTOMER_DATA_BLOCK_SIZE];

		//copy customer id
		byte[] idBytes = ConversionUtility.intToByteArray(customer.getId());
		   System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
		   index += Customer.ID_LENGTH;
	 
		byte[] contactnoBytes = ConversionUtility.stringToByteArray(customer.getContactNo());
		System.arraycopy(contactnoBytes, 0, dataBuffer, index, contactnoBytes.length);
		index += Customer.CONTACTNO_LENGTH;

		byte[] emailBytes = ConversionUtility.stringToByteArray(customer.getEmail());
		System.arraycopy(emailBytes, 0, dataBuffer, index, emailBytes.length);
		index += Customer.EMAIL_MAX_LENGTH;


		byte[] cityBytes = ConversionUtility.stringListToByteArray(customer.getCity(), Customer.CITY_MAX_LENGTH);
		System.arraycopy(cityBytes, 0, dataBuffer, index, cityBytes.length);
		index += cityBytes.length;


		byte[] nameBytes = ConversionUtility.stringListToByteArray(customer.getName(), Customer.NAME_MAX_LENGTH);
		System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
		index += nameBytes.length;

		if(index != dataBuffer.length)
		{
		throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");

		}
		return dataBuffer;

		}
		
		public static Customer byteArrayBlockToSupplier(byte[] byteArray) {
		    Customer customer = new Customer ();

		    if (byteArray.length != CUSTOMER_DATA_BLOCK_SIZE) {
		        throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
		    }

		    int index = 0;

		    // copy customer id
		    byte[] idBytes = new byte[Customer.ID_LENGTH];
		    System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
		    customer.setId(ConversionUtility.byteArrayToInteger(idBytes));
		    index += Customer.ID_LENGTH;

		    // copy Supplier Contact No
		    byte[] contactnoBytes = new byte[Customer.CONTACTNO_LENGTH];
		    System.arraycopy(byteArray, index, contactnoBytes, 0, contactnoBytes.length);
		    customer.setContactNo(ConversionUtility.byteArrayToString(contactnoBytes));
		    index += Customer.CONTACTNO_LENGTH;

		    // copy Supplier Email
		    byte[] emailBytes = new byte[Customer.EMAIL_MAX_LENGTH];
		    System.arraycopy(byteArray, index, emailBytes, 0, emailBytes.length);
		    customer.setEmail(ConversionUtility.byteArrayToString(emailBytes));
		    index += Customer.EMAIL_MAX_LENGTH;

		    // copy Supplier City
		    byte[] cityBytes = new byte[Customer.CITY_MAX_LENGTH];
		    System.arraycopy(byteArray, index, cityBytes, 0, cityBytes.length);
		    customer.setCity(ConversionUtility.byteArrayToStringList(cityBytes, Customer.CITY_MAX_LENGTH));
		    index += cityBytes.length;

		    // copy Supplier name
		    byte[] nameBytes = new byte[Customer.NAME_MAX_LENGTH];
		    System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
		    customer.setName(ConversionUtility.byteArrayToStringList(nameBytes, Customer.NAME_MAX_LENGTH));
		    index += nameBytes.length;

		    if (index != byteArray.length) {
		        throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		    }

		    if (customer.getId() == 0) {
		        return null;
		    } else {
		    	
		        return customer;
		        
		    }

	    }
	}

