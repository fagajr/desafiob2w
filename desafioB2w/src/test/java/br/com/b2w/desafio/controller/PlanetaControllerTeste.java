package br.com.b2w.desafio.controller;

import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.b2w.desafio.dao.PlanetaDao;

@RunWith(MockitoJUnitRunner.class)
public class PlanetaControllerTeste {
	
	private PlanetaController controller;
	
	@Mock
	private PlanetaDao dao;
	
	
	@Before
	public void setUp() {
		controller = spy(new PlanetaController());
	}

}
