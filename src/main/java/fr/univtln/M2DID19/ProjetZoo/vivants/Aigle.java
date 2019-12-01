package fr.univtln.M2DID19.ProjetZoo.vivants;

//import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.Min;
import java.io.Serializable;


@Entity
@Table(name="Aigle")
//@Builder
@Getter
@Setter
@NamedQuery(name = "findAllAigle", query = "SELECT a from Aigle a")
public class Aigle extends Oiseau implements Serializable {

    @Column(name="vitesse")
    @Min(0)
    private int vitesse;

    @Override
    public String toString() {
        return super.toString()+", je suis un aigle";

    }
    @ManyToOne(cascade = CascadeType.ALL)
    private Faune faune;


//    @Override
//    public int hashCode() {
//
//        return this.getNom().hashCode();
//    }
//
//    public boolean equals(Aigle aigle) {
//        if (this.getNom()==aigle.getNom())
//            return true;
//        return false;
//    }
}