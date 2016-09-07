package finalproject.engine;

import finalproject.inface.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * Class controller for MainFrame, which waiting for button press.
 * @author VitaliyL
 *	
 */

public class MainFrameEngine implements ActionListener {
	/**
	 * Link for main frame.
	 */
	private MainFrame parent;

	/**
	 *  Overrides method, which waiting for button press.
	 *  @param e  source
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if (src.getText().equals("Log as admin")) {
			new AdminPassDialog(parent);
		} else if (src.getText().equals("Log as sub")) {
			new SubPassDialog(parent);
		} else if (src.getText().equals("About..")) {
			new AboutDialog(parent);
		} else if (src.getText().equals("Exit")) {
			System.exit(0);
		}

	}

}
