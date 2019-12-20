package fr.univtln.M2DID19.ProjetZoo.vivants;

import fr.univtln.M2DID19.ProjetZoo.exceptions.NomNonValideException;
import fr.univtln.M2DID19.ProjetZoo.exceptions.VitesseNonValideException;
import lombok.Getter;
import lombok.Setter;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="Aigle")
//@Builder
@Getter
@Setter
@NamedQuery(name = "findAllAigle", query = "SELECT a from Aigle a")
public class Aigle extends Oiseau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "vitesse")
    private int vitesse;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonbTransient
    private Faune faune;

    @Override
    public String toString() {
        return super.toString() + "je suis un aigle";
    }

    public Aigle() {
    }

    public Aigle(String nom,int vitesse, Oiseau.couleur couleur,int id_zoo) throws NomNonValideException,VitesseNonValideException{
        if(vitesse<0 || vitesse>320)
            throw new VitesseNonValideException(vitesse);
    this.setNom(nom);
    this.setId_zoo(id_zoo);
    this.setVitesse(vitesse);
    this.setCouleur(couleur);

    ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
    Validator validator=factory.getValidator();
    Set<ConstraintViolation<Aigle>> constraintViolations=validator.validate(this);

    if (constraintViolations.size() > 0 ) {
        System.out.println("impossible de valider les données de l'aigle  ...");
        throw new NomNonValideException(nom);
        } else {
            System.out.println("Les données de l'aigle sont valides ... ");
        }
    }

}