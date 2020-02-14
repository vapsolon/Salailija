# Salailija - Käyttöohje
.jar löytyy **build**-kansiosta ja sen pitäisi olla täysin ajokunnossa ja vastata viikon 4 palautusta. Käynnistys ei vaadi mitään erityistä ja ohjelman tulisi lähteä käyntiin tuosta vain. Käyttöliittymä on graafinen joten näiltä osin kaiken pitäisi olla jokseenkin selvää. Salausmenetelmän vaihto tapahtuu ikkunan pohjalla olevan radionappiryhmän avulla ja valitun napin vaihtuessa myös näkyvissä olevat syöte-elementit vaihtuvat kyseisen salauksen vaatimusten mukaan. Eri salausten vaatimat erikoisuudet on selitetty tarkemmin alla.

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