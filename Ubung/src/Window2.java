import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Window2 {

	static JFrame mainWindow = new JFrame("Titel");
	static JLabel eingabe = new JLabel("Eingabe: ");
	static JTextField tf = new JTextField(10);
	static JButton buttonLoad = new JButton("Load");
	static JButton buttonAdd = new JButton("Add");
	static JButton buttonZufall = new JButton("Zufall");
	static JButton buttonAr = new JButton("ArrayList");
	static WindowVerwaltung verwaltung = new WindowVerwaltung();
	static ArrayList<String> ar = new ArrayList<String>();
	static FlowLayout flow = new FlowLayout();

	public static void main(String[] args) {

		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(flow);
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					ar.add(tf.getText());
					verwaltung.saveCSV("Test", ar);
					tf.setText("");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		buttonLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				
					ar = verwaltung.loadCSV("Test");		
					tf.setText("Laden erfolgreich!");
			}
		});
		
		buttonAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				
				for(String s : ar) {
					System.out.println(s);
				}
			}
		});
		
		
		mainWindow.add(eingabe);
		mainWindow.add(tf);
		mainWindow.add(buttonLoad);
		mainWindow.add(buttonAdd);
		mainWindow.add(buttonZufall);
		mainWindow.add(buttonAr);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
}
