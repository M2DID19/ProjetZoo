package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
@LocalBean
public class GestionAigle implements GestionAigleLocal,Serializable {

    @Inject private DAO dao;

    public String communiquer() {
        int a = (int) Math.random() * 25;
        if (a > 18) {
            return "Bonsoir";
        }
        return "Bonjour";
    }


    public  List<Aigle> findAllAigle() {
        return  dao.findWithNamedQuery("findAllAigle");
    }

    public Aigle findAigle() {
        Aigle aigle = new Aigle();
        aigle = (Aigle) dao.find(Aigle.class, 5);
        return aigle;
    }

    public void postAigle(Aigle aigle) {
            dao.create(aigle);

    }

}
