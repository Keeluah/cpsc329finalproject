package cpsc329FinalProject;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class gameASCIIWindow extends JFrame{

	//Image credit: https://computersciencewiki.org/index.php/File:Ascii_table.png
	//Getting the image onto the JFrame: https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
	public gameASCIIWindow() {
		setTitle("ASCII Table");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(125, 125, 856, 602);
		BufferedImage img;
		try {
			img = ImageIO.read(new File("Ascii_table.png"));
			JLabel pic = new JLabel(new ImageIcon(img));
			this.add(pic);
		} catch (IOException e) {
			JLabel lblError = new JLabel("Error in opening ASCII table");
			this.add(lblError);
		}
		this.setVisible(true);
	}
	
}
