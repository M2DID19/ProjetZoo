package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Valid
public class Vache extends Mammifere{

    @Min(4)
    @Max(4)
    private int nbPattes;

    @NotNull
    public Vache(String nom) {
        super(nom);
    }

    public Vache() {
    }

    public void setNbPattes(int nbPattes) {
        this.nbPattes = nbPattes;
    }

    @Override
    public String toString() {
        return "Je suis "+this.getNom()+", je suis une vache, ";
    }
}
