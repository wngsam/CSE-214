//Sam Wang
//ID: 108107971
//Homework 6
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 * Main interactive driver program that will contain the SpamFilter instance and compare whether emails are spam.
 * @author Sam
 *
 */
public class SpamDriver {

	private static SpamFilter filter;
	private static final String FILENAME="SpamFilter.obj";
	private static final float SPAM_RATIO = 0.05f;
	/**
	 * Load FILENAME if available to filter, if not an instance of the filter will be created.
	 */
	private static void loadFilter(){
		try {
		  //If file is found, open it
		  FileInputStream   file = new FileInputStream(FILENAME);
		  ObjectInputStream fin  = new ObjectInputStream(file);
		  filter = (SpamFilter) fin.readObject();
		  file.close();
		} catch(Exception e){filter = new SpamFilter();}
	}
	/**
	 * Save the filter class to FILENAME.
	 */
	private static void saveFilter(){
		try {
			  FileOutputStream   file = new FileOutputStream(FILENAME);
			  ObjectOutputStream fout = new ObjectOutputStream(file);
			  fout.writeObject(filter);
			  fout.close();
			} catch(Exception e) {System.out.println("Save fail\n"); }
	}
	/**
	 * Main program that will load/save FILENAME and open up emails to check for spam and give users the option menu
	 * @param args
	 */
	public static void main(String[] args){
		loadFilter();
		Scanner input = new Scanner(System.in);
		String option="";
		
		while(!option.equalsIgnoreCase("Q")){
		System.out.print("C) Check emails\nI) Insert word\nR) Remove word\nS) Search for word\nQ) Quit program\nChoice> ");
		option = input.nextLine();
		
			if(option.length()>1 || !option.equalsIgnoreCase("C")&&!option.equalsIgnoreCase("I")
					&&!option.equalsIgnoreCase("R")&&!option.equalsIgnoreCase("S")&&!option.equalsIgnoreCase("Q")){
			System.out.println("Invalid input, try again\n");
			}
			else{
				if(option.equalsIgnoreCase("C")){
					Scanner file = new Scanner(System.in);
					System.out.print("File that contains email info: ");
					
					try{
						BufferedReader reader = new BufferedReader(new FileReader(file.nextLine()));
						
						String line = reader.readLine();
						System.out.print("\nInbox - spam marked with a *");
						System.out.printf("\n%-9s   %-10s %-10s %-10s %-10s", " To", "From", "Date","Subject","Filename");
						System.out.printf("\n%-9s   %-10s %-10s %-10s %-10s\n","--------","----------","----------","----------","----------");
						do{
							line=line.trim();
						while(line.length()==0 || line.equals("")){
							line = reader.readLine().trim();
						}
						
						String[] temp = line.split("\t");
						EmailInfo info = new EmailInfo();
						info.setTo(temp[0]);
						info.setFrom(temp[1]);
						info.setDate(temp[2]);
						info.setSubject(temp[3]);
						String fileName = temp[4];
						String message = "";
						try{
							BufferedReader reader2 = new BufferedReader(new FileReader(fileName));
							String line2=reader2.readLine();
							while(line2!=null){
								message+=line2;
								line2=reader2.readLine();
							}
							info.setMessage(message);
							reader2.close();
						}catch (Exception e){
							System.out.println("\nError reading email. Try again.\n");
						}
						
						if(filter.checkEmail(info.getMessage())>SPAM_RATIO){
							System.out.print("*");
							System.out.printf("%-9.7s  %-10.10s %-10.10s %-10.10s %-10.10s\n",info.getTo(),info.getFrom(),info.getDate(),info.getSubject(),fileName);
						}
						else{
							System.out.printf(" %-9.7s  %-10.10s %-10.10s %-10.10s %-10.10s\n",info.getTo(),info.getFrom(),info.getDate(),info.getSubject(),fileName);
						}
						
						line=reader.readLine();
						}while(line!=null);
						
						reader.close();
					}catch (Exception e){
						System.out.println("\nError reading file. Try again.\n");
					}
					System.out.print("\n");
				}
				if(option.equalsIgnoreCase("I")){
					Scanner word = new Scanner(System.in);
					System.out.print("Word to insert: ");
					String s = word.next();
					filter.insert(s);
					saveFilter();
				}
				if(option.equalsIgnoreCase("R")){
					Scanner word = new Scanner(System.in);
					System.out.print("Word to remove: ");
					String s = word.next();
					try {
						filter.remove(s);
					} catch (Exception e) {
					System.out.println(s+" not found in Hashtable\n");	
					}
				}
				if(option.equalsIgnoreCase("S")){
					Scanner word = new Scanner(System.in);
					System.out.print("Word to search for: ");
					String s = word.next();
					if(filter.isBadWord(s)){
						System.out.println(s+" is in the hashtable.\n");
					}
					else{
						System.out.println(s+" is not in the hashtable.\n");
					}
				}
			}
		}
		System.out.println("\nProgram Terminated Normally...");
	}
	
}
