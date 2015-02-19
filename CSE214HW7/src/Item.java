//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.Serializable;
/**
 * Item class with item data values
 * @author Sam
 *
 */
public class Item implements Comparable, Serializable  {
	private String itemName;
	private int itemNumber,quantity;
	/**
	 * Item constructor 
	 * @param itemName
	 * @param quantity
	 */
	Item(String itemName, int quantity,int size){
		this.itemName=itemName;
		itemNumber=1000+size;
		this.quantity=quantity;
	}
	/**
	 * Returns item name
	 * @return
	 */
	public String getItemName(){
		return itemName;
	}
	/**
	 * Returns item number
	 * @return
	 */
	public int getItemNumber(){
		return itemNumber;
	}
	/**
	 * Returns quantity
	 * @return
	 */
	public int getQuantity(){
		return quantity;
	}
	/**
	 * Modifies quantity with addition
	 * @param quantity
	 */
	public void setQuantity(int quantity){
		this.quantity+=quantity;
	}
	/**
	 * Method for default collections sort comparing item numbers
	 */
	public int compareTo(Object o) {
		Item otherIte = (Item)o;
		if(this.itemNumber == otherIte.itemNumber)
			return 0;
		else if (this.itemNumber>otherIte.itemNumber)
			return 1;
		else
			return -1;
	}
}
