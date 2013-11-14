package br.com.maplink2.webservices.consumer;

import java.io.IOException;

import java.util.List;

import br.com.maplink2.json.io.DataInput;
import br.com.maplink2.json.io.DataOutput;
import br.com.maplink2.json.repository.JsonRepository;
import br.com.maplink2.webservices.repository.ConsumerWebServiceRepository;

/**
 * 
 * @author Fernando de Campos Pinheiro
 *<br>Classe:<b>ConsumerWebService</b>
 *<br>Responsavel por manipular as classes obtenção e geração({@link JsonRepository},{@link ConsumerWebServiceRepository}) de JSON  
 * e consumir o web service : <a href="http://services.maplink.com.br/webservices/v3/route/route.asmx">services.maplink.com.br/webservices/</a>
 *<br>
 */
public class CosumerWebService {

	
	
	public static void main(String[] args) throws IOException {
		
		//Local do arquivo JSON
		String addresInput="input/DadosEntradaAlterados.js";
		
		//Criamos um jsonRepository para manipular o JSON
		JsonRepository jsonRepository = new JsonRepository();
		
		//Obtemmos uma lista de DataInput com os dados JSON
		List<DataInput> listDataInput = jsonRepository.getListOfInputDataFile(addresInput);
		
		//Criamos um ConsumerWebServiceRepository  para consumirmos o web service.
		ConsumerWebServiceRepository cr = new ConsumerWebServiceRepository();
		
		//Obtemos uma lista de DataInput com o retorno do processamento
		List<DataOutput> listOutput = cr.getListDataOutputWebservice(listDataInput);
		
		
		//Usamos o jsonRepository para obtermos um arquivo .json, passando a lista e o local para o salvar arquivo.
		jsonRepository.generateJsonFile(listOutput, "C:/Destino");
		
	}
	
	
	
	
	
}
