//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * Main interactive driver for software
 * @author Sam
 *
 */
public class Driver {
	private static Database data;
	private static final String FILENAME="database.obj";
	/**
	 * Loads database.obj if available
	 */
	private static void loadFile(){
		try {
		  //If file is found, open it
		  FileInputStream   file = new FileInputStream(FILENAME);
		  ObjectInputStream fin  = new ObjectInputStream(file);
		  data = (Database) fin.readObject();
		  file.close();
		} catch(Exception e){data = new Database();System.out.println("Database file not found. Initializing new database...\n");}
	}
	/**
	 * Saves database.obj
	 */
	private static void saveFile(){
		try {
			  FileOutputStream   file = new FileOutputStream(FILENAME);
			  ObjectOutputStream fout = new ObjectOutputStream(file);
			  fout.writeObject(data);
			  fout.close();
			} catch(Exception e) {System.out.println("Save fail."); }
	}
	/**
	 * Main interactive program with menu for using software
	 * @param args
	 */
public static void main(String[] args){
		
		System.out.println("Welcome.\n");
		loadFile();
		Scanner input = new Scanner(System.in);
		String option ="";
		
		while(!option.equalsIgnoreCase("Q")){
		System.out.print("Please select an option from the menu:\n\n C - Add Customer\n I - Add Item\n S - Record a Sale\n R - Record a Return\nVC - View Customers\nVI - View Items\nVT - View Transactions\n Q - Quit\n\nPlease select an option: ");
		option = input.nextLine();
		
		if(option.length()>2 || !option.equalsIgnoreCase("C")&&!option.equalsIgnoreCase("I")
				&&!option.equalsIgnoreCase("S")&&!option.equalsIgnoreCase("R")
				&&!option.equalsIgnoreCase("VC")&&!option.equalsIgnoreCase("VI")&&!option.equalsIgnoreCase("VT")
				&&!option.equalsIgnoreCase("Q")){
		System.out.println("\nInvalid input, try again\n");
		}
		else{
				if(option.equalsIgnoreCase("C")){
					Scanner in = new Scanner(System.in);
					System.out.print("Enter the customer's name: ");
					String a = in.nextLine();
					System.out.print("Enter the customer's street address: ");
					String b = in.nextLine();
					System.out.print("Enter the customer's city, state, and zip code: ");
					String c = in.nextLine();
					if(data.addCustomer(a,b,c)){
					System.out.println("\nCustomer added. ID# "+data.returnCustomerId()+"\n");
					}
					else{
						System.out.println("\nAdding customer failed. Try again.\n");
					}
				}
				if(option.equalsIgnoreCase("I")){
					Scanner in = new Scanner(System.in);
					System.out.print("\nEnter the item's name: ");
					String a = in.nextLine();
					System.out.print("Enter the item's quantity: ");
					int b = in.nextInt();
					if(data.addItem(a,b)){
						System.out.println("\nItem added. ID# "+data.returnItemId()+"\n");
						}
						else{
							System.out.println("\nAdding item failed. Try again.\n");
						}
				}
				if(option.equalsIgnoreCase("S")){
					Item temp;
					
					Scanner in = new Scanner(System.in);
					System.out.print("\nEnter the customer's MemberID:");
					int a = in.nextInt();
					if(data.searchMemberId(a)==null){
						System.out.println("\nError: Member "+a+" was not found in the database");
					}
					else{
					System.out.print("Enter the itemID:");
					int b = in.nextInt();
					if((temp=data.searchItemId(b))==null){
							System.out.println("\nError: Item "+b+" was not found in the database");
					}
					else{
					System.out.print("Enter the quantity: ");
					int c = in.nextInt();
					System.out.print("Enter the transaction date: ");
					Scanner str = new Scanner(System.in);
					String d = str.nextLine();
					if(temp.getQuantity()<c){
						System.out.print("\nItem out of stock.\n");
					}
					else{
					if(data.addTransaction(a,b,d,c, 1)){
						temp.setQuantity(-c);
						System.out.println("\nTransaction added. ID# "+data.returnTransactionId()+"\n");
						}
						else{
							System.out.println("\nRecording sale failed. Try again.\n");
						}
					}
					}
					}
				}
				if(option.equalsIgnoreCase("R")){
					Scanner in = new Scanner(System.in);
					System.out.print("\nEnter the customer's memberID: ");
					int a = in.nextInt();
					System.out.print("Enter the itemID: ");
					int b = in.nextInt();
					System.out.print("Enter the quantity: ");
					int c = in.nextInt();
					if(data.searchTran(a,b)==null){
						System.out.println("\nError: There is no matching purchase in the database. Return cannot be processed.\n");
					}
					else{
						if(c<1){
							System.out.println("\nError: Cannot return 0.");
						}
						else{
						if(data.history(a,b)<c){
							System.out.println("\nError: There is no matching purchase in the database. Return cannot be processed.");
						}
						else{
							System.out.print("Enter the transaction date: ");
							Scanner str = new Scanner(System.in);
							String d = str.nextLine();
							if(data.addTransaction(a, b, d, c,0)){
								data.searchItemId(b).setQuantity(c);
								System.out.println("\nItem returned, transaction added. ID# "+data.returnTransactionId()+"\n");
							}
							else{
								System.out.println("\nReturn failed. Try again.\n");
							}
							
						}
					}
					}
					
				}
				if(option.equalsIgnoreCase("VC")){
					String a ="";
					ArrayList<Customer> customer = data.getCustomer();
					Collections.sort(customer);
					System.out.printf("\n%s   %9s   %21s %17s\n","MemberID","Name","Street Address","City");
					System.out.printf("%s   %13s   %s   %s\n","--------","-------------","--------------------","--------------------");
					for(int i=0;i<customer.size();i++){
						Customer temp = customer.get(i);
						System.out.printf(" %-7d   %-13s   %-20s   %-20s\n",temp.getMemberId(),temp.getName(),temp.getStreetAddress(),temp.getCity());
					}
					while(!a.equalsIgnoreCase("M")){
					
					System.out.print("\nNA) Sort by Name in Ascending Order\nND) Sort by Name in Descending order\n M) Return to Main Menu\n\nPlease select an option: ");
					Scanner in = new Scanner(System.in);
					a = in.nextLine();
					if(a.equalsIgnoreCase("NA")){
					Collections.sort(customer, new AscNameComparator());
					System.out.printf("\n%s   %9s   %21s %17s\n","MemberID","Name","Street Address","City");
					System.out.printf("%s   %13s   %s   %s\n","--------","-------------","--------------------","--------------------");
					for(int i=0;i<customer.size();i++){
						Customer temp = customer.get(i);
						System.out.printf(" %-7d   %-13s   %-20s   %-20s\n",temp.getMemberId(),temp.getName(),temp.getStreetAddress(),temp.getCity());
					}
					}
					else if(a.equalsIgnoreCase("ND")){
					Collections.sort(customer, new DesNameComparator());
					System.out.printf("\n%s   %9s   %21s %17s\n","MemberID","Name","Street Address","City");
					System.out.printf("%s   %13s   %s   %s\n","--------","-------------","--------------------","--------------------");
					for(int i=0;i<customer.size();i++){
						Customer temp = customer.get(i);
						System.out.printf(" %-7d   %-13s   %-20s   %-20s\n",temp.getMemberId(),temp.getName(),temp.getStreetAddress(),temp.getCity());
					}
					}
					else if(a.equalsIgnoreCase("M")){	
					}
					else{
						System.out.println("\nInvalid Input, Try Again.");
					}
					}
				}
				if(option.equalsIgnoreCase("VI")){
					String a ="";
					ArrayList<Item> item = data.getItem();
					Collections.sort(item);
					System.out.printf("\n%s    %-13s   %s\n","ItemID","Item Name","Quantity");
					System.out.printf("%s   %s   %s\n","------","--------------","--------");
					for(int i=0;i<item.size();i++){
						Item temp = item.get(i);
						System.out.printf(" %d    %-13s   %8d\n",temp.getItemNumber(),temp.getItemName(),temp.getQuantity());
					}
					while(!a.equalsIgnoreCase("M")){
						Scanner in = new Scanner(System.in);
						System.out.print("\nID) Sort by ItemID in Descending Order\nNA) Sort by Item Name in Ascending Order\nQA) Sort by Quantity in Ascending Order\n M) Return to Main Menu\n\nPlease select an option: ");
						a = in.nextLine();
						if(a.equalsIgnoreCase("ID")){
							Collections.sort(item, new DesItemIDComparator());
							System.out.printf("\n%s    %-13s   %s\n","ItemID","Item Name","Quantity");
							System.out.printf("%s   %s   %s\n","------","--------------","--------");
							for(int i=0;i<item.size();i++){
								Item temp = item.get(i);
								System.out.printf(" %d    %-13s   %8d\n",temp.getItemNumber(),temp.getItemName(),temp.getQuantity());
							}
						}
						else if(a.equalsIgnoreCase("NA")){
							Collections.sort(item, new AscItemNameComparator());
							System.out.printf("\n%s    %-13s   %s\n","ItemID","Item Name","Quantity");
							System.out.printf("%s   %s   %s\n","------","--------------","--------");
							for(int i=0;i<item.size();i++){
								Item temp = item.get(i);
								System.out.printf(" %d    %-13s   %8d\n",temp.getItemNumber(),temp.getItemName(),temp.getQuantity());
							}
						}
						else if(a.equalsIgnoreCase("QA")){
							Collections.sort(item, new AscQuantityComparator());
							System.out.printf("\n%s    %-13s   %s\n","ItemID","Item Name","Quantity");
							System.out.printf("%s   %s   %s\n","------","--------------","--------");
							for(int i=0;i<item.size();i++){
								Item temp = item.get(i);
								System.out.printf(" %d    %-13s   %8d\n",temp.getItemNumber(),temp.getItemName(),temp.getQuantity());
							}
						}
						else if(a.equalsIgnoreCase("M")){
						}
						else{
							System.out.println("\nInvalid Input, Try Again.");
						}
					}
					
				}
				if(option.equalsIgnoreCase("VT")){
					String a ="";
					ArrayList<Transaction> transaction = data.getTransaction();
					Collections.sort(transaction);
					System.out.printf("\n%13s    %8s       %-16s    %8s       %-6s\n","TransactionID","MemberID","Item Name","Quantity","Date");
					System.out.printf("%s    %s      %s     %s    %s\n","-------------","--------","----------------","--------","---------");
					for(int i=0;i<transaction.size();i++){
						Transaction temp = transaction.get(i);
						int quantity = temp.getQuantity();
						if(temp.purchase==0)quantity=quantity*-1;
						System.out.printf("\n     %-8d      %-6d      %-16s         %4d     %8s",temp.getTransactionId(),temp.getMemberId(),temp.getItemName(),quantity,temp.getDate());
					}
					
					while(!a.equalsIgnoreCase("M")){
						Scanner in = new Scanner(System.in);
						System.out.println("\nMA) Sort by MemberID in Ascending Order\nMD) Sort by MemberID in Descending Order\nIA) Sort by Item Name in Ascending Order\nID) Sort by Item Name in Descending Order\n M) Return to Main Menu\nPlease select an option: ");
						a = in.nextLine();
						
						if(a.equalsIgnoreCase("MA")){
						Collections.sort(transaction, new AscMemberIdComparator());	
						System.out.printf("\n%13s    %8s       %-16s    %8s       %-6s\n","TransactionID","MemberID","Item Name","Quantity","Date");
						System.out.printf("%s    %s      %s     %s    %s\n","-------------","--------","----------------","--------","---------");
						for(int i=0;i<transaction.size();i++){
							Transaction temp = transaction.get(i);
							int quantity = temp.getQuantity();
							if(temp.purchase==0)quantity=quantity*-1;
							System.out.printf("\n     %-8d      %-6d      %-16s         %4d     %8s",temp.getTransactionId(),temp.getMemberId(),temp.getItemName(),quantity,temp.getDate());}
						}
						else if(a.equalsIgnoreCase("MD")){
						Collections.sort(transaction, new AscMemberIdComparator());
						System.out.printf("\n%13s    %8s       %-16s    %8s       %-6s\n","TransactionID","MemberID","Item Name","Quantity","Date");
						System.out.printf("%s    %s      %s     %s    %s\n","-------------","--------","----------------","--------","---------");
						for(int i=transaction.size()-1;i>=0;i--){
							Transaction temp = transaction.get(i);
							int quantity = temp.getQuantity();
							if(temp.purchase==0)quantity=quantity*-1;
							System.out.printf("\n     %-8d      %-6d      %-16s         %4d     %8s",temp.getTransactionId(),temp.getMemberId(),temp.getItemName(),quantity,temp.getDate());}
						}
						else if(a.equalsIgnoreCase("IA")){
						Collections.sort(transaction, new ItemNameAscComparator());
						System.out.printf("\n%13s    %8s       %-16s    %8s       %-6s\n","TransactionID","MemberID","Item Name","Quantity","Date");
						System.out.printf("%s    %s      %s     %s    %s\n","-------------","--------","----------------","--------","---------");
						for(int i=0;i<transaction.size();i++){
							Transaction temp = transaction.get(i);
							int quantity = temp.getQuantity();
							if(temp.purchase==0)quantity=quantity*-1;
							System.out.printf("\n     %-8d      %-6d      %-16s         %4d     %8s",temp.getTransactionId(),temp.getMemberId(),temp.getItemName(),quantity,temp.getDate());}
						}
						else if(a.equalsIgnoreCase("ID")){
						Collections.sort(transaction, new ItemNameAscComparator());
						System.out.printf("\n%13s    %8s       %-16s    %8s       %-6s\n","TransactionID","MemberID","Item Name","Quantity","Date");
						System.out.printf("%s    %s      %s     %s    %s\n","-------------","--------","----------------","--------","---------");
						for(int i=transaction.size()-1;i>=0;i--){
							Transaction temp = transaction.get(i);
							int quantity = temp.getQuantity();
							if(temp.purchase==0)quantity=quantity*-1;
							System.out.printf("\n     %-8d      %-6d      %-16s         %4d     %8s",temp.getTransactionId(),temp.getMemberId(),temp.getItemName(),quantity,temp.getDate());}
						}
						else if(a.equalsIgnoreCase("M")){
						}
						else{
							System.out.println("\nInvalid Input, Try Again.");
						}
						
						
					}
					
				}
			}
		
		}
		saveFile();
		System.out.println("\nProgram successfully exited and database saved.");
	}
}
