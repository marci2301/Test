import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest{

	public static void main (String[] args) throws IOException{
		
		File file = new File("F:\\meineAusgabedatei.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String[] s = new String[2];
		s[0] = "Hallo";
		s[1] = "World";
		
		try {
			for(int i=0; i<s.length; i++) {
				bw.write(s[i]);
				bw.newLine();
			}
		}
		catch(FileNotFoundException fne){			
			fne.printStackTrace();			
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			bw.close();
			fw.close();
			StdOut.println("Programm beendet.");
		}
	}
}