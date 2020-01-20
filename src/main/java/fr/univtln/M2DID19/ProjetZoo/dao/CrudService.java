package fr.univtln.M2DID19.ProjetZoo.dao;

import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;
import java.util.List;

public interface CrudService<T> {
    public T create(T t);
    public T find(Class type,Object id);
    public T update(T t);
    public void delete(Object o);
    public Aigle findAigle(int idAigle);
    public List findWithNamedQuery(String queryName);
//        public List findWithNamedQuery(String queryName,int resultLimit);
//        public List findWithNamedQuery(String namedQueryName, Map parameters);
//        public List findWithNamedQuery(String namedQueryName, Map parameters,int resultLimit);
}