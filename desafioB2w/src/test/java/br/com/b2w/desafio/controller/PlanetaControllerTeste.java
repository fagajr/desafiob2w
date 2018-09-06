package br.com.b2w.desafio.controller;

import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.b2w.desafio.dao.PlanetaDao;
import br.com.b2w.desafio.entity.Planeta;

@RunWith(MockitoJUnitRunner.class)
public class PlanetaControllerTeste {
	
	private PlanetaController controller;
	
	@Mock
	private PlanetaDao dao;
	
	
	@Before
	public void setUp() {
		controller = spy(new PlanetaController());
		controller.setCd(dao);
	}

	@Test
	public void cadastrarTest() {
		Planeta p = new Planeta();
		p.setNome("name");
		p.setTerreno("terreno");
		p.setClima("clima");
		
		controller.cadastrar(p);
	}
	
	@Test(expected = Exception.class)
	public void cadastrarTestException() {
		Mockito.when(controller.cadastrar(Mockito.any(Planeta.class))).thenThrow(new Exception());
		controller.cadastrar(new Planeta());
	}
	
	@Test
	public void buscarPorIdTest() {
		Planeta p = new Planeta();
		p.setNome("name");
		p.setTerreno("terreno");
		p.setClima("clima");
		p.setId("1");
		
		Mockito.when(dao.buscarPorId(Mockito.anyString())).thenReturn(p);
		
		controller.buscarPorId(Mockito.anyString());
	}
	
	@Test(expected = Exception.class)
	public void buscarPorIdTestException() {
		Mockito.when(dao.buscarPorId(Mockito.anyString())).thenThrow(new Exception());
		controller.buscarPorId(Mockito.anyString());
	}
	
	@Test
	public void buscarPorNomeTest() {
		Planeta p = new Planeta();
		p.setNome("name");
		p.setTerreno("terreno");
		p.setClima("clima");
		
		Mockito.when(dao.buscarPorNome(Mockito.anyString())).thenReturn(p);
		
		controller.buscarPorNome(Mockito.anyString());
	}
	
	@Test(expected = Exception.class)
	public void buscarPorNomeTestException() {
		Mockito.when(dao.buscarPorNome(Mockito.anyString())).thenThrow(new Exception());
		controller.buscarPorNome(Mockito.anyString());
	}
	
	@Test
	public void removerTest() {
		Planeta p = new Planeta();
		p.setNome("name");
		p.setTerreno("terreno");
		p.setClima("clima");
		
		controller.remover(p);
	}
	
	@Test(expected = Exception.class)
	public void removerTestException() {
		Mockito.when(controller.remover(Mockito.any(Planeta.class))).thenThrow(new Exception());
		controller.remover(new Planeta());
	}
	
	@Test
	public void buscarTodosTest() {
		Planeta p = new Planeta();
		p.setNome("name");
		p.setTerreno("terreno");
		p.setClima("clima");
		List<Planeta> lp = new ArrayList<>();
		lp.add(p);
		
		Mockito.when(dao.buscarTodos()).thenReturn(lp);
		
		controller.buscarTodos();
	}
	
	@Test(expected = Exception.class)
	public void buscarTodosTestException() {
		Mockito.when(controller.buscarTodos()).thenThrow(new Exception());
		controller.buscarTodos();
	}
}
