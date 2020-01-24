package labra.tira.salailija.Structures;

import java.util.HashMap;

/**
 * Sanakirja- ja käännöspalvely Morselle <br>
 * Tällä hetkellä käytössä on Javan HashMap jotta toiminnallisuus saadaan alkuun,
 * myöhemmässä vaiheessa tähän tehdään täysin oma toteutus.
 * @author vapsolon
 */

//TODO: Replace HashMap with a custom implementation


public class MorseDict {
    
    //HashMap toimii sanakirjana
    private HashMap<Character, String> morse;
    
    /**
     * Konstruktori alustaa ansin sanakirjan ja lisää sinne sitten kaikki
     * tuetut käännökset helpottamaan kääntämistä
     */
    public MorseDict(){
        //Alustetaan sanakirja
        this.morse = new HashMap<>();
        this.morse.put('a', ".-");
        this.morse.put('b', "-...");
        this.morse.put('c', "-.-.");
        this.morse.put('d', "-..");
        this.morse.put('e', ".");
        this.morse.put('f', "..-.");
        this.morse.put('g', "--.");
        this.morse.put('h', "....");
        this.morse.put('i', "..");
        this.morse.put('j', ".---");
        this.morse.put('k', "-.-");
        this.morse.put('l', ".-..");
        this.morse.put('m', "--");
        this.morse.put('n', "-.");
        this.morse.put('o', "---");
        this.morse.put('p', ".--.");
        this.morse.put('q', "--.-");
        this.morse.put('r', ".-.");
        this.morse.put('s', "...");
        this.morse.put('t', "-");
        this.morse.put('u', "..-");
        this.morse.put('v', "...-");
        this.morse.put('w', ".--");
        this.morse.put('x', "-..-");
        this.morse.put('y', "-.--");
        this.morse.put('z', "--..");
        this.morse.put('1', ".----");
        this.morse.put('2', "..---");
        this.morse.put('3', "...--");
        this.morse.put('4', "....-");
        this.morse.put('5', ".....");
        this.morse.put('6', "-....");
        this.morse.put('7', "--...");
        this.morse.put('8', "---..");
        this.morse.put('9', "----.");
        this.morse.put('0', "-----");
    }

    /**
     * Varsinainen käännöstoiminnallisuus. <br>
     * Ottaa vastaan merkin ja hakee sanakirjasta vastaavan käännöksen.
     * Sana- ja lauselogiikka on toteutettu itse Cipher-luokassa.
     * @param c Käännettävä merkki
     * @return Käännetty merkki, tai alkuperäinen merkki jos käännöstä ei löytynyt
     */
    public String translate(char c){
        //Sanakirjassa on vain pieniä kirjaimia tilan säästämiseksi, muunnetaan
        //siis käännettäväkin kirjain pieneksi
        char lower = Character.toLowerCase(c);
        //Varmistetaan että kirjaimelle on käännös ja käännetään se
        if(this.morse.containsKey(lower)){
            return this.morse.get(lower);
        }
        //Jos käännöstä ei löydy, palautetaan kirjain sellaisenaan lisättäväksi
        //tulokseen
        return Character.toString(c);
    }
    
}
