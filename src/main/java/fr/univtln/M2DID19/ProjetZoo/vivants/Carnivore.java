package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.Valid;

public interface Carnivore {

    void manger(@Valid Animal animal);

}