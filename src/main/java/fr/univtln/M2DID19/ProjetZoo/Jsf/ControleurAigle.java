package fr.univtln.M2DID19.ProjetZoo.Jsf;
import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.ejb.GestionAigle;
import fr.univtln.M2DID19.ProjetZoo.structures.Zoo;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;
import fr.univtln.M2DID19.ProjetZoo.vivants.Faune;
import fr.univtln.M2DID19.ProjetZoo.vivants.Oiseau;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named("ControleurAigle")
@ViewScoped
@Getter
@Setter
public class ControleurAigle implements Serializable {
    @EJB GestionAigle gestionAigle;
    @Inject private DAO dao;
    private List<Aigle> liste;

    //////////////////////////////////////////////////////////////////////

    private ArrayList<enumCouleur> allCouleurs;

    private  enumCouleur[] couleurs;

    //////////////////////////////////////////////////////////////////////

    private String nom;
    private Zoo zoo;
    private Faune faune;


    public enum enumCouleur {
        ROUGE,
        JAUNE,
        NOIR,
        GRIS,

//        @Override
//        public boolean equals(Object object) {
//            if (object instanceof String)
//                object = enumCouleur.valueOf((String)object);
//            return super.equals(object);
//        }
    }
    @Enumerated(EnumType.STRING)
    @NotNull
    private Oiseau.couleur couleur;

    private int vitesse;

    //////////////////////////////////////////////////////////////////////


    @PostConstruct
    public void init() {
        liste = gestionAigle.findAllAigle();

        allCouleurs = new ArrayList<>();
        for (enumCouleur c: enumCouleur.values() ) {
            allCouleurs.add(c);
        }

        couleurs = enumCouleur.values();
        System.out.println("AAAAAAAAAAAAAAAAa " + Arrays.toString(couleurs));
        System.out.println("BBBBBBBBBBBBBBBBB " + couleurs[0].getClass());
    }

    public List<Aigle> getListe() {
        return liste;
    }

    public void ajouterAigle() {
        Aigle aigle = new Aigle();
        aigle.setNom(nom);
        aigle.setCouleur(couleur);
        aigle.setVitesse(vitesse);
        aigle.setFaune(faune);
        aigle.setId_zoo(zoo.getId_zoo());
        System.out.println("l'aige est: " + aigle);
        gestionAigle.createAigle(aigle);
    }
}
