package fr.univtln.M2DID19.ProjetZoo.connexion;

import lombok.Getter;
import lombok.Setter;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;


@Setter
@Getter
public class Connexion {
    protected String host;
    protected int port;
    protected String username;
    protected String password;
    protected String databaseName;
    
    public CouchDbConnector connexion() {

        System.out.println("debut connexion");
        CouchDbConnector connector = null;

        try {

            HttpClient httpClient = new StdHttpClient.Builder()
                    .host(host)
                    .port(port)
                    .username(username)
                    .password(password)
                    .build();

            System.out.println(httpClient);

            CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

            connector = dbInstance.createConnector(databaseName, true);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return connector;
    }


    @Override
    public String toString() {
        return "Connexion{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }
}
