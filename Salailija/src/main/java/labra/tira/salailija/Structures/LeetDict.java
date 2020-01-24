package labra.tira.salailija.Structures;

import java.util.HashMap;

/**
 * Sanakirja- ja käännöspalvely 13375p33k1113 <br>
 * Tällä hetkellä käytössä on Javan HashMap jotta toiminnallisuus saadaan alkuun,
 * myöhemmässä vaiheessa tähän tehdään täysin oma toteutus.
 * @author vapsolon
 */

//TODO: Replace HashMap with a custom implementation


public class LeetDict {
    
    //HashMap toimii toistaiseksi sanakirjana
    private HashMap<Character, Character> leet;
    
    /**
     * Konstruktori alustaa ensin sanakirjan ja täyttää sen sitten kaikilla
     * tuetuilla käännöksillä
     */
    public LeetDict(){
        this.leet = new HashMap<>();
        this.leet.put('a', '4');
        this.leet.put('b', '8');
        this.leet.put('e', '3');
        this.leet.put('i', '1');
        this.leet.put('l', '1');
        this.leet.put('o', '0');
        this.leet.put('s', '5');
        this.leet.put('t', '7');
    }
    
    /**
     * Varsinainen käännöstoiminnallisuus. <br>
     * Ottaa vastaan merkin ja hakee sanakirjasta vastaavan käännöksen.
     * Sana- ja lauselogiikka on toteutettu itse Cipher-luokassa.
     * @param c Käännettävä merkki
     * @return Käännetty merkki, tai alkuperäinen merkki jos käännöstä ei löytynyt
     */
    public char translate(char c){
        //Sanakirjassa on helppouden vuoksi vain pieniä kirjaimia, muunnetaan
        //siis syötekin pieneksi
        char lower = Character.toLowerCase(c);
        //Jos merkille löytyy käännös palautetaan se
        if(this.leet.containsKey(lower)){
            return this.leet.get(lower);
        }
        //Muutoin palautetaan alkuperäinen merkki
        return c;
    }
    
}
