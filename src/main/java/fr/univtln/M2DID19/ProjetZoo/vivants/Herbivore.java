package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;

public interface Herbivore {


    void brouter(@Valid Plante plante);

}