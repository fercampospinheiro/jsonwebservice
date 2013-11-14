package br.com.maplink2.json.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import br.com.maplink2.json.io.DataInput;
import br.com.maplink2.json.io.DataOutput;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 * @author Fernando de Campos Pinheiro
 * <br>Classe:<b>JsonRepository</b>
 *<br><br>Responsável pelas operações de manipulação dos dados tipo {@link DataInput}e {@link DataOutput} para JSON ou Java. 
 *
 */
public class JsonRepository {

	public JsonRepository() {
		System.out.println("JsonRepository manipulando informações referentes a Json");
	}
/**
 * 
 * @param URL
 * @return String
 * <br>
 * Pega um JSON de uma URL e converte em String
 * <br>
 */
	public String getJsonURL(String URL){
		Client client = Client.create();
		WebResource resourceJSON = client.resource(URL);
		return resourceJSON.get(String.class);
	}
	
	/**
	 * 
	 * @param o 
	 * @return String
	 * <br>Converte um objeto Java em um JSON String<br>
	 */
	public String parseObjectForJsonString(Object o ){
		try{
		return new Gson().toJson(o);
		}catch (ClassCastException e) {
			e.getMessage();
			System.out.println("Erro na conversao da classe para Json");
		}
		return null;
	}
	
/**
 * @param json
 * @param outputAddress<br>
 * <br>Recebe um JSON em String + endereço em String do local do arquivo 
 * .json aonde será salvo.<b> Não precisa informar o nome do arquivo</b>
 * será criado por padrão um arquivo <b>new.json</b><br>
 */
	public void generateJsonFileOfString(String json,String outputAddress) {
		
			File arquivo = new File(outputAddress+"/new"+".json");
			FileWriter fw;
			try {
				fw = new FileWriter(arquivo);
				fw.write(json);
				fw.close();
				System.out.println("Arquivo Json(new.js) gerado com sucesso na pasta : "+outputAddress);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getMessage();
				System.out.println("Não foi possivel gerar o arquivo json");
			}
		

		
		
	}
	/**
	 * @param t
	 * @param addressOutput<br>
	 * <br>Recebe um List<{@link DataInput}> ou List<{@link DataOutput}> + o endereço local
	 * onde será salvo o arquivo .json .<b> Não precisa informar o nome do arquivo</b>
     * será criado por padrão um arquivo <b>new.json</b><br><br>
	 */
	
	public void generateJsonFile(Object objectJson ,String addressOutput){
		JsonRepository jr = new JsonRepository();
		jr.generateJsonFileOfString(jr.parseObjectForJsonString(objectJson),addressOutput);
		
	}
	
/** 
 * @param URL
 * @return List<DataInput><br>
 * <br>Converte uma lista JSON de uma URL para uma lista {@link DataInput}   
 * <br>
 */
	public  List<DataInput> parseListDataInput(String URL){
		
		Client client = Client.create();
		WebResource resourceJSON = client.resource(URL);
		String json = resourceJSON.get(String.class);
		 Type listType = new TypeToken<List<DataInput>>(){}.getType();  
	     List<DataInput> list = new Gson().fromJson(json, listType);    
	     return list;  

	}
	
/**
 * @param addressFile
 * @return List<DataInput>
 * @throws FileNotFoundException<br>
 * <br>Converte uma lista JSON de um arquivo local para uma lista de {@link DataInput}
 * <br>
 */	
	public  List<DataInput> getListOfInputDataFile(String addressFile) throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader(addressFile));
		 Type listType = new TypeToken<List<DataInput>>(){}.getType();  
	     List<DataInput> list = new Gson().fromJson(br, listType);
		return list;
	}
	
	/** 
	 * @param URL
	 * @return List<DataOutput><br>
	 * <br>Converte uma lista Json de uma URL para uma lista {@link DataOutput}   
	 * <br>
	 */
	public  List<DataOutput> getListDataOutput(String URL){
		
		Client client = Client.create();
		WebResource resourceJSON = client.resource(URL);
		String json = resourceJSON.get(String.class);
		 Type listType = new TypeToken<List<DataOutput>>(){}.getType();  
	     List<DataOutput> list = new Gson().fromJson(json, listType);    
	     return list;  

	}
	/**
	 * @param addressFile
	 * @return List<DataOutput>
	 * @throws FileNotFoundException
	 *<br> Converte uma lista JSON de um arquivo local para uma lista de {@link DataOutput}
	 *<br>
	 */	
	public  List<DataOutput> getListOfOutputDataFile(String addressFile) throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader(addressFile));
		 Type listType = new TypeToken<List<DataOutput>>(){}.getType();  
	     List<DataOutput> list = new Gson().fromJson(br, listType);
		return list;
	}
	
	
	
}
