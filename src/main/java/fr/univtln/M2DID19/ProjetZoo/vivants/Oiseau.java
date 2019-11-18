package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Valid
public class Oiseau extends Animal {

    @Min(2)
    @Max(2)
    private int nbPattes;

    @Min(2)
    @Max(2)
    private int nbAiless;


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
