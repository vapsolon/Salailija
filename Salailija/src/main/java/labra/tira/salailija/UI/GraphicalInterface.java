package labra.tira.salailija.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import labra.tira.salailija.Ciphers.Caesar;
import labra.tira.salailija.Ciphers.ColumnarTransposition;
import labra.tira.salailija.Ciphers.Leet;
import labra.tira.salailija.Ciphers.Morse;
import labra.tira.salailija.Ciphers.PrivateKey;
import labra.tira.salailija.Utils.InputChecker;

/**
 * Kauan odotettu graafinen käyttöliittymä. <br>
 * Tällä hetkellä kevyimmässä muodossaan, kuitenkin hyvin toiminnallinen ja 
 * jopa käyttövalmis. Syöte ja tuloste ovat omissa tekstialueissaan ja 
 * kontrollien avulla voi vaihtaa salausmenetelmää. Kontrollit myös näyttävät
 * ja piilottavat lisätietoja kyselevät kentät tarpeen mukaan. <br>
 * Laajenee varmaan vielä huomattavasti ainakin suunnitellun
 * purkamistoiminnallisuuden myötä, lisäksi tarkoitus on rajoittaa Private Key
 * puhtaasti tiedostosalaamismenetelmäksi joten näiltäkin osin laajenemista
 * tulossa.
 * @author vapsolon
 */
public class GraphicalInterface extends Application {
    
    private Caesar c;
    private Leet leet;
    private Morse morse;
    private ColumnarTransposition ct;
    private PrivateKey pk;
    private InputChecker ic;
    //error on globaali jotta salausluokat voivat helposti kommunikoida
    //käyttöliittymän kanssa
    private Label error;
    //Pidetään kirjaa virhetilasta. 0 Jos virhettä ei ole tapahtunut, 1 jos on
    private int errorState = 0;
    //Vermistetaan myös että luokka on tietoinen jos sitä testataan
    private boolean testing = false;
    
    /**
     * Tyhjä konstruktori normaalikäyttöön.
     */
    public GraphicalInterface(){
        this(false);
    }
    
    /**
     * Parametrillinen konstruktori testaamisen takia. Ottaa vastaan tiedon
     * siitä, että luokkaa testataan, ja osaa tämän perusteella olla lähtemättä
     * käyntiin ja sallii silti UI:n kanssa kommunikoivien luokkien helpon
     * testaamisen.
     * @param test Testataanko luokkaa, true jos olion on luonut testiluokka,
     * false muuten.
     */
    public GraphicalInterface(boolean test){
        this.c = new Caesar(this);
        this.leet = new Leet();
        this.morse = new Morse();
        this.ct = new ColumnarTransposition();
        this.pk = new PrivateKey();
        this.ic = new InputChecker();
        this.testing = test;
    }
    
    @Override
    public final void start(Stage window){
        window.setTitle("Salailija");
        
        //Luodaan pohja-asettelu
        BorderPane base = new BorderPane();
        base.setPadding(new Insets(10, 10, 10, 10));
        //Luodaan keskelle syötteen ja tulosteen sisältävä asettelu
        GridPane inputBox = new GridPane();
        inputBox.setHgap(10);
        inputBox.setVgap(10);
        //Luodaan salausmenetelmävaihtajan asettelu
        HBox controlBox = new HBox(10);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setPadding(new Insets(20, 0, 0, 0));
        
        //Ladotaan inputBox täyteen komponentteja
        Label inputLabel = new Label("Salattava syöte");
        inputLabel.setStyle("-fx-font-size: 16;");
        Label outputLabel = new Label("Salattu tulos");
        outputLabel.setStyle("-fx-font-size: 16;");
        Label keyLabel = new Label("Salauksessa käytettävä avain");
        keyLabel.setVisible(false);
        keyLabel.setStyle("-fx-font-size: 16;");
        Label rotationLabel = new Label("Salauksessa käytettävä rotaatio");
        rotationLabel.setStyle("-fx-font-size: 16;");
        
        TextArea input = new TextArea("");
        TextArea output = new TextArea("");
        output.setEditable(false);
        TextField key = new TextField("");
        key.setVisible(false);
        TextField rotation = new TextField("");
        
        Button cipher = new Button("Salaa");
        cipher.setStyle("-fx-font-size: 16;");
        //Anna napeista pienemmän skaalautua suuremman varaamaan kokoon
        cipher.setMaxWidth(Double.MAX_VALUE);
        Button swap = new Button("<- Vaihda");
        swap.setStyle("-fx-font-size: 16;");
        
        this.error = new Label("");
        this.error.setAlignment(Pos.CENTER);
        this.error.setTextAlignment(TextAlignment.CENTER);
        this.error.setStyle("-fx-font-size: 16;-fx-background-color: #FF6666;");
        this.error.setMaxWidth(Double.MAX_VALUE);
        this.error.setMaxHeight(Double.MAX_VALUE);
        this.error.setVisible(false);
        
        inputBox.add(inputLabel, 0, 0);
        inputBox.add(input, 0, 1);
        inputBox.add(outputLabel, 2, 0);
        inputBox.add(output, 2, 1);
        inputBox.add(keyLabel, 0, 2);
        inputBox.add(rotationLabel, 0, 2);
        inputBox.add(key, 0, 3);
        inputBox.add(rotation, 0, 3);
        inputBox.add(swap, 1, 4);
        inputBox.add(cipher, 1, 5);
        inputBox.add(error, 0, 4, 1, 2);
        
        //Ladotaan controlBox täyteen komponentteja
        RadioButton caesarb = new RadioButton("Caesarian Cipher");
        RadioButton rot13b = new RadioButton("ROT13");
        RadioButton leetb = new RadioButton("1337");
        RadioButton morseb = new RadioButton("Morse");
        RadioButton ctb = new RadioButton("Columnar Transposition");
        RadioButton privkeyb = new RadioButton("Private Key");
        
        ToggleGroup control = new ToggleGroup();
        caesarb.setToggleGroup(control);
        caesarb.setSelected(true);
        rot13b.setToggleGroup(control);
        leetb.setToggleGroup(control);
        morseb.setToggleGroup(control);
        ctb.setToggleGroup(control);
        privkeyb.setToggleGroup(control);
        
        controlBox.getChildren().add(caesarb);
        controlBox.getChildren().add(rot13b);
        controlBox.getChildren().add(leetb);
        controlBox.getChildren().add(morseb);
        controlBox.getChildren().add(ctb);
        controlBox.getChildren().add(privkeyb);
        
        //Lisätään aliasetelmat pääasetelmaan
        base.setCenter(inputBox);
        base.setBottom(controlBox);
        
        //Luodaan tapahtumakäsittelijät
        EventHandler controlHandler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                if(e.getSource() == caesarb){
                    keyLabel.setVisible(false);
                    key.setVisible(false);
                    rotationLabel.setVisible(true);
                    rotation.setVisible(true);
                }
                else if(e.getSource() == leetb
                        || e.getSource() == morseb
                        || e.getSource() == rot13b){
                    rotationLabel.setVisible(false);
                    rotation.setVisible(false);
                    keyLabel.setVisible(false);
                    key.setVisible(false);
                }
                else{
                    rotationLabel.setVisible(false);
                    rotation.setVisible(false);
                    keyLabel.setVisible(true);
                    key.setVisible(true);
                }
            }
        };
        
        EventHandler buttonHandler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                //Käsitellään ensin virhetilanteesta palaaminen
                if(errorState == 1){
                    errorState = 0;
                    error.setText("");
                    error.setVisible(false);
                }
                
                if(control.getSelectedToggle() == caesarb){
                    if(!ic.isNumeric(rotation.getText())){
                        error("Virheellinen rotaatiomäärä.\nAnnettu rotaatio"
                                + " sisältää ei-numeerisia merkkejä");
                    }
                    else{
                        output.setText(c.cipher(input.getText(),
                                Integer.valueOf(rotation.getText())));
                    }
                }
                else if(control.getSelectedToggle() == rot13b){
                    output.setText(c.cipher(input.getText(), 13));
                }
                else if(control.getSelectedToggle() == leetb){
                    output.setText(leet.translate(input.getText()));
                }
                else if(control.getSelectedToggle() == morseb){
                    output.setText(morse.translate(input.getText()));
                }
                else if(control.getSelectedToggle() == ctb){
                    output.setText(ct.translate(input.getText(),
                            key.getText()));
                }
                else if(control.getSelectedToggle() == privkeyb){
                    output.setText(pk.translate(input.getText(),
                            key.getText()));
                }
            }
        };
        
        EventHandler switchHandler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                input.setText(output.getText());
                output.setText("");
            }
        };
        
        caesarb.setOnAction(controlHandler);
        rot13b.setOnAction(controlHandler);
        leetb.setOnAction(controlHandler);
        morseb.setOnAction(controlHandler);
        ctb.setOnAction(controlHandler);
        privkeyb.setOnAction(controlHandler);
        
        cipher.setOnAction(buttonHandler);
        swap.setOnAction(switchHandler);
        
        Scene view = new Scene(base);
        window.setScene(view);
        window.show();
    }
    
    /**
     * Ulkomaailmalle näkyvissä oleva helppo tapa kommunikoida sattuneet virheet
     * UI:lle. <br>
     * Ottaa vastaan kommunikoivan luokan lähettämän viestin ja asettaa sen
     * virhetekstikentän arvoksi. Tämän jälkeen virhekenttä asetetaan vielä
     * näkyviin ja kerrotaan muulle luokalle sen olevan näkyvissä. Virhe
     * piilotetaan kun käännösnappia painetaan seuraavan kerran.
     * @param message Ruudulla näytettävä virheviesti
     */
    public void error(String message){
        if(!testing){
            this.error.setText(message);
            this.error.setVisible(true);
            this.errorState = 1;
        }
    }
}