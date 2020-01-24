package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Structures.MorseDict;

/**
 * Morse-kääntäjä tekstille, rakennettu Morse-kirjainkääntäjän ja -sanakirjan päälle
 * @author vapsolon
 */


public class Morse {
    
    //Morse-sanakirja luokan käyttöön
    private MorseDict m;
    
    /**
     * Konstruktori alustaa Morse-sanakirjan
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
        StringBuilder result = new StringBuilder();
        //Käydään syöte läpi merkki kerrallaan
        for(char c: input.toCharArray()){
            //Annetaan sanakirjan kääntää merkki
            result.append(m.translate(c));
        }
        //Palautetaan tulos
        return result.toString();
    }
    
}
