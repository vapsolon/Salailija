package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Utils.CharArray;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestPrivateKey {

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
