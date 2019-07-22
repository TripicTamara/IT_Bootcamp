package prodavnicaAutomobila;

import java.sql.*;

public class ProdavnicaMetode {
	private String konekcija;
	private Connection konektuj;
	
	public ProdavnicaMetode () {
		konekcija = "jdbc:sqlite:C:\\Users\\tamara\\Desktop\\ProdavnicaAutomobila.db";
	
	}
	
	public void connect () throws SQLException {
		disconnect();
		konektuj = DriverManager.getConnection(konekcija);
	}
	public void disconnect() throws SQLException {
		if (konektuj != null && !konektuj.isClosed()) {
			konektuj.close();
			
		}
}
	//check database for ussername
	public boolean proveriKorisnika (String usser) throws SQLException {
		boolean provera = false;
		String upitic = "select count (*) from Korisnik where Ussername ='"+usser+"' ";
		Statement stm = konektuj.createStatement();
		ResultSet rezultat = stm.executeQuery(upitic);
		while (rezultat.next()) {
		int broj = rezultat.getInt(1);
		
		
		if (broj<1)
		 { 
			provera = true;
		}
		else provera = false;
		stm.close();
		}
		return provera;
		
		}
	
	//create new member
	public void kreirajKorisnika (String usser,  String pass) throws SQLException {
		String upit = "insert into Korisnik (Ussername, Password) values ('"+usser+"','"+pass+"')";
		Statement stm1 = konektuj.createStatement();
		stm1.executeUpdate(upit);
		stm1.close();
	}
	//login	
	public boolean login (String ussername, String password) throws SQLException {
		boolean provera1 = false;
		String upitic1 = "select count (*) from Korisnik where Ussername ='"+ussername+"' and Password ='"+password+"' ";
		Statement stm4 = konektuj.createStatement();
		ResultSet rezultat1 = stm4.executeQuery(upitic1);
		while (rezultat1.next()) {
		int broj1 = rezultat1.getInt(1);
		
		if (broj1==1)
		 { 
			provera1 = true;
		}
		else provera1 = false;
		stm4.close();
		}
		return provera1;
		
		}
	//print the offer of available cars
	 public void ispisAutomobila () throws SQLException {
		 String upit = "select model.naziv, nabavka.prodajnaCena from nabavka, Model where model.idAutomobila = nabavka.idAutomobila group by nabavka.IdAutomobila";
		 Statement stm = konektuj.createStatement();
		 ResultSet rezultat = stm.executeQuery(upit);
		 while(rezultat.next()) {
			 String naziv =rezultat.getString(1);
			 double cena = rezultat.getInt(2);
			 
			 System.out.println(naziv + " " +cena);

		 }
	 }
	 //buy a car
	public void kupiAutomobil (int kupovina, String ussername, Date datum) throws SQLException {
		String upit2 = "insert into prodaja ('idautomobila', ussername, datum) values ('"+kupovina+"','"+ussername+"','"+datum+"'); insert into prodaja select prodajnaCena from nabavka where idAutomobila ='"+kupovina+"'; delete from nabavka where nabavka.IdAutomobila ='"+kupovina+"'; delete from automobil where automobil.IdAutomobila ='"+kupovina+"'";
		Statement stm = konektuj.createStatement();
		stm.executeUpdate(upit2);
		stm.close();
	}
	//increment number of sold cars
	public void incBrProdatih(int idAuto) throws SQLException {
		String upitMod = "select Model.IdModela from Model, Automobil where Automobil.IdModela = Model.IdModela and Automobil.IdAutomobila= "
				+ idAuto;
		Statement stm = konektuj.createStatement();
		ResultSet rs = stm.executeQuery(upitMod);

		int idModel = rs.getInt(1);
		String upit = "UPDATE Model SET BrProdatih =  BrProdatih + 1 where IdModela= " + idModel;
		Statement stm1 = konektuj.createStatement();
		stm.executeUpdate(upit);
		stm.close();
	}
	//print all sold cars by ussername
	public void prikaziKupljene(String ime) throws SQLException {
		System.out.println("\n\nKupljeni automobili: ");
		String upit = "SELECT prodaja.idAutomobila, model.idModela, prodaja.prodajnacena FROM prodaja, model \r\n"
				+ " WHERE  prodaja.IdAutomobila = model.idAutomobila and model.idmodela = automobil.idmodela" + " AND prodaja.Username = '" + ime + "'";

		Statement stm = konektuj.createStatement();
		ResultSet rezultat = stm.executeQuery(upit);
		while (rezultat.next()) {
			System.out.println(rezultat.getInt(1) + "   " + rezultat.getString(2) + "   " + rezultat.getDouble(3));
		}
		stm.close();
	}
		
		
		
	}



	

