//Sam Wang
//ID: 108107971
//Homework 3
//CSE214
//Recitation 4 TA: Varun Agrawal 
import java.util.Scanner;
/**
 * The class CSAir is for user interaction with the program.
 * csAir creates a new CityList object.
 * @author Sam
 *
 */
public class CSAir {

	static CityList csAir = new CityList();
	/**
	 * The main method initiates the program.
	 * @param args
	 */
	public static void main(String[] args){
		menu();
	}
	/**
	 * The menu method creates the menu options for user interaction.
	 */
	public static void menu(){
		Scanner input = new Scanner(System.in);
		System.out.print("\nI) Insert a City\nA) Add a Flight Path (one way)\nR) Request a Flight\nQ) Quit\nChoice> ");
		String response = input.nextLine();
		check(response);
	}
	/**
	 * Check method checks the user input from menu in order to match it with a particular option.
	 * @param input
	 * User input that will be evaluated.
	 */
	public static void check(String input){
		if(input.length()<1){
			System.out.println("\nInvalid input, please try again.");
			menu();
		}
		else{
		if(input.equalsIgnoreCase("i")){
			System.out.print("Enter a city> ");
			Scanner input0 = new Scanner(System.in);
			String city = input0.nextLine();
			csAir.addCity(city);
			menu();
		}
		else if(input.equalsIgnoreCase("a")){
			System.out.print("Origin City> ");
			Scanner input0 = new Scanner(System.in);
			String originCity = input0.nextLine();
			System.out.print("Destination City> ");
			Scanner input1 = new Scanner(System.in);
			String destCity = input1.nextLine();
			csAir.addPath(originCity, destCity);
			menu();
		}
		else if(input.equalsIgnoreCase("r")){
			System.out.print("Origin City> ");
			Scanner input0 = new Scanner(System.in);
			String originCity = input0.nextLine();
			System.out.print("Destination City> ");
			Scanner input1 = new Scanner(System.in);
			String destCity = input1.nextLine();
			if(searchIndex(destCity)== -1){System.out.println(destCity+" is not in the list of cities!"); menu();} 
			else if(searchIndex(originCity)== -1){System.out.println(originCity+" is not in the list of cities!"); menu();
			}else{
				boolean flight = csAir.isPath(originCity, destCity);
			if(!originCity.equalsIgnoreCase(destCity)){
			if(flight==true){
				System.out.println("\nA flight from "+originCity+" to "+destCity+" is possible!");
			}
			else{
				System.out.println("\nCSAir does not fly from "+originCity+" to "+destCity+", sorry!");
				}
			}
			else{
				System.out.println("\nDOH! Why would you want to fly from "+originCity+" to "+destCity+"?");
				}
			}
			menu();
		}
		else if(input.equalsIgnoreCase("q")){
			System.out.println("\nProgram terminated normally...");
		}
		else{
			System.out.println("\nInvalid input, please try again.");
			menu();
		}
	}
}	
	/**
	 * searchIndex searches the arrays of city names in CityList for their index and whether they exist.
	 * @param city
	 * The city in which you wish to search for.
	 * @return
	 * Returns the index or -1 if the city is not implemented.
	 */
	public static int searchIndex(String city){
		for(int i=0;i<CityList.getManyItems();i++){
			if(CityList.getCityName(i).equalsIgnoreCase(city)){
				return i;
			}
		}
		return -1;
	}
}
