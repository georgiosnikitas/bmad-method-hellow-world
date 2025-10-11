
package school.madcalc;

import org.junit.jupiter.api.Test;

import school.madcalc.MadCalc;

import static org.junit.jupiter.api.Assertions.*;

class MadCalcTest {

    @Test
    void testSimpleAddition() {
        assertEquals(5.0, MadCalcTestHelper.evaluate("2+3"), 0.0001);
    }

    @Test
    void testParentheses() {
        assertEquals(14.0, MadCalcTestHelper.evaluate("2*(3+4)"), 0.0001);
        assertEquals(20.0, MadCalcTestHelper.evaluate("(2+3)*4"), 0.0001);
        assertEquals(2.0, MadCalcTestHelper.evaluate("10/(2+3)"), 0.0001);
        assertEquals(9.0, MadCalcTestHelper.evaluate("(2+(3*4))-5"), 0.0001);
    }


    @Test
    void testMismatchedParentheses() {
        Exception ex1 = assertThrows(RuntimeException.class, () -> MadCalcTestHelper.evaluate("(2+3"));
        assertTrue(ex1.getMessage().contains("Mismatched parentheses"));
        Exception ex2 = assertThrows(RuntimeException.class, () -> MadCalcTestHelper.evaluate("2+)"));
        assertTrue(ex2.getMessage().contains("Unexpected"));
    }

    @Test
    void testSquareRootPositiveInteger() throws Exception {
        assertEquals(4.0, MadCalcTestHelper.calculateSquareRoot("16"), 0.0001);
        assertEquals(5.0, MadCalcTestHelper.calculateSquareRoot("25"), 0.0001);
    }

    @Test
    void testSquareRootPositiveDecimal() throws Exception {
        assertEquals(1.41421356, MadCalcTestHelper.calculateSquareRoot("2.0"), 0.0001);
        assertEquals(2.23606798, MadCalcTestHelper.calculateSquareRoot("5.0"), 0.0001);
    }

    @Test
    void testSquareRootZero() throws Exception {
        assertEquals(0.0, MadCalcTestHelper.calculateSquareRoot("0"), 0.0001);
    }



    // Helper to access the private evaluate method
    static class MadCalcTestHelper {
        static double evaluate(String expr) {
            // Use reflection to call private static method
            try {
                java.lang.reflect.Method m = MadCalc.class.getDeclaredMethod("evaluate", String.class);
                m.setAccessible(true);
                return (double) m.invoke(null, expr);
            } catch (Exception e) {
                throw new RuntimeException(e.getCause() != null ? e.getCause().getMessage() : e.getMessage());
            }
        }

        static double calculateSquareRoot(String numberStr) throws Exception {
            try {
                java.lang.reflect.Method m = MadCalc.class.getDeclaredMethod("calculateSquareRoot", String.class);
                m.setAccessible(true);
                return (double) m.invoke(null, numberStr);
            } catch (java.lang.reflect.InvocationTargetException e) {
                if (e.getCause() instanceof RuntimeException) {
                    throw (RuntimeException) e.getCause();
                }
                throw e;
            }
        }

        static double calculatePowerOfTwo(String numberStr) throws Exception {
            try {
                java.lang.reflect.Method m = MadCalc.class.getDeclaredMethod("calculatePowerOfTwo", String.class);
                m.setAccessible(true);
                return (double) m.invoke(null, numberStr);
            } catch (java.lang.reflect.InvocationTargetException e) {
                if (e.getCause() instanceof RuntimeException) {
                    throw (RuntimeException) e.getCause();
                }
                throw e;
            }
        }

        static double calculateCube(String numberStr) throws Exception {
            try {
                java.lang.reflect.Method m = MadCalc.class.getDeclaredMethod("calculateCube", String.class);
                m.setAccessible(true);
                return (double) m.invoke(null, numberStr);
            } catch (java.lang.reflect.InvocationTargetException e) {
                if (e.getCause() instanceof RuntimeException) {
                    throw (RuntimeException) e.getCause();
                }
                throw e;
            }
        }
    }

    @Test
    void testSquareRootNegative() throws Exception {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MadCalcTestHelper.calculateSquareRoot("-4"));
        assertTrue(ex.getMessage().contains("Cannot calculate square root of a negative number"));
    }

    @Test
    void testSquareRootNonNumeric() throws Exception {
        assertThrows(NumberFormatException.class, () -> MadCalcTestHelper.calculateSquareRoot("abc"));
        assertThrows(NumberFormatException.class, () -> MadCalcTestHelper.calculateSquareRoot(""));
    }

    @Test
    void testPowerOfTwoPositiveInteger() throws Exception {
        assertEquals(9.0, MadCalcTestHelper.calculatePowerOfTwo("3"), 0.0001);
        assertEquals(16.0, MadCalcTestHelper.calculatePowerOfTwo("4"), 0.0001);
    }

    @Test
    void testPowerOfTwoPositiveDecimal() throws Exception {
        assertEquals(2.25, MadCalcTestHelper.calculatePowerOfTwo("1.5"), 0.0001);
        assertEquals(6.25, MadCalcTestHelper.calculatePowerOfTwo("2.5"), 0.0001);
    }

    @Test
    void testPowerOfTwoZero() throws Exception {
        assertEquals(0.0, MadCalcTestHelper.calculatePowerOfTwo("0"), 0.0001);
    }

    @Test
    void testPowerOfTwoOne() throws Exception {
        assertEquals(1.0, MadCalcTestHelper.calculatePowerOfTwo("1"), 0.0001);
    }

    @Test
    void testPowerOfTwoNegative() throws Exception {
        assertEquals(9.0, MadCalcTestHelper.calculatePowerOfTwo("-3"), 0.0001);
        assertEquals(16.0, MadCalcTestHelper.calculatePowerOfTwo("-4"), 0.0001);
    }

    @Test
    void testPowerOfTwoNonNumeric() throws Exception {
        assertThrows(NumberFormatException.class, () -> MadCalcTestHelper.calculatePowerOfTwo("xyz"));
        assertThrows(NumberFormatException.class, () -> MadCalcTestHelper.calculatePowerOfTwo(""));
    }

    @Test
    void testCubePositiveInteger() throws Exception {
        assertEquals(27.0, MadCalcTestHelper.calculateCube("3"), 0.0001);
        assertEquals(64.0, MadCalcTestHelper.calculateCube("4"), 0.0001);
    }

    @Test
    void testCubePositiveDecimal() throws Exception {
        assertEquals(3.375, MadCalcTestHelper.calculateCube("1.5"), 0.0001);
        assertEquals(15.625, MadCalcTestHelper.calculateCube("2.5"), 0.0001);
    }

    @Test
    void testCubeZero() throws Exception {
        assertEquals(0.0, MadCalcTestHelper.calculateCube("0"), 0.0001);
    }

    @Test
    void testCubeOne() throws Exception {
        assertEquals(1.0, MadCalcTestHelper.calculateCube("1"), 0.0001);
    }

    @Test
    void testCubeNegative() throws Exception {
        assertEquals(-27.0, MadCalcTestHelper.calculateCube("-3"), 0.0001);
        assertEquals(-64.0, MadCalcTestHelper.calculateCube("-4"), 0.0001);
    }

    @Test
    void testCubeNonNumeric() throws Exception {
        assertThrows(NumberFormatException.class, () -> MadCalcTestHelper.calculateCube("abc"));
        assertThrows(NumberFormatException.class, () -> MadCalcTestHelper.calculateCube(""));
    }
}