-- Examens
CREATE TABLE IF NOT EXISTS examen (
    examen_id int AUTO_INCREMENT PRIMARY KEY,
    consultation_id int NOT NULL,
    nom_examen TEXT DEFAULT NULL,
    type_examen TEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

