package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.vivant.Aigle;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GestionAigleLocal {

    public String communiquer();
    public List<Aigle> findAllAigle();
}
