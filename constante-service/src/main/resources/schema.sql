
-- Constantes médicales
CREATE TABLE IF NOT EXISTS constantes (
    constantes_id int AUTO_INCREMENT PRIMARY KEY,
    patient_id int NOT NULL,
    poids DECIMAL(5,2) DEFAULT NULL,
    taille SMALLINT DEFAULT NULL,
    temperature DECIMAL(4,2)  DEFAULT NULL,
    tension_systolique SMALLINT DEFAULT NULL,
    tension_diastolique SMALLINT DEFAULT NULL,
    frequence_cardiaque SMALLINT DEFAULT NULL,
    frequence_respiratoire SMALLINT DEFAULT NULL,
    groupe_sanguin VARCHAR(10) DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );
