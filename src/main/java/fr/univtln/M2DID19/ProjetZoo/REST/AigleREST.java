package fr.univtln.M2DID19.ProjetZoo.REST;

import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/aigle")
//@Produces({"application/json})"})
public class AigleREST {

    private DAO dao = new DAO();

//    @GET
//    @Path("/aigles")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Aigle> getAllAigle() {
//        return dao.findWithNamedQuery("findAllAigle");
//    }

    @GET
    @Path("/aigles")
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllAigle() {
        return "got it";
    }

}
