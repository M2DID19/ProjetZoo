package fr.univtln.M2DID19.ProjetZoo.ejb;

import javax.ejb.Local;

@Local
public interface ZooLocal {

    public String concatZoo(String nom1,String nom2);
}
