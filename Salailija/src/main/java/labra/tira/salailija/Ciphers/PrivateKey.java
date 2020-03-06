package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Utils.CharArray;

/**
 * Yksinkertainen yksityisen avaimen symmetrinen salausmenetelmä <br>
 * Ottaa vastaan tavulistan ja käyttäjän määrittelemän avaimen ja salaa sisällön
 * avaimen avulla XOR-operaatioilla.
 * @author vapsolon
 */

public class PrivateKey { 
    /**
     * Käännösfunktio tiedostokääntämiseen. <br>
     * Yksinkertainen XOR-pohjainen tavusalaus. Merkkijonomuotoinen avain
     * muutetaan ensin tavulistaksi ja salattava syöte käsitellään sitten tavu
     * kerrallaan.
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
