package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.dao.DAO;
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

    public void createAigle(Aigle aigle) {
        dao.create(aigle);
    }

    public Aigle findAigle(int idAigle) {
        Aigle aigleFind;
        aigleFind = (Aigle) dao.find(Aigle.class, idAigle);
        return aigleFind;
    }


    public void updateAigle(Aigle aigle) {
        try {
            dao.update(aigle);
        }catch(Exception e){
            e.getStackTrace();
        }
    }


    public void deleteAigle(int idAigle) {
        Aigle aigleFind;
        try {
            aigleFind = dao.findAigle(idAigle);
            dao.delete(aigleFind);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public List<Aigle> findAllAigle() {
        return  dao.findWithNamedQuery("findAllAigle");
    }

    public Aigle findAigleByName(String name) {
        return  dao.findAigleByName(name);
    }

}
