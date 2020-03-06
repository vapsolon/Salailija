package labra.tira.salailija.Utils;

/**
 * Alkuperäinen Quicksort-toteutus, nyt nimetty uudelleen koska kyseessä on
 * suurempi erikoistapaus verrattuna nykyiseen toteutukseen. <br>
 * Tehtävänä on järjestää annetun merkkijonon merkit aakkosjärjestykseen.
 * @author vapsolon
 */

public class CharArraySort {
    
    private CharIndex[] characters;
    
    /**
     * Aloitusfunktio ja näistä ainoa ulkopuolelta kutsuttava. <br>
     * Luo annetusta merkkijonosta ensin CharIndex-listan ja aloittaa sitten
     * tämän listan perusteella järjestämisprosessin. <br>
     * Tekee hieman oletettua enemmän ja palauttaa lopulta listan joka kuvastaa
     * yksittäisten merkkien alkuperäisiä sijainteja merkkijonossa, mutta nyt
     * järjestettynä aakkosjärjestykseen
     * @param s Järjestettävä merkkijono
     * @return Lista merkkien alkuperäisistä sijainneista merkkijonossa, nyt 
     * aakkosjärjestyksessä
     */
    public int[] start(String s){
        this.characters = new CharIndex[s.length()];
        int i = 0;
        CharArray ca = new CharArray();
        for(char c: ca.convert(s)){
            CharIndex ci = new CharIndex(c, i);
            this.characters[i] = ci;
            i++;
        }
        sort(0, s.length()-1);
        identical();
        int[] columns = new int[s.length()];
        for(int j=0;j<this.characters.length;j++){
            columns[j] = this.characters[j].getIndex();
        }
        return columns;
    }

    //Järjestyksen aloitus
    private void sort(int start, int end){
        if(start < end){
            int middle = split(start, end);
            sort(start, middle-1);
            sort(middle+1, end);
        }
    }

    //Puolitusmetodi, käytännössä järjestys tapahtuu täällä
    private int split(int start, int end){
        int middle = start;
        for(int i=start+1;i<=end;i++){
            CharIndex current = this.characters[i];
            CharIndex first = this.characters[start];
            if(current.getChar() < first.getChar()){
                middle++;
                this.characters[i] = this.characters[middle];
                this.characters[middle] = current;
            }
        }
        CharIndex temp = this.characters[start];
        this.characters[start] = this.characters[middle];
        this.characters[middle] = temp;
        return middle;
    }
    
    //Joskus identtisten merkkien järjestys ei mene pelkällä quicksortilla
    //oikein vaan merkkijonossa myöhemmin esiintynyt merkki asetetaan aiemman
    //merkin edelle. Oikaistaan nämä tilanteet vielä erillisellä tarkistuksella.
    private void identical(){
        for(int i=1;i<this.characters.length;i++){
            CharIndex current = this.characters[i];
            CharIndex pred = this.characters[i-1];
            if((pred.getChar() == current.getChar())
                    && (pred.getIndex() > current.getIndex())){
                this.characters[i-1] = current;
                this.characters[i] = pred;
                identical();
            }
        }
    }
    
}
