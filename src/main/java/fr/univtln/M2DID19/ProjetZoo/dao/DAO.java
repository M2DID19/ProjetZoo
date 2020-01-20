package fr.univtln.M2DID19.ProjetZoo.dao;

import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import java.util.List;

@TransactionManagement(TransactionManagementType.CONTAINER)
public class DAO<T> implements CrudService{
    public DAO() {
    }

    @PersistenceContext (unitName = "authors")
    EntityManager em;
    @Override
    public Object create(Object o) {
        try {
            em.persist(o);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }

        return o;
    }

    @Override
    public Object find(Class type, Object id) {
        return (Object) em.find(type, id);
    }

    @Override
    public Object update(Object o) { return (Object) em.merge(o); }


    @Override
    public void delete(Object o){
        em.remove(o);
    }

    public Aigle findAigle(int id_aigle) {return em.find(Aigle.class,id_aigle);}

    public Aigle findAigleByName(String name){
        Aigle aigleFound=null;
        try {
            Query query = em.createQuery("SELECT aigle FROM Aigle aigle WHERE aigle.nom LIKE '" + name + "'");
            aigleFound= (Aigle) query.getSingleResult();
        } catch(Exception e){e.getStackTrace();}
        return aigleFound;
    }

    public List findWithNamedQuery(String queryName) {
        return this.em.createNamedQuery(queryName).getResultList();
    }

    public static boolean nomValide(String nom) {
        if(nom.length()<4 || nom.length()>20)
            return false;
        for (char c : nom.toCharArray()) {
            if (!Character.isLetter(c))
                return false;
        }return true;
    }

    public boolean existeDeja(int idAigle) {
        Aigle aigleFounded=findAigle(idAigle);
        if(aigleFounded==null)
            return true;
        return false;
    }
}