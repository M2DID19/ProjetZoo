package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Positive;



@Entity
@Builder
@Getter
@Setter
public class Vache extends Mammifere implements Herbivore{

    @Column(name="nbTache")
    @Positive
    int nbTache;

    public String toString() {
        return super.toString()+"je suis une vache, ";
    }

//    @Override
//    public int hashCode() {
//
//        return this.getNom().hashCode();
//    }
//
//    public boolean equals(Vache vache) {
//        if (this.getNom()==vache.getNom())
//            return true;
//        return false;
//    }

    @Override
    public void brouter(Plante plante) {

    }
}



