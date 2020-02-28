package labra.tira.salailija.Utils;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestQuicksort {
    
    @Test
    public void getEmpty(){
        Quicksort q = new Quicksort();
        FrequencyPair[] fp = new FrequencyPair[5];
        fp[0] = new FrequencyPair('a');
        fp[1] = new FrequencyPair('b');
        fp[2] = new FrequencyPair('c');
        fp[3] = new FrequencyPair('d');
        fp[4] = new FrequencyPair('e');
        fp[0].setCount(10);
        fp[1].setCount(5);
        fp[2].setCount(18);
        fp[3].setCount(7);
        fp[4].setCount(19);
        FrequencyPair[] result = q.start(fp, fp.length);
        assertEquals("Returned an incorrect order when sorting frequencies", 19, result[0].getCount());
        assertEquals("Returned an incorrect order when sorting frequencies", 'e', result[0].getCharacter());
    }
    
}
