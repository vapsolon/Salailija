package labra.tira.salailija.Ciphers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
Testit Morse-kääntäjälle. Toimii samalla myös Morse-sanakirjan testaajana, jolloin
erilliselle sanakirjatestaajalle ei ole tarvetta.
*/

public class TestMorse {
    
    @Test
    public void testSimple(){
        Morse m = new Morse();
        String test = "Morse";
        assertEquals("Wrong translation for string " + test, "-----.-.....", m.translate(test));
    }
    
    @Test
    public void testComplex(){
        Morse m = new Morse();
        String test = "This is an example string to be turned into Morse";
        assertEquals("Wrong translation for string " + test, "-......... ..... .--. .-..-.---.--..-... ...-.-...-.--. ---- -.... -..-.-.-..-.. ..-.---- -----.-.....", m.translate(test));
    }
    
    @Test
    public void testNumbers(){
        Morse m = new Morse();
        String test = "1231337";
        assertEquals("Wrong translation for string " + test, ".----..---...--.----...--...----...", m.translate(test));
    }
    
    @Test
    public void testNoChange(){
        Morse m = new Morse();
        String test = "!?äö...---...+=";
        assertEquals("Wrong translation for string " + test, "!?äö...---...+=", m.translate(test));
    }
    
}
