package fr.univtln.M2DID19.ProjetZoo.exceptions;

public class NomNonValideException extends Exception {

    public NomNonValideException(String nom){
        System.out.println("le nom : "+nom+" n'est pas valide, le nom doit avoir une taille superieur à 4, ne doit pas comporter de chiffres ou de caracteres speciaux ...");
    }

}
