package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Structures.LeetDict;

/**
 * 1337-kääntäjä tekstille, rakennettu 1337-kirjainkääntäjän ja
 * -sanakirjan päälle.
 * @author vapsolon
 */

public class Leet {
    
    //Sanakirja
    private LeetDict l;
    
    /**
     * Konstruktori alustaa sanakirjan.
     */
    public Leet(){
        this.l = new LeetDict();
    }
    
    /**
     * Varsinainen kääntäjä sanoille ja lauseille. <br>
     * Kirjaintason kääntäminen on sanakirjan vastuulla.
     * @param input Käännettävä syöte
     * @return Käännetty tulos
     */
    public String translate(String input){
        //Luodaan palautettavan käännöksen rakentaja
        StringBuilder result = new StringBuilder();
        //Käydään syöte läpi merkki kerralaan
        for(char c: input.toCharArray()){
            //Käytetään merkki sanakirjan oman kääntäjän kautta ja lisätään
            //tulos palautukseen
            result.append(l.translate(c));
        }
        return result.toString();
    }
    
}
