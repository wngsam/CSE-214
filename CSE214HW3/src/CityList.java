//Sam Wang
//ID: 108107971
//Homework 3
//CSE214
//Recitation 4 TA: Varun Agrawal 
import java.util.LinkedList;
import java.util.Stack;
/**
 * The CityList class creates a list of cities with arrays of their names, whether they've been visited, the number of cities in the array and their adjacent cities.
 * MAX_CITIES sets the maximum amount of cities.
 * cityNames holds an array of city names.
 * visited holds flags for whether the city at that particular index has been visited.
 * manyItems stores the amount of cities currently in the list.
 * adjacentCities holds an array of linked lists that stores data on citys' available destinations.
 * @author Sam
 *
 */
public class CityList {

	final int MAX_CITIES=20;
	private static String[] cityNames;
	private boolean[] visited;
	private static int manyItems;
	private LinkedList[] adjacentCities;
	/**
	 * CityList is a constructor that initializes all the arrays and sets manyItems to 0;
	 */
	public CityList(){
		cityNames= new String[MAX_CITIES];
		visited = new boolean[MAX_CITIES];
		adjacentCities = new LinkedList[MAX_CITIES];
		for(int i=0;i<MAX_CITIES;i++){
			adjacentCities[i] = new LinkedList<String>();
		}
		manyItems=0;
	}
	/**
	 * Add a particular city into the lists of cities.
	 * @param city
	 * City name in which you would like to add.
	 */
	public void addCity(String city){
		if(manyItems==20){
			System.out.println("\nThe list is full!");
		}
		else{
		try{
			if(searchIndex(city)!=-1) throw new InvalidCityException();
		}
		catch (InvalidCityException e)
		{
			System.out.println("\nDOH! You've already entered "+city+" into the list of cities!");
		}
		cityNames[manyItems]=city;
		visited[manyItems]=false;
		manyItems++;
		}
	}
/**
 * Adds an available destination city to the origin city's linked lists making it available for flight.	
 * @param originCity
 * The city you originate from.
 * @param destCity
 * The city you can fly to.
 */
	public void addPath(String originCity, String destCity){
		adjacentCities[searchIndex(originCity)].add(destCity);
	}
	/**
	 * Marks the particular city's respective visited array into true or visited.
	 * @param city
	 * Particular city you wish to mark
	 */
	public void markAsVisited(String city){
		try{
			if(searchIndex(city)==-1) throw new InvalidCityException();
		}
		catch (InvalidCityException e)
		{
			System.out.println(city+" not found in the list.");
		}
		visited[searchIndex(city)]=true;
	}
	/**
	 * Make all the value in the visited boolean array into visited or false.	
	 */
	public void unvisitAll(){
		for(int i=0;i<manyItems;i++){
			visited[i]=false;
		}
	}
	/**
	 * Gets the next unvisited city in the visited array.
	 * @param city
	 * The city you wish to start the search at.
	 * @return
	 * the next unvisited city adjacent to the input city.
	 */
	public String getNextUnvisitedCity(String city){
		for(int i=0;i<adjacentCities[searchIndex(city)].size();i++){
		String temp = (String) adjacentCities[searchIndex(city)].get(i);
			if(visited[searchIndex(temp)]==false){
				return temp;
			}
		}
		return null;
	}
	/**
	 * isPath searches for whether there is a flight from origin city to the destination city.
	 * @param originCity
	 * City you start your flight at.
	 * @param destCity
	 * City you wish to fly to.
	 * @return
	 * Returns true or false depending on whether the path is available.
	 */
	public boolean isPath(String originCity, String destCity){
		try{
			if(searchIndex(originCity)==-1) throw new InvalidCityException();
			if(searchIndex(destCity)==-1) throw new InvalidCityException();
		}
		catch (InvalidCityException e)
		{
			System.out.println("Invalid City");
		}
		unvisitAll();
		Stack<String> stack = new Stack<String>();
		stack.push(originCity);
		markAsVisited(originCity);
		String topCity = stack.peek();
		while(!stack.isEmpty() && !destCity.equalsIgnoreCase(topCity)){
			String nextCity = getNextUnvisitedCity(topCity);
			if(nextCity==null){
				stack.pop();
			}
			else{
				stack.push(nextCity);
				markAsVisited(nextCity);
			}
			if(!stack.isEmpty()){
				topCity=stack.peek();
			}
		}
		if(stack.isEmpty())
			return false;
		else
			return true;
	}
	/**
	 * This method searches for the city's index with the name as input.
	 * @param city
	 * The city's name in which you wish to search for.
	 * @return
	 * Index of the city.
	 */
	public int searchIndex(String city){
		for(int i=0;i<manyItems;i++){
			if(cityNames[i].equalsIgnoreCase(city)){
				return i;
			}
		}
		return -1;
	}
	/**
	 * Accessor for a city's name for a specific index.
	 * @param i
	 * index of the city you wish to return.
	 * @return
	 * Returns the city's name.
	 */
	public static String getCityName(int i){
		return cityNames[i];
		}
	/**
	 * Accessor for manyItems variable.
	 * @return
	 * manyItems's value.
	 */
	public static int getManyItems(){
		return manyItems;
		}
}
