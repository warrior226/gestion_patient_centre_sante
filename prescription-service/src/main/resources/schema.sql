-- Prescriptions
CREATE TABLE IF NOT EXISTS prescription (
    prescription_id int AUTO_INCREMENT PRIMARY KEY,
    consultation_id int NOT NULL,
    medicament TEXT DEFAULT NULL,
    posologie TEXT DEFAULT NULL,
    created_at DATE NOT NULL,
    updated_at DATE DEFAULT NULL
    );

