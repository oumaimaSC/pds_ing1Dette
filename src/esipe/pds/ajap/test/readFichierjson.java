package esipe.pds.ajap.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class readFichierjson {

	public String readFileCarbonEstimateConf() throws IOException {
		
		InputStream fis = new FileInputStream("resources/test/smartCity.json");
		InputStreamReader ipsr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(ipsr);
		String outjsonString = "";
		String chaine = "";

		while ((outjsonString = br.readLine()) != null) {
			chaine = chaine + outjsonString;
		}
		System.out.println("Request sent : " + chaine);
		return chaine;
	}

	public String readFiletransportation() throws IOException {
		InputStream fis = new FileInputStream("resources/test/transportation.json");
		InputStreamReader ipsr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(ipsr);
		String outjsonString = "";
		String chaine = "";

		while ((outjsonString = br.readLine()) != null) {
			chaine = chaine + outjsonString;
		}
		System.out.println("Data reading in the file : " + chaine);
		return chaine;
	}
	
	
}
