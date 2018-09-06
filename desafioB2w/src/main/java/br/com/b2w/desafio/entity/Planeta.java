/**
 * 
 */
package br.com.b2w.desafio.entity;

import java.io.Serializable;

/**
 * Classe Planeta - Desafio B2W
 * @author franc
 *
 */
public class Planeta implements Serializable {
	
	private static final long serialVersionUID = 8399263005957401050L;
	private String id;
	private String nome;
	private String terreno;
	private String clima;
	private Long qtdAparicoes;
	
	public Planeta() {
		
	}

	public Planeta(String id, String nome, String terreno, String clima, Long qtdAparicoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.terreno = terreno;
		this.clima = clima;
		this.qtdAparicoes = qtdAparicoes;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the qtdAparicoes
	 */
	public Long getQtdAparicoes() {
		return qtdAparicoes;
	}

	/**
	 * @param qtdAparicoes the qtdAparicoes to set
	 */
	public void setQtdAparicoes(Long qtdAparicoes) {
		this.qtdAparicoes = qtdAparicoes;
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
		Planeta other = (Planeta) obj;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nome=" + nome + ", terreno=" + terreno + ", clima=" + clima + ", qtdAparicoes="
				+ qtdAparicoes + "]";
	}

}
