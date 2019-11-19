package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Valid
public class Lapin extends Mammifere implements Herbivore{


    @Min(4)
    @Max(4)
    private int nbPattes;

    @Override
    public String toString() {
        return super.toString()+"je suis un lapin";

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void brouter(Plante plante) {

    }
}
