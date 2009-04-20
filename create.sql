CREATE TABLE Bibliothek_Autor (
	Id NUMBER NOT NULL,
	Nachname VARCHAR2(40) NOT NULL,
	Vorname VARCHAR2(40) NOT NULL,
	CONSTRAINT PK_Bibliothek_Autor PRIMARY KEY (ID) 
);


CREATE TABLE Bibliothek_Einrichtungen (
    Ausweisnr NUMBER NOT NULL,
    E_Name VARCHAR2(40) NOT NULL,
    oeffentliche_E NUMBER DEFAULT 0 NOT NULL,
    AnzahlAusgeliehen NUMBER DEFAULT 0 NOT NULL,
    CONSTRAINT PK_Bibliothek_Einrichtungen PRIMARY KEY (Ausweisnr),
    CONSTRAINT Anz_Ausl_Einr CHECK ((oeffentliche_E=0 and AnzahlAusgeliehen<=25) or
                                    (oeffentliche_E=1 and AnzahlAusgeliehen<=50))
);


CREATE TABLE Bibliothek_Personen (
	Ausweisnr NUMBER NOT NULL,
	P_Name VARCHAR2(40) NOT NULL,
	Einr_Ausweisnr NUMBER NULL,
	AnzahlAusgeliehen NUMBER DEFAULT 0 NOT NULL
	CONSTRAINT Anz_Ausl_Person CHECK (AnzahlAusgeliehen<=5),
	CONSTRAINT PK_Bibliothek_Personen PRIMARY KEY (Ausweisnr),
	CONSTRAINT Einrichtung_hat_person FOREIGN KEY (Einr_Ausweisnr)
		REFERENCES Bibliothek_Einrichtungen
);


CREATE TABLE Bibliothek_Objekt (
	Inventarnr NUMBER NOT NULL,
	Titel VARCHAR2(40) NOT NULL,
	Verlag VARCHAR2(40) NOT NULL,
	Typ VARCHAR2(40) NOT NULL
	CONSTRAINT CHK_typ CHECK (typ in ('Buch','Zeitschrift','Hörbuch')),
	Erscheinungsjahr Date,
	P_Ausweisnr NUMBER NULL,
	E_Ausweisnr NUMBER NULL,
	CONSTRAINT PK_Bibliothek_Objekt PRIMARY KEY (Inventarnr),
	CONSTRAINT Einrichtung_leiht_objekt FOREIGN KEY (E_Ausweisnr)
		REFERENCES Bibliothek_Einrichtungen,
	CONSTRAINT Person_leiht_objekt FOREIGN KEY (P_Ausweisnr)
		REFERENCES Bibliothek_Personen,
	CONSTRAINT einmal_verleihbar CHECK (P_Ausweisnr is null or E_Ausweisnr is null)
);


CREATE TABLE Bibliothek_Objekt_hat_Autor (
	ID NUMBER NOT NULL,
	Inventarnr NUMBER NOT NULL,
	CONSTRAINT PK_Bibliothek_Objekt_hat_Autor PRIMARY KEY (ID, Inventarnr),
	CONSTRAINT FK_objekt FOREIGN KEY (Inventarnr) REFERENCES Bibliothek_Objekt,
	CONSTRAINT FK_autor FOREIGN KEY (ID) REFERENCES Bibliothek_Autor
);

CREATE TABLE Bibliothek_Ausleihhistorie (
	Historien_ID NUMBER NOT NULL,
	P_Ausweisnr NUMBER NOT NULL,
	Inventarnr NUMBER NOT NULL,
	CONSTRAINT PK_Bibliothek_Ausleihhistorie PRIMARY KEY (Historien_ID),
	CONSTRAINT Objekt_wurde_verliehen FOREIGN KEY (Inventarnr) REFERENCES Bibliothek_Objekt,
	CONSTRAINT Person_hat_geliehen FOREIGN KEY (P_Ausweisnr) REFERENCES Bibliothek_Personen
);