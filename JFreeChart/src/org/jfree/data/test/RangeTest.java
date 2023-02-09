package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
    private Range exampleRange;			// Given Example from LAB Document
    private Range rangeNomial;
    private Range rangePositive;
    private Range rangePositiveUB;		// Assume Upper Bound is 1000
    private Range rangeNegative;
    private Range rangeNegativeLB;		// Assume Lower Bound is -1000
    private Range rangeLarge;
    private Range intersectRange;
    private Range exampleRange2;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	rangeNomial = new Range(-10,10);
        rangePositive = new Range(1, 100);
        rangePositiveUB = new Range(1, 1000); 
        rangeNegative = new Range(-100, -1);
        rangeNegativeLB = new Range(-1000, 1); 
        intersectRange = new Range(5,15);
    }

	// -----------------------------------------------------------------------------------------
	// Given Example Test Code from LAB Document
	// -----------------------------------------------------------------------------------------
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
	// -----------------------------------------------------------------------------------------
	// Start of Test Code
	// -----------------------------------------------------------------------------------------
    	
    // ------- Test for combine(Range range1, Range range2) -------
    
    /*
     *  This test will simulate when both parameters are not NULL
     *  Expected result: new range should be created from two input ranges
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineNoNullParametersLowerBound() {
		// combine two ranges  : (-1, 11), (-10, -9)
		Range tempRange = Range.combine(new Range(-1, 11), new Range(-10, -9));													
		double actualLowerBound = tempRange.getLowerBound();
		double expectedLowerBound = -10.0;
		assertEquals("Checking combinded lower bound when both parameters are non null value", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
   *  This test will simulate when both parameters are not NULL
     *  Expected result: new range should be created from two input ranges
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineNoNullParametersUpperBound() {
		// combine two ranges  : (-1, 11), (-10, -9)
		Range tempRange = Range.combine(new Range(-1, 11), new Range(-10, -9));													
		double actualUpperBound = tempRange.getUpperBound();
		double expectedUpperBound = 11.0;
		assertEquals("Checking combinded upper bound when both parameters are non null value", expectedUpperBound, actualUpperBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the first parameter is NULL
     *  Expected result: returns second parameter's lower bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineFirstParameterNullLowerBound() {
		// combine two ranges  : null, (-5, 6)
		Range tempRange = Range.combine(null, new Range(-5, 6));
		double actualLowerBound = tempRange.getLowerBound();
		double expectedLowerBound = -5.0;
		assertEquals("Checking combinded lower bound when first parameter is null", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the first parameter is NULL
     *  Expected result: returns second parameter's upper bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineFirstParameterNullUpperBound() {
		// combine two ranges  : null, (-5, 6)
		Range tempRange = Range.combine(null, new Range(-5, 6));
		double actualUpperBound = tempRange.getUpperBound();
		double expectedUpperBound = 6.0;
		assertEquals("Checking combinded upper bound when first parameter is null", expectedUpperBound, actualUpperBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the second parameter is NULL
     *  Expected result: returns first parameter's lower bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineSecondParameterNullLowerBound() {
		// combine two ranges  : (-3,7), null
		Range tempRange = Range.combine(new Range(-3, 7), null);
		double actualLowerBound = tempRange.getLowerBound();
		double expectedLowerBound = -3.0;
		assertEquals("Checking combinded lower bound when second parameter is null", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the second parameter is NULL
     *  Expected result: returns first parameter's upper bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineSecondParameterNullUpperBound() {
		// combine two ranges  : (-3,7), null
		Range tempRange = Range.combine(new Range(-3, 7), null);
		double actualUpperBound = tempRange.getUpperBound();
		double expectedUpperBound = 7.0;
		assertEquals("Checking combinded upper bound when second parameter is null", expectedUpperBound, actualUpperBound, .000000001d);
	}
	
    /*
     *  This test will simulate when both parameters are NULL
     *  Expected result: returns null, should not create Range object
     */
	@Test(expected = NullPointerException.class)
	public void testCombineBothNullParametersLowerBound() {
		Range tempRange = Range.combine(null, null);
		double actualLowerBound = tempRange.getLowerBound(); 
		assertNull("Checking combinded lower bound when both parameter are null", actualLowerBound);
	}
	
    /*
     *  This test will simulate when both parameters are NULL
     *  Expected result: returns null, should not create Range object
     */
	@Test(expected = NullPointerException.class)
	public void testCombineBothNullParametersUpperBound() {
		Range tempRange = Range.combine(null, null);
		double actualUpperBound = tempRange.getUpperBound(); 
		assertNull("Checking combinded upper bound when both parameter are null", actualUpperBound);
	}
	
    // ------- Test for getLowerBound() -------
	// Assumed UpperBound = 1000, LowerBound = -1000;
	
	
    /*
     *  This test will simulate when input parameter is nominal range
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNominal() {
		double actualLowerBound = rangeNomial.getLowerBound();
		double expectedLowerBound = -10.0;
		assertEquals("Lower bound was differ when input was nomial range", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is positive range
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundPositive() {
		double actualLowerBound = rangePositive.getLowerBound();
		double expectedLowerBound = 1.0;
		assertEquals("Lower bound was differ when input was positive range", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is positive range, and have upper bound
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundPositiveUB() {
		double actualLowerBound = rangePositiveUB.getLowerBound();
		double expectedLowerBound = 1;
		assertEquals("Lower bound was differ when input was positive range, and have upper bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is positive range, and have above upper bound
     *  Expected result: lower bound of input parameter
     *  
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundPositiveAUB() {
		Range rangePositiveAUB = new Range (1, 1001); 	// Assumed Upper bound is 1000
		double actualLowerBound = rangePositiveAUB.getLowerBound();
		double expectedLowerBound = 1;
		assertEquals("Lower bound was differ when input was positive range, and have above upper bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is Negative range
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNegative() {
		double actualLowerBound = rangeNegative.getLowerBound();
		double expectedLowerBound = -100;
		assertEquals("Lower bound was differ when input was Nagative range", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is Negative range, and have lower bound
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNegativeLB() {
		double actualLowerBound = rangeNegativeLB.getLowerBound();
		double expectedLowerBound = -1000;
		assertEquals("Lower bound was differ when input was Nagative range, and have lower bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is Negative range, and have below lower bound
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNegativeBLB() {
		Range rangeNegativeBLB = new Range (-1001, -1); 	// Assumed lower bound is -1000
		double actualLowerBound = rangeNegativeBLB.getLowerBound();
		double expectedLowerBound = -1001;
		assertEquals("Lower bound was differ when input was Nagative range, and have below lower bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
    // ------- Test for intersects(double, double) -------
	// The assumed Range lower = 5, upper = 15;
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * The doubles will both be within the range and will satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesWithinRange() {
		boolean result = intersectRange.intersects(10.5,14.5);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the lower and upper limit will have the same value
	 * The values will exist on the boundary of the test range
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsWithinRangeToRightLowerEqualsUpper() {
		boolean result = intersectRange.intersects(15,15);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the lower and upper limit will have the same value
	 * The values will exist outside the boundaries of the test range 
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsOutsideRangeToRightLowerEqualsUpper() {
		boolean result = intersectRange.intersects(-5,-5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * The doubles will both be within the range and will not satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the input is invalid.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesWithinRangeLowerGreaterThanUpper() {
		boolean result = intersectRange.intersects(14.5,10.5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the double for lower will be outside the test range on the right side
	 * The double for upper will be within the test range
	 * and will not satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the input is invalid.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesOnRightLowerGreaterThanUpper() {
		boolean result = intersectRange.intersects(20,10.5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the double for lower will be outside the test range on the right side
	 * The double for upper will be within the test range
	 * and will not satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the input is invalid.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesOnLeftLowerGreaterThanUpper() {
		boolean result = intersectRange.intersects(5.5,-5.5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}	
	
	
	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * One double will be within the range on the right side and the doubles will satisfy the conditions that lower <= upper 
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsWithinRangeToRight() {
		boolean result = intersectRange.intersects(14.5,20);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * One double will be within the range on the left side and the doubles will satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsWithinRangeToLeft() {
		boolean result = intersectRange.intersects(-5.2,5.2);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the upper value will be equal to the bound of the range on the left side and 
	 * the doubles will satisfy the conditions that lower <= upper 
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsEqualRangeToLeft() {
		boolean result = intersectRange.intersects(-5.2,5);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * The doubles will be outside the test range, and the doubles will satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the ranges should not intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsOutsideRange() {
		boolean result = intersectRange.intersects(-15.5,-5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}
	// ------- End of tests for intersects(double, double) -------		
	
	
		//	 ------- Test for getLength() -------
	/*
	 * This will test the getLength function by inputting two inputs as positive numbers
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthPosPosNum() {
		exampleRange2 = new Range(1, 100);
	    assertEquals("The length of the range is:",
	    99, exampleRange2.getLength(), .000000001d); //expected output: 100-1=99
	}
	
	/*
	 * This will test the getLength function by inputting first number as negative and second number as postive
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthNegPosNum() {
		exampleRange2 = new Range(-10, 5);
	    assertEquals("The length of the range is:",
	    15, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting two inputs as negative numbers
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthNegNegNum() {
		exampleRange2 = new Range(-6, -5);
	    assertEquals("The length of the range is:",
	    1, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting two inputs as zeros
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthZeroZeroNum() {
		exampleRange2 = new Range(0, 0);
	    assertEquals("The length of the range is:",
	    0, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting first number as zero and second number as positive number
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthZeroPosoNum() {
		exampleRange2 = new Range(0, 5);
	    assertEquals("The length of the range is:",
	    5, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting first number as negative number and second number as zero
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthNegZeroNum() {
		exampleRange2 = new Range(-8, 0);
	    assertEquals("The length of the range is:",
	    8, exampleRange2.getLength(), .000000001d); 
	}
	
	// ------- End of tests for getLength() -------		
	
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
