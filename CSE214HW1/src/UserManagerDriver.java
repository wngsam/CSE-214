//Sam Wang
//ID: 108107971
//Homework #1
//CSE214
//R04 Varun Agrawal

import java.util.Scanner;
public class UserManagerDriver {
	public static UserManager userManager = new UserManager();
	public static UserManager backUp = new UserManager();
	
	public static void main(String[] args){
		initiate(userManager, backUp);	
		
		}
	
	/**
	 * This method brings out the menu screen and scans your input for the next operation.
	 * @param userManager
	 * @param backUp
	 */
	
	public static void initiate(UserManager userManager, UserManager backUp){
	System.out.println(
			"o        Add User:               A  <Username> <Password> <Email> <Full Name>\n"+
			"o        Change Password:        C  <Username> <Password> <New Password>\n"+
			"o        Get User:               G  <Position>\n"+
			"o        Login:                  L  <Username> <Password>\n"+
			"o        Print All Users:        P \n"+
			"o        Remove User:            R  <Position>\n"+
			"o        backUp(Save):           B\n"+
			"o        Size:                   S\n"+
			"o        Verify backUp:          V\n"+
			"o        Quit:                   Q\n"+
			"\n"+
			"Select a menu option.");

	char input;
	Scanner scan = new Scanner(System.in);
	String temp = scan.next();
	input = temp.charAt(0);
	
	check(input,userManager, backUp);
	}
	
	/**
	 * This method takes your input and matches it with the corresponding function according to the menu and does the operation.
	 * @param input
	 * @param userManager
	 * @param backUp
	 */
	
	public static void check(char input, UserManager userManager, UserManager backUp){
		if(input=='A' || input =='a'){
			
			Scanner input1 = new Scanner(System.in);
			System.out.println("Enter Username");
			String username = input1.nextLine();
			
			Scanner input2 = new Scanner(System.in);
			System.out.println("Enter Password");
			String password = input2.nextLine();
			
			Scanner input3 = new Scanner(System.in);
			System.out.println("Enter Email");
			String email = input3.nextLine();
			
			Scanner input4 = new Scanner(System.in);
			System.out.println("Enter Full Name");
			String fullName = input4.nextLine();
			
			User user = new User(username,password,email,fullName);
			userManager.addUser(user,userManager.size());
			
			System.out.println("User added: "+username);
			
			menu(userManager, backUp);
			
		}
		if(input=='C' || input =='c'){
			User user = new User();
			Scanner input9 = new Scanner(System.in);
			System.out.print("Enter username");
			String username = input9.nextLine();
			
			if(findUsername(username, userManager)==-1){
			System.out.println("This user does not exist");
			menu(userManager,backUp);
			}
			else{
				user = userManager.getUser(findUsername(username, userManager));
			}
			
			Scanner input7 = new Scanner(System.in);
			System.out.print("Enter password");
			String password = input7.nextLine();
			
			if(password.equals(user.getPassword())==false){
				System.out.println("Invalid password");
				menu(userManager,backUp);
			}
			else{
			Scanner input8 = new Scanner(System.in);
			System.out.print("Enter New password");
			String newPassword = input8.nextLine();
			
			userManager.list[findUsername(username, userManager)].setPassword(newPassword);
			
			System.out.println("Password changed.");
			menu(userManager,backUp);
		}
			}
		if(input=='G' || input =='g'){
			System.out.println("Enter User's Position");
			Scanner input5 = new Scanner(System.in);
			int position = input5.nextInt();
			User temp = userManager.getUser(position-1);
			System.out.print("Username        Password      Full Name        Email\n"+"---------------------------------------------------------------------------\n"+temp.toString()+"\n");
			
			menu(userManager, backUp);
			
		}
		if(input=='L' || input =='l'){
			
			Scanner input11 = new Scanner(System.in);
			System.out.println("Enter your username:");
			String username = input11.nextLine();
			
			Scanner input12 = new Scanner(System.in);
			System.out.println("Enter your password:");
			String password = input12.nextLine();
			
			userManager.login(username, password);
			
		}
		if(input=='P' || input =='p'){
			userManager.printAllUsers();
		}
		if(input=='R' || input =='r'){
			System.out.println("Enter the user's position to remove");
			Scanner input13 = new Scanner(System.in);
			int position = input13.nextInt();
			User temp = userManager.getUser(position-1);
			System.out.println("Removed user "+temp.getUsername());
			
			userManager.removeUser(position-1);
			
			menu(userManager, backUp);
			
		}
		if(input=='B' || input =='b'){
			backUp = (UserManager) userManager.clone();
			System.out.println("backUp successfully saved.");
			
			menu(userManager, backUp);
		}
		if(input=='S' || input =='s'){
			System.out.println("There are "+userManager.size()+" users.");
			menu(userManager, backUp);
		}
		if(input=='V' || input =='v'){
		if(userManager.equals(backUp)==true){
			System.out.println("Backup and user manager are equal.");
			menu(userManager, backUp);
		}
		else if(userManager.equals(backUp)==false){
			System.out.println("Backup and user manager are not equal.");
			menu(userManager, backUp);
		}
		menu(userManager, backUp);
		}
		else if(input=='Q' || input =='q'){
			System.out.println("Program will now terminate.");
		}
	}
	
	/**
	 * Repeats the menu screen as long as the user presses M.
	 * @param userManager
	 * @param backUp
	 */
	
	
	public static void menu(UserManager userManager, UserManager backUp){
		System.out.println("Press M to return to the menu");
		char input;
		Scanner input1 = new Scanner(System.in);
		String temp = input1.next();
		input = temp.charAt(0);
		
		if(input=='M' || input== 'm'){
			initiate(userManager, backUp);
		}
		else{
			menu(userManager, backUp);
		}
	}
	
	/**
	 * Attempts to find the username that was typed in the UserManager database and returns its position or -1 if non-existant
	 * @param username
	 * @param userManager
	 * @return
	 */
	
	public static int findUsername(String username, UserManager userManager){
		
		String[] usernameArray = new String[userManager.size()];
		
		for(int i=0;i<userManager.size();i++){
			usernameArray[i]=userManager.list[i].getUsername();
		}
		
		for(int i=0;i<userManager.size();i++){
			if(usernameArray[i].equals(username)==true){
				return i;
			}
		}
		return -1;
		
	}
	
}
