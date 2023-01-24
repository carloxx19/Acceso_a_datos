import com.mongodb.client.*;
import org.bson.Document;

import java.util.Iterator;
import java.util.Scanner;

public class Metodos {


    public void listarCollection(MongoDatabase db, String collectionName) {

        MongoCollection<Document> collection = db.getCollection(collectionName); //prueba
        FindIterable<Document> iterable = collection.find();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void buscar(MongoDatabase db, String collectionName, String key, String value) {
        MongoCollection<Document> collection = db.getCollection(collectionName); //prueba

        Document findDocument = new Document(key, value);
        MongoCursor<Document> resultDocument = (MongoCursor<Document>) collection.find(findDocument).iterator();
        System.out.println("listado por" + key);

        while (resultDocument.hasNext()) {
            System.out.println(resultDocument.next().toJson());
        }
    }

    public void eliminar(MongoDatabase db, String nombre, String key, String value) {
        MongoCollection<Document> collection = db.getCollection(nombre); //prueba

        Document findDocument = new Document(key, value);
        collection.findOneAndDelete(findDocument);
    }

    public void insertarPokemon(MongoDatabase db, String collection, String key, String value) {
        // Create the document to insert
        Document document = new Document(key, value);

        MongoCollection<Document> col = db.getCollection(collection);

        // Insert the document in the collection
        col.insertOne(document);
    }

    public void actualizar(MongoDatabase db, String collection, String value) {
        MongoCollection<Document> col = db.getCollection(collection); //prueba

        Document findDocument = new Document("name", "james");

        Document updateDocument = new Document("$set",
                new Document("name", value).
                        append("juegos","moster")

        );

        col.findOneAndUpdate(findDocument, updateDocument);
    }

    /*
    -----------------------LISTAR COLLECIONS NAME
            MongoIterable<String> list = db.listCollectionNames();
        for (String name : list) {
            System.out.println(name);
        }
    ---------------------
    public void buscar(MongoDatabase db, String nombre, String key, String value) {
        MongoCollection<Document> collection = db.getCollection(nombre); //prueba

        Document findDocument = new Document(key, value);
        MongoCursor<Document> resultDocument = (MongoCursor<Document>) collection.find(findDocument).iterator();
        System.out.println("listado por" + key);

        while (resultDocument.hasNext()) {
            System.out.println(resultDocument.next().toJson());
        }

    }


    */
}