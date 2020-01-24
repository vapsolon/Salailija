package labra.tira.salailija.Ciphers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaesar {
    
    @Test
    public void testShortShift(){
        Caesar c = new Caesar();
        String test = "Test";
        assertEquals("Wrong translation for string " + test + " with rotation 1", "Uftu", c.cipher(test, 1));
    }
    
    @Test
    public void testLongShift(){
        Caesar c = new Caesar();
        String test = "Test";
        assertEquals("Wrong translation for string " + test + " with rotation 20", "Nymn", c.cipher(test, 20));
    }
    
    @Test
    public void testNoShift(){
        Caesar c = new Caesar();
        String test = "Test";
        assertEquals("Wrong translation for string " + test + " with rotation 26", "Test", c.cipher(test, 26));
        assertEquals("Wrong translation for string " + test + " with rotation 0", "Test", c.cipher(test, 0));
    }
    
    @Test
    public void testRot13(){
        Caesar c = new Caesar();
        String test = "Test";
        String rotated = c.cipher(test, 13);
        assertEquals("Wrong translation for string " + test + " with double-ROT13", "Test", c.cipher(rotated, 13));
    }
    
    @Test
    public void testIncorrectShift(){
        Caesar c = new Caesar();
        String test = "Test";
        assertEquals("String " + test + " was translated even though an incorrect rotation was provided", null, c.cipher(test, -1));
        assertEquals("String " + test + " was translated even though an incorrect rotation was provided", null, c.cipher(test, 27));
    }
    
}
