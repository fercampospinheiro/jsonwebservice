package br.com.maplink2.json.io;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Fernando de Campos Pinheiro
 * <br>Classe:<b>DataInput</b>
 *<br><br>Modelo resposável por receber os dados JSON vindo de uma URL ou arquivo, String para Java.  
 *
 */

@XmlRootElement
public class DataInput {

	private String id;
	private OriginCoordinate originCoordinate;
	private DestinationCoordinate destinationCoordinate;
	
	public DataInput() {
		super();
	}

	
	public DestinationCoordinate getDestinationCoordinate() {
		return destinationCoordinate;
	}
	public void setDestinationCoordinate(DestinationCoordinate destinationCoordinate) {
		this.destinationCoordinate = destinationCoordinate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OriginCoordinate getOriginCoordinate() {
		return originCoordinate;
	}
	public void setOriginCoordinate(OriginCoordinate originCoordinate) {
		this.originCoordinate = originCoordinate;
	}
}
