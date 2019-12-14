package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Builder;
import lombok.Getter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
//@Builder
@Entity
@Table(name = "faune")
public class Faune {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @JsonbTransient
    private int id;

    @OneToMany(mappedBy = "faune")
    private List<Lapin> lapinL;
    @OneToMany(mappedBy = "faune")
    private List<Aigle> aigleL;
    @OneToMany(mappedBy = "faune")
    private List<Vache> vacheL;


    @JsonbTransient
    private static List<Animal> faune=new ArrayList();


    public int ajouterAnimal(Animal animal){
        if(!faune.contains(animal))
        {faune.add(animal);
        animal.setFaune(this);
            return 1;
        }
        return 0;
    }
    public void afficherFaune(){
        Iterator iteratorZoo=faune.iterator();
        while(iteratorZoo.hasNext()){
            System.out.println(iteratorZoo.next().toString());
        }
    }

    @Override
    public String toString() {
        return id + "";
    }
}