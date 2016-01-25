INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Fafik', 'Pies');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Stefan', 'Czlowiek');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Ochroniarz', 'Czlowiek');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Andrzej', 'Golab');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Dziecko', 'Czlowiek');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Kucharz', 'Czlowiek');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Lapek', 'Pies');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Zgrywus', 'Lis');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Tymek', 'Wiewiorka');

INSERT INTO Wrogowie
(nazwa_wroga, gatunek)
VALUES ('Mistrzunio', 'Czlowiek');



INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Szef', 1, NULL);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Wabik', 1, 99);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Zwiadowca', 1, 199);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Lizus Tygrysa', 1, 200);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Medyczka', 10, 400);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Silacz', 100, 999);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Doradca', 100, 600);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Prychacz', 2, 700);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Pomoc', 300, 900);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Zaopatrzenie', 1, 99);

INSERT INTO Funkcje
(nazwa_funkcji, min_przydzial_myszy, max_przydzial_myszy)
VALUES ('Snajper', 99, 999);



INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Kozaki', 1, 'Smietniki za restauracja');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Superbanda', 2, 'Park');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Pazurki', 3, 'Osiedle');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Ogoniasci', 4, 'Wybrzeze');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Pogromcy', 5, 'Centrum handlowe');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Niszczyciele', 6, 'Kolo rzeczki');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Nienawistni', 7, 'Schronisko');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Lesne Koty', 8, 'Las');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Tancerze', 9, 'Obwodnica');

INSERT INTO Bandy
(nazwa, nr_bandy, teren)
VALUES ('Smieszki', 10, 'Wies');


INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Tygrys', 'M', '18.01.1993', NULL, NULL, 'Szef');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Maja', 'K', '13.03.1995', 1, 'Tygrys', 'Wabik');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Mops', 'M', '21.05.1997', 1, 'Tygrys', 'Zwiadowca');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Kocur', 'M', '09.09.1997', 5, 'Tygrys', 'Lizus Tygrysa');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Szybka', 'K', '12.12.2000', 2, 'Kocur', 'Medyczka');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Ignacy', 'M', '01.01.2001', 4, 'Kocur', 'Silacz');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Madrala', 'M', '03.03.2003', 3, 'Tygrys', 'Doradca');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Zuch', 'M', '09.11.2004', 7, 'Tygrys', 'Prychacz');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Tosia', 'K', '14.02.2012', 7, 'Zuch', 'Pomoc');

INSERT INTO Koty
(pseudo, plec, data_wstapienia, nr_bandy, pseudo_szefa, nazwa_funkcji_kota)
VALUES ('Marysia', 'K', '01.02.2013', 7, 'Zuch', 'Zaopatrzenie');



INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Mistrzunio', 'Ignacy', 'Zlapal za ogon', 5, '01.01.2002');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Fafik', 'Tygrys', 'Dotkliwie pogryzl', 8, '13.05.2004');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Madrala', 'Kucharz', 'Gonil za kradziez kielbasy', 2, '23.08.2008');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Ochroniarz', 'Kocur', 'Zlapal w siec na ryby', 9, '11.11.2001');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Zgrywus', 'Mops', 'Ukradl szynke', 2, '18.09.2009');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Tymek', 'Tosia', 'Rzucal szyszkami', 4, '13.12.2012');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Andrzej', 'Marysia', 'Sploszyl krolika do zjedzenia', 10, '28.02.2013');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Lapek', 'Tygrys', 'Zaatakowal z nienacka', 7, '01.04.2004');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Fafik', 'Maja', 'Nie pozwolil na kradziez kury', 9, '01.05.2015');

INSERT INTO Incydenty
(nazwa_wroga, pseudo_kota, opis_incydentu, stopien_wrogosci, data_incydentu)
VALUES ('Stefan', 'Marysia', 'Krzyczal za miauczenie', 1, '13.11.2009');



INSERT INTO Lapowki
(nazwa)
VALUES ('Wodka');

INSERT INTO Lapowki
(nazwa)
VALUES ('Pieniadze');

INSERT INTO Lapowki
(nazwa)
VALUES ('Kosci');

INSERT INTO Lapowki
(nazwa)
VALUES ('Samochod');

INSERT INTO Lapowki
(nazwa)
VALUES ('Whisky');

INSERT INTO Lapowki
(nazwa)
VALUES ('Bizuteria');

INSERT INTO Lapowki
(nazwa)
VALUES ('Bursztyn');

INSERT INTO Lapowki
(nazwa)
VALUES ('Karma');

INSERT INTO Lapowki
(nazwa)
VALUES ('Jedzenie');

INSERT INTO Lapowki
(nazwa)
VALUES ('Telefon');



INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Wodka', 'Mistrzunio');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Karma', 'Lapek');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Pieniadze', 'Kucharz');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Telefon', 'Dziecko');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Whisky', 'Stefan');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Jedzenie', 'Tymek');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Jedzenie', 'Fafik');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Bizuteria', 'Ochroniarz');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Kosci', 'Andrzej');

INSERT INTO Lapowki_Wrogow
(nazwa_lapowki, nazwa_wroga)
VALUES ('Samochod', 'Mistrzunio');



INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (1, NULL, '10.01.1995', 15, 10, NULL, 'Tygrys');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (2, '10.01.2001', '10.01.1999', 11, 9, 'Tygrys', 'Mops');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (3, '20.12.2001', '12.12.2001', 15, 10, 'Maja', 'Kocur');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (4, '14.07.2002', '10.02.2002', 22, 8, 'Zuch', 'Maja');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (5, '24.05.2005', '23.05.2005', 15, 7, 'Tygrys', 'Zuch');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (6, NULL, '18.02.2008', 15, 25, NULL, 'Madrala');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (7, '11.11.2011', '16.06.2009', 12, 30, 'Madrala', 'Ignacy');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (8, NULL, '10.03.2012', 13, 31, NULL, 'Tygrys');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (9, '16.07.2013', '13.03.2013', 11, 34, 'Tosia', 'Zuch');

INSERT INTO Myszy
(nr, data_wydania, data_upolowania, waga_myszy, dlugosc_myszy, pseudo_zjadajacego_kota, pseudo_polujacego_kota)
VALUES (10, NULL, '3.07.2014', 11, 12, NULL, 'Kocur');
