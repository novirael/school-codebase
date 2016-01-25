
ALTER SESSION SET NLS_DATE_FORMAT='DD.MM.YYYY';

DROP TABLE MYSZY;
DROP TABLE LAPOWKI_WROGOW;
DROP TABLE LAPOWKI;
DROP TABLE INCYDENTY;
DROP TABLE KOTY;
DROP TABLE BANDY;
DROP TABLE FUNKCJE;
DROP TABLE WROGOWIE;

CREATE TABLE Wrogowie (
  nazwa_wroga VARCHAR(15) CONSTRAINT pk_imie_wroga PRIMARY KEY,
  gatunek VARCHAR(15)
);

CREATE TABLE Funkcje (
  nazwa_funkcji VARCHAR(15) CONSTRAINT pk_nazwa_funkcji PRIMARY KEY,
  min_przydzial_myszy NUMBER(3) CONSTRAINT check_min_myszy CHECK(min_przydzial_myszy >= 0) CONSTRAINT nn_min_myszy NOT NULL,
  max_przydzial_myszy NUMBER(3),
  CONSTRAINT check_max_gr_than_min_myszy CHECK(min_przydzial_myszy <= max_przydzial_myszy)
);

CREATE TABLE Bandy (
  nazwa VARCHAR(15) CONSTRAINT nn_nazwa_bandy NOT NULL,
  nr_bandy NUMBER(3) CONSTRAINT pk_nr_bandy PRIMARY KEY CONSTRAINT nr_bandy_greater_than_0 CHECK (nr_bandy > 0),
  teren VARCHAR(25) CONSTRAINT nn_teren NOT NULL
);

CREATE TABLE Koty (
  pseudo VARCHAR(15) CONSTRAINT pk_pseudo PRIMARY KEY,
  plec CHAR(1) CONSTRAINT check_plec CHECK(plec IN ('K', 'M')) CONSTRAINT nn_plec NOT NULL,
  data_wstapienia DATE CONSTRAINT nn_data_wstapienia NOT NULL,
  nr_bandy NUMBER(3) CONSTRAINT fk_numer_bandy REFERENCES Bandy(nr_bandy),
  pseudo_szefa VARCHAR(15) CONSTRAINT fk_koty_pseudo_szefa REFERENCES Koty(pseudo),
  nazwa_funkcji_kota VARCHAR(15) CONSTRAINT fk_nazwa_funkcji REFERENCES Funkcje(nazwa_funkcji) CONSTRAINT nn_nazwa_funkcji_kota NOT NULL
);

CREATE TABLE Incydenty (
  nazwa_wroga VARCHAR(15) CONSTRAINT fk_incydenty_nazwa_wroga REFERENCES Wrogowie(nazwa_wroga),
  pseudo_kota VARCHAR(15) CONSTRAINT fk_incydent_pseudo_kota REFERENCES Koty(pseudo),
  opis_incydentu VARCHAR(255) CONSTRAINT nn_opis_incydentu NOT NULL,
  stopien_wrogosci NUMBER(2) CONSTRAINT nn_nr_stopien_wrogosci NOT NULL CONSTRAINT stopien_wrogosci_zero_ten CHECK (stopien_wrogosci between 0 and 10),
  data_incydentu DATE CONSTRAINT nn_data_incydentu NOT NULL,
  CONSTRAINT pk_pseudo_k_wroga PRIMARY KEY(nazwa_wroga, pseudo_kota)
);

CREATE TABLE Lapowki (
  nazwa VARCHAR(15) CONSTRAINT pk_lapowki PRIMARY KEY CONSTRAINT nn_nazwa_lapowki NOT NULL
);

CREATE TABLE Lapowki_Wrogow (
  nazwa_lapowki VARCHAR(15) CONSTRAINT fk_lapowki_wrogow_nazlap REFERENCES Lapowki(nazwa) CONSTRAINT nn_lapowki_wrogow_nazlap NOT NULL,
  nazwa_wroga VARCHAR(15) CONSTRAINT fk_lapowki_wrogow_nazwa_wroga REFERENCES Wrogowie(nazwa_wroga) CONSTRAINT nn_lapowki_wrogow_nazwa_wroga NOT NULL,
  CONSTRAINT pk_lapowki_wrogow PRIMARY KEY(nazwa_wroga, nazwa_lapowki)
);

CREATE TABLE Myszy (
  nr NUMBER(3) CONSTRAINT pk_nr_myszy PRIMARY KEY,
  data_wydania DATE,
  data_upolowania DATE CONSTRAINT nn_data_upolowania NOT NULL,
  waga_myszy NUMBER(3) CONSTRAINT check_waga_myszy CHECK(waga_myszy > 10) CONSTRAINT nn_waga_myszy NOT NULL,
  dlugosc_myszy NUMBER(3) CONSTRAINT check_dlugosc_myszy CHECK(dlugosc_myszy > 5) CONSTRAINT nn_dlugosc_myszy NOT NULL,
  pseudo_zjadajacego_kota VARCHAR(15) CONSTRAINT fk_myszy_pseudo_zjadajacego REFERENCES Koty(pseudo),
  pseudo_polujacego_kota VARCHAR(15) CONSTRAINT nn_pseudo_polujacego NOT NULL CONSTRAINT fk_myszy_pseudo_polujacego REFERENCES Koty(pseudo),
  CONSTRAINT pk_myszy CHECK(data_wydania >= data_upolowania)
);
