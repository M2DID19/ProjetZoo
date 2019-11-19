package fr.univtln.M2DID19.ProjetZoo.vivants;

import javax.validation.constraints.Size;

//@Entity
//@Getter
//@Setter
//@Builder
public class Plante {

    //@Id
    //@GeneratedValue
    private int id;

    @Size(min=0, max=50)
    private String name;
}
