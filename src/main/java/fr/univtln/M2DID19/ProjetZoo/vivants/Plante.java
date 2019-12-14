package fr.univtln.M2DID19.ProjetZoo.vivants;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
//@Builder
public class Plante {

    @Id
    private int id;

    @Size(min=0, max=50)
    private String name;
}