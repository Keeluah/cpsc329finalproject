package cpsc329FinalProject;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.JLabel;

public class panelResultScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelResultScreen(JPanel mainGUI, ArrayList<pwdStruct> levels, double[] times, int round, int totalLevels) {
		setBounds(100, 100, 750, 500);
		JLabel lblThisWouldBe = new JLabel("This would be the end");
		add(lblThisWouldBe);

	}

}
