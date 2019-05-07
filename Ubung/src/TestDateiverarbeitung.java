import java.util.LinkedList;

public class TestDateiverarbeitung {

	public static void main(String[] args) {
		Datenverwaltung dv = new Datenverwaltung();
		LinkedList<Artikel> artikelliste = new LinkedList<Artikel>();
		
		artikelliste.add(new Artikel(123456,"Lederjacke",199.99));
		artikelliste.add(new Artikel(234567,"Jeanshose",39.99));
		artikelliste.add(new Artikel(345678,"Sporthose",19.99));
		artikelliste.add(new Artikel(456789,"Schwimmbrille",199.99));
		artikelliste.add(new Artikel(567891,"Badehose",16.49));
		artikelliste.add(new Artikel(678912,"Sprotschuhe",129.00));
		artikelliste.add(new Artikel(789123,"T-Shirt",29.99));
		artikelliste.add(new Artikel(891234,"Guertel",16.29));

		//Test Objektserialisierung
		System.out.println(dv.saveObject("Artikeldaten_Object.obj", artikelliste));
		
		LinkedList<Artikel> ll = dv.loadObject("Artikeldaten_Object.obj");
		for(Artikel a: ll)
			System.out.println(a);
		
		// Test Dateiverarbeitung
		System.out.println(dv.saveCSV("Artikelliste.csv", artikelliste));
		LinkedList<Artikel> al = dv.loadCSV("Artikelliste.csv");
		for(Artikel a: al)
			System.out.println(a);
		
		// Einzelnes Artikelobjekt mit Serialisierung sichern
		System.out.println(dv.saveArtikelObject("Artikelobject.obj", artikelliste.get(2)));
		System.out.println(dv.loadArtikelObject("Artikelobject.obj"));
		
		// Einzelnes Artikelobjekt mitDateiverarbeitung sichern
		System.out.println(dv.saveArtikelCSV("Artikelobject.csv", artikelliste.get(0)));
		System.out.println(dv.loadArtikelCSV("Artikelobject.csv"));
		System.out.println("Programm erfolgreich beendet!");
	}

}
