package fr.univtln.M2DID19.ProjetZoo.structures;

import fr.univtln.M2DID19.ProjetZoo.vivant.Animal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Getter @Setter

    private String nom;

    @Setter @Getter
    @Transient
    private List<Animal> zooL=new ArrayList();

    public int ajouterAnimal(Animal animal){
        if(this.zooL.contains(animal))
            return 0;
        this.zooL.add(animal);
        animal.setZoo(this);
        return 1;
    }

    public void afficheToi(){
        System.out.println("Affichage de "+this.getNom()+ "....");
        Iterator iteratorAnimaux=this.zooL.iterator();
        while(iteratorAnimaux.hasNext()){
            System.out.println(iteratorAnimaux.next().toString());
        }
    }

    @Override
    public String toString() {
        return this.getNom();
    }
}
