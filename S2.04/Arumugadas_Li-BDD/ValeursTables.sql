-- Voici les valeurs que nous allons insérées dans les tables, ce sont des exemples.

-- Valeurs pour la table Enseignant


INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Lefort', 'Mathieu');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Girard', 'Sophie');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Lévesque', 'Isabelle');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Côté', 'Simon');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Boucher', 'Caroline');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Tardif', 'Éric');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Pelletier', 'Marie');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Lapointe', 'David');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Gagné', 'Valérie');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Morin', 'Lucie');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Simard', 'Philippe');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Desjardins', 'Isabelle');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Bélanger', 'Martin');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Lauzon', 'Stéphanie');
INSERT INTO enseignant (nom_enseignant, prenom_enseignant) VALUES ('Fournier', 'Jean-François');


-- Valeurs pour la table Etudiant 

INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Tremblay', 'Alex', 12212345, 'Tlaloc');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Gagnon', 'Sophie', 12223456, 'Whaithiri');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Lavoie', 'Simon', 12234567, 'Zeus');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Roy', 'Marie', 12245678, 'Shango');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Bergeron', 'Mathieu', 12256789, 'Indra');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Dupuis', 'Sophia', 12267890, 'Tlaloc');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Lemieux', 'Samuel', 12278901, 'Whaithiri');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Gauthier', 'Julie', 12289012, 'Zeus');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Poirier', 'Philippe', 12290123, 'Shango');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Fortin', 'Emma', 12201234, 'Indra');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Bouchard', 'Gabriel', 12212345, 'Tlaloc');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Morin', 'Clara', 12223456, 'Whaithiri');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Lefebvre', 'Thomas', 12234567, 'Zeus');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Martel', 'Olivia', 12245678, 'Shango');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Girard', 'Noah', 12256789, 'Indra');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Pelletier', 'Léa', 12267890, 'Tlaloc');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Rousseau', 'Félix', 12278901, 'Whaithiri');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Lapointe', 'Eva', 12289012, 'Zeus');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Leclerc', 'Nathan', 12290123, 'Shango');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Deschênes', 'Alice', 12201234, 'Indra');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Caron', 'Jacob', 12212345, 'Tlaloc');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Lemay', 'Sarah', 12223456, 'Whaithiri');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Bertrand', 'Édouard', 12234567, 'Zeus');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Bélanger', 'Liam', 12245678, 'Shango');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Hamel', 'Camille', 12256789, 'Indra');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Leduc', 'Zoé', 12267890, 'Tlaloc');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Fortier', 'Gabrielle', 12278901, 'Whaithiri');
INSERT INTO etudiant (nom_etudiant, prenom_etudiant, nip, groupe) VALUES ('Ouellet', 'Maxime', 12289012, 'Zeus');

-- Valeurs pour la table Matière


INSERT INTO matiere (id_enseignant, nom_matiere) VALUES (1, 'Développement orienté objets');
INSERT INTO matiere (id_enseignant, nom_matiere) VALUES (2, 'Graphes');
INSERT INTO matiere (id_enseignant, nom_matiere) VALUES (3, 'Anglais');
INSERT INTO matiere (id_enseignant, nom_matiere) VALUES (4, 'Développement d''applications avec IHM');
INSERT INTO matiere (id_enseignant, nom_matiere) VALUES (5, 'Communication et fonctionnement bas niveau');
INSERT INTO matiere (id_enseignant, nom_matiere) VALUES (6, 'Introduction aux services réseaux');


-- Valeurs pour la table Contrôle

INSERT INTO controle (id_matiere, controle, date_controle) VALUES
(1, 'Petit contrôle', '2023-05-01'),
(1, 'Contrôle connaissance', '2023-05-10'),
(1, 'Contrôle final', '2023-05-18'),
(2, 'Ataraxy', '2023-05-02'),
(2, 'Contrôle final', '2023-05-12'),
(3, 'Toiec', '2023-05-05'),
(3, 'Examen final', '2023-05-15'),
(4, 'Contrôle 1', '2023-05-08'),
(4, 'Contrôle final', '2023-05-20'),
(5, 'Examen 1', '2023-05-03'),
(5, 'Examen 2', '2023-05-13'),
(6, 'TP', '2023-05-06'),
(6, 'Contrôle final', '2023-05-16');

-- Valeurs pour la table Note

INSERT INTO note (id_etudiant, id_controle, id_matiere, note) VALUES
(1, 1, 1, 15),
(1, 2, 2, 18),
(1, 3, 1, 16),
(1, 4, 2, 13),
(1, 5, 1, 17),
(2, 1, 1, 14),
(2, 2, 2, 16),
(2, 3, 1, 15),
(2, 4, 2, 12),
(2, 5, 1, 14),
(3, 1, 1, 16),
(3, 2, 2, 19),
(3, 3, 1, 17),
(3, 4, 2, 16),
(3, 5, 1, 18),
(4, 1, 1, 12),
(4, 2, 2, 15),
(4, 3, 1, 13),
(4, 4, 2, 14),
(4, 5, 1, 16),
(5, 1, 1, 17),
(5, 2, 2, 14),
(5, 3, 1, 16),
(5, 4, 2, 15),
(5, 5, 1, 13),
(6, 1, 1, 16),
(6, 2, 2, 18),
(6, 3, 1, 17),
(6, 4, 2, 16),
(6, 5, 1, 15),
(7, 1, 1, 13),
(7, 2, 2, 15),
(7, 3, 1, 14),
(7, 4, 2, 13),
(7, 5, 2, 15),
(8, 1, 1, 18),
(8, 2, 2, 16),
(8, 3, 2, 19),
(8, 4, 1, 17),
(8, 5, 1, 16),
(9, 1, 2, 15),
(9, 2, 1, 17),
(9, 3, 2, 15),
(9, 4, 1, 14),
(9, 5, 1, 16),
(10, 1,2, 17),
(10, 2, 1, 16),
(10, 3, 1, 18),
(10, 4, 2, 17),
(10, 5, 1, 19),



