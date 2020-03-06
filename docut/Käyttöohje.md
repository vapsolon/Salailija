# Salailija - Käyttöohje

Githubissa pitäisi olla release joka vastaa projektin lopullista palautusta. Käynnistys ei vaadi mitään erityistä ja ohjelman tulisi lähteä käyntiin tuosta vain. Linuxilla tosin OpenJDK-asennukset vaativat ilmeisesti myös OpenJFX-paketin jotta .jar lähtee käyntiin. Käyttöliittymä on graafinen joten näiltä osin kaiken pitäisi olla jokseenkin selvää. Salausmenetelmän vaihto tapahtuu ikkunan pohjalla olevan radionappiryhmän avulla ja valitun napin vaihtuessa myös näkyvissä olevat syöte-elementit vaihtuvat kyseisen salauksen vaatimusten mukaan. Eri salausten vaatimat erikoisuudet on selitetty tarkemmin alla.

### Salaukset

* **Caesarian Cipher**: 
    * Syöte voi olla mitä tahansa, tosin toteutus salaa tällä hetkellä ainoastaan amerikkalaistyylisesti kirjaimet A-Z ja a-z. Rotaatio on numero väliltä 0-26, ohjelma valittaa hyvin näkyvästi jos rotaatio on virheellinen
    * Tuloste on salattu tulos. Salauksen purkaminen tapahtuu salaamalla tuloste rotaatiolla (26-<alkuperäinen rotaatio>)
* **ROT13**
    * Keisarilaisen erikoistapaus. Syöte voi samoin olla mitä tahansa, mutta ainoastaan A-Z, a-z salataan. Rotaatio on lukittu arvoon 13 joten tietoa ei tällä kertaa kysytä
    * Tuloste on salattu tulos. Salauksen purkaminen tapahtuu salaamalla tuloste uudestaan
* **1337**
    * Syöte voi olla mitä tahansa, mutta vain 1337-yhteensopivat merkit salataan. Salaus on sanakirjapohjainen, joten rotaatiota tai avainta ei kysytä
    * Tuloste on salattu tulos. Purkaminen ei onnistu automaattisesti (vielä)
* **Morse**
    * Syöte voi olla mitä tahansa, mutta vain A-Z, a-z, 0-9 salataan tavallisen Morse-aakoston mukaisesti. Salaus on sanakirjapohjainen, joten rotaatiota tai avainta ei kysytä
    * Tuloste on salattu tulos. Purkaminen ei onnistu automaattisesti (vielä)
* **Columnar Transposition**
    * Syöte voi olla mitä tahansa, tällä kertaa ilman tunnettuja rajoitteita. Avain voi samoin olla käytännössä mitä tahansa sillä sisäisesti ainoa merkityksellinen osa on avaimen merkkien "aakkosjärjestys". Salausta on kuitenkin testattu vain länsimaisella aakkostolla, eksoottisemmat variaatiot siis omalla riskillä
    * Tuloste on salattu tulos. Tällä hetkellä purkaminen onnistuu salaamalla tulosteen uudestaan tarpeeksi monta kertaa
* **Private Key**
    * Syöte on tiedosto joka valitaan ohjelman yläosaan ilmestyvällä napilla. Mikä tahansa tiedosto kelpaa, tosin tyypilliset käyttäjäoikeusrajoitteet pätevät ja salatun tiedoston kirjoittaminen levylle saattaa estyä jos käyttäjällä ei ole tarvittavia oikeuksia kyseiseen kansioon
    * Tuloste on salattu tulos. Varsinainen tuloste on vain muodon vuoksi, ohjelma luo lisäksi salatun tiedoston syötetiedoston kansioon nimellä **<alkuperäinen tiedosto>.salattu**. Salauksen purku onnistuu valitsemalla tämä **.salattu**-tiedosto ja salaamalla se uudestaan samalla avaimella. **HUOM: .salattu-päätteisen tiedoston salaaminen kirjoittaa tuloksen alkuperäiseen tiedostoon, eli siis ilman .salattu-päätettä. Ota kopioita ennen kuin salaat mitään kovin tärkeää**
    
### Frekvenssianalyysi

* Syöte voi olla mitä tahansa eikä testaamisessa ole tullut vastaan mitään kiellettyjä merkkejä. Pohjimmillaan tarkoitus on antaa syötteenä esimerkiksi Caesar-salauksen antamia salattuja tuloksia, mutta mikä tahansa lähde kelpaa.
* Tuloste on lista syötteessä esiintyneistä merkeistä järjestettynä niiden esiintymismäärän perusteella suurimmasta pienimpään.

### Suorituskykytestaaminen

* Suorituskykytestien ajamiseen on myös mahdollisuus. Testit voidaan ajaa antamalla ohjelmalle argumenttina merkkijono "performance", eli siis kutsumalla "java -jar Salailija.jar performance"