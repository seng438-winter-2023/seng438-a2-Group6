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
 
  
      -First number in positive, second number positive -> Range(+, +6) → expected output: 6+5 = 11 : PASS
  
      -First number is positive, second number is negative -> Range(+, -) → expected output: -5+6 = 1 : (DOES NOT WORK, GIVES JAVA/SYNTAX CODE ERROR, INPUTTING NUMBERS INCORRECTLY WHICH IS WHY IT GIVES ERROR)
  
      -First number is negative, second number is positive -> Range(-, +) → expected output: 6--5=11 : PASS
  
      -First number is negative, second number is negative -> Range(-, -) → expected output: -2-(-4)=2 : PASS
  
      -First number is zero, second number is zero -> Range(0, 0) →boundary Value; expected output: = 0-0=0 : PASS
  
      -First number is zero, second number is positive -> Range(0, +):expected Output: 5-0=5: PASS
  
      -First number is positive, second number is zero -> Range(+, 0):expected Output:0-5=-5(DOES NOT WORK, GIVES JAVA/SYNTAX CODE ERROR, INPUTTING NUMBERS INCORRECTLY WHICH IS WHY IT GIVES ERROR)
  
      -First number is zero, second number is negative -> Range(0, -): expected output: -5-0=-5 (DOES NOT WORK, GIVES JAVA/SYNTAX CODE ERROR, INPUTTING NUMBERS INCORRECTLY WHICH IS WHY IT GIVES ERROR)
  
      -First number is negative, second number is zero -> Range(-, 0):expected Output: 0-(-5)=5 : PASS




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
  
Test Case for DataUtilities Class: calculateRowTotal(Values2D, int):


Equivalent Class Partitioning and Boundary Values:

    -Calculate row total with 1 row and 1 column: with a value of 3→expected output = 3.0=> actual output: FAIL
    
    -Calculate row total with 1 row and 3 column with a positive value: with a values of 3+3+3→expected output = 9.0=> actual output: FAIL
    
    -Calculate row total with 1 row and 3 column: with a value of 0 in each column→expected output = 0.0=> actual output: PASS
    
    -Calculate row total with 1 row and 4 column where values add up to 0: (0,0)=3, (0,1) = -3, (0,2)= -4, (0,3)=4 →expected output = 0.0=> actual output: FAIL
    
    -Calculate row total with 1 row and 3 columns when the total of row value is a negative number: actual output: FAIL
    
    -Inputting NULL values as Value2D parameter: expected output: catch the exception; actual output: FAIL



<img width="600" alt="Screen Shot 2023-02-09 at 1 05 07 PM" src="https://user-images.githubusercontent.com/56771715/217925024-5833705c-e83f-4876-ad22-a90100f469dd.png">

<img width="600" alt="Screen Shot 2023-02-09 at 7 47 07 PM" src="https://user-images.githubusercontent.com/77519521/217987436-ed2df18f-0ee9-49fe-85ab-dd82ab8ed64c.jpg">

| Method: combine() |  Equivalent Class Partition/Boundary Value   | Actual Output: Pass/Fail|
| --------------------------------------------- | --- | --- |
| testCombineNoNullParametersLowerBound() | Inputs in middle of range (no null values) | Pass |
| testCombineNoNullParametersUpperBound() | Inputs in middle of range (no null values) | Fail |
| testCombineFirstParameterNullLowerBound() | First parameter is Null | Pass |
| testCombineFirstParameterNullUpperBound()| First parameter is Null | Fail |
| testCombineSecondParameterNullLowerBound() | Second parameter is Null | Pass |
| testCombineSecondParameterNullUpperBound() | Second parameter is Null | Fail |
| testCombineBothNullParametersLowerBound() | Both parameters are Null, Expected: NullPointerException | Pass |
| testCombineBothNullParametersUpperBound() | Both parameters are Null, Expected: NullPointerException | Pass |

| Method: getLowerBound() |  Equivalent Class Partition/Boundary Value   | Actual Output: Pass/Fail|
| --------------------------------------------- | --- | --- |
| testGetLowerBoundNominal() | input is at the middle of range (NOM) | Pass |
| testGetLowerBoundPositive() | input range within Positive | Pass |
| testGetLowerBoundPositiveUB() | input is at upper boundary (UB, +1000) | Pass |
| testGetLowerBoundPositiveAUB() | input is at above upper boundary | Pass |
| testGetLowerBoundNegative() | input range within Negative | Pass |
| testGetLowerBoundNegativeLB() | input is at the lower boundary (LB, -1000) | Pass |
| testGetLowerBoundNegativeBLB() | input is at below lower boundary (BLB) | Pass |


Data Utilities Class Test Cases Method:


<img width="600" alt="Screen Shot 2023-02-09 at 1 07 09 PM" src="https://user-images.githubusercontent.com/56771715/217925446-c8d3e978-93e6-4cb5-9ff8-08da637c2383.png">

<img width="600" alt="Screen Shot 2023-02-09 at 7 47 09 PM" src="https://user-images.githubusercontent.com/77519521/217987542-90d7f8ff-050d-4ace-94f1-a47dfeca4c7c.jpg">

| Method: calculateColumnTotal() |  Equivalent Class Partition/Boundary Value   | Actual Output: Pass/Fail|
| --------------------------------------------- | --- | --- |
| testCalculateColumnTotalFiveValues()          | Inputs in middle of range (5 pairs, positive values with positive Index number) | Pass |
| testCalculateColumnTotalNegative()            | Partition, all values are negative | Pass |
| testCalculateColumnTotalEmpty()               | Boundary, Empty key value sets are invalid input. Expected: total of zero  | Pass |
| testCalculateColumnTotalNegativeColumnIndex() | Boundary, negative index is invalid input for Zero-Based Index. Expected: total of zero | Fail |
| testCalculateColumnNullValue()                | Boundary, Null object is invalid data object, Expected: InvalidParameterException | Fail |


// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Each team member was assigned methods from both the Range Class and DataUtilities Class, for which they designed, coded, and ran the test cases. 


Maarya Ahmed

     -Range Class:  
     
          -getLength(): double
          
     -DataUtilities Class:
     
          -calculateRowTotal(Values2D, int): double
          
          
Hannah Son

     -Range Class:  
     
          -contains(double): boolean
          
     -DataUtilities Class:
     
          -getCumulativePercentages(KeyedValues): KeyedValues   
          
          
Jinsu Kwak   

     -Range Class:  
     
          -combine(Range, Range): Range
          
          -getLowerBound(): double
          
     -DataUtilities Class:
     
          -calculateColumnTotal(Values2D, int): double
          
          
Jack Li 

     -Range Class:  
     
          -intersects(double, double): boolean
          
     -DataUtilities Class:
     
          -createNumberArray(double[]): Number[]
          
          -createNumberArray2D(double[][]): Number[][]
          
          
          
# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
