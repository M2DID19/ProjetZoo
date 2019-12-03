package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@MappedSuperclass
public abstract class Oiseau extends Animal implements Carnivore{

    public enum couleur{
        ROUGE,
        JAUNE,
        NOIR,
        GRIS,

    }
    @Enumerated(EnumType.STRING)
    @Column(name="couleur")
    @NotNull
    private couleur couleur;

    @Override
    public String toString() {
        return super.toString()+", je suis un oiseau, ";
    }



    @Override
    public void manger(@Valid Animal animal) {

    }
}