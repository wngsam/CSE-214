//Sam Wang
//ID: 108107971
//Homework 6
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.io.Serializable;
import java.util.Hashtable;
/**
 * The spam filter class that contains the hashtable of bad words to filter
 * @author Sam
 *
 */
public class SpamFilter implements Serializable {

	private Hashtable<String,String>badWords;
	/**
	 * Constructor that will initialize the hashtable
	 */
	SpamFilter(){
		badWords = new Hashtable<String,String>();
	}
	/**
	 * Takes in a string that will be inserted into the hashtable
	 * @param word
	 */
	public void insert(String word){
		if(!badWords.contains(word.toLowerCase())){
		badWords.put(word.toLowerCase(),word.toLowerCase());
		System.out.println(word+" added to hashtable!\n");}
		else{
			System.out.println("Duplicate word.\n");
		}
	}
	/**
	 * Takes in a string then locate it in the hashtable for removal
	 * @param word
	 * @throws Exception
	 */
	public void remove(String word) throws Exception{
		if(badWords.remove(word.toLowerCase())!=null){
		System.out.println(word+" removed from hashtable!\n");}
		else{
			System.out.println(word+" not found in Hashtable\n");
		}
	}
	/**
	 * Takes in a string and checks whether the hashtable contains this string
	 * @param checkMe
	 * @return
	 */
	public boolean isBadWord(String checkMe){
		return badWords.get(checkMe.toLowerCase()) != null;
	}
	/**
	 * Breaks a string up into words and checks whether the word is a badword by checking whether they're in the hashtable
	 * @param message
	 * @return
	 */
	public float checkEmail(String message){
		float bad=0.0f;
		String [] email = message.split(" ");
		
		for(int i=0;i<email.length;i++){
			if(isBadWord(email[i])){
				bad++;
			}
		}
		return bad/email.length;
	}
}
