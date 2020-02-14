package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Utils.CharArray;
import static org.junit.Assert.assertArrayEquals;
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
    
    @Test
    public void testNoCycle(){
        PrivateKey pk = new PrivateKey();
        String test = "test";
        String key = "123";
        assertEquals("Wrong translation for string " + test + " with key " + key, "EW@E", pk.translate(test, key));
    }
    
    @Test
    public void testEncryption(){
        PrivateKey pk = new PrivateKey();
        CharArray ca = new CharArray();
        byte[] test = ca.byteArray("test");
        byte[] expected = {53, 19, 18, 29};
        assertArrayEquals("Incorrect result for encrypting content 'test' with key 'Avain'", expected, pk.encrypt(test, "Avain"));
    }
    
    @Test
    public void testLongerEncryption(){
        PrivateKey pk = new PrivateKey();
        CharArray ca = new CharArray();
        byte[] test = ca.byteArray("This is a test phrase");
        byte[] expected = {21, 30, 8, 26, 78, 40, 5, 65, 8, 78, 53, 19, 18, 29, 78, 49, 30, 19, 8, 29, 36};
        assertArrayEquals("Incorrect result for encrypting content 'test' with key 'Avain'", expected, pk.encrypt(test, "Avain"));
    }
    
}
