package vivants;

public class Mammifere extends Animal{

    public Mammifere(String nom) {
        super(nom);
    }

    public Mammifere() {
    }

    @Override
    public String toString() {
        return "je suis un mammifere, "+super.toString();
    }
}
