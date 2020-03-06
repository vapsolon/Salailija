package labra.tira.salailija.Utils;

import java.util.Random;
import labra.tira.salailija.Ciphers.Caesar;
import labra.tira.salailija.Ciphers.ColumnarTransposition;
import labra.tira.salailija.Ciphers.Leet;
import labra.tira.salailija.Ciphers.Morse;
import labra.tira.salailija.Ciphers.PrivateKey;

/**
 * Suorituskykytestaamisluokka. <br>
 * Testaa tällä hetkellä kaikkien tuettujen salausmenetelmien tehoa
 * erimittaisilla syötteillä ja tulostaa salaamiseen kuluneet ajat konsoliin.
 * Jokainen yksittäinen testi suoritetaan kahdesti testaamisohjeen kehotuksen
 * mukaisesti, mutta muodon vuoksi ensimmäisten testien tuloksia ei heitetä
 * heti pois, vaan ne tulostetaan viralliseksi jäävän toisen testin rinnalla
 * vertailun vuoksi.
 * @author vapsolon
 */
public class TestPerformance {
    Caesar c = new Caesar();
    ColumnarTransposition ct = new ColumnarTransposition();
    Leet l = new Leet();
    Morse m = new Morse();
    PrivateKey pk = new PrivateKey();
    Random r = new Random(1337);
    
    String testString10;
    String testString100;
    String testString1000;
    String testString10000;
    String testString100000;;
    String testString1000000;
    
    /**
     * Ulkomaailmalle näkyvä päämetodi, aloittaa testaamisen. <br>
     * Alustetaan ensin testisyötteet setup()-metodilla ja ajetaan sitten
     * yksittäisten salausmenetelmien testit.
     */
    public void test(){
        setup();
        testCaesar();
        System.out.println("");
        testLeet();
        System.out.println("");
        testMorse();
        System.out.println("");
        testCt();
        System.out.println("");
        testPrivateKey();
        System.out.println("");
    }
    
    /**
     * Testaa Caesar-luokan.
     */
    private void testCaesar(){
        System.out.print("Testing Caesar with length 10: ");
        long start = System.nanoTime();
        c.cipher(this.testString10, 13);
        long end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Caesar with length 10: ");
        start = System.nanoTime();
        c.cipher(this.testString10, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Caesar with length 100: ");
        start = System.nanoTime();
        c.cipher(this.testString100, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Caesar with length 100: ");
        start = System.nanoTime();
        c.cipher(this.testString100, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Caesar with length 1000: ");
        start = System.nanoTime();
        c.cipher(this.testString1000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Caesar with length 1000: ");
        start = System.nanoTime();
        c.cipher(this.testString1000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Caesar with length 10000: ");
        start = System.nanoTime();
        c.cipher(this.testString10000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Caesar with length 10000: ");
        start = System.nanoTime();
        c.cipher(this.testString10000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Caesar with length 100000: ");
        start = System.nanoTime();
        c.cipher(this.testString100000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Caesar with length 100000: ");
        start = System.nanoTime();
        c.cipher(this.testString100000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Caesar with length 1000000: ");
        start = System.nanoTime();
        c.cipher(this.testString1000000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Caesar with length 1000000: ");
        start = System.nanoTime();
        c.cipher(this.testString1000000, 13);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
    }
    
    /**
     * Testaa Leet-luokan
     */
    private void testLeet(){
        
        System.out.print("Testing Leet with length 10: ");
        long start = System.nanoTime();
        l.translate(this.testString10);
        long end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Leet with length 10: ");
        start = System.nanoTime();
        l.translate(this.testString10);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Leet with length 100: ");
        start = System.nanoTime();
        l.translate(this.testString100);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Leet with length 100: ");
        start = System.nanoTime();
        l.translate(this.testString100);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Leet with length 1000: ");
        start = System.nanoTime();
        l.translate(this.testString1000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Leet with length 1000: ");
        start = System.nanoTime();
        l.translate(this.testString1000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Leet with length 10000: ");
        start = System.nanoTime();
        l.translate(this.testString10000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Leet with length 10000: ");
        start = System.nanoTime();
        l.translate(this.testString10000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Leet with length 100000: ");
        start = System.nanoTime();
        l.translate(this.testString100000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Leet with length 100000: ");
        start = System.nanoTime();
        l.translate(this.testString100000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Leet with length 1000000: ");
        start = System.nanoTime();
        l.translate(this.testString1000000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Leet with length 1000000: ");
        start = System.nanoTime();
        l.translate(this.testString1000000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
    }
    
    /**
     * Testaa Morse-luokan
     */
    private void testMorse(){
        
        System.out.print("Testing Morse with length 10: ");
        long start = System.nanoTime();
        m.translate(this.testString10);
        long end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Morse with length 10: ");
        start = System.nanoTime();
        m.translate(this.testString10);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Morse with length 100: ");
        start = System.nanoTime();
        m.translate(this.testString100);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Morse with length 100: ");
        start = System.nanoTime();
        m.translate(this.testString100);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Morse with length 1000: ");
        start = System.nanoTime();
        m.translate(this.testString1000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Morse with length 1000: ");
        start = System.nanoTime();
        m.translate(this.testString1000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Morse with length 10000: ");
        start = System.nanoTime();
        m.translate(this.testString10000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Morse with length 10000: ");
        start = System.nanoTime();
        m.translate(this.testString10000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Morse with length 100000: ");
        start = System.nanoTime();
        m.translate(this.testString100000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Morse with length 100000: ");
        start = System.nanoTime();
        m.translate(this.testString100000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Morse with length 1000000: ");
        start = System.nanoTime();
        m.translate(this.testString1000000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Morse with length 1000000: ");
        start = System.nanoTime();
        m.translate(this.testString1000000);
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
    }
    
    /**
     * Testaa ColumnarTransposition-luokan
     */
    private void testCt(){
        
        System.out.print("Testing Columnar Transposition with length 10: ");
        long start = System.nanoTime();
        ct.translate(this.testString10, "Rotation");
        long end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Columnar Transposition with length 10: ");
        start = System.nanoTime();
        ct.translate(this.testString10, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Columnar Transposition with length 100: ");
        start = System.nanoTime();
        ct.translate(this.testString100, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Columnar Transposition with length 100: ");
        start = System.nanoTime();
        ct.translate(this.testString100, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Columnar Transposition with length 1000: ");
        start = System.nanoTime();
        ct.translate(this.testString1000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Columnar Transposition with length 1000: ");
        start = System.nanoTime();
        ct.translate(this.testString1000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Columnar Transposition with length 10000: ");
        start = System.nanoTime();
        ct.translate(this.testString10000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Columnar Transposition with length 10000: ");
        start = System.nanoTime();
        ct.translate(this.testString10000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Columnar Transposition with length 100000: ");
        start = System.nanoTime();
        ct.translate(this.testString100000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Columnar Transposition with length 100000: ");
        start = System.nanoTime();
        ct.translate(this.testString100000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Columnar Transposition with length 1000000: ");
        start = System.nanoTime();
        ct.translate(this.testString1000000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Columnar Transposition with length 1000000: ");
        start = System.nanoTime();
        ct.translate(this.testString1000000, "Rotation");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
    }
    
    /**
     * Testaa PrivateKey-luokan
     */
    private void testPrivateKey(){
        CharArray ca = new CharArray();
        
        System.out.print("Testing Private Key with length 10: ");
        byte[] testBytes = ca.byteArray(testString10);
        long start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        long end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Private Key with length 10: ");
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Private Key with length 100: ");
        testBytes = ca.byteArray(testString100);
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Private Key with length 100: ");
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Private Key with length 1000: ");
        testBytes = ca.byteArray(testString1000);
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Private Key with length 1000: ");
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Private Key with length 10000: ");
        testBytes = ca.byteArray(testString10000);
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Private Key with length 10000: ");
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Private Key with length 100000: ");
        testBytes = ca.byteArray(testString100000);
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Private Key with length 100000: ");
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        
        System.out.print("Testing Private Key with length 1000000: ");
        testBytes = ca.byteArray(testString1000000);
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
        System.out.print("Testing Private Key with length 1000000: ");
        start = System.nanoTime();
        pk.encrypt(testBytes, "Testkey");
        end = System.nanoTime();
        System.out.print("Execution time "+((end-start)/1e9)+" s");
        System.out.println("");
    }
    
    /**
     * Alustaa testisyötteet syötteenrakennusmetodin avulla.
     */
    private void setup(){
        this.testString10 = build(10);
        this.testString100 = build(100);
        this.testString1000 = build(1000);
        this.testString10000 = build(10000);
        this.testString100000 = build(100000);
        this.testString1000000 = build(1000000);
    }
    
    /**
     * Rakentaa satunnaisen merkkijonon käytettäväksi testaamisessa. <br>
     * Käyttää globaalia alustettua satunnaisgeneraattoria, joten tuotetut
     * merkkijonot ovat aina samat jokaisella testikerralla.
     * @param length Tuotettavan merkkijonon pituus
     * @return Tuotettu satunnaismerkkijono
     */
    private String build(int length){
        ResultBuilder rb = new ResultBuilder();
        for(int i=0;i<length;i++){
            rb.append((char)(r.nextInt(26) + 'a'));
        }
        return rb.toString();
    }
    
}
