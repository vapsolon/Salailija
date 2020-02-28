package labra.tira.salailija.Utils;

/**
 * Jo aiemmin toteutettu Quicksort, tällä kertaa paljon klassisemmassa muodossa.
 * <br>
 * Tehtävänä on järjestää frekvenssianalyysin tuottamia merkkien
 * esiintymismäärälistoja esiintymismäärän perusteella.
 * @author vapsolon
 */

public class Quicksort {
    
    private FrequencyPair[] frequencies;
    
    /**
     * Aloitusfunktio ja näistä ainoa ulkopuolelta kutsuttava. <br>
     * Ottaa vastaan valmiin frekvenssiparilistan ja siirtää sen
     * järjestettäväksi. Kun järjestys on valmis palauttaa tuloksen.
     * @param fp Järjestettävä FrequencyPair-lista
     * @param length Listan aito pituus, ei siis sisällä listan olemassa olevia
     * mutta täyttämättömiä kenttiä
     * @return Parametrina annettu lista mutta järjestettynä
     */
    public FrequencyPair[] start(FrequencyPair[] fp, int length){
        this.frequencies = fp;
        sort(0, length-1);
        return this.frequencies;
    }

    private void sort(int start, int end){
        if(start < end){
            int middle = split(start, end);
            sort(start, middle-1);
            sort(middle+1, end);
        }
    }

    private int split(int start, int end){
        int middle = start;
        for(int i=start+1;i<=end;i++){
            FrequencyPair current = this.frequencies[i];
            FrequencyPair first = this.frequencies[start];
            if(current.getCount() > first.getCount()){
                middle++;
                this.frequencies[i] = this.frequencies[middle];
                this.frequencies[middle] = current;
            }
        }
        FrequencyPair temp = this.frequencies[start];
        this.frequencies[start] = this.frequencies[middle];
        this.frequencies[middle] = temp;
        return middle;
    }
    
}
