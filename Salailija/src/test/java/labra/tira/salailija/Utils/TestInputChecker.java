package labra.tira.salailija.Utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestInputChecker {
    
    @Test
    public void testNumerical(){
        InputChecker ic = new InputChecker();
        String test = "1234567890";
        assertTrue("Got false for string containing only numbers", ic.isNumeric(test));
    }
    
    @Test
    public void testNonNumerical(){
        InputChecker ic = new InputChecker();
        String test = "test123";
        assertFalse("Got true for string containing non-numerical characters", ic.isNumeric(test));
    }
    
}
