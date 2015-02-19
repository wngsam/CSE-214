//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.Serializable;
/**
 * Customer contains a count for increasing member ID and data values name, address, city
 * @author Sam
 *
 */
public class Customer implements Comparable, Serializable  {
	private int memberId;
	private String name,streetAddress,city;

	/**
	 * Contructor which sets the datas of customer
	 * @param name
	 * @param streetAddress
	 * @param city
	 */
	Customer(String name, String streetAddress, String city, int size){
		memberId = 4000+size;
		this.name=name;
		this.streetAddress=streetAddress;
		this.city=city;
	}
	/**
	 * Returns member ID
	 * @return
	 */
	public int getMemberId(){
		return memberId;
	}
	/**
	 * Returns name
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns Street Address
	 * @return
	 */
	public String getStreetAddress(){
		return streetAddress;
	}
	/**
	 * Returns city
	 * @return
	 */
	public String getCity(){
		return city;
	}
	/**
	 * Compares member ID for default collections sorting
	 */
	public int compareTo(Object o) {
		Customer otherCus = (Customer)o;
		if(this.memberId == otherCus.memberId)
			return 0;
		else if (this.memberId>otherCus.memberId)
			return 1;
		else
			return -1;
	}
}
