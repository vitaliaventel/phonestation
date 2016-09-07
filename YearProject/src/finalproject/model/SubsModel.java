package finalproject.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *  Class for preparing JTable
 * @author VitaliyL
 *
 */
public class SubsModel extends AbstractTableModel {
	/** Headers of table*/
	private static final String[] headers = { "ID", "First Name", "Last Name", "Phone", "Score", "Services", "Status" };
	/** Subscriber list*/
	private final ArrayList<Subscriber> subs;
	/**
	 * Constructor to fill subscriber list
	 * @param subs Subscriber list
	 */
	public SubsModel(ArrayList<Subscriber> subs) {
		this.subs = subs;
	}

	/** Method getting headers length
	 * @return Headers length
	 */
	@Override
	public int getColumnCount() {
		return headers.length;
	}
	/** Method getting size of subscriber list
	 * @return Size of subs list
	 */
	@Override
	public int getRowCount() {
		return subs.size();
	}

	/** Method getting column name
	 * @param col column number
	 * @return Column name
	 */
	@Override
	public String getColumnName(int col) {
		return headers[col];
	}

	/** Method getting column name
	 * @param row row number
	 * @param col column number
	 * @return Object
	 */
	@Override
	public Object getValueAt(int row, int col) {
		Subscriber subscriber = subs.get(row);
		switch (col) {
		case 0:
			return subscriber.getId();
		case 1:
			return subscriber.getFirstName();
		case 2:
			return subscriber.getLastName();
		case 3:
			return subscriber.getPhoneNumber();
		case 4:
			return subscriber.getBalance();
		case 5:
			return subscriber.getServices();
		default:
			return subscriber.isStatus();
		}
	}

}
