package zavrsni;

import java.io.IOException;
import java.sql.SQLException;

public class KnjigaTest {

	public static void main(String[] args) {
		try {
			Knjiga k = new Knjiga();
			k.splitujKnjigu();
			System.out.println("Novih reci ima " + k.proveriReci().size());
			k.upisiSQL();
			System.out.println("Reci i koliko se puta ponavljaju: ");
			k.printniMapu();
			k.proveriDvadeset();
			k.upisiUfajl();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
