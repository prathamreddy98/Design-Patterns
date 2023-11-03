package studentRecordsBackupTree.bst;
import studentRecordsBackupTree.util.Results;

public class BST {
    Results r =new Results();
  int sum=0;
  int tempSum=0;
  int tempSum_1=0;
    
  
    public Node root;
  
    public BST() {
      root = null;
    }
  
    /**
     * @param bnumber-inserts the bnumber in the node
     * @param bnum
     */
    public void insert(Node bnumber, int bnum) {
      root = insertbnumber(root, bnumber ,bnum);
    }
  
    // Insert bnumber in the tree
    Node insertbnumber(Node root, Node addedNode ,int bnumber) {
      // Return a new node if the tree is empty
      if (root == null) {
        root = addedNode;
        return root;
      }
  
      
      if (bnumber < root.bnumber)
        root.left = insertbnumber(root.left,addedNode, bnumber);
      else if (bnumber > root.bnumber)
        root.right = insertbnumber(root.right, addedNode ,bnumber);
  
      return root;
    }
  
    /**
     * @param inorder- performs inorder traversal on the BST
     * @param outputFile- prints output file of the inorder traversal
     * @param error_file- to write errors
     */
    public void inorder(String outputFile, String error_file) {
      inorderRec(root, outputFile, error_file);
      Results.write_result("\n", outputFile, error_file);
    }
  
    // Inorder Traversal
    void inorderRec(Node root, String outputFile, String error_file) {
      if (root != null) {
        inorderRec(root.left, outputFile, error_file);
        Results.write_result(root.bnumber + " ,", outputFile, error_file);
    
        inorderRec(root.right, outputFile, error_file);
      }
    }
    /**
     * @param root root is passed to compute sum of all the nodes.
     * @return returns the sum of the nodes
     */
    public int sumNodes(Node root) {

      if (root == null) {
          return 0;
      }

      sumNodes(root.left);
      assignSum(root.bnumber);
      sumNodes(root.right);
      return tempSum;

    }
    /**
     * @param tempSum- globally declare variable initialized to 0 used to calculate the sum of nodes
     */
    public void assignSum(int temp_1) {
      tempSum += temp_1;
  }

  /**
   * @param temp_2 used to print the sum of all nodes after the increment.
   */
  public void assignSum_1(int temp_2) {
    tempSum_1 += temp_2;
}

  /**
   * 
   * @param x the increment value which is passed to nodes so the nodes are incremented by x.
   */
  public void updateNode(Node root, int x) {
      if (root == null) {
          return  ;
      }

      updateNode(root.left, x);

      root.bnumber += x;
      root.notifyObs();
      updateNode(root.right, x);
    
  }
  public int sum_of_nodes(Node root){
    if (root == null) {
      return 0;
  }

  sum_of_nodes(root.left);
    assignSum_1(root.bnumber);
    sum_of_nodes(root.right);
    return tempSum_1;



  }
    
  }