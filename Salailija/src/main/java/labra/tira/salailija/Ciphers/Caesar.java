package labra.tira.salailija.Ciphers;
import labra.tira.salailija.UI.GraphicalInterface;
import labra.tira.salailija.Utils.CharArray;
import labra.tira.salailija.Utils.ResultBuilder;

/**
 * Caesarian Shift -toteutus, tällä hetkellä vielä amerikkalaistyylinen eli
 * suurin mahdollinen shift on 26. <br>
 * Ääkkösiä tai muita "erikoismerkkejä" ei tueta
 * <br><br>
 * Toimii myös ROT13-toteutuksena vakiosiirtymällä 13
 * @author vapsolon
 */

public class Caesar {

    private final int base = 97; //Pienten kirjainten a
    private final int top = 122; //Pienten kirjainten z
    private final int bigbase = 65; //Isojen kirjainten A
    private final int bigtop = 90; //Isojen kirjainten Z
    private GraphicalInterface g;

    /**
     * Parametriton konstruktori erikoiskäyttöön.
     */
    public Caesar(){
        this(new GraphicalInterface(false));
    }
    
    /**
     * Varsinainen konstruktori joka ottaa vastaan graafisen käyttöliittymän
     * viitteen. <br>
     * Mahdollistaa virheiden helpon välittämisen takaisin käyttöliittymälle
     * joka voi sitten piirtää ne ruudulle konsolin käyttämisen tai erityisen
     * viestintäluokan sijasta.
     * @param gi Viite käynnissä olevaan graafiseen käyttöliittymään
     */
    public Caesar(GraphicalInterface gi){
        this.g = gi;
    }
    
    /**
     * Käännösfunktio, suorittaa jokaiselle syötteen kirjaimelle määritellyn
     * rotaation ja palauttaa lopuksi tulosmerkkijonon.
     * @param input Käännettävä syöte
     * @param rotation Käännöksessä käytettävän siirtymän määrä
     * @return Käännetty tulos
     */
    public String cipher(final String input, final int rotation){
        //Varmistetaan että rotaatiot ovat tällä hetkellä tuetussa ympäristössä
        if(rotation < 0 || rotation > 26){
            g.error(
            "Virheellinen rotaatiomäärä.\nSallitut rotaatiot ovat välillä 0-26"
            );
            return null;
        }
        //Alustetaan salatun tekstin rakentaja
        ResultBuilder rb = new ResultBuilder();
        CharArray ca = new CharArray();
        //Käydään salattava data läpi merkki kerrallaan
        for(char c: ca.convert(input)){
            //Haetaan merkin numeerinen esitys
            int numval = (int)c;
            //Talletetaan uusi arvo omaan muuttujaansa
            int newval = 0;

            //Pieni kirjain
            if(numval >= base && numval <= top){
                //Otetaan huomioon rotaation overflow
                if(numval + rotation > top){
                    //Lasketaan uusi siirtymä alusta:
                    //Alkuperäinen rotaatio
                    //-(yläraja - ylärajan saavuttamiseen tarvittu siitymä)
                    //-1, koska pohja-arvo on validi merkki
                    int temp = rotation - (top-numval) - 1;
                    //Suoritetaan loput siirtymästä
                    newval = base + temp;
                }
                else{
                    //Jos ylivuotoa ei tapahdu siirtymä on helppo
                    newval = numval + rotation;
                }
            }

            //Iso kirjain
            else if(numval >= bigbase && numval <= bigtop){
                //Lasketaan uusi siirtymä alusta:
                //Alkuperäinen rotaatio
                //-(yläraja - ylärajan saavuttamiseen tarvittu siitymä)
                //-1, koska pohja-arvo on validi merkki
                if(numval + rotation > bigtop){
                    int temp = rotation - (bigtop-numval) - 1;
                    //Suoritetaan loput siirtymästä
                    newval = bigbase + temp;
                }
                else{
                    //Jos ylivuotoa ei tapahdu siirtymä on helppo
                    newval = numval + rotation;
                }
            }
            //Jos merkki saatiin salattua, kirjoitetaan salattu
            //merkki tulosjonoon
            if(newval != 0){
                rb.append((char)newval);
            }
            //Jos merkkiä ei saatu (vielä) salattua, kirjoitetaan se silti jonon
            //jatkoksi jotta tietoa (välimerkit, numerot, ääkköset) ei häviä
            else{
                rb.append(c);
            }
        }
        //Palautetaan lopulta salattu merkkijono
        return rb.toString();
    }
}
