package cpsc329FinalProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;

public class panelMainScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public panelMainScreen(JPanel mainGUI, ArrayList<pwdStruct> levels, double[] times, int totalLevels) {
		// Declare variables to be used
		int startRound = 1;
		// Set bounds of this JPanel
		setBounds(100, 100, 750, 500);
		
		// Label for the Title of the game
		JLabel lblAsciiEncryptionGame = new JLabel("ASCII Encryption Game");
		lblAsciiEncryptionGame.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblAsciiEncryptionGame.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Create a button 'START'
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// REF: https://stackoverflow.com/questions/11706948/how-to-make-cardlayout-inside-jtabbedpane
				// From the main panel (1st) head to a game panel (2nd)
				mainGUI.add(new panelGameRound(mainGUI, levels, times, startRound, totalLevels));
				((CardLayout)mainGUI.getLayout()).next(mainGUI);
				
			}
		});
		
		// GROUP LAYOUT
		// REF: https://www.youtube.com/watch?v=UXZCjFr_7l8
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAsciiEncryptionGame, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(276)
					.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addGap(272))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAsciiEncryptionGame, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(147)
					.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(171))
		);
		setLayout(groupLayout);
	}
}
