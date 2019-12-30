package fr.univtln.M2DID19.ProjetZoo.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AigleValidator implements ConstraintValidator<Nom, String> {
    @Override
    public void initialize(Nom constraintAnnotation) {

    }

    @Override
    public boolean isValid(String nom, ConstraintValidatorContext constraintValidatorContext) {
        if(nom.length()<4 || nom.length()>20)
        {System.out.println("wahya sinia ....");
            return false;}
        for (char c : nom.toCharArray()) {
            if (!Character.isLetter(c))
                return false;
        }return true;
    }
}

