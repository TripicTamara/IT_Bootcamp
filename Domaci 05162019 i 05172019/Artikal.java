package domaci05172019;

public abstract class Artikal {
	public static int idGlobal = 1;
	
	private int id;
	private double cena;
	private int kolicina;
	
	public Artikal (double cena, int kolicina) {
		this.cena = cena;
		this.kolicina = kolicina;
		id = idGlobal;
		idGlobal++;
	}
	public boolean kupi () {
		boolean kupi = false;

		if (kolicina > 0) {
			kupi = true;
			kolicina--;
		}
		else {
			kupi = false;
		}
		return kupi;
		}
	
		public abstract String ime();
		
		public String toString () {
			String str;
			str = "#" + id + ":" + /*Artikal.ime +*/ " - " + cena + "[kol: "+kolicina+"]";
			return str;
		}

	public static int getIdGlobal() {
		return idGlobal;
	}

	public int getId() {
		return id;
	}

	public double getCena() {
		return cena;
	}

	public int getKolicina() {
		return kolicina;
	}
	
	

}
