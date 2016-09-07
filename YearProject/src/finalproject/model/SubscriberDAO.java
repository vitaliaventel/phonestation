package finalproject.model;

import java.util.ArrayList;

/**
 * Interface for class Administrator
 * 
 * @author VitaliyL
 */
public interface SubscriberDAO {

	public int addSubscriber(Subscriber subscriber);

	public void updateSubscriber(Subscriber subscriber);

	public void deleteSubscriber(int subId);

	public Subscriber getSubscriber(int subId);

	public void setContacts(ArrayList<Subscriber> subs);

	public ArrayList<Subscriber> findContacts();
}
