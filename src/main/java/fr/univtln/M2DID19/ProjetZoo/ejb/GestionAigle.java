package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.Annotation.Test;
import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import javax.transaction.*;
import java.util.List;

@Stateless(mappedName = "Aigle")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionAigle implements GestionAigleLocal {

//    @Inject DAO dao;
    DAO dao2 = new DAO();
//    @Resource private UserTransaction transaction;

    public String communiquer() {
        int a = (int) Math.random() * 25;
        if (a > 18) {
            return "Bonsoir";
        }
        return "Bonjour";
    }


//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  List<Aigle> findAllAigle() {
//        @Resource private UserTransaction transaction;
//        transaction.begin();
//        List<Aigle> liste = dao2.findWithNamedQuery("findAllAigle");
//        dao2.find(Aigle.class, 5);
//        transaction.commit();
//        System.out.println("HALLO2" + dao);
        List<Aigle> liste = dao2.findWithNamedQuery("findAllAigle");
        @Test(value=Test.Case.UPPER)
        String nom = liste.get(0).getNom();

        return liste;
//        return  dao2.findWithNamedQuery("findAllAigle");
    }

    public Aigle findAigle() {
        Aigle aigle = new Aigle();
        aigle = (Aigle) dao2.find(Aigle.class, 5);
        return aigle;
    }

}
