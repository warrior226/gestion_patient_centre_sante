-- Rendez-vous
CREATE TABLE IF NOT EXISTS rdv(
    rdv_id int AUTO_INCREMENT PRIMARY KEY,
    user_id int NOT NULL,
    date_rdv DATE NOT NULL,
    heure_rdv TIME NOT NULL,
    motif_consultation VARCHAR(255) DEFAULT NULL,
    status VARCHAR(10) DEFAULT NULL CHECK (status IN ('en_cours','confirme', 'annule')),
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );
