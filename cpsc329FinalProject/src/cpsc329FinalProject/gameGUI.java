package cpsc329FinalProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class gameGUI extends JFrame {
	private JPanel gameMGUI;
	
	/**
	 * Create the frame.
	 */
	public gameGUI(ArrayList<pwdStruct> gLevels, double[] times, int totalLevels) {
		// Set the title of the JFrame
		setTitle("CPSC329 ASCII Encryption Game");
		// Set the JFrame to exit the application when closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Setting bounds of JFrame
		setBounds(100, 100, 825, 500);
		
		// Creating a JPanel that encompasses which JPanel is being shown on the JFrame
		gameMGUI = new JPanel();
		gameMGUI.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gameMGUI);
		
		// CardLayout to setup multiple panels for easy transitions
		gameMGUI.setLayout(new CardLayout());
		gameMGUI.add(new panelMainScreen(gameMGUI, gLevels, times, totalLevels));
		
		// Set the JFrame to be visible
		this.setVisible(true);
		
	}
}