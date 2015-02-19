//Sam Wang
//ID: 108107971
//Homework 5
//CSE214
//Recitation 4 TA: Varun Agrawal
/**
 * TreeNode class containing references to 3 child nodes and label, message and prompt Strings.
 * @author Sam
 *
 */
public class TreeNode {

	TreeNode left,middle,right;
	private String label;
	private String message;
	private String prompt;
	/**
	 * Empty Constructor
	 */
	TreeNode(){
	}
	/**
	 * TreeNode constructor with parameters
	 * @param label
	 * Takes in the label
	 * @param message
	 * Takes in the message
	 * @param prompt
	 * Takes in the prompt
	 */
	TreeNode(String label, String message, String prompt){
		this.label=label;
		this.message=message;
		this.prompt=prompt;
	}
	/**
	 * Returns the left child of the TreeNode
	 * @return
	 */
	public TreeNode getLeft(){
		return left;
	}
	/**
	 * Sets the reference to the TreeNode's left child.
	 * @param left
	 */
	public void setLeft(TreeNode left){
		this.left=left;
	}
	/**
	 * Returns the middle child of the TreeNode
	 * @return
	 */
	public TreeNode getMiddle(){
		return middle;
	}
	/**
	 * Sets the reference to the TreeNode's middle child.
	 * @param middle
	 */
	public void setMiddle(TreeNode middle){
		this.middle=middle;
	}
	/**
	 * Returns the right child of the TreeNode
	 * @return
	 */
	public TreeNode getRight(){
		return right;
	}
	/**
	 * Sets the reference to the right child of the TreeNode
	 * @param right
	 */
	public void setRight(TreeNode right){
		this.right=right;
	}
	/**
	 * Returns the label of the TreeNode
	 * @return
	 */
	public String getLabel(){
		return label;
	}
	/**
	 * Sets the label for the TreeNode
	 * @param label
	 */
	public void setLabel(String label){
		this.label=label;
	}
	/**
	 * Returns the message of the TreeNode
	 * @return
	 */
	public String getMessage(){
		return message;
	}
	/**
	 * Sets the Message for the TreeNode
	 * @param message
	 */
	public void setMessage(String message){
		this.message=message;
	}
	/**
	 * Return the prompt of the TreeNode
	 * @return
	 */
	public String getPrompt(){
		return prompt;
	}
	/**
	 * Sets the prompt for the TreeNode
	 * @param prompt
	 */
	public void setPrompt(String prompt){
		this.prompt=prompt;
	}
	/**
	 * Returns whether the TreeNode contains children.
	 * @return
	 */
	public boolean isLeaf(){
		return(left==null && middle==null && right==null);
	}
}