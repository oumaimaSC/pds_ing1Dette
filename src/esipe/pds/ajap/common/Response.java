package esipe.pds.ajap.common;

import java.util.ArrayList;
//change ?
public class Response {
	ArrayList<String> list;

	public Response() {
	}
	
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Response " + list + "";
	}
	
	
	
}
