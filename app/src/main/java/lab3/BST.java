package lab3;

/** a binary search tree class for Lab 3, part 2: Recursion on Trees*/
public class BST {
    public Node root;
    public String traversal;
    /** constructor: create an empty BST */
    public BST() {
        root = null;
    }

    /* return true iff Node n is a leaf node. a null node is not considered
     * a leaf. */
    public boolean isLeaf(Node n) {
	  if(n != null && n.left == null && n.right == null){
		return true;
	  }
        return false;

    }

    /** return the number of nodes in the tree */
    public int size() {
        return size(root);
    }

    /* number of nodes in the tree rooted at n
     * = 0 if n is null
     * = 1 + number of nodes in left + number of nodes in right */
    private int size(Node n) {
        if(n == null){
            return 0;
        } 
	    return 1 + size(n.left) + size(n.right);
    }


    /** appends the values in the tree to String traversal using an in-order traversal */
    public void inOrder() {
        traversal = "";
        inOrder(root);
    }
    /* recursive definition:
    *   inOrder(null) = ""
    *   inOrder(n) = 
    *        "n.value" +
    *        inOrder(n.left) if n has a left
    *        inOrder(n.right) if n has a right */
    private void inOrder(Node n) {
        if(n != null){
            if(n.left != null){
              inOrder(n.left);  
            }
            traversal += n.value;
            if(n.right != null){
               inOrder(n.right); 
            }
        }
    }


    /**  appends the values in the tree to String traversal using a pre-order traversal */
    public void preOrder() {
        traversal = "";
        preOrder(root);
    }
    /* recursive definition:
   *   preOrder(null) = ""
   *   preOrder(n) = 
   *        "n.value" +
   *        preOrder(n.left) if n has a left
   *        preOrder(n.right) if n has a right */
    private void preOrder(Node n) {
        if(n != null){
            traversal += n.value;
            if(n.left != null){
                preOrder(n.left);
            }
            if(n.right != null){
                preOrder(n.right);
            }
        }
    }

    /** appends the values in the tree to String traversal using a post-order traversal */
    public void postOrder() {
        traversal = "";
        postOrder(root);
    }
   /* recursive definition:
   *   postOrder(null) = ""
   *   postOrder(n) =   
   *        "n.value" +
   *        postOrder(n.left) if n has a left
   *        postOrder(n.right) if n has a right */
    private void postOrder(Node n) {
        if(n != null){
            if(n.left != null){
              postOrder(n.left);  
            }
            if(n.right != null){
               postOrder(n.right); 
            }
            traversal += n.value;
        }
    }

    /** return the height of the tree.
     *  recall that the height is the path length from the deepest leaf to the
     *  root. special case: an empty tree (root == null) is defined to have
     *  height = -1 */
    public int height() {
        return height(root);
    }

    /* return the height of the tree rooted at n 
        recursive definition:
    *   height(null) = -1
    *   height(n) = Math.max(leftHeight, rightHeight) + 1
     */
    private int height(Node n) {
        if(n == null){
            return -1;
        }
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /** inner class representing a node in the tree. */
    public class Node {
        public int value;
        public Node parent;
        public Node left;
        public Node right;

        /** constructor: gives default values to all fields */
        public Node() { }

        /** constructor: sets only value */
        public Node(int v) {
            value = v;
        }

        /** constructor: sets value and parent fields */
        public Node(int v, Node p) {
            value = v;
            parent = p;
        }

        /** constructor: sets all fields */
        public Node(int v, Node p, Node l, Node r) {
            value = v;
            parent = p;
            left = l;
            right = r;
        }
    }


    /* methods for testing */

    /** constructor: constructs various BST instances for testing */
    public BST(int testCase) {
        switch(testCase) {
            case 0:
                root = null;
                break;
            case 1:
                root = new Node(4);
                break;
            case 2:
                root = new Node(4);
                root.left = new Node(2);
                root.right = new Node(6);
                break;
            case 3:
                root = new Node(4);
                root.left = new Node(2);
                root.right = new Node(6);
                root.right.right = new Node(7);
                root.right.right.right = new Node(8);
                root.right.right.right.right = new Node(9);
                break;
            case 4:
                root = new Node(4);
                root.left = new Node(2);
                root.right = new Node(6);
                root.right.right = new Node(7);
                root.right.right.right = new Node(8);
                root.right.right.right.right = new Node(9);
                root.left.left = new Node(1);
                root.left.left.left = new Node(0);
                break;
        }
    }

    /** print a sideways representation of the tree - root at left,
     * right is up, left is down. */
    public void printTree() {
        printSubtree(root, 0);
    }
    private void printSubtree(Node n, int level) {
        if (n == null) {
            return;
        }
        printSubtree(n.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("        ");
        }
        System.out.println(n.value);
        printSubtree(n.left, level + 1);
    }
}
