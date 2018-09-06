package br.com.b2w.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.b2w.desafio.controller.servico.PlanetaAPIServico;
import br.com.b2w.desafio.dao.PlanetaDao;
import br.com.b2w.desafio.entity.Planeta;
import br.com.b2w.desafio.util.PlanetaUtil;

/*
 * Toda a API que sera consumida pelo angular js
 */
@RestController
public class PlanetaController {

	@Autowired
	PlanetaDao cd;
	
	@RequestMapping(value="planeta/novo", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> cadastrar(@RequestBody Planeta pla){
		JsonObject json = new JsonObject();
		try{
			pla.setQtdAparicoes(PlanetaUtil.preencherQuantidade(PlanetaAPIServico.buscarFilmes(), pla));
			cd.salvar(pla);
			json.addProperty("msg", pla.getNome() + ", salvo");
			return new ResponseEntity<String>(new Gson().toJson(json), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			json.addProperty("msg", "Erro");
			return new ResponseEntity<String>(new Gson().toJson(json), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="planeta/buscar/{id}", method=RequestMethod.GET)
	public @ResponseBody  ResponseEntity<String> buscarPorId(@PathVariable String id){
		JsonObject json = new JsonObject();
		try{
			Planeta planeta = cd.buscarPorId(id);
			
			return new ResponseEntity<String>(new Gson().toJson(planeta), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			json.addProperty("msg", "Erro");
			return new ResponseEntity<String>(new Gson().toJson(json), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="planeta/buscar/{nome}", method=RequestMethod.GET)
	public @ResponseBody  ResponseEntity<String> buscarPorNome(@PathVariable String nome){
		JsonObject json = new JsonObject();
		try{
			Planeta planeta = cd.buscarPorNome(nome);
			
			return new ResponseEntity<String>(new Gson().toJson(planeta), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			json.addProperty("msg", "Erro");
			return new ResponseEntity<String>(new Gson().toJson(json), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="planeta/remover", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> remover(@RequestBody Planeta pla){
		JsonObject json = new JsonObject();
		try{
			cd.remover(pla.getId());
			json.addProperty("msg", pla.getNome() + ", removido");
			return new ResponseEntity<String>(new Gson().toJson(json), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			json.addProperty("msg", "Erro");
			return new ResponseEntity<String>(new Gson().toJson(json), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="planeta/buscar", method=RequestMethod.POST)
	public @ResponseBody  ResponseEntity<String> buscarTodos(){
		try{
			List<Planeta> planetas = cd.buscarTodos();
			
			return new ResponseEntity<String>(new Gson().toJson(planetas), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			JsonObject json = new JsonObject();
			json.addProperty("msg", "Erro");
			return new ResponseEntity<String>(new Gson().toJson(json), HttpStatus.BAD_REQUEST);
		}
	}
	
}
