-- Relation Patient ↔ Médecin
CREATE TABLE IF NOT EXISTS user (
    user_id int AUTO_INCREMENT PRIMARY KEY,
    patient_id int NOT NULL,
    medecin_id int NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

