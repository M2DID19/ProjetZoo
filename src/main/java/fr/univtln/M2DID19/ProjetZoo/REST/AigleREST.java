package fr.univtln.M2DID19.ProjetZoo.REST;

import fr.univtln.M2DID19.ProjetZoo.ejb.GestionAigle;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/aigle")
@Produces({"application/json", "application/xml"})
public class AigleREST {

    @EJB GestionAigle gestionAigle;


    @GET
    @Path("/allAigles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aigle> getAllAigle() {
        return gestionAigle.findAllAigle();
    }


    @GET
    @Path("/aigles")
    @Produces(MediaType.APPLICATION_JSON)
    public Aigle getAigle() {
        Aigle aigle = new Aigle();
        aigle = gestionAigle.findAigle();
        return aigle;
    }

    @POST
    @Path("/persistAigle")
    @Consumes(MediaType.APPLICATION_JSON)
    public void persistAigle(@QueryParam("nom") String nom) {
        try {
            Aigle aigle = new Aigle();
            aigle.setNom(nom);
            System.out.println("nom " + nom);
            System.out.println("aigle= " + aigle);
            gestionAigle.postAigle(aigle);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

}
