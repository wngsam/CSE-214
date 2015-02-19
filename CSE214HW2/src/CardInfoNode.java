//Sam Wang
//ID: 108107971
//Homework 2
//CSE214
//Recitation 4 TA: Varun Agrawal 
/**
 * CardInfoNode creates a node that represents a card in a linkedlist and contain information on its placement.
 * info connects the node with its CardInfo object containing the account's info.
 * next refers to the next node after this node.
 * prev refers to the previous node before this node.
 * @author Sam
 *
 */
public class CardInfoNode {
	
	CardInfo info;
	CardInfoNode next=null;
	CardInfoNode prev=null;
	/**
	 * Empty Constructor
	 * Order of Complexity: O(1)
	 */
	public CardInfoNode(){
	}
	/**
	 * Constructor for making node object 
	 * @param next
	 * The next node after this recently created node
	 * @param prev
	 * The previous node before this recently created node
	 * Order of Complexity: O(1)
	 */
	public CardInfoNode(CardInfoNode next, CardInfoNode prev){
		this.next=next;
		this.prev=prev;
	}
	/**
	 * Modifies/sets the cardinfo object to the node.
	 * @param info
	 * CardInfo object to link to the node.
	 * Order of Complexity: O(1)
	 */
	public void setCardInfo(CardInfo info){
		this.info=info;
	}
	/**
	 * Returns the CardInfo object of this node
	 * @return
	 * CardInfo node linked to this node.
	 * Order of Complexity: O(1)
	 */
	public CardInfo getInfo(){
		return info;
	}
	/**
	 * Sets the next node after this node
	 * @param node
	 * The node you want to link after this node.
	 * Order of Complexity: O(1)
	 */
	public void setNext(CardInfoNode node){
		next=node;
	}
	/**
	 * Sets the previous node before this node
	 * @param node
	 * The node you want to link before this node.
	 * Order of Complexity: O(1)
	 */
	public void setPrev(CardInfoNode node){
		prev=node;
	}
	/**
	 * Get the node after this node
	 * @return
	 * CardInfoNode that is linked after this node.
	 * Order of Complexity: O(1)
	 */
	public CardInfoNode getNext(){
		return next;
	}
	/**
	 * 	Get the node before this node
	 * @return
	 * CardInfoNode that is linked before this node.
	 * Order of Complexity: O(1)
	 */
	public CardInfoNode getPrev(){
		return prev;
	}
}
