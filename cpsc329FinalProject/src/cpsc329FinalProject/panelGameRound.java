package cpsc329FinalProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;

public class panelGameRound extends JPanel {
	private int cRound = 0;
	private int grLives = 3;
	private ArrayList<pwdStruct> gLevels;
	private double[] times;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public panelGameRound(JPanel mainGUI, ArrayList<pwdStruct> levels, double[] times, int round, int totalLevels) {
		double start = System.currentTimeMillis();
		setBounds(100, 100, 750, 500);
		cRound = round;
		gLevels = levels;
		this.times = times;
		JLabel lblThisIsA = new JLabel("Round " + cRound);
		lblThisIsA.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
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
		
		// Label to display Difficulty
		JLabel lblDifficulty = new JLabel("Difficulty: " + getDifficulty(round));
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// Label to displays the Encrypted Password
		JLabel lblNewLabel = new JLabel(levels.get(round-1).getEncryptedPassword());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		// Label to display Key
		JLabel lblKey = new JLabel("Key: " + levels.get(round-1).getKey());
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		// Label that informs the user where the Encrypted Password is
		JLabel lblEncryptedPassword = new JLabel("Encrypted Password:");
		lblEncryptedPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDifficulty, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblThisIsA, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
							.addGap(345))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(256)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnTheoreticalsuccessButton, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEncryptedPassword, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addGap(139)))))
					.addGap(200))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKey, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(630))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThisIsA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDifficulty, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblKey, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(lblEncryptedPassword, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnTheoreticalsuccessButton)
					.addGap(136))
		);
		setLayout(groupLayout);
	}
	
	// Function to grab a String for Difficulty
	private String getDifficulty(int round) {
		String veasy = "Very Easy";
		String easy = "Easy";
		String norm = "Normal";
		String hard = "Hard";
		
		switch(round) {
		case 1:
			return(veasy);
		case 2:
			return(veasy);
		case 3:
			return(easy);
		case 4:
			return(easy);
		case 5:
			return(norm);
		case 6:
			return(norm);
		case 7:
			return(norm);
		case 8:
			return(hard);
		case 9:
			return(hard);
		case 10:
			return(hard);
		default:
			// If the rounds are messed up.
			return(veasy);
		}
		
	}
	
}
