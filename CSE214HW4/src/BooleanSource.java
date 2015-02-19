//Sam Wang
//ID: 108107971
//Homework 4
//CSE214
//Recitation 4 TA: Varun Agrawal 

public class BooleanSource {
/**
 * BooleanSource is used to determine whether a probability has occured.
 * probability holds the probability input.
 */
	double probability;
	/**
	 * BooleanSource creates an instance of BooleanSource which sets the parameter to probability and checks for validity.
	 * @param p 
	 * User input of probability
	 * @throws IllegalArgumentException
	 */
	public BooleanSource(double p) throws IllegalArgumentException {
		if(p<0.0 || p>1.0){
			throw new IllegalArgumentException();
		}
		probability =p;
	}
	/**
	 * occurs determines whether the chance has occured.
	 * @return
	 * Returns true or false depending on the randomly generated number.
	 */
	public boolean occurs(){
			return (Math.random()<probability);
	}
}
