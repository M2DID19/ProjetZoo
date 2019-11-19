package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@Builder
@Getter
@Setter
public class Aigle extends Oiseau{

    @Column(name="vitesse")
    @Min(0)
    private int vitesse;

    @Override
    public String toString() {
        return super.toString()+", je suis un aigle";

    }

    @Override
    public int hashCode() {

        return this.getNom().hashCode();
    }

    public boolean equals(Aigle aigle) {
        if (this.getNom()==aigle.getNom())
            return true;
        return false;
    }
}