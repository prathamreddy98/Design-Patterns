package studentRecordsBackupTree.util;

import java.util.Scanner;
import java.io.File;
import studentRecordsBackupTree.bst.BST;
import studentRecordsBackupTree.bst.BSTBuilder;
import studentRecordsBackupTree.bst.Node;

public class FileProcessor {
    
    BST mainbst = new BST();
    BST backup1 = new BST();
    BST backup2 = new BST();
    BSTBuilder obj;

    
    public void read_file(String input,int x, String outputFile, String error_file){

        ClearFiles.ClearData(outputFile, error_file);
        ClearFiles.ClearData(error_file, error_file);

        try{

            int temp;
            File f= new File(input);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()){

               temp = sc.nextInt(); 

               Node node = new Node(temp);
               Node node1 = new Node(temp);
               Node node2 = new Node(temp);
                
                node.addObs(node1);
                node.addObs(node2);

                mainbst.insert(node, temp);
                backup1.insert(node, temp);
                backup2.insert(node, temp);
               

            
            }
            
            sc.close();
            Results.write_result("BST: ", outputFile, error_file);

            mainbst.inorder(outputFile, error_file);
            Results.write_result("Backup-1: ", outputFile, error_file);
            
            backup1.inorder(outputFile, error_file);
            Results.write_result("Backup-2: ", outputFile, error_file);
           
            backup2.inorder(outputFile, error_file);
          
             int filesum1 =mainbst.sumNodes(mainbst.root);
             Results.write_result("\nBST: " + filesum1, outputFile, error_file);

             int filesum2 =backup1.sumNodes(backup1.root); 
            Results.write_result("\nBackup-1: " + filesum2, outputFile, error_file);

             int filesum3 =backup2.sumNodes(backup2.root); 
             mainbst.updateNode(mainbst.root,x);
             Results.write_result("\nBackup-2: " + filesum3, outputFile, error_file);

             // sum of nodes after increment
             int filesum5=mainbst.sum_of_nodes(mainbst.root);
            Results.write_result("\n\nBST: " + filesum5, outputFile, error_file);
            int filesum6=backup1.sum_of_nodes(backup1.root);
            Results.write_result("\nBackup-1: " + filesum6, outputFile, error_file);
            int filesum7=backup2.sum_of_nodes(backup2.root);
             Results.write_result("\nBackup-2: " + filesum7, outputFile, error_file);
            
            
        }
        catch(Exception e){
            Results.write_result(e.toString(), error_file, error_file);

        }
        finally{
            System.out.println("Finally block");
            
        }
        
       
    } 

    }
    

   
	

