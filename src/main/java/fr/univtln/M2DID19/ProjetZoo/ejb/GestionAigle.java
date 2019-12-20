package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

//@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
@LocalBean
public class GestionAigle implements GestionAigleLocal,Serializable {

    @Inject private DAO dao;

    public void createAigle(Aigle aigle){
        dao.create(aigle);
    }

    public Aigle findAigle(int idAigle) {
        Aigle aigleFind = null;
        aigleFind = (Aigle) dao.find(Aigle.class, idAigle);
        return aigleFind;
    }

    public void updateAigle(Aigle aigle){
        try {
            dao.update(aigle);
            System.out.println("after DAO call...");
        }catch(Exception e){
            e.getStackTrace();
        }
    }
    public void deleteAigle(int idAigle){
        Aigle aigleFind=null;
        try {
            aigleFind = dao.findAigle(idAigle);
            dao.delete(aigleFind);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

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

}
