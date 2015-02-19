//Sam Wang
//ID: 108107971
//Homework 2
//CSE214
//Recitation 4 TA: Varun Agrawal 
/**
 * This class presents the menu in which the user interact with and accesses the other classes and linkedlist.
 */
import java.util.Scanner;
/**
 * Creates menu and lets user interact with the program.
 */
public class CreditCardReport {
	
	static CardList list = new CardList();
	/**
	 * Calls the menu method.
	 * @param args
	 * none
	 * Order of Complexity: O(1)
	 */
	public static void main(String[] args){
		menu();
	}
	/**
	 * Prints out a menu and scans inputs
	 * Order of Complexity: O(1)
	 */
	public static void menu(){
		System.out.print("\nDA) Display all info\n" +
				"DB) Display by balance\n" +
				"DC) Display by company\n" +
				"DP) Display by person\n" +
				"DS) Display by status\n" +
				"IN) Insert an info\n" +
				"NX) Next\n" +
				"PR) Previous\n" +
				"RM) Remove an info\n" +
				"TP) Top\n" +
				"Q)  Quit\n"+
				"\n"+
				"Select an option> ");

		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		if(response.length()>2){
			System.out.print("\nInvalid input option, please try again.\n"+"\n");
			menu();
		}
		check(response);
	}
	/**
	 * Checks the input from the menu
	 * @param input
	 * The string of the input from the menu to check
	 * Order of Complexity: O(1)
	 */
	public static void check(String input){
		if(input.equalsIgnoreCase("DA")){
			System.out.println(printLabel());
			list.displayAll();
			System.out.println("");
			menu();
		}
		else if(input.equalsIgnoreCase("DB")){
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter the balance> ");
			double balance = input2.nextDouble();
			System.out.println("");
			System.out.println(printLabel());
			list.displayByBalance(balance);
			System.out.println("");
			menu();
		}
		else if(input.equalsIgnoreCase("DC")){
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter issued company> ");
			String company = input2.nextLine();
			System.out.println(printLabel());
			list.displayByCompany(company);
			System.out.println("");
			menu();
		}
		else if(input.equalsIgnoreCase("DP")){
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter Name> ");
			String name = input2.nextLine();
			System.out.println("");
			System.out.println(printLabel());
			list.displayByPerson(name);
			System.out.println("");
			menu();
		}
		else if(input.equalsIgnoreCase("DS")){
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter the delinquency in payments> ");
			int status = input2.nextInt();
				if(status<0){
					System.out.print("\nStatus cannot be negative, please try again.\n"+"\n");
					menu();	
				}
			else{
				System.out.println("");
				System.out.println(printLabel());
				list.displayByStatus(status);
				System.out.println("");
				menu();
			}
		}
		else if(input.equalsIgnoreCase("IN")){
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter Name> ");
			String name = input2.nextLine();
			if(name.length()>25){
			System.out.println("Account Name over 25 Characters");
			menu();
				}
			Scanner input3 = new Scanner(System.in);
			System.out.print("Enter Company> ");
			String company = input3.nextLine();
			if(company.length()>15){
				System.out.println("Company Name over 15 Characters");
				menu();
				}
			Scanner input4 = new Scanner(System.in);
			System.out.print("Enter Issued Date> ");
			String date = input4.nextLine();
			Scanner input5 = new Scanner(System.in);
			System.out.print("Enter Account Balance> ");
			double lastBalance = input5.nextDouble();
			Scanner input6 = new Scanner(System.in);
			System.out.print("Enter Account Status> ");
			int accountStatus = input6.nextInt();
				if(accountStatus<0){
					System.out.println("Error: Invalid account status. Info not added.");
					menu();
				}
			else{
			CardInfo info = new CardInfo(name, company, date, lastBalance, accountStatus);
			list.insertCardInfo(info);
			menu();
			}
		}
		else if(input.equalsIgnoreCase("NX")){
			System.out.println(printLabel());
			list.displayNext();
			if(list.getHead()!=null){
			CardInfoNode temp = list.getCurrent().getNext();
			if(temp!=null){
			list.setCurrent(temp);
				}
			}
			System.out.println("");
			menu();
		}
		else if(input.equalsIgnoreCase("PR")){
			System.out.println(printLabel());
			list.displayPrevious();
			if(list.getHead()!=null){
			CardInfoNode temp = list.getCurrent().getPrev();
			if(temp!=null){
			list.setCurrent(temp);
				}
			}
			System.out.println("");
			menu();
		}
		else if(input.equalsIgnoreCase("RM")){
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter Name> ");
			String name = input2.nextLine();
			Scanner input3 = new Scanner(System.in);
			System.out.print("Enter issued company> ");
			String issuedCompany = input3.nextLine();
				if(list.removeCardInfo(name, issuedCompany)==true){
					menu();
				}
				else{
					System.out.println("\nNo such account.\n");
					menu();
				}
		}
		else if(input.equalsIgnoreCase("TP")){
			System.out.println(printLabel());
			list.displayTop();
			CardInfoNode temp = list.getHead();
			list.setCurrent(temp);
			System.out.println("\n");
			menu();
		}
		else if(input.equalsIgnoreCase("Q")){
			System.out.print("\nProgram terminated normally...");
		}
		else{
			System.out.print("\nInvalid input option, please try again.\n"+"\n");
			menu();
		}
	}
	/**
	 * Returns a string of the chart's header
	 * @return
	 * Returns a string of the chart's header
	 * Order of Complexity: O(1)
	 */
	public static String printLabel(){
		return "\nAccount holder             Company          Issued date  Balance     Status\n"+
				"-------------------------  ---------------  -----------  ----------  ------";
	}
}
