package domaci05172019;

import java.util.Date;
import java.util.LinkedList;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private LinkedList<Numera> lista;

	public Album(String naziv, String izvodjac, Date datum) {

		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;

	}

	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public Date getDatum() {

		return datum;
	}

	public String getTrajanje() {
		int trajanje = 0;
		for (int i = 0; i < lista.size(); i++) {
			String[] splitovano = lista.get(i).getTrajanje().split(":");
			trajanje += Integer.parseInt(splitovano[0]) * 60 + Integer.parseInt(splitovano[1]);
		}
		return toString() + trajanje / 60 + trajanje % 60;
	}

	public Numera getNumera(int index) {
		return lista.get(index);
	}

	public Numera getNumera(String ime) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNaziv().equals(ime))
				return lista.get(i); 
		}
		
		return null;
	}

	public String toString() {
		String st;
		st = izvodjac + " - " + naziv + "(" + datum + ") : \n";
		st += lista.toString();
		return st;
	}

}
