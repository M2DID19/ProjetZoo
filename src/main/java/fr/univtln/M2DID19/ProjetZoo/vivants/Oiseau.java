package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter

public abstract class Oiseau extends Animal implements Carnivore{




    @Column(name="couleur")
    @NotNull
    private String couleur;


    @Override
    public String toString() {
        return super.toString()+", je suis un oiseau, ";
    }



    @Override
    public void manger(@Valid Animal animal) {

    }
}
