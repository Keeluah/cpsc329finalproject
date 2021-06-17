package cpsc329FinalProject;

import javax.swing.JPanel;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.Font;

public class panelResultScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelResultScreen(JPanel mainGUI, ArrayList<pwdStruct> levels, double[] times, int round, int totalLevels) {
		// Set bounds of the JPanel
		setBounds(100, 100, 750, 500);
		
		// Label that displays 'Final scores' at the top
		JLabel lblThisWouldBe = new JLabel("FINAL   SCORES");
		lblThisWouldBe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		// Creating a new JPanel (timerPanel) within this JPanel
		JPanel timerPanel = new JPanel();
		// Making a Group Layout for this JPanel (panelResultScreen)
		GroupLayout groupLayout = new GroupLayout(this);
		
		// WindowBuilder code
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(265)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblThisWouldBe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(timerPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
					.addGap(265))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblThisWouldBe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(timerPanel, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
					.addGap(32))
		);
		
		// Set the JPanel (timerPanel) to a Box Layout, Vertically Aligned (Y-Axis)
		timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.Y_AXIS));
		// Setting this JPanel (panelResultScreen) to GroupLayout
		setLayout(groupLayout);
		
		// Creating Labels for all the stages, and finding the time spent on every stage
		for (int i = 0; i < totalLevels; i++) {
			// If the time is higher than 0,
			if (times[i] >= 0) {
				// Create a label after translating the time to seconds
				float timeInSeconds;
				timeInSeconds = (float)times[i] / 1000;
				timerPanel.add(new JLabel("ROUND: " + (i+1) + " TIME SPENT: " + timeInSeconds));
			} else {
				// If the time is lower than 0, create a label for the stage with a N/A time
				timerPanel.add(new JLabel("ROUND: " + (i+1) + " TIME SPENT: N/A"));
			}
		}
		// Align all components in the timerPanel to the left
		timerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

	}
}
