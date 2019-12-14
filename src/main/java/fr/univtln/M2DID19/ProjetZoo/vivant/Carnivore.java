package fr.univtln.M2DID19.ProjetZoo.vivant;

import javax.validation.Valid;

public interface Carnivore {

    void manger(@Valid Animal animal);

}