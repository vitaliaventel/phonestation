package finalproject.inface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
/**
 * Class creates password dialog window
 * @author VitaliyL
 *
 */
public class AdminPassDialog extends JDialog {
	/** Password field*/
	private JPasswordField password;
	/**
	 * Constructor create new Dialog Window
	 * @param frame Parent frame which start dialog
	 */
	public AdminPassDialog(JFrame frame) {
		super(frame, "Enter a password", true);
		password = new JPasswordField();
		JButton ok = new JButton("OK");
		ok.addActionListener(new DialogListener(frame));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(password);
		panel.add(ok);
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

		private JFrame frame;

		public DialogListener(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String myPass = String.valueOf(password.getPassword());
			if (myPass.equals("admin")) {
				dispose();
				new AdminFrame();
			} else {
				JOptionPane.showMessageDialog(frame, "Incorrect password!", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		}

	}
}
