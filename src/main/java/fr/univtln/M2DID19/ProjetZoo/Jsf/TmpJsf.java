package fr.univtln.M2DID19.ProjetZoo.Jsf;
import fr.univtln.M2DID19.ProjetZoo.ejb.GestionAigle;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("TmpJsf")
@RequestScoped
public class TmpJsf implements Serializable {
    private String message = "CA MARCHE !!!!!";
    @EJB GestionAigle gestionAigle;

    private List<Aigle> liste;

    @PostConstruct
    public void init() {
        System.out.println("????????????????????");
        liste = gestionAigle.findAllAigle();
    }

    public List<Aigle> getListe() {
        return liste;
    }

    public String getMessage() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return message;
    }

    public void setMessage(String string) {
        message = string;
    }
}
