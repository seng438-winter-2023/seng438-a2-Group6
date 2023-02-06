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