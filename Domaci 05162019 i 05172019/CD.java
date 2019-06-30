package domaci05172019;


public class CD extends AlbumArtikal {

	public CD(Album album, String izdavac, double cena, int kolicina) {
		super(album, izdavac, cena, kolicina);

	}

	public String ime() {
		String str;
		str = CD.super.getAlbum() + "(CD)";
		return str;

	}
}
