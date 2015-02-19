//Sam Wang
//ID: 108107971
//Homework 4
//CSE214
//Recitation 4 TA: Varun Agrawal 
/**
 * Customer class is an instance of customer with datas.
 * arrivalTime stores the time the customer arrived.
 * numItems stores the number of items the customer have.
 * @author Sam
 *
 */
public class Customer {
	
	int arrivalTime;
	int numItems;
/**
 * Customer constructor creates an instance of customer.
 * @param arrivalT
 * The time the customer entered the line.
 * @param numI
 * The amount of items the customer have.
 */
	Customer(int arrivalT, int numI){
		arrivalTime=arrivalT;
		numItems=numI;
	}
}
