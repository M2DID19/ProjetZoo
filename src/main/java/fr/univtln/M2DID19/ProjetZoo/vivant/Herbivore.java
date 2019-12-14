package fr.univtln.M2DID19.ProjetZoo.vivant;

import javax.validation.Valid;

public interface Herbivore {


    void brouter(@Valid Plante plante);

}