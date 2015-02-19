//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.util.Comparator;
/**
 * Comparator for sorting descending name
 * @author Sam
 *
 */
public class DesNameComparator implements Comparator {
	/**
	 * Compare method for comparator
	 */
	public int compare(Object o1, Object o2){
		Customer e1 = (Customer) o1;
		Customer e2 = (Customer) o2;
		return -(e1.getName().compareTo(e2.getName()));
	}
}
