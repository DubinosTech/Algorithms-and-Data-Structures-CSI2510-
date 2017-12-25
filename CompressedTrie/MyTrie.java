/*** 
 * This is class implements a trie that holds a set of strings.
 * MyTrie stores stores nodes using class TreeNode
 * 
 * Name:  Emmanuel Asinyo 
 * Student Number: 8890676
 * Uottawa Email: easin081@uottawa
 * 
 *
 */

public class MyTrie {
	
	private TreeNode root = null;

	private int numNodes;

    // Constructor. Note that an empty trie (no strings added) contains the root node 
	public MyTrie() {
		root = new TreeNode(null, null, null,false); 
		numNodes=1;
	}

	// Method to be implemented by you. See handout part 1A
	/*
	public TreeNode(TreeNode par, TreeNode left, TreeNode right, boolean used) {
		parent=par;
		leftChild= left;
		rightChild=right;	
		isUsed=used;
	}
    */
	public boolean insert(String s) {
/*TreeNode currentNode = root;
for (int i = 0; i<s.length(); i++) {
if (s.charAt(i) == '0') {
if (currentNode.getLeftChild() == null) {
TreeNode lNode = new TreeNode(currentNode, null, null, false);
currentNode.setLeftChild(lNode);
numNodes++;
}
currentNode = currentNode.getLeftChild();
} else if (s.charAt(i) == '1') {
if (currentNode.getRightChild() == null) {
TreeNode rNode = new TreeNode(currentNode, null, null, false);
currentNode.setRightChild(rNode);
numNodes++;
}
currentNode = currentNode.getRightChild();
}
}
if (currentNode.getIsUsed() == false) {
currentNode.setIsUsed(true);
return true;
} else {
return false;
}
}
*/
        int i=s.length();//lentgh of the string
			    
				
				 TreeNode qq=root;// temporary node 
					

					for (int j=0;j<i;j++)
					{  TreeNode p=new TreeNode(qq,null,null,false);
						if(s.charAt(j)=='1')
						{if (qq.getRightChild()==null)
						    { //set the right node
						    	qq.setRightChild(p);
						     numNodes+=1;
						    }
						    
                            qq=qq.getRightChild();
						 
						}
						else if(s.charAt(j)=='0')
						{
							if (qq.getLeftChild()==null)
						           {
						           
						            qq.setLeftChild(p);
						        numNodes+=1;
						    
						    }	
                         qq=qq.getLeftChild();
						}
					}
					if (qq.getIsUsed()==false)
						{
							qq.setIsUsed(true);
							return true;
						}
					
					else
					     return false;
		   
		}



public boolean search(String s) {

// **** method code to be added in this class *****
		// now we just have a dummy that prints  message and returns true.

    TreeNode q=root;//temporary node
		  int i=s.length();
				
				
		if(q.getRightChild()==null || q.getLeftChild()==null)
			return false;
					
		if(q!=null){
                      
					for (int j=0;j<i;j++)
					{  
						if(s.charAt(j)=='1')
						 {
						 if(q.getRightChild()==null)
						      return false;	
						 q=q.getRightChild();
						 	
						
						 }
						
						 
						
						else if(s.charAt(j)=='0')
						{
							
							if(q.getLeftChild()==null)
								return false;
						    q=q.getLeftChild();
						}

						else
						 		return false;
						    		
					}
					    
					
			}
						
					
		return(q.getIsUsed());	//return IsgetUsed 
		    
		
	    
	}

	

	// Method to be implemented by you. See handout part 1A	
	public void printStringsInLexicoOrder() {
		// ***** method code to be added in this class *****
		// now we just have a dummy method that prints a message.
            
                TreeNode q=root;
            if (q!=null)
                 {String lexico="";//initialisation of the string 
                   printStringsInLexicoOrder(q,lexico);//calling a private method recursively
               }

            else
            	System.out.println("printStringsInLexicoOrder() not implemented!");

	}
	private void printStringsInLexicoOrder(TreeNode q,String lexico) 
              
						{   if(q==null)
							    return;
							if(q.getIsUsed())
								System.out.print(lexico+",");
 
						
                          //calling recursively the left node 
						  printStringsInLexicoOrder(q.getLeftChild(),lexico+'0');
					      
							//calling recursively the right node 
						  printStringsInLexicoOrder(q.getRightChild(),lexico+'1');

                        }
					

		
	
	
	
	
	// the following method that calls its recursive counterpart
	// prints the tree and its boolean values at nodes in 
	// in-order traversal order
	
	public void printInOrder() { // not to be changed
		printInOrder(root);
	}
	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N!=null) {
			printInOrder(N.getLeftChild());
			System.out.print(N.getIsUsed());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}
	

	
	public TreeNode root() { // not to be changed
		return root;
	}
	
	public int numNodes() { // not to be changed
		return numNodes;
	}


}
