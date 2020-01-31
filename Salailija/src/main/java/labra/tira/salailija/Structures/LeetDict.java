package labra.tira.salailija.Structures;

import labra.tira.salailija.Utils.Dictionary;

/**
 * Sanakirja- ja käännöspalvely 13375p33k1113. <br>
 * Tässä vaiheessa ollaan saatu aikaan oma geneerinen sanakirjaluokka tarjoamaan
 * tallennustilaa käännössanakirjoille ja HashMap on kokonaan eliminoitu.<br>
 * Toiminnallisuus vaikuttaisi olevan täysin vastaava, tosin tehokkuudesta ei
 * anneta takuita.
 * @author vapsolon
 */

public class LeetDict {
    
    //Nyt täysin omintakeisella sanakirjalla
    private Dictionary leet;
    
    /**
     * Konstruktori alustaa ensin sanakirjan ja täyttää sen sitten kaikilla
     * tuetuilla käännöksillä.
     */
    public LeetDict(){
        this.leet = new Dictionary();
        this.leet.add('a', "4");
        this.leet.add('b', "8");
        this.leet.add('e', "3");
        this.leet.add('i', "1");
        this.leet.add('l', "1");
        this.leet.add('o', "0");
        this.leet.add('s', "5");
        this.leet.add('t', "7");
    }
    
    /**
     * Varsinainen käännöstoiminnallisuus. <br>
     * Ottaa vastaan merkin ja hakee sanakirjasta vastaavan käännöksen.
     * Sana- ja lauselogiikka on toteutettu itse Cipher-luokassa.
     * @param c Käännettävä merkki
     * @return Käännetty merkki, tai alkuperäinen merkki jos
     * käännöstä ei löytynyt
     */
    public char translate(char c){
        //Sanakirjassa on helppouden vuoksi vain pieniä kirjaimia, muunnetaan
        //siis syötekin pieneksi
        char lower = Character.toLowerCase(c);
        //Jos merkille löytyy käännös palautetaan se
        if(this.leet.contains(lower)){
            //Oman sanakirjaluokan toteutus vaatii Morsen takia käännösten
            //olevan merkkijonoja joten tänne tarvitaan ylimääräinen muunnos
            //takaisin merkiksi
            return this.leet.get(lower).charAt(0);
        }
        //Muutoin palautetaan alkuperäinen merkki
        return c;
    }
    
}
