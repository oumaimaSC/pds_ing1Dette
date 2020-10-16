package oumaimaSC_server;

import java.io.IOException;
import java.net.ServerSocket;

import org.json.JSONException;

import oumaimaSC_connection_pool.DataSource;

public class ServerOumaima {
	private ServerSocket serverSocket;
	private static DataSource datasource;

	public void start(int port) throws IOException, JSONException, ClassNotFoundException {
		serverSocket = new ServerSocket(port);
		datasource = new DataSource();
		while (true) {
			new ClientThread(serverSocket.accept()).start();
		}
	}

	public void CloseConnection() throws IOException {
		serverSocket.close();
		System.out.println("Server deconnecte");
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public static void main(String[] args) throws IOException, JSONException, ClassNotFoundException {
		ServerOumaima serveur1 = new ServerOumaima();
		serveur1.start(3030);
		serveur1.CloseConnection();
	}

}
