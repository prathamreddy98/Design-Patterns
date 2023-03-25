# cs542-fall-22-assign2
Name: Pratham Reddy
Number of slack days used : 0
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
## Instructions to compile:
  ant -buildfile studentRecordsBackupTree/src/build.xml all

## Instructions to run:

ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=10 -Darg4=10
-----------------------------------------------------------------------  
## Instruction to clean
ant -buildfile studentRecordsBackupTree/src/build.xml clean

-----------------------------------------------------------------------
#Data structure used:
-----------------------------------------------------------------------
I have used array list since the size of the array list can be increased as elements are added to the list so it increases the size 
dynamically as needed. Hence it saves the memory cost. Also assuming that the size of the array list will keep on growing frequently 
as observers will add.
Space complexity for BST- O(n)
Time complexity is - O(log n)
-----------------------------------------------------------------------
##References:
-----------------------------------------------------------------------
https://www.programiz.com/dsa/binary-search-tree
https://www.geeksforgeeks.org/java-program-to-write-into-a-file/

-----------------------------------------------------------------------
## Description of Design:
-----------------------------------------------------------------------
The bstInput.txt file contains the input, the input is read in the fileprocessor file.
The BST class contains the implementation of the Binary search tree.
The Observer.java and Subject.java contains the methods implemented by the subject and the object.
The Node class is used for creating nodes and all the operations of BST are performed in the BST.java file.
The clearFiles file is used to clear the output and error files so whenever the code is implemented the old files are cleared from the file.
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 10/23/2022 