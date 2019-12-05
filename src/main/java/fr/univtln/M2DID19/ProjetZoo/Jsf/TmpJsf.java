package fr.univtln.M2DID19.ProjetZoo.Jsf;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("TmpJsf")
@SessionScoped
@ManagedBean
public class TmpJsf implements Serializable {
    private String message = "bonjour";


    public String getMessage() {
        return message;
    }

    public void setMessage(String string) {
        message = string;
    }
}
