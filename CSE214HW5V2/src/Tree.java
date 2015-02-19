//Sam Wang
//ID: 108107971
//Homework 5
//CSE214
//Recitation 4 TA: Varun Agrawal
import java.util.Scanner;
/**
 * Tree class that will hold the root of the tree and provide various operations.
 * @author Sam
 *
 */
public class Tree {

	TreeNode root;
	
	Tree(){
	}
	/**
	 * Calls getNodeReference when applicable and adds the node to the tree aftering finding its parent and putting it in the right spot.
	 * @param label
	 * Node's label
	 * @param prompt
	 * Node's prompt
	 * @param message
	 * Node's message
	 * @param parentLabel
	 * Parent's Label
	 * @return
	 */
	public boolean addNode(String label, String prompt, String message, String parentLabel){
		TreeNode node = new TreeNode(label,message,prompt);
		if(root==null){
			root = node;
			System.out.println("\nTree created successfully!");
			return true;
		}
		TreeNode parent = getNodeReference(parentLabel);
		if(parent!=null){
		if(parent.getLeft()==null){
			parent.setLeft(node);
			return true;
		}
		if(parent.getMiddle()==null){
			parent.setMiddle(node);
			return true;
		}
		if(parent.getRight()==null){
			parent.setRight(node);
			return true;
		}
		}
		return false;
	}
	/**
	 * Calls the labelSearch function to find a matching node's label.
	 * @param label
	 * Label to be searched.
	 * @return
	 */
	public TreeNode getNodeReference(String label){
		return labelSearch(label, root);
	}
	/**
	 * Calls the print function to print all the TreeNodes.
	 */
	public void preOrder(){
		System.out.println("Traversing the tree in preorder:");
		System.out.print(print(root));
	}
	/**
	 * Begins the question/answering session.
	 */
	public void beginSession(){
		
		TreeNode current, prev = null;
		System.out.println("\nHelp Session Starting...");
		Scanner input = new Scanner(System.in);
		current=root;
		
		while(current!=null){
			System.out.println("\n"+current.getMessage());
			if(current.getLeft()!=null){
				System.out.println("1 "+current.getLeft().getPrompt());
			}
			if(current.getMiddle()!=null){
				System.out.println("2 "+current.getMiddle().getPrompt());
			}
			if(current.getRight()!=null){
				System.out.println("3 "+current.getRight().getPrompt());
			}
			if(current.isLeaf()==false){
				if(prev!=null){
					System.out.println("B Go Back.");
				}
				System.out.print("0 Exit session.\nChoices> ");
			String in = input.nextLine();
			if(in.equals("1")==false && in.equals("2")==false && in.equals("3")==false && 
					in.equals("0")==false && in.length()>1 && in.equalsIgnoreCase("B")==false){
				System.out.println("Invalid Choice.");
			}
			else{
				if(in.equals("0")){
					current=null;
				}
				if(in.equals("1")){
					prev=current;
					current=current.getLeft();
				}
				if(in.equals("2")){
					if(current.getMiddle()==null){System.out.println("Invalid Choice");}
					else{
						prev=current;
						current=current.getMiddle();
					}
				}
				if(in.equals("3")){
					if(current.getRight()==null){System.out.println("Invalid Choice");}
					else{
						prev=current;
						current=current.getRight();
					}
				}
				if(in.equalsIgnoreCase("B")==true){
					if(prev!=null){
					current=prev;
					prev=null;}
					else{
						
					System.out.println("Invalid Choice. No previous.");
					}
				}
			}
			}
			else{
				current=null;
				}
		}
		
		System.out.println("Thank you for using this automated help service!");
		
	}
	/**
	 * Recursively search the tree for a matching label.
	 * @param label
	 * Label to be searched.
	 * @param root
	 * Tree's root to begin at.
	 * @return
	 */
	public TreeNode labelSearch(String label, TreeNode root){
		TreeNode temp=root;
		
		if(temp.getLabel().equals(label))
			return temp;
		
		if(temp.getLeft()!=null){
			temp=temp.getLeft();
			if(temp.getLabel().equals(label))
				return temp;
			temp=labelSearch(label,temp);
			if(temp!=null&&temp.getLabel().equals(label))
				return temp;
		}
		temp=root;
		if(temp.getMiddle()!=null){
			temp=temp.getMiddle();
			if(temp.getLabel().equals(label))
				return temp;
			temp=labelSearch(label,temp);
			if(temp!=null&&temp.getLabel().equals(label))
				return temp;
		}
		temp=root;
		if(temp.getRight()!=null){
			temp=temp.getRight();
			if(temp.getLabel().equals(label))
				return temp;
			temp=labelSearch(label,temp);
			if(temp!=null&&temp.getLabel().equals(label))
				return temp;
		}
		
		return null;
	}
	/**
	 * Recursively searches the tree from the root and returns a string with all the info attached.
	 * @param root
	 * @return
	 */
	public String print(TreeNode root){
		
		String x = "\nLabel: "+root.getLabel()+"\nPrompt: "+root.getPrompt()+"\nMessage: "+root.getMessage()+"\n";
		if(root.getLeft()!=null){
		x+= print(root.getLeft());
		}
		if(root.getMiddle()!=null){
		x+= print(root.getMiddle());
		}
		if(root.getRight()!=null){
		x+= print(root.getRight());
		}
		return x;
	}
}
