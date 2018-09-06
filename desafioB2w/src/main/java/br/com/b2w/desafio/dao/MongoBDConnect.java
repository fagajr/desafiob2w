package br.com.b2w.desafio.dao;


import org.bson.Document;
import org.apache.log4j.Logger;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class MongoBDConnect {
	
	private static MongoClient conexao;
	private static Logger log = Logger.getLogger(MongoBDConnect.class);
	
	private MongoBDConnect() {
	}

	public static MongoClient getConexao() {
		if (conexao == null) {
			try {
				conexao = new MongoClient("localhost", 27017);
			} catch (MongoException e) {
				log.error(e);
			}
		}
		return conexao;
	}
	
	public static MongoDatabase getDb(String db) {
		return getConexao().getDatabase(db);
	}

	public static MongoCollection<Document> getCollection(String dbName, String col) {
		return getDb(dbName).getCollection(col);
	}
}
