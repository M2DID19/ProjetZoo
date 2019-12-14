package fr.univtln.M2DID19.ProjetZoo.Jsf;
import fr.univtln.M2DID19.ProjetZoo.ejb.GestionAigle;
import fr.univtln.M2DID19.ProjetZoo.vivant.Aigle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("ControleurAigle")
@RequestScoped
public class ControleurAigle implements Serializable {
    @EJB GestionAigle gestionAigle;

    private List<Aigle> liste;

    @PostConstruct
    public void init() {
        liste = gestionAigle.findAllAigle();
    }

    public List<Aigle> getListe() {
        return liste;
    }
}
