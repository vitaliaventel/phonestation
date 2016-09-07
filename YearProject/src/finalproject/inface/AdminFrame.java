package finalproject.inface;

import finalproject.engine.AdminFrameEngine;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

/**
 * Class create admin's menu frame
 * @author VitaliyL
 *
 */
public class AdminFrame extends JFrame {
	/**
	 * Default constructor, which create admin's frame with panels.
	 */
	public AdminFrame(){
		JTable subsTable = new JTable();
		subsTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(subsTable),BorderLayout.CENTER);
		
		JPanel butPanel = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 0, 5);
		
		butPanel.setLayout(gridbag);
		JButton add = new JButton("Add");
		gridbag.setConstraints(add, gbc);
		JButton update = new JButton("Update File");
		gridbag.setConstraints(update, gbc);
		JButton loadFile = new JButton("Load File");
		gridbag.setConstraints(loadFile, gbc);
		JButton edit = new JButton("Edit");
		gridbag.setConstraints(edit, gbc);
		JButton delete = new JButton("Delete");
		gridbag.setConstraints(delete, gbc);
		JButton requests = new JButton("Requests");
		gridbag.setConstraints(requests, gbc);
		add.setToolTipText("Press button if you wanna add new subscriber.");
		edit.setToolTipText("Pres the button if you wanna edit subscriber's info.");
		delete.setToolTipText("Press the button if you wanna delete subscriber.");
		update.setToolTipText("Press the button if you wanna update subscribers data base.");
		loadFile.setToolTipText("Press the button if you wanna load subs data base.");
		requests.setToolTipText("Press the button if you wanna open requests.");
		butPanel.add(add);
		butPanel.add(edit);
		butPanel.add(delete);
		butPanel.add(update);
		butPanel.add(loadFile);
		butPanel.add(requests);
		
		add(butPanel,BorderLayout.WEST);
		setTitle("Admin's menu");
		setPreferredSize(new Dimension(700, 500));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		AdminFrameEngine afe = new AdminFrameEngine(subsTable);
		add.addActionListener(afe);
		update.addActionListener(afe);
		edit.addActionListener(afe);
		delete.addActionListener(afe);
		loadFile.addActionListener(afe);
		requests.addActionListener(afe);
	}
}
