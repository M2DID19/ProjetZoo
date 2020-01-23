package fr.univtln.M2DID19.ProjetZoo.vivants;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Getter
@Setter
@NamedQuery(name = "findAllPlante", query = "SELECT p from Plante p")
public class Plante {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("_rev")
    private String rev;

    private String name;
    private String famille;
    private String nbFeuilles;

    @Override
    public String toString() {
        return "Plante{" +
                "id='" + id + '\'' +
                ", rev='" + rev + '\'' +
                ", name='" + name + '\'' +
                ", famille='" + famille + '\'' +
                ", nbFeuilles='" + nbFeuilles + '\'' +
                '}';
    }
}