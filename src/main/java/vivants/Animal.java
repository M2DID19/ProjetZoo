package vivants;

public class Animal {

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Animal(String nom) {
        this.nom = nom;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Je suis "+this.nom+", et je suis un animal";
    }
}
