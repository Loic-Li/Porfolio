
-- Cette vue permet de voir la note selon le type d’utilisateur : 

CREATE VIEW vue_notes_etudiant AS 
SELECT * FROM note 
JOIN controle ON note.id_controle = controle.id_controle 
WHERE note.id_etudiant = current_user; 


-- Cette fonction permet à entrer des notes pour l’enseignant en particulier mais l’administrateur a aussi ces permissions 

CREATE OR REPLACE FUNCTION saisir_note (id_etudiant int, id_controle int, id_matiere int, note FLOAT)  
RETURNS VOID AS $$ 
BEGIN 
INSERT INTO note (id_etudiant, id_controle, id_matiere, note)	VALUES ($1, $2, $3, $4); 
END; 
$$ language plpgsql SECURITY DEFINER;


