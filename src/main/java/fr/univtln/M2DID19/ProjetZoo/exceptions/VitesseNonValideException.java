package fr.univtln.M2DID19.ProjetZoo.exceptions;

import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

public class VitesseNonValideException extends Exception {
    public VitesseNonValideException(int vitesse){
        System.out.println("la vitesse "+vitesse+" saisie n'est pas valide, une vitesse ne peut pas être une valeur négative, ni superieur a 320km/h ");
    }
    public String getMessage(Aigle aigle){
        return "la vitesse "+aigle.getVitesse()+" saisie n'est pas valide, une vitesse ne peut pas être une valeur négative, ni superieur a 320km/h ";
    }
}
