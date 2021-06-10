package cpsc329FinalProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelMainScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelMainScreen(JPanel mainGUI) {
		setLayout(null);
		JLabel lblAsciiEncryptionGame = new JLabel("ASCII Encryption Game");
		lblAsciiEncryptionGame.setBounds(141, 28, 134, 14);
		add(lblAsciiEncryptionGame);
		
		// Create a button 'START'
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// REF: https://stackoverflow.com/questions/11706948/how-to-make-cardlayout-inside-jtabbedpane
				// From the main panel (1st) head to a game panel (2nd)
				((CardLayout)mainGUI.getLayout()).next(mainGUI);
			}
		});
		btnStart.setBounds(155, 128, 89, 23);
		add(btnStart);
	}

}
