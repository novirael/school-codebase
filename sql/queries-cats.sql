-----------------------------------------------------------------------------------------
-- trzy proste zapytania operujące na jednej relacji (w tym 1 zapytanie z operacja grupowania)
-----------------------------------------------------------------------------------------

-- Tygrys chce wiedzieć ile w sumie punktow wrogosci mają Marysia i Tosia.

SELECT pseudo_kota "Kot", sum(DISTINCT stopien_wrogosci) "W sumie punktow wrogosci"
    FROM incydenty
    WHERE pseudo_kota IN ('Marysia', 'Tosia')
    GROUP BY pseudo_kota;

-- Tygrys chce znalezc nazwy wrogow ktorzy sa psami posortowane alfabetycznie.

SELECT nazwa_wroga "Nazwa psa"
    FROM wrogowie
    WHERE gatunek = 'Pies'
    ORDER BY nazwa_wroga;

-- Tygrys chcialby podzielic wszytskie koty na te, ktore dolaczyly po i przed 2000 rokiem.

SELECT pseudo, CASE
    WHEN data_wstapienia < '01.01.2000' THEN 'Przed 2000' else 'Po 2000' END "Staż"
    FROM koty;

-----------------------------------------------------------------------------------------
-- trzy zapytania realizujące złączenia (w tym 1 zapytanie z operacja grupowania)
-----------------------------------------------------------------------------------------

-- Tygrys potzebuje listy wrogow i przedmiotow posortowanych malejaco, ktorymi moze przekupic wrogów.

SELECT w.nazwa_wroga "Wrog", l.nazwa_lapowki "Lapowka dla wroga"
    FROM wrogowie w
    JOIN lapowki_wrogow l
    ON w.nazwa_wroga = l.nazwa_wroga
    ORDER BY l.nazwa_lapowki DESC;

-- Tygrys chce dac kazdemu maksymalny przydzial myszy. Chcialby zobaczyc ile on wynosi dla kazdego kota.

SELECT k.pseudo "Pseudo kota", f.max_przydzial_myszy "Przydzial myszy"
    FROM koty k
    JOIN funkcje f
    ON k.nazwa_funkcji_kota = f.nazwa_funkcji
    WHERE f.max_przydzial_myszy IS NOT NULL;

-- Tygrys chcialby zobaczyc sredni min. przydzial myszy z podzialem na plec.

SELECT CASE WHEN plec = 'M' THEN 'Kocury' ELSE 'Kocice' END "Plec kotow", round(avg(min_przydzial_myszy)) "Sredni min. przydzial dla plci"
    FROM koty
    JOIN funkcje f
    ON nazwa_funkcji_kota = f.nazwa_funkcji
    GROUP BY plec;

-----------------------------------------------------------------------------------------
-- trzy zapytania wykorzystujące podzapytania (w tym 1 zapytanie z operacja grupowania)
-----------------------------------------------------------------------------------------

-- Tygrys chcialby sprawdzic jak nazywaja sie tereny, na ktorych poluja grupy z ktorych pochodzi Tosia i Ignacy.

SELECT nazwa FROM bandy
    WHERE nr_bandy IN (
    SELECT nr_bandy FROM koty WHERE
    pseudo = 'Tosia' OR pseudo = 'Ignacy'
);

-- Tygrys jest ciekaw ile kotow maja pod soba inni dowodcy procz niego nie liczac tych kotow, ktore mialy incydent z Mistrzuniem.

SELECT pseudo_szefa "Dowodcy", count(pseudo_szefa) "Ilosc kotow pod dowodca" FROM koty
    WHERE pseudo_szefa != 'Tygrys' AND pseudo NOT IN (
    SELECT pseudo_kota FROM incydenty
    WHERE nazwa_wroga = 'Mistrzunio'
)
GROUP BY pseudo_szefa;

-- Tosia chce przekupic swojego wroga. Chce zobaczyc jakie moze dac lapowki.

SELECT nazwa_lapowki "Lapowki dla wrogow" FROM lapowki_wrogow
WHERE nazwa_wroga IN (
    SELECT nazwa_wroga FROM koty k
    JOIN incydenty i
    ON k.pseudo = i.pseudo_kota
    WHERE k.pseudo = 'Tosia'
);

-----------------------------------------------------------------------------------------
-- trzy pespektywy (jedna prosta i dwie złożone) (w tym 1 zapytanie z operacja grupowania)
-----------------------------------------------------------------------------------------

-- Koty chcą dowiedziec sie jak nazywa sie banda 7 i ilu ma czlonkow.

CREATE VIEW banda_nr_7 AS
    SELECT b.nazwa "Nazwa bandy nr 7", count(k.pseudo) "Ilosc czlonkow" FROM koty k
    JOIN bandy b
    ON k.nr_bandy = b.nr_bandy
    WHERE k.nr_bandy = 7
    GROUP BY b.nazwa;

SELECT * FROM banda_nr_7;

-- Tygrys chcialby wiedziec ile waza w sumie wszystkie upolowane przez koty plci meskiej myszy.

SELECT sum(waga_myszy) "Waga myszy kocurow" FROM myszy
    WHERE pseudo_polujacego_kota IN (
    SELECT pseudo FROM koty
    WHERE plec = 'M'
);

-- Tygrys zostal poproszony o opis lagodnych incydentow (<mniej niz 5) sprzed 01.01.2010 uporzadkowane malejaco.

CREATE VIEW lagodne_incydenty AS
    SELECT opis_incydentu "Opis lagodnego incydentu", stopien_wrogosci "Stopien wrogosci" FROM incydenty
    WHERE stopien_wrogosci < 5 AND data_incydentu < '01.01.2010'
    ORDER BY stopien_wrogosci DESC;

SELECT * FROM lagodne_incydenty;
