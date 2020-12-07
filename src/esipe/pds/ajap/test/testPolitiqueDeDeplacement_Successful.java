package esipe.pds.ajap.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;

import esipe.pds.ajap.client.CalculS;
import esipe.pds.ajap.common.Request;
import esipe.pds.ajap.common.Response;
import esipe.pds.ajap.common.SmartCity;
import esipe.pds.ajap.common.Transportation;

public class testPolitiqueDeDeplacement_Successful {

	public SmartCity getSmartCity() {
		try {
			readFichierjson table = new readFichierjson();
			String s = table.readFileCarbonEstimateConf();
			SmartCity sc = new ObjectMapper().readValue(s, SmartCity.class);
			return sc;
		} catch (Exception e) {
			System.out.println("erreur" + e);
			e.printStackTrace();
		}

		return null;
	}

	public Transportation gettransportation() {
		try {
			readFichierjson table = new readFichierjson();
			String t = table.readFiletransportation();
			Transportation tr = new ObjectMapper().readValue(t, Transportation.class);

			return tr;
		} catch (Exception e) {
			System.out.println("erreur" + e);
			e.printStackTrace();
		}

		return null;
	}

	public static int somme(int a, int b, int c, int d) {
		return a + b + c + d;
	}

	public double getPerimetreValueOfSmartCity(SmartCity sc) {
		return sc.getHeightkm();
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
////////////////initialisation des données ////////////////////////
		CalculS calcul = new CalculS();
		testPolitiqueDeDeplacement_NotSuccessful test = new testPolitiqueDeDeplacement_NotSuccessful();
		testPolitiqueDeDeplacement_NotSuccessful test1 = new testPolitiqueDeDeplacement_NotSuccessful();

		SmartCity sc = test.getSmartCity();
		double perimetre = test.getPerimetreValueOfSmartCity(sc);
		
		
		readFichierjson table = new readFichierjson();

		Response mapTransportation = new ObjectMapper().readValue(table.readFiletransportation(), Response.class);

		System.out.println("readfile  :  " + table.readFiletransportation());

		ArrayList<String> list = mapTransportation.getList();

		System.out.println(list);

		Transportation Vehicule = new Transportation();
		Transportation Tram = new Transportation();
		Transportation Bike = new Transportation();
		int i = 2;
		String typeoftransport = "";

		// System.out.println(list.size());
		while (i < list.size()) {
			// System.out.println(list.get(i));// idtransportation
			System.out.println(list.get(i + 2)); // typeoftransport
			// System.out.println(list.get(i+4));//dailytransportusercount
			// System.out.println(list.get(i+6)); // averageofco2releasedbytransport
			typeoftransport = list.get(i + 2);

			if (typeoftransport.equals("Tram")) {

				Tram = new Transportation(Integer.parseInt(list.get(i)), list.get(i + 2),
						Integer.parseInt(list.get(i + 4)), Double.parseDouble(list.get(i + 6)));

			}

			if (typeoftransport.equals("Vehicule")) {

				Vehicule = new Transportation(Integer.parseInt(list.get(i)), list.get(i + 2),
						Integer.parseInt(list.get(i + 4)), Double.parseDouble(list.get(i + 6)));

			}

			if (typeoftransport.equals("Bike")) {

				Bike = new Transportation(Integer.parseInt(list.get(i)), list.get(i + 2),
						Integer.parseInt(list.get(i + 4)), Double.parseDouble(list.get(i + 6)));

			}

			i += 10;
			// System.out.println("i ="+i);
		}

		int nbreVehiculeD = Vehicule.getDailytransportusercount();
		int nbreTramD = Tram.getDailytransportusercount();
		int nbreCyclisteD = Bike.getDailytransportusercount();
		int nbrePopulation = 10000;

		int nbreVehiculeE=2000;
		int nbreTramE=1000;
		int nbrePietonE=5000;
		int nbreCyclisteE=500;
		int nbrePietonD = (nbrePopulation - nbreVehiculeD - nbreTramD - nbreCyclisteD);

		System.out.println("**********************************");
		System.out.println("  THE BEGINNING OF THE TEST 1");
		System.out.println("**********************************");
		System.out.println("IN THIS TEST WE WILL PROPOSE A GOOD  TRAVEL POLICY");
		System.out.println("EXPECTED RESULT :the proposed travel policy is better than the current travel policy");
		System.out.println("EXPECTED RESULT : Estimate pollution threshold = 21718.87");
		System.out.println("EXPECTED RESULT :the current pollution threshold = 42997.93");
///////////// transition ///////////////////////////////////////
		double calculD = calcul.estimatedThreshold(nbreVehiculeD, perimetre, nbreCyclisteD, nbreTramD, nbrePietonD);
		double calculE = calcul.estimatedThreshold(nbreVehiculeE, perimetre, nbreCyclisteE, nbreTramE, nbrePietonE);
		
		System.out.println("the proposed travel policy");
		System.out.println("perimetre : " + perimetre);
		System.out.println("The number of vehicles :" + nbreVehiculeE);
		System.out.println("The number of vehicles :" + nbreVehiculeE);
		System.out.println("The number of cyclists :" + nbreCyclisteE);
		System.out.println("the number of pedestrians :" + nbrePietonE);
		System.out.println("the number of tram users:" + nbreTramE);
		System.out.println("pollution threshold : " + calculE);
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("the current travel policy");
		System.out.println("The number of vehicles :" + nbreVehiculeD);
		System.out.println("The number of cyclists :" + nbreCyclisteD);
		System.out.println("the number of pedestrians :" + nbrePietonD);
		System.out.println("the number of tram users:" + nbreTramD);
		System.out.println("the current pollution threshold :" + calculD);

/////verification///////////////////////////////////////////////////////////////				
		if (calculE < calculD) {
			System.out.println("Conclusion :the proposed travel policy is better than the current travel policy");
		} else {
			System.out.println("Conclusion :the current travel policy is better than the proposed travel policy");

		}
		System.out.println(" FINAL ");
		System.out.println(" ********************************************* ");

	}

}
//}
