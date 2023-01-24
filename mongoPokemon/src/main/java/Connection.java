import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {

    private final String URL = "mongodb+srv://root:root@cluster0.1cqxnav.mongodb.net/?retryWrites=true&w=majority";
    private final String database = "Pokemon";
    private MongoClient client;

    public MongoDatabase connect(String URL, String nombreDb) {
        client = MongoClients.create(URL);
        MongoDatabase database = client.getDatabase(nombreDb);
        System.out.println("conexion establecida");
        return database;
    }

    public void disconnect() {
        client.close();
    }

    public String getURL() {
        return URL;
    }

    public String getDatabase() {
        return database;
    }

    public MongoClient getClient() {
        return client;
    }

    public void setClient(MongoClient client) {
        this.client = client;
    }
}