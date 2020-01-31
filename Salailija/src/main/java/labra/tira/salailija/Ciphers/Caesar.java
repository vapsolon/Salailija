package labra.tira.salailija.Ciphers;

/**
 * Caesarian Shift -toteutus, tällä hetkellä vielä amerikkalaistyylinen eli
 * suurin mahdollinen shift on 26. <br>
 * Ääkkösiä ei tueta ja ne tullaan käsittelemään erikoistapauksina myöhemmin
 * <br><br>
 * Toimii myös ROT13-toteutuksena vakiosiirtymällä 13
 * @author vapsolon
 */

//TODO: ääkköset, numerot, mahdollisesti jopa erikoismerkit (!?)


public class Caesar {

    private int base = 97; //Pienten kirjainten a
    private int top = 122; //Pienten kirjainten z
    private int bigbase = 65; //Isojen kirjainten A
    private int bigtop = 90; //Isojen kirjainten Z

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
            System.out.println(
            "Virheellinen rotaatiomäärä. Sallitut rotaatiot ovat välillä 0-26"
            );
            return null;
        }
        //Alustetaan salatun tekstin rakentaja
        StringBuilder encoded = new StringBuilder();
        //Käydään salattava data läpi merkki kerrallaan
        for(char c: input.toCharArray()){
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
                encoded.append((char)newval);
            }
            //Jos merkkiä ei saatu (vielä) salattua, kirjoitetaan se silti jonon
            //jatkoksi jotta tietoa (välimerkit, numerot, ääkköset) ei häviä
            else{
                encoded.append(c);
            }
        }
        //Palautetaan lopulta salattu merkkijono
        return encoded.toString();
    }
}
