package labra.tira.salailija.Utils;

/**
 * Käännösdatatyyppi käytettäväksi HashMapin tilalle luoduissa 
 * sanakirjaluokissa. <br>
 * Settereitä ei ole ollenkaan sillä käännöksillä ei ole syytä muuttua ajon
 * aikana.
 * @author vapsolon
 */

public class Translation {
    
    private final char character;
    private final String translation;
    
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
