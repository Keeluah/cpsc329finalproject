package cpsc329FinalProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

public class panelGameRound extends JPanel {
	private int cRound = 0;
	/**
	 * Create the panel.
	 */
	public panelGameRound(int round, JPanel mainGUI) {
		cRound = round;
		setLayout(null);
		setBounds(100, 100, 750, 500);
		JLabel lblThisIsA = new JLabel("Round " + cRound);
		lblThisIsA.setBounds(10, 11, 56, 14);
		add(lblThisIsA);
		
		JButton btnTheoreticalsuccessButton = new JButton("Theoretical 'Success' Button");
		btnTheoreticalsuccessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout)mainGUI.getLayout()).next(mainGUI);
			}
		});
		btnTheoreticalsuccessButton.setBounds(190, 201, 228, 23);
		add(btnTheoreticalsuccessButton);

	}

}
