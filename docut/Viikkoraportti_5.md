# Viikkoraportti 5

### Tekemiset
Viikko oli vertaisarviopainotteinen. Arvioon meni odotettua paljon enemmän aikaa, mutta ainakin tulos on laaja ja toivottavasti siitä on jotain hyötyäkin. Ohjelmistopuolellekin ehti jonkin verran tapahtua, pääasiassa **PrivateKeyn** kanssa vääntämistä ja GUI:n pientä laajentamista tulevaisuutta varten. Käyttöhje on nyt myös hieman paremmass muodossa.

### Edistyminen
Suurin edistyminen oli **PrivateKeyn** muuntaminen puhtaasti tiedostopohjaiseksi. Vanha tekstisalausmenetelmä on vielä luokassa tallella kaiken varalta jos vaikka se tekisi vielä paluun, mutta ainakin yksi versio salauksesta toimii täydellisesti.

Tiedostosalaus toi mukanaan myös muutamia pieniä lisäyksiä apuluokkiin ja tietorakenteisiin jotta tavuja saadaan käsiteltyä helposti. GUI laajeni myös jonkin verran ja tapahtumakäsittelijät jatkavat rajatonta kasvuaan odotellessaan siirtymistä täysin omiin luokkiinsa pois jo valmiiksi täyteen tungetusta käynnistysmetodista.

Aikaa ohjelmistopuolella käytettiin kokonaisuudessaan noin 5 tuntia, vertaisarvioinnissa vähintään saman verran.

### Oppimiset
Viimeisestä Javalla tehdystä tiedostonkäsittelysovelluksesta oli kulunut aikaa, joten näiden muistelu ja nykyisen standardin etsiminen olivat käytännössä uuden oppimista. Samoin vertaisarviointi pakotti lukemaan jonkun muun kirjoittamaa koodia joten ohjelman rakenteen ja flown seuraamista tuli kanssa opittua ainakin hieman.

### Epäselvät
Tällä viikolla ei mitään.

### Seuraavaksi
**PrivateKey** on nyt valmis, mutta muiden salausten laajentaminen on ollut tällä listalla viikosta 2 alkaen jatkuvasti. Ehkä tällä viikolla viimein. Toinen vaihtoehto on analyysi- ja purkutoiminnallisuuden suorittaminen, varsinkin sanakirjapohjaiset **1337** ja **Morse** tarvitsevat vielä automaattisen käännöksen takaisin selkokielelle, samoin **Caesarin** ja ehkä **PrivateKeyn** frekvenssianalyysi voisi olla kiinnostava lisä.