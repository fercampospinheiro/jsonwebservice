package br.com.maplink2.json.io;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Fernando de Campos Pinheiro
 * <br>Classe:<b>DataOutput</b>
 *<br><br>Modelo resposável por receber os dados JSON de sáida do Webservice, String para Java.  
 *
 */
@XmlRootElement
public class DataOutput {
	
	private String id;
	private Double distance;
	private Double fuelCost;
	private String totalTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getFuelCost() {
		return fuelCost;
	}
	public void setFuelCost(Double fuelCost) {
		this.fuelCost = fuelCost;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

}
