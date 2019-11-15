package fr.univtln.M2DID19.ProjetZoo;

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
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Vache>> constraintViolations = validator.validate(vache);
        for (ConstraintViolation<Vache> cv:constraintViolations){
            System.out.println(" . " + cv.getPropertyPath() +
                    "( in " + cv.getRootBeanClass().getSimpleName() +
            " )" + cv.getMessage());
        }
    }
}
