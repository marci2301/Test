import java.io.Serializable;
import java.util.Comparator;

public class Artikel implements Comparator<Artikel>, Serializable{

	private int artikelnummer;
	private String artikelbezeichnung;
	private double artikelpreis;
	private static final long serialUID = 123547882L;

	public Artikel(int artikelnummer, String artikelbezeichnung, double artikelpreis) {
		this.artikelnummer = artikelnummer;
		this.artikelbezeichnung = artikelbezeichnung;
		this.artikelpreis = artikelpreis;
	}

	public String getArtikelbezeichnung() {
		return artikelbezeichnung;
	}

	public void setArtikelbezeichnung(String artielbezeichnung) {
		this.artikelbezeichnung = artielbezeichnung;
	}

	public double getArtikelpreis() {
		return artikelpreis;
	}

	public void setArtikelpreis(double artikelpreis) {
		this.artikelpreis = artikelpreis;
	}

	public int getArtikelnummer() {
		return artikelnummer;
	}

	@Override
	public String toString() {
		return this.artikelnummer + ";" + this.artikelbezeichnung + ";" + this.artikelpreis;
	}

	@Override
	public int compare(Artikel ar1, Artikel ar2) {		
		return ar1.getArtikelnummer() - ar2.getArtikelnummer();
	}
}
