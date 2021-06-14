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
import javax.swing.SwingConstants;

public class panelGameRound extends JPanel {
	private int cRound = 0;
	private int grLives = 3;
	private ArrayList<pwdStruct> gLevels;
	private double[] times;
	private JTextField decryptTxtField;
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
		
		// Textfield for Decrypted Password Input
		decryptTxtField = new JTextField();
		decryptTxtField.setColumns(10);
		
		// Label that appears when an incorrect input has been displayed
		JLabel lblWrongInput = new JLabel("Incorrect!");
		lblWrongInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWrongInput.setVisible(false);
		
		// Label that displays the number of attempts remaining
		JLabel lblLives = new JLabel("Lives: " + grLives);
		lblLives.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnTheoreticalsuccessButton = new JButton("Enter");
		btnTheoreticalsuccessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (decryptTxtField.getText().compareTo(levels.get(cRound-1).getPassword()) == 0) {
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
						// Head to end screen, as this would be the last level
						mainGUI.add(new panelResultScreen(mainGUI, levels, times, cRound, totalLevels));
						((CardLayout)mainGUI.getLayout()).next(mainGUI);
					}
				} else {
					// If the password in the textfield is not the same, subtract lives
					grLives--;
					if (grLives == 0) {
						// If the number of attempts reaches 0, head to the end-screen
						// and set the remaining slots (if any) of time to -1.
						lblWrongInput.setVisible(false);
						for (int i = cRound-1; i < totalLevels; i++) {
							times[i] = -1;
						}
						mainGUI.add(new panelResultScreen(mainGUI, levels, times, cRound, totalLevels));
						((CardLayout)mainGUI.getLayout()).next(mainGUI);
					} else {
						// Update the lives label
						lblLives.setText("Lives: " + grLives);
						// Display the incorrect label
						lblWrongInput.setVisible(true);
					}
				}
			}
		});
		
		JButton btnAscii = new JButton("ASCII Table");
		btnAscii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameASCIIWindow aw = new gameASCIIWindow();
			}
		});
		
		// Label to display Difficulty
		JLabel lblDifficulty = new JLabel("Difficulty: " + getDifficulty(round));
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// Label to displays the Encrypted Password
		JLabel lblEncPWD = new JLabel(levels.get(round-1).getEncryptedPassword());
		lblEncPWD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		// Label to display Key
		JLabel lblKey = new JLabel("Key: " + levels.get(round-1).getKey());
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// Label that informs the user where the Encrypted Password is
		JLabel lblEncryptedPassword = new JLabel("Encrypted Password:");
		lblEncryptedPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		// Label that informs the user where to enter the Decrypted Password
		JLabel lblEnterDecryptedPassword = new JLabel("Enter Decrypted Password:");
		lblEnterDecryptedPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		// Temporary Label that displays the correct input, for testing and until implementation of ASCII Table
		JLabel lblPasswordIs = new JLabel("PASSWORD IS: " + levels.get(round-1).getPassword());
		
		
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
								.addComponent(decryptTxtField, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(lblEncPWD, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEncryptedPassword, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addGap(139))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnTheoreticalsuccessButton, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
									.addGap(195))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAscii, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(30))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEnterDecryptedPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(117))
								.addComponent(lblWrongInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(51)
					.addComponent(lblLives, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(38))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKey, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addGap(630))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblPasswordIs, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblThisIsA)
						.addComponent(lblLives, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDifficulty, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblKey, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(lblEncryptedPassword, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEncPWD, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblEnterDecryptedPassword, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(decryptTxtField, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnTheoreticalsuccessButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnAscii, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWrongInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(56)
					.addComponent(lblPasswordIs)
					.addGap(51))
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
