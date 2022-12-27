import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

public class MedicalStoreManagement {

	

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat sekil = new SimpleDateFormat();
        Date tarih = new Date();
			while (true) 
			{ 
				 gotoxy(5, 5);
				 System.out.print("\t\t\tWelcome To Medical Store\n");
				    // Print the top border of the menu
				    System.out.print("+");
				    for (int i = 0; i < 106; i++) {
				      System.out.print("=");
				    }
				    System.out.println("+");

		
				    // Print the "Welcome To Medical Store" message
				    gotoxy(5, 6);
				    System.out.println("# 							                                                 #");

				    // Print the menu options
				    gotoxy(5, 7);
				    System.out.println("# 1-Supplier Info   2-Customer Info    3-Medicine    4-Report  5-Bill   6-About   7-Exit         	 # ");

				    // Print the blank lines
				    for (int i = 8; i <= 20; i++) {
				      gotoxy(5, i);
				      System.out.println("#                                                                             				 #");
				    }

				    // Print the "Press First Character" message
				    gotoxy(5, 21);
				    System.out.println("#   			 	        			   		              	 	  #");

				    // Print the bottom border of the menu
				    gotoxy(5, 22);
				    System.out.print("+");
				    for (int i = 0; i < 106; i++) {
				      System.out.print("=");
				    }
				    System.out.println("+");
			    
			  
	            System.out.print("\nEnter your choice: ");

	            int choice;
	            if (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please try again.");
	                continue;
	            }
	            choice = scanner.nextInt();
         
              
	            switch (choice) 
	            {
	                case 1:
	                	SupplierInfo();
	                    break;
	                case 2:
	                    CustomerInfo();
	                    break;
	                case 3:
	                    Medicine();
	                    break;
	                case 4:
	                	Report();
	                     break;
	                case 5:
	                	Bill();
	                	break;
	                case 6:
	                	About();
	                	break;
	                case 7:
	                	  System.exit(0);
	                    return;
	                    
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
              
	        }
	    }

	private static void gotoxy(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public static void SupplierInfo() {
		
		
		 gotoxy(5, 5);
		 System.out.print("\t\t\tSUPPLIER INFO\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("# 1-Add Supplier   2-Update Supplier    3-Search Supplier    4-List Supplier     5-Exit           	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("# 								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");
	    
	  
        System.out.print("\nEnter your choice: ");
		
		Scanner scanner = new Scanner(System.in);
		
        
        int choice;
        choice = scanner.nextInt();
      try {  
        switch (choice) 
        {
        case 1:
        	AddSupplier(scanner);
        	break;
        case 2:
        	UpdateSupplier(scanner);
        	break;
        case 3:
			searchSupplier();
        	break;
        case 4: 
        	listSupplier();
             SupplierInfo();
        	break;
        case 5:
        	
        	return;
        default:
        	System.out.println("Invalid choice. Please try again.");
            break;
        }
       }
      catch (IOException e) 
      {
    	   
    	   System.out.println("Invalid choice. Please try again.");
        	
       }
        
        		
        	
        
	}
	private static void listSupplier() throws IOException {
			
		String filePath21 = "Suppliers.dat";
		 int blockSize = Supplier.SUPPLIER_DATA_BLOCK_SIZE;
		 byte[] data21 = FileUtility.readAllBytes(filePath21);
          
		 gotoxy(5, 5);
		 System.out.print("\t\t\tSUPPLIER INFO\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i1 = 0; i1 < 106; i1++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("#                                                                                                 	 # ");

		    // Print the blank lines
		    for (int i1 = 8; i1 <= 20; i1++) {
		      gotoxy(5, i1);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   							   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i1 = 0; i1 < 106; i1++) {
		      System.out.print("=");
		    }
		    System.out.println("+");
		 
		 for (int i = 0; i < data21.length; i += blockSize) {
			 byte[] block = new byte[blockSize];
		     System.arraycopy(data21, i, block, 0, blockSize);
		     Supplier currentBook = Supplier.byteArrayBlockToSupplier(block);
		     
		     if(currentBook != null)
		     {
		    	
			    
		    	 System.out.println("Id: " + currentBook.getId());
			     System.out.println("Contact No: " + currentBook.getContactNo());
			     System.out.println("City: " + currentBook.getCity());
			     System.out.println("Email: " + currentBook.getEmail());
			     System.out.println("Name: " + currentBook.getName());

		     }
		 }	
		 
	}
	private static void searchSupplier() throws IOException {
		
		gotoxy(5, 5);
		 System.out.print("\t\t\tWelcome To Medical Store\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("#                            ENTER ID TO SEARCH SUPPLIER                            	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("="); 
		    }
		    System.out.println("+");
	    

		
		String filePath2 = "Suppliers.dat";
		Supplier supplier2 = new Supplier();
		System.out.print("Enter ID TO SEARCH SUPPLIER: ");
		Scanner scanner1 = new Scanner(System.in);
		int search = scanner1.nextInt();
		
		
		
		byte[] data2 = FileUtility.readBlock(search, Supplier.SUPPLIER_DATA_BLOCK_SIZE, filePath2);
		int blocksize = Supplier.SUPPLIER_DATA_BLOCK_SIZE;
		byte[] asd = ConversionUtility.intToByteArray(blocksize);
		
		for (int i = 0; i < data2.length; i += blocksize) {
		   
		    byte[] block = new byte[blocksize];
		    System.arraycopy(data2, i, block, 0, blocksize);
	 	    Supplier currentSupplier = Supplier.byteArrayBlockToSupplier(block);
		    
		    
		    if(currentSupplier == null) {
		    	System.out.println("Supplier not found.");
		    }
		    else {
		    	
		    	
		    System.out.println("Id: " + currentSupplier.getId());
		    System.out.println("Contact No: " + currentSupplier.getContactNo());
		    System.out.println("City: " + currentSupplier.getCity());
		    System.out.println("Email: " + currentSupplier.getEmail());
		    System.out.println("Name: " + currentSupplier.getName());
		    }
     	 
		}
	}
	
	
	private static void UpdateSupplier(Scanner scanner) throws IOException {
		
		gotoxy(5, 5);
		 System.out.print("\t\t\tWelcome To Medical Store\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("# 1-SUPPLIER ID   2-NEW CITY    3-NEW EMAIL ID    4-NEW SUPPLIER NAME  5-NEW CONTACT NO                     	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("="); 
		    }
		    System.out.println("+");
	    
	  
       System.out.print("\nEnter your choice: ");

		
		
		String filePath = "Suppliers.dat";
		Supplier supplier = new Supplier();
		System.out.print("Enter ID TO UPDATE SUPPLIER: ");
		Scanner scanner2 = new Scanner(System.in);
		int update = scanner.nextInt();
		
		byte[] data2 = FileUtility.readBlock(update, Supplier.SUPPLIER_DATA_BLOCK_SIZE, filePath);
		int blocksize = Supplier.SUPPLIER_DATA_BLOCK_SIZE;
		
		for (int i = 0; i < data2.length; i += blocksize) {
			
			byte[] block = new byte[blocksize];
		    System.arraycopy(data2, i, block, 0, blocksize);
		    Supplier currentSupplier = Supplier.byteArrayBlockToSupplier(block);
		    
		    if(currentSupplier == null) {
		    	System.out.println("Supplier not found.");
		    }
		    else {
		    	System.out.println("Id: " + currentSupplier.getId());
			    System.out.println("Contact No: " + currentSupplier.getContactNo());
			    System.out.println("City: " + currentSupplier.getCity());
			    System.out.println("Email: " + currentSupplier.getEmail());
			    System.out.println("Name: " + currentSupplier.getName());
			
			    
			    
			    System.out.print("SUPPLIER ID: ");
				int id2 = scanner.nextInt();
			    Supplier supplier2 = new Supplier();
			    System.out.print("NEW City: ");
				String city = scanner.next();
				System.out.print("NEW EMAIL ID: ");
				String mail = scanner.next();
				System.out.print("NEW Supplier Name: ");
				String name = scanner.next();
				System.out.print("NEW CONTACT NO.: ");
				String phone = scanner.next();
				
				List<String> city1 = new ArrayList<>();
				List<String> Name = new ArrayList<>();
				city1.add(city);
				Name.add(name);
				
				supplier2.setId(id2);
				supplier2.setCity(city1);
				supplier2.setEmail(mail);
				supplier2.setName(Name);
				supplier2.setContactNo(phone);
				
				byte [] data = Supplier.supplierToByteArrayBlock(supplier2);
				FileUtility.appendBlock( id2, Supplier.SUPPLIER_DATA_BLOCK_SIZE, filePath, data);
				
				System.out.println("Supplier updated successfully.");
		    	
		    }
		}
		
		
		
	}
	public static void AddSupplier(Scanner scanner) throws IOException {
		
		gotoxy(5, 5);
		 System.out.print("\t\t\tADD SUPPLIER\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("# 1-SUPPLIER ID  2-CITY   3-EMAIL ID    4-SUPPLIER NAME  5-CONTACT NO                          	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		
		
		System.out.print("SUPPLIER ID: ");
		int id = scanner.nextInt();
		System.out.print("City: ");
		String city = scanner.next();
		System.out.print("EMAIL ID: ");
		String mail = scanner.next();
		System.out.print("Supplier Name: ");
		String name = scanner.next();
		System.out.print("CONTACT NO.: ");
		String phone = scanner.next();
		
		List<String> city1 = new ArrayList<>();
		List<String> Name = new ArrayList<>();
		city1.add(city);
		Name.add(name);
		
		Supplier supplier = new Supplier();
		supplier.setId(id);
		supplier.setCity(city1);
		supplier.setEmail(mail);
		supplier.setName(Name);
		supplier.setContactNo(phone);
		
		
		byte [] data = Supplier.supplierToByteArrayBlock(supplier);
    	String filePath = "Suppliers.dat";
    	FileUtility.appendBlock(id, Supplier.SUPPLIER_DATA_BLOCK_SIZE, filePath, data );
	}
	
	
	public static void CustomerInfo() throws IOException 
	{
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sekil = new SimpleDateFormat();
        Date tarih = new Date();
			while (true) 
			{ 
				 gotoxy(5, 5);
				 System.out.print("\t\t\tCUSTOMER INFO\n");
				    // Print the top border of the menu
				    System.out.print("+");
				    for (int i = 0; i < 106; i++) {
				      System.out.print("=");
				    }
				    System.out.println("+");

				    // Print the "Welcome To Medical Store" message
				    gotoxy(5, 6);
				    System.out.println("# 							                                                 #");

				    // Print the menu options
				    gotoxy(5, 7);
				    System.out.println("# 1-Add New Customer   2-Update Customer     3-Search Customer    4-List Of Existing Customer   5-Main Menu                    	 # ");

				    // Print the blank lines
				    for (int i = 8; i <= 20; i++) {
				      gotoxy(5, i);
				      System.out.println("#                                                                             				 #");
				    }

				    // Print the "Press First Character" message
				    gotoxy(5, 21);
				    System.out.println("#   			 	        			   		              	 	  #");

				    // Print the bottom border of the menu
				    gotoxy(5, 22);
				    System.out.print("+");
				    for (int i = 0; i < 106; i++) {
				      System.out.print("=");
				    }
				    System.out.println("+");
			    
			  
	            System.out.print("\nEnter your choice: ");
	            
	            int choices;
	            if (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please try again.");
	                continue;
	            }
	            choices = scanner.nextInt();
         
              
	            switch (choices) 
	            {
	                case 1:
	                	AddNewCustomer();
	                    break;
	                case 2:
	                    UpdateCustomer();
	                    break;
	                case 3:
	                    SearchCustomer();
	                    break;
	                case 4:
	                	ListOfExistingCustomer();
	                     break;
	                case 5:
	                	  System.exit(0);
	                    return;
	                    
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
              

	                  
			
			}
	            
	         	            		
		
	}
	
	public static void ListOfExistingCustomer()  throws IOException {
		
	String filePath21 = "Customers.dat";
	 int blockSize = Customer.CUSTOMER_DATA_BLOCK_SIZE;
	 byte[] data21 = FileUtility.readAllBytes(filePath21);
      
	 gotoxy(5, 5);
	 System.out.print("\t\t\tCUSTOMER LIST\n");
	    // Print the top border of the menu
	    System.out.print("+");
	    for (int i1 = 0; i1 < 106; i1++) {
	      System.out.print("=");
	    }
	    System.out.println("+");

	    // Print the "Welcome To Medical Store" message
	    gotoxy(5, 6);
	    System.out.println("# 							                                                 #");

	    // Print the menu options
	    gotoxy(5, 7);
	    System.out.println("#                                                                                                 	 # ");

	    // Print the blank lines
	    for (int i1 = 8; i1 <= 20; i1++) {
	      gotoxy(5, i1);
	      System.out.println("#                                                                             				 #");
	    }

	    // Print the "Press First Character" message
	    gotoxy(5, 21);
	    System.out.println("#   							   		              	 	  #");

	    // Print the bottom border of the menu
	    gotoxy(5, 22);
	    System.out.print("+");
	    for (int i1 = 0; i1 < 106; i1++) {
	      System.out.print("=");
	    }
	    System.out.println("+");
	 
	 for (int i = 0; i < data21.length; i += blockSize) {
		 byte[] block = new byte[blockSize];
	     System.arraycopy(data21, i, block, 0, blockSize);
	     Customer currentBook = Customer.byteArrayBlockToSupplier(block);
	     
	     if(currentBook != null)
	     {
	    	
		    
	    	 System.out.println("Id: " + currentBook.getId());
		     System.out.println("Contact No: " + currentBook.getContactNo());
		     System.out.println("City: " + currentBook.getCity());
		     System.out.println("Email: " + currentBook.getEmail());
		     System.out.println("Name: " + currentBook.getName());

	     }
	 }	
	 
}
	

	public static void SearchCustomer() throws IOException 
	{
		gotoxy(5, 5);
		 System.out.print("\t\t\tWelcome To Medical Store\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("#                            ENTER ID TO SEARCH CUSTOMER                            	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("="); 
		    }
		    System.out.println("+");
	    

		
		String filePath2 = "Customers.dat";
		Customer customer2 = new Customer();
		System.out.print("Enter ID TO SEARCH CUSTOMER: ");
		Scanner scanner1 = new Scanner(System.in);
		int search = scanner1.nextInt();
		
		
		
		byte[] data2 = FileUtility.readBlock(search, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath2);
		int blocksize = Customer.CUSTOMER_DATA_BLOCK_SIZE;
		byte[] asd = ConversionUtility.intToByteArray(blocksize);
		
		for (int i = 0; i < data2.length; i += blocksize) {
		   
		    byte[] block = new byte[blocksize];
		    System.arraycopy(data2, i, block, 0, blocksize);
	 	    Customer currentCustomer = Customer.byteArrayBlockToSupplier(block);
		    
		    
		    if(currentCustomer == null) {
		    	System.out.println("Supplier not found.");
		    }
		    else {
		    	
		    	
		    System.out.println("Id: " + currentCustomer.getId());
		    System.out.println("Contact No: " + currentCustomer.getContactNo());
		    System.out.println("City: " + currentCustomer.getCity());
		    System.out.println("Email: " + currentCustomer.getEmail());
		    System.out.println("Name: " + currentCustomer.getName());
		    }
    	 
		}
		
	}

	public static void UpdateCustomer() throws IOException 
	{
		gotoxy(5, 5);
		 System.out.print("\t\t\tUPDATE CUSTOMER\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("# 1-CUSTOMER ID   2-NEW CITY    3-NEW EMAIL ID    4-NEW CUSTOMER NAME  5-NEW CONTACT NO                     	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("="); 
		    }
		    System.out.println("+");
	    
	  
     

		
      Scanner scanner1 = new Scanner(System.in);
		String filePath = "Customers.dat";
		Customer customer = new Customer();
		System.out.print("Enter ID TO UPDATE CUSTOMER: ");
		Scanner scanner2 = new Scanner(System.in);
		int update = scanner1.nextInt();
		
		byte[] data2 = FileUtility.readBlock(update, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath);
		int blocksize = Customer.CUSTOMER_DATA_BLOCK_SIZE;
		
		for (int i = 0; i < data2.length; i += blocksize) {
			
			byte[] block = new byte[blocksize];
		    System.arraycopy(data2, i, block, 0, blocksize);
		    Customer currentCustomer = Customer.byteArrayBlockToSupplier(block);
		    
		    if(currentCustomer == null) {
		    	System.out.println("Customer not found.");
		    }
		    else {
		    	System.out.println("Id: " + currentCustomer.getId());
			    System.out.println("Contact No: " + currentCustomer.getContactNo());
			    System.out.println("City: " + currentCustomer.getCity());
			    System.out.println("Email: " + currentCustomer.getEmail());
			    System.out.println("Name: " + currentCustomer.getName());
			
			    
			    
			    System.out.print("CUSTOMER ID: ");
				int id2 = scanner1.nextInt();
			    Customer customer2 = new Customer();
			    System.out.print("NEW City: ");
				String city = scanner1.next();
				System.out.print("NEW EMAIL ID: ");
				String mail = scanner1.next();
				System.out.print("NEW Customer Name: ");
				String name = scanner1.next();
				System.out.print("NEW CONTACT NO.: ");
				String phone = scanner1.next();
				
				List<String> city1 = new ArrayList<>();
				List<String> Name = new ArrayList<>();
				city1.add(city);
				Name.add(name);
				
				customer2.setId(id2);
				customer2.setCity(city1);
				customer2.setEmail(mail);
				customer2.setName(Name);
				customer2.setContactNo(phone);
				
				byte [] data = Customer.customerToByteArrayBlock(customer2);
				FileUtility.appendBlock( id2, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath, data);
				
				System.out.println("Customer updated successfully.");
				}
		    }
		    
		
	}

	public static void AddNewCustomer()  
	{
		gotoxy(5, 5);
		 System.out.print("\t\t\tADD CUSTOMER\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("# 1-CUSTOMER ID  2-CITY   3-EMAIL ID    4-CUSTOMER NAME  5-CONTACT NO                          	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		
		Scanner scannerx = new Scanner(System.in);
		System.out.print("CUSTOMER ID: ");
		int id = scannerx.nextInt();
		System.out.print("City: ");
		String city = scannerx.next();
		System.out.print("EMAIL ID: ");
		String mail = scannerx.next();
		System.out.print("CUSTOMER Name: ");
		String name = scannerx.next();
		System.out.print("CONTACT NO.: ");
		String phone = scannerx.next();
		
		List<String> city1 = new ArrayList<>();
		List<String> Name = new ArrayList<>();
		city1.add(city);
		Name.add(name);
		
		Customer customer = new Customer();
		customer.setId(id);
		customer.setCity(city1);
		customer.setEmail(mail);
		customer.setName(Name);
		customer.setContactNo(phone);
		
		
		byte [] data = Customer.customerToByteArrayBlock(customer);
   	String filePath = "Customers.dat";
   	FileUtility.appendBlock(id, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath, data );
	
		
	}

	public static void Medicine() throws IOException 
	{
		Scanner scannera = new Scanner(System.in);
		
		SimpleDateFormat sekil = new SimpleDateFormat();
        Date tarih = new Date();
		
		
		gotoxy(5, 5);
		 System.out.print("\t\t\tMEDICINE\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");


		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("# 1-Purchase New Medicine   2-Sale Medicine    3-Stock Of Medicine    4-Search Medicine 5-Main Menu                                         	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   			 	        			   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");
	    
	  
       System.out.print("\nEnter your choice: ");

       int choice;
   
	if (!scannera.hasNextInt()) {
           System.out.println("Invalid input. Please try again.");
          
       }
       choice = scannera.nextInt();

     
       switch (choice) 
       {
           case 1:
            	PurchaseNewMedicine(scannera);
               break;
           case 2:
               SaleMedicine();
               break;
           case 3:
               StockOfMedicine();
               break;
           case 4:
        	   SearchMedicine();
        	   break;
           case 5:
           	  System.exit(0);
               return;
               
           default:
               System.out.println("Invalid choice. Please try again.");
               break;
       }
     
   
	}
	
	public static void SearchMedicine() throws IOException
    {
		gotoxy(5, 5);
		 System.out.print("\t\t\tSEARCH MEDICINE\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("#                            ENTER ID TO SEARCH MEDICINE                            	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("="); 
		    }
		    System.out.println("+");
	    

		
		String filePath2 = "Medicine.dat";
		Medicine medicine2 = new Medicine();
		System.out.print("Enter ID TO SEARCH MEDICINE: ");
		Scanner scanner1 = new Scanner(System.in);
		int search = scanner1.nextInt();
		
		
		
		byte[] data2 = FileUtility.readBlock(search, Medicine.MEDICINE_DATA_BLOCK_SIZE, filePath2);
		int blocksize = Medicine.MEDICINE_DATA_BLOCK_SIZE;
		byte[] asd = ConversionUtility.intToByteArray(blocksize);
		
		for (int i = 0; i < data2.length; i += blocksize) {
		   
		    byte[] block = new byte[blocksize];
		    System.arraycopy(data2, i, block, 0, blocksize);
	 	    Medicine currentMedicine = Medicine.byteArrayBlockToMedicine(block);
		    
		    
		    if(currentMedicine == null) {
		    	System.out.println("Medicine not found.");
		    }
		    else {
		    	
		    	
		    	System.out.println("Id: " + currentMedicine.getId());
			    System.out.println("Rack No: " + currentMedicine.getRackNo());
			    System.out.println("Company Name: " + currentMedicine.getCompanyName());
			    System.out.println("Unit Cost: " + currentMedicine.getUnitCost());
			    System.out.println("Quantity: " + currentMedicine.getQuantity());
			    System.out.println("Medicine Name: " + currentMedicine.getMedicineName());
			    System.out.println("Cabnıt No: " + currentMedicine.getCabnıtNo());
			    System.out.println("Supplier Name: " + currentMedicine.getSupplierName());
			    System.out.println("Sale Cost: " + currentMedicine.getSaleCost());
		    }
   	 
		}
	}

	public static void PurchaseNewMedicine(Scanner scanner) 
	{
		 {
			
			gotoxy(5, 5);
			 System.out.print("\t\t\tPURCHASE NEW MEDICINE\n");
			    // Print the top border of the menu
			    System.out.print("+");
			    for (int i = 0; i < 106; i++) {
			      System.out.print("=");
			    }
			    System.out.println("+");

			    // Print the "Welcome To Medical Store" message
			    gotoxy(5, 6);
			    System.out.println("# 							                                                 #");

			    // Print the menu options
			    gotoxy(5, 7);
			    System.out.println("# 1-MEDICINE ID  2-ENTER RACK NO   3-COMPANY NAME    4-UNIT COST  5-QUANTITY  6-MEDICINE NAME  7-CABNIT NO  8-SUPPLIER NAME  9-SALE COST                        	 # ");

			    // Print the blank lines
			    for (int i = 8; i <= 20; i++) {
			      gotoxy(5, i);
			      System.out.println("#                                                                             				 #");
			    }

			    // Print the "Press First Character" message
			    gotoxy(5, 21);
			    System.out.println("#   								   		              	 	  #");

			    // Print the bottom border of the menu
			    gotoxy(5, 22);
			    System.out.print("+");
			    for (int i = 0; i < 106; i++) {
			      System.out.print("=");
			    }
			    System.out.println("+");

			
			
			System.out.print("MEDICINE ID: ");
			int id = scanner.nextInt();
			System.out.print("ENTER RACK NO: ");
			int rackNo = scanner.nextInt();
			System.out.print("COMPANY NAME: ");
			String companyname = scanner.next();
			System.out.print("UNIT COST: ");
			int unitcost = scanner.nextInt();
			System.out.print("QUANTITY: ");
			int quantity = scanner.nextInt();
			System.out.print("MEDICINE NAME: ");
			String medicinename = scanner.next();
			System.out.print("CABNIT NO: ");
			int cabnıtno = scanner.nextInt();
			System.out.print("SUPPLIER NAME: ");
			String suppliername = scanner.next();
			System.out.print("SALE COST: ");
			int salecost = scanner.nextInt();
			
			

			
			Medicine medicine = new Medicine();
			medicine.setId(id);
			medicine.setRackNo(rackNo);
			medicine.setCompanyName(companyname);
			medicine.setUnitCost(unitcost);
			medicine.setQuantity(quantity);
			medicine.setMedicineName(medicinename);
            medicine.setCabnıtNo(cabnıtno);
            medicine.setSupplierName(suppliername);
            medicine.setSaleCost(salecost);
			
			byte [] data = Medicine.medicineToByteArrayBlock(medicine);
	    	String filePath = "Medicine.dat";
	    	FileUtility.appendBlock(id, Medicine.MEDICINE_DATA_BLOCK_SIZE , filePath, data );
	    	}
		
		
	}
	
	public static void SaleMedicine() throws IOException 
	{
		gotoxy(5, 5);
		 System.out.print("\t\t\tSALE MEDICINE\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("# 1-CUSTOMER ID   2-NEW CITY    3-NEW EMAIL ID    4-NEW CUSTOMER NAME  5-NEW CONTACT NO                     	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("="); 
		    }
		    System.out.println("+");
	    
	  
    

		
        Scanner scanner1 = new Scanner(System.in);
		String filePath = "Medicine.dat";
		Medicine medicine = new Medicine();
		System.out.print("Enter ID TO SALE MEDICINE: ");
		Scanner scanner2 = new Scanner(System.in);
		int update = scanner1.nextInt();
		
		byte[] data2 = FileUtility.readBlock(update, medicine.MEDICINE_DATA_BLOCK_SIZE, filePath);
		int blocksize = Medicine.MEDICINE_DATA_BLOCK_SIZE;
		
		for (int i = 0; i < data2.length; i += blocksize) {
			
			byte[] block = new byte[blocksize];
		    System.arraycopy(data2, i, block, 0, blocksize);
		    Medicine currentMedicine = Medicine.byteArrayBlockToMedicine(block);
		    

		    
		    
		    if(currentMedicine == null) {
		    	System.out.println("Medicine not found.");
		    }
		    else {
		    	System.out.println("Id: " + currentMedicine.getId());
			    System.out.println("Rack No: " + currentMedicine.getRackNo());
			    System.out.println("Company Name: " + currentMedicine.getCompanyName());
			    System.out.println("Unit Cost: " + currentMedicine.getUnitCost());
			    System.out.println("Quantity: " + currentMedicine.getQuantity());
			    System.out.println("Medicine Name: " + currentMedicine.getMedicineName());
			    System.out.println("Cabnıt No: " + currentMedicine.getCabnıtNo());
			    System.out.println("Supplier Name: " + currentMedicine.getSupplierName());
			    System.out.println("Sale Cost: " + currentMedicine.getSaleCost());
			    
			    
			    
			    System.out.print("MEDICINE ID: ");
				int id2 = scanner1.nextInt();
			    Medicine medicine2 = new Medicine();
			    System.out.print("NEW RACK NO: ");
				int rackno = scanner1.nextInt();
				System.out.print("NEW COMPANY NAME: ");
				String companyname = scanner1.next();
				System.out.print("NEW UNIT COST: ");
				int unitcost = scanner1.nextInt();
				System.out.print("NEW QUANTITY: ");			
			    int quantity = scanner1.nextInt();
				System.out.print("NEW MEDICINE NAME ");
				String medicinename = scanner1.next();
				System.out.print("NEW CABNIT NO.: ");
				int cabnıtno = scanner1.nextInt();
				System.out.print("NEW SUPPLIER NAME ");
				String suppliername = scanner1.next();
				System.out.print("NEW SALE COST: ");
				int salecost = scanner1.nextInt();
				
				
				
				
				
				medicine2.setId(id2);
				medicine2.setRackNo(rackno);
				medicine2.setCompanyName(companyname);
				medicine2.setUnitCost(unitcost);
				medicine2.setQuantity(quantity);
				medicine2.setMedicineName(medicinename);
				medicine2.setCabnıtNo(cabnıtno);
				medicine2.setSupplierName(suppliername);
				medicine2.setSaleCost(salecost);
				
				
				
				
				byte [] data = Medicine.medicineToByteArrayBlock(medicine2);
				FileUtility.appendBlock( id2, Customer.CUSTOMER_DATA_BLOCK_SIZE, filePath, data);
				
				System.out.println("Customer updated successfully.");
				}
		    }
		
		
		
		
	}
	
	public static void StockOfMedicine() throws IOException 
	{
		String filePath21 = "Medicine.dat";
		 int blockSize = Medicine.MEDICINE_DATA_BLOCK_SIZE;
		 byte[] data21 = FileUtility.readAllBytes(filePath21);
         
		 gotoxy(5, 5);
		 System.out.print("\t\t\tSTOCK OF MEDICINE\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i1 = 0; i1 < 106; i1++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.println("#                                                                                                 	 # ");

		    // Print the blank lines
		    for (int i1 = 8; i1 <= 20; i1++) {
		      gotoxy(5, i1);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   							   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i1 = 0; i1 < 106; i1++) {
		      System.out.print("=");
		    }
		    System.out.println("+");
		 
		 for (int i = 0; i < data21.length; i += blockSize) {
			 byte[] block = new byte[blockSize];
		     System.arraycopy(data21, i, block, 0, blockSize);
		     Medicine currentBook = Medicine.byteArrayBlockToMedicine(block);
		     
		     if(currentBook != null)
		     {
		    	
			    
			    	System.out.println("Id: " + currentBook.getId());
				    System.out.println("Rack No: " + currentBook.getRackNo());
				    System.out.println("Company Name: " + currentBook.getCompanyName());
				    System.out.println("Unit Cost: " + currentBook.getUnitCost());
				    System.out.println("Quantity: " + currentBook.getQuantity());
				    System.out.println("Medicine Name: " + currentBook.getMedicineName());
				    System.out.println("Cabnıt No: " + currentBook.getCabnıtNo());
				    System.out.println("Supplier Name: " + currentBook.getSupplierName());
				    System.out.println("Sale Cost: " + currentBook.getSaleCost());
				    
		     }
		 }	
		
	}
	
	
	
	
	
	
	
	
	public static void Report() 
	{
		
		
	}
	
	public static void Bill() 
	{
		
		
	}
	
	public static void About() 
	{
		gotoxy(5, 5);
		 System.out.print("\t\t\tABOUT MEDICAL STORE\n");
		    // Print the top border of the menu
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("=");
		    }
		    System.out.println("+");

		    // Print the "Welcome To Medical Store" message
		    gotoxy(5, 6);
		    System.out.println("# 							                                                 #");

		    // Print the menu options
		    gotoxy(5, 7);
		    System.out.print("#  ==>This project is about medical store"
		    		+ " ==>In this project we can add medicine, customer, supplier details"
		    		+ "==>We can modified & delete existing record"
		    		+ "==> We can also search medicine, customer, supplier details"
		    		+ "==>It's helpfull for display stock of medicine  "
		    		+ "                                                                  	 # ");

		    // Print the blank lines
		    for (int i = 8; i <= 20; i++) {
		      gotoxy(5, i);
		      System.out.println("#                                                                             				 #");
		    }

		    // Print the "Press First Character" message
		    gotoxy(5, 21);
		    System.out.println("#   								   		              	 	  #");

		    // Print the bottom border of the menu
		    gotoxy(5, 22);
		    System.out.print("+");
		    for (int i = 0; i < 106; i++) {
		      System.out.print("="); 
		    }
		    System.out.println("+");
		    }
	
}

