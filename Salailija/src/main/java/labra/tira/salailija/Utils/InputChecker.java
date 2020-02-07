package labra.tira.salailija.Utils;

/**
 * Syötteentarkistusluokka tiettyjen salausmenetelmien käyttöön. <br>
 * Tällä hetkellä varmistaa, että Caesar saa syötteenä vain numeerisia
 * rotaatioita, mutta tulee varmasti laajenemaan tulevaisuudessa.
 * @author vapsolon
 */
public class InputChecker {
    
    /**
     * Tarkista onko annettu merkkijono numeerinen vai sisältääkö se
     * mahdollisesti myös kirjainmerkkejä.
     * @param input Testattava merkkijono
     * @return true jos merkkijonossa oli ainoastaan numeroita, false muuten
     */
    public boolean isNumeric(String input){
        CharArray ca = new CharArray();
        char[] split = ca.convert(input);
        for(char c: split){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    
}
