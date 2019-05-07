import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Datenverwaltung {

	public Datenverwaltung() {
		// TODO Auto-generated constructor stub
	}

	public boolean saveObject(String dateiname, LinkedList<Artikel> artikelliste) {

		File file = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			file = new File(dateiname);
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(artikelliste);
		} 
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 		
		finally {
				try {
					if (oos != null) {
						oos.close();
					}
					if (fos != null) {
						fos.close();
					}
				} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return true;
	}

	public LinkedList<Artikel> loadObject(String dateiname) {

		File file = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		LinkedList<Artikel> al = null;

		try {
			file = new File(dateiname);
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			if (o instanceof LinkedList<?>)
				al = (LinkedList<Artikel>) o;
		} 
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} 
		catch(ClassCastException cce) {
			cce.printStackTrace();
		}
		finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return al;
	}

	public boolean saveArtikelObject(String dateiname, Artikel artikel) {
		
		File file = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			file = new File(dateiname);
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(artikel);
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if(oos != null) {
					oos.close();
				}
				if(fos != null) {
					fos.close();
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}		
		return true;		
	}

	public Artikel loadArtikelObject(String dateiname) {
		
		File file = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Artikel art = null;
		
		try {
			file = new File(dateiname);
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			if (o instanceof Artikel)
				art = (Artikel) o;
		} 
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} 
		catch(ClassCastException cce) {
			cce.printStackTrace();
		}
		finally {
			try {
				if(ois != null) {
					ois.close();
				}
				if(fis != null) {
					fis.close();
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		return art;
	}

	public boolean saveCSV(String dateiname, LinkedList<Artikel> artikelliste) {
		
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			file = new File(dateiname);
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for(Artikel art : artikelliste) {
			bw.write(art.toString());
			bw.newLine();
			}
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(fw != null) {
					fw.close();
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return true;
	}

	public LinkedList<Artikel> loadCSV(String dateiname) {
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String zeile = null;
		LinkedList<Artikel> al = null;
		
		try {
			file = new File(dateiname);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while((zeile = br.readLine()) != null) {
				String[] temp = zeile.split(";");
				int artNr = Integer.parseInt(temp[0]);
				String artBez = temp[1];
				double preis = Double.parseDouble(temp[2]);
				
				al = new LinkedList<Artikel>();
				al.add(new Artikel(artNr, artBez, preis));				
			}
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		catch(ClassCastException cce) {
			cce.printStackTrace();
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return al;
	}

	public boolean saveArtikelCSV(String dateiname, Artikel artikel) {
		
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			file = new File(dateiname);
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write(artikel.toString());
			bw.newLine();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}		
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(fw != null) {
					fw.close();
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return true;		

	}

	public Artikel loadArtikelCSV(String dateiname) {
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String zeile = null;
		Artikel art = null;
		
		try {
			file = new File(dateiname);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while((zeile = br.readLine()) != null) {
				String[] temp = zeile.split(";");
				int artNr = Integer.parseInt(temp[0]);
				String artBez = temp[1];
				double preis = Double.parseDouble(temp[2]);
				
				art = new Artikel(artNr, artBez, preis);
			}				
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			} 
		}		
		return art;
	}
}
