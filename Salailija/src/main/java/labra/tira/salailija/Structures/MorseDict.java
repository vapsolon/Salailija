package labra.tira.salailija.Structures;

import labra.tira.salailija.Utils.Dictionary;

/**
 * Sanakirja- ja käännöspalvely Morselle. <br>
 * Tässä vaiheessa ollaan saatu aikaan oma geneerinen sanakirjaluokka tarjoamaan
 * tallennustilaa käännössanakirjoille ja HashMap on kokonaan eliminoitu.<br>
 * Toiminnallisuus vaikuttaisi olevan täysin vastaava, tosin tehokkuudesta ei
 * anneta takuita.
 * @author vapsolon
 */

public class MorseDict {
    
    
    //Nyt täysin omintakeisella sanakirjalla
    private Dictionary morse;
    
    /**
     * Konstruktori alustaa ansin sanakirjan ja lisää sinne sitten kaikki
     * tuetut käännökset helpottamaan kääntämistä.
     */
    public MorseDict(){
        //Alustetaan sanakirja
        this.morse = new Dictionary();
        this.morse.add('a', ".-");
        this.morse.add('b', "-...");
        this.morse.add('c', "-.-.");
        this.morse.add('d', "-..");
        this.morse.add('e', ".");
        this.morse.add('f', "..-.");
        this.morse.add('g', "--.");
        this.morse.add('h', "....");
        this.morse.add('i', "..");
        this.morse.add('j', ".---");
        this.morse.add('k', "-.-");
        this.morse.add('l', ".-..");
        this.morse.add('m', "--");
        this.morse.add('n', "-.");
        this.morse.add('o', "---");
        this.morse.add('p', ".--.");
        this.morse.add('q', "--.-");
        this.morse.add('r', ".-.");
        this.morse.add('s', "...");
        this.morse.add('t', "-");
        this.morse.add('u', "..-");
        this.morse.add('v', "...-");
        this.morse.add('w', ".--");
        this.morse.add('x', "-..-");
        this.morse.add('y', "-.--");
        this.morse.add('z', "--..");
        this.morse.add('1', ".----");
        this.morse.add('2', "..---");
        this.morse.add('3', "...--");
        this.morse.add('4', "....-");
        this.morse.add('5', ".....");
        this.morse.add('6', "-....");
        this.morse.add('7', "--...");
        this.morse.add('8', "---..");
        this.morse.add('9', "----.");
        this.morse.add('0', "-----");
    }

    /**
     * Varsinainen käännöstoiminnallisuus. <br>
     * Ottaa vastaan merkin ja hakee sanakirjasta vastaavan käännöksen.
     * Sana- ja lauselogiikka on toteutettu itse Cipher-luokassa.
     * @param c Käännettävä merkki
     * @return Käännetty merkki, tai alkuperäinen merkki jos käännöstä ei
     * löytynyt
     */
    public String translate(char c){
        //Sanakirjassa on vain pieniä kirjaimia tilan säästämiseksi, muunnetaan
        //siis käännettäväkin kirjain pieneksi
        char lower = Character.toLowerCase(c);
        String translation = this.morse.get(lower);
        //Jos käännöstä ei ole, palautetaan alkuperäinen merkki
        if(translation == null){
            return Character.toString(c);
        }
        else{
            return translation;
        }
    }
    
}
