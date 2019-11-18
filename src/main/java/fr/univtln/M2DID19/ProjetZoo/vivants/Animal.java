package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Valid
public class Animal {

    @Size(min=1,max=50)
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Animal(String nom) {
        this.nom = nom;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Je suis "+this.nom+", et je suis un animal";
    }
}
