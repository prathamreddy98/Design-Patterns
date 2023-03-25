
package studentRecordsBackupTree.bst;
import java.util.ArrayList;


public class Node implements Subject, Observer {
    int x;
    public ArrayList<Node> obs= new ArrayList<>();
  
    public int bnumber;
    String desc;
    public Node left;
    public Node right;

    public Node(int data)
    {
        bnumber=data;
        left=right=null; 
       
    }
    /*
     * @param addObs()- This method adds the observers to the array list
     */
    public void addObs(Node ob){
        obs.add(ob);

    }
    /* 
     * @param update- updates the nodes
     */
    public void update(int newBnumber){
        bnumber = newBnumber;
    }
    /* 
     * @param notifyObs()- notifies the observer
     */
    public void notifyObs(){
        for(Node ob:obs){
            ob.update(bnumber);
        }
        
        }
        
    }
 

