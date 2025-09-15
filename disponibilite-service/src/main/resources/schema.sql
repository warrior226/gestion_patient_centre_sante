-- Disponibilités des médecins
CREATE TABLE IF NOT EXISTS disponibilite (
    disponibilite_id int AUTO_INCREMENT PRIMARY KEY,
    medecin_id int NOT NULL,
    date_disponibilite DATE NOT NULL,
    heure_debut TIME NOT NULL,
    heure_descente TIME DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );
