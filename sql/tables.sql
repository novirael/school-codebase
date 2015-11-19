

DROP TABLE jezyki_obce;
DROP TABLE sprawnosci;
DROP TABLE donacje;
DROP TABLE dawcy;
DROP TABLE zlecenia;
DROP TABLE wampiry;


CREATE TABLE Wampiry (
  pseudo_wampira VARCHAR2(15)
    CONSTRAINT pseudo_wampira_pk PRIMARY KEY,
  wampir_w_rodzinie DATE NOT NULL,
  plec_wampira CHAR(1) NOT NULL
    CONSTRAINT plec_wampira_ch CHECK(plec_wampira IN ('K','M')),
  pseudo_szefa VARCHAR2(15)
    CONSTRAINT pseudo_szefa_fk REFERENCES Wampiry
);

CREATE TABLE Zlecenia (
  nr_zlecenia NUMBER(6)
    CONSTRAINT nr_zlecenia_pk PRIMARY KEY
    CONSTRAINT nr_zlecenia_ch CHECK(nr_zlecenia > 0),
  data_zlecenia DATE NOT NULL,
  pseudo_wampira VARCHAR2(15) NOT NULL
    CONSTRAINT pseudo_wampira_zlec_fk REFERENCES Wampiry
);

CREATE TABLE Dawcy (
  pseudo_dawcy VARCHAR2(15)
    CONSTRAINT pseudo_dawcy_pk PRIMARY KEY,
  rocznik_dawcy NUMBER(4) NOT NULL,
  plec_dawcy CHAR(1)
    CONSTRAINT plec_dawcy_ch CHECK(plec_dawcy IN ('K','M')),
  grupa_krwi VARCHAR2(2)
    CONSTRAINT grupa_krwi_ch CHECK(grupa_krwi IN ('0','A', 'B', 'AB'))
);

CREATE TABLE Donacje (
  nr_zlecenia NUMBER(6)
    CONSTRAINT nr_zlecenia_fk REFERENCES Zlecenia,
  pseudo_dawcy VARCHAR2(15)
    CONSTRAINT pseudo_dawcy_fk REFERENCES Dawcy,
  data_oddania DATE NOT NULL,
  ilosc_krwi NUMBER(3)
    CONSTRAINT ilosc_krwi_ch CHECK(ilosc_krwi > 0),
  pseudo_wampira VARCHAR2(15)
    CONSTRAINT pseudo_wampira_dona_fk REFERENCES Wampiry,
  data_wydania DATE,
  CONSTRAINT data_wydania_oddania_ch CHECK (data_wydania>=data_oddania),
  CONSTRAINT donacje_pk PRIMARY KEY (nr_zlecenia, pseudo_dawcy)
);

CREATE TABLE Sprawnosci (
  sprawnosc VARCHAR2(15) 
    CONSTRAINT sprawnosc_pk PRIMARY KEY
);

CREATE TABLE Sprawnosci_w (
  pseudo_wampira VARCHAR2(15)
    CONSTRAINT pseudo_wampira_spraw_fk REFERENCES Wampiry,
  sprawnosc VARCHAR2(20)
    CONSTRAINT sprawnosc_fk REFERENCES Sprawnosci,
  sprawnosc_od DATE NOT NULL,
  CONSTRAINT sprawnosci_w_pk PRIMARY KEY(pseudo_wampira, sprawnosc)
);

CREATE TABLE Jezyki_obce (
  jezyk_obcy VARCHAR2(20) 
    CONSTRAINT jezyk_obcy_pk PRIMARY KEY
);

CREATE TABLE Jezyki_obce_w (
  pseudo_wampira VARCHAR2(15)
    CONSTRAINT pseudo_wampira_jezy_fk REFERENCES Wampiry,
  jezyk_obcy VARCHAR2(20)
    CONSTRAINT jezyk_obcy_fk REFERENCES Jezyki_obce,
  jezyk_obcy_od DATE NOT NULL,
  CONSTRAINT jezyki_obcy_w_pk PRIMARY KEY(pseudo_wampira, jezyk_obcy)
);
