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
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

-- Relation Patient ↔ Médecin
CREATE TABLE IF NOT EXISTS users (
    user_id int AUTO_INCREMENT PRIMARY KEY,
    patient_id int NOT NULL,
    medecin_id int NOT NULL,
    created_at DATE NOT NULL,
       updated_at DATE DEFAULT NULL

    );

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

-- Consultations
CREATE TABLE IF NOT EXISTS consultation (
    consultation_id int AUTO_INCREMENT PRIMARY KEY,
    user_id int NOT NULL,
    date_consultation DATE NOT NULL,
    heure_consultation TIME NOT NULL,
    motif_consultation TEXT DEFAULT NULL,
    antecedents_medicaux TEXT DEFAULT NULL,
    antecedents_familiaux TEXT DEFAULT NULL,
    allergies TEXT DEFAULT NULL,
    symptomes TEXT DEFAULT NULL,
    traitement_en_cours TEXT DEFAULT NULL,
    observation TEXT DEFAULT NULL,
    recommandation TEXT DEFAULT NULL,
    date_prochaine_visite DATE DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

-- Prescriptions
CREATE TABLE IF NOT EXISTS prescription (
    prescription_id int AUTO_INCREMENT PRIMARY KEY,
    consultation_id int NOT NULL,
    medicament TEXT DEFAULT NULL,
    posologie TEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

-- Examens
CREATE TABLE IF NOT EXISTS examen (
    examen_id int AUTO_INCREMENT PRIMARY KEY,
    consultation_id int NOT NULL,
    nom_examen TEXT DEFAULT NULL,
    type_examen TEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

-- Resultats
    CREATE TABLE IF NOT EXISTS resultat (
        resultat_id int AUTO_INCREMENT PRIMARY KEY,
        examen_id int NOT NULL,
        resultats TEXT DEFAULT NULL,
        interpretation TEXT DEFAULT NULL,
        resultat_file TEXT DEFAULT NULL,
        created_at DATE NOT NULL,
        updated_at DATE DEFAULT NULL

    );

-- Constantes médicales
CREATE TABLE IF NOT EXISTS constantes (
    constantes_id int AUTO_INCREMENT PRIMARY KEY,
    patient_id int NOT NULL,
    poids VARCHAR(6) DEFAULT NULL,
    taille VARCHAR(5) DEFAULT NULL,
    temperature VARCHAR(50) DEFAULT NULL,
    tension_systolique VARCHAR(50) DEFAULT NULL,
    tension_diastolique VARCHAR(50) DEFAULT NULL,
    frequence_cardiaque VARCHAR(50) DEFAULT NULL,
    frequence_respiratoire VARCHAR(50) DEFAULT NULL,
    groupe_sanguin VARCHAR(10) DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );
