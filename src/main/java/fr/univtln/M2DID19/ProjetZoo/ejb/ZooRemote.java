package fr.univtln.M2DID19.ProjetZoo.ejb;

import javax.ejb.EJBObject;
import javax.ejb.Remote;

@Remote
public interface ZooRemote extends EJBObject {

    public String concatZoo(String nom1,String nom2);
}
