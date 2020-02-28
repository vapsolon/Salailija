package labra.tira.salailija.Utils;

/**
 * Käännösdatatyyppi käytettäväksi HashMapin tilalle luoduissa 
 * sanakirjaluokissa. <br>
 * Käännökselle on setteri sillä sitä joudutaan muuttamaan frekvenssianalyysin
 * aikana, alkuperäisen merkin arvo ei muutu koskaan.
 * @author vapsolon
 */

public class Translation {
    
    private char character;
    private String translation;
    
    /**
     * Luokan konstruktori tallettaa luokan arvot.
     * @param c Alkuperäinen merkki
     * @param t Alkuperäisen merkin käännös
     */
    public Translation(char c, String t){
        this.character = c;
        this.translation = t;
    }
    
    /**
     * Getteri alkuperäisen merkin arvolle.
     * @return Olion tallettama alkuperäinen merkki
     */
    public char getCharacter(){
        return this.character;
    }
    
    /**
     * Getteri alkuperäisen merkin käännöksen arvolle.
     * @return Olion tallettama alkuperäisen merkin käännös
     */
    public String getTranslation(){
        return this.translation;
    }
    
}
