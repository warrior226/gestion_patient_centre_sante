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

