package labra.tira.salailija.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestTextInterface {
    
    private final ByteArrayOutputStream outs = new ByteArrayOutputStream();
    private final PrintStream outo = System.out;
    //String[] outContents;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outs));
    }

    @After
    public void restoreStreams() {
        System.setOut(outo);
        /*int i = 0;
        for(String s: outContents){
            System.out.println("=== " + i + ": " + s);
            i++;
        }*/
    }
    
    @Test
    public void testInputOutOfRange(){
        Scanner s = new Scanner("0\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[11].startsWith("Epäkelpo syöte"));
    }
    
    @Test
    public void testCaesar(){
        Scanner s = new Scanner("1\nTesti\n1\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContents = outs.toString().split("\n");
        assertTrue(outContents[11].startsWith("Ceaserian Shift"));
        assertTrue(outContents[14].contains("Uftuj"));
    }
    
    @Test
    public void testROT13(){
        Scanner s = new Scanner("2\nTesti\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContents = outs.toString().split("\n");
        assertTrue(outContents[11].startsWith("ROT13"));
        assertTrue(outContents[13].contains("Grfgv"));
    }
    
    @Test
    public void testMorse(){
        Scanner s = new Scanner("3\nTesti\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContents = outs.toString().split("\n");
        assertTrue(outContents[11].startsWith("Morse"));
        assertTrue(outContents[13].contains("-....-.."));
    }
    
    @Test
    public void testLeet(){
        Scanner s = new Scanner("4\nTesti\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContents = outs.toString().split("\n");
        assertTrue(outContents[11].startsWith("1337"));
        assertTrue(outContents[13].contains("73571"));
    }
    
}
