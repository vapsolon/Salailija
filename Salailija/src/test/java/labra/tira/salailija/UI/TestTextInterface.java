package labra.tira.salailija.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestTextInterface {
    
    /*Kuten varsinainen TextInterface, myös testiluokka on nyt virallisesti
    * vanhentunut. Pidetään kylmäsäilössä pahan päivän varalle ainakin hetken
    * aikaa, poistetaan jossain vaiheessa, ainakin ennen viimeistä palautusta
    * ja demoa
    */
    
    /*
    private final ByteArrayOutputStream outs = new ByteArrayOutputStream();
    private final PrintStream outo = System.out;
    //Lisää debugaamistavaraa, katso alle
    //String[] outContents;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outs));
    }

    @After
    public void restoreStreams() {
        System.setOut(outo);
        //Nämä täällä debugaamista varten kun testejä lisätään tai uusi koodi
        //käyttöliittymään rikkoo kaiken
        /*int i = 0;
        for(String s: outContents){
            System.out.println("=== " + i + ": " + s);
            i++;
        }
    }
    
    @Test
    public void testInputOutOfRange(){
        Scanner s = new Scanner("0\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[13].startsWith("Epäkelpo syöte"));
    }
    
    @Test
    public void testCaesar(){
        Scanner s = new Scanner("1\nTesti\n1\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[13].startsWith("Ceaserian Shift"));
        assertTrue(outContent[16].contains("Uftuj"));
    }
    
    @Test
    public void testROT13(){
        Scanner s = new Scanner("2\nTesti\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[13].startsWith("ROT13"));
        assertTrue(outContent[15].contains("Grfgv"));
    }
    
    @Test
    public void testMorse(){
        Scanner s = new Scanner("3\nTesti\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[13].startsWith("Morse"));
        assertTrue(outContent[15].contains("-....-.."));
    }
    
    @Test
    public void testLeet(){
        Scanner s = new Scanner("4\nTesti\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[13].startsWith("1337"));
        assertTrue(outContent[15].contains("73571"));
    }
    
    @Test
    public void testColumnar(){
        Scanner s = new Scanner("5\nTesti\nadbc\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[13].startsWith("Columnar"));
        assertTrue(outContent[16].contains("Ttesi"));
    }
    
    @Test
    public void testPrivateKey(){
        Scanner s = new Scanner("6\nTesti\n1111\nx");
        TextInterface t = new TextInterface(s);
        t.run();
        String[] outContent = outs.toString().split("\n");
        assertTrue(outContent[13].startsWith("Private"));
        assertTrue(outContent[16].contains("eTBEX"));
    }
    */
}
