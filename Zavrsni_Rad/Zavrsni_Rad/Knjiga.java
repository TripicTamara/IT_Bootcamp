package zavrsni;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Knjiga {
	private ArrayList<String> noveReci;
	private HashMap<String, Integer> brojac;
	private Recnik recnik;

	public Knjiga() throws SQLException {
		noveReci = new ArrayList<String>();
		brojac = new HashMap<String, Integer>();
		recnik = new Recnik();
		recnik.napraviRecnik();

	}

	// split book into words, without interpunction signs, and put it into new txt
	// file
	public void splitujKnjigu() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\knjiga"));
		FileWriter fw = new FileWriter("splitovanaKnjiga", true);
		String linija = br.readLine();
		while (linija != null) {
			String[] rec = linija.toLowerCase().split(" ");
			for (int i = 0; i < rec.length; i++) {
				for (int j = 0; j < rec[i].length(); j++) {
					if (!(rec[i].charAt(j) >= 'a' || rec[i].charAt(j) <= 'z')) {
						rec[i].replace(rec[i].charAt(j), ' ');
					}
				}
				fw.write(rec[i] + "\n");

			}
		}
		fw.flush();
		br.close();
		fw.close();
	}

	/*
	 * check if words from book exist in recnik, and put all words that don't exist
	 * into new ArrayList named NoveReci. Also, for words that exist in book and
	 * recnik, count how many times are repeated
	 */
	public ArrayList<String> proveriReci() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new FileReader("splitovanaKnjiga"));

		String linija = br.readLine();
		while (linija != null) {

			if (!recnik.getRecnik().containsKey(linija)) {
				noveReci.add(linija);

			} else if (recnik.getRecnik().containsKey(linija)) {
				if (brojac.get(linija) == null) {
					brojac.put(linija, 1);
				} else {
					brojac.put(linija, brojac.get(linija) + 1);
				}
			}

			linija = br.readLine();
		}
		br.close();
		return noveReci;

	}

	// write new word into new sql table
	public void upisiSQL() throws SQLException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < noveReci.size(); i++) {
			sb.append(noveReci.get(i)).append(", ");
		}
		recnik.prosiriBazu(sb);
	}

	// print repeated words and their count
	public void printniMapu() {

		for (String kljuc : brojac.keySet()) {
			System.out.print(kljuc + " ");
			System.out.println(brojac.get(kljuc));
		}
	}

	// check 20 most repeated words in a book, and print them by descending order
	public void proveriDvadeset() throws IOException {
		System.out.println("-------------------------------------------");
		HashMap<String, Integer> knjiga = new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new FileReader("splitovanaKnjiga"));
		String linija = br.readLine();
		while (linija != null) {

			if (knjiga.get(linija) == null) {
				knjiga.put(linija, 1);
			} else {
				knjiga.put(linija, knjiga.get(linija) + 1);
			}
			linija = br.readLine();
		}
		br.close();
		LinkedHashMap<String, Integer> sortiranih20 = new LinkedHashMap<>();
		knjiga.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> sortiranih20.put(x.getKey(), x.getValue()));

		for (String x : sortiranih20.keySet()) {
			int redBr = 0;
			if (redBr == 20)
				break;
			else {
				System.out.print(++redBr + x + " ");
				System.out.println(sortiranih20.get(x));
			}
		}
	}

	// sort all words by lexicographic order
	public void upisiUfajl() throws IOException {
		System.out.println("-------------------------------------------");
		BufferedReader br = new BufferedReader(new FileReader("splitovanaKnjiga"));
		TreeMap<String, String> sortiranaLex = new TreeMap<String, String>();
		String linija = br.readLine();
		while (linija != null) {
			sortiranaLex.put(linija, linija);
			br.readLine();
		}
		br.close();

		for (Entry<String, String> entry : sortiranaLex.entrySet())
			System.out.println(entry.getKey());
	}

}
