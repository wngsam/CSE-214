//Sam Wang
//ID: 108107971
//Homework #1
//CSE214
//R04 Varun Agrawal

public class UserManager extends UserManagerDriver{

	final int MAX_USERS=50;
	User[] list = new User[MAX_USERS];
	static int size=-1;
	
	//MAX_USERS is the max array size
	//list is the array stored in UserManager objects
	//size counts for the size of the entries in the array at the moment
	
	/**
	 * Returns an instance of UserManager
	 **/
	
	public UserManager(){
		
	}
	public Object clone(){
		UserManager Copy = new UserManager();
		for(int i=0;i<list.length;i++){
			Copy.list[i]=list[i];
		}
		return Copy;
	}
	public boolean equals (UserManager obj){
		for(int i=0;i<obj.size();i++){
			if(list[i].equals(obj.list[i])==false){
				return false;
			}
		}
			return true;
	}
	public int size(){
		return size+1;
	}
	
	/**
	 * Inserts a new User into the UserManager
	 * @param user
	 * @param position
	 */
	
	public void addUser(User user, int position){
		size++;
		list[position]=user;
	}
	public void removeUser(int position){
		size=size-1;
		for(int i=position;i<size;i++){
			list[i]=list[i+1];
		}
	}
	public User getUser(int position){
		return list[position];
	}
	public void printAllUsers(){
		System.out.println(toString());
		menu(userManager, backUp);
	}
	public void login(String username, String password){
		if(findUsername(username, userManager)==-1){
			System.out.println("This user does not exist");
			menu(userManager,backUp);
			}
			else{
				User user = userManager.getUser(findUsername(username, userManager));
				if(user.getPassword().equals(password)==true){
					System.out.println("You have successfully logged in.");
					menu(userManager, backUp);
				}
				else{
					System.out.println("Wrong password, please try again.");
					menu(userManager, backUp);
				}
			}
	}
	public String toString(){
		
		String info = "";
		
		for(int i=0;i<size();i++){
			info += list[i].toString()+"\n";
		}
		
		return "Username        Password      Full Name        Email\n"+"---------------------------------------------------------------------------\n"+info;
		
	}
}
