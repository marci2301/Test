package Window;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JLabel lEingabe = new JLabel("Eingabe");
	private JTextField tfEingabe = new JTextField(10);
	private JButton btnAdd = new JButton("Add");
	private JButton btnLoad = new JButton("Load");
	private JButton btnAr = new JButton("ArrayList");
	private JButton btnZufall = new JButton("Zufall");
	private JFileChooser fc;
	private LinkedList<String> ll;
	private Datenverwaltung dv;
	private FlowLayout flow = new FlowLayout(FlowLayout.CENTER);

	public GUI() {

		super.setTitle("Programm");
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(flow);
		super.add(lEingabe);
		super.add(tfEingabe);
		super.add(btnLoad);
		super.add(btnAdd);
		super.add(btnZufall);
		super.add(btnAr);
		dv = new Datenverwaltung();
		fc = new JFileChooser();
		ll = new LinkedList<String>();
		FileFilter filterTxt = new FileNameExtensionFilter("Textdatei", "txt", "dat");
		FileFilter filterObj = new FileNameExtensionFilter("Objektdatei", "obj");
		fc.addChoosableFileFilter(filterTxt);
		fc.addChoosableFileFilter(filterObj);

		btnLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});

		btnZufall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zufall();
			}
		});

		btnAr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ar();
			}
		});
	}

	public void load() {

		try {
			int returnValue = fc.showOpenDialog(this);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				ll = this.dv.loadObject(fc.getName(fc.getSelectedFile()));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Fehler: " + e.getMessage(), "Fehlermeldung",
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Laden erfolgreich!");
	}

	public void add() {
		ll.add(tfEingabe.getText());

	}

	public void zufall() {

	}

	public void ar() {
		
		for (String s : ll) {
			System.out.println(s);
		}
	}
}
