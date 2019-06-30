package domaci05172019;
/* ovde sam ipak probala da uradim metodu za pretragu, na osnovu one za niz, ali ocigledno
 * opet nesto nisam primenila kako treba, jer mi ispisuje samo do te linije*/
 
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestProdavnica {
	public static void simulacija(Prodavnica p, String zelja) {
		System.out.println("-- Kupac ulazi u radnju --");
		System.out.println("Kupac: Dobar dan! Zeleo bih da kupim nesto od " + zelja + "-a!");
		List<Artikal> ponuda = p.pretrazi(zelja);
		if(ponuda.size()==0) {
		System.out.println("Prodavac: Nazalost nemamo to u ponudi :(");
		System.out.println("Kupac: Ih prava steta, vidimo se neki drugi put!");
		}else {
		System.out.println("Prodavac: Pozdrav, od " + zelja + "-a imamo u ponudi: ");
		for(int i=0;i<ponuda.size();i++)
		System.out.println(" " + ponuda.get(i));
		boolean kupio = false;
		while(ponuda.size()>0 && !kupio) {
		System.out.println("Kupac: Kupicu -- " + ponuda.get(0).ime());
		kupio = ponuda.get(0).kupi();
		if(!kupio) {
		System.out.print("Prodavac: ");
		System.err.println("Na�alost nemamo tra�eni artikal trenutno :(");
		ponuda.remove(0);
		}
		}
		if(kupio) {
		System.out.println("Prodavac: Izvolite!");
		System.out.println("Kupac: Hvala lepo! Vidimo se sledeceg meseca kad legne plata!");
		}else {
		System.out.println("Kupac: Ih ba� �teta! Vidimo se za nedelju dana!");
		}
		}
		System.out.println();
		}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Album love_supreme = new Album("A Love Supreme", "John Coltrane", new Date(1965, 1, 12));
		Album animals = new Album("Animals", "Pink Floyd", new Date(1977, 1, 23));
		
		Numera a1 = new Numera(love_supreme.getIzvodjac(), "Part I: Acknowledgement", "7:42");
		Numera a2 = new Numera(love_supreme.getIzvodjac(), "Part II: Resolution", "7:19");
		Numera a3 = new Numera(love_supreme.getIzvodjac(), "Part III: Pursuance", "10:41");
		Numera a4 = new Numera(love_supreme.getIzvodjac(), "Part IV: Psalm", "07:02");
		Numera b1 = new Numera(animals.getIzvodjac(), "Pigs on the wing 1", "1:25");
		Numera b2 = new Numera(animals.getIzvodjac(), "Dogs", "17:05");
		Numera b3 = new Numera(animals.getIzvodjac(), "Pigs (Three diffrent ones)", "11:26");
		Numera b4 = new Numera(animals.getIzvodjac(), "Sheep", "10:18");
		Numera b5 = new Numera(animals.getIzvodjac(), "Pigs on the wing 2", "1:28");

		LinkedList<Numera> listaJC = new LinkedList<Numera>();
		listaJC.add(a1);
		listaJC.add(a2);
		listaJC.add(a3);
		listaJC.add(a4);

		LinkedList<Numera> listaPF = new LinkedList<Numera>();
		listaPF.add(b1);
		listaPF.add(b2);
		listaPF.add(b3);
		listaPF.add(b4);
		listaPF.add(b5);


		Prodavnica p = new Prodavnica ("Music shop", "Koltrejnova 17");
		p.dodaj(new LP(love_supreme,"Imuplse! Records",2750, 0, 120));
		p.dodaj(new LP(love_supreme,"Imuplse! Records",3110, 7, 180));
		p.dodaj(new CD(love_supreme,"Imuplse! Records",1500, 40));
		p.dodaj(new LP(animals,"Pink Floyd Records",2500, 7, 120));
		p.dodaj(new CD(animals,"Pink Floyd Records",1250, 30));
		
		System.out.println(p+"");
		simulacija(p, "Pink Floyd");
		simulacija(p, "David Bowie");
		simulacija(p, "colTrane");
		System.out.println(p);


	}

}
