package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Valid
public class Aigle extends Oiseau{


    @Override
    public String toString() {
            return super.toString()+"je suis un aigle";

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
