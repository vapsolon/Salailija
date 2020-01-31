# Viikkoraportti 2

### Tekemiset
Viimeiset kaksi suunniteltua salausmenetelmää saatiin valmiiksi ja kaikki kielletyt valmiit tietorakenteet on tiettävästi saatu karsittua pois, tästä tosin lisää myöhemmin. Ensimmäisen varsinaisen produktioviikon oppimisprosessin jälkeen testaaminen ja vaadittavat dokumentaatiot kuten **PIT** ja **javadoc** olivat helppoja eivätkä vieneet varsinaista kehitysaikaa juuri ollenkaan. Checkstyle tuli conffattua hyvin karkeasti omaa tyyliä vastaavaan muotoon, jonka ansiosta suuri osa aidosti virheellisistä tyyliseikoistakin saatiin korjattua.

### Edistyminen
Viimeiset kaksi salausta on siis tosiaan saatu toimimaan ja varmasti kielletyt valmiit tietorakenteet on korvattu omilla kehitelmillä. Private Key on todella yksinkertainen mutta Columnar Transposition on vielä tässä vaiheessa hieman __ongelmallinen__ eikä noudata tarkkaan salauksen varsinaista standardimääritelmää. Tähän toivottavasti heti ensi viikolla paikkaus, mutta nykyisessä muodossa mukaan laitettu versio on kuitenkin täysin toimiva omalla tavallaan, vaikkei vastaakaan netistä löytyvien todellisten 1:1 toteutuksien tarjoamaa tulosta.

Dokumentaatio on myös lähtenyt rullaamaan paljon sujuvammin nyt kun kaikki on tuttua ja raportit saa aikaan yhdellä napilla joka löytyy juuri sieltä mistä pitääkin.

Aikaa käytettiin kokonaisuudessaan noin 12 tuntia.

### Oppimiset
Checkstylen config oli hieman hankala löytää mutta lopulta omat tyylitottumukset saatiin pakotettua perussäännöstön sekaan. Private Keyn suhteen oli varattu paljon enemmän aikaa, mutta toteutus olikin yllättävän helppo ja ainoa uusi asia oli löytää Javan XOR. Omatekoisiin tietorakenteisiin ja muutamaan algoritmiin haettiin inspiraatiota omista vanhoista TiRa-palautuksista joten vaikka varsinaista uutta ei tässäkään opittu, ainakin vanhaa tuli tehokkaasti kerrattua.

### Epäselvät
Omien tietorakenteiden luomisen jälkeen jäi muutama kysymys vielä käytössä olevista Javan valmiista apuvälineistä:

* Useassa salauksessa on käytössä StringBuilder johon sitten lisätään merkki kerrallaan salattua tietoa. Onko Javan oma rakenne OK vai kannattaako vaihtaa lisäämään merkkejä tavallisen merkkijonon perään?
* Tällä hetkellä Quicksortin ainoassa omassa testissä on käytössä Arrays.equals() jonka toiminnallisuudelle saattaa olla käyttöä myös tulevaisuudessa. Onko equals() sallittu vai kannattaako esim. Arrays.sort():n tapaan tehdä oma toteutus?

### Seuraavaksi
Columnar Transposition ja Caesar kaipaavat hieman parannuksia joten nämä etualalle. Jos vielä käytössä olevat Javan apukeinot eivät mene läpi niin niiden toiminnallisuuden oma toteutus on myös korkealla prioriteetilla. Näiden jälkeen tärkein on varmaan GUI, varsinkin Private Keyn mukanaan tuoman tekstikäyttöliittymän rajoittuneisuuden takia. Kaikki mahdolliset merkit tulisi saada näkyviin jotta viesti saadaan myös purettua, joten GUI ennen salausten purkamistoiminnallisuutta vaikuttaa oikealta ratkaisulta.