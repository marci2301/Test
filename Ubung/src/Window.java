import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window implements ActionListener{
	
	static JFrame mainWindow = new JFrame("Titel");
	static JButton button = new JButton("Button");
	static JLabel label = new JLabel("Label");
	static JTextField tf = new JTextField(10);
	static FlowLayout flow = new FlowLayout();
	

	public static void main(String[] args) {

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = "Hallo";
				JOptionPane.showMessageDialog(mainWindow, message);
			}
		});
		
		//mainWindow.setBounds(50, 100, 300, 150);
		mainWindow.getContentPane().setLayout(flow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.add(label);
		mainWindow.add(button);
		mainWindow.add(tf);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}