
INSERT INTO Bibliothek_Autor VALUES (1,'Kafka', 'Franz');
INSERT INTO Bibliothek_Autor VALUES (2,'Krüger', 'Eberhard');
INSERT INTO Bibliothek_Autor VALUES (3,'Erlenkötter', 'Helmut');
INSERT INTO Bibliothek_Autor VALUES (4,'Emmerich', 'Roland');
INSERT INTO Bibliothek_Autor VALUES (5,'Malik', 'Fredmund');
INSERT INTO Bibliothek_Autor VALUES (6,'Tess', 'Gerritsen');
INSERT INTO Bibliothek_Autor VALUES (7,'Mustermann', 'Max');
INSERT INTO Bibliothek_Autor VALUES (8,'Addison', 'Wesley');
INSERT INTO Bibliothek_Autor VALUES (9,'Steiner', 'Rene');
INSERT INTO Bibliothek_Autor VALUES (10,'Schubert', 'Matthias');


INSERT INTO Bibliothek_Personen VALUES (111, 'Eugen Lechner',NULL, 0);
INSERT INTO Bibliothek_Personen VALUES (222, 'Tomas Miller', NULL, 0);
INSERT INTO Bibliothek_Personen VALUES (333, 'Alexander Albrant', NULL, 2);
INSERT INTO Bibliothek_Personen VALUES (444, 'Mikhail Goldenzweig', NULL, 1);

INSERT INTO Bibliothek_Einrichtungen VALUES (1111, 'Das Rote Kreuz', 0, 0);
INSERT INTO Bibliothek_Einrichtungen VALUES (2222, 'HAW', 0, 0);
INSERT INTO Bibliothek_Einrichtungen VALUES (3333, 'UNI Hamburg', 0, 0);

INSERT INTO Bibliothek_Objekt VALUES (1, 'C, Programmieren von Anfang an', 'Rowohlt Tb.', 'Buch', TO_DATE('2007', 'YYYY'), 333, NULL);
INSERT INTO Bibliothek_Objekt VALUES (2,'Die Verwandlung', 'Reclam, Ditzingen', 'Buch', TO_DATE('2005', 'YYYY'), NULL, 1111);
INSERT INTO Bibliothek_Objekt VALUES (3,'Rätselblock', 'Bassermann', 'Zeitschrift', TO_DATE('2009', 'YYYY'), NULL, NULL);
INSERT INTO Bibliothek_Objekt VALUES (4, 'Blutmale', 'Blanvalet', 'Buch', TO_DATE('2007', 'YYYY'),NULL, 3333);
INSERT INTO Bibliothek_Objekt VALUES (5, 'Führen, Leisten, Leben', 'Campus Verlag', 'Hörbuch', TO_DATE('2000', 'YYYY'), 444, NULL);
INSERT INTO Bibliothek_Objekt VALUES (6,'10.000 BC', 'Warner Home Video', 'Zeitschrift', TO_DATE('2008', 'YYYY'), 333, NULL);
INSERT INTO Bibliothek_Objekt VALUES (7,'Irgedwas', 'Warner Home Video', 'Hörbuch', TO_DATE('2007', 'YYYY'), NULL, NULL);
INSERT INTO Bibliothek_Objekt VALUES (8, 'Datenbanken', 'Rowohlt Tb.', 'Buch', TO_DATE('2007', 'YYYY'), NULL, NULL);
INSERT INTO Bibliothek_Objekt VALUES (9, 'Datenbanken', 'heise', 'Zeitschrift', TO_DATE('2009', 'YYYY'), NULL, NULL);
INSERT INTO Bibliothek_Objekt VALUES (10, 'Datenbanken', 'Springer', 'Buch', TO_DATE('2005', 'YYYY'), NULL, NULL);



INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (1, 6);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (2, 5);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (3, 4);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (4, 3);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (5, 2);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (6, 1);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (7, 7);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (8, 8);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (9, 9);
INSERT INTO Bibliothek_Objekt_hat_Autor VALUES (10, 10);


	
INSERT INTO Bibliothek_Ausleihhistorie VALUES (1, 333, 1);
INSERT INTO Bibliothek_Ausleihhistorie VALUES (2, 444, 5);
INSERT INTO Bibliothek_Ausleihhistorie VALUES (3, 222, 7);
INSERT INTO Bibliothek_Ausleihhistorie VALUES (4, 333, 7);
INSERT INTO Bibliothek_Ausleihhistorie VALUES (5, 111, 10);
INSERT INTO Bibliothek_Ausleihhistorie VALUES (6, 333, 10);
INSERT INTO Bibliothek_Ausleihhistorie VALUES (7, 444, 9);
INSERT INTO Bibliothek_Ausleihhistorie VALUES (8, 222, 10);

/*zuviel
INSERT INTO Bibliothek_Autor VALUES (6, 'Erlenkötter', 'Helmut');
INSERT INTO Bibliothek_Autor VALUES (5, 'Kafka', 'Franz');
INSERT INTO Bibliothek_Autor VALUES (4, 'Krüger', 'Eberhard');
INSERT INTO Bibliothek_Autor VALUES (3, 'Gerritsen', 'Tess');
INSERT INTO Bibliothek_Autor VALUES (2, 'Malik', 'Fredmund');
INSERT INTO Bibliothek_Autor VALUES (1, 'Emmerich', 'Roland');
*/


