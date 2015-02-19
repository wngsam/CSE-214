//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.Serializable;
/**
 * Contains datas for Transaction and a counter to automatically icnrease transaction ids
 * @author Sam
 *
 */
public class Transaction implements Comparable, Serializable {
	private int transactionId,memberId,itemId,quantity;
	private String date, itemName;
	int purchase;
/**
 * Default constructor which sets the data values
 * @param memberId
 * @param itemId
 * @param date
 * @param quantity
 * @param purchase
 * @param name
 */
	Transaction(int memberId, int itemId, String date, int quantity, int purchase, String name, int size){
		transactionId=7000+size;
		this.memberId=memberId;
		this.itemId=itemId;
		this.date=date;
		this.quantity=quantity;
		this.purchase=purchase;
		itemName=name;
	}
	/**
	 * Returns transaction id
	 * @return
	 */
	public int getTransactionId(){
		return transactionId;
	}
	/**
	 * Returns member id
	 * @return
	 */
	public int getMemberId(){
		return memberId;
	}
	/**
	 * Returns item id
	 * @return
	 */
	public int getItemId(){
		return itemId;
	}
	/**
	 * Returns item name
	 * @return
	 */
	public String getItemName(){
		return itemName;
	}
	/**
	 * Returns date
	 * @return
	 */
	public String getDate(){
		return date;
	}
	/**
	 * Returns quantity
	 * @return
	 */
	public int getQuantity(){
		return quantity;
	}
	/**
	 * Returns purchase
	 * @return
	 */
	public int getPurchase(){
		return purchase;
	}
	/**
	 * Method for default collections sorting comparing transaction id
	 */
	public int compareTo(Object o) {
		Transaction otherEmp = (Transaction)o;
        if (this.transactionId == otherEmp.transactionId)
                return 0;
        else if (this.transactionId > otherEmp.transactionId)
                return 1;
        else
                return -1;
	}
}
