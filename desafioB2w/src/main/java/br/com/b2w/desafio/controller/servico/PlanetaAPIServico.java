package br.com.b2w.desafio.controller.servico;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import br.com.b2w.desafio.entity.PlanetaServico;

public final class PlanetaAPIServico {
	private static Logger log = Logger.getLogger(PlanetaAPIServico.class);
	private static List<PlanetaServico> listaPlanetas;
	
	
	@SuppressWarnings("rawtypes")
	public static List<PlanetaServico> buscarFilmes() {
		try {
			URL url = new URL("http://swapi.co/api/planets/");
			
			Document document = getDocumento(url);
			 
            Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext();) {
            	PlanetaServico p = new PlanetaServico();
            	Element element = (Element) i.next();
            	
            	if (element.getQualifiedName().equals("name"))
                    p.setNome(element.getText());
            	
            	if (element.getQualifiedName().equals("diameter"))
            		p.setDiametro(element.getText());
            	
            	if (element.getQualifiedName().equals("rotation_period"))
            		p.setRotacao(element.getText());
            	
            	if (element.getQualifiedName().equals("orbital_period"))
            		p.setOrbita(element.getText());
            	
            	if (element.getQualifiedName().equals("gravity"))
            		p.setGravidade(element.getText());
            	
            	if (element.getQualifiedName().equals("population"))
            		p.setPopulacao(element.getText());
            	
            	if (element.getQualifiedName().equals("climate"))
            		p.setClima(element.getText());
            	
            	if (element.getQualifiedName().equals("terrain"))
            		p.setTerreno(element.getText());
            	
            	if (element.getQualifiedName().equals("surface_water"))
            		p.setSupercicieAquatica(element.getText());
            	
            	if (element.getQualifiedName().equals("residents"))
            		p.setResidentes(element.getText());
            	
            	if (element.getQualifiedName().equals("films"))
                    p.setFilmes(element.getText());
            	
            	if (element.getQualifiedName().equals("url"))
                    p.setUrl(element.getText());
            	
            	getListaPlanetas().add(p);
            }
			return getListaPlanetas();
		} catch (MalformedURLException | DocumentException e) {
			log.error("Erro ao efetuar a busca por id", e);
			return null;
		}
	}
	
	 public static Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
 
        return document;
    }

	/**
	 * @return the listaPlanetas
	 */
	public static List<PlanetaServico> getListaPlanetas() {
		return listaPlanetas;
	}

	/**
	 * @param listaPlanetas the listaPlanetas to set
	 */
	public void setListaPlanetas(List<PlanetaServico> listaPlanetas) {
		this.listaPlanetas = listaPlanetas;
	}
}
