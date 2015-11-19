

def print_block(block, query):
    for l in block.split("\n"):
        line = l.strip()
        if line:
            print(query.format(line))

    print("\n")


def generate_wampiry():
    wampiry = """
    'Drakula', TO_DATE('12.12.1217', 'dd.mm.yyyy'), 'M', NULL
    'Opoj', TO_DATE('07.11.1777', 'dd.mm.yyyy'), 'M', 'Drakula'
    'Wicek', TO_DATE('11.11.1721', 'dd.mm.yyyy'), 'M', 'Drakula'
    'Baczek', TO_DATE('13.04.1855', 'dd.mm.yyyy'), 'M', 'Opoj'
    'Bolek', TO_DATE('31.05.1945', 'dd.mm.yyyy'), 'M', 'Opoj'
    'Gacek', TO_DATE('21.02.1891', 'dd.mm.yyyy'), 'M', 'Wicek'
    'Pijawka', TO_DATE('03.11.1901', 'dd.mm.yyyy'), 'K', 'Wicek'
    'Czerwony', TO_DATE('13.09.1823', 'dd.mm.yyyy'), 'M', 'Wicek'
    'Komar', TO_DATE('23.07.1911', 'dd.mm.yyyy'), 'M', 'Wicek'
    'Zyleta', TO_DATE('23.09.1911', 'dd.mm.yyyy'), 'K', 'Opoj'
    'Predka', TO_DATE('29.03.1877', 'dd.mm.yyyy'), 'K', 'Drakula'
    """
    query = "INSERT INTO Wampiry (pseudo_wampira, wampir_w_rodzinie," \
            "plec_wampira, pseudo_szefa) \nVALUES ({});\n"

    print_block(wampiry, query)


def generate_zlecenia():
    zlecenia = """
    221, TO_DATE('04.07.2005', 'dd.mm.yyyy'), 'Opoj'
    222, TO_DATE('04.07.2005', 'dd.mm.yyyy'), 'Baczek'
    223, TO_DATE('17.07.2005', 'dd.mm.yyyy'), 'Bolek'
    224, TO_DATE('22.07.2005', 'dd.mm.yyyy'), 'Opoj'
    225, TO_DATE('01.08.2005', 'dd.mm.yyyy'), 'Pijawka'
    226, TO_DATE('07.08.2005', 'dd.mm.yyyy'), 'Gacek'
    """
    query = "INSERT INTO Zlecenia (nr_zlecenia, data_zlecenia, " \
            "pseudo_wampira) \nVALUES ({});\n"

    print_block(zlecenia, query)


def generate_dawcy():
    dawcy = """
    'Slodka', 1966, 'K', 'AB'
    'Miodzio', 1983, 'M', 'B'
    'Gorzka', 1958, 'K', '0'
    'Lolita', 1987, 'K', '0'
    'Wytrawny', 1971, 'M', 'A'
    'Okocim', 1966, 'M', 'B'
    'Adonis', 1977, 'M', 'AB'
    'Zywiec', 1969, 'M', 'A'
    'Eliksir', 1977, 'M', '0'
    'Zenek', 1959, 'M', 'B'
    'Zoska', 1963, 'K', '0'
    'Czerwonka', 1953, 'M', 'A'
    """
    query = "INSERT INTO Dawcy (pseudo_dawcy, rocznik_dawcy, plec_dawcy, " \
            "grupa_krwi) \nVALUES ({});\n"

    print_block(dawcy, query)


def generate_donacje():
    donacje = """
    221, 'Slodka', TO_DATE('04.07.2005', 'dd.mm.yyyy'), 455, 'Drakula', TO_DATE('06.08.2005', 'dd.mm.yyyy')
    221, 'Miodzio', TO_DATE('04.07.2005', 'dd.mm.yyyy'), 680, 'Gacek', TO_DATE('15.08.2005', 'dd.mm.yyyy')
    221, 'Gorzka', TO_DATE('05.07.2005', 'dd.mm.yyyy'), 471, 'Pijawka', TO_DATE('11.08.2005', 'dd.mm.yyyy')
    221, 'Lolita', TO_DATE('05.07.2005', 'dd.mm.yyyy'), 340, 'Czerwony', TO_DATE('21.08.2005', 'dd.mm.yyyy')
    222, 'Wytrawny', TO_DATE('07.07.2005', 'dd.mm.yyyy'), 703, 'Drakula', TO_DATE('17.07.2005', 'dd.mm.yyyy')
    222, 'Okocim', TO_DATE('07.07.2005', 'dd.mm.yyyy'), 530, 'Komar', TO_DATE('01.09.2005', 'dd.mm.yyyy')
    222, 'Adonis', TO_DATE('08.07.2005', 'dd.mm.yyyy'), 221, 'Zyleta', TO_DATE('11.09.2005', 'dd.mm.yyyy')
    223, 'Zywiec', TO_DATE('17.07.2005', 'dd.mm.yyyy'), 587, 'Wicek', TO_DATE('18.09.2005', 'dd.mm.yyyy')
    224, 'Gorzka', TO_DATE('22.07.2005', 'dd.mm.yyyy'), 421, 'Drakula', TO_DATE('23.08.2005', 'dd.mm.yyyy')
    224, 'Eliksir', TO_DATE('25.07.2005', 'dd.mm.yyyy'), 377, 'Predka', TO_DATE('26.07.2005', 'dd.mm.yyyy')
    225, 'Zenek', TO_DATE('04.08.2005', 'dd.mm.yyyy'), 600, 'Opoj', TO_DATE('15.08.2005', 'dd.mm.yyyy')
    225, 'Zoska', TO_DATE('06.08.2005', 'dd.mm.yyyy'), 450, NULL, NULL
    226, 'Czerwonka', TO_DATE('10.08.2005', 'dd.mm.yyyy'), 517, 'Pijawka', TO_DATE('30.09.2005', 'dd.mm.yyyy')
    226, 'Miodzio', TO_DATE('11.08.2005', 'dd.mm.yyyy'), 644, NULL, NULL
    """

    query = "INSERT INTO Donacje (nr_zlecenia, pseudo_dawcy, data_oddania, " \
            "ilosc_krwi, pseudo_wampira, data_wydania) \nVALUES ({});\n"

    print_block(donacje, query)


def generate_sprawnosci():
    sprawnosci = """
    'podryw'
    'gorzala'
    'kasa'
    'przymus'
    'niesmiertelnosc'
    """

    query = "INSERT INTO Sprawnosci (sprawnosc) \nVALUES ({});\n"

    print_block(sprawnosci, query)


def generate_sprawnosci_w():
    sprawnosci_w = """
    'Drakula', 'podryw', TO_DATE('12.12.1217', 'dd.mm.yyyy')
    'Drakula', 'gorzala', TO_DATE('12.12.1217', 'dd.mm.yyyy')
    'Wicek', 'kasa', TO_DATE('11.11.1721', 'dd.mm.yyyy')
    'Wicek', 'przymus', TO_DATE('07.01.1771', 'dd.mm.yyyy')
    'Opoj', 'podryw', TO_DATE('07.11.1777', 'dd.mm.yyyy')
    'Czerwony', 'niesmiertelnosc', TO_DATE('13.09.1823', 'dd.mm.yyyy')
    'Drakula', 'kasa', TO_DATE('13.09.1823', 'dd.mm.yyyy')
    'Opoj','gorzala', TO_DATE('11.12.1844', 'dd.mm.yyyy')
    'Baczek', 'gorzala', TO_DATE('13.04.1855', 'dd.mm.yyyy')
    'Drakula', 'przymus', TO_DATE('14.06.1857', 'dd.mm.yyyy')
    'Drakula', 'niesmiertelnosc', TO_DATE('21.08.1858', 'dd.mm.yyyy')
    'Opoj', 'przymus', TO_DATE('15.07.1861', 'dd.mm.yyyy')
    'Wicek', 'gorzala', TO_DATE('19.01.1866', 'dd.mm.yyyy')
    'Predka', 'podryw', TO_DATE('29.03.1877', 'dd.mm.yyyy')
    'Czerwony', 'kasa', TO_DATE('03.02.1891', 'dd.mm.yyyy')
    'Gacek', 'kasa', TO_DATE('21.02.1891', 'dd.mm.yyyy')
    'Pijawka', 'podryw', TO_DATE('03.11.1901', 'dd.mm.yyyy')
    'Komar', 'gorzala', TO_DATE('23.07.1911', 'dd.mm.yyyy')
    'Zyleta', 'przymus', TO_DATE('23.09.1911', 'dd.mm.yyyy')
    'Bolek', 'gorzala', TO_DATE('31.05.1945', 'dd.mm.yyyy')
    """

    query = "INSERT INTO Sprawnosci_w (pseudo_wampira, sprawnosc, " \
            "sprawnosc_od) \nVALUES ({});\n"

    print_block(sprawnosci_w, query)


def generate_jezyki_obce():
    jezyki_obce = """
    'niemiecki'
    'wegierski'
    'bulgarski'
    'rosyjski'
    'portugalski'
    'francuski'
    'angielski'
    'polski'
    'hiszpanski'
    'czeski'
    'wloski'
    'szwedzki'
    """

    query = "INSERT INTO Jezyki_obce (jezyk_obcy) \nVALUES ({});\n"

    print_block(jezyki_obce, query)


def generate_jezyki_obce_w():
    jezyki_obce_w = """
    'Drakula', 'niemiecki', TO_DATE('12.12.1217', 'dd.mm.yyyy')
    'Drakula', 'wegierski', TO_DATE('12.12.1217', 'dd.mm.yyyy')
    'Drakula', 'bulgarski', TO_DATE('03.04.1455', 'dd.mm.yyyy')
    'Wicek', 'rosyjski', TO_DATE('11.11.1721', 'dd.mm.yyyy')
    'Opoj', 'portugalski', TO_DATE('07.11.1777', 'dd.mm.yyyy')
    'Czerwony', 'francuski', TO_DATE('13.09.1823', 'dd.mm.yyyy')
    'Drakula', 'angielski', TO_DATE('13.09.1823', 'dd.mm.yyyy')
    'Wicek', 'polski', TO_DATE('18.08.1835', 'dd.mm.yyyy')
    'Opoj', 'hiszpanski', TO_DATE('12.03.1851', 'dd.mm.yyyy')
    'Baczek', 'czeski', TO_DATE('13.04.1855', 'dd.mm.yyyy')
    'Wicek', 'niemiecki', TO_DATE('11.06.1869', 'dd.mm.yyyy')
    'Wicek', 'wloski', TO_DATE('14.03.1873', 'dd.mm.yyyy')
    'Predka', 'czeski', TO_DATE('29.03.1877', 'dd.mm.yyyy')
    'Opoj', 'polski', TO_DATE('13.09.1883', 'dd.mm.yyyy')
    'Czerwony', 'rosyjski', TO_DATE('23.11.1888', 'dd.mm.yyyy')
    'Gacek', 'polski', TO_DATE('21.02.1891', 'dd.mm.yyyy')
    'Predka', 'niemiecki', TO_DATE('07.06.1894', 'dd.mm.yyyy')
    'Baczek', 'angielski', TO_DATE('04.12.1899', 'dd.mm.yyyy')
    'Pijawka', 'angielski', TO_DATE('03.11.1901', 'dd.mm.yyyy')
    'Komar', 'szwedzki', TO_DATE('23.07.1911', 'dd.mm.yyyy')
    'Zyleta', 'angielski', TO_DATE('23.09.1911', 'dd.mm.yyyy')
    'Bolek', 'francuski', TO_DATE('31.05.1945', 'dd.mm.yyyy')
    """

    query = "INSERT INTO Jezyki_obce_w (pseudo_wampira, jezyk_obcy," \
            "jezyk_obcy_od) \nVALUES ({});\n"

    print_block(jezyki_obce_w, query)

if __name__ == '__main__':
    generate_wampiry()
    generate_zlecenia()
    generate_dawcy()
    generate_donacje()
    generate_sprawnosci()
    generate_sprawnosci_w()
    generate_jezyki_obce()
    generate_jezyki_obce_w()
