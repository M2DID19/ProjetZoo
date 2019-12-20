package fr.univtln.M2DID19.ProjetZoo.DAO;

import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import java.util.List;

public interface CrudService<T> {
    public T create(T t);
    public T find(Class type,Object id);
    public T update(T t);
//    public void delete(Class type,Object id);
    public void delete(Object o);
//    public void deleteAigle(Aigle aigle);
    public Aigle findAigle(int idAigle);
    public List findWithNamedQuery(String queryName);
    //public boolean nomValide(String nom);
    //public boolean existeDeja(Object o);
//        public List findWithNamedQuery(String queryName,int resultLimit);
//        public List findWithNamedQuery(String namedQueryName, Map parameters);
//        public List findWithNamedQuery(String namedQueryName, Map parameters,int resultLimit);
}