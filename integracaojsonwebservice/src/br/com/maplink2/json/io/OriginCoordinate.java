package br.com.maplink2.json.io;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Fernando de Campos Pinheiro
 * <br>Classe:<b>DestionationCoordina</b>
 *<br><br>Modelo responsável pelas coordenadas de origem
 *
 */
@XmlRootElement
public class OriginCoordinate {
	private Double latitude;
	private Double longitude;
	
	public OriginCoordinate(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
