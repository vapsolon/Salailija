# Määrittelydokumentti

### Toteutettavat algoritmit ja tietorakenteet
Työssä on tarkoitus toteuttaa sopiva määrä erilaisia salausmenetelmiä (sekä yksinkertaisia että edistyneempiä / nykyaikaisia). Näin suunnitteluvaiheessa toteutettavien toiminnallisuuksien listalla ovat ainakin:

* Suurempi määrä yksinkertaisia salausmenetelmiä
  * **Caesarian Shift**
  * Keisarilaisesta erikoistapauksena **ROT13**
  * **Columnar Transposition**
  * Mahdollisesti muutama kirjoitusjärjestelmä, kuten **Morse** ja **1337**
* Ainakin yksi avainpohjainen salausalgoritmi
  * Voidaan edelleen muokata ottamaan käytettävän avaimen käyttäjältä, käyttämään vain ohjelman tuntemaa avainta tai luomaan uuden avaimen jokaisen salauksen yhteydessä
  * **Symmetrinen avain** ensisijainen helppouden vuoksi, **julkisen avaimen** toteutus ajasta riippuen
* Mahdollisuus purkaa tai analysoida helpoimpia salauksia
  * Ainakin **Caesar** ja **ROT13**

Jotta harjoitustyössä olisi oikeasti työtäkin, tavoitteena on kirjoittaa jokaiseen tapaukseen tarvittavat algoritmit itse, vaikka kaikista löytyykin varmasti monta valmista toteutusta.
Mahdollinen lisä työhön olisi toteuttaa tehokkuusvertailuja itse toteutettujen ja Javan valmiiden tai ulkoisten kirjastojen tarjoamien vastaavien menetelmien välillä.

Tietorakenteiden osalta tärkeintä on tallettaa joidenkin yksinkertaisten menetelmien vaatimat "sanakirjat" tai taulukot, joiden perusteella annettu viesti voidaan kääntää.
Ainakin **Morse** ja **1337** on helppo toteuttaa hajautustaululla, sillä tietty merkki vastaa aina tiettyä merkkiä toisessa järjestelmässä.
**Keisarilainen** ja **ROT13** taas pystytään toteuttamaan kirjainmerkkien numeerisilla esityksillä, joten varsinaista erityistä tietorakennetta ei tarvita.
Myös **symmetrinen avain** on helppoa tallentaa normaaliksi merkkijonoksi, tosin käännöksen aikana tietoa täytyy käsitellä binäärimuodossa.

Työhön on tarkoitus myös toteuttaa graafinen käyttöliittymä.

### Ratkaistavat ongelmat
Tarkoitus on tosiaan tarjota käyttäjälle kohtuullinen määrä erilaisia ja eritasoisia salausmenetelmiä helppokäyttöisen graafisen käyttöliittymän kautta.
Ratkaistava ongelma on tietoturva, vaikkakin suunnitelluista salauksista ainoastaan **symmetrisen avaimen** salausta voidaan pitää missään määrin turvallisena nykyään. Kaikki salaukset ovat kuitenkin joissain määrin käyttökelpoisia, ja vaikkapa kahden henkilön väliseen ei-niin-salaiseen keskusteluun esimerkiksi **ROT13** on hyvin tehokas ja helppokäyttöinen salausmenetelmä joka kuitenkin on vaikea ymmärtää ja murtaa aiheeseen täysin perehtymättömälle.

Algoritmit valittiin käytännössä kiinnostavuuden ja helppouden / vaikeuden perusteella. **Keisarilainen**, **ROT13** ja **Morse**/**1337** ovat kaikki hyvin tunnettuja mutta myös hyvin helppoja toteuttaa, jolloin työstä saa helposti toimivan. Toisaalta itselleni **transpositio** oli vieras ja sen toteuttamisessa on tämän takia ainakin jonkinlainen haaste. Samoin **symmetrisen avaimen** salaus on hyvin tunnettu, mutta mielestäni avainsalauksista helpompi toteuttaa, ja täten ensisijainen valinta.
Aihe antaa myös mahdollisuuden työn lähes rajattomaan laajentamiseen ja parantamiseen. Helpoilla menetelmillä aloittamisen etuna on mahdollisuus käyttää myöhemmässä vaiheessa tarvittaessa paljonkin aikaa esimerkiksi omintakeisen **julkisen avaimen** salauksen tai täysin uuden kotikeittoisen salausmenetelmän kehittämiseen ilman pelkoa täydellisestä epäonnistumisesta.

### Syötteet ja tulosteet
Ohjelma saa kaikissa tapauksissa syötteenä ainakin salattavan viestin tai tiedoston. Tämän lisäksi saatetaan kysyä menetelmäkohtaisia syötteitä, kuten

* **Caesarian Shift**
  * Tarvitaan suoritettavan siirron määrä, nollasyötteen tapauksessa arvotaan
* **ROT13**
  * Ei lisäsyötettä
* **Columnar Transposition**
  * Uusi kolumnijärjestys on mahdollista kysyä syötteenä, nollasyötteen tapauksessa arvotaan
* **Morse**/**1337**
  * Ei lisäsyötettä
* **Symmetrinen Avain**
  * Käytettävä avain voidaan kysyä käyttäjältä suoraan, käyttäjäsyötettä voidaan käyttää avaimen luomisessa tai avain voidaan luoda täysin satunnaisesti syötteen puuttuessa
  
Analyysipuolella tarvitaan samoin analysoitava viesti tai tiedosto. Lisäksi voitaisiin kysyä käyttäjän arvausta käytetystä menetelmästä.

Tuloste on aina salattu viesti tai tiedosto, lisäksi esimerkiksi käytetty siirtymänumero tai avain jotta käyttäjä saa salauksen myös purettua.

### Aikavaatimukset

* **Caesarian Shift**, **ROT13**
  * O(n), yksinkertainen for-loop
* **Morse**/**1337**
  * O(n), for-loop hajautustaululla
* **Columnar Transposition**
  * Tavoitteena O(n^2), pitäisi olla toteutettavissa kahdella for-loopilla
* **Symmetrinen Avain**
  * O(1), avaimen pituus ja sillä salattavien palasten pituus ovat vakio
  
### Lähteet
[rumkin.com](http://rumkin.com/tools/cipher/index.php) - Inspiraatio suurimmalle osalle suunnitelluista algoritmitoteutukista.
