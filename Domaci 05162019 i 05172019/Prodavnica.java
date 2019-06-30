package domaci05172019;

import java.util.LinkedList;
import java.util.Scanner;

public class Prodavnica {
	private String ime;
	private String lokacija;
	private LinkedList<Artikal> inventar;

	public Prodavnica(String ime, String lokacija) {
		this.ime = ime;
		this.lokacija = lokacija;
		this.inventar = new LinkedList <Artikal>();
	}

	
	public void dodaj(Artikal i) {
		
		inventar.add(i);
		
	}

	public LinkedList<Artikal> pretrazi(String tekst) {

		LinkedList<Artikal> ponuda = new LinkedList<Artikal>();
		for (int i = 0; i < inventar.size(); i++) {
			
			if (inventar.get(i).toLowerCase().contains(tekst.toLowerCase())) {
				
				ponuda.add(inventar.get(i));
				System.out.println(ponuda);
			} else {
				System.out.println("Trazeni artikal nemamo u ponudi");
			}
		}
		return ponuda;
	}

	public String getIme() {
		return ime;
	}
	

	public String getLokacija() {
		return lokacija;
	}

	public String toString() {
		String str;
		str = ime + ": " + lokacija + inventar.toString();
		return str;
	}

}
