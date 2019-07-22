package prodavnicaAutomobila;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

public class ProdavnicaProgram {

	public static void main(String[] args) throws SQLException {
		try {
			ProdavnicaMetode p = new ProdavnicaMetode();
			p.connect();
			Scanner s = new Scanner(System.in);
			
			System.out.println("Dobrodosli u prodavnicu Automobila!");
			System.out.println("Izaberite opciju:");
			System.out.println("1. Kreiranje naloga \n2.Uloguj se \n3. Nastavi kao neregistrovan korisnik");
			int odgovor = s.nextInt();
			String ime;
			String sifra;

			switch (odgovor) {
			case 1:
				System.out.println("Unesite korisnicko ime");
				ime = s.next();
				System.out.println("Unesite sifru");
				sifra = s.next();
				
				while (p.proveriKorisnika(ime)!= true) {
					System.out.println("Uneto korisnicko ime, vec postoji u bazi, molimo pokusajte ponovo");
					System.out.println("Unesite korisnicko ime");
					ime = s.next();
					System.out.println("Unesite sifru");
					sifra = s.next();
					p.proveriKorisnika(ime);
				}
					if (p.proveriKorisnika(ime) == true) {
						p.kreirajKorisnika(ime, sifra);
						break;

					}
						
			case 2:
				System.out.println("Unesite korisnicko ime:");
				ime = s.next();
				System.out.println("Unesite sifru");
				sifra = s.next();

				if (p.login(ime, sifra) == true) {
					
					if (!ime.equals("admin")) {
						System.out.println("\n\n");
						System.out.println("Kupovina (1) ili Placanje (2)?");
						int kp = s.nextInt();
						if (kp == 1) {

							p.ispisAutomobila();
							System.out.println("Zelite li da kupite automobil?");
							String odg = s.next();
							if (odg.toLowerCase().equals("da")) {
		
							System.out.println("Odaberite automobil.");
							int idAuto = s.nextInt();
							Date datum = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
							p.kupiAutomobil(idAuto, ime, datum);
							p.incBrProdatih(idAuto);

							}
							else break;
							
						} else if (kp == 2) {
							p.prikaziKupljene(ime);
							System.out.println("Odaberite automobil.");
							int idAuto = s.nextInt();
							System.out.println("Iznos uplate: ");
							int iznos = s.nextInt();
							//p.uplati(idAuto, iznos, ime); - zavrsi naknadno metodu

						}

				break;
					}
				s.close();
			p.disconnect();
		}
		} 
		}
		catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
