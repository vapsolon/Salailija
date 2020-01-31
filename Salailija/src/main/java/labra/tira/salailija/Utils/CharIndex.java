package labra.tira.salailija.Utils;

/**
 * Apudatatyyppi ohjelman pikajärjestämisluokalle. Pitää kirjaa tietyn merkin
 * alkuperäisestä sijanumerosta oman merkkijononsa sisällä. <br>
 * Kuten lähisukulaisensa Translation, myöskään CharIndex ei sisällä settereitä
 * sillä arvon ei koskaan tarvitse vaihtua olion konsturktorin asettamasta
 * miksikään muuksi (ainakaan ohjelman nykyisen toiminnallisuuden rajoissa).
 * @author vapsolon
 */

public class CharIndex {
    
    private char character;
    private int index;
    
    /**
     * Konstruktori tallentaa olion datatyypit.
     * @param c Tallennettava merkki
     * @param i Tallennettavan merkin paikka alkuperäisessä merkkijonossa
     */
    public CharIndex(char c, int i){
        this.character = c;
        this.index = i;
    }
    
    /**
     * Getteri merkin arvolle.
     * @return Olioon tallennetun merkin arvo
     */
    public char getChar(){
        return this.character;
    }
    
    /**
     * Getteri merkin paikan arvolle.
     * @return Olioon tallennetun merkin alkuperäinen paikka omassa
     * merkkijonossaan
     */
    public int getIndex(){
        return this.index;
    }
    
}
