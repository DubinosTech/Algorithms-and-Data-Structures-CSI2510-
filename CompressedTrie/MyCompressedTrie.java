/*final version of Compressed Trie 
Emmanuel Asinyo
*/
public class MyCompressedTrie {
 
    private TreeNodeWithData root;
 
    private int numNodes;
 
    public MyCompressedTrie() { // simple constructor (empty trie consisting of root only)
        root = new TreeNodeWithData(null, null, null, false, null);
        numNodes = 1;
 
    }
 
    public MyCompressedTrie(MyTrie trie) {
        this();
        root.setData("");
        compressLeft(trie.root().getLeftChild(), "0", trie, root);
        compressRight(trie.root().getRightChild(), "1", trie, root);
    }
 
    public void compressLeft(TreeNode node, String s, MyTrie trie, TreeNodeWithData current) {
        if (node == null) {
            return;
        }
        boolean usedOrNot;
        usedOrNot = node.getIsUsed();
        if (node == trie.root()) {
            current = root;
        } else if (!node.getIsUsed() && node.getLeftChild() == null && node.getRightChild() != null) {
        } else if (!node.getIsUsed() && node.getLeftChild() != null && node.getRightChild() == null) {
        } else {
            if (s.charAt(0) == '0') {
                current.setLeftChild(new TreeNodeWithData(current, null, null, usedOrNot, s));
                current = (TreeNodeWithData) current.getLeftChild();
                numNodes++;
            } else if (s.charAt(0) == '1') {
                current.setRightChild(new TreeNodeWithData(current, null, null, usedOrNot, s));
                current = (TreeNodeWithData) current.getRightChild();
                numNodes++;
            }
        }
        compressLeft(node.getLeftChild(), s + '0', trie, current);
        compressLeft(node.getRightChild(), s + '1', trie, current);
    }
 
    public void compressRight(TreeNode node, String s, MyTrie trie, TreeNodeWithData current) {
        if (node == null) {
            return;
        }
        boolean usedOrNot;
        usedOrNot = node.getIsUsed();
        if (node == trie.root()) {
            current = root;
        } else if (!node.getIsUsed() && node.getLeftChild() == null && node.getRightChild() != null) {
        } else if (!node.getIsUsed() && node.getLeftChild() != null && node.getRightChild() == null) {
        } else {
            if (s.charAt(0) == '0') {
                current.setLeftChild(new TreeNodeWithData(current, null, null, usedOrNot, s));
                current = (TreeNodeWithData) current.getLeftChild();
                numNodes++;
            } else if (s.charAt(0) == '1') {
                current.setRightChild(new TreeNodeWithData(current, null, null, usedOrNot, s));
                current = (TreeNodeWithData) current.getRightChild();
                numNodes++;
            }
        }
        compressRight(node.getLeftChild(), s + '0', trie, current);
        compressRight(node.getRightChild(), s + '1', trie, current);
    }
 
    public void printStringsInLexicoOrder() {
        printPreOrder(root, "");
    }
 
    public void printPreOrder(TreeNodeWithData N, String previsVa) {
        if (N != null) {
            if (N.getData() == "") {
            }
            previsVa = previsVa + N.getData();
            if (N.getIsUsed() == true & N.getParent() != null) {
                System.out.print(previsVa + " ");
            }
            printPreOrder((TreeNodeWithData) N.getLeftChild(), previsVa);
            printPreOrder((TreeNodeWithData) N.getRightChild(), previsVa);
        }
        }
   
 
    // the following method that calls its recursive counterpart
    // prints the tree and its data values at nodes in
    // in-order traversal order
 
    public void printInOrder() { // not to be changed
        printInOrder(root);
    }
 
    private void printInOrder(TreeNode N) { // not to be changed
        System.out.print("(");
        if (N != null) {
            printInOrder(N.getLeftChild());
            System.out.print(((TreeNodeWithData) N).getData());
            printInOrder(N.getRightChild());
        }
        System.out.print(")");
    }
 
    public int numNodes() {
        return numNodes;
    }
}