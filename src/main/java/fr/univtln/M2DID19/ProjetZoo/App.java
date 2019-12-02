package fr.univtln.M2DID19.ProjetZoo;

import fr.univtln.M2DID19.ProjetZoo.REST.Tmp;
import fr.univtln.M2DID19.ProjetZoo.ejb.GestionAigle;
import fr.univtln.M2DID19.ProjetZoo.structures.Zoo;
import fr.univtln.M2DID19.ProjetZoo.vivants.*;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    @SuppressWarnings("unused")
    private static final Class[] shadeHack = {org.apache.log4j.RollingFileAppender.class,
            org.apache.log4j.ConsoleAppender.class,
            PatternLayout.class};

    //Set the logger with the real class name.
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        logger.info("App started.");
        logger.debug("About to talk :");
        System.out.println("Hello world !");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("authors");
        EntityManager em = emf.createEntityManager();

        System.out.print("ttt");

        Tmp tmp = new Tmp();

//        Vache.VacheBuilder builderVache = Vache.builder();
//        Vache vache =builderVache.build();
//        vache.setNom("vache qui rit");
//
//        Lapin lapino= Lapin.builder().build();
//        lapino.setNom("helo");
//
//        Aigle aigle= Aigle.builder().build();
//        aigle.setId(2);
//        aigle.setNom("zoro");
//        Zoo z=new Zoo();
//        Zoo z2=new Zoo();
//        z2.setNom("Mon zoo 2 ...");
//        z.setNom("Mon zoo 1 ...");
//        z.ajouterAnimal(vache);
//        z.ajouterAnimal(lapino);
//        //z.ajouterAnimal(lapino);
//        //z.ajouterAnimal(vache);
//        z2.ajouterAnimal(aigle);
//        z.afficheToi();
//        z2.afficheToi();
//        lapino.setZoo(z);
//        System.out.println(lapino.getZoo());
        Oiseau.couleur couleur= Oiseau.couleur.GRIS;
        Faune faune=new Faune();
        Vache vache=new Vache();
        Vache vache1=new Vache();
        vache.setNom("vache qui rit");
        vache.setNbTache(14);
        vache1.setNbTache(12);
        vache1.setNom("kiri kiri kiri");
        Aigle aigle=new Aigle();
        aigle.setNom("jackie chan");
        aigle.setVitesse(666);
        aigle.setCouleur(couleur);
        Lapin lapino=new Lapin();
        lapino.setLongueurOreille(5);
        lapino.setNom("lapino");
        faune.ajouterAnimal(lapino);
        faune.ajouterAnimal(vache);
        faune.ajouterAnimal(vache1);
        faune.ajouterAnimal(aigle);
        Zoo zoo1=new Zoo();
        Zoo zoo2=new Zoo();
        zoo2.setNom("my zozo ");
        zoo1.setNom("my zoo");
        zoo1.ajouterAnimal(vache);
        zoo1.ajouterAnimal(aigle);
        zoo2.ajouterAnimal(vache1);
        zoo2.ajouterAnimal(lapino);

        em.getTransaction().begin();
        em.persist(lapino);
        em.persist(vache);
        em.persist(aigle);
        em.persist(vache1);
        em.persist(vache);
        em.persist(faune);
        em.persist(zoo1);
        em.persist(zoo2);
        em.getTransaction().commit();
        emf.close();
        faune.afficherFaune();

        GestionAigle gestionAigle = new GestionAigle();
        gestionAigle.communiquer();


//        System.out.println("FIN !!");
//        List<Aigle> liste = tmp.getAllAigle2();
//        System.out.println("FIN2 !!");
//        System.out.println(liste.get(0));

//        System.out.println("FIN !!");
//        String liste = tmp.getAllAigle2();
//        System.out.println("FIN2 !!");
//        System.out.println(liste);
    }

}