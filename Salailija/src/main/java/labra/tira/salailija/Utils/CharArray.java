package labra.tira.salailija.Utils;

/**
 * String.toCharArray() -vastine. <br>
 * Muuntaa merkkijonon merkkilistaksi. Toiminnallisuus on hyvin tärkeä
 * jokaiselle tuetulle salausmenetelmälle, sillä kaikki ovat merkkikohtaisia
 * salauksia. Korvaa tosiaan String-luokan vastaavan metodin.
 * @author vapsolon
 */
public class CharArray {
    
    /**
     * Muuntaa annetun merkkijonon merkkilistaksi. <br>
     * Ei kovin erityinen funktio, käy yksinkertaisesti merkkijonon läpi merkki
     * kerrallaan ja asettaa tietyssä kohdassa olevan merkin vastaavaan kohtaan
     * merkkilistalla.
     * @param s Pilkottava merkkijono
     * @return Pilkottu merkkilista
     */
    public char[] convert(String s){
        char[] result = new char[s.length()];
        for(int i=0;i<s.length();i++){
            result[i] = s.charAt(i);
        }
        return result;
    }
    
    /**
     * Muuntaa annetun merkkijonon tavulistaksi. <br>
     * Sama periaate kuin merkkilistallakin, mutta muuntaa suoraan tavuiksi
     * tukemaan privkeyn uutta muotoa tiedostosalaajana.
     * @param s Pilkottava merkkijono
     * @return Pilkottu tavulista
     */
    public byte[] byteArray(String s){
        byte[] result = new byte[s.length()];
        for(int i=0;i<s.length();i++){
            result[i] = (byte)s.charAt(i);
        }
        return result;
    }
    
}
