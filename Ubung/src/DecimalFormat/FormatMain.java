package DecimalFormat;

import java.text.DecimalFormat;

public class FormatMain {
	
	static double i = 1.2;
	static DecimalFormat deci = new DecimalFormat("00");

	public static void main(String[] args) {
		
		System.out.println(deci.format(i));
	}

}
