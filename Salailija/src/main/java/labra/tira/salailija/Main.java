package labra.tira.salailija;

import javafx.application.Application;
import labra.tira.salailija.UI.GraphicalInterface;
/**
 * Pääluokka koko ohjelmalle. Tällä hetkellä käynnistää vain
 * tekstikäyttöliittymän mutta tulevaisuudessa graafisen käyttöliittymän
 * valmistuttua tämäkin luokka laajenee hieman
 * @author vapsolon
 */
public class Main {
    
    /**
     * public static void main. <br>
     * Alustaa ja käynnistää tekstikäyttöliittymän.
     * @param args main-argumentit joita ainakaan tässä vaiheessa ei ole
     */
    public static void main(String[] args){
        //TextInterface t = new TextInterface();
        Application.launch(GraphicalInterface.class,
                "--testing=no");
        //t.run();
    }
    
}
