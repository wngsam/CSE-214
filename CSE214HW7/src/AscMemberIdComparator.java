//Sam Wang
//ID: 108107971
//Homework 7
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.util.Comparator;
/**
 * Comparator for sorting Ascending Member ID 
 * @author Sam
 *
 */
public class AscMemberIdComparator implements Comparator{
	/**
	 * Compare method for comparator
	 */
	public int compare(Object o1, Object o2) {
		Transaction eMp = (Transaction)o1;
		Transaction otherEmp = (Transaction)o2;
        if (eMp.getTransactionId() == otherEmp.getTransactionId())
                return 0;
        else if (eMp.getTransactionId() > otherEmp.getTransactionId())
                return 1;
        else
                return -1;
	}
}
