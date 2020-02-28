package labra.tira.salailija.Utils;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestFrequencyAnalysis {
 
    @Test
    public void basicAnalysisWorks(){
        FrequencyAnalysis fa = new FrequencyAnalysis();
        String result = fa.analyze("test");
        assertTrue("Basic FrequencyAnalysis doesn't work", result.contains("Merkki: 't', määrä: 2"));
    }
    
}
