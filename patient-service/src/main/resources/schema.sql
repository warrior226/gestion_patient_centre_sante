-- Patients
CREATE TABLE IF NOT EXISTS patient (
    patient_id int AUTO_INCREMENT PRIMARY KEY,
    matricule VARCHAR(25) NOT NULL UNIQUE, -- JJ-MM-AA-MinMin-SecSec-MillisecMillisec
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) DEFAULT NULL UNIQUE,
    adresse VARCHAR(255) DEFAULT NULL,
    contact VARCHAR(255) DEFAULT NULL UNIQUE,
    date_naissance DATE DEFAULT NULL,
    genre VARCHAR(6) DEFAULT NULL CHECK (genre IN ('M', 'F')),
    profession VARCHAR(255) DEFAULT NULL,
    password TEXT NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
);
