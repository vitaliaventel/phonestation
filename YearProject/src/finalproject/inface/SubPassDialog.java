package finalproject.inface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;
import finalproject.model.Subscriber;
/**
 * Class creates subscriber password dialog window
 * @author VitaliyL
 *
 */
public class SubPassDialog extends JDialog {

	private JPasswordField password;
	private Subscriber login;
	/**
	 * Constructor create new Dialog Window
	 * @param frame Parent frame which start dialog
	 */
	public SubPassDialog(JFrame frame) {
		super(frame, "Enter your phone number", true);
		password = new JPasswordField();
		JButton ok = new JButton("OK");
		ok.addActionListener(new DialogListener(frame));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(password);
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
			String myPass = String.valueOf(password.getPassword());
			boolean check = true;
			ArrayList<Subscriber> subs = new ArrayList<Subscriber>();
			try {
				File file = new File("resources","subscribers.ser");
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				try {
					subs = (ArrayList<Subscriber>) in.readObject();
				} finally {
					in.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			for (Subscriber item : subs) {
				if (myPass.equals(item.getPhoneNumber())) {
					login = item;
					setVisible(false);
					new SubFrame(login);
					check = false;
				}
			}
			if (check) {
				JOptionPane.showMessageDialog(frame, "Unknown subscriber!!!", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}
	
}
