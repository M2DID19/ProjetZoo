package fr.univtln.M2DID19.ProjetZoo.dao;

import fr.univtln.M2DID19.ProjetZoo.connexion.Connexion;
import fr.univtln.M2DID19.ProjetZoo.vivants.Plante;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;

import java.util.List;

public class DAONoSQL {

    public void readDb(String host, int port, String dbName) {
        List<Plante> allDocs;
        try {
            Connexion connexion = new Connexion();
            connexion.setHost(host);
            connexion.setPort(port);
            connexion.setDatabaseName(dbName);

            CouchDbConnector connector = connexion.connexion();
            try {
                ViewQuery q = new ViewQuery().allDocs().includeDocs(true);
                allDocs = connector.queryView(q, Plante.class);
                System.out.println(allDocs.get(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
