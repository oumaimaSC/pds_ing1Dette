package esipe.pds.ajap.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;

import esipe.pds.ajap.common.Response;
import esipe.pds.ajap.common.Transportation;

public class test {

		public static void main(String[] args) throws IOException {
			readFichierjson table = new readFichierjson();

	
			
			Response mapTransportation = new ObjectMapper().readValue(table.readFiletransportation(), Response.class);
			
			System.out.println("readfile  :  "  + table.readFiletransportation()  );
			
		

			
			ArrayList<String> list =mapTransportation.getList();
			
			System.out.println(list);
			
	
			
			Transportation Vehicule = new Transportation();
			Transportation Tram = new Transportation();
			Transportation Bike = new Transportation();
			int i = 2;
			String typeoftransport= "";
			
		
			//System.out.println(list.size());
				while (i<list.size()) {
					//System.out.println(list.get(i));// idtransportation
					System.out.println(list.get(i+2)); //typeoftransport
					//System.out.println(list.get(i+4));//dailytransportusercount
					//System.out.println(list.get(i+6)); // averageofco2releasedbytransport
					typeoftransport = list.get(i+2);
					
					
					if(typeoftransport.equals("Tram")) {
						
						
						 Tram = new Transportation(Integer.parseInt(list.get(i)),list.get(i+2),Integer.parseInt(list.get(i+4)),Double.parseDouble(list.get(i+6)));
						
					}
					
					if(typeoftransport.equals("Vehicule")) {
						
						
						Vehicule = new Transportation(Integer.parseInt(list.get(i)),list.get(i+2),Integer.parseInt(list.get(i+4)),Double.parseDouble(list.get(i+6)));
						
					}
					
					
					if(typeoftransport.equals("Bike")) {
						
						
						Bike = new Transportation(Integer.parseInt(list.get(i)),list.get(i+2),Integer.parseInt(list.get(i+4)),Double.parseDouble(list.get(i+6)));
						
					}
					
					
					
					
					i+=10;
					//System.out.println("i ="+i);
				}
		
			System.out.println(Vehicule);
			System.out.println(Tram);
			System.out.println(Bike);
		}

	}


