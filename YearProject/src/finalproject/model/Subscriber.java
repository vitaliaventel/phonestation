package finalproject.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Class for subscriber info
 * @author VitaliyL
 *
 */
public class Subscriber extends Person implements Serializable, Cloneable, Comparable {
	/** Subscriber identifier*/
	private int id;
	/** Subscriber phone number*/
	private String phoneNumber;
	/** Account balance*/
	private int balance;
	/** Subscriber services*/
	private ArrayList<String> services;
	/** Subscriber status*/
	private boolean status;
	/** Subscriber month donate*/
	private int monthDonate;
	/** Static field - price for one service*/
	private static final int PRICE = 13;

	/**
	 * Constructor create new object with entered parameters.
	 * @param id Subscriber ID
	 * @param phoneNumber Subscriber phone number
	 * @param services Subscriber services
	 * @param status Subscriber status
	 * @see Subscriber#Subscriber(String, ArrayList, boolean)
	 * @see Subscriber#Subscriber(String, String, String)
	 * @see Subscriber#Subscriber(int, String, ArrayList, boolean)
	 * @see Subscriber#Subscriber(String, String, String, ArrayList, boolean, int, int)
	 */
	public Subscriber(int id, String phoneNumber, ArrayList<String> services, boolean status) {
		this.id = id;
		firstName = "none";
		lastName = "none";
		this.phoneNumber = phoneNumber;
		this.services = services;
		this.status = status;
		balance = 0;
	}

	/**
	 * Constructor create new object with entered parameters.
	 * @param phoneNumber Subscriber phone number
	 * @param services Subscriber services
	 * @param status Subscriber status
	 */
	public Subscriber(String phoneNumber, ArrayList<String> services, boolean status) {
		firstName = "none";
		lastName = "none";
		this.phoneNumber = phoneNumber;
		this.services = services;
		this.status = status;
		balance = 0;
	}

	/**
	 * Constructor create new object with entered parameters.
	 * @param firstName Subscriber first name
	 * @param lastName	Subscriber last name
	 * @param phoneNumber	Subscriber phone number
	 */
	public Subscriber(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		balance = 0;
		status = true;
	}

	/**
	 * Constructor create new object with entered parameters.
	 * @param firstName Subscriber first name
	 * @param lastName	Subscriber last name
	 * @param phoneNumber	Subscriber phone number
	 * @param services Subscriber services
	 * @param status Subscriber status
	 * @param balance Subscriber balance
	 * @param id Subscriber identifier
	 */
	public Subscriber(String firstName, String lastName, String phoneNumber, ArrayList<String> services, boolean status,
			int balance, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.services = services;
		this.status = status;
		this.balance = balance;
		this.id = id;
		monthDonate = PRICE * services.size();
	}

	/** Method for getting value of field {@link Subscriber#status}
     * @return Returns subscriber status
     */
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setMonthDonate(ArrayList<String> services) {
		monthDonate = PRICE * services.size();
	}
	/** Method for getting value of field {@link Subscriber#monthDonate}
     * @return Returns subscriber month donate
     */
	public int getMonthDonate() {
		return monthDonate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setServices(ArrayList<String> services) {
		this.services = new ArrayList<String>();
		this.services = services;
	}

	public void setId(int id) {
		this.id = id;
	}

	/** Method for getting value of field {@link Subscriber#id}
     * @return Returns subscriber identifier
     */
	public int getId() {
		return id;
	}

	/** Method for getting value of field {@link Subscriber#phoneNumber}
     * @return Returns subscriber phone number
     */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/** Method for getting value of field {@link Subscriber#balance}
     * @return Returns subscriber balance
     */
	public int getBalance() {
		return balance;
	}

	/** Method for getting value of field {@link Subscriber#services}
     * @return Returns subscriber services
     */
	public ArrayList<String> getServices() {
		return services;
	}

	/** Subscriber pay for services
	 * @param money how much money
     */
	public void pay(int money) {
		balance += money;
	}
	/** Subscriber change number request
	 * @param number new phone number
	 */
	public void changeNumber(String number) {
		phoneNumber = number;
	}

	/** Subscriber cancel services
	 * @return true
	 */
	public boolean cancelServices() {
		return true;
	}
	
	/**
	 *  Method to compare by subscriber last name and if them equals then
	 *  by first name
	 */
	@Override
	public int compareTo(Object obj) {
		Subscriber entry = (Subscriber)obj;
		 int result = lastName.compareTo(entry.lastName);
         if(result != 0) {
                return result;
         }
         result = firstName.compareTo(entry.firstName);
         if(result != 0) {
                return result;
         }
		return 0;
	}

	@Override
	public String toString() {
		return "Subscriber [id = " +  id + "\n" +
				"First name = " + firstName + "\n" +
				"Last name = " + lastName + "\n" +
				"phoneNumber = " + phoneNumber + "\n" +
				"score = " + balance + "\n" +
				"services = " + services+ "\n" +
				 "status = " + status + "]" + "\n" +
				"*************************************************";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		if (id != other.id)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (balance != other.balance)
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	@Override
	public Object clone(){
		try{
			return super.clone();
		} catch(CloneNotSupportedException e){
			return this;
		}
	}

}
