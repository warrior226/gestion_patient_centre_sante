package com.wendyam_rayaisse.medecinservice.constants;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedecinConstants {

    public MedecinConstants(){

    }
    public static final String  STATUS_201 = "201";
    public static final String  MESSAGE_201 = "Création de compte réussie";
    public static final String  STATUS_200 = "200";
    public static final String  MESSAGE_200 = "Requête traitée avec succès";
    public static final String  STATUS_417 = "417";
    public static final String  MESSAGE_417_UPDATE= "Opération de mise à jour échouée.Vueillez réessayer ou  contactez l'équipe de développement";
    public static final String  MESSAGE_417_DELETE= "Opération de suppression échoué.Vueillez réessayer ou  contactez l'équipe de développement";

        public static String generateMatricule(String nom,String prenom,String specialite){
        String firstPart= nom.toUpperCase().charAt(0)+ LocalDate.now().toString().split("-")[2]+LocalDate.now().toString().split("-")[1]+LocalDate.now().toString().split("-")[0];
        String secondPart= prenom.toUpperCase().charAt(0)+ LocalTime.now().toString().split(":")[0]+LocalTime.now().toString().split(":")[1]+LocalTime.now().toString().split(":")[2].substring(0,2);
        char thirdPart=specialite.toUpperCase().charAt(0);
        return firstPart+secondPart+thirdPart;
    }
}
