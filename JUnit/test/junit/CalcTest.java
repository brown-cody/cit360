
/*
***assertArrayEquals
***assertEquals
***assertFalse
***assertNotNull
***assertNotSame
***assertNull
assertSame
***assertThat
***assertTrue
*/

package junit;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CalcTest {
    
    public CalcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Calc.
     */
    @Test
    public void testAdd() {
        System.out.println("assertEquals      - add");
        double inputA = 5;
        double inputB = 7;
        Calc instance = new Calc();
        double expResult = 12;
        double result = instance.add(inputA, inputB);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of subtract method, of class Calc.
     */
    @Test
    public void testSubtract() {
        System.out.println("assertEquals      - subtract");
        double inputA = 17;
        double inputB = 8;
        Calc instance = new Calc();
        double expResult = 9;
        double result = instance.subtract(inputA, inputB);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testSubtract2() {
        System.out.println("assertNotNull     - subtract");
        double inputA = 17;
        double inputB = 8;
        Calc instance = new Calc();
        double result = instance.subtract(inputA, inputB);
        assertNotNull(result);
    }

    /**
     * Test of multiply method, of class Calc.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double inputA = 12;
        double inputB = 1;
        Calc instance = new Calc();
        double expResult = 12;
        double result = instance.multiply(inputA, inputB);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testMultiply2() {
        System.out.println("assertNotSame     - multiply");
        double inputA = 12;
        double inputB = 1;
        Calc instanceA = new Calc();
        Calc instanceB = new Calc();
        assertNotSame(instanceA, instanceB);
    }

    /**
     * Test of divide method, of class Calc.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        double inputA = 60;
        double inputB = 5;
        Calc instance = new Calc();
        double expResult = 12;
        double result = instance.divide(inputA, inputB);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testDivide2() {
        System.out.println("assertThat        - divide");
        double inputA = 100;
        double inputB = 20;
        Calc instance = new Calc();
        double expResult = 5;
        double result = instance.divide(inputA, inputB);
        assertThat(result, is(expResult));
    }

    /**
     * Test of sqrt method, of class Calc.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        double input = 64;
        Calc instance = new Calc();
        double expResult = 8;
        double result = instance.sqrt(input);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of pwr method, of class Calc.
     */
    @Test
    public void testPwr() {
        System.out.println("pwr");
        double inputA = 2;
        double inputB = 8;
        Calc instance = new Calc();
        double expResult = 256;
        double result = instance.pwr(inputA, inputB);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of circumference method, of class Calc.
     */
    @Test
    public void testCircumference() {
        System.out.println("assertTrue        - circumference");
        double radius = 8;
        Calc instance = new Calc();
        double expResult = 50.27;
        double result = instance.circumference(radius);
        assertTrue(expResult == result);
    }

    /**
     * Test of areaOfCircle method, of class Calc.
     */
    @Test
    public void testAreaOfCircle() {
        System.out.println("areaOfCircle");
        double radius = 5;
        Calc instance = new Calc();
        double expResult = 78.54;
        double result = instance.areaOfCircle(radius);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of isPrime method, of class Calc.
     */
    @Test
    public void testIsPrime() {
        System.out.println("assertFalse       - isPrime");
        int input = 6;
        Calc instance = new Calc();
        boolean result = instance.isPrime(input);
        assertFalse(result);
    }
    
    /**
     * Test of isMathHard method, of class Calc.
     */
    @Test
    public void testIsMathHard() {
        System.out.println("assertNull        - isMathHard");
        int input = 0;
        Calc instance = new Calc();
        String result = instance.isMathHard(input);
        assertNull(result);
    }
    
    @Test
    public void testIsMathHard2() {
        System.out.println("assertNotNull     - isMathHard");
        int input = 1;
        Calc instance = new Calc();
        String result = instance.isMathHard(input);
        assertNotNull(result);
    }
    
    @Test
    public void testArrayBuilder() {
        System.out.println("assertArrayEquals - arrayBuilder");
        int inputA = 1;
        int inputB = 2;
        int inputC = 3;
        int inputD = 4;
        int[] expResult = new int[]{inputA,inputB,inputC,inputD};
        Calc instance = new Calc();
        int[] result = instance.arrayBuilder(inputA,inputB,inputC,inputD);
        assertArrayEquals(expResult,result);
    }
    
}
