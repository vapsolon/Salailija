
package labra.tira.salailija.Ciphers;

import labra.tira.salailija.Utils.CharArraySort;
import labra.tira.salailija.Utils.ResultBuilder;

/**
 * Hyvin rajoitettu Columnar Transposition -toteutus. Ottaa käyttäjältä vastaan
 * ensin salattavan viestin ja sitten salauksen avaimen jonka perusteella 
 * sarakkeiden uusi järjestys määritetään. <br>
 * Järjestyksen määrittämiseen käytetään yksinkertaisesti avaimen sisäistä
 * aakkosjärjestystä, itse järjestämisestä huolehtii CharArraySort-luokka
 * @author vapsolon
 */

public class ColumnarTransposition {
    
    /**
     * Kääntää viestin saraketranspositiota käyttäen annetun avaimen perusteella
     * <br>
     * Avaimena toimii mikä tahansa merkkijono jonka CharArraySort voi vain 
     * järjestää. Tämän merkkijonon kirjaimet järjestetään aakkosjärjestykseen,
     * mutta niiden alkuperäisistä sijainneista merkkijonossa pidetään kirjaa
     * ja niiden avulla luodaan viestin sarakkeille uusi järjestys. <br>
     * Itse viesti pilkotaan vakiomittaisiin riveihin avaimen pituuden
     * perusteella, ja lopulta pilkotun viestin sarakkeet sekoitetaan
     * sarakelistan perusteella.
     * @param message Salattava viesti
     * @param key Salauksessa käytettävä avain
     * @return Salattu viesti
     */
    public String translate(String message, String key){
        key = key.replaceAll("\\s+","");
        //Luodaan avaimelle järjestäjä
        CharArraySort q = new CharArraySort();
        //Haetaan avaimen kirjainten aakkosjärjestys kolumnien järjestykseksi
        int[] columns = q.start(key);
        
        //Tallennetaan listan pituus, tätä tarvitaan käännöksessä
        int keyLen = columns.length;
        
        //Lasketaan avaimen pituuden avulla käännösmatriisiin tarvittavien
        //rivien määrä
        int rows = (int)Math.ceil(message.length() / keyLen);
        //Ja tallennetaan myös viimeiselle vajaalle riville pusketun ylijäämän
        //pituus
        int surplus = message.length() % keyLen;
        if(surplus > 0){
            rows++;
            for(int k=0;0<=k && k<keyLen-surplus;k++){
                message += " ";
            }
        }
        
        //Luodaan käännösmatriisi, rivejä siis (rivien määrä + yksi ylimääräinen
        //ylivuodolle
        char[][] translation = new char[rows][keyLen];
        //Suoritetaan käännös
        for(int i=0;i<rows;i++){
            for(int j=0;j<keyLen;j++){
                //Rivi suoraan i:n perusteella, sarakkeiden sekoitus saadaan
                //aikaan käyttämällä suoraan numeerisen avaimen uusia
                //sarakearvoja
                translation[i][columns[j]] = message.charAt(i*keyLen + j);
            }
        }
        
        /*//Käsitellään vielä ylivuoto erikseen samalla periaatteella
        for(int j=0;j<surplus;j++){
            translation[rows][columns[j]] = message.charAt(rows*keyLen + j);
        }*/
        
        //Luodaan lopullisen tuloksen rakentaja
        ResultBuilder result = new ResultBuilder();
        //Rakennetaan vielä salattu merkkijono matriisin palikoista
        for(int i=0;i<rows;i++){
            for(int j=0;j<keyLen;j++){
                result.append(translation[i][j]);
            }
        }
        
        return result.toString();
    }
}
