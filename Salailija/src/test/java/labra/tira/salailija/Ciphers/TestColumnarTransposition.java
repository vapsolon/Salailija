package labra.tira.salailija.Ciphers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestColumnarTransposition {
    
    @Test
    public void testShortMessage(){
        ColumnarTransposition ct = new ColumnarTransposition();
        String test = "Test";
        String key = "ba";
        assertEquals("Wrong translation for string " + test + " with key " + key, "eTts", ct.translate(test, key));
    }
    
    @Test
    public void testLongerMessage(){
        ColumnarTransposition ct = new ColumnarTransposition();
        String test = "Test Message Longer Version";
        String key = "ba";
        assertEquals("Wrong translation for string " + test + " with key " + key, "eTtsM seasegL noeg reVsroi n", ct.translate(test, key));
    }
    
    @Test
    public void testLongerKey(){
        ColumnarTransposition ct = new ColumnarTransposition();
        String test = "Test Message";
        String key = "longkey";
        assertEquals("Wrong translation for string " + test + " with key " + key, "tM esTeg esas ", ct.translate(test, key));
    }
    
}
