package labra.tira.salailija.Utils;

/**
 * Sanakirjatoteutus, tällä kertaa muokattu merkki-lukumäärä -muotoiseksi. <br>
 * Kyseessä tosiaan siis Dictionary-luokan kopio sillä metodit ja tallennettava
 * data ovat tarpeeksi erilaisia jotta erillinen luokka oli tarpeen selkeyden
 * vuoksi. Tallettaa listan merkki-lukumäärä -pareja ja tarvittaessa palauttaa
 * listan sanakirjaan tallennetuista merkeistä ja niiden lukumääristä.
 * @author vapsolon
 */
public class FrequencyMap {
    
    private FrequencyPair[] dictionary;
    //Pidetään kirjaa listan seuraavasta avoimesta indeksistä
    private int openIndex;
    //Pidetään kirjaa listan nykyisestä maksimikoosta
    private int size;
    //Pidetään kirjaa listalle lisättyjen käännösten määrästä
    private int added;
    
    /**
     * Konstruktori alustaa sanakirjan analysoitavan viestin pituuden
     * perusteella.<br>
     * Lisäksi apumuuttujat alustetaan samalla. Viestin pituinen sanakirja voisi
     * olla hieman liian pitkä, kyseessä on kuitenkin viestin uniikkien merkkien
     * tilastointi, joten aloitetaan viestin puolikkaan pituudella ja kasvetaan
     * tarvittaessa.
     * @param length Tallennettavan merkkijonon pituus, käytetään alustamaan
     * sanakirja
     */
    public FrequencyMap(int length){
        this.dictionary = new FrequencyPair[(int)(length/2)];
        this.size = (int)(length/2);
        this.openIndex = 0;
        this.added = 0;
    }
    
    /**
     * Lisää uuden merkki-lukumäärä -parin sanakirjaan, tai kasvattaa jo
     * sanakirjassa olevan merkin lukumäärää. <br>
     * Jos merkki on jo sanakirjassa, sen lukumäärä vain kasvaa. Jos merkkiä
     * ei ole sanakirjassa, se lisätään sinne.
     * @param character Lisättävä merkki
     */
    public void add(char character){
        int index = contains(character);
        if(index == -1){
            if(this.openIndex == this.size){
                grow();
            }
            FrequencyPair fp = new FrequencyPair(character);
            this.dictionary[this.openIndex] = fp;
            this.openIndex++;
            this.added++;
        }
        else{
            FrequencyPair fp = get(index);
            fp.growCount();
        }
    }

    /**
     * Hakee frekvenssiparin tietystä indeksistä. <br>
     * Koska contains() palauttaa löydetyn merkin indeksin, voidaan hakeminen
     * supistaa tämän indeksin hakemiseen taulukosta. Varmistetaan kuitenkin
     * vielä että annettu indeksi on taulukon käyttöalueella ennen varsinaisen
     * tiedon palauttamista.
     * @param index Indeksi jossa olevaa tietoa haetaan
     * @return Haetusta indeksistä löytynyt FrequencyPair jos indeksi oli
     * olemassa, muuten null
     */
    public FrequencyPair get(int index){
        if(index >= 0 && index < added){
            return this.dictionary[index];
        }
        return null;
    }
    
    /**
     * Tarkistetaan sisältääkö sanakirja tietyn merkin. <br>
     * Käydään koko sanakirja läpi indeksi kerrallaan ja yritetään löytää
     * kysytty merkki. Koska merkit ovat tallennettuna FrequencyPair-muotoon,
     * palautetaan indeksi jonka avulla löydetyn merkin voi helposti hakea.
     * @param character Haettava merkki
     * @return Löydetyn merkin indeksi jos merkki löytyi, muuten -1
     */
    public int contains(char character){
        for(int i=0;i<this.added;i++){
            FrequencyPair c = this.dictionary[i];
            if(character == c.getCharacter()){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Kasvatetaan sanakirjan tallennustilana toimivan listan kokoa tarvittaessa
     * <br>
     * Nyt sanakirjaan lisätään merkkejä konstruktorin ulkopuolelta joten
     * kasvatustoiminnallisuuden täytyy olla kunnossa. Sama metodi toimii myös
     * muissa omintakeisissa listarakenteissa, joten uusiokäyttöön myös täällä.
     */
    public void grow(){
        //Tuplatarkistus pääasiassa jotta PIT ajaa paremmin eikä syö koko
        //tarjolla olevaa muistia erroriin asti
        if(this.openIndex == this.size){
            FrequencyPair[] temp = new FrequencyPair[this.size+this.size];
            for(int i=0;i<this.size;i++){
                temp[i] = this.dictionary[i];
            }
            this.dictionary = temp;
            this.size = size+size;
        }
    }
    
    @Override
    public String toString(){
        Quicksort q = new Quicksort();
        FrequencyPair[] temp = q.start(this.dictionary, added);
        ResultBuilder rb = new ResultBuilder();
        for(int i=0;i<added;i++){
            FrequencyPair fp = temp[i];
            String result = "Merkki: '" + fp.getCharacter() + "', määrä: "
                    + fp.getCount() + "\n";
            rb.appendString(result);
        }
        return rb.toString();
    }
    
}
