# cs542-fall-22-assign4

## Name:
Pratham Reddy B00918556
Rajat Nipane  B00931099
-----------------------------------------------------------------------
-----------------------------------------------------------------------

## Slack Days Used: 
3

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in WordCount/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile WordCount/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile WordCount/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile WordCount/src/build.xml run -Darg0=Input.txt -Darg1=spellingInputFile.txt -Darg2=8 -Darg3=KMostFrequentWords.txt -Darg4=spellCheckOutput.txt -Darg5=2

## you can run it in the following manner:


Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description of Design:

We have implemented Visitor Pattern and Stratergy Pattern in this Assignment. 
Visitor design pattern is a way of separating an algorithm from an object structure on which it operates. A practical result of this separation is the ability to add new operations to existing object structures without modifying the structures. It is one way to follow the open/closed principle whereas strategy pattern is a behavioral software design pattern that enables selecting an algorithm at runtime. Instead of implementing a single algorithm directly, code receives run-time instructions as to which in a family of algorithms to use. We are using Visitor Pattern for implementing word count and Stratergy Pattern for converting Spell Check and conversion from British to American Words.

## Data Structure :
1. ArrayList: To read the input file containing sentences sentences.
2. Hashmap: to keep count of the words for sending it to priority queue
3. priority queue:  To determine the order of elements
4. iterator: to loop through ArrayList

## Time Complexity : O(n) -- n = number of words.

## Reference:
1. https://www.geeksforgeeks.org/priorityqueue-iterator-method-in-java/#:~:text=PriorityQueue.,what%20present%20in%20the%20Queue
2. https://www.geeksforgeeks.org/iterate-map-java/

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
offense."

Date: 12/11/2022