//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.util.Comparator;
/**
 * Comprator for sorting Item Name ascending
 * @author Sam
 *
 */
public class ItemNameAscComparator implements Comparator{
	/**
	 * Compare method for comparator
	 */
	public int compare(Object o1, Object o2) {
		Transaction eMp = (Transaction)o1;
		Transaction otherEmp = (Transaction)o2;
		return (eMp.getItemName().compareTo(otherEmp.getItemName()));
	}
}
