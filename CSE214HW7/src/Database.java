//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Contains several arraylists
 * @author Sam
 *
 */
public class Database  implements Serializable {
	
	private ArrayList<Customer> customer;
	private ArrayList<Item> item;
	private ArrayList<Transaction> transaction;
	/**
	 * Database constructor
	 */
	Database(){
		customer = new ArrayList<Customer>();
		item = new ArrayList<Item>();
		transaction = new ArrayList<Transaction>();
	}
	/**
	 * Returns arraylist customer
	 * @return
	 */
	public ArrayList<Customer> getCustomer(){
		return customer;
	}
	/**
	 * Returns arraylist items
	 * @return
	 */
	public ArrayList<Item> getItem(){
		return item;
	}
	/**
	 * Returns arraylist transaction
	 * @return
	 */
	public ArrayList<Transaction> getTransaction(){
		return transaction;
	}
	/**
	 * Add new customer object to arraylist customers
	 * @param name
	 * @param streetAddress
	 * @param city
	 * @return
	 */
	public boolean addCustomer(String name, String streetAddress, String city){
		return customer.add(new Customer(name, streetAddress, city, customer.size()));
	}
	/**
	 * Adds new item object to arraylist item
	 * @param itemName
	 * @param quantity
	 * @return
	 */
	public boolean addItem(String itemName, int quantity){
		return item.add(new Item(itemName, quantity, item.size()));
	}
	/**
	 * Adds a new object transaction to arraylist transaction
	 * @param memberId
	 * @param itemId
	 * @param date
	 * @param quantity
	 * @param purchase
	 * @return
	 */
	public boolean addTransaction(int memberId, int itemId, String date, int quantity, int purchase){
		return transaction.add(new Transaction(memberId, itemId, date, quantity, purchase,searchItemId(itemId).getItemName(),transaction.size()));
	}
	/**
	 * Returns latest customer id
	 * @return
	 */
	public int returnCustomerId(){
		return customer.get(customer.size()-1).getMemberId();
	}
	/**
	 * Returns the latest item id
	 */
	public int returnItemId(){
		return item.get(item.size()-1).getItemNumber();
	}
	/**
	 * Returns the latest transaction id
	 * @return
	 */
	public int returnTransactionId() {
		return transaction.get(transaction.size()-1).getTransactionId();
	}
	/**
	 * Searches for a customer by searching for member id
	 * @param id
	 * @return
	 */
	public Customer searchMemberId(int id){
		for (int i=0;i<customer.size();i++){
			if(customer.get(i).getMemberId()==id){
				return customer.get(i);
			}
		}
		return null;
	}
	/**
	 * Search for a specific item by item id
	 * @param id
	 * @return
	 */
	public Item searchItemId(int id){
		for (int i=0;i<item.size();i++){
			if(item.get(i).getItemNumber()==id){
				return item.get(i);
			}
		}
		return null;
	}
	/**
	 * Search for a specific transaction by item id and member id
	 * @param a
	 * @param b
	 * @return
	 */
	public Transaction searchTran(int a, int b){
		for (int i=0;i<transaction.size();i++){
			if(transaction.get(i).getMemberId()==a && transaction.get(i).getItemId()==b && transaction.get(i).getPurchase()==1){
				return transaction.get(i);
			}
		}
		return null;
	}
	/**
	 * Returns the difference between purchases and returns
	 * @param a
	 * @param b
	 * @return
	 */
	public int history(int a, int b){
		int quantBought=0;
		for (int i=0;i<transaction.size();i++){
			if(transaction.get(i).getMemberId()==a && transaction.get(i).getItemId()==b){
				if(transaction.get(i).getPurchase()==1){
					quantBought+=transaction.get(i).getQuantity();
				}
				if(transaction.get(i).getPurchase()==0){
					quantBought-=transaction.get(i).getQuantity();
				}
			}
		}
		return quantBought;
	}
}
