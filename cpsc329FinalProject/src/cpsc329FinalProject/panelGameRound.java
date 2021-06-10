package cpsc329FinalProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

public class panelGameRound extends JPanel {
	private int cRound = 0;
	private int grLives = 3;
	private ArrayList<pwdStruct> gLevels;
	private double[] times;
	/**
	 * Create the panel.
	 */
	public panelGameRound(JPanel mainGUI, ArrayList<pwdStruct> levels, double[] times, int round, int totalLevels) {
		double start = System.currentTimeMillis();
		setLayout(null);
		setBounds(100, 100, 750, 500);
		cRound = round;
		gLevels = levels;
		this.times = times;
		JLabel lblThisIsA = new JLabel("Round " + cRound);
		lblThisIsA.setBounds(10, 11, 56, 14);
		add(lblThisIsA);
		
		JButton btnTheoreticalsuccessButton = new JButton("Theoretical 'Success' Button");
		btnTheoreticalsuccessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// If the current round is less than or equal to the total amount of levels
				if (cRound < totalLevels) {
					// Success, get the time, add it to the array, create the next round and goto it.
					double end = System.currentTimeMillis();
					times[cRound-1] = end - start;
					cRound++;
					mainGUI.add(new panelGameRound(mainGUI, levels, times, cRound, totalLevels));
					((CardLayout)mainGUI.getLayout()).next(mainGUI);
					
				} else {
					// If the current round is equal to the total amount of levels
					double end = System.currentTimeMillis();
					times[cRound-1] = end - start;
					// Print to console to test times
					for (int i = 0; i < totalLevels; i++) {
						float timeInSeconds;
						timeInSeconds = (float)times[i] / 1000;
						System.out.println("Round: " + (i+1) + "Time: " + timeInSeconds);
					}
					mainGUI.add(new panelResultScreen(mainGUI, levels, times, cRound, totalLevels));
					((CardLayout)mainGUI.getLayout()).next(mainGUI);
				}
			}
		});
		btnTheoreticalsuccessButton.setBounds(190, 201, 228, 23);
		add(btnTheoreticalsuccessButton);

	}

}
