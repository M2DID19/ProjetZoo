package fr.univtln.M2DID19.ProjetZoo.vivants;

import fr.univtln.M2DID19.ProjetZoo.structures.Zoo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Getter
@Setter
public abstract class Animal implements Comparable<Animal>{

    @Id
    @GeneratedValue
    private int id;
    @Column(name="nom")
    @Size(min = 1,max = 50)
    private String nom;

    @Getter
    private Zoo zoo;

    @Override
    public String toString() {
        return "mon nom est "+this.nom+", et je suis un animal, ";
    }

    @Override
    public int compareTo(Animal animal) {
        if (this.getClass()==animal.getClass() && this.getId()==animal.getId())
            return 1;
        return 0;
    }

    public int hashCode() {

        return this.getNom().hashCode();
    }

    public boolean equals(Animal animal) {
        if (this.getId()==animal.getId() /*|| this.getNom()==animal.getNom()*/)
            return true;
        return false;
    }


}