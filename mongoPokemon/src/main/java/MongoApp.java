import com.mongodb.client.MongoDatabase;

import java.util.Scanner;

public class MongoApp {

    final String collectionName = "pokemon_mongoDB";
    Connection connection = new Connection();
    MongoDatabase db = new Connection().connect(connection.getURL(), connection.getDatabase());
    Metodos metodos = new Metodos();

    private void menu() {

        Scanner keyboard = new Scanner(System.in);
        String key;
        String value;
        int option;
        System.out.println("""
                *** OPCIONES ***
                1.-MOSTRAR TODOS LOS POKEMON Y CARACTERISTICAS. CHECK
                2.-BUSCAR POKEMON EN FUNCION DE UN CAMPO VALOR QUE LE PROPORCIONEMOS. CHECK
                3.-Eliminar uno o varios Pokémon en función de un campo valor que le proporcionemos. CHECK
                4.-INSERTAR POKEMON QUE TENGA SOLAMENTE NOMBRE.
                5.-ACTUALIZAR UN POKEMON EN FUNCION DE UN CAMPO QUE LE PROPORCIONEMOS.
                """);
        option = keyboard.nextInt();

        switch (option) {
            case 1 -> metodos.listarCollection(db, "pokemon_mongoDB");//metodos.listarCollection(db, collectionName);
            case 2 -> {
                System.out.println("Introduce el parametro por el que quieres buscar");
                key = keyboard.next();

                System.out.println("Introduce el valor de la busqueda");
                value = keyboard.next();

                metodos.buscar(db, collectionName, key, value);
            }
            case 3 -> {
                System.out.println("Introduce el parametro por el que quieres borrar");
                key = keyboard.next();

                System.out.println("Introduce el valor por el que quieres borrar");
                value = keyboard.next();

                metodos.eliminar(db, collectionName, key, value);
            }
            case 4 -> {
                System.out.println("Introduce el tipo de dato a agregar");
                key = keyboard.next();

                System.out.println("introduce el dato");
                value = keyboard.next();

                metodos.insertarPokemon(db, collectionName, key, value);
            }
            case 5 -> {
                metodos.actualizar(db, collectionName, "james");
            }
        }
    }

    public static void main(String[] args) {
        MongoApp mongoApp = new MongoApp();

        mongoApp.menu();
    }
}

//----------CAMPO DE PRUEBAS-----------
    /*
    public void prueba1() {
        MongoCollection<Document> collection = db.getCollection(collectionName);

        //esto es un filtro, si lo quito cuenta con todos los datos de la base de datos, aqui filtro que solo muestre
        //los pokemon de la generacion 7.
         Document match = new Document("$match", new Document("generation",7));

        //en el parametro que dice type1 puede pedir que cuente tod0 lo que sea type1(se puede poner
        // otro parametro como type2 o por nombre) es decir si quiero que cuente
        //todos los Types de grass va a mostrar grass y la cantidad que hay ejemplo-> grass:12
        Document groupFields = new Document("_id", "$type2" ).
                append("total", new Document("$sum", 1));
        Document group = new Document("$group", groupFields);

        List<Document> pipeline = Arrays.asList(group);
        MongoCursor<Document> output = collection.aggregate(pipeline).iterator();

        while (output.hasNext()){
            Document document = output.next();
            System.out.println(document.getString("_id")+":" + (document.getInteger("total")));

        }
    }

    */

//----------CIERRO CAMPO DE PRUEBAS--------------