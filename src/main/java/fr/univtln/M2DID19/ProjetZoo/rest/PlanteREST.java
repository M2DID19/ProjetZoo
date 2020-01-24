package fr.univtln.M2DID19.ProjetZoo.rest;

import fr.univtln.M2DID19.ProjetZoo.ejb.GestionPlante;
import fr.univtln.M2DID19.ProjetZoo.vivants.Plante;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/plante")
@Produces({"application/json"})
public class PlanteREST {

    @Inject
    @EJB GestionPlante gestionPlante;

    @PUT
    @Path("/adddb")
    public void addDataBase(@QueryParam("username") String username, @QueryParam("password") String password,
                            @QueryParam("host") String host, @QueryParam("port") int port,
                            @QueryParam("dbName") String dbName) {
        try {
            gestionPlante.addDb(username, password, host, port, dbName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @GET
    @Path("/plantes")
    public List<Plante> getAllPlante(@QueryParam("host") String host, @QueryParam("port") int port,
                                     @QueryParam("dbName") String dbName) {
        List<Plante> allDocs = null;
        if (null != host & null != dbName) {
            System.out.println("debut");
            allDocs = gestionPlante.readDb(host, port, dbName);
            System.out.println("fin");
        }
        return allDocs;
    }

    @PUT
    @Path("/createPlante")
    public String createPlante(@QueryParam("host") String host, @QueryParam("port") int port,
                             @QueryParam("dbName") String dbName, @QueryParam("name") String name,
                             @QueryParam("famille") String famille, @QueryParam("nbFeuilles") int nbFeuilles) {
        String id = null;
        try {
            id = gestionPlante.createPlante(host, port, dbName, name, famille, nbFeuilles);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return id + "\n";
    }

    @GET
    @Path("/planteId")
    public Plante getById(@QueryParam("host") String host, @QueryParam("port") int port,
                          @QueryParam("dbName") String dbName, @QueryParam("id") String id) {
        Plante plante = null;
        try {
            plante = gestionPlante.getById(host, port, dbName, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plante;
    }

    @PUT
    @Path("/updatePlante")
    public Plante updatePlante(@QueryParam("host") String host, @QueryParam("port") int port,
                               @QueryParam("dbName") String dbName, @QueryParam("id") String id,
                               @QueryParam("rev") String rev, @QueryParam("name") String name,
                               @QueryParam("famille") String famille, @QueryParam("nbFeuilles") int nbFeuilles) {
        Plante plante = null;
        try {
            plante = gestionPlante.updatePlante(host, port, dbName, id, rev, name, famille, nbFeuilles);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plante;
    }
}
