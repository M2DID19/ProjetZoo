package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GestionAigleLocal {

    public List<Aigle> findAllAigle();
    public void createAigle(Aigle aigle);
    public Aigle findAigle(int idAigle);
    public void updateAigle(Aigle aigle);
    public void deleteAigle(int idAigle);
    public  Aigle findAigleByName(String name);
}
