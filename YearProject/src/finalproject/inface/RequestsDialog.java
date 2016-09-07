package finalproject.inface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/**
 * Class creates request dialog window
 * @author VitaliyL
 *
 */
public class RequestsDialog extends JDialog {

	/**
	 * Constructor create new add subscriber dialog window
	 * @param frame Parent frame which start dialog
	 */
	
	public RequestsDialog(JFrame frame) {
		super(frame, "Pending requests..", true);
		JTextArea reqArea = new JTextArea();
		reqArea.setEditable(false);
		reqArea.setLineWrap(true);
		reqArea.setText("You need to update subscribers requests, press *Update*");

		JButton update = new JButton("Update");
		update.setToolTipText("Press the button to update subscribers requests.");
		update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				try {
					reqArea.setText("");
					File file = new File("resources", "subrequest_main.txt");
					BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					try {
						String s;
						while ((s = in.readLine()) != null) {
							reqArea.append(s + "\n");
						}
					} finally {
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		JButton clear = new JButton("Clear");
		clear.setToolTipText("Press the button to clear all requests.");
		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				try {
					File file = new File("resources", "subrequest_main.txt");
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
					try {
						out.print("");
					} finally {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				reqArea.setText("You are clear all requests!");
			}
		});

		JPanel panel = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 0, 5);

		panel.setLayout(gridbag);
		gridbag.setConstraints(update, gbc);
		gridbag.setConstraints(clear, gbc);
		panel.add(update);
		panel.add(clear);
		add(panel, BorderLayout.WEST);
		add(new JScrollPane(reqArea), BorderLayout.CENTER);
		setSize(700, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
