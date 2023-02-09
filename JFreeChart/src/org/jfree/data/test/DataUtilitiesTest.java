package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class DataUtilitiesTest {
	
	 // -----------------------------------------------------------------------------------------
	 // Given Example Test Code from LAB Document
	 // -----------------------------------------------------------------------------------------

	 @Test
	 public void calculateColumnTotalForTwoValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     assertEquals(result, 10.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 // -----------------------------------------------------------------------------------------
	 // Start of Test Code
	 // -----------------------------------------------------------------------------------------
    	
     // ------- Test for calculateColumnTotal(Values2D data, int column) -------
	 
	 /*
	 *  This test will simulate when all the data contains five values
	 *  Expected result: total sum of columns
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalFiveValues() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(5));
	             
	             one(values).getValue(0, 1);
	             will(returnValue(7.5));
	             
	             one(values).getValue(1, 1);
	             will(returnValue(2.5));
	             
	             one(values).getValue(2, 1);
	             will(returnValue(4));
	             
	             one(values).getValue(3, 1);
	             will(returnValue(-4));
	             
	             one(values).getValue(4, 1);
	             will(returnValue(5));

	         }
	     });
	    
	     int columnNumber = 1;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = 15.0;
	     assertEquals("Checking fucntion returns correct column sum",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
	 *  This test will simulate when all the data is negative number
	 *  Expected result: total sum of columns
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalNegative() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(4));
	             
	             one(values).getValue(0, 1);
	             will(returnValue(-7.5));
	             
	             one(values).getValue(1, 1);
	             will(returnValue(-2.5));
	             
	             one(values).getValue(2, 1);
	             will(returnValue(-6));
	             
	             one(values).getValue(3, 1);
	             will(returnValue(-4));

	         }
	     });
	    
	     int columnNumber = 1;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = -20.0;
	     assertEquals("Checking fucntion returns correct column sum when all Negative",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
	 *  This test will simulate when empty data is passed in
	 *  Expected result: 0
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalEmpty() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
				one(values).getRowCount();
				will(returnValue(0));
	         }
	     });
	     int columnNumber = 0;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = 0;
	     assertEquals("The colum total dose not adding up to 0 when data is empty",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
	 *  This test will simulate when invalid column number (negative) passed in
	 *  Expected result: total of zero
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalNegativeColumnIndex() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(3));
	             
	             one(values).getValue(0, -1);
	             will(returnValue(7.5));
	             
	             one(values).getValue(1, -1);
	             will(returnValue(2.5));
	             
	             one(values).getValue(2, -1);
	             will(returnValue(4));
	         }
	     });
	     int columnNumber = -1;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = 0;	// 0 since invalid input
	     assertEquals("calcuateColumTotal() did not return 0 when there was invalid input (negative index)",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
     *  This test will simulate when invalid data object passed in
     *  Expected result: throws InvalidParameterException
	 */
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnNullValue(){
		 final Values2D values = null; 				  // invalid data object (null)
		 try {
			 DataUtilities.calculateColumnTotal(values, 0);// line that exception will occurs
		 }catch(Exception e) {
			 assertEquals("InvalidParameterException was thrown",IllegalArgumentException.class, 
					 e.getClass());
		 }
	 }
	 
	 // ------- Test for createNumberArray(double[] data) -------
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * the doubles will have standard values with a mix of negatives and positives
	  */
	 @Test
	 public void createNumberArrayStandard() {
		 // expected Number array
		 Number[] expected = {19.2,-2.6,40.9,-3.5};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {19.2,-2.6,40.9,-3.5};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [19.2, -2.6, 40.9, -3.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a null double array is passed to createNumberArray
	  * It should throw an InvalidParameterException.
	  */
	 @Test
	 public void createNumberArrayNull() {
		 // Try/catch block to catch exceptions
		 try {
			 // create a null double array to pass
			 double [] passArray = null;
			 DataUtilities.createNumberArray(passArray);
			 

		 }catch(Exception e) {
			 assertEquals("InvalidParameterException was thrown",InvalidParameterException.class, 
					 e.getClass());
		 }

	 }
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * the doubles will have standard values, all being positives
	  */
	 @Test
	 public void createNumberArrayPositives() {
		 // expected Number array
		 Number[] expected = {1.2,2.3,3.4,4.5};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {1.2,2.3,3.4,4.5};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [1.2, 2.3, 3.4, 4.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * the doubles will have standard values, all being negatives
	  */
	 @Test
	 public void createNumberArrayNegatives() {
		 // expected Number array
		 Number[] expected = {-1.2,-2.3,-3.4,-4.5};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {-1.2,-2.3,-3.4,-4.5};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [-1.2, -2.3, -3.4, -4.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an empty array of doubles is passed to createNumberArray
	  */
	 @Test
	 public void createNumberArrayEmpty() {
		 // expected Number array
		 Number[] expected = {};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should be empty: []",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * There will only be one element in the array
	  */
	 @Test
	 public void createNumberArrayOneElement() {
		 // expected Number array
		 Number[] expected = {0};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {0};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values: [0]",
				 expected, testArray);
	 }

	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * There will be 10 elements in the array
	  */
	 @Test
	 public void createNumberArrayTenElements() {
		 // expected Number array
		 Number[] expected = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values: [0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0]",
				 expected, testArray);
	 }
	// ------- End of Test for createNumberArray(double[] data) -------

	// ------- Test for createNumberArray2D(double[][] data) -------
	 /**
	  * This will test the case when an 2D array of doubles is passed to createNumberArray2D
	  * the doubles will have standard values with a mix of negatives and positives
	  */
	 @Test
	 public void createNumberArray2DStandard() {
		 // expected 2D Number array
		 Number[][] expected = {{1.0,-2.0,3.0},{-1.0,2.0,-3.0}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{1.0,-2.0,3.0},{-1.0,2.0,-3.0}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [1.0,-2.0,3.0][-1.0,2.0,-3.0]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a null 2D double array is passed to createNumberArray2D
	  * It should throw an InvalidParameterException.
	  */
	 @Test
	 public void createNumberArray2DNull() {
		 // Try/catch block to catch exceptions
		 try {
			 // create a null double array to pass
			 double [][] passArray = null;
			 DataUtilities.createNumberArray2D(passArray);
			 

		 }catch(Exception e) {
			 assertEquals("InvalidParameterException was thrown",InvalidParameterException.class, 
					 e.getClass());
		 }

	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * the doubles will have standard values, all being positives
	  */
	 @Test
	 public void createNumberArray2DPositives() {
		 // expected Number array
		 Number[][] expected = {{1.5,10.0,20.4,30.5,45.2},{2.0,5.2,6.3,15.4,22.5}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{1.5,10.0,20.4,30.5,45.2},{2.0,5.2,6.3,15.4,22.5}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [1.5,10.0,20.4,30.5,45.2],[2.0,5.2,6.3,15.4,22.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * the doubles will have standard values, all being negatives
	  */
	 @Test
	 public void createNumberArray2DNegatives() {
		 // expected 2D Number array
		 Number[][] expected = {{-1.5,-10.0,-20.4,-30.5,-45.2},{-2.0,-5.2,-6.3,-15.4,-22.5}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{-1.5,-10.0,-20.4,-30.5,-45.2},{-2.0,-5.2,-6.3,-15.4,-22.5}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values : [-1.5,-10.0,-20.4,-30.5,-45.2], [-2.0,-5.2,-6.3,-15.4,-22.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an empty 2D array of doubles is passed to createNumberArray2D
	  * Both arrays will be empty
	  */
	 @Test
	 public void createNumberArray2DBothEmpty() {
		 // expected 2D Number array
		 Number[][] expected = {{},{}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{},{}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should be empty",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * One of the arrays will contain doubles, while the other will be empty
	  */
	 @Test
	 public void createNumberArray2DOneEmpty() {
		 // expected 2D Number array
		 Number[][] expected = {{1.0,-2.0,3.0},{}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{1.0,-2.0,3.0},{}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values [1.0,-2.0,3.0] and be empty"
		 		+ " in the other.",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * There will only be one element in both of the arrays
	  */
	 @Test
	 public void createNumberArray2DOneElements() {
		 // expected 2D Number array
		 Number[][] expected = {{0.0},{0.0}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{0.0},{0.0}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values: [0] and [0]",
				 expected, testArray);
	 }

	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * There will be 10 elements in both the arrays
	  */
	 @Test
	 public void createNumberArray2DTenElements() {
		 // expected 2D Number array
		 Number[][] expected = {{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0},{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0}};
		 // 2D double array to be passed to createNumberArray 
		 double [][] passArray = {{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0},{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values: [0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0],"
		 		+ "[0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0]",
				 expected, testArray);
	 }
	// ------- End of Test for createNumberArray2D(double[][] data) -------
	 
	 // -----------------------------------------------------------------------------------------
	 // End of Test Code
	 // -----------------------------------------------------------------------------------------
    
	 @After
	 public void tearDown() throws Exception {
	 }

	 @AfterClass
	 public static void tearDownAfterClass() throws Exception {
	 }

}