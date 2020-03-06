package labra.tira.salailija.Utils;

/**
 * Frekvenssianalyysissä käytettävä merkki-lukumäärä -pari.
 * Inspiraatio haettu Translation-luokasta, tosin tällä kertaa lukumäärälle
 * on sekä setteri että helppo kasvatusfunktio.
 * @author vapsolon
 */
public class FrequencyPair {
    
    private final char character;
    private int count;
    
    /**
     * Konstruktori alustaa olion tiedot.
     * Merkin arvoksi asetetaan haluttu merkki ja lukumääräksi aina 1.
     * @param ch Olioon tallennettava merkki
     */
    public FrequencyPair(char ch){
        this.character = ch;
        this.count = 1;
    }
    
    /**
     * Palauttaa olion säilyttämän merkin.
     * @return Olion säilyttämä merkki
     */
    public char getCharacter(){
        return this.character;
    }
    
    /**
     * Palauttaa olion säilyttämän merkin esiintymismäärän.
     * @return Lukumäärä kuinka monta kertaa olion merkki on esiintynyt
     * tekstissä.
     */
    public int getCount(){
        return this.count;
    }
    
    /**
     * Asettaa olion merkin esiintymismäärän tiettyyn arvoon.
     * @param newCount Uusi esiintymismäärä tallennettavaksi
     */
    public void setCount(int newCount){
        this.count = newCount;
    }
    
    /**
     * Kasvattaa olion merkin esiintymismäärää yhdellä.
     */
    public void growCount(){
        this.count++;
    }
    
}
