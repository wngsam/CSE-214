//Sam Wang
//ID: 108107971
//Homework 2
//CSE214
//Recitation 4 TA: Varun Agrawal 
/**This class CardInfo stores primitive datas for each specific card.
 * accountName stores the name of the card owner.
 * company stores the name of the card company.
 * date stores the date the card was opened.
 * lastBalance stores the balance of the card.
 * accountStatus stores how long the account's been overdue.
 * @author Sam
 *
 */
public class CardInfo {

	String accountName, company, date;
	double lastBalance;
	int accountStatus;
	
	/**
	 * A method that creates a CardInfo object and fills it with data.
	 * @param accountName
	 * Name on the card
	 * @param company
	 * Name of the card company
	 * @param date
	 * Date account created
	 * @param lastBalance
	 * Balance on the card
	 * @param accountStatus
	 * Days account overdue
	 * Order of Complexity: O(1)
	 */
	public CardInfo(String accountName, String company, String date, double lastBalance, int accountStatus){
		this.accountName=accountName;
		this.company=company;
		this.date=date;
		this.lastBalance=lastBalance;
		this.accountStatus=accountStatus;
	}
	/**
	 * This method returns the Account Name
	 * @return
	 * Account Name
	 * Order of Complexity: O(1)
	 */
	public String getAccountName(){
		return accountName;
	}
	/**
	 * This method returns the Company Name
	 * @return
	 * company
	 * Order of Complexity: O(1)
	 */
	public String getCompany(){
		return company;
	}
	/**
	 * This method returns the date the account was created
	 * @return
	 * date
	 * Order of Complexity: O(1)
	 */
	public String getDate(){
		return date;
	}
	/**
	 * This method returns the balance
	 * @return
	 * lastBalance
	 * Order of Complexity: O(1)
	 */
	public double getLastBalance(){
		return lastBalance;
	}
	/**
	 * This method returns the days the account is overdue
	 * @return
	 * accountStatus
	 * Order of Complexity: O(1)
	 */
	public int getAccountStatus(){
		return accountStatus;
	}
	/**
	 * Modifies the account name of the card
	 * @param accountName
	 * The name of the card's owner.
	 * Order of Complexity: O(1)
	 */
	public void setAccountName(String accountName){
		this.accountName=accountName;
	}
	/**
	 * Modifies the company name
	 * @param company
	 * Name of the card's company
	 * Order of Complexity: O(1)
	 */
	public void setCompany(String company){
		this.company=company;	
	}
	/**
	 * Modifies the date the card was created on
	 * @param date
	 * date the card was opened
	 * Order of Complexity: O(1)
	 */
	public void setDate(String date){
		this.date=date;
	}
	/**
	 * Modifies the balance of the account
	 * @param lastBalance
	 * Current balance of the account.
	 * Order of Complexity: O(1)
	 */
	public void setLastBalance(double lastBalance){
		this.lastBalance=lastBalance;
	}
	/**
	 * Modifies the account status of the card
	 * @param accountStatus
	 * Days the card is overdue
	 * Order of Complexity: O(1)
	 */
	public void setAccountStatus(int accountStatus){
		this.accountStatus=accountStatus;
	}
}
