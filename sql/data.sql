INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Drakula', TO_DATE('12.12.1217', 'dd.mm.yyyy'), 'M', NULL);

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Opoj', TO_DATE('07.11.1777', 'dd.mm.yyyy'), 'M', 'Drakula');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Wicek', TO_DATE('11.11.1721', 'dd.mm.yyyy'), 'M', 'Drakula');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Baczek', TO_DATE('13.04.1855', 'dd.mm.yyyy'), 'M', 'Opoj');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Bolek', TO_DATE('31.05.1945', 'dd.mm.yyyy'), 'M', 'Opoj');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Gacek', TO_DATE('21.02.1891', 'dd.mm.yyyy'), 'M', 'Wicek');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Pijawka', TO_DATE('03.11.1901', 'dd.mm.yyyy'), 'K', 'Wicek');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Czerwony', TO_DATE('13.09.1823', 'dd.mm.yyyy'), 'M', 'Wicek');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Komar', TO_DATE('23.07.1911', 'dd.mm.yyyy'), 'M', 'Wicek');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Zyleta', TO_DATE('23.09.1911', 'dd.mm.yyyy'), 'K', 'Opoj');

INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie,plec_wampira, pseudo_szefa) 
VALUES ('Predka', TO_DATE('29.03.1877', 'dd.mm.yyyy'), 'K', 'Drakula');



INSERT INTO Zlecenia (nr_zlecenia, data_zlecenia, pseudo_wampira) 
VALUES (221, TO_DATE('04.07.2005', 'dd.mm.yyyy'), 'Opoj');

INSERT INTO Zlecenia (nr_zlecenia, data_zlecenia, pseudo_wampira) 
VALUES (222, TO_DATE('04.07.2005', 'dd.mm.yyyy'), 'Baczek');

INSERT INTO Zlecenia (nr_zlecenia, data_zlecenia, pseudo_wampira) 
VALUES (223, TO_DATE('17.07.2005', 'dd.mm.yyyy'), 'Bolek');

INSERT INTO Zlecenia (nr_zlecenia, data_zlecenia, pseudo_wampira) 
VALUES (224, TO_DATE('22.07.2005', 'dd.mm.yyyy'), 'Opoj');

INSERT INTO Zlecenia (nr_zlecenia, data_zlecenia, pseudo_wampira) 
VALUES (225, TO_DATE('01.08.2005', 'dd.mm.yyyy'), 'Pijawka');

INSERT INTO Zlecenia (nr_zlecenia, data_zlecenia, pseudo_wampira) 
VALUES (226, TO_DATE('07.08.2005', 'dd.mm.yyyy'), 'Gacek');



INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Slodka', 1966, 'K', 'AB');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Miodzio', 1983, 'M', 'B');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Gorzka', 1958, 'K', '0');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Lolita', 1987, 'K', '0');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Wytrawny', 1971, 'M', 'A');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Okocim', 1966, 'M', 'B');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Adonis', 1977, 'M', 'AB');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Zywiec', 1969, 'M', 'A');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Eliksir', 1977, 'M', '0');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Zenek', 1959, 'M', 'B');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Zoska', 1963, 'K', '0');

INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, grupa_krwi) 
VALUES ('Czerwonka', 1953, 'M', 'A');



INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (221, 'Slodka', TO_DATE('04.07.2005', 'dd.mm.yyyy'), 455, 'Drakula', TO_DATE('06.08.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (221, 'Miodzio', TO_DATE('04.07.2005', 'dd.mm.yyyy'), 680, 'Gacek', TO_DATE('15.08.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (221, 'Gorzka', TO_DATE('05.07.2005', 'dd.mm.yyyy'), 471, 'Pijawka', TO_DATE('11.08.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (221, 'Lolita', TO_DATE('05.07.2005', 'dd.mm.yyyy'), 340, 'Czerwony', TO_DATE('21.08.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (222, 'Wytrawny', TO_DATE('07.07.2005', 'dd.mm.yyyy'), 703, 'Drakula', TO_DATE('17.07.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (222, 'Okocim', TO_DATE('07.07.2005', 'dd.mm.yyyy'), 530, 'Komar', TO_DATE('01.09.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (222, 'Adonis', TO_DATE('08.07.2005', 'dd.mm.yyyy'), 221, 'Zyleta', TO_DATE('11.09.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (223, 'Zywiec', TO_DATE('17.07.2005', 'dd.mm.yyyy'), 587, 'Wicek', TO_DATE('18.09.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (224, 'Gorzka', TO_DATE('22.07.2005', 'dd.mm.yyyy'), 421, 'Drakula', TO_DATE('23.08.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (224, 'Eliksir', TO_DATE('25.07.2005', 'dd.mm.yyyy'), 377, 'Predka', TO_DATE('26.07.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (225, 'Zenek', TO_DATE('04.08.2005', 'dd.mm.yyyy'), 600, 'Opoj', TO_DATE('15.08.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (225, 'Zoska', TO_DATE('06.08.2005', 'dd.mm.yyyy'), 450, NULL, NULL);

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (226, 'Czerwonka', TO_DATE('10.08.2005', 'dd.mm.yyyy'), 517, 'Pijawka', TO_DATE('30.09.2005', 'dd.mm.yyyy'));

INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, ilosc_krwi, pseudo_wampira, data_wydania) 
VALUES (226, 'Miodzio', TO_DATE('11.08.2005', 'dd.mm.yyyy'), 644, NULL, NULL);



INSERT INTO Sprawnosci (sprawnosc) 
VALUES ('podryw');

INSERT INTO Sprawnosci (sprawnosc) 
VALUES ('gorzala');

INSERT INTO Sprawnosci (sprawnosc) 
VALUES ('kasa');

INSERT INTO Sprawnosci (sprawnosc) 
VALUES ('przymus');

INSERT INTO Sprawnosci (sprawnosc) 
VALUES ('niesmiertelnosc');



INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Drakula', 'podryw', TO_DATE('12.12.1217', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Drakula', 'gorzala', TO_DATE('12.12.1217', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Wicek', 'kasa', TO_DATE('11.11.1721', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Wicek', 'przymus', TO_DATE('07.01.1771', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Opoj', 'podryw', TO_DATE('07.11.1777', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Czerwony', 'niesmiertelnosc', TO_DATE('13.09.1823', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Drakula', 'kasa', TO_DATE('13.09.1823', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Opoj','gorzala', TO_DATE('11.12.1844', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Baczek', 'gorzala', TO_DATE('13.04.1855', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Drakula', 'przymus', TO_DATE('14.06.1857', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Drakula', 'niesmiertelnosc', TO_DATE('21.08.1858', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Opoj', 'przymus', TO_DATE('15.07.1861', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Wicek', 'gorzala', TO_DATE('19.01.1866', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Predka', 'podryw', TO_DATE('29.03.1877', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Czerwony', 'kasa', TO_DATE('03.02.1891', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Gacek', 'kasa', TO_DATE('21.02.1891', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Pijawka', 'podryw', TO_DATE('03.11.1901', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Komar', 'gorzala', TO_DATE('23.07.1911', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Zyleta', 'przymus', TO_DATE('23.09.1911', 'dd.mm.yyyy'));

INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, sprawnosc_od) 
VALUES ('Bolek', 'gorzala', TO_DATE('31.05.1945', 'dd.mm.yyyy'));



INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('niemiecki');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('wegierski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('bulgarski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('rosyjski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('portugalski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('francuski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('angielski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('polski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('hiszpanski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('czeski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('wloski');

INSERT INTO Jezyki_obce (jezyk_obcy) 
VALUES ('szwedzki');



INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Drakula', 'niemiecki', TO_DATE('12.12.1217', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Drakula', 'wegierski', TO_DATE('12.12.1217', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Drakula', 'bulgarski', TO_DATE('03.04.1455', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Wicek', 'rosyjski', TO_DATE('11.11.1721', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Opoj', 'portugalski', TO_DATE('07.11.1777', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Czerwony', 'francuski', TO_DATE('13.09.1823', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Drakula', 'angielski', TO_DATE('13.09.1823', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Wicek', 'polski', TO_DATE('18.08.1835', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Opoj', 'hiszpanski', TO_DATE('12.03.1851', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Baczek', 'czeski', TO_DATE('13.04.1855', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Wicek', 'niemiecki', TO_DATE('11.06.1869', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Wicek', 'wloski', TO_DATE('14.03.1873', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Predka', 'czeski', TO_DATE('29.03.1877', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Opoj', 'polski', TO_DATE('13.09.1883', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Czerwony', 'rosyjski', TO_DATE('23.11.1888', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Gacek', 'polski', TO_DATE('21.02.1891', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Predka', 'niemiecki', TO_DATE('07.06.1894', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Baczek', 'angielski', TO_DATE('04.12.1899', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Pijawka', 'angielski', TO_DATE('03.11.1901', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Komar', 'szwedzki', TO_DATE('23.07.1911', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Zyleta', 'angielski', TO_DATE('23.09.1911', 'dd.mm.yyyy'));

INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy,jezyk_obcy_od) 
VALUES ('Bolek', 'francuski', TO_DATE('31.05.1945', 'dd.mm.yyyy'));
