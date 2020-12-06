package esipe.pds.ajap.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import esipe.pds.ajap.client.CalculS;
import esipe.pds.ajap.common.Request;
import esipe.pds.ajap.common.SmartCity;
import esipe.pds.ajap.common.Transportation;


public class testPolitiqueDeDeplacement_NotSuccessful {

	public SmartCity getSmartCity() {
		try {				
			readFichierjson table = new readFichierjson();
			String s = table.readFileCarbonEstimateConf();///// STACK THE FILE'S VALUES INTO s			
			SmartCity sc=new ObjectMapper().readValue(s, SmartCity.class);		
			return sc;
		}
		catch(Exception e) {
			System.out.println("erreur"+e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Transportation gettransportation() {
		try {				
			readFichierjson table = new readFichierjson();
			String t = table.readFiletransportation();		
			Transportation tr=new ObjectMapper().readValue(t, Transportation.class);	
		
			return tr;
		}
		catch(Exception e) {
			System.out.println("erreur"+e);
			e.printStackTrace();
		}
		
		return null;
	}

	public static int somme(int a, int b, int c,int d)
	    {
	        return a+b+c+d;
	    }
	
	public double getPerimetreValueOfSmartCity(SmartCity sc) {
		return sc.getHeightkm();	
	}


	
	 public static void main(String[] args) {
		    System.out.println("**********************************");
			System.out.println("  THE BEGINNING OF THE TEST 1");
			System.out.println("**********************************");
			System.out.println("IN THIS TEST WE WILL PROPOSE a good  TRAVEL POLICY");
			System.out.println("EXPECTED RESULT :the current travel policy is better than the proposed travel policy");
////////////////initialisation des données ////////////////////////
			CalculS calcul = new CalculS();
			testPolitiqueDeDeplacement_NotSuccessful test=new testPolitiqueDeDeplacement_NotSuccessful(); 
			testPolitiqueDeDeplacement_NotSuccessful test1=new testPolitiqueDeDeplacement_NotSuccessful();
			
			
			SmartCity sc = test.getSmartCity();	
			double perimetre=test.getPerimetreValueOfSmartCity(sc);
			
		
			int nbreVehiculeD=4000;
			int nbreTramD=2000;
			int nbreCyclisteD=1000;
			int nbrePopulation= 10000;
			 
			int nbreVehiculeE=5000;
			int nbreTramE=5000;
			int nbrePietonE=500;
			int nbreCyclisteE=50;
			int nbrePietonD=(nbrePopulation-nbreVehiculeD-nbreTramD-nbreCyclisteD);
			
			
///////////// transition ///////////////////////////////////////
			double calculD =calcul.estimatedThreshold (nbreVehiculeD,perimetre , nbreCyclisteD, nbreTramD, nbrePietonD);
			double calculE =calcul.estimatedThreshold (nbreVehiculeE,perimetre , nbreCyclisteE, nbreTramE, nbrePietonE);
			 System.out.println("*********3***********");
			System.out.println("the proposed travel policy" );
			System.out.println("perimetre : "+perimetre );
			System.out.println("The number of vehicles :" + nbreVehiculeE);
			 System.out.println("The number of vehicles :" + nbreVehiculeE);
			 System.out.println("The number of cyclists :" + nbreCyclisteE);
			 System.out.println("the number of pedestrians :" + nbrePietonE);
			 System.out.println("the number of tram users:" + nbreTramE);
			 System.out.println("pollution threshold : "+ calculE);
			 System.out.println("**********************************");
			 System.out.println("**********************************");
			 System.out.println("the current travel policy" );
			 System.out.println("The number of vehicles :" + nbreVehiculeD);
			 System.out.println("The number of cyclists :" + nbreCyclisteD);
			 System.out.println("the number of pedestrians :" + nbrePietonD);
			 System.out.println("the number of tram users:" + nbreTramD); 
			 System.out.println("the current pollution threshold :" + calculD);
			 
/////verification///////////////////////////////////////////////////////////////				
			if (calculE< calculD) {
					System.out.println("Conclusion :the proposed travel policy is better than the current travel policy");
			 }
			 else {
				System.out.println("Conclusion :the current travel policy is better than the proposed travel policy");
				 
			}
				System.out.println(" FINAL ");
				System.out.println(" ********************************************* ");



			} 	
			
		
	 }
//}
