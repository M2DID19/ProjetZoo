package fr.univtln.M2DID19.ProjetZoo.vivants;

public class Oiseau extends Animal {

    public Oiseau(String nom) {
        super(nom);
    }

    public Oiseau() {
    }

    @Override
    public String toString() {
        return super.toString()+"je suis un oiseau, ";
    }
}
