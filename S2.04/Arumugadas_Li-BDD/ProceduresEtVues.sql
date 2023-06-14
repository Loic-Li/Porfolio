
-- Voici des procédures et des vues qui vont nous permettre d'accéder à ces tables 


-----------------------------------------------------------------------------------------------------------------------

-- Sélectionner les notes des étudiants dans une matière précise sur un contrôle en particulier 

CREATE OR REPLACE FUNCTION notes_matiere_controle(p_nom_matiere VARCHAR,
p_nom_controle VARCHAR)
RETURNS TABLE (id_etudiant INTEGER, nom_etudiant VARCHAR, prenom_etudiant VARCHAR,
note FLOAT, controle VARCHAR, date_controle DATE)
AS $$
BEGIN
 RETURN QUERY
 SELECT e.id_etudiant, e.nom_etudiant, e.prenom_etudiant, n.note, c.controle, c.date_controle
 FROM etudiant e
 JOIN note n ON e.id_etudiant = n.id_etudiant
 JOIN controle c ON n.id_controle = c.id_controle
 JOIN matiere m ON c.id_matiere = m.id_matiere
 WHERE m.nom_matiere = p_nom_matiere AND c.controle = p_nom_controle;
END;
$$ LANGUAGE plpgsql;


-- SELECT * FROM notes_matiere_controle(<nom_matière>, <nom_controle>);

-----------------------------------------------------------------------------------------------------------------------


-- Classement des moyennes générales des étudiants  

CREATE VIEW moyenne_generale_etudiant AS
SELECT e.id_etudiant, AVG(note) AS moyenne_generale
FROM etudiant e
JOIN note n ON e.id_etudiant = n.id_etudiant
GROUP BY e.id_etudiant
ORDER BY moyenne_generale DESC;

-- SELECT * FROM moyenne_generale_etudiant;


-----------------------------------------------------------------------------------------------------------------------


-- La moyenne d’un étudiant pour chacune des matières 


CREATE OR REPLACE FUNCTION calculer_moyenne_etudiant_par_matiere(etudiant_id INTEGER)
RETURNS TABLE (id_etudiant INTEGER, nom_etudiant VARCHAR, prenom_etudiant VARCHAR, nom_matiere VARCHAR, moyenne FLOAT) AS $$
DECLARE
    result RECORD;
BEGIN
    FOR result IN
        SELECT e.id_etudiant, e.nom_etudiant, e.prenom_etudiant, m.nom_matiere, AVG(n.note) AS moyenne
        FROM etudiant e
        JOIN note n ON e.id_etudiant = n.id_etudiant
        JOIN matiere m ON n.id_matiere = m.id_matiere
        WHERE e.id_etudiant = etudiant_id
        GROUP BY e.id_etudiant, e.nom_etudiant, e.prenom_etudiant, m.nom_matiere
    LOOP
        id_etudiant := result.id_etudiant;
        nom_etudiant := result.nom_etudiant;
        prenom_etudiant := result.prenom_etudiant;
        nom_matiere := result.nom_matiere;
        moyenne := result.moyenne;
        RETURN NEXT;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE plpgsql;

-- SELECT * FROM calculer_moyenne_etudiant_pour_matiere(<id_etudiant);

-----------------------------------------------------------------------------------------------------------------------


-- La moyenne de chaque groupe classé  

CREATE OR REPLACE VIEW moyenne_groupe AS
SELECT e.groupe, AVG(n.note) AS moyenne
FROM etudiant e
JOIN note n ON e.id_etudiant = n.id_etudiant
GROUP BY e.groupe
ORDER BY moyenne DESC;

--SELECT * FROM moyenne_groupe;

-----------------------------------------------------------------------------------------------------------------------

-- Statistiques de chaque matière(moyenne des étudiants dans une matière, avec la note maximale et minimale) 


CREATE OR REPLACE VIEW moyennes_notes_par_matieres AS
SELECT m.id_matiere, m.nom_matiere, AVG(n.note) AS moyenne_matiere, MAX(n.note) AS
note_max_matiere, MIN(n.note) AS note_min_matiere
FROM note n
JOIN matiere m ON n.id_matiere = m.id_matiere
GROUP BY m.id_matiere, m.nom_matiere;


-- SELECT * FROM moyennes_notes_matieres;

-----------------------------------------------------------------------------------------------------------------------

