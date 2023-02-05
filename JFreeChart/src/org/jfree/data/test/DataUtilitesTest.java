package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class DataUtilitesTest {
	
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
	 @Test(expected = IllegalArgumentException.class) // expecting an exception
	 public void testCalculateColumnNullValue(){
		 final Values2D values = null; 				  // invalid data object (null)
		 DataUtilities.calculateColumnTotal(null, 0);// line that exception will occurs
	 }
	 
	 // -----------------------------------------------------------------------------------------
	 // End of Test Code
	 // -----------------------------------------------------------------------------------------
    
	 @After
	 void tearDown() throws Exception {
	 }

	 @AfterClass
	 public static void tearDownAfterClass() throws Exception {
	 }

}
