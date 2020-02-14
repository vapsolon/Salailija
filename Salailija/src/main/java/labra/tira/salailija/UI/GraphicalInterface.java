package labra.tira.salailija.UI;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import labra.tira.salailija.Ciphers.Caesar;
import labra.tira.salailija.Ciphers.ColumnarTransposition;
import labra.tira.salailija.Ciphers.Leet;
import labra.tira.salailija.Ciphers.Morse;
import labra.tira.salailija.Ciphers.PrivateKey;
import labra.tira.salailija.Utils.InputChecker;
import labra.tira.salailija.Utils.ResultBuilder;

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
    //Tuodaan salattavan tiedoston luettu sisältö myös globaaliksi
    private byte[] fileContents;
    //Pidetään myös avatun tiedoston osoite tallessa
    private Path filePath;
    //Tallennetaan viimeisin käyty kansio jotta se voidaan avata uudestaan
    //seuraavaa tiedostoa valittaessa
    private Path lastVisited;
    
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
        //Luodaan privkeyn käyttämä etiketti-nappi -kombinaation alusta
        HBox fileInputBox = new HBox(10);
        
        //Luodaan kaikki tarvittavat etiketit kerralla
        Label inputLabel = new Label("Salattava syöte");
        inputLabel.setStyle("-fx-font-size: 16;");
        Label outputLabel = new Label("Salattu tulos");
        outputLabel.setStyle("-fx-font-size: 16;");
        Label keyLabel = new Label("Salauksessa käytettävä avain");
        keyLabel.setVisible(false);
        keyLabel.setStyle("-fx-font-size: 16;");
        Label rotationLabel = new Label("Salauksessa käytettävä rotaatio");
        rotationLabel.setStyle("-fx-font-size: 16;");
        Label fileLabel = new Label("Salattava tiedosto");
        fileLabel.setStyle("-fx-font-size: 16;");
        
        //Luodaan tiedostovalitsin
        FileChooser inFile = new FileChooser();
        inFile.setTitle("Salattava Tiedosto");
        
        //Luodaan syöte- ja tulostekomponentit
        TextArea input = new TextArea("");
        input.setWrapText(true);
        TextArea output = new TextArea("");
        output.setWrapText(true);
        output.setEditable(false);
        TextField key = new TextField("");
        key.setVisible(false);
        TextField rotation = new TextField("");
        
        //Luodaan napit
        Button cipher = new Button("Salaa");
        cipher.setStyle("-fx-font-size: 16;");
        //Anna napeista pienemmän skaalautua suuremman varaamaan kokoon
        cipher.setMaxWidth(Double.MAX_VALUE);
        Button swap = new Button("<- Vaihda");
        swap.setStyle("-fx-font-size: 16;");
        Button selectFile = new Button("Valitse");
        selectFile.setStyle("-fx-font-size: 16;");
        
        //Luodaan globaalisti näkyvä virheilmoitin
        this.error = new Label("");
        this.error.setAlignment(Pos.CENTER);
        this.error.setTextAlignment(TextAlignment.CENTER);
        this.error.setStyle("-fx-font-size: 16;-fx-background-color: #FF6666;");
        this.error.setMaxWidth(Double.MAX_VALUE);
        this.error.setMaxHeight(Double.MAX_VALUE);
        this.error.setVisible(false);
        
        //Alustetaan privkeyn lisäsyötelaatikko
        fileInputBox.getChildren().add(fileLabel);
        fileInputBox.getChildren().add(selectFile);
        fileInputBox.setVisible(false);
        
        //Lisätään tarvittavat komponentit varsinaiseen syötepohjaan
        inputBox.add(inputLabel, 0, 0);
        inputBox.add(fileInputBox, 0, 0);
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
        
        //Luodaan radionapit salausmenetelmän vaihtamiseen
        RadioButton caesarb = new RadioButton("Caesarian Cipher");
        RadioButton rot13b = new RadioButton("ROT13");
        RadioButton leetb = new RadioButton("1337");
        RadioButton morseb = new RadioButton("Morse");
        RadioButton ctb = new RadioButton("Columnar Transposition");
        RadioButton privkeyb = new RadioButton("Private Key");
        
        //Luodaan napeille ryhmä ja lisätään ne siihen
        ToggleGroup control = new ToggleGroup();
        caesarb.setToggleGroup(control);
        caesarb.setSelected(true);
        rot13b.setToggleGroup(control);
        leetb.setToggleGroup(control);
        morseb.setToggleGroup(control);
        ctb.setToggleGroup(control);
        privkeyb.setToggleGroup(control);
        
        //Ladotaan napit asettelupohjaansa
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
        //Kontrollin vaihto radionapeilla
        EventHandler controlHandler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                if(e.getSource() == caesarb){
                    keyLabel.setVisible(false);
                    key.setVisible(false);
                    rotationLabel.setVisible(true);
                    rotation.setVisible(true);
                    inputLabel.setVisible(true);
                    fileInputBox.setVisible(false);
                    swap.setVisible(true);
                    input.setEditable(true);
                }
                else if(e.getSource() == leetb
                        || e.getSource() == morseb
                        || e.getSource() == rot13b){
                    rotationLabel.setVisible(false);
                    rotation.setVisible(false);
                    keyLabel.setVisible(false);
                    key.setVisible(false);
                    inputLabel.setVisible(true);
                    fileInputBox.setVisible(false);
                    swap.setVisible(true);
                    input.setEditable(true);
                }
                else if(e.getSource() == privkeyb){
                    rotationLabel.setVisible(false);
                    rotation.setVisible(false);
                    keyLabel.setVisible(true);
                    key.setVisible(true);
                    inputLabel.setVisible(false);
                    fileInputBox.setVisible(true);
                    swap.setVisible(false);
                    input.setEditable(false);
                }
                else{
                    rotationLabel.setVisible(false);
                    rotation.setVisible(false);
                    keyLabel.setVisible(true);
                    key.setVisible(true);
                    inputLabel.setVisible(true);
                    fileInputBox.setVisible(false);
                    swap.setVisible(true);
                    input.setEditable(true);
                }
            }
        };
        
        //Salausnapin käsittelijä
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
                    if(fileContents == null){
                        error("Ei salattavaa tiedostoa");
                    }
                    else if(key.getText().length() == 0){
                        error("Ei salauksessa käytettävää avainta");
                    }
                    else{
                        byte[] encryptedData = pk.encrypt(fileContents,
                                key.getText());
                        
                        ResultBuilder rb = new ResultBuilder();
                        for(byte b: encryptedData){
                            rb.appendString(String.format("%02x", b));
                        }
                        output.setText(rb.toString());
                        
                        Path outPath = filePath.resolveSibling(
                                filePath.getFileName() + ".salattu");
                        if(filePath.toString().endsWith(".salattu")){
                            String strPath = filePath.toString();
                            outPath = Paths.get(strPath.substring(
                                    0, strPath.lastIndexOf('.')));
                        }
                        try (OutputStream out = new BufferedOutputStream(
                            Files.newOutputStream(outPath))){
                                out.write(
                                        encryptedData, 0, encryptedData.length);
                        } catch (IOException ex) {
                            error("IOException, varsinainen virhe konsolissa");
                            System.out.println(ex);
                        }
                    }
                }
            }
        };
        
        //Vaihtonapin käsittelijä
        EventHandler switchHandler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                input.setText(output.getText());
                output.setText("");
            }
        };
        
        //Tiedostovalitsinnapin käsittelijä
        EventHandler fileInputHandler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                try {
                    if(lastVisited != null){
                        inFile.setInitialDirectory(lastVisited.toFile());
                    }
                    File in = inFile.showOpenDialog(window);
                    if(in != null){
                        filePath = in.toPath();
                        lastVisited = filePath.getParent();
                        fileContents = Files.readAllBytes(filePath);
                        ResultBuilder rb = new ResultBuilder();
                        for(byte b: fileContents){
                            rb.appendString(String.format("%02x", b));
                        }
                        input.setText(rb.toString());
                    }
                    
                } catch (IOException ex) {
                    error("IOException, varsinainen virhe konsolissa");
                    System.out.println(ex);
                }
            }
        };
        
        //Asetetaan radionapeille käsittelijät
        caesarb.setOnAction(controlHandler);
        rot13b.setOnAction(controlHandler);
        leetb.setOnAction(controlHandler);
        morseb.setOnAction(controlHandler);
        ctb.setOnAction(controlHandler);
        privkeyb.setOnAction(controlHandler);
        
        //Asetetaan varsinaisille napeille käsittelijät
        cipher.setOnAction(buttonHandler);
        swap.setOnAction(switchHandler);
        selectFile.setOnAction(fileInputHandler);
        
        //Lisätään asetelma omalle sivulleen
        TabPane tp = new TabPane();
        Tab cipherTab = new Tab();
        cipherTab.setText("Salaus");
        cipherTab.setContent(base);
        tp.getTabs().add(cipherTab);
        
        //Luodaan vielä varsinainen skene ja asetetaan se ikkunan näkymäksi
        Scene view = new Scene(tp);
        window.setScene(view);
        
        //Lisätään vielä kuvake
        window.getIcons().add(new Image("file:src/main/resources/icon.png"));
        
        //Vihdoin valmis näytettäväksi
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
