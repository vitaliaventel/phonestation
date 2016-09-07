package finalproject.inface;

import finalproject.engine.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * MainFrame of phone station.
 * @author VitaliyL
 *	
 */

public class MainFrame extends JFrame {

	/**
	 * Default constructor, which create frame with panels.
	 */
	public MainFrame() {
		JPanel windowContent = new JPanel();
		windowContent.setLayout(new BorderLayout());
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 0, 5);
		
		JPanel butGroup = new JPanel();
		butGroup.setLayout(gridbag);
		JButton logAdmin = new JButton("Log as admin");
		logAdmin.setToolTipText("Press this button, if you want to join admin's menu.");
		gridbag.setConstraints(logAdmin, gbc);
		butGroup.add(logAdmin);
		JButton logSub = new JButton("Log as sub");
		logSub.setToolTipText("Press this button, if you want to join subscriber's menu.");
		gridbag.setConstraints(logSub, gbc);
		butGroup.add(logSub);
		JButton about = new JButton("About..");
		about.setToolTipText("Information about a phone station final project.");
		gridbag.setConstraints(about, gbc);
		butGroup.add(about);
		JButton exit = new JButton("Exit");
		exit.setToolTipText("Press button, if you want to close the program.");
		gridbag.setConstraints(exit, gbc);
		butGroup.add(exit);
		windowContent.add("West", butGroup);
		JLabel imageLabel = new JLabel(new ImageIcon("resources/logo_main.png"));
		windowContent.add(imageLabel);

		setTitle("Phone Station final project");
		setContentPane(windowContent);
		setPreferredSize(new Dimension(700, 500));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		MainFrameEngine mfe = new MainFrameEngine();
		logAdmin.addActionListener(mfe);
		logSub.addActionListener(mfe);
		about.addActionListener(mfe);
		exit.addActionListener(mfe);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
