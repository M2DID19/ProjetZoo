package fr.univtln.M2DID19.ProjetZoo.Jsf;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
//import java.io.IOException;

@Named("TmpJsf")
public class TmpJsf implements Serializable {
    private String message = "bonjour";


    public String getMessage() {
        return message;
    }

    public void setMessage(String string) {
        message = string;
    }
}
