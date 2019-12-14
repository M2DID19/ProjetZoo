package fr.univtln.M2DID19.ProjetZoo.rest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AigleRESTTest {

    @Test
    public void testPersistAigle() {
        String nom;
        nom = "un nom";
        Assertions.assertTrue(nom.length() > 3, "La taille du nom n'est pas trop petite");

        nom = "no";
        Assertions.assertFalse(nom.length() > 3, "La taille du nom n'est pas trop petite");
    }

}
