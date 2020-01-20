package fr.univtln.M2DID19.ProjetZoo.jsf;

import fr.univtln.M2DID19.ProjetZoo.dao.DAO;
import fr.univtln.M2DID19.ProjetZoo.ejb.GestionAigle;
import fr.univtln.M2DID19.ProjetZoo.exceptions.NomNonValideException;
import fr.univtln.M2DID19.ProjetZoo.exceptions.VitesseNonValideException;
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
import java.io.Serializable;
import java.util.List;

@Named("ControleurAigle")
@ViewScoped
@Getter
@Setter
public class ControleurAigle implements Serializable {
    @EJB GestionAigle gestionAigle;
    @Inject private DAO dao;
    private List<Aigle> listeAigle;
    private Aigle aigle;
    private Oiseau.couleur[] couleurs;
    private static String nom;
    private static String nameSearch;
    private static int id_zoo;
    private static Oiseau.couleur couleur;
    private static int vitesse;
    private static Faune faune;
    Aigle selectedAigle;
    private static Aigle aigleFound;

    public Aigle getAigleFound() {
        return aigleFound;
    }

    public void setAigleFound(Aigle aigleFound) {
        this.aigleFound = aigleFound;
    }

    public String getNameSearch() {
        return nameSearch;
    }

    public void setNameSearch(String nameSearch) {
        ControleurAigle.nameSearch = nameSearch;
    }

    public Aigle getSelectedAigle() {
        return selectedAigle;
    }

    public void setSelectedAigle(Aigle selectedAigle) {
        this.selectedAigle = selectedAigle;
    }

    public Aigle getAigle() {
        return aigle;
    }

    public void setAigle(Aigle aigle) {
        this.aigle = aigle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_zoo() {
        return id_zoo;
    }

    public void setId_zoo(int id_zoo) {
        this.id_zoo = id_zoo;
    }

    public Oiseau.couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Oiseau.couleur couleur) {
        this.couleur = couleur;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    @PostConstruct
    public void init() {
        listeAigle = gestionAigle.findAllAigle();
        couleurs = Oiseau.couleur.values();
    }

    public List<Aigle> getListe() {
        return listeAigle;
    }

    public void ajouterAigle() throws VitesseNonValideException, NomNonValideException{
        aigle=new Aigle(nom,vitesse, couleur,id_zoo);
        gestionAigle.createAigle(aigle);
    }


    public void suppAigle(Aigle aigle){
        listeAigle.remove(aigle);
        gestionAigle.deleteAigle(aigle.getId());
    }


    public void findAigleParNom(){
        aigleFound= gestionAigle.findAigleByName(nameSearch);
    }

}