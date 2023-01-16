package mongoJava;

import java.util.Iterator;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class Main {

	public static void main(String[] args) {
		
		//conexao sem autenticacao
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
		//para pegar/criar uma base
		DB database = mongoClient.getDB("bd2");
		
		//outra forma de pegar a base
		MongoDatabase db = mongoClient.getDatabase("bd2");
	    
		//mostrar base
		System.out.println("------------------------------------");
		System.out.println("Bases disponíveis");
		mongoClient.getDatabaseNames().forEach(System.out::println);
		System.out.println("------------------------------------");
			
		//Criar
		database.createCollection("funcionario", null);
		System.out.println("------------------------------------");
		System.out.println("colecoes: ");
		database.getCollectionNames().forEach(System.out::println);
		System.out.println("------------------------------------");
		
		
		DBCollection collection = database.getCollection("funcionario");
		//ou
		MongoCollection<Document> colFuncionario = db.getCollection("funcionario");
				
		
		BasicDBObject document = new BasicDBObject();
		document.put("name", "Roben Lunardi");
		document.put("salario", 1200);
		collection.insert(document);
		
		BasicDBObject document2 = new BasicDBObject();
		document2.put("name", "Juliana Bol");
		document2.put("salario", 2500);
		document2.put("filho", "Joao Bol");
		collection.insert(document2);
		
		//ler documento específico
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "Roben C Lunardi");
		DBCursor cursor = collection.find(searchQuery);
		
		System.out.println("------------------------------------");
		System.out.println("Lista de documentos (funcionarios conforme especificado): ");
		while (cursor.hasNext()) {
		    System.out.println(cursor.next());
		}
		System.out.println("------------------------------------");
		
		//update
		BasicDBObject query = new BasicDBObject();
		query.put("name", "Roben Lunardi");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", "Roben C Lunardi");

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);

		collection.update(query, updateObject);
		
		//ler -> usando a outra forma de pegar base/colecoes
		System.out.println("------------------------------------");
		System.out.println("Lista de TODOS documentos (funcionarios): ");
		
		FindIterable<Document> iterDoc = colFuncionario.find();
	      Iterator it = iterDoc.iterator();
	      while (it.hasNext()) {
	         System.out.println(it.next());
	      }
	      
	    // deletar
	    BasicDBObject searchQuery2 = new BasicDBObject();
	    searchQuery2.put("name", "Roben C Lunardi");

	    collection.remove(searchQuery2);
	    System.out.println("------------------------------------");
	    System.out.println("documentos ao fim, apos remover");
	    it = iterDoc.iterator();
	      while (it.hasNext()) {
	         System.out.println(it.next());
	      }
	      
	    //apagando toda a colecao
	    System.out.println("------------------------------------");
		System.out.println("colecoes antes de remover: ");
		database.getCollectionNames().forEach(System.out::println);
		System.out.println("------------------------------------");
	    collection.drop();
	    System.out.println("------------------------------------");
		System.out.println("colecoes depois de remover: ");
		database.getCollectionNames().forEach(System.out::println);
		System.out.println("------------------------------------");
	    
	    
		//close resources
		mongoClient.close();
		}	
        
	

}