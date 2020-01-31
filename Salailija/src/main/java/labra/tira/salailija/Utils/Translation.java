package labra.tira.salailija.Utils;

/**
 * Käännösdatatyyppi käytettäväksi HashMapin tilalle luoduissa 
 * sanakirjaluokissa. <br>
 * Ei sisällä settereitä sillä käännöksiä ei ole koskaan tarve muuttaa, ne
 * luodaan kertaalleen sanakirjaolion luonnin yhteydessä ja ne pysyvät
 * muuttumattomina olion eliniän ajan.
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
