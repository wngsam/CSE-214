//Sam Wang
//ID: 108107971
//Homework 5
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Main interactive class that interacts with the user. Creates a tree on startup.
 * @author Sam
 *
 */
public class TreeDriver {

	static Tree tree = new Tree();
	/**
	 * Main program that begins the program and provides available menu options and interactions.
	 * @param args
	 */
	public static void main(String[] args){

	Scanner input = new Scanner(System.in);
	String option="";
	
	while(option.equalsIgnoreCase("Q")!=true){
		System.out.print("L - Load a Tree.\nH - Begin a Help Session.\nT - Traverse the Tree in preorder.\nQ - Quit\nChoice> ");
		option = input.nextLine();
		if(option.length()>1 || (option.equalsIgnoreCase("L")==false && option.equalsIgnoreCase("H")==false 
			&& option.equalsIgnoreCase("T")==false && option.equalsIgnoreCase("Q")==false)){
		System.out.println("\nInvalid Input, please try again.\n");
		}
		else if(option.equalsIgnoreCase("L")==true){
			
			
			System.out.print("\nEnter the file name> ");
			Scanner file = new Scanner(System.in);
			String filename = file.nextLine();
			String label="";
			int count=0;
			
			try{
				   BufferedReader reader = new BufferedReader(new FileReader(filename));
				   String line = reader.readLine();
				   tree = new Tree();
				   do{
					   line=line.trim();
					   if(line.trim().length()==0 || line.trim().equals("")){
						line=reader.readLine();   
					   }
					   else{
						   if(tree.root==null){
							   String[] in = new String[3];
							   
							   in[0]=line;
							   for(int i=1;i<3;i++){
								   line=reader.readLine();
								   while(line.trim().length()==0 || line.trim().equals("")){
										line=reader.readLine();   
									   }
								   in[i]=line.trim();
							   }
							   try{
							   tree.addNode(in[0],in[1],in[2],"");
							   }catch(Exception e){
								   System.out.println("\nError adding node. Try again.");
							   }
						   }
						   else{
							   if(count==0){
								   label=line.substring(0,line.length()-1).trim();
								   count+=line.charAt(line.length()-1)-'0';
								   String[] in = new String[3];
								   for(int i=0;i<3;i++){
									   line=reader.readLine();
									   while(line.trim().length()==0 || line.trim().equals("")){
											line=reader.readLine();   
										   }
									   in[i]=line.trim();
								   }
								   try{
								   tree.addNode(in[0],in[1],in[2], label);count--;
							   }catch(Exception e){
								   System.out.println("\nError adding node. Try again.");
							   }
								   
							   }
							   else{
								   String[] in = new String[3];
								   
								   in[0]=line;
								   for(int i=1;i<3;i++){
									   line=reader.readLine();
									   while(line.trim().length()==0 || line.trim().equals("")){
											line=reader.readLine();   
										   }
									   in[i]=line.trim();
								   }
								   try{
								   tree.addNode(in[0],in[1],in[2], label);count--;
								   }catch(Exception e){
									   System.out.println("\nError adding node. Try again.");
								   }
								   
							   }
						   }
						   line=reader.readLine();
					   }
				   }while(line!=null);
				   
				   reader.close();
			}catch(Exception e){
			   System.out.println("\nError reading file. Try again.");
			}
			
			System.out.println("");
		}
		else if(option.equalsIgnoreCase("H")==true){
			if(tree.root==null){
				System.out.print("No tree has been loaded.");
			}
			else{
			tree.beginSession();
			}
			System.out.println("\n");
		}
		else if(option.equalsIgnoreCase("T")==true){
			if(tree.root==null){
				System.out.print("No tree has been loaded.");
			}
			else{
			tree.preOrder();
			}
			System.out.println("\n");
		}	
	}
	System.out.println("\nThank you for using our automated help services!");
	}

}
