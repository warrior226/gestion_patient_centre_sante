-- Patients
CREATE TABLE IF NOT EXISTS patient (
    patient_id  int AUTO_INCREMENT PRIMARY KEY ,
    matricule VARCHAR(25) NOT NULL, --JJ-MM-AA-MinMin-SecSec-MillisecMillisec
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE DEFAULT NULL,
    adresse VARCHAR(255) DEFAULT NULL,
    contact VARCHAR(255) DEFAULT NULL,
    date_naissance DATE DEFAULT NULL,
    genre VARCHAR(6) DEFAULT NULL CHECK (genre IN ('M', 'F', 'Autre')),
    profession VARCHAR(255) DEFAULT NULL,
    password TEXT NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

-- Medecins
CREATE TABLE IF NOT EXISTS medecin (
    medecin_id UUID PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE DEFAULT NULL,
    adresse VARCHAR(255) DEFAULT NULL,
    contact VARCHAR(255) DEFAULT NULL,
    date_naissance DATE DEFAULT NULL,
    genre VARCHAR(6) DEFAULT NULL CHECK (genre IN ('M', 'F', 'Autre')),
    specialite VARCHAR(255) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

-- Relation Patient ↔ Médecin
CREATE TABLE IF NOT EXISTS user (
    user_id UUID PRIMARY KEY,
    patient_id UUID NOT NULL,
    medecin_id UUID NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id) ON DELETE CASCADE,
    FOREIGN KEY (medecin_id) REFERENCES medecin(medecin_id) ON DELETE CASCADE
    );

-- Disponibilités des médecins
CREATE TABLE IF NOT EXISTS disponibilite (
    disponibilite_id UUID PRIMARY KEY,
    medecin_id UUID NOT NULL,
    date_disponibilite DATE NOT NULL,
    heure_debut TIME NOT NULL,
    heure_descente TIME DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (medecin_id) REFERENCES medecin(medecin_id) ON DELETE CASCADE
    );

-- Rendez-vous
CREATE TABLE IF NOT EXISTS rdv(
    rdv_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    date_rdv DATE NOT NULL,
    heure_rdv TIME NOT NULL,
    motif_consultation VARCHAR(255) DEFAULT NULL,
    status VARCHAR(10) DEFAULT NULL CHECK (status IN ('planifie', 'confirme', 'annule', 'termine')),
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
    );

-- Consultations
CREATE TABLE IF NOT EXISTS consultation (
    consultation_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
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
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
    );

-- Prescriptions
CREATE TABLE IF NOT EXISTS prescription (
    prescription_id UUID PRIMARY KEY,
    consultation_id UUID NOT NULL,
    medicament TEXT DEFAULT NULL,
    posologie TEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (consultation_id) REFERENCES consultation(consultation_id) ON DELETE CASCADE
    );

-- Examens
CREATE TABLE IF NOT EXISTS examen (
    examen_id UUID PRIMARY KEY,
    consultation_id UUID NOT NULL,
    nom_examen TEXT DEFAULT NULL,
    type_examen TEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (consultation_id) REFERENCES consultation(consultation_id) ON DELETE CASCADE
    );

-- Resultats
    CREATE TABLE IF NOT EXISTS resultat (
        resultat_id UUID PRIMARY KEY,
        examen_id UUID NOT NULL,
        resultats TEXT DEFAULT NULL,
        interpretation TEXT DEFAULT NULL,
        resultat_file TEXT DEFAULT NULL,
        created_at DATE NOT NULL,
        updated_at DATE DEFAULT NULL,
        FOREIGN KEY (examen_id) REFERENCES examen(examen_id) ON DELETE CASCADE

    )

-- Constantes médicales
CREATE TABLE IF NOT EXISTS constantes (
    constantes_id UUID PRIMARY KEY,
    patient_id UUID NOT NULL,
    poids VARCHAR(6) DEFAULT NULL,
    taille VARCHAR(5) DEFAULT NULL,
    temperature VARCHAR(50) DEFAULT NULL,
    tension_systolique VARCHAR(50) DEFAULT NULL,
    tension_diastolique VARCHAR(50) DEFAULT NULL,
    frequence_cardiaque VARCHAR(50) DEFAULT NULL,
    frequence_respiratoire VARCHAR(50) DEFAULT NULL,
    groupe_sanguin VARCHAR(10) DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL,
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id) ON DELETE CASCADE
    );
