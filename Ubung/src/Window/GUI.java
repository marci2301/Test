package Window;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	
	private JLabel lEingabe;
	private JTextField tfEingabe;
	private JButton btnAdd;
	private JButton btnLoad;
	private JButton btnAr;
	private JButton btnZufall;
	private JFileChooser fc;
	private LinkedList<String> ll;
	
	
	
	public GUI() {
		
		super.setTitle("Programm");
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new FlowLayout(FlowLayout.CENTER));
		super.add(lEingabe = new JLabel("Eingabe"));
		super.add(tfEingabe = new JTextField(10));
		super.add(btnLoad = new JButton("Load"));
		super.add(btnAdd = new JButton("Add"));
		super.add(btnZufall = new JButton("Zufall"));
		super.add(btnAr = new JButton("ArrayList"));
		
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
		
	}
	
	public void add() {
		
	}
	
	public void zufall() {
		
	}
	
	public void ar() {
		
	}
	

}
