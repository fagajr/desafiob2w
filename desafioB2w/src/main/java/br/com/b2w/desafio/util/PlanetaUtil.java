package br.com.b2w.desafio.util;

import java.util.List;

import br.com.b2w.desafio.entity.Planeta;
import br.com.b2w.desafio.entity.PlanetaServico;

public final class PlanetaUtil {
	
	public static Long preencherQuantidade(List<PlanetaServico> lista, Planeta p) {
		for (PlanetaServico ps : lista) {
			if (ps.getNome().equals(p.getNome()) && ps.getTerreno().equals(p.getTerreno()) && ps.getClima().equals(p.getClima())) {
				return Long.valueOf(ps.quantidadeParticipacoes());
			}
		}
		return null;
	}
}
