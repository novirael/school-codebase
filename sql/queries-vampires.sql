
-- Zad. 3. Znaleźć pseudonimy i roczniki dawców posiadających grupę krwi A.
SELECT pseudo_dawcy, rocznik_dawcy FROM Dawcy WHERE grupa_krwi = 'A';


-- Zad. 4. Znaleźć pseudonimy dawców, którzy oddawali krew między 20.07.2005 a 20.08.2005.
SELECT DISTINCT pseudo_dawcy FROM Donacje WHERE data_oddania BETWEEN TO_DATE('20.07.2005', 'dd.mm.yyyy') AND TO_DATE('20.08.2005', 'dd.mm.yyyy');


-- Zad. 5. Określić, ile sprawności posiadają w sumie wampiry o pseudonimach Opoj i Czerwony.
SELECT COUNT(DISTINCT sprawnosc) FROM Sprawnosci_w WHERE pseudo_wampira IN ('Opoj', 'Czerwony');


-- Zad. 6. Określić całkowitą objętość krwi, dla której data wydania rożni się od daty oddania co najwyżej o 10 dni.
SELECT SUM(ilosc_krwi) FROM Donacje WHERE data_wydania <= data_oddania + 10;


-- Zad. 7. Określić wampiry, które wielokrotnie konsumowały krew z Banku Krwi.
SELECT pseudo_wampira, COUNT(pseudo_wampira) FROM Donacje GROUP BY pseudo_wampira HAVING COUNT(pseudo_wampira) > 1;


-- Zad. 8. Wyświetlić liczbę dawców każdej grupy krwi z podziałem na płcie.
SELECT grupa_krwi, plec_dawcy, COUNT(*) FROM Dawcy GROUP BY grupa_krwi, plec_dawcy;


-- Zad. 9. Wyświetlić numery zleceń, w ramach których pobierana była krew grupy ‘AB’ (wykorzystać złączenia relacji).
SELECT Do.nr_zlecenia FROM Donacje Do, Dawcy Da WHERE Do.pseudo_dawcy=Da.pseudo_dawcy AND Da.grupa_krwi = 'AB';


-- Zad. 10. Przedstawić pseudonimy wampirów wraz z ich płcią oraz pseudonimy i płcie ich szefów (wykorzystać wyłącznie złączenia relacji).
SELECT DISTINCT Wa.pseudo_wampira, Wa.plec_wampira, NVL(Sze.pseudo_wampira, ' '), NVL(Sze.plec_wampira, ' ')
FROM Wampiry Wa LEFT JOIN Wampiry Sze ON Wa.pseudo_szefa = Sze.pseudo_wampira ORDER BY Wa.pseudo_wampira;


-- Todo union all DONE
-- Zad. 11. Określić uporządkowane alfabetycznie pseudonimy dawców, od których pobrano w sumie powyżej 1000 ml,
-- między 700 a 1000 ml i poniżej 700 ml. Zastosować połączenie pionowe relacji.
SELECT pseudo_dawcy, 'Powyzej 1000' FROM Donacje GROUP BY pseudo_dawcy HAVING SUM(ilosc_krwi) > 1000
UNION ALL
SELECT pseudo_dawcy, 'Ponizej 700' FROM Donacje GROUP BY pseudo_dawcy HAVING SUM(ilosc_krwi) < 700
UNION ALL
SELECT pseudo_dawcy, 'Miedzy 700 a 1000' FROM Donacje GROUP BY pseudo_dawcy HAVING SUM(ilosc_krwi) BETWEEN 700 and 1000;


-- Zad. 12. Wyświetlić numery zleceń, w ramach których pobierana była krew grupy ‘AB’ (wykorzystać podzapytania).
SELECT nr_zlecenia FROM Donacje WHERE pseudo_dawcy IN (SELECT pseudo_dawcy FROM Dawcy WHERE grupa_krwi='AB');


-- Todo skorelowane DONE
-- Zad. 13. Wyświetlić uporządkowane malejąco trzy największe objętości donacji wraz z pseudonimami dawców,
-- od których donacje pochodzą. Zadanie wykonać z wykorzystaniem podzapytania skorelowanego.
-- SELECT ilosc_krwi, pseudo_dawcy FROM (Select * FROM Donacje ORDER BY ilosc_krwi DESC) WHERE ROWNUM < 4;
SELECT ilosc_krwi, pseudo_dawcy FROM Donacje D1 WHERE (SELECT COUNT(DISTINCT D2.ilosc_krwi) FROM donacje D2 WHERE D2.ilosc_krwi > D1.ilosc_krwi) < 3 ORDER BY ilosc_krwi DESC;


-- Zad. 14. Określić ile wampirów w każdej z płci zna przynajmniej dwa języki obce (wykorzystać podzapytanie).
SELECT plec_wampira, COUNT(*) FROM Wampiry W WHERE (SELECT COUNT(jezyk_obcy) FROM Jezyki_obce_w WHERE W.pseudo_wampira = pseudo_wampira) > 1 GROUP BY plec_wampira;


-- Zad. 15. Określić pseudonimy i grupy krwi dawców, od których pobierały krew wampiry znające język polski oraz
-- pseudonimy wampirów pobierających krew. Zadanie rozwiązać wykorzystując złączenia relacji.
SELECT DISTINCT pseudo_dawcy, grupa_krwi, Z.pseudo_wampira
FROM (Donacje D NATURAL JOIN Dawcy JOIN Zlecenia Z ON Z.nr_zlecenia= D.nr_zlecenia) JOIN Jezyki_obce_w J ON Z.pseudo_wampira = J.pseudo_wampira WHERE JEZYK_OBCY = 'polski' ORDER BY Z.pseudo_wampira;


-- Zad. 16. „Odmłodzić” wszystkich dawców grupy krwi 0 o pięć lat. Wyświetlić ich roczniki przed zmianą,
-- dokonać zmiany, wyświetlić roczniki po zmianie a następnie wycofać zmiany.
SELECT pseudo_dawcy, rocznik_dawcy FROM Dawcy WHERE grupa_krwi='0';
UPDATE Dawcy SET rocznik_dawcy=rocznik_dawcy + 5 WHERE grupa_krwi='0';


-- Zad. 17. Zdefiniować perspektywę określającą sumaryczne spożycie krwi przez każdego wampira
-- (z wyłączeniem Drakuli). Wyświetlić zawartość perspektywy.
CREATE VIEW Spozycie (pseudo,spozycie)
AS SELECT pseudo_wampira, SUM(ilosc_krwi) FROM Donacje WHERE pseudo_wampira != 'Drakula' GROUP BY pseudo_wampira;
SELECT * FROM Spozycie;


-- Zad. 18. Zdefiniować perspektywę określającą zlecenia i ich wykonawców, które nie skończyły się
-- poborem donacji (z wyłączenie zleceń wykonywanych przez Drakulę i jego bezpośrednich podwładnych).
-- Wyświetlić zawartość perspektywy.
CREATE VIEW DobreZlecenia (nr_zlecenia,pseudo_wampira)
AS SELECT nr_zlecenia, pseudo_dawcy
FROM Donacje LEFT JOIN Wampiry USING(pseudo_wampira)
WHERE data_oddania IS NULL
AND (pseudo_wampira != 'Drakula' OR pseudo_szefa != 'Drakula');
SELECT * FROM DobreZlecenia;


-- Zad. 19. Zdefiniować zapytanie, które zwróci raport określający sumaryczne spożycie krwi
-- z Banku Krwi podwładnych każdego szefa z podziałem na płcie podwładnych.
SELECT CASE
  W.plec_wampira WHEN 'K' THEN 'Wampirki' ELSE 'Wampiry' END "Plec podwladnych",
  SUM(CASE WHEN W.pseudo_szefa = 'Drakula' THEN D.ilosc_krwi ELSE 0 END) "Pod Drakula",
  SUM(CASE WHEN W.pseudo_szefa = 'Opoj' THEN D.ilosc_krwi ELSE 0 END) "Pod Opojem",
  SUM(CASE WHEN W.pseudo_szefa = 'Wicek' THEN D.ilosc_krwi ELSE 0 END) "Pod Wickiem"
FROM Wampiry W, Donacje D WHERE W.pseudo_wampira = D.pseudo_wampira GROUP BY W.plec_wampira;
