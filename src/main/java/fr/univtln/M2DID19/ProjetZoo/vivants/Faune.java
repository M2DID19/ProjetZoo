package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
//@Builder
public class Faune {

    @Id
    @GeneratedValue
    private int id;

    public static List<Animal> faune=new ArrayList();

    public int ajouterAnimal(Animal animal){
        if(!faune.contains(animal))
        {faune.add(animal);
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

}
