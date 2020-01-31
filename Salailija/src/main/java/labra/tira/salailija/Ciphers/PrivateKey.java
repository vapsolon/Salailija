package labra.tira.salailija.Ciphers;

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
        StringBuilder result = new StringBuilder();
        int keyPos = 0;
        for(char c: message.toCharArray()){
            if(keyPos == key.length()){
                keyPos = 0;
            }
            int cval = (int)c;
            int mask = (int)key.charAt(keyPos);
            result.append((char)(cval ^ mask));
            keyPos++;
        }
        return result.toString();
    }
    
}
