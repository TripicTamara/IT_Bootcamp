package domaci05172019;


public class LP extends AlbumArtikal {
	
private int tezina;

public LP (Album album, String izdavac, double cena, int kolicina,  int tezina) {
	super (album, izdavac, cena,kolicina);
	this.tezina = tezina;
}

public String ime() {
	String str;
	str = LP.super.getAlbum() + "(" + tezina+ "[g] LP";
	return str;
	
}

}
