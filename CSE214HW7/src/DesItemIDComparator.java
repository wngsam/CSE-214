//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.util.Comparator;
/**
 * Comparator for sorting Item ID descending
 * @author Sam
 *
 */
public class DesItemIDComparator implements Comparator {
	/**
	 * Compare method for comparator
	 */
	public int compare(Object o1, Object o2) {
		Item iTe = (Item)o1;
		Item otherIte = (Item)o2;
		if(iTe.getItemNumber() == otherIte.getItemNumber())
			return 0;
		else if (iTe.getItemNumber()>otherIte.getItemNumber())
			return -1;
		else
			return 1;
	}
}
