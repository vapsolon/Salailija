package labra.tira.salailija.Utils;

/**
 * Omatekoinen luokka korvaamaan tarve HashMapille. <br>
 * Tarjoaa vastaavanlaiset toiminnallisuudet kaikille aiemmassa versiossa
 * käytetyille HashMap-metodeille. Tehokkuudesta ei takuita mutta kaikki
 * tarvittava toimii ja pääsee läpi testeistä. <br>
 * 
 * Apuna toimii Translation-datatyyppi joka helpottaa sana-käännösparien
 * muodostamista tallentamalla molemmat itseensä, jolloin varsinaiseksi
 * sanakirjaksi liittää lista näitä käännösolioita.
 * @author vapsolon
 */

public class Dictionary {
    
    private Translation[] dictionary;
    private int openIndex;
    private int size;
    private int added;
    
    /**
     * Konstruktori alustaa sanakirjan ensin 10 alkion kokoiseksi ja asettaa
     * samalla muutaman apumuuttujan alkuarvoihinsa.
     */
    public Dictionary(){
        this.dictionary = new Translation[10];
        this.size = 10;
        this.openIndex = 0;
        this.added = 0;
    }
    
    /**
     * Lisää uuden sana-käännösparin sanakirjaan. <br>
     * Sanan voi lisätä vain kerran ja jos sanalle on jo käännös, uusi yritys
     * jätetään huomiotta. Näin koska sanakirjaan tullaan lisäämään ainoastaan
     * automaattisesti varsinaisten erikoistuneiden sanakirjojen
     * konstruktoreissa joten muokkaustarvetta ei ole.
     * @param character Lisättävä sana
     * @param translation Lisättävä käännös
     */
    public void add(char character, String translation){
        if(!(contains(character))){
            if(this.openIndex == this.size){
                grow();
            }
            Translation c = new Translation(character, translation);
            this.dictionary[this.openIndex] = c;
            this.openIndex++;
            this.added++;
        }
    }
    
    /**
     * Hakee sanakirjasta käännöksen alkuperäisen sanan perusteella.
     * @param character Sana jonka käännöstä haetaan
     * @return Sanan käännös jos sana löytyy sanakirjasta, muuten null
     */
    public String get(char character){
        for(int i=0;i<this.added;i++){
            Translation t = this.dictionary[i];
            if(character == t.getCharacter()){
                return t.getTranslation();
            }
        }
        return null;
    }
    
    /**
     * Tarkistetaan löytyykö sana sanakirjasta.
     * @param character Haettava sana
     * @return true jos sana löytyy sanakirjasta, muuten false
     */
    public boolean contains(char character){
        for(int i=0;i<this.added;i++){
            Translation c = this.dictionary[i];
            if(character == c.getCharacter()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Kasvatetaan sanakirjan tallennustilana toimivan listan kokoa tarvittaessa
     * <br>
     * Vaikka sanakiraan ei tulla lisäämään sanoja konstruktorien ulkopuolelta
     * täytyy luokan kuitenkin olla yleispätevä ainakin kahden tällä hetkellä
     * toteutetun erikoistuneen sanakirjan pohjana. Jo näiden kahden sanakirjan
     * merkkimäärien välillä on suuri ero, joten staattisen suurimman
     * mahdollisen koon sijasta kasvetaan dynaamisesti tarvittaessa ja
     * skaalaudutaan täten paremmin myös tulevaisuutta ajatellen.
     */
    public void grow(){
        //Tuplatarkistus pääasiassa jotta PIT ajaa paremmin eikä syö koko
        //tarjolla olevaa muistia erroriin asti
        if(this.openIndex == this.size){
            Translation[] temp = new Translation[this.size+this.size];
            for(int i=0;i<this.size;i++){
                temp[i] = this.dictionary[i];
            }
            this.dictionary = temp;
            this.size = size+size;
        }
    }
    
}
