package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;



@Entity
@Getter
@Setter
public class Vache extends Mammifere implements Herbivore{

    @Column(name="nbTache")
    @Positive
    int nbTache;

    public String toString() {
        return super.toString()+"je suis une vache, ";
    }
    @ManyToOne(cascade = CascadeType.ALL)
    private Faune faune;


    @Override
    public void brouter(Plante plante) {

    }
}