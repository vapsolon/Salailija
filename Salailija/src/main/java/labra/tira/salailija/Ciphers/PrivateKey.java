package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Utils.CharArray;
import labra.tira.salailija.Utils.ResultBuilder;

/**
 * Yksinkertainen yksityisen avaimen symmetrinen salausmenetelmä <br>
 * Ottaa vastaan viestin ja käyttäjän määrittelemän avaimen ja salaa viestin
 * avaimen avulla XOR-operaatioilla.<br>
 * Tällä hetkellä hieman hankalakäyttöinen sillä tekstikäyttöliittymä ei oikein
 * tykkää tuloksena saatavista eksoottisemmista merkeistä, mutta esimerkiksi
 * numeerisia avaimia käyttäen toimintaa voi testata myös konsolissa. Todellinen
 * potentiaali saavutetaan kuitenkin vasta graafisen käyttöliittymän myötä.
 * @author vapsolon
 */

public class PrivateKey {
    
    /**
     * Symmetrisen avaimen käännösfunktio. Ottaa vastaan salattavan viestin ja
     * käyttäjän itsensä määrittelemän avaimen ja salaa sitten viestin avainta
     * käyttäen. Salauksen pohjalla on yksinkertainen merkkikohtainen XOR.
     * @param message Salattava viesti
     * @param key Salauksessa käytettävä avain
     * @return Salattu viesti
     */
    public String translate(String message, String key){
        //Luodaan tulosrakentaja
        ResultBuilder result = new ResultBuilder();
        //Luodaan merkkilistamuuntaja
        CharArray ca = new CharArray();
        //Pidetään kirjaa sijainnista avaimessa
        int keyPos = 0;
        for(char c: ca.convert(message)){
            //Hypätään tarvittaessa takaisin avaimen alkuun
            if(keyPos == key.length()){
                keyPos = 0;
            }
            //Muunnetaan salattava merkki kokonaislukumuotoon
            int cval = (int)c;
            //Muunnetaan samoin salauksessa käytettävä avaimen merkki
            int mask = (int)key.charAt(keyPos);
            //Lisätään salattu tulos nyt taas merkkimuodossa tulokseen
            result.append((char)(cval ^ mask));
            keyPos++;
        }
        return result.toString();
    }
    
    /**
     * Käännösfunktio tiedostokääntämiseen. <br>
     * Tällä kertaa toimitaan raakadatan parissa. Salausmenetelmä on sama 
     * tekstisalauksesta tunnettu yksinkertainen XOR, avain pysyy edelleen
     * merkkijonomuodossa hieman muokatun CharArray-luokan ansiosta.
     * @param input Salattava data tavulistana
     * @param key Salauksessa käytettävä avain
     * @return Salattu data tavulistana
     */
    public byte[] encrypt(byte[] input, String key){
        //Alustetaan tuloslista
        byte[] result = new byte[input.length];
        //Apuluokka muuntamaan avain tavuiksi
        CharArray ca = new CharArray();
        //Muunnetaan avain tavuiksi
        byte[] keyBytes = ca.byteArray(key);
        //Pidetään kirjaa sijainnista avaimessa
        int keyPos = 0;
        //Sekä datassa
        int i = 0;
        for(byte b: input){
            //Hypätään tarvittaessa avaimen alkuun
            if(keyPos == keyBytes.length){
                keyPos = 0;
            }
            //Suoritetaan salaus ja lisätään tulos listalle
            result[i] = (byte)(input[i] ^ keyBytes[keyPos]);
            i++;
            keyPos++;
        }
        return result;
    }
    
}
