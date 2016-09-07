package finalproject.inface;

import finalproject.engine.*;
import finalproject.model.Subscriber;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

/**
 * Class create subscriber's menu frame
 * @author VitaliyL
 *
 */
public class SubFrame extends JFrame {

	/**
	 * Constructor create new dialog window which includes info about subscriber
	 * @param dial Subscriber
	 */
	public SubFrame(Subscriber dial) {
		JPanel butPanel = new JPanel();

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 0, 5);

		butPanel.setLayout(gridbag);
		JButton pay = new JButton("Pay");
		pay.setToolTipText("Press the button, if you wanna pay for your services.");
		gridbag.setConstraints(pay, gbc);
		JButton cancelServices = new JButton("Cancel services");
		cancelServices.setToolTipText("Press the button, if you wanna cancel your services.");
		gridbag.setConstraints(cancelServices, gbc);
		JButton changeNumber = new JButton("Change number");
		changeNumber.setToolTipText("Press the button, if you wanna change your number.");
		gridbag.setConstraints(changeNumber, gbc);
		butPanel.add(pay);
		butPanel.add(cancelServices);
		butPanel.add(changeNumber);
		add(butPanel, BorderLayout.WEST);

		JPanel p1 = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		p1.setLayout(new GridLayout(7, 2));
		JLabel label1 = new JLabel("First name:");
		JTextField firstName = new JTextField(dial.getFirstName());
		firstName.setEditable(false);
		JLabel label2 = new JLabel("Last name:");
		JTextField lastName = new JTextField(dial.getLastName());
		lastName.setEditable(false);
		JLabel label3 = new JLabel("Phone number:");
		JTextField phone = new JTextField(dial.getPhoneNumber());
		phone.setEditable(false);
		JLabel label4 = new JLabel("Score:");
		JSpinner score = new JSpinner();
		score.setValue((int) dial.getBalance());
		score.setEnabled(false);
		JCheckBox status = new JCheckBox("Available?");
		status.setSelected(dial.isStatus());
		status.setEnabled(false);
		JLabel label5 = new JLabel("Services: ");
		JLabel label6 = new JLabel("Your packet price: ");
		JSpinner price = new JSpinner();
		price.setValue((int)dial.getMonthDonate());
		price.setEnabled(false);
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
		p1.add(label6);
		p1.add(price);
		p1.add(label5);
		

		JTextArea mainArea = new JTextArea();
		mainArea.setEditable(false);
		mainArea.setLineWrap(true);
		for (String item : dial.getServices()) {
			mainArea.append(item + "\n");
		}

		mainPanel.add(p1);
		mainPanel.add(new JScrollPane(mainArea));
		add(mainPanel, BorderLayout.CENTER);

		if(dial.isStatus() == false){
			cancelServices.setEnabled(false);
			changeNumber.setEnabled(false);
			label4.setForeground(Color.RED);
		}
		
		setTitle(dial.getFirstName() + " " + dial.getLastName() + " menu");
		setPreferredSize(new Dimension(400, 300));
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		SubFrameEngine sfe = new SubFrameEngine(dial);
		pay.addActionListener(sfe);
		cancelServices.addActionListener(sfe);
		changeNumber.addActionListener(sfe);

	}
}
