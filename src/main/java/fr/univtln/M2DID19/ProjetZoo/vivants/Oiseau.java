package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class Oiseau extends Animal{

    public enum couleur{
        ROUGE,
        JAUNE,
        NOIR,
        GRIS,
        MARON

    }
    @Enumerated(EnumType.STRING)
    @Column(name="couleur")
    private couleur couleur;

    @Override
    public String toString() {
        return super.toString()+"je suis un oiseau, ma couleur est " + getCouleur() + " , ";
    }


}