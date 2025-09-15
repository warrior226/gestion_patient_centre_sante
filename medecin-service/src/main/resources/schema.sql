-- Medecins
CREATE TABLE IF NOT EXISTS medecin (
    medecin_id int AUTO_INCREMENT PRIMARY KEY,
    matricule VARCHAR(25) NOT NULL UNIQUE,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255)  DEFAULT NULL UNIQUE,
    adresse VARCHAR(255) DEFAULT NULL,
    contact VARCHAR(255) DEFAULT NULL,
    date_naissance DATE DEFAULT NULL,
    genre VARCHAR(6) DEFAULT NULL CHECK (genre IN ('M', 'F')),
    specialite VARCHAR(255) NOT NULL,
    password TEXT NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );
