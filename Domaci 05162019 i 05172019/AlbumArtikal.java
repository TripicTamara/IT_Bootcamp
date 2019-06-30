package domaci05172019;
//AlbumArtikal je apstraktna klasa koja nasleuje klasu Artikal i opisana je albumom i izdavaem tipa string.

public class AlbumArtikal extends Artikal {
	private Album album;
	private String izdavac;
	
	public AlbumArtikal(Album album, String izdavac, double cena, int kolicina) {
		super (cena, kolicina);
		this.album = album;
		this.izdavac = izdavac;
	}

	public String ime() {
		return ime();
		
	}

	public Album getAlbum() {
		return album;
	}

	public String getIzdavac() {
		return izdavac;
	}
	

}
