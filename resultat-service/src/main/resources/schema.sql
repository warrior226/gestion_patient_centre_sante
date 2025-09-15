-- Resultats
    CREATE TABLE IF NOT EXISTS resultat (
        resultat_id int AUTO_INCREMENT PRIMARY KEY,
        examen_id int NOT NULL,
        resultat TEXT DEFAULT NULL,
        interpretation TEXT DEFAULT NULL,
        resultat_file_path TEXT DEFAULT NULL,
        created_at DATE NOT NULL,
        updated_at DATE DEFAULT NULL

    );
