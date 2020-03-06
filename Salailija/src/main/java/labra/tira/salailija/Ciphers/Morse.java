package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Structures.MorseDict;
import labra.tira.salailija.Utils.CharArray;
import labra.tira.salailija.Utils.ResultBuilder;

/**
 * Morse-kääntäjä tekstille, rakennettu Morse-kirjainkääntäjän ja -sanakirjan
 * päälle.
 * @author vapsolon
 */


public class Morse {
    
    //Morse-sanakirja luokan käyttöön
    private MorseDict m;
    
    /**
     * Konstruktori alustaa Morse-sanakirjan.
     */
    public Morse(){
        //Alustetaan sanakirja kun olio luodaan
        this.m = new MorseDict();
    }

    /**
     * Varsinainen käännöstoiminnallisuus sanoille ja lauseille. <br>
     * Kirjainkohtaiset käännökset suorittaa sanakirja
     * @param input Käännettävä syöte
     * @return Käännetty tulos
     */
    public String translate(String input){
        //Luodaan käännetyn merkkijonon rakentaja
        ResultBuilder result = new ResultBuilder();
        CharArray ca = new CharArray();
        //Käydään syöte läpi merkki kerrallaan
        for(char c: ca.convert(input)){
            //Annetaan sanakirjan kääntää merkki
            result.appendString(m.translate(c));
        }
        //Palautetaan tulos
        return result.toString();
    }
    
}
