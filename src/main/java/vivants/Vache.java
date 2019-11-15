package vivants;

public class Vache extends Mammifere{

    public Vache(String nom) {
        super(nom);
    }

    public Vache() {
    }

    @Override
    public String toString() {
        return "Je suis "+this.getNom()+", je suis une vache, ";
    }
}
