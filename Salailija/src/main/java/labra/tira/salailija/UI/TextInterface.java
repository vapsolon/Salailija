package labra.tira.salailija.UI;

import java.util.Scanner;
import labra.tira.salailija.Ciphers.*;

/**
 * Väliaikainen tekstikäyttöliittymä ohjelmalle sillä välin kun tärkeämpiä osia
 * vielä kehitetään. Tarkoitus vaihtaa mukavaan pieneen graafiseen versioon
 * ajallaan
 * @author vapsolon
 */
public class TextInterface {
    
    private Scanner input;
    private Caesar c;
    private Leet leet;
    private Morse morse;
    private ColumnarTransposition ct;
    private PrivateKey pk;
    
    /**
     * Parametriton konstruktori vakiokäyttöön.
     */
    public TextInterface(){
        this(new Scanner(System.in));
    }
    
    /**
     * Varsinainen konstruktori joka ottaa vastaan Scannerin parametrina.
     * Toteutettu näin testaamissyistä. <br>
     * Asettaa tarjotun skannerin luokan käytettäväksi ja alustaa kaikki
     * käytössä olevat käännöspalvelut.
     * @param s Syötteen vastaanottamiseen käytettävä Scanner
     */
    public TextInterface(Scanner s){
        this.input = s;
        this.c = new Caesar();
        this.leet = new Leet();
        this.morse = new Morse();
        this.ct = new ColumnarTransposition();
        this.pk = new PrivateKey();
    }
    
    /**
     * Varsinainen käyttöliittymä klassisessa tekstimuodossa. <br><br>
     * Tulostaa listan toiminnoista ja kysyy loputtomassa silmukassa käyttäjältä
     * komentoja kunnes käyttäjä päättää lopettaa.
     */
    public void run(){
        System.out.println("Tervetuloa Salailijaan!");
        System.out.println("Mitä haluaisit tehdä?");
        System.out.println("");
        System.out.println(" 1) Caesarian Shift");
        System.out.println(" 2) ROT13");
        System.out.println(" 3) Morse");
        System.out.println(" 4) 1337");
        System.out.println(" 5) Columnar Transposition");
        System.out.println(" 6) Private Key Encryption");
        System.out.println("");
        System.out.println(" x) Poistu"); //Tuloste 8
        //Loopataan loputtomasti kunnes käyttäjä haluaa pois
        while(true){
            System.out.println("");
            System.out.print("Komento: "); //Tuloste 10
            String action = input.nextLine();
            
            if(action.equalsIgnoreCase("x")){
                break;
            }
            else if(action.equals("1")){
                System.out.println("");
                System.out.println("Ceaserian Shift valittu");
                System.out.print("Syötä salattava sana tai lause: ");
                String plaintext = input.nextLine();
                System.out.println("");
                System.out.print("Syötä haluttu siirtymämäärä (0-26): ");
                int shift = Integer.valueOf(input.nextLine());
                System.out.println("");
                String result = c.cipher(plaintext, shift);
                //Tuloksen on mahdollista olla null jos esimerkiksi siirtymä
                //on laiton. Tällöin itse kääntäjäluokka tulostaa valituksensa
                //jolloin täällä ei tarvitse tulostusta ollenkaan
                if(result != null){
                    System.out.println("Tulos: " + result);
                }
            }
            else if(action.equals("2")){
                System.out.println("");
                System.out.println("ROT13 valittu");
                System.out.print("Syötä salattava sana tai lause: ");
                String plaintext = input.nextLine();
                System.out.println("");
                String result = c.cipher(plaintext, 13);
                //Nyt siirtymä on vakio (ainakin toivottavasti), joten tuloksen
                //voi suoraan tulostaa ilman null-tarkastusta
                System.out.println("Tulos: " + result);
            }
            else if(action.equals("3")){
                System.out.println("");
                System.out.println("Morse valittu");
                System.out.print("Syötä salattava sana tai lause: ");
                String plaintext = input.nextLine();
                System.out.println("");
                //Muunnetaan syöte pieniksi kirjaimiksi sillä Morsen tapauksessa
                //jokaiselle (englantilaiselle) kirjaimelle on varmasti käännös
                //joka ei tunne iso/pieni -jakoa
                System.out.println("Tulos: " + morse.translate(plaintext));
            }
            else if(action.equals("4")){
                System.out.println("");
                System.out.println("1337 valittu");
                System.out.print("Syötä salattava sana tai lause: ");
                String plaintext = input.nextLine();
                System.out.println("");
                System.out.println("Tulos: " + leet.translate(plaintext));
            }
            else if(action.equals("5")){
                System.out.println("");
                System.out.println("Columnar Transposition valittu");
                System.out.print("Syötä salattava sana tai lause: ");
                String plaintext = input.nextLine();
                System.out.println("");
                System.out.print("Syötä salauksessa käytettävä avain: ");
                String key = input.nextLine();
                System.out.println("");
                System.out.println("Tulos: " + ct.translate(plaintext, key));
            }
            else if(action.equals("6")){
                System.out.println("");
                System.out.println("Private Key valittu");
                System.out.print("Syötä salattava sana tai lause: ");
                String plaintext = input.nextLine();
                System.out.println("");
                System.out.print("Syötä salauksessa käytettävä avain: ");
                String key = input.nextLine();
                System.out.println("");
                System.out.println("Tulos: " + pk.translate(plaintext, key));
            }
            else{
                System.out.println("");
                System.out.println("Epäkelpo syöte " + action
                        + ", yritä uudestaan"
                );
            }
        }
    }
    
}
