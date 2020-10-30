package oumaimaSC_server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oumaimaSC_common.Student;
import oumaimaSC_connection_pool.DataSource;

public class Crud_Controller {

	public Crud_Controller() throws ClassNotFoundException {
	}

	public Student existStudent(int id) throws ClassNotFoundException {
		Student retour = null;
		try {
			Connection con = DataSource.getConnection();

			PreparedStatement pt = con.prepareStatement("select * from student where id =" + id);
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				int idS = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				retour = new Student(idS, name, age);
				DataSource.returnConnection(con);
			}

		} catch (SQLException ex) {
			System.out.println("erreur " + ex.getMessage());
		}
		return retour;

	}

	// Request SELECT

	public ArrayList<Student> showStudent() throws ClassNotFoundException, InterruptedException {
		ArrayList<Student> retour = new ArrayList<Student>();
		try {
			System.out.println("Connexion available on connexion pool before use : "+DataSource.getListConnectionavailable().size());
	        Thread.sleep(3000);
			System.out.println("Using");
			Connection con = DataSource.getConnection();

			PreparedStatement pt = con.prepareStatement("select * from student");
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);

				retour.add(new Student(id, name, age));
				
			}
			long start = System.currentTimeMillis();
		      
		       // System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
		        
		        System.out.println("Connection available on connection pool after use "+DataSource.getListConnectionavailable().size());
		        System.out.println("15 seconde before the availability of the connection");
		        Thread.sleep(15000);
		        System.out.println(" return the connection+1");
		        DataSource.returnConnection(con);
		        System.out.println("Connection available on connection pool "+DataSource.getListConnectionavailable().size());

		} catch (SQLException ex) {
			System.out.println("erreur " + ex.getMessage());
		}
		return retour;

	}


	/*
	 * public void deleteStudentByName(int ID) throws ClassNotFoundException { try {
	 * Connection con = DataSource.getConnection(); Statement stmt =
	 * con.createStatement(); ResultSet rslt =
	 * stmt.executeQuery("select id from Student where name = " + name);
	 * while(rslt.next()) { if(rslt.equals(obj)) }
	 * 
	 * PreparedStatement pt = con
	 * .prepareStatement("delete from Student where name like ?"); pt.setString(1,
	 * name); pt.execute(); DataSource.returnConnection(con);
	 * 
	 * } catch (SQLException ex) { System.out.println("erreur " + ex.getMessage());
	 * }
	 * 
	 * }
	 */

	public void deleteStudentById(int ID) throws ClassNotFoundException {
		try {
			Connection con = DataSource.getConnection();
			PreparedStatement pt = con.prepareStatement("delete from student where id = " + ID);
			pt.execute();
			DataSource.returnConnection(con);

		}

		catch (SQLException ex) {
			System.out.println("erreur " + ex.getMessage());
		}
	}

	// Request INSERT

	public void addStudent(Student p) throws ClassNotFoundException {
		try {
			Connection con = DataSource.getConnection();

			String req = "insert into student (name,age) values (?,?)";
			PreparedStatement pstm = con.prepareStatement(req);
			pstm.setString(1, p.getName());
			pstm.setInt(2, p.getAge());
			pstm.executeUpdate();
			DataSource.returnConnection(con);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Request UPDATE

	public void updateStudentAge(int id, int age) throws ClassNotFoundException {
		try {
			Connection con = DataSource.getConnection();

			PreparedStatement pstm = con.prepareStatement(" UPDATE student SET age = ?  WHERE id = ?");
			pstm.setInt(1, age);
			pstm.setInt(2, id);
			pstm.executeUpdate();
			DataSource.returnConnection(con);

		} catch (SQLException ex) {
			System.out.println("erreur " + ex.getMessage());
		}
	}

	public void updateStudentName(int id, String name) throws ClassNotFoundException {
		try {
			Connection con = DataSource.getConnection();

			PreparedStatement pstm = con.prepareStatement(" UPDATE student SET name = ?  WHERE id = ?");
			pstm.setString(1, name);
			pstm.setInt(2, id);
			pstm.executeUpdate();
			DataSource.returnConnection(con);

		} catch (SQLException ex) {
			System.out.println("erreur " + ex.getMessage());
		}

	}

	public void deleteAllStudent() throws SQLException, ClassNotFoundException {
		Connection con = DataSource.getConnection();

		Statement query = con.createStatement();
		int result = query.executeUpdate("TRUNCATE TABLE student");
		DataSource.returnConnection(con);

	}
}
