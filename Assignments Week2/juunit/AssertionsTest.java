package assignments_week2.juunit;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals("2 + 3 should equal 5", 5, 2 + 3);

        // Assert true / false
        assertTrue("5 is greater than 3", 5 > 3);
        assertFalse("5 is not less than 3", 5 < 3);

        // Assert null / not null
        Object obj = null;
        assertNull("Object should be null", obj);

        obj = new Object();
        assertNotNull("Object should not be null", obj);
    }
}
