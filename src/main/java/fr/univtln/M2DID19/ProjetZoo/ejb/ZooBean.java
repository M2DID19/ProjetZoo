package fr.univtln.M2DID19.ProjetZoo.ejb;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.rmi.RemoteException;

@Stateless
public class ZooBean implements ZooLocal,ZooRemote {

    public String hello(String nom){
        return "hello "+nom+" ...";
    }

    @PersistenceContext
    private EntityManager em;


    @Override
    public String concatZoo(String nom1, String nom2) {
        return nom1+nom2;
    }

    @Override
    public EJBHome getEJBHome() throws RemoteException {
        return null;
    }

    @Override
    public Object getPrimaryKey() throws RemoteException {
        return null;
    }

    @Override
    public void remove() throws RemoteException, RemoveException {

    }

    @Override
    public Handle getHandle() throws RemoteException {
        return null;
    }

    @Override
    public boolean isIdentical(EJBObject ejbObject) throws RemoteException {
        return false;
    }
}
