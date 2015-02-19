//Sam Wang
//ID: 108107971
//Homework 4
//CSE214
//Recitation 4 TA: Varun Agrawal 
import java.util.LinkedList;
import java.util.Vector;
/**
 * Queue class for storing instances of customers.
 * @author Sam
 * waitTime
 * Holds the scanning time required for that customer.
 */
public class Queue extends Vector <Customer>{

	LinkedList<Integer>waitTime = new LinkedList<Integer>();
	LinkedList<Integer>TotalwaitTime = new LinkedList<Integer>();//
	
	/**
	 * Creates an empty queue.
	 */
	Queue(){
	}
	/**
	 * Checks whether the Queue is empty.
	 */
	public boolean isEmpty(){
		return (elementCount==0);
	}
	/**
	 * Enters a new customer object into the queue.
	 * @param obj
	 * Customer object to be inserted.
	 */
	public void enqueue(Customer obj){
		addElement(obj);
	}
	/**
	 * Removes the first customer object in queue.
	 */
	public void dequeue(){
		remove(0);
	}
	/**
	 * Returns the size of the queue.
	 */
	public int size(){
		return elementCount;
	}
}
