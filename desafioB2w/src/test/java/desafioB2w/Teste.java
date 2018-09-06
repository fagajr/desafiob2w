/**
 * 
 */
package desafioB2w;

import java.util.List;

import br.com.b2w.desafio.controller.servico.PlanetaAPIServico;
import br.com.b2w.desafio.entity.PlanetaServico;

/**
 * @author franc
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PlanetaAPIServico api = new PlanetaAPIServico();
		List<PlanetaServico> cd = api.buscarFilmes();
		
		for (PlanetaServico planetaServico : cd) {
			System.out.println(planetaServico);
		}
	}
}
