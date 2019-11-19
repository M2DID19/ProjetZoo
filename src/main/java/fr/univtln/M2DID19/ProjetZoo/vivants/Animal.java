package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
public abstract class Animal implements Comparable<Animal>{

    @Column(name="nom")
    @Size(min = 1,max = 50)
    private String nom;

    @Override
    public String toString() {
        return "mon nom est "+this.nom+", et je suis un animal, ";
    }

    @Override
    public int compareTo(Animal animal) {
        if (this.getClass()==animal.getClass() && this.nom==animal.nom)
            return 1;
        return 0;
    }


}