package finalproject.inface;

import finalproject.model.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class creates add or edit subscriber dialog window
 * @author VitaliyL
 *
 */
public class AddSubDialog extends JDialog {

	private JFormattedTextField firstName;
	private JFormattedTextField lastName;
	private JFormattedTextField phone;
	private JCheckBox status;
	private JList<String> services;
	private JSpinner score;
	private JButton save;
	private int subId = 0;
	private boolean saving = false;

	/**
	 * Constructor create new add subscriber dialog window
	 * @param frame Parent frame which start dialog
	 */
	public AddSubDialog(JFrame frame) {
		super(frame, "Enter information about subscriber", true);
		JPanel p1 = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		p1.setLayout(new GridLayout(6, 2));
		JLabel label1 = new JLabel("First name:");
		firstName = new JFormattedTextField();
		JLabel label2 = new JLabel("Last name:");
		lastName = new JFormattedTextField();
		JLabel label3 = new JLabel("Phone number:");
		phone = new JFormattedTextField();
		JLabel label4 = new JLabel("Score:");
		score = new JSpinner();
		status = new JCheckBox("Available?");
		services = new JList<String>(getServices());
		JLabel label5 = new JLabel("Services: ");
		services.setLayoutOrientation(JList.VERTICAL);
		p1.add(label1);
		p1.add(firstName);
		p1.add(label2);
		p1.add(lastName);
		p1.add(label3);
		p1.add(phone);
		p1.add(label4);
		p1.add(score);
		p1.add(new JLabel());
		p1.add(status);
		p1.add(label5);
		mainPanel.add(p1);
		JScrollPane pane = new JScrollPane(services);
		mainPanel.add(pane);
		add(mainPanel, BorderLayout.CENTER);
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				saving = true;
				dispose();
			}
		});
		JPanel p2 = new JPanel();
		p2.add(save);
		add(p2, BorderLayout.SOUTH);
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Constructor create new add subscriber dialog window
	 * @param frame Parent frame which start dialog
	 * @param sub Subscriber info for edit
	 */
	public AddSubDialog(JFrame frame, Subscriber sub) {
		super(frame, "Edit information about subscriber", true);
		JPanel p1 = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		p1.setLayout(new GridLayout(6, 2));
		JLabel label1 = new JLabel("First name:");
		firstName = new JFormattedTextField(sub.getFirstName());
		JLabel label2 = new JLabel("Last name:");
		lastName = new JFormattedTextField(sub.getLastName());
		JLabel label3 = new JLabel("Phone number:");
		phone = new JFormattedTextField(sub.getPhoneNumber());
		JLabel label4 = new JLabel("Score:");
		score = new JSpinner();
		score.setValue((int) sub.getBalance());
		status = new JCheckBox("Available?");
		status.setSelected(sub.isStatus());
		services = new JList<String>(getServices());
		JLabel label5 = new JLabel("Services: ");
		services.setLayoutOrientation(JList.VERTICAL);
		p1.add(label1);
		p1.add(firstName);
		p1.add(label2);
		p1.add(lastName);
		p1.add(label3);
		p1.add(phone);
		p1.add(label4);
		p1.add(score);
		p1.add(new JLabel());
		p1.add(status);
		p1.add(label5);

		mainPanel.add(p1);
		JScrollPane pane = new JScrollPane(services);
		mainPanel.add(pane);
		add(mainPanel, BorderLayout.CENTER);
		subId = sub.getId();
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				saving = true;
				dispose();
			}
		});
		JPanel p2 = new JPanel();
		p2.add(save);
		add(p2, BorderLayout.SOUTH);
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * Method which return save or not
	 * @return true or false
	 */
	public boolean isSave() {
		return saving;
	}

	/**
	 * Method which return subscriber full information
	 * @return Subscriber full information
	 */
	public Subscriber getSubscriber() {
		Subscriber sub = new Subscriber(firstName.getText(), lastName.getText(), phone.getText(), strToList(),
				status.isSelected(), (int) score.getValue(), subId);
		return sub;
	}

	/**
	 * Method which return subscriber services
	 * @return Subscriber services
	 */
	private static String[] getServices() {
		String[] serv = new String[10];
		try {
			File file = new File("resources","services_main.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			try {
				String s;
				int i = 0;
				while ((s = in.readLine()) != null) {
					serv[i++] = s;
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serv;
	}

	/**
	 * Method convert List to ArrayList
	 * @return ArrayList
	 */
	private ArrayList<String> strToList() {
		ArrayList<String> result = new ArrayList<String>();
		List<String> list = services.getSelectedValuesList();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(i));
		}
		return result;
	}

}
