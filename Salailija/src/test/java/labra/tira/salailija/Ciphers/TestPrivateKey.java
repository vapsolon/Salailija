package labra.tira.salailija.Ciphers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPrivateKey {
    
    @Test
    public void testSimpleKey(){
        PrivateKey pk = new PrivateKey();
        String test = "Test";
        String key = "1111";
        String cycle = pk.translate(test, key);
        assertEquals("Wrong translation for string " + test + " with key " + key, test, pk.translate(cycle, key));
    }
    
    @Test
    public void testLongString(){
        PrivateKey pk = new PrivateKey();
        String test = "This is a test sentence about to be encrypted with a relatively short private key";
        String key = "1234";
        String cycle = pk.translate(test, key);
        assertEquals("Wrong translation for string " + test + " with key " + key, test, pk.translate(cycle, key));
    }
    
    @Test
    public void testLongKey(){
        PrivateKey pk = new PrivateKey();
        String test = "This is a test sentence about to be encrypted with a relatively short private key";
        String key = "1029512030919002945808902365";
        String cycle = pk.translate(test, key);
        assertEquals("Wrong translation for string " + test + " with key " + key, test, pk.translate(cycle, key));
    }
    
    @Test
    public void testNonNumericalKey(){
        PrivateKey pk = new PrivateKey();
        String test = "Test";
        String key = "Key";
        String cycle = pk.translate(test, key);
        assertEquals("Wrong translation for string " + test + " with key " + key, test, pk.translate(cycle, key));
    }
    
    @Test
    public void testLongNonNumericalKey(){
        PrivateKey pk = new PrivateKey();
        String test = "This is a test sentence about to be encrypted with a longer non-numerical key";
        String key = "Thisisanonnumericalkeywithoutspaces";
        String cycle = pk.translate(test, key);
        assertEquals("Wrong translation for string " + test + " with key " + key, test, pk.translate(cycle, key));
    }
    
}
