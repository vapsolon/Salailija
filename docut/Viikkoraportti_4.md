# Viikkoraportti 4

### Tekemiset
Viikko vierähti sittenkin käyttöliittymäpäivityksen parissa. Uusi graafinen look rakentui pala palalta kun eri komponenttien ja asetelmien omia pikku erikoisuuksia tuli muisteltua Oraclen omien docsien avulla. Muutama oma tietorakenne tuli myös toteutettua, tärkeimpinä **ResultBuilder** korvaamaan Javan **StringBuilderin** ja **CharArray** korvaamaan **String.toCharArray()** -toiminnallisuuden. Private keyn kanssa huomattiin ikävä ongelma, tavallisia aakkosia käyttävällä avaimella on suuri todennäköisyys salautua kontrollimerkkialueelle, jolloin salattu viesti menettää helposti dataa. Tätä yritettiin paikata useaan otteeseen, mutta lopullinen päätös oli palauttaa luokka alkuperäiseen kuntoonsa ja katsoa tarkemmin ensi viikolla onko tekstin privkey-salaaminen vaivan arvoista vai kannattaako salausmenetelmä rajata täysin tiedostosalaamiseksi, jolloin kaikki käsiteltävä data olisikin binäärimuotoista eikä käyttökelvottomille alueille salautumisesta tarvitsisi huolehtia.

### Edistyminen
GUI on tosiaan nykyiselle salaustoiminnallisuudelle täysin valmis. Menetelmää voi vaihtaa helpon kontrollinappiryhmän avulla ja kaikki salaukset toimivat ainakin oman testauksen perusteella. Samoin edellä mainitut kaksi uutta luokkaa **ResultBuilder** ja **CharArray** toimivat odotetusti ja ovat korvanneet vastaavat Javan omat toiminnallisuudet täysin. Kolmas uusi luokka, **InputCheker** on myös saatu osaksi ohjelmaa, tosin tällä hetkellä se vain tarkistaa Caesarin saamaa rotaatiosyötettä kirjainmerkkien varalta. Luokka tulee kuitenkin todennäköisesti laajenemaan huomattavasti, sillä suunnitelmissa on sisällyttää kaikkien salausmenetelmien syötetarkistukset juuri tänne.

Aikaa käytettiin kokonaisuudessaan noin 10 tuntia.

### Oppimiset
Vaikka OhJa sisälsikin jonkin verran GUI-tehtävia, oli asiassa paljon kertaamista. Yksi melkein täysin uusi oppiminen oli tapahtumakäsittelijöiden erottaminen ainakin omiksi olioikseen suoraan komponentin onAction()-metodin sisälle kirjoittamisen sijasta. Tästä oli suuri apu radionappien käsittelemisessä yhden ainoan käsittelijän avulla kuuden sijasta, mutta ilmankin tätä copy-pasten säästämistä olisin halunnut kirjoittaa käsittelijät erikseen siisteyden vuoksi. Lisäksi nyt aukesi mahdollisuus sijoittaa käsittelijät ja niiden liittäminen komponentteihinsa omaan funktioonsa start():n ulkopuolelle yhä enemmän siistimään luokkaa.

### Epäselvät
GUI toi mukanaan yhden suuren epäselvyyden:

* Kuuluuko GUI-testaaminen kurssin vaatimuksiin? Joissain OhJan graafisissa tehtävissä oli muistaakseni testit ja jonkinlaista kursori- ja syöteautomaatiota joten inspiraatiota olisi mahdollista hakea noiden palautusten testeistä, mutta onko tämä tarpeellista?

### Seuraavaksi
Nyt tosiaan ne pitkään esillä olleet salausparannukset. Tärkeimmäksi nousee ehdottomasti **Private Key**, joka pitäisi joko saada tukemaan tavallisia aakkosia sisältäviä avaimia. Suunnitteilla on myös alusta asti ollut käyttää privkeytä myös tiedostosalaamiseen, jopa ensisijaisella tarkoituksella, joten pahimmassa tapauksessa saatetaan joutua pudottamaan privkey tekstisalauksista ja rajata se täysin tiedostopohjaiseksi.

Myös **Caesar** ja **CT** sisältävät parannusmahdollisuuksia alunperin suunnitellun toiminnallisuuden ulkopuolelle. **InputCheker** tulee varmasti myös laajenemaan seuraavaan versioon nyt kun luokka on olemassa ja graafinen käyttöliittymä ei listaa syötemuotoilukehotuksia missään. Tiedostosalaamiseen voisi suorittaa myös jonkin muun menetelmän kuin vain **Private Key**, mutta tulevalle viikolle tämä on taka-alalla ja jo olemassa olevien menetelmien parantaminen on prioriteetti.