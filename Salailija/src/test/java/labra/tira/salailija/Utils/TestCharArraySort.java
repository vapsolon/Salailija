package labra.tira.salailija.Utils;

import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestCharArraySort {
    
    @Test
    public void getEmpty(){
        CharArraySort q = new CharArraySort();
        String test = "aabbbccaa";
        int[] result = {0,1,7,8,2,3,4,5,6};
        assertTrue("Returned an incorrect order when sorting identical characters", Arrays.equals(q.start(test), result));
    }
    
}
