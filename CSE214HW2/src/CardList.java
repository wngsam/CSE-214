//Sam Wang
//ID: 108107971
//Homework 2
//CSE214
//Recitation 4 TA: Varun Agrawal 
/**
 * CardList holds details on the linkedlist and contain information on linked nodes.
 * head represents the current top node in the list.
 * tail represents the current last card on the list.
 * current represents the node you are currently dealing with.
 * @author Sam
 *
 */
public class CardList {

	CardInfoNode head, tail, current;
	/**
	 * Constructor that creates a CardList and sets its data to null
	 * Order of Complexity: O(1)
	 */
	public CardList(){
		head=null;
		tail=null;
		current=null;
	}
	/**
	 * Inserts a CardInfo object into a CardInfoNode and links it to the list.
	 * @param info
	 * CardInfo object that will be linked into a new node
	 * Order of Complexity: O(n)
	 */
	public void insertCardInfo (CardInfo info){
		if(head==null){
			CardInfoNode node = new CardInfoNode(null,null);
			node.setCardInfo(info);
			head=node;
			tail=node;
			current=node;
		}
		else{
			current=head;
			int counter=0;
			while(counter<1){
				if(current.getInfo().getAccountName().equalsIgnoreCase(info.getAccountName())){
					if(current.getInfo().getCompany().equalsIgnoreCase(info.getCompany()) 
							|| current.getInfo().getCompany().compareTo(info.getCompany())<0){
						CardInfoNode node = new CardInfoNode(current.getNext(),current);
						node.setCardInfo(info);
						current.setNext(node);
						if(current==tail){
							tail=node;
							}
						counter=2;
					}
					
						if(current.getInfo().getCompany().compareTo(info.getCompany())>0){
							CardInfoNode node = new CardInfoNode(current,current.getPrev());
							node.setCardInfo(info);
						if(current.getPrev()!=null){
							current.getPrev().setNext(node);
						}
						current.setPrev(node);
						
						if(current==head){
							head=node;
						}
						counter=2;
						}
				}
				if(current.getNext()!=null){
					current=current.getNext();
				}
				else{
					counter=1;
				}
				
			}
			if(counter==1){
				current=head;
				while(current.getInfo().getAccountName().compareTo(info.getAccountName())<0){
					if(current.getNext()!=null){
						current=current.getNext();
					}
					else{
						CardInfoNode node = new CardInfoNode(null,current);
						node.setCardInfo(info);
						current.setNext(node);
							tail=node;
						current=node;
					}
				}
				if(current.getInfo().getAccountName().compareTo(info.getAccountName())!=0){
					CardInfoNode node = new CardInfoNode(current,current.getPrev());
					node.setCardInfo(info);
					if(current.getPrev()!=null){
						current.getPrev().setNext(node);}
						current.setPrev(node);
					if(current==head){
						head=node;
						}
					}
				}
			}
		}
	/**
	 * Removes a CardInfo Node from the list, unlinking it
	 * @param accountName
	 * Name of the CardInfo to be removed
	 * @param issuedCompany
	 * Name of the card's company
	 * @return
	 * Returns true if removal was successful and false if unsuccessful
	 * Order of Complexity: O(n)
	 */
	public boolean removeCardInfo (String accountName, String issuedCompany){
		current=head;
		if(current!=null){
		while(current!=null){
			if(current.getInfo().getAccountName().equalsIgnoreCase(accountName) 
					&& current.getInfo().getCompany().equalsIgnoreCase(issuedCompany)){
				if(current==head){
					if(current.getNext()!=null){
						current.getNext().setPrev(current.getPrev());}
						head=current.getNext();
					return true;
				}
				else if(current==tail){
					if(current.getPrev()!=null){
						current.getPrev().setNext(current.getNext());}
						tail=current.getPrev();
					return true;
				}
				else{
					current.getNext().setPrev(current.getPrev());
					current.getPrev().setNext(current.getNext());
					return true;
				}
			}
			current=current.getNext();
			}
		}
		return false;
	}
	/*
	 * Sets the current to the input node
	 * @param node
	 * CardInfoNode to be set as current
	 * Order of Complexity: O(1)
	 */
	public void setCurrent (CardInfoNode node){
		current=node;
	}
	/**
	 * Sets head to the input node
	 * @param node
	 * CardInfoNode to be set as head
	 * Order of Complexity: O(1)
	 */
	public void setHead (CardInfoNode node){
		head=node;
	}
	/* Sets tail to the input node
	 * @param node
	 * CardInfoNode to be set as tail
	 * Order of Complexity: O(1)
	 */
	public void setTail (CardInfoNode node){
		tail=node;
	}
	/**
	 * Get the current node
	 * @return
	 * Returns the current node
	 * Order of Complexity: O(1)
	 */
	public CardInfoNode getCurrent (){
		return current;
	}
	/**
	 * Get the head node
	 * @return
	 * Returns the Head node
	 * Order of Complexity: O(1)
	 */
	public CardInfoNode getHead (){
		return head;
	}
	/**
	 * Get the tail node
	 * @return
	 * Returns the tail node
	 * Order of Complexity: O(1)
	 */
	public CardInfoNode getTail (){
		return tail;
	}
	/**
	 * Prints out all the CardInfo contained in the list.
	 * Order of Complexity: O(n)
	 */
	public void displayAll(){
		current=head;
		while(current!=null){
			System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d", current.getInfo().getAccountName(), 
					current.getInfo().getCompany(), current.getInfo().getDate(), current.getInfo().getLastBalance(), 
					current.getInfo().getAccountStatus());
					current=current.getNext();
		}
		current=head;
	}
	/**
	 * Displays all the cards under the input name
	 * @param name
	 * Name of the cards you would like to print
	 * Order of Complexity: O(n)
	 */
	public void displayByPerson(String name){
		current=head;
		while(current!=null){
			if(current.getInfo().getAccountName().equalsIgnoreCase(name)){
				System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d \n", current.getInfo().getAccountName(), 
						current.getInfo().getCompany(), current.getInfo().getDate(), current.getInfo().getLastBalance(), 
						current.getInfo().getAccountStatus());
			}
			current=current.getNext();
		}
		current=head;
	}
	/**
	 * Displays all the cards under this company name
	 * @param company
	 * Company name of the cards you would like to print
	 * Order of Complexity: O(n)
	 */
	public void displayByCompany(String company){
		current=head;
		while(current!=null){
			if(current.getInfo().getCompany().equalsIgnoreCase(company)){
				System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d \n", current.getInfo().getAccountName(), 
						current.getInfo().getCompany(), current.getInfo().getDate(), current.getInfo().getLastBalance(), 
						current.getInfo().getAccountStatus());
		}
			current=current.getNext();
		}
		current=head;
	}
	/**
	 * Displays all the cards of this status or more
	 * @param status
	 * The cards of this status or more you would like to show
	 * Order of Complexity: O(n)
	 */
	public void displayByStatus(int status){
		current=head;
		while(current!=null){
			if(current.getInfo().getAccountStatus()>=status){
			System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d \n", current.getInfo().getAccountName(), 
					current.getInfo().getCompany(), current.getInfo().getDate(), current.getInfo().getLastBalance(), 
					current.getInfo().getAccountStatus());
			}
			current=current.getNext();
		}
		current=head;
	}
	/**
	 * Display cards by balance
	 * @param balance
	 * Cards of this balance or more you would like to print
	 * Order of Complexity: O(n)
	 */
	public void displayByBalance(double balance){
		current=head;
		while(current!=null){
			if(current.getInfo().getLastBalance()>=balance){
			System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d \n", current.getInfo().getAccountName(), 
					current.getInfo().getCompany(), current.getInfo().getDate(), current.getInfo().getLastBalance(), 
					current.getInfo().getAccountStatus());
			}
			current=current.getNext();
		}
		current=head;
	}
	/**
	 * Displays the top node
	 * Order of Complexity: O(1)
	 */
	public void displayTop(){
		if(head==null){
			System.out.println("List is empty.");
		}
		else{
		System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d \n", head.getInfo().getAccountName(), head.getInfo().getCompany(), 
				head.getInfo().getDate(), head.getInfo().getLastBalance(), head.getInfo().getAccountStatus());
		}
	}
	/**
	 * Displays the next node
	 * Order of Complexity: O(1)
	 */
	public void displayNext(){
		if(head==null){
			System.out.println("List is empty.");
		}
		else if(current.getNext()==null){
			System.out.println("There is no next.");
		}
		else{
		System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d \n", current.getNext().getInfo().getAccountName(), 
				current.getNext().getInfo().getCompany(), current.getNext().getInfo().getDate(), current.getNext().getInfo().getLastBalance(), 
				current.getNext().getInfo().getAccountStatus());
		}
	}
	/**
	 * Displays the previous node
	 * Order of Complexity: O(1)
	 */
	public void displayPrevious(){
		if(head==null){
			System.out.println("List is empty.");
		}
		else if(current.getPrev()==null){
			System.out.println("There is no previous.");
		}
		else{
		System.out.printf("\n%-25s  %-15s  %-10s   %-10.2f   %-6d \n", current.getPrev().getInfo().getAccountName(), 
				current.getPrev().getInfo().getCompany(), current.getPrev().getInfo().getDate(), current.getPrev().getInfo().getLastBalance(), 
				current.getPrev().getInfo().getAccountStatus());
			}
		}
}
