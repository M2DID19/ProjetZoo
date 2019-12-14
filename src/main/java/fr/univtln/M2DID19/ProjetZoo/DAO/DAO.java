package fr.univtln.M2DID19.ProjetZoo.DAO;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import java.util.List;

@TransactionManagement(TransactionManagementType.CONTAINER)
public class DAO<T> implements CrudService{

    @PersistenceContext (unitName = "authors")
    EntityManager em;
    @Override
    public Object create(Object o) {
        try {
            System.out.println(em);
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
    public Object update(Object o) {
        return (Object) em.merge(o);
    }

    @Override
    public void delete(Class type, Object id) {
        Object ref = em.getReference(type, id);
        em.remove(ref);
    }

    @Override
    public List findWithNamedQuery(String queryName) {
        return this.em.createNamedQuery(queryName).getResultList();
    }
}