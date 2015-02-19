//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.util.Comparator;
/**
 * Comparator for sorting in Ascending Item Name Comparator
 * @author Sam
 *
 */
public class AscItemNameComparator implements Comparator {
	/**
	 * Compare method for comparator
	 */
	public int compare(Object o1, Object o2){
		Item e1 = (Item) o1;
		Item e2 = (Item) o2;
		return (e1.getItemName().compareTo(e2.getItemName()));
	}
}
