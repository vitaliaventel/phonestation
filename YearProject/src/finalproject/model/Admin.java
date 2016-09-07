package finalproject.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Calendar;

/**
 * Class helps to manage subscribers data base.
 * @author VitaliyL
 *
 */
public class Admin implements SubscriberDAO {
	/** List of subscribers*/
	private ArrayList<Subscriber> subs = new ArrayList<Subscriber>();

	/** Add new subscriber and set ID
	*@param subscriber Subscriber
     * @return Returns subscribers id
     */
	@Override
	public int addSubscriber(Subscriber subscriber) {
		int id = hashCode();
		subscriber.setId(id);
		subs.add(subscriber);
		return id;
	}
	
	/** Update subscriber info 
	 *@param subscriber Subscriber
	 */
	@Override
	public void updateSubscriber(Subscriber subscriber) {
		Subscriber oldSubscriber = getSubscriber(subscriber.getId());
		if (oldSubscriber != null) {
			oldSubscriber.setFirstName(subscriber.getFirstName());
			oldSubscriber.setLastName(subscriber.getLastName());
			oldSubscriber.setPhoneNumber(subscriber.getPhoneNumber());
			oldSubscriber.setBalance(subscriber.getBalance());
			oldSubscriber.setStatus(subscriber.isStatus());
			oldSubscriber.setServices(subscriber.getServices());
			oldSubscriber.setMonthDonate(subscriber.getServices());
		}
	}

	/** Delete subscriber from list
	 * @param subId Subscriber identifier 
	 */
	@Override
	public void deleteSubscriber(int subId) {
		for (Iterator<Subscriber> it = subs.iterator(); it.hasNext();) {
			Subscriber sub = it.next();
			if (sub.getId() == subId) {
				it.remove();
			}
		}
	}

	/** Method for getting subscriber by ID
	 * @param subId Subscriber identifier
     * @return Returns subscriber or null
     */
	@Override
	public Subscriber getSubscriber(int subId) {
		for (Subscriber subscriber : subs) {
			if (subscriber.getId() == subId) {
				return subscriber;
			}
		}
		return null;
	}

	/** Find subscribers data base, also if today first day of month
	 *  set subscriber status (true/false).
	 * @return Subscriber list
	 */
	@Override
	public ArrayList<Subscriber> findContacts() {
		Collections.sort(subs);
		Calendar cal = Calendar.getInstance();
		for(Subscriber item : subs){
			if(cal.get(Calendar.DAY_OF_MONTH) == 1){
				int temp = item.getBalance() - item.getMonthDonate();
				if(temp < 0){
					item.setStatus(false);
				} else{
					item.setBalance(temp);
				}
			}
		}
		return subs;
	}

	@Override
	public void setContacts(ArrayList<Subscriber> subs) {
		this.subs = subs;
	}

	@Override
	public int hashCode() {
		int subId = Math.abs((int) Math.round(Math.random() * 1000 + System.currentTimeMillis()));
		while (getSubscriber(subId) != null) {
			subId = Math.abs((int) Math.round(Math.random() * 1000 + System.currentTimeMillis()));
		}
		return subId;
	}

}
