package fr.univtln.M2DID19.ProjetZoo.exceptions;


public class NexistePasException extends Exception {
    public NexistePasException(String nom){
        System.out.println(nom+" n'existe pas ...");
    }
}
