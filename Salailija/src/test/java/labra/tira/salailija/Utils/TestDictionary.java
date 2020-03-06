package labra.tira.salailija.Utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestDictionary {
    
    @Test
    public void getEmpty(){
        Dictionary d = new Dictionary();
        assertEquals("Returned a result when getting a translation from an empty dictionary", null, d.get('A'));
    }
    
    @Test
    public void addAndGet(){
        Dictionary d = new Dictionary();
        char test = 'a';
        d.add(test, "b");
        String translation = d.get('a');
        assertEquals("Returned incorrect translation " + translation + " for character " + test, "b", d.get(test));
    }
    
    @Test
    public void addAndContains(){
        Dictionary d = new Dictionary();
        char test = 'a';
        d.add(test, "b");
        assertEquals("Returned false when asking if dictionary contains character " + test + " which was previously added", 0, d.contains(test));
    }
    
    @Test
    public void emptyContains(){
        Dictionary d = new Dictionary();
        char test = 'a';
        assertEquals("Returned true when asking if dictionary contains character " + test + " which was not added at all", -1, d.contains(test));
    }
    
}
