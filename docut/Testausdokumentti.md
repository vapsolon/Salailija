# Salailija - Testausdokumentti

### Yksikkötestaus
Lähes kaikki ohjelman luokat on yksikkötestattu kattavasti. Ainoat poikkeukset ovat **GraphicalInterface** GUI-testaamisen hankaluuden takia ja **TestPerformance** joka on osa testikattavuutta eli sen testaaminen on turhaa.

Projektissa on käytössä **PIT**, ja sen tuottamiin raportteihin on linkki repon juurssa. Testikattavuus on pitkään ollut 90+%-luokkaa.

Salausmenetelmien testaamisessa on keskitytty pitkälti salatun tuloksen oikeellisuuteen. Testattavalla menetelmällä salataan testisyöte joka on helppo salata käsin, ja saatua tulosta verrataan käsin salattuun tulokseen. Joissain tapauksissa testisyöte ensin salataan ja sitten puretaan salaamalla ensimmäisen salauksen tulos uudestaan, jolloin syklisissä salauksissa pitäisi päätyä alkuperäisviestiin.

Tietorakenteiden ja apuluokkien testaamisessa on samoin keskitytty niiden tuottamien tulosten oikeellisuuteen. Salausmenetelmien testaus toimii joissain määrin niiden käyttämien apuluokkien testaamisena, sillä virhe apuluokassa aiheuttaa virheen myös salauksessa, mutta tämän sivuvaikutustestaamisen lisäksi joitain perustoiminnallisuuksia on testattu, varsinkin jos **PIT**-raporttien mukaan testikattavuus tai mutaatioeliminaatiot joidenkin luokkien kohdalla eivät ole olleet pelkkien sivuvaikutusten jälkeen tarpeeksi laajat.

### Suorituskykytestaus
Suorituskykytestaus on toteutettu erilliseen **TestPerformance**-luokkaan **Utils**-pakettiin. Suorituskykytestejä ei normaalitilanteessa ajeta, ja tällä hetkellä niiden ajamiseksi **Main**-luokassa täytyy tehdä muutama muutos jotta käyttöliittymän sijaan ajetaankin testit.

Tällä hetkellä ainoastaan salausmenetelmien suorituskykyä testataan, sillä täten koko ohjelman tehokkuudesta saadaan hyvä kuva. Apuluokkien kuten **Quicksort** testaaminen on harkinnan alla.

Testisyöte on kaikille salausmenetelmille sama. Ennen testien ajamista testiluokka alustaa kuusi erimittaista merkkijonoa jotka luodaan tunnetulla satunnaislukugeneraattorilla, joten merkkijonot pysyvät samana ohjelman jokaisella ajokerralla. Merkkijonojen pituudet ovat 10, 100, 1000, 10000, 100000, 1000000. Jokainen salausmenetelmä ajetaan jokaisella merkkijonolla kaksi kertaa kuten testausohjeessa kehotettiin, mutta ensimmäisen ajon tulos pidetään mukana ainakin vielä kiinnostavana vertailukohteena.

Alla vielä nopeasti yksittäisen testiajon antamat tulokset:

```Testing Caesar with length 10: Execution time 4.012E-4 s
Testing Caesar with length 10: Execution time 4.0E-6 s
Testing Caesar with length 100: Execution time 1.75E-5 s
Testing Caesar with length 100: Execution time 2.08E-5 s
Testing Caesar with length 1000: Execution time 1.54E-4 s
Testing Caesar with length 1000: Execution time 1.448E-4 s
Testing Caesar with length 10000: Execution time 0.0014348 s
Testing Caesar with length 10000: Execution time 0.0014555 s
Testing Caesar with length 100000: Execution time 0.0080611 s
Testing Caesar with length 100000: Execution time 0.002013 s
Testing Caesar with length 1000000: Execution time 0.010637 s
Testing Caesar with length 1000000: Execution time 0.010261 s

Testing Leet with length 10: Execution time 9.25E-5 s
Testing Leet with length 10: Execution time 7.5E-6 s
Testing Leet with length 100: Execution time 6.26E-5 s
Testing Leet with length 100: Execution time 7.05E-5 s
Testing Leet with length 1000: Execution time 3.642E-4 s
Testing Leet with length 1000: Execution time 2.437E-4 s
Testing Leet with length 10000: Execution time 0.0013459 s
Testing Leet with length 10000: Execution time 0.0014204 s
Testing Leet with length 100000: Execution time 0.0083703 s
Testing Leet with length 100000: Execution time 0.003565 s
Testing Leet with length 1000000: Execution time 0.0173675 s
Testing Leet with length 1000000: Execution time 0.0212327 s

Testing Morse with length 10: Execution time 7.16E-5 s
Testing Morse with length 10: Execution time 6.5E-6 s
Testing Morse with length 100: Execution time 6.19E-5 s
Testing Morse with length 100: Execution time 5.93E-5 s
Testing Morse with length 1000: Execution time 4.582E-4 s
Testing Morse with length 1000: Execution time 2.467E-4 s
Testing Morse with length 10000: Execution time 0.0017026 s
Testing Morse with length 10000: Execution time 0.0024118 s
Testing Morse with length 100000: Execution time 0.0112583 s
Testing Morse with length 100000: Execution time 0.0067034 s
Testing Morse with length 1000000: Execution time 0.0663179 s
Testing Morse with length 1000000: Execution time 0.0543341 s

Testing Columnar Transposition with length 10: Execution time 0.0023325 s
Testing Columnar Transposition with length 10: Execution time 3.6E-5 s
Testing Columnar Transposition with length 100: Execution time 4.41E-5 s
Testing Columnar Transposition with length 100: Execution time 6.5E-5 s
Testing Columnar Transposition with length 1000: Execution time 1.213E-4 s
Testing Columnar Transposition with length 1000: Execution time 1.3E-4 s
Testing Columnar Transposition with length 10000: Execution time 9.763E-4 s
Testing Columnar Transposition with length 10000: Execution time 0.0010385 s
Testing Columnar Transposition with length 100000: Execution time 0.0043134 s
Testing Columnar Transposition with length 100000: Execution time 0.0018237 s
Testing Columnar Transposition with length 1000000: Execution time 0.0129329 s
Testing Columnar Transposition with length 1000000: Execution time 0.0086657 s

Testing Private Key with length 10: Execution time 7.7E-6 s
Testing Private Key with length 10: Execution time 2.1E-6 s
Testing Private Key with length 100: Execution time 4.6E-6 s
Testing Private Key with length 100: Execution time 5.1E-6 s
Testing Private Key with length 1000: Execution time 3.94E-5 s
Testing Private Key with length 1000: Execution time 4.35E-5 s
Testing Private Key with length 10000: Execution time 3.832E-4 s
Testing Private Key with length 10000: Execution time 4.5E-4 s
Testing Private Key with length 100000: Execution time 0.0022075 s
Testing Private Key with length 100000: Execution time 4.296E-4 s
Testing Private Key with length 1000000: Execution time 0.003257 s
Testing Private Key with length 1000000: Execution time 0.0018663 s
```