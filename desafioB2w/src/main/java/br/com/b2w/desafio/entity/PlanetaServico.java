/**
 * 
 */
package br.com.b2w.desafio.entity;


/**
 * @author franc
 *
 */
public class PlanetaServico {
	
	private String nome;
	private String diametro;
	private String rotacao;
	private String orbita;
	private String gravidade;
	private String populacao;
	private String clima;
	private String terreno;
	private String supercicieAquatica;
	private String residentes;
	private String filmes;
	private String url;
	
	public PlanetaServico(String nome, String diametro, String rotacao, String orbita, String gravidade,
			String populacao, String clima, String terreno, String supercicieAquatica, String residentes,
			String filmes, String url) {
		this.nome = nome;
		this.diametro = diametro;
		this.rotacao = rotacao;
		this.orbita = orbita;
		this.gravidade = gravidade;
		this.populacao = populacao;
		this.clima = clima;
		this.terreno = terreno;
		this.supercicieAquatica = supercicieAquatica;
		this.residentes = residentes;
		this.filmes = filmes;
		this.url = url;
	}
	public PlanetaServico() {
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the diametro
	 */
	public String getDiametro() {
		return diametro;
	}
	/**
	 * @param diametro the diametro to set
	 */
	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}
	/**
	 * @return the rotacao
	 */
	public String getRotacao() {
		return rotacao;
	}
	/**
	 * @param rotacao the rotacao to set
	 */
	public void setRotacao(String rotacao) {
		this.rotacao = rotacao;
	}
	/**
	 * @return the orbita
	 */
	public String getOrbita() {
		return orbita;
	}
	/**
	 * @param orbita the orbita to set
	 */
	public void setOrbita(String orbita) {
		this.orbita = orbita;
	}
	/**
	 * @return the gravidade
	 */
	public String getGravidade() {
		return gravidade;
	}
	/**
	 * @param gravidade the gravidade to set
	 */
	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}
	/**
	 * @return the populacao
	 */
	public String getPopulacao() {
		return populacao;
	}
	/**
	 * @param populacao the populacao to set
	 */
	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}
	/**
	 * @return the clima
	 */
	public String getClima() {
		return clima;
	}
	/**
	 * @param clima the clima to set
	 */
	public void setClima(String clima) {
		this.clima = clima;
	}
	/**
	 * @return the terreno
	 */
	public String getTerreno() {
		return terreno;
	}
	/**
	 * @param terreno the terreno to set
	 */
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	/**
	 * @return the supercicieAquatica
	 */
	public String getSupercicieAquatica() {
		return supercicieAquatica;
	}
	/**
	 * @param supercicieAquatica the supercicieAquatica to set
	 */
	public void setSupercicieAquatica(String supercicieAquatica) {
		this.supercicieAquatica = supercicieAquatica;
	}
	/**
	 * @return the residentes
	 */
	public String getResidentes() {
		return residentes;
	}
	/**
	 * @param residentes the residentes to set
	 */
	public void setResidentes(String residentes) {
		this.residentes = residentes;
	}
	/**
	 * @return the filmes
	 */
	public String getFilmes() {
		return filmes;
	}
	/**
	 * @param filmes the filmes to set
	 */
	public void setFilmes(String filmes) {
		this.filmes = filmes;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer quantidadeParticipacoes() {
		String[] filmes = this.getFilmes().split(",");
		
		return filmes.length;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clima == null) ? 0 : clima.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((terreno == null) ? 0 : terreno.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetaServico other = (PlanetaServico) obj;
		if (clima == null) {
			if (other.clima != null)
				return false;
		} else if (!clima.equals(other.clima))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (terreno == null) {
			if (other.terreno != null)
				return false;
		} else if (!terreno.equals(other.terreno))
			return false;
		return true;
	}
}
