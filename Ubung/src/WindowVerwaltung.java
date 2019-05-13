import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WindowVerwaltung {

	public boolean saveCSV(String dateiname, ArrayList<String> ar) throws IOException {

		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			file = new File(dateiname);
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (String s : ar) {
				bw.write(s+";");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return true;
	}

	public ArrayList<String> loadCSV(String dateiname) {

		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> ar = null;
		String zeile = null;

		try {
			file = new File(dateiname);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while ((zeile = br.readLine()) != null) {
				String[] temp = zeile.split(";");
				temp[0] = zeile;
				ar = new ArrayList<String>();
				System.out.println(zeile);
				String s = new String(temp[0]);
				ar.add(s);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return ar;
	}
}
