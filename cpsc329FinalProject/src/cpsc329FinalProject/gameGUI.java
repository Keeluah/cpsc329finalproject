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
import java.awt.event.ActionEvent;

public class gameGUI extends JFrame {
	private pwdStruct gLevels;
	private double[] times;
	private int totalLevels;
	
	private JPanel gameMGUI;
	
	public gameGUI(pwdStruct levels, double[] times, int totalLevels) {
		gLevels = levels;
		this.times = times;
		this.totalLevels = totalLevels;
	}
	
	/**
	 * Create the frame.
	 */
	public gameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		gameMGUI = new JPanel();
		gameMGUI.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gameMGUI);
		
		// CardLayout to setup multiple panels for easy transitions
		gameMGUI.setLayout(new CardLayout());
		gameMGUI.add(new panelMainScreen(gameMGUI, gLevels, times, totalLevels));
		
		// 10 Rounds, Create 10 Panels to add to the cardLayout
		//gameMGUI.add(new panelGameRound(gameMGUI, ));
		
		// Old Code, Creates 10 Panels Immediately
		/*
		for(int i = 1; i <= 10; i++) {
			gameMGUI.add(new panelGameRound(gameMGUI, ));
		}
		*/
		
		//gameMGUI.add(new panelResultScreen());
		this.setVisible(true);
		
	}
}