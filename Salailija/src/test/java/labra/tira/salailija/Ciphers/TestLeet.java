package labra.tira.salailija.Ciphers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLeet {
    
    @Test
    public void testSimple(){
        Leet l = new Leet();
        String test = "Leet";
        assertEquals("Wrong translation for string " + test, "1337", l.translate(test));
    }
    
    @Test
    public void testComplex(){
        Leet l = new Leet();
        String test = "This is an example string to be leetified";
        assertEquals("Wrong translation for string " + test, "7h15 15 4n 3x4mp13 57r1ng 70 83 13371f13d", l.translate(test));
    }
    
    @Test
    public void testNumbers(){
        Leet l = new Leet();
        String test = "Leet1337";
        assertEquals("Wrong translation for string " + test, "13371337", l.translate(test));
    }
    
    @Test
    public void testNoChange(){
        Leet l = new Leet();
        String test = "N Chng Hr";
        assertEquals("Wrong translation for string " + test, "N Chng Hr", l.translate(test));
    }
    
}
