# Salailija - Toteutusdokumentti

### Yleisrakenne
Ohjelma on eritelty neljään eri pakettiin. Salausmenetelmät, muutama niitä tukeva varsinainen tietorakenne, käyttöliittymä ja yleiskäyttöiset apuluokat ovat kaikki erillään. Lisäksi **Main**-luokka sijaitsee pakettirakenteen juuressa.

### Ciphers
Sisältää ohjelman tukemat salausmenetelmät.

##### Caesarian Cipher
Yksinkertainen merkkisiirtymäsalaus, ottaa vastaan syötteenä salattavan merkkijonon sekä salauksessa käytettävän rotaation määrän ja siirtää sitten jokaista merkkijonon merkkiä aakkostossa eteenpäin rotaation verran, loopaten tarvittaessa takaisin aakkoston alkuun. Jos salattavaksi annettu merkki ei kuulu tuettuun aakkostoon sille ei tehdä mitään.

Salausalgoritmi on hyvin yksinkertainen. Merkkijono pilkotaan ensin yksittäisiksi merkeiksi jotka käydään sitten yksi kerrallaan läpi. Jos merkki on salattavissa olevalla alueella, sen numeeriseen arvoon yritetään lisätä rotaation määrä. Jos saatu salattu arvo vuotaa yli salattavan alueen ylärajasta merkin arvo siirretään takaisin alueen alkuun ja ylijäämä lisätään tähän pohja-arvoon.

Sama luokka toimii myös erikoistapauksen **ROT13** salaajana vakiorotaatiolla 13.

##### Leet ja Morse
Molemmat sanakirjasalauksia joissa tietty merkki vaihdetaan vastaavaan merkkiin tai merkkijonoon salausaakkostossa. Jos salattavalle merkille ei löydy käännöstä salauksen omassa aakkostossa sille ei tehdä mitään.

Salausalgoritmi on vielä keisarilaistakin yksinkertaisempi. Pilkotun merkkijonon merkit käydään läpi yksi kerrallaan ja algoritmi tarkistaa löytyykö merkille käännöstä käännöksen sanakirjassa. Merkki salataan jos sille löytyy käännös, mutten se palautetaan sellaisenaan.

##### Columnar Transposition
Hieman haastavampi sekoitussalaus. Ottaa vastaan salattavan merkkijonon ja salauksess käytettävän avaimen jonka perusteella syöte salataan. Tukee periaatteessa mitä tahansa merkkejä sekä syötteessä että avaimessa sillä ainoa merkittävä tekijä on avaimen merkkien aakkosjärjestys niiden numeeristen arvojen perusteella.

Algoritmi on myös aiempia paljon monimutkaisempi. Ensin avaimen sisäinen aakkosjärjestys selvitetään ja salattava syöte pilkotaan avaimen mittaisiin riveihin. Avaimen aakkosjärjestyksen perusteella pilkotun syötteen sarakkeille annetaan järjestysnumerot. Nämä sarakkeeet asetellaan sitten uusien järjestysnumeroidensa perusteella uuteen järjestykseen ja lopulta riveistä mudostetaan lopullinen kokonainen salattu merkkijono.

##### Private Key
Pohjimmiltaan hyvin yksinkertainen tiedostosalausmenetelmä ja samalla tämän ohjelman ehdottomasti turvallisin salaus. Itse algoritmi ottaa vastaan listan tavuja ja salauksessa käytettävän merkkijonoavaimen, mutta varsinaisessa käytössä graafisen käyttöliittymän yhteydessä tarkoitus on ottaa syötteenä tiedosto ja kirjoittaa salattu tulos uuteen tiedostoon.

Algoritmi on hyvin yksinkertainen. Merkkijonona saatu avain muutetaan ensin tavulistaksi kuten syötekin. Syöte käydään sitten läpi tavu kerrallaan ja jokainen tavu XOR:taan avaimen sillä hetkellä käytössä olevalla tavulla.

### Structures
Sisältää kaksi välikappaletta jotka kommunikoivat sanakirjasalausten ja varsinaisen sanakirjaluokan välillä.

##### LeetDict ja MorseDict
Sanakirjat Leet- ja Morse-salauksille. Tallentavat ensin kovakoodatun listan aakkosia ja niiden käännöksiä vielä erikseen toteutettuun sanakirjaluokkaan ja tarjoavat sitten mahdollisuuden kääntää annetun merkin jos se löytyy tuetusta aakkostosta.

### UI
Sisältää ohjelman käyttöliittymän.

##### GraphicalInterface
Hieman mittavaksi kasvanut graafinen käyttöliittymä. Tarjoaa mahdollisuuden salata tekstiä tai tiedostoja tuetuilla salausmenetelmillä ja myös suorittaa frekvenssianalyysin. itse toteutuksessa ei ole juuri mitään erikoista, ainoastaan pitkä liuta komponenttien luomista ja asettelua, joskus muutama tapahtumakäsittelijä, joten jätetään tarkempi analyysi tekemättä.

### Utils
Sisältää loput yleishyödylliset apuluokat ja kaiken mitä ei suoraan voitu laittaa itse salausmenetelmäluokkiin. Selitetään tässä ainoastaan tärkeimmät, muissa javadocsit kertovat tarpeeksi.

##### Quicksort ja CharArraySort
Quicksortissa on tavallinen Quicksort-toteutus, ei mitään kovin erikoista. CharArraySort on täysin sama toiminnallisuus mutta sitä on jouduttu erikoistuttamaan jotta varsinainen toiminnallisuus merkkijonon kolumnien listaamisesta merkkijonon merkkien aakkosjärjestyksen perusteella saadaan toteutettua.

##### TestPerformance
Suorituskykytestausluokka. Selitetty hieman tarkemmin testausdokumentissa, mutta luo tosiaan eri mittaisia testisyötteitä tunnetulla satunnaislukugeneraattorilla ja merkkijonongeneroimisfunktiolla ja salaa sitten nämä merkkijonot kaikilla tuetuilla salausmenetelmillä.