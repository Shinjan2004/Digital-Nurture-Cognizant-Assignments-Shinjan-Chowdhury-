package assignments_week2.juunit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorFixtureTest {
    private Calculator calc;

    @Before
    public void setUp() {
        // ARRANGE: initialize shared calculator instance
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        // TEARDOWN: null out to help detect unintended reuse
        calc = null;
    }

    @Test
    public void testAdd_ArrangeActAssert() {
        // ACT
        int result = calc.add(10, 20);
        // ASSERT
        assertEquals("10 + 20 should be 30", 30, result);
    }

    @Test
    public void testSubtract_AAA() {
        // ACT
        int result = calc.subtract(10, 5);
        // ASSERT
        assertEquals("10 - 5 should be 5", 5, result);
    }
}
