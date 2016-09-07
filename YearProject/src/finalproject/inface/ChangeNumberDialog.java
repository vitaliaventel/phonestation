package finalproject.inface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import finalproject.model.Subscriber;

/**
 * Class creates change number dialog window
 * @author VitaliyL
 *
 */
public class ChangeNumberDialog extends JDialog {

	private Subscriber sub;
	private JTextField phone;
	/**
	 * Constructor create new Dialog Window
	 * @param frame Parent frame which start dialog
	 * @param sub Subscriber
	 */
	public ChangeNumberDialog(JFrame frame, Subscriber sub) {
		super(frame, "Enter your new phone number", true);
		this.sub = sub;
		phone = new JTextField();
		JButton ok = new JButton("OK");
		ok.addActionListener(new DialogListener(frame));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(phone);
		panel.add(ok, CENTER_ALIGNMENT);
		add(panel, BorderLayout.CENTER);
		setSize(300, 80);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Inner class DialogListener creates listener's
	 * @author VitaliyL
	 *
	 */
	private class DialogListener implements ActionListener {

		JFrame frame;

		public DialogListener(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			sub.changeNumber(phone.getText());
			JOptionPane.showMessageDialog(frame, "You requested for changing your number to -> " + phone.getText(), "Nice!",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}

	}
}
