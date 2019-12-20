package fr.univtln.M2DID19.ProjetZoo.vivants;


import fr.univtln.M2DID19.ProjetZoo.annotations.Nom;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class Animal implements Comparable<Animal>{

    @Id
    @GeneratedValue
    private int id;
    @Column(name="nom")
    private String nom;
    @JsonbTransient
    private int id_zoo;
    @JsonbTransient
    private Faune faune;


    @Override
    public String toString() {
        return "mon id est " + this.getId() + " mon nom est " + this.nom + ", et je suis un animal, ";
    }

    @Override
    public int compareTo(Animal animal) {
        if (this.getClass()==animal.getClass() && this.getId()==animal.getId())
            return 1;
        return 0;
    }
    @Nom
    public String getNom() {
        return nom;
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