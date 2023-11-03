# CSX42: Assignment 1
## Name: Praqtham Reddy

-----------------------------------------------------------------------
-----------------------------------------------------------------------

## Table of Contents

- [Instructions](#instructions)
  - [Clean](#clean)
  - [Compile](#compile)
  - [Run](#run)
- [Description](#description)
- [Design Overview](#design-overview)
- [Data Structures](#data-structures)
- [Academic Honesty Statement](#academic-honesty-statement)

Following are the commands and the instructions to run ANT on your project.

### Note: build.xml is present in studentCoursesMgmt/src folder.

-----------------------------------------------------------------------

## Instructions

There are two types of instruction that you can use or follow, one is the ant commands another one's are make commands. Since I don't know ant that well I have written make commands.
### Command: ant -buildfile studentCoursesMgmt/src/build.xml clean

## Clean

```sh
make clean
```

Make sure you are on the root directory

Description: It cleans up all the .class files that were generated when you
compiled your code. Also deletes all the log files so you dont have to manually do it everytime.

-----------------------------------------------------------------------

## Compile

### Command: ant -buildfile studentCoursesMgmt/src/build.xml all

```sh
make all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------

## Run

### Command: ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=<input_file.txt> -Darg1=<delete_file.txt> -Darg2=<output1_file.txt> -Darg3=<output2_file.txt> -Darg4=<output3_file.txt>

Replace <fileName.txt> with real file names. For example, if the files are available in the path, you can run it in the following manner:

ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=input_file.txt -Darg1=delete_file.txt -Darg2=output1_file.txt -Darg3=output2_file.txt -Darg4=output3_file.txt

To run it according to my design enter the following command:

```shell
make run
```

You can edit arguments if you want in the Makefile.
Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------

## Description

Took File io from [here]("https://docs.oracle.com/javase/tutorial/essential/io/file.html")
Took method reflection for dynamic function call from [here](https://www.oracle.com/technical-resources/articles/java/javareflection.html) and [here](https://www.baeldung.com/java-method-reflection)

-----------------------------------------------------------------------

## Design Overview

![design](design_overview.png)

## Data Structures

Lists (ArrayLists):
Usage: I am using ArrayLists to store collections of students and courses.
Justification: ArrayLists are chooen as I wanted to dynamically grow and shrink them and also they are the easiest to implement. They provide O(1) time complexity for accessing elements by index, making them suitable for storing and retrieving lists of students and courses. However, they may require occasional resizing, which can lead to O(n) time complexity in some cases.

Reflection (Method Invocation):
Usage: Reflection is used to dynamically invoke methods on Student objects to access their course choices.
Justification: Reflection allows to access methods and fields of objects at runtime, making my code more flexible.

StringBuilder:
Usage: Using StringBuilder to efficiently construct and manipulate strings, especially for generating output results.
Justification: StringBuilder is more efficient than using regular string concatenation, especially when I need to perform many string append operations.

## Academic Honesty statement

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 09/28/2022
