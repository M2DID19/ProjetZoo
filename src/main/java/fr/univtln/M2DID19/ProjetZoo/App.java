package fr.univtln.M2DID19.ProjetZoo;

import fr.univtln.M2DID19.ProjetZoo.structures.Zoo;
import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;
import fr.univtln.M2DID19.ProjetZoo.vivants.Lapin;
import fr.univtln.M2DID19.ProjetZoo.vivants.Vache;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

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

        Vache.VacheBuilder builderVache = Vache.builder();
        Vache vache =builderVache.build();
        vache.setNom("vache qui rit");

        Lapin lapino= Lapin.builder().build();
        lapino.setNom("helo");

        Aigle aigle= Aigle.builder().build();
        aigle.setId(2);
        aigle.setNom("zoro");
        Zoo z=new Zoo();
        Zoo z2=new Zoo();
        z2.setNom("Mon zoo 2 ...");
        z.setNom("Mon zoo 1 ...");
        z.ajouterAnimal(vache);
        z.ajouterAnimal(lapino);
        //z.ajouterAnimal(lapino);
        //z.ajouterAnimal(vache);
        z2.ajouterAnimal(aigle);
        z.afficheToi();
        z2.afficheToi();
        lapino.setZoo(z);
        System.out.println(lapino.getZoo());
    }

}