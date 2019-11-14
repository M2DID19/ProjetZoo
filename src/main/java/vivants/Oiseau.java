package vivants;

public class Oiseau extends Animal {

    public Oiseau(String nom) {
        super(nom);
    }

    public Oiseau() {
    }

    @Override
    public String toString() {
        return "je suis un oiseau, "+super.toString();
    }
}
