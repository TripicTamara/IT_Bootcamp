package domaci05172019;


public class Numera {
	private String naziv;
	private String izvodjac;
	private String trajanje;
	
	
	public Numera(String izvodjac, String naziv, String trajanje) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.trajanje = trajanje;
				
}
	public String getNaziv() {
		return naziv;
	}
	public String getIzvodjac() {
		return izvodjac;
	}

	public String getTrajanje() {
		return trajanje;
	}
	
	public String toString() {
		String str;
		str =izvodjac + " - " + naziv + ": " + trajanje + "\n";
		return str;
	}
}
