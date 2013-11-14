package br.com.maplink2.webservices.repository;


import java.util.ArrayList;
import java.util.List;
import br.com.maplink2.json.io.DataInput;
import br.com.maplink2.json.io.DataOutput;
import br.com.maplink2.webservices.ArrayOfMultiRouteRequest;
import br.com.maplink2.webservices.ArrayOfSingleRouteTotals;
import br.com.maplink2.webservices.MultiRoute;
import br.com.maplink2.webservices.MultiRouteRequest;
import br.com.maplink2.webservices.Point;
import br.com.maplink2.webservices.Route;
import br.com.maplink2.webservices.RouteDetails;
import br.com.maplink2.webservices.RouteOptions;
import br.com.maplink2.webservices.RouteSoap;
import br.com.maplink2.webservices.RouteStop;
import br.com.maplink2.webservices.SingleRouteTotals;
import br.com.maplink2.webservices.Vehicle;
/**
 * 
 * @author Fernando de Campos Pinheiro
 * <br>Classe:<b>ConsumerRepository</b>
 *<br><br>Responsável pelas operações dos dados({@link DataInput},{@link DataOutput}) de JSON com o web service
 *
 */
public class ConsumerWebServiceRepository {
	
	final String TOKEN ="c13iyCvmcC9mzwkLd0LCbmYC5mUF5m2jNGNtNGt6NmK6NJK=";
	private Point point;
	private RouteStop originRoute;
	private RouteStop destinationRoute;
	private ArrayOfMultiRouteRequest arrayOfMultiRouteRequest;
	private RouteDetails routeDetails;
	private Vehicle vehicle;
	private RouteOptions routeOptions;
	private MultiRouteRequest multiRouteRequest;
	private List<DataOutput> listDataOutput;
	private DataOutput dataOutput;

	
	/**
	 * 
	 * @param listDataInput
	 * @return List<listDataOutput> listDataOutput
	 *<br> Método:<b>getListDataOutputWebservice</b>
	 * Responsavel por lançar uma lista de {@link DataInput}<b>com valores defaut</b> e devolve um {@link DataOutput}
	 * para geração do JSON com o {@link JsonRepository }
	 * <br>
	 */
	public List<DataOutput> getListDataOutputWebservice(List<DataInput> listDataInput){
		//CHAVE
		this.arrayOfMultiRouteRequest= new ArrayOfMultiRouteRequest();
		
		for (DataInput dataInput : listDataInput) {
		
		
		//PONTO DE ORIGEM 
		this.point = new Point();
		this.point.setX(dataInput.getOriginCoordinate().getLatitude());
		this.point.setY(dataInput.getOriginCoordinate().getLongitude());
		this.originRoute = new RouteStop();
		this.originRoute.setPoint(point);

		//PONTO DE DESTINO
		this.point = new Point();
		this.point.setX(dataInput.getDestinationCoordinate().getLatitude());
		this.point.setY(dataInput.getDestinationCoordinate().getLongitude());
		this.destinationRoute = new RouteStop();
		this.destinationRoute.setPoint(point);
		
		//PEDIDO DE ROTA
		multiRouteRequest= new MultiRouteRequest();
		multiRouteRequest.setOrigin(originRoute);
		multiRouteRequest.setDestination(destinationRoute);
		
		//ARRAY COM OS PEDIDOS DE ROTAS
		this.arrayOfMultiRouteRequest.getMultiRouteRequest().add(multiRouteRequest);
		}
		
		
		
		//DETALHES DA ROTA
		routeDetails = new RouteDetails();
		routeDetails.setDescriptionType(0);
		routeDetails.setRouteType(1);
		routeDetails.setOptimizeRoute(true);
		
		//DADOS DO VEICULO
		vehicle = new Vehicle();
		vehicle.setTankCapacity(20);
		vehicle.setAverageConsumption(9);
		vehicle.setFuelPrice(3);
		vehicle.setAverageSpeed(60);
		vehicle.setTollFeeCat(2);
		
		//CONFIGURAÇÕES DA ROTA
		routeOptions = new RouteOptions();
		routeOptions.setLanguage("portugues");
		routeOptions.setRouteDetails(routeDetails);
		routeOptions.setVehicle(vehicle);
		//CHAMADA AO SOAP
		RouteSoap routeSoap = new Route().getRouteSoap();
		
		//LANÇA AS INFORMAÇÇOES DE TODAS AS ROTAS NO SOAP
		MultiRoute multiRoute = routeSoap.getMultiRoute(arrayOfMultiRouteRequest, routeOptions, TOKEN);
		
		//SOAP RETORNA OS TOTAIS DAS ROTAS
		ArrayOfSingleRouteTotals arraySingleRouteTotals = multiRoute.getSingleRouteTotals();
		
		listDataOutput = new ArrayList<DataOutput>();
		
		//LIST DE DATAOUPUT: ID , DISTANCIA , CUSTO DO COMBUSTIVEL E TEMPO GASTO
		for (SingleRouteTotals singleRouteTotals :arraySingleRouteTotals.getSingleRouteTotals()) {
			
			dataOutput =  new DataOutput();
			dataOutput.setId(singleRouteTotals.getLogRouteId());
			dataOutput.setFuelCost(singleRouteTotals.getRouteTotals().getTotalfuelCost());
			dataOutput.setDistance(singleRouteTotals.getRouteTotals().getTotalDistance());
			dataOutput.setTotalTime(singleRouteTotals.getRouteTotals().getTotalTime());
			listDataOutput.add(dataOutput);
		}
		
		System.out.println("web service consumido");
		return this.listDataOutput;
	}
	
	/**
	 * 
	 * @param listDataInput 
	 * @param routeDetails
	 * @param vehicle
	 * @return List<listDataOutput> listDataOutput
	 *<br> Método:<b>getListDataOutputWebservice</b>
	 * Responsavel por lançar uma lista de {@link DataInput} <b>com valores personalizados</b> e devolve um {@link DataOutput}
	 * para geração do JSON com o {@link JsonRepository }
	 * <br>
	 */
	public List<DataOutput> getListDataOutputWebservice(List<DataInput> listDataInput,RouteDetails routeDetails,Vehicle vehicle){
		//CHAVE
		this.arrayOfMultiRouteRequest= new ArrayOfMultiRouteRequest();
		
		for (DataInput dataInput : listDataInput) {
		
		
		//PONTO DE ORIGEM 
		this.point = new Point();
		this.point.setX(dataInput.getOriginCoordinate().getLatitude());
		this.point.setY(dataInput.getOriginCoordinate().getLongitude());
		this.originRoute = new RouteStop();
		this.originRoute.setPoint(point);

		//PONTO DE DESTINO
		this.point = new Point();
		this.point.setX(dataInput.getDestinationCoordinate().getLatitude());
		this.point.setY(dataInput.getDestinationCoordinate().getLongitude());
		this.destinationRoute = new RouteStop();
		this.destinationRoute.setPoint(point);
		
		//PEDIDO DE ROTA
		multiRouteRequest= new MultiRouteRequest();
		multiRouteRequest.setOrigin(originRoute);
		multiRouteRequest.setDestination(destinationRoute);
		
		//ARRAY COM OS PEDIDOS DE ROTAS
		this.arrayOfMultiRouteRequest.getMultiRouteRequest().add(multiRouteRequest);
		}
		
		//CONFIGURAÇÕES DA ROTA
		routeOptions = new RouteOptions();
		routeOptions.setLanguage("portugues");
		routeOptions.setRouteDetails(routeDetails);
		routeOptions.setVehicle(vehicle);
		//CHAMADA AO SOAP
		RouteSoap routeSoap = new Route().getRouteSoap();
		
		//LANÇA AS INFORMAÇÇOES DE TODAS AS ROTAS NO SOAP
		MultiRoute multiRoute = routeSoap.getMultiRoute(arrayOfMultiRouteRequest, routeOptions, TOKEN);
		
		//SOAP RETORNA OS TOTAIS DAS ROTAS
		ArrayOfSingleRouteTotals arraySingleRouteTotals = multiRoute.getSingleRouteTotals();
		
		listDataOutput = new ArrayList<DataOutput>();
		
		//LIST DE DATAOUPUT: ID , DISTANCIA , CUSTO DO COMBUSTIVEL E TEMPO GASTO
		for (SingleRouteTotals singleRouteTotals :arraySingleRouteTotals.getSingleRouteTotals()) {
			
			dataOutput =  new DataOutput();
			dataOutput.setId(singleRouteTotals.getLogRouteId());
			dataOutput.setFuelCost(singleRouteTotals.getRouteTotals().getTotalfuelCost());
			dataOutput.setDistance(singleRouteTotals.getRouteTotals().getTotalDistance());
			dataOutput.setTotalTime(singleRouteTotals.getRouteTotals().getTotalTime());
			listDataOutput.add(dataOutput);
		}
		
		System.out.println("web service consumido");
		return this.listDataOutput;
	}
	

	public ConsumerWebServiceRepository() {
		super();
		System.out.println("consumindo web service .. ... ..");
	}
	
}
