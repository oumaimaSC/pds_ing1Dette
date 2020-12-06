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


public class testPolitiqueDeDeplacement_Successful {
/*
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
	
	public ArrayList<String> gettransportation() {
		try {				
			readFichierjson table = new readFichierjson();
			String t = table.readFiletransportation();		
			Request tr=new ObjectMapper().readValue(t, Request.class);	
			ArrayList<String> listInfo = tr.getList();
			return listInfo;
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

	public int getnbreTramD (ArrayList<String> listInfo) { 
		for (int i = 0; i < listInfo.size(); i++) {
		if (listInfo.getTypeoftransport() =="tram" ) {
			int n = listInfo.getDailytransportusercount();
			 System.out.print("getnbreTramD"+n);
			 return n;
		}
		else { 
			return 0; 
				}}
		
	}
	public int getnbreCyclisteD(Transportation tr) {
		
		if (tr.getTypeoftransport()=="Bike") {
			int n = tr.getDailytransportusercount();
		System.out.print("getnbreCyclisteD"+n);
		return n;
		}
		else { 
			return 0; 
				}}
	public int getnbreVehiculeD(Transportation tr) {
		if (tr.getTypeoftransport()== "Vehicule" ) {
			int n = tr.getDailytransportusercount();
			 System.out.print(" getnbreVehiculeD"+n);
		return n;
		}
		else { 
			return 0; 
				}}
	
	 public static void main(String[] args) {
		    System.out.println("**********************************");
			System.out.println("  THE BEGINNING OF THE TEST 1");
			System.out.println("**********************************");
			System.out.println("IN THIS TEST WE WILL PROPOSE  TRAVEL POLICY WORST THEN HE CURRENT TRAVEL POLICY");
			System.out.println("EXPECTED RESULT : the current travel policy is better than the proposed travel policy ");
////////////////initialisation des données ////////////////////////
			CalculS calcul = new CalculS();
			testPolitiqueDeDeplacement_NotSuccessful test=new testPolitiqueDeDeplacement_NotSuccessful(); 
			testPolitiqueDeDeplacement_NotSuccessful test1=new testPolitiqueDeDeplacement_NotSuccessful();
			
			
			SmartCity sc = test.getSmartCity();	
			double perimetre=test.getPerimetreValueOfSmartCity(sc);
			
			ArrayList<String> tr= test1.gettransportation() ;
		    int nbreVehiculeD=test1.getnbreVehiculeD(tr);
		    int nbreTramD=test1.getnbreTramD(tr);
		    int nbreCyclisteD=test1.getnbreCyclisteD(tr);

			//int nbreVehiculeD=4000;
			//int nbreTramD=2000;
			//int nbreCyclisteD=1000;
			int nbrePopulation= 10000;
			 
			int nbreVehiculeE=5000;
			int nbreTramE=5000;
			int nbrePietonE=500;
			int nbreCyclisteE=50;
			int nbrePietonD=(nbrePopulation-nbreVehiculeD-nbreTramD-nbreCyclisteD);
			
			
///////////// transition ///////////////////////////////////////
			double calculD =calcul.estimatedThreshold (nbreVehiculeD,perimetre , nbreCyclisteD, nbreTramD, nbrePietonD);
			double calculE =calcul.estimatedThreshold (nbreVehiculeE,perimetre , nbreCyclisteE, nbreTramE, nbrePietonE);
			 
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
	*/		
		
	 }
//}
