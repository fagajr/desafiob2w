/**
 * 
 */
package br.com.b2w.desafio.controller.converter;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;

import br.com.b2w.desafio.entity.Planeta;

/**
 * @author franc
 *
 */
public class PlanetaConverter {
	
		@SuppressWarnings("unchecked")
		public static Document transformToDocument(Planeta p) {

			BasicDBObjectBuilder builder = BasicDBObjectBuilder.start().append("name", p.getNome())
																	   .append("terreno", p.getTerreno())
																	   .append("clima", p.getClima())
																	   .append("qtd", p.getQtdAparicoes());
			
			if (p.getId() != null) {
				builder = builder.append("_id", new ObjectId(p.getId()));
			}
			return new Document(builder.get().toMap());
		}

		public static Planeta transformToPlaneta(Document doc) {
			Planeta p = new Planeta();
			p.setNome((String) doc.get("name"));
			p.setTerreno((String) doc.get("terreno"));
			p.setClima((String) doc.get("clima"));
			p.setQtdAparicoes((Long) doc.get("qtd"));
			ObjectId id = (ObjectId) doc.get("_id");
			p.setId(id.toString());
			return p;

		}

}
