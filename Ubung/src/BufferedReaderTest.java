import java.io.*;

public class BufferedReaderTest {
	
	public static void main(String[] args) throws IOException, FileNotFoundException{
		
		File file = new File("F:\\meineAusgabedatei.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String zeile;
		
		while((zeile = br.readLine()) != null) {
			StdOut.println(zeile);
		}
		br.close();
		fr.close();
	}

}
