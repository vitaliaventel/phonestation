package finalproject.inface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import finalproject.model.Subscriber;

/**
 * Class creates pay dialog window
 * @author VitaliyL
 *
 */
public class PayDialog extends JDialog {
	private JSpinner score;
	private Subscriber sub;

	/**
	 * Constructor create new Dialog Window
	 * @param frame Parent frame which start dialog
	 * @param sub Subscriber
	 */
	public PayDialog(JFrame frame, Subscriber sub) {
		super(frame, "Enter your deposite", true);
		this.sub = sub;
		score = new JSpinner();
		JButton ok = new JButton("OK");
		ok.addActionListener(new DialogListener(frame));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(score);
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
			sub.pay((int)score.getValue());
			JOptionPane.showMessageDialog(frame, "You deposited your balance on " + (int)score.getValue() + " UAH", "Nice!",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}

	}
}
