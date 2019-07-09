package zavrsni;

import java.sql.*;
import java.util.*;

public class Recnik {

	private HashMap<String, String> recnik;
	private static String konekcija;
	private static Connection konektuj;

	public Recnik() {
		konekcija = "jdbc:sqlite:C:\\Users\\tamara\\Desktop\\Dictionary.db";
		recnik = new HashMap<String, String>();
	}

	public static void connect() throws SQLException {
		disconnect();
		konektuj = DriverManager.getConnection(konekcija);
	}

	public static void disconnect() throws SQLException {
		if (konektuj != null && !konektuj.isClosed()) {
			konektuj.close();

		}
	}

	public HashMap<String, String> getRecnik() {
		return recnik;
	}

	// copy all words and definition of words from sql file into HashMap recnik
	public void napraviRecnik() throws SQLException {

		connect();
		String upit = "select word, definition from entries";
		Statement stm = konektuj.createStatement();
		ResultSet rezultat = stm.executeQuery(upit);
		while (rezultat.next()) {
			String k = rezultat.getString("word").toLowerCase();
			String v = rezultat.getString("definition").toLowerCase();
			recnik.put(k, v);
		}
		rezultat.close();
		stm.close();
		disconnect();
	}

	// create new sql table and insert new words into that table
	public void prosiriBazu(StringBuilder s) throws SQLException {
		connect();
		String upit = "CREATE TABLE NoveReci (word text); insert into NoveReci (word) VALUES ('" + s + "')";
		Statement stm1 = konektuj.createStatement();
		stm1.executeUpdate(upit);
		stm1.close();
		disconnect();
	}

}
