package fr.univtln.M2DID19.ProjetZoo.REST;

import fr.univtln.M2DID19.ProjetZoo.DAO.DAO;
import fr.univtln.M2DID19.ProjetZoo.ejb.GestionAigle;
import fr.univtln.M2DID19.ProjetZoo.exceptions.NexistePasException;
import fr.univtln.M2DID19.ProjetZoo.exceptions.NomNonValideException;
import fr.univtln.M2DID19.ProjetZoo.exceptions.VitesseNonValideException;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;
import fr.univtln.M2DID19.ProjetZoo.vivants.Oiseau;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/aigle")
@Produces({"application/json", "application/xml"})
public class AigleREST {

    @Inject
    //DAO<Aigle> dao;
//    @Inject GestionAigle gestionAigle;
    @EJB GestionAigle gestionAigle;



    @POST
    @Path("/createAigle")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAigle(@QueryParam("nom") String nom, @QueryParam("couleur") Oiseau.couleur couleur,@QueryParam("vitesse") int vitesse,@QueryParam("zoo_id") int zoo_id) throws NomNonValideException, VitesseNonValideException, NexistePasException {
           Aigle aigle=null;
            try {
                aigle=new Aigle(nom,vitesse,couleur,zoo_id);
                gestionAigle.createAigle(aigle);
                System.out.println(nom + "     " + couleur + "     " + vitesse + "     " + aigle.getId_zoo()+ "     "+aigle.getId());
            }catch(NomNonValideException | VitesseNonValideException e){
                e.getMessage();
            }
    }

    @GET
    @Path("/findAigle")
    @Produces(MediaType.APPLICATION_JSON)
    public Aigle findAigle(@QueryParam("id") int idAigle){
        return gestionAigle.findAigle(idAigle);
    }

    @GET
    @Path("/aigles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aigle> getAllAigle() {
        return gestionAigle.findAllAigle();
    }

    @PUT
    @Path("/updateAigle")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAigle(@QueryParam("id") int id,@QueryParam("nom") String nom, @QueryParam("couleur") Oiseau.couleur couleur,@QueryParam("vitesse") int vitesse) throws NexistePasException{
       Aigle aigle=null;
        try{
             aigle=gestionAigle.findAigle(id);
            if(aigle==null)
                throw new NexistePasException(nom);
            aigle.setCouleur(couleur);
            aigle.setVitesse(vitesse);
            aigle.setNom(nom);
            System.out.println(aigle.getId()+"  "+aigle.getNom()+"  "+aigle.getCouleur());
            gestionAigle.updateAigle(aigle);
            System.out.println("After gestionAigle's call ...");
        }
        catch(NexistePasException e){
            e.getStackTrace();
        }
    }

    @DELETE
    @Path("/removeAigle")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAigle(@QueryParam("id") int idAigle){
            gestionAigle.deleteAigle(idAigle);}

}
