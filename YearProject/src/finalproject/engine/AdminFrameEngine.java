package finalproject.engine;

import finalproject.inface.*;
import finalproject.model.Subscriber;
import finalproject.model.Admin;
import finalproject.model.SubsModel;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.util.ArrayList;

/**
 * Class controller for AdminFrame, which waiting for button press
 * and control subscriber data base
 * @author VitaliyL
 *	
 */
public class AdminFrameEngine implements ActionListener {

	private AdminFrame parent;
	private Admin admin = new Admin();
	private JTable subsTable;
	private Subscriber sub;

	/**
	 * Constructor creates listener
	 * @param subsTable subscribers table (data base)
	 */
	public AdminFrameEngine(JTable subsTable) {
		this.subsTable = subsTable;
	}

	/**
	 *  Overrides method, which waiting for button press.
	 *  @param e  source
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if (src.getText().equals("Add")) {
			addSub();
		} else if (src.getText().equals("Update File")) {
			updateFile();
		} else if (src.getText().equals("Load File")) {
			loadFile();
		} else if (src.getText().equals("Edit")) {
			editSub();
		} else if (src.getText().equals("Delete")) {
			deleteSub();
		} else if (src.getText().equals("Requests")) {
			new RequestsDialog(parent);
		}
	}

	/**
	 * Load file with subscribers.
	 */
	private void loadFile() {
		try {
			File file = new File("resources","subscribers.ser");
			ArrayList<Subscriber> subs = new ArrayList<Subscriber>();
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			try {
				subs = (ArrayList<Subscriber>) in.readObject();
				admin.setContacts(subs);
				upSub();
			} finally {
				in.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Update file with subscribers.
	 */
	private void updateFile() {
		try {
			File file = new File("resources","subscribers.ser");
			ArrayList<Subscriber> subs = admin.findContacts();
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			try {
				out.writeObject(subs);
			} finally {
				out.close();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Update subscribers table (data base)
	 */
	private void upSub() {
		ArrayList<Subscriber> subs = admin.findContacts();
		SubsModel sm = new SubsModel(subs);
		subsTable.setModel(sm);
	}

	/**
	 * Add new subscriber
	 */
	private void addSub() {
		AddSubDialog subDial = new AddSubDialog(parent);
		saveSub(subDial);
	}

	/**
	 * Save new subscriber
	 * @param asd Info from window dialog
	 */
	private void saveSub(AddSubDialog asd) {
		if (asd.isSave()) {
			sub = asd.getSubscriber();
			if (sub.getId() == 0) {
				admin.addSubscriber(sub);
			} else {
				admin.updateSubscriber(sub);
			}
			upSub();
		}
	}

	/**
	 * Edit subscriber information
	 */
	private void editSub() {
		int sr = subsTable.getSelectedRow();
		if (sr != -1) {
			int id = Integer.parseInt(subsTable.getModel().getValueAt(sr, 0).toString());
			sub = admin.getSubscriber(id);
			AddSubDialog asd = new AddSubDialog(parent, sub);
			saveSub(asd);
		} else {
			JOptionPane.showMessageDialog(parent, "Choose one of subs!" , "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Delete base from table
	 */
	private void deleteSub() {
		int sr = subsTable.getSelectedRow();
		if (sr != -1) {
			int id = Integer.parseInt(subsTable.getModel().getValueAt(sr, 0).toString());
			admin.deleteSubscriber(id);
			upSub();
		} else {
			JOptionPane.showMessageDialog(parent, "Choose one of subs!" , "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
