package fr.univtln.M2DID19.ProjetZoo.dao;

import fr.univtln.M2DID19.ProjetZoo.connexion.Connexion;
import fr.univtln.M2DID19.ProjetZoo.vivants.Plante;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;

import javax.inject.Inject;
import java.util.List;

public class DAONoSQL {

    @Inject private Connexion connexion;


    public void addDb(String username, String password, String host, int port, String dbName) {
        try {
            connexion.setUsername(username);
            connexion.setPassword(password);
            connexion.setHost(host);
            connexion.setPort(port);
            connexion.setDatabaseName(dbName);

            CouchDbConnector connector = connexion.connexion();
            // createDatabaseIfNotExists() ne retourne rien, il faut regarder si la bd n'existe pas deja avant
            // ne la supprime pas si elle existe deja
            connector.createDatabaseIfNotExists();
            connexion.closeConnexion(connector);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Plante> readDb(String host, int port, String dbName) {
        List<Plante> allDocs = null;
        try {
            connexion.setHost(host);
            connexion.setPort(port);
            connexion.setDatabaseName(dbName);

            CouchDbConnector connector = connexion.connexion();
            try {
                ViewQuery q = new ViewQuery().allDocs().includeDocs(true);
                allDocs = connector.queryView(q, Plante.class);
                System.out.println(allDocs.get(0));
                connexion.closeConnexion(connector);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            connexion.closeConnexion(connector);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return allDocs;
    }


    public String createPlante(String host, int port, String dbName, String name, String famille, int nbFeuilles) {
        String id = null;
        try {
            connexion.setHost(host);
            connexion.setPort(port);
            connexion.setDatabaseName(dbName);

            CouchDbConnector connector = connexion.connexion();
            try {
                Plante plante = new Plante();
                plante.setFamille(famille);
                plante.setName(name);
                plante.setNbFeuilles(nbFeuilles);
                connector.create(plante);
                id = plante.getId();
                connexion.closeConnexion(connector);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                connexion.closeConnexion(connector);
            }
            connexion.closeConnexion(connector);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public Plante getById(String host, int port, String dbName, String id) {
        Plante plante = null;
        try {
            connexion.setHost(host);
            connexion.setPort(port);
            connexion.setDatabaseName(dbName);

            CouchDbConnector connector = connexion.connexion();
            try {
                plante = connector.get(Plante.class, id);
                connexion.closeConnexion(connector);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                connexion.closeConnexion(connector);
            }
            connexion.closeConnexion(connector);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plante;
    }

    public Plante updatePlante(String host, int port, String dbName, Plante plante) {
        Plante planteRetour = null;
        try {
            connexion.setHost(host);
            connexion.setPort(port);
            connexion.setDatabaseName(dbName);

            CouchDbConnector connector = connexion.connexion();
            try {
                if (plante.getId() != null && connector.contains(plante.getId())) {
                    connector.update(plante);
                    planteRetour = plante;
                    connexion.closeConnexion(connector);
                }
                else {
                    try {
                        connector.create(plante);
                        planteRetour = plante;
                        System.out.println("La plante n'existait pas, elle a été créée");
                        connexion.closeConnexion(connector);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                        connexion.closeConnexion(connector);
                    }
                    connexion.closeConnexion(connector);
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
                connexion.closeConnexion(connector);
            }
            connexion.closeConnexion(connector);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return planteRetour;
    }
}
