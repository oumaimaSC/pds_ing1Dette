package esipe.pds.ajap.connection_pool;

import esipe.pds.ajap.server.Crud_Service;;

public class OumaimaMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Crud_Service cs = new Crud_Service();
		cs.addStudent("alain", 22);
		System.out.println("hi");

	}


}
