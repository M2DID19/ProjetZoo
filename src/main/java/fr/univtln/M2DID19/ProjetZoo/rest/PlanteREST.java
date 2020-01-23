package fr.univtln.M2DID19.ProjetZoo.rest;


import fr.univtln.M2DID19.ProjetZoo.connexion.Connexion;
import fr.univtln.M2DID19.ProjetZoo.dao.DAONoSQL;
import org.ektorp.CouchDbConnector;

import javax.ws.rs.*;

@Path("/plante")
@Produces({"application/json"})
public class PlanteREST {

    DAONoSQL daoNoSQL = new DAONoSQL();

    @PUT
    @Path("/adddb")
    public void addDataBase(@QueryParam("username") String username, @QueryParam("password") String password,
                            @QueryParam("host") String host, @QueryParam("port") int port,
                            @QueryParam("dbName") String dbName) {
        try {
            Connexion connexion = new Connexion();
            connexion.setUsername(username);
            connexion.setPassword(password);
            connexion.setHost(host);
            connexion.setPort(port);
            connexion.setDatabaseName(dbName);

            CouchDbConnector connector = connexion.connexion();
            connector.createDatabaseIfNotExists();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @GET
    @Path("/plantes")
    public void getAllPlante(@QueryParam("host") String host, @QueryParam("port") int port,
                             @QueryParam("dbName") String dbName) {
        System.out.println("debut");
        daoNoSQL.readDb(host, port, dbName);
        System.out.println("fin");
    }
}
