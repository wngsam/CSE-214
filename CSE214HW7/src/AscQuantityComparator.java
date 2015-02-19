//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.util.Comparator;
/**
 * Comparator for sorting ascending quantity comparator
 * @author Sam
 *
 */
public class AscQuantityComparator implements Comparator{
	/**
	 * Compare method for comparator
	 */
	public int compare(Object o1, Object o2) {
		Item iTe = (Item)o1;
		Item otherIte = (Item)o2;
		if(iTe.getQuantity() == otherIte.getQuantity())
			return 0;
		else if (iTe.getQuantity()>otherIte.getQuantity())
			return 1;
		else
			return -1;
	}
}
