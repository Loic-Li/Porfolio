

    CREATE TABLE enseignant (
        id_enseignant SERIAL PRIMARY KEY,
        nom_enseignant VARCHAR NOT NULL,
        prenom_enseignant VARCHAR NOT NULL);

    CREATE TABLE etudiant (
        id_etudiant SERIAL PRIMARY KEY ,
        nom_etudiant VARCHAR NOT NULL,
        prenom_etudiant VARCHAR NOT NULL,
        nip INTEGER NOT NULL CHECK (nip >= 12200000 AND nip <= 12299999),
        groupe VARCHAR NOT NULL
    );

    CREATE TABLE matiere (
        id_matiere SERIAL PRIMARY KEY,
        id_enseignant INTEGER REFERENCES enseignant(id_enseignant),
        nom_matiere VARCHAR NOT NULL
    );

    CREATE TABLE controle (
        id_controle SERIAL PRIMARY KEY,
        id_matiere INTEGER REFERENCES matiere(id_matiere),
        controle VARCHAR NOT NULL,
        date_controle DATE NOT NULL
    );

    CREATE TABLE note (
    id_etudiant INTEGER REFERENCES etudiant(id_etudiant),
    id_controle INTEGER REFERENCES controle(id_controle),
    id_matiere INTEGER REFERENCES matiere(id_matiere),
        note FLOAT NOT NULL
    );


