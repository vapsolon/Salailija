package labra.tira.salailija.Utils;

/**
 * Frekvenssianalyysin pääluokka. <br>
 * Melkein kaikki toiminnallisuus on siirretty alaluokkiin, joten täältä
 * löytyy käytännössä ainoastaan "käyttöliittymä" ja keskustelu UI:n kanssa.
 * @author vapsolon
 */
public class FrequencyAnalysis {
    
    /**
     * Käynnistetään annetun merkkijonon analyysi ja palautetaan lopulta saatu
     * tulos. <br>
     * Syöte muunnetaan ensin merkkilistaksi joka syötetään sitten merkki
     * kerrallaan frekvenssisanakirjan käsiteltäväksi. Lopulta sanakirja
     * tulostetaan.
     * @param source Analysoitava merkkijono
     * @return Analyysin tulos listana merkki-lukumäärä -pareja hieman
     * sievemmässä muodossa
     */
    public String analyze(String source){
        CharArray ca = new CharArray();
        FrequencyMap fm = new FrequencyMap(source.length());
        char[] split = ca.convert(source);
        
        for(char c: split){
            fm.add(c);
        }
        
        return fm.toString();
    }
    
}
