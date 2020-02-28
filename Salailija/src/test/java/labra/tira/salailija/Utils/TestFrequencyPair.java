package labra.tira.salailija.Utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestFrequencyPair {
    
    @Test
    public void manuallyChangingCountWorks(){
        FrequencyPair fp = new FrequencyPair('a');
        fp.setCount(10);
        assertEquals("Manually changing the count of a FrequencyPair doesn't work", 10, fp.getCount());
    }
    
}
