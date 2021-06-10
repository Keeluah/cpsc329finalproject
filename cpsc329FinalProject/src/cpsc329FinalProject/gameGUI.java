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

	private JPanel gameMGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameGUI frame = new gameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		//setBounds(100, 100, 450, 300);
		gameMGUI = new JPanel();
		gameMGUI.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gameMGUI);
		
		// CardLayout to setup multiple panels for easy transitions
		gameMGUI.setLayout(new CardLayout());
		gameMGUI.add(new panelMainScreen(gameMGUI));
		
		// 10 Rounds, Create 10 Panels to add to the cardLayout
		for(int i = 1; i <= 10; i++) {
			gameMGUI.add(new panelGameRound(i, gameMGUI));
		}
		
		gameMGUI.add(new panelResultScreen());
		this.setVisible(true);
		
	}
}