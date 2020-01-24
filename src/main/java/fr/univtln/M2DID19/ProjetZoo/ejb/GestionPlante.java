package fr.univtln.M2DID19.ProjetZoo.ejb;

import fr.univtln.M2DID19.ProjetZoo.dao.DAONoSQL;
import fr.univtln.M2DID19.ProjetZoo.vivants.Plante;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class GestionPlante {

    @Inject private DAONoSQL daoNoSQL;

    public List<Plante> readDb(String host, int port, String dbName) {
        List<Plante> allDocs = null;
        try {
            allDocs = daoNoSQL.readDb(host, port, dbName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return allDocs;
    }

    public void addDb(String username, String password, String host, int port, String dbName) {
        try {
           daoNoSQL.addDb(username, password, host, port, dbName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String createPlante(String host, int port, String dbName, String name, String famille, int nbFeuilles) {
        String id = null;
        try {
            id = daoNoSQL.createPlante(host, port, dbName, name, famille, nbFeuilles);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public Plante getById(String host, int port, String dbName, String id) {
        Plante plante = null;
        try {
            plante = daoNoSQL.getById(host, port, dbName, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plante;
    }

    public Plante updatePlante(String host, int port, String dbName, String id, String rev, String name, String famille, int nbFeuilles) {
        Plante planteRetour = null;
        try {
            Plante plante = new Plante();
            plante.setId(id);
            plante.setRev(rev);
            plante.setName(name);
            plante.setFamille(famille);
            plante.setNbFeuilles(nbFeuilles);
            try {
                planteRetour = daoNoSQL.updatePlante(host, port, dbName, plante);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return planteRetour;
    }
}
