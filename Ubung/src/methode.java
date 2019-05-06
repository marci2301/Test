
public class methode{
	
	public static void main (String[] args) {
		try {
		berechneDivision(2,0);
		}
		catch(IllegalArgumentException iae) {
			StdOut.println("Fehler");
		}
	}
	
	public static int berechneDivision(int a, int b){
		if (b == 0){
	    throw new IllegalArgumentException("Der Nenner darf nicht Null sein");
		}
	int c = a/b;
	return c;
	}
}

