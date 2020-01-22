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
    protected String host; // = "192.168.99.100";
    protected int port; // = 5984;
    protected String username; // = "admin";
    protected String password; // = "admin";
    protected String databaseName; // = "test22";



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
