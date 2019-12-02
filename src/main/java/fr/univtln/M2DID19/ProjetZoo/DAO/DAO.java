package fr.univtln.M2DID19.ProjetZoo.DAO;

import javax.persistence.*;
import java.util.List;


public class DAO<T> implements CrudService{

    @PersistenceContext
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("authors");
    EntityManager em = emf.createEntityManager();
//    @PersistenceContext private EntityManager em;
//    @PersistenceContext
//    EntityTransaction transac = em.getTransaction();

    @Override
    public Object create(Object o) {
//        transac.begin();
        em.persist(o);
//        transac.commit();
        return o;
    }

    @Override
    public Object find(Class type, Object id) {
        return (Object) em.find(type, id);
    }

    @Override
    public Object update(Object o) {
        return (Object) em.merge(o);
    }

    @Override
    public void delete(Class type, Object id) {
        Object ref = em.getReference(type, id);
//        transac.begin();
        em.remove(ref);
//        transac.commit();
    }

    @Override
    public List findWithNamedQuery(String queryName) {
        return this.em.createNamedQuery(queryName).getResultList();
    }
}