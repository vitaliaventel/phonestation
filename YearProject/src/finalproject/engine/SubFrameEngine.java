package finalproject.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import finalproject.inface.ChangeNumberDialog;
import finalproject.inface.PayDialog;
import finalproject.inface.SubFrame;
import finalproject.model.Subscriber;
/**
 * Class controller for SubFrame, which waiting for button press
 * and sending request's to administrator
 * @author VitaliyL
 *	
 */
public class SubFrameEngine implements ActionListener {

	private Subscriber sub;
	private SubFrame parent;
	private Date today;

	public SubFrameEngine(Subscriber sub) {
		this.sub = sub;
	}

	/**
	 *  Overrides method, which waiting for button press.
	 *  @param e  source
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		today = new Date();
		JButton src = (JButton) e.getSource();
		if (src.getText().equals("Pay")) {
			new PayDialog(parent, sub);
			request("Pay request! " + today.toString());
		} else if (src.getText().equals("Cancel services")) {
			request("Cancel services request! " + today.toString());
			JOptionPane.showMessageDialog(parent, "You requested for cancel your services. ", "Bad idea!",
					JOptionPane.INFORMATION_MESSAGE);
			
		} else if (src.getText().equals("Change number")) {
			new ChangeNumberDialog(parent, sub);
			request("Change number request! " + today.toString());
		}

	}

	/**
	 *  Generate subscriber request with message
	 *  @param message Request message
	 */
	private void request(String message) {
		try {
			File file = new File("resources", "subrequest_main.txt");
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			try {
				out.println(message);
				out.println(sub.toString());
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
