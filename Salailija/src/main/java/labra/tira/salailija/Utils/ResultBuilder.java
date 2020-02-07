package labra.tira.salailija.Utils;

/**
 * StringBuilder-vastine salausluokkien palautettavien salattujen viestien
 * rakentamiseen. <br>
 * Tallentaa merkkejä käytännössä suoraan Dictionarystä kopioituun
 * listarakenteeseen ja tarvittaessa palauttaa listasta rakennetun merkkijonon.
 * @author vapsolon
 */
public class ResultBuilder {
    
    //Varsinainen merkkilista
    private char[] chars;
    //Seuraava avoin indeksi listalla, käytetään lisäämisessä
    private int openIndex;
    //Listan tämänhetkinen maksimikoko, käytetään kasvattamisessa
    private int size;
    //Listalle lisättyjen merkkien lukumäärä, käytetään rakentamisessa
    private int added;
    
    /**
     * Konstruktori alustaa listan ja lisäämisessä, palautuksen rakentamisessa
     * ja listan koon kasvattamisessa käytettävä apumuuttujat.
     */
    public ResultBuilder(){
        this.chars = new char[10];
        this.openIndex = 0;
        this.size = 10;
        this.added = 0;
    }
    
    /**
     * Lisää merkin listalle. <br>
     * Tarvittaessa listan kokoa kasvatetaan apufunktiolla, muuten hyvin
     * yksinkertainen. Kasvatettavia apumuuttujia tarvitaan listan koon
     * kasvattamisessa ja palautettavan merkkijonon rakentamisessa.
     * @param c Lisättävä merkki
     */
    public void append(char c){
        if(this.openIndex == this.size){
            grow();
        }
        this.chars[this.openIndex] = c;
        this.openIndex++;
        this.added++;
    }
    
    /**
     * Apufunktio tarjoamaan tuen myös merkkijonojen lisäämiseen listalle. <br>
     * Tällä hetkellä Morse palauttaa tuloksenaan merkkijonon, sillä yksittäinen
     * merkki muuntuu mahdollisesti useamman merkin mittaiseksi Morseksi. Täten
     * tarvitaan myös tuki merkkijonojen lisäämiseen tulosrakentajaan.
     * @param s Lisättävä merkkijono
     */
    public void appendString(String s){
        CharArray ca = new CharArray();
        char[] str = ca.convert(s);
        for(char c: str){
            append(c);
        }
    }
    
    @Override
    public String toString(){
        String result = "";
        for(int i=0;i<added;i++){
            result += chars[i];
        }
        return result;
    }
    
    /**
     * Kasvatetaan tallennustilana toimivan listan kokoa tarvittaessa
     * <br>
     * Kopioitu suoraan Dictionarystä. Tällä kertaa oikeasti hyödyllinen sillä
     * merkkilista saattaa salattavan viestin koosta riippuen kasvaa hyvinkin
     * suureksi.
     */
    public void grow(){
        //Tuplatarkistus pääasiassa jotta PIT ajaa paremmin eikä syö koko
        //tarjolla olevaa muistia erroriin asti
        if(this.openIndex == this.size){
            char[] temp = new char[this.size+this.size];
            for(int i=0;i<this.size;i++){
                temp[i] = this.chars[i];
            }
            this.chars = temp;
            this.size = size+size;
        }
    }
    
}
