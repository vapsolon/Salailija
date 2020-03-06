package labra.tira.salailija;

import javafx.application.Application;
import labra.tira.salailija.UI.GraphicalInterface;
import labra.tira.salailija.Utils.TestPerformance;
/**
 * Pääluokka koko ohjelmalle. <br>
 * Käynnistää graafisen käyttöliittymän, tai tarvittaessa ajaa
 * suorituskykytestauksen.
 * @author vapsolon
 */
public class Main {
    
    /**
     * public static void main. <br>
     * Alustaa ja käynnistää käyttöliittymän.
     * @param args yleensä tyhjä, jos args[0] on "performance" ajetaan
     * suorituskykytestit
     */
    public static void main(String[] args){
        if(args.length > 0 && args[0].equals("performance")){
            TestPerformance tp = new TestPerformance();
            tp.test();
        }
        else{
            Application.launch(GraphicalInterface.class,
                "--testing=no");
        }
    }
    
}
