package fr.univtln.M2DID19.ProjetZoo.ejb;


import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.structures.Zoo;

import javax.inject.Inject;

public class GestionZoo {

    @Inject DAO dao;

    public Zoo find(int id){
        return (Zoo) dao.find(Zoo.class,id);
    }
    public void createZoo(Zoo zoo){
        dao.create(zoo);
    }




}
