package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Valid
public class Mammifere extends Animal{

    @Size(min=0, max=50)
    public Mammifere(String nom) {
        super(nom);
    }

    public Mammifere() {
    }

    @Override
    public String toString() {
        return super.toString()+"je suis un mammifere, ";
    }
}
