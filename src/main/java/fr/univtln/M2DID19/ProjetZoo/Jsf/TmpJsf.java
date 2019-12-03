package fr.univtln.M2DID19.ProjetZoo.Jsf;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
import javax.inject.Named;
//import java.io.IOException;

@Named
public class TmpJsf {
    private String nom;
    private String mdp;

    public String getMdp() {
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setMdp(String string) {
        mdp = string;
    }

    public void setNom(String string) {
        nom = string;
    }

//    public void logout() throws IOException {
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//        ec.invalidateSession();
//        ec.redirect(ec.getRequestContextPath() + "/index.html");
//    }
}
