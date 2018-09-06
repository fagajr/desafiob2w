package br.com.b2w.desafio.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import br.com.b2w.desafio.controller.converter.PlanetaConverter;
import br.com.b2w.desafio.entity.Planeta;

@Repository
public class PlanetaDao {
	static String db = "desafiob2w";
	static String colecao = "planetas";
	
	private static Logger log = Logger.getLogger(PlanetaDao.class);

	
	public void salvar(Planeta p) {
		try {
			MongoCollection<Document> col = MongoBDConnect.getCollection(db, colecao);
			Document obj = PlanetaConverter.transformToDocument(p);
			
			col.insertOne(obj);
		} catch (Exception e) {
			log.error("Erro ao tentar salvar o Planeta", e);
		}
	}
	
	public Planeta buscarPorId(String id) {
		try {
			MongoCollection<Document> col = MongoBDConnect.getCollection(db, colecao);
			
			BasicDBObject query = new BasicDBObject();
			query.put("_id", new ObjectId(id));
			FindIterable<Document> retorno = col.find(query);
			
			Document doc = retorno.first();
			Planeta p = PlanetaConverter.transformToPlaneta(doc);
			return p;
		} catch (Exception e) {
			log.error("Erro ao efetuar a busca por id", e);
			return null;
		}
	}
	
	public Planeta buscarPorNome(String nome) {
		try {
			MongoCollection<Document> col = MongoBDConnect.getCollection(db, colecao);
			
			BasicDBObject query = new BasicDBObject();
			query.put("name", nome);
			FindIterable<Document> retorno = col.find(query);
			
			Document doc = retorno.first();
			Planeta p = PlanetaConverter.transformToPlaneta(doc);
			return p;
		} catch (Exception e) {
			log.error("Erro ao efetuar a busca por id", e);
			return null;
		}
	}
	
	
	public void remover(String id) {
		try {
			MongoCollection<Document> col = MongoBDConnect.getCollection(db, colecao);
			Document item = PlanetaConverter.transformToDocument(buscarPorId(id));
			
			col.deleteOne(item);
		} catch (Exception e) {
			log.error("Erro ao tentar remover o planeta", e);
		}
	}
	
	public List<Planeta> buscarTodos(){
		List<Planeta> listaPlanetas = new ArrayList<>();
		try {
			MongoCollection<Document> col = MongoBDConnect.getCollection(db, colecao);
			
			MongoCursor<Document> cursor = col.find().iterator();
			
			while(cursor.hasNext()) {
				Document doc = cursor.next();
				Planeta p = PlanetaConverter.transformToPlaneta(doc);
				listaPlanetas.add(p);
			}
			return listaPlanetas;
		} catch (Exception e) {
			log.error("Erro ao buscar todos os planeta", e);
			return null;
		}
	}
}
