//Sam Wang
//ID: 108107971
//Homework 6
//CSE214
//Recitation 4 TA: Varun Agrawal
/**
 * EmailInfo class that will contain the information of emails such as to, from, date, subject and message
 * @author Sam
 *
 */
public class EmailInfo {

	private String to,from,date,subject,message;
	/**
	 * Empty constructor
	 */
	EmailInfo(){
	}
	/**
	 * Set the string to data to
	 * @param to
	 */
	public void setTo(String to){
		this.to=to;
	}
	/**
	 * Returns the to string
	 * @return
	 */
	public String getTo(){
		return to;
	}
	/**
	 * Set the from to from data
	 * @param from
	 */
	public void setFrom(String from){
		this.from=from;
	}
	/**
	 * Returns the from string
	 * @return
	 */
	public String getFrom(){
		return from;
	}
	/**
	 * Set the date to date data
	 * @param date
	 */
	public void setDate(String date){
		this.date=date;
	}
	/**
	 * Returns the date string
	 * @return
	 */
	public String getDate(){
		return date;
	}
	/**
	 * Set the subject to subject data
	 * @param subject
	 */
	public void setSubject(String subject){
		this.subject=subject;
	}
	/**
	 * Returns the subject string
	 * @return
	 */
	public String getSubject(){
		return subject;
	}
	/**
	 * Set the message to message data
	 * @param message
	 */
	public void setMessage(String message){
		this.message=message;
	}
	/**
	 * Returns the message string
	 * @return
	 */
	public String getMessage(){
		return message;
	}
}
