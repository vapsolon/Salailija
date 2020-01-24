# Viikkoraportti 2

### Tekemiset
Kakkosviikolla varsinainen produktio alkoi. Ensimmäiset (ja helpoimmat) neljä salausmenetelmää on pääpiirteittäin toteutettu, vaikkakin joitakin ominaisuuksia kuten ääkkösiä joudutaan odottamaan jonkin aikaa jotta muut salaukset saadaan valmiiksi.

Myös **javadoc**, **testaaminen**, **testikattavuus** ja muu hauska on lähtenyt pienten alkuongelmien jälkeen rullaamaan, vaikkakin checkstylen kanssa on muutamia erimielisyyksiä aaltosulkeiden sijaintien kanssa. Samoin **Maven** ja ehkä jopa itse **Netbeans** ovat tulleet tutummiksi, aiemmin ei ole tarvinnut näin hienoa teknologiaa käyttää kun tuotettua koodia ei ole kukaan muu lukenut.

### Edistyminen
Neljä helpointa salausmenetelmää on saanut toimintakuntoon, osaan tosin tulee vielä lisätoiminnallisuutta kunhan puuttuvat ainakin kaksi salausta saadaan samoin toimintakelpoisiksi. Jokaiselle ominaisuudelle on myös oma testiluokkansa ja muutama testi jotka näyttävät kattavan kaiken tärkeän, tästä tosin hieman myöhemmin.

Aikaa käytettiin kokonaisuudessaan noin 10 tuntia.

### Oppimiset
**Maven** ja ensimmäisenä kurssin dokumentaatiotyökaluista ajettu **PIT** olivat melkoista oppimista, mutta lopulta oikea nappi löytyi ja tämän ansiosta lopulta **checkstyle** ja **javadoc** taas olivat hyvinkin helppoja lisätä projektiin ja ajaa. Kaikki kolme olivat myös toiminnallisuudeltaa täysin uutta, joten viikon suurimmat oppimiset tulivat tällä alalla. Testaaminen oli jo ohjelmoinnin perus- ja jatkokursseilta tuttua mutta tulipa kerrattua.

### Epäselvät
Testaamisesta jäi mutaatiotestaamisen jälkeen muutama epäselvä kohta:

* Tarvitseeko ohjelman sanakirjaluokkia testata erikseen vaikka itse kääntäjien testit kattavatkin myös sanakirjaluokat kokonaan? Sanakirjojen testiluokat olisivat vain sanakirjan itsensä testaamista syöttämällä merkin ja katsomalla kääntyykö se oikein, eli sinällään hyvin helppoa kopioida vastaavista käännösluokista, mutta olisiko tämä täysin turhaa ja ylimääräistä koodia?
* Caesar-luokassa mutaatiotestaaminen tuottaa muutaman kohdan joissa mutaatiot jäävät henkiin tarkistettaessa onko kirjain iso vai pieni. Mitenköhän nämä mutaatiot saataisiin pois, vai tarvitseeko itse tarkistusta muuttaa?
* Checkstyle ei tykkää aaltosulkeiden tyylistä, vaikka erot ovat hyvin minimaalisia (ei välilyöntiä välissä ){, } eri rivillä jne). Tarvitseeko tyyliä muuttaa vai voiko checkstylen vain käydä conffaamassa pitämään huolen omista asioistaan ja keskittymään oikeasti merkittäviin tyylirikoksiin?

### Seuraavaksi
Viimeiset kaksi suunniteltua salausta olisi tarkoitus toteuttaa, jonka jälkeen voidaan keskittyä kaikkien kuuden toiminnallisuuden parantamiseen ja mahdollisen lisätoiminnaliisuuden suunnittelemiseen ja toteuttamiseen. Jos salaukset saadaan kaikki kuntoon ennen seuraavaa palautusta seuraavana tärkeysjärjestyksessä on omien tietorakenteiden toteutus HashMapin tilalle sanakirjoissa. Näiden parissa luulisi viikon taas vierähtävän.