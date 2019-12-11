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
//    DAO dao2 = new DAO();
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("authors");
//    EntityManager em = emf.createEntityManager();
//    @Resource private UserTransaction transaction;
//    @PersistenceUnit (name="authors")
//    EntityManagerFactory emf;
//    @PersistenceContext
//    EntityManager em;

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

        System.out.println("ALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        return  dao.findWithNamedQuery("findAllAigle");
    }

    public Aigle findAigle() {
        Aigle aigle = new Aigle();
        aigle = (Aigle) dao.find(Aigle.class, 5);
        return aigle;
    }

    public void postAigle(Aigle aigle) {
//            transaction.begin();
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBB");
            dao.create(aigle);
//            transaction.commit();

    }

}
