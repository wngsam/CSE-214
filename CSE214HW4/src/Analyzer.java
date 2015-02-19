//Sam Wang
//ID: 108107971
//Homework 4
//CSE214
//Recitation 4 TA: Varun Agrawal 
import java.util.Scanner;
/**
 * Main interaction between user and program to simulate the program.
 * @author Sam
 *
 */

public class Analyzer {

	/**
	 * Calls menu to begin the program. Also prints a chart of results.
	 * @param args
	 */
	public static void main(String[] args){
		
		double a=.1;
		int b=2;
		System.out.println("                                        Scan Time");
		System.out.println("Arrival Rate |-----2-----|-----4-----|-----6------|-----8------|-----10------|");
		for(int i=0;i<5;i++){
			a=.1+(.1*i);
			System.out.printf("%1.1f               ",a);
			for(int k=0;k<5;k++){
				b=2+(k*2);
				System.out.printf("%-7.1f     ",Simulator.avgWaitTime(8,a,75,b,1600));
			}
			System.out.println("");
		}
		System.out.println("");
		
		menu();
	}
	
	/**
	 * Brings up the program and begins the interaction with user and simulation.
	 */
	public static void menu(){
		System.out.println("Welcome to the Supermarket Simulator! ");
		
		System.out.print("Please enter the number of cashiers: ");
		Scanner nCashier = new Scanner(System.in);
		int numCashiers=nCashier.nextInt();
		try{
			if(numCashiers<2 || numCashiers>10) throw new IllegalArgumentException(); 
		}
		catch(IllegalArgumentException e){
			System.out.println("\nThe numbers of cashiers must be a positive integer less than or equal to 10 but greater than or equal to 2. Try Again!\n ");
			menu();
		}
		
		System.out.print("Please enter the probability that a customer will arrive each second: ");
		Scanner aProb = new Scanner(System.in);
		double arrivalProb=aProb.nextDouble();
		try{
			if(arrivalProb<0 || arrivalProb>=1) throw new IllegalArgumentException(); 
		}
		catch(IllegalArgumentException e){
			System.out.println("\nArrival probability of a customer must be a positive real number less than 1. Try Again!\n");
			menu();
		}
		
		System.out.print("Please enter the maximum number of items each customer may purchase: ");
		Scanner mItem = new Scanner(System.in);
		int maxItems=mItem.nextInt();
		try{
			if(maxItems<0 || maxItems>100) throw new IllegalArgumentException(); 
		}
		catch(IllegalArgumentException e){
			System.out.println("\nMaximum number of items must be a positive integer less than or equal to 100. Try Again!\n");
			menu();
		}
		
		System.out.print("Please enter the number of seconds it takes to scan each item: ");
		Scanner sSpeed = new Scanner(System.in);
	    int	scanSpeed=sSpeed.nextInt();
	    try{
			if(scanSpeed<0 || scanSpeed>10) throw new IllegalArgumentException(); 
		}
		catch(IllegalArgumentException e){
			System.out.println("\nSeconds per item must be a positive integer less than or equal to 10. Try Again!\n");
			menu();
		}
	    
		System.out.print("Please enter the number of minutes to be simulated: ");
		Scanner sMin = new Scanner(System.in);
		int simMinutes=sMin.nextInt();
		try{
			if(simMinutes<0 || simMinutes>2400) throw new IllegalArgumentException(); 
		}
		catch(IllegalArgumentException e){
			System.out.println("\nNumber of simulation minutes must be a positive integer less than or equal to 2400. Try Again! \n");
			menu();
		}
		
		System.out.println("Thank you! Running Simulation...");

		double avgWaitTime = Simulator.avgWaitTime(numCashiers,arrivalProb,maxItems,scanSpeed,simMinutes);
		int min= (int) avgWaitTime/60;
		int sec= (int) avgWaitTime%60;
		System.out.printf("\nAverage Waiting Time: %1.1f \n", avgWaitTime);//TEST
		System.out.println("The average waiting time per customer was "+min+" minutes and "+sec+" seconds");
		
	}
	
}
