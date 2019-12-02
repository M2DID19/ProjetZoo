package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless(mappedName = "Aigle")
public class GestionAigle implements GestionAigleLocal {

//    @Inject DAO dao;

    public String communiquer() {
        int a = (int) Math.random() * 25;
        if (a > 18) {
            return "Bonsoir";
        }
        return "Bonjour";
    }

//    public String findAllAigle() {
//        List<Aigle> liste = dao.findWithNamedQuery("findAllAigle");
//        return "got it";
//    }

}
