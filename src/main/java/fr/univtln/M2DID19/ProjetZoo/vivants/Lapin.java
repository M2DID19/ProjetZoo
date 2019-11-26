package fr.univtln.M2DID19.ProjetZoo.vivants;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Positive;


@Entity
//@Builder
@Getter
@Setter
public class Lapin extends Mammifere implements Herbivore{


    @Column(name="longueurOreille")
    @Positive
    private int longueurOreille;

    @Override
    public String toString() {
        return super.toString()+"je suis un lapin";

    }

//    @Override
//    public int hashCode() {
//
//        return this.getNom().hashCode();
//    }
//    public boolean equals(Lapin lapin) {
//        if (this.getNom()==lapin.getNom())
//            return true;
//        return false;
//    }

    @Override
    public void brouter(Plante plante) {

    }
}