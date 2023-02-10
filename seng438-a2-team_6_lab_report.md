**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  6   |
| -------------- | --- |
| Student Names: |  Maarya Ahmed   |
|                |  Hannah Son   |
|                |  Jinsu Kwak   |
|                |  Jack Li   |

# 1 Introduction

The goal of this assignment was to familarize ourselves the basics of automated unit testing with a focus on testing the specific requirements for each method. The tool used in this assignment is JUnit, a tool that is part of the XUnit framework family. JUnit is the most common testing framework to use in the language of Java. We also used JMocks in Java to test code development. More specifically, we mocked objects to test the code. The SUT is JFreeChart which is an open-source Java framework to for chart calculation, creation, and display.This lab consists of three sections. The first section focuses on familiarization. The second section is dedicated to creating unit tests based on the requirements outlined in Javadocs. Finally, once the test suites have been completed, the last stage involves running the tests on multiple versions of the system under test and collecting the results.

# 2 Detailed description of unit test strategy

RANGE CLASS:


Test Case for Range Class: getLength():

Equivalent Class Partitioning:
 

  -First number in positive, second number positive -> Range(+, +6) →output: 6+5=11: PASS
  
  -First number is positive, second number is negative -> Range(+, -) →-5+6=1: (DONE NOT WORK, GIVES ACC CODE ERROR)
  
  -First number is negative, second number is positive -> Range(-, +) →6--5=11:PASS
  
  -First number is negative, second number is negative -> Range(-, -) → -2-(-4)=2:PASS
  
  -First number is zero, second number is zero -> Range(0, 0) →boundary Value, output = 0-0=0:PASS
  
  -First number is zero, second number is positive -> Range(0, +):Output: 5-0=5:PASS
  
  -First number is positive, second number is zero -> Range(+, 0):Output:0-5=-5(DOES NOT WORK, GIVES ACC CODE ERROR)
  
  -First number is zero, second number is negative -> Range(0, -):-5-0=-5(DOES NOT WORK, GIVES ACC CODE ERROR)
  
  -First number is negative, second number is zero -> Range(-, 0):Output:0--5=5:PASS




Test Case for Range Class: contains(double): boolean

Equivalent Class Partitioning and Boundary Value:


  -Input is above upper boundary (AUB): Should return false
  
  -Input is at upper boundary (UB): Should return true
  
  -Input is at just below upper boundary (BUB): Should return true
  
  -Input is in the middle of range (NOM): Should return true 
  
  -Input is at just above lower boundary (ALB): Should return true
  
  -Input is at lower boundary (LB): Should return true
  
  -Input is below lower boundary (BLB): Should return false




DATA UTILITIES CLASS:

Test Case for DataUtilities Class: getCumulativePercentages(KeyedValues): KeyedValues


Equivalent Class Partitioning and Boundary Value:


  -Input is null: should throw InvalidParameterException
  
  -Input is an empty KeyedValues object: should return valid KeyedValues object 
  
  -Input is a KeyedValues object with one value (positive):  should return valid KeyedValues object 
  
  -Input is a KeyedValues object with five values (positive):  should return valid KeyedValues object 
  
  -Input is a KeyedValues object with both positive and negative values:  should return valid KeyedValues object 
  
  -Input is a KeyedValues object with all zero values:  should return valid KeyedValues object 
  
  -Input is a KeyedValues object where first value is zero:  should return valid KeyedValues object 
  
  -Input is a KeyedValues object where last value is zero:  should return valid KeyedValues object 
  
  -Input is a KeyedValues object with mix of int and double values:  should return valid KeyedValues object 
  


# 3 Test cases developed

Range Class Test Cases Methods:

<img width="600" alt="Screen Shot 2023-02-09 at 1 05 07 PM" src="https://user-images.githubusercontent.com/56771715/217925024-5833705c-e83f-4876-ad22-a90100f469dd.png">

<img width="600" alt="Screen Shot 2023-02-09 at 7 47 07 PM" src="https://user-images.githubusercontent.com/77519521/217987436-ed2df18f-0ee9-49fe-85ab-dd82ab8ed64c.jpg">


Data Utilities Class Test Cases Method:


<img width="600" alt="Screen Shot 2023-02-09 at 1 07 09 PM" src="https://user-images.githubusercontent.com/56771715/217925446-c8d3e978-93e6-4cb5-9ff8-08da637c2383.png">

<img width="600" alt="Screen Shot 2023-02-09 at 7 47 09 PM" src="https://user-images.githubusercontent.com/77519521/217987542-90d7f8ff-050d-4ace-94f1-a47dfeca4c7c.jpg">



// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
