package fr.univtln.M2DID19.ProjetZoo.annotations;

import fr.univtln.M2DID19.ProjetZoo.annotations.AigleValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = AigleValidator.class)
@Documented

public @interface Nom {

    String message() default "{Le nom n'est pas valide ...}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
