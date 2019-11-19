package fr.univtln.M2DID19.ProjetZoo;

import fr.univtln.M2DID19.ProjetZoo.vivants.Aigle;
import fr.univtln.M2DID19.ProjetZoo.vivants.Plante;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.univtln.M2DID19.ProjetZoo.vivants.Vache;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import java.lang.invoke.MethodHandles;
import java.util.Set;

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
        Vache vache = new Vache("marguerite");
        vache.setNbPattes(4);
        Plante plante = new Plante();
        vache.brouter(plante);
        Aigle aigle=new Aigle();
        aigle.manger(vache);
    }
}
