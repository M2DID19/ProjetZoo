package fr.univtln.M2DID19.ProjetZoo.DAO;

import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import java.util.List;

@TransactionManagement(TransactionManagementType.CONTAINER)
public class DAO<T> implements CrudService{

//<<<<<<< HEAD
//    @PersistenceContext (unitName = "authors")
//    EntityManager em;
//
//=======
    public DAO() {
        System.out.println("hello i'm in DAO constructor ...");
    }
//>>>>>>> development

    //    @PersistenceContext
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("authors");
//    EntityManager em = emf.createEntityManager();
//    @PersistenceContext private EntityManager em;
//    @PersistenceContext (unitName = "authors")
//    private EntityManager em;
//    EntityTransaction transac = em.getTransaction();
    @PersistenceContext (unitName = "authors")
    EntityManager em;
    @Override
    public Object create(Object o) {
//<<<<<<< HEAD
//        try {
//            System.out.println("alo alo");
//            System.out.println(o);
//            System.out.println(o.getClass());
//            em.persist(o);
//        } catch (ConstraintViolationException e) {
//            System.out.println(e);
//        }
        System.out.println("Hello i'm in create ...");
        try {
            System.out.println("hello i'm in create's try ...");
            System.out.println(em);
            em.persist(o);
            System.out.println("hello i'm after persistence ...");
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

    public Aigle findAigle(int id_aigle){return em.find(Aigle.class,id_aigle);}

//    @Override
//<<<<<<< HEAD
//    public void delete(Class type, Object id) {
//        Object ref = em.getReference(type, id);
//        em.remove(ref);
//    }
//
//    @Override
//    public List findWithNamedQuery(String queryName) {
//        return this.em.createNamedQuery(queryName).getResultList();
//=======
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
//>>>>>>> development
    }
}