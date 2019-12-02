package fr.univtln.M2DID19.ProjetZoo.REST;

import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import java.util.List;


public class Tmp {

    DAO dao = new DAO();

    public List<Aigle> getAllAigle2() {
        System.out.println("ggg");
        System.out.println("xx " + dao.findWithNamedQuery("findAllAigle").get(0));
        return dao.findWithNamedQuery("findAllAigle");
    }
}
