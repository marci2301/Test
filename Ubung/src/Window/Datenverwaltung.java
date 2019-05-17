package Window;
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

	public boolean saveObject(String dateiname, LinkedList<String> ll) {

		File file = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			file = new File(dateiname);
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ll);
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

	public LinkedList<String> loadObject(String dateiname) {

		File file = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		LinkedList<String> ll = null;

		try {
			file = new File(dateiname);
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			if (o instanceof LinkedList<?>)
				ll = (LinkedList<String>) o;
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
		return ll;
	}

	public boolean saveArtikelObject(String dateiname, String s) {
		
		File file = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			file = new File(dateiname);
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(s);
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

	public String loadArtikelObject(String dateiname) {
		
		File file = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		String s = null;
		
		try {
			file = new File(dateiname);
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			if (o instanceof String)
				s= (String) o;
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
		
		return s;
	}

	public boolean saveCSV(String dateiname, LinkedList<String> ll) {
		
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			file = new File(dateiname);
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for(String s : ll) {
			bw.write(s);
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

	public LinkedList<String> loadCSV(String dateiname) {
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String zeile = null;
		LinkedList<String> ll = null;
		
		try {
			file = new File(dateiname);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while((zeile = br.readLine()) != null) {
				String[] temp = zeile.split(";");
				
				ll = new LinkedList<String>();
				ll.add(temp[0]);		
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
		return ll;
	}

	public boolean saveArtikelCSV(String dateiname, String s) {
		
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			file = new File(dateiname);
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write(s);
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

	public String loadArtikelCSV(String dateiname) {
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String zeile = null;
		String s = null;
		
		try {
			file = new File(dateiname);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while((zeile = br.readLine()) != null) {
				String[] temp = zeile.split(";");				
				s = new String(temp[0]);
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
		return s;
	}
}
