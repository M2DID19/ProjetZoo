package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@MappedSuperclass
public abstract class Mammifere extends Animal{
    @Column(name="marin")
    boolean marin;

    @Override
    public String toString() {
        return super.toString()+"je suis un mammifere, ";
    }



}