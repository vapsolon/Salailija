package labra.tira.salailija.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestFrequencyMap {
    
    @Test
    public void testAddSameChar(){
        FrequencyMap fm = new FrequencyMap(10);
        fm.add('a');
        fm.add('a');
        FrequencyPair fp = fm.get(fm.contains('a'));
        assertEquals("The count of a character doesn't increase when it's added twice", 2, fp.getCount());
    }
    
    @Test
    public void getInvalidReturnsNull(){
        FrequencyMap fm = new FrequencyMap(10);
        fm.add('a');
        fm.add('a');
        assertEquals("Getting an invalid index doesn't return null", null, fm.get(-1));
    }
    
    @Test
    public void containsReturnsCorrectIndex(){
        FrequencyMap fm = new FrequencyMap(10);
        fm.add('a');
        fm.add('b');
        fm.add('c');
        assertEquals("Checking if map contains a char returns the wrong index", 2, fm.contains('c'));
    }
    
    @Test
    public void toStringContainsCorrectData(){
        FrequencyMap fm = new FrequencyMap(10);
        fm.add('a');
        fm.add('b');
        fm.add('c');
        fm.add('c');
        fm.add('c');
        assertTrue("toString returns incorrect data", fm.toString().contains("Merkki: 'c', määrä: 3"));
    }
    
    @Test
    public void longerInputGrowsMap(){
        FrequencyMap fm = new FrequencyMap(2);
        fm.add('a');
        fm.add('b');
        fm.add('c');
        fm.add('d');
        fm.add('e');
        fm.add('f');
        fm.add('g');
        assertEquals("Checking if map contains a char returns the wrong index", 2, fm.contains('c'));
    }
}
