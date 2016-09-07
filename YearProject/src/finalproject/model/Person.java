package finalproject.model;

import java.io.Serializable;

/**
 * Abstract class Person which super class for Subscriber
 * @author VitaliyL
 *
 */
public abstract class Person implements Serializable {

	/** First name of person*/
	protected String firstName;
	/** Last name of person*/
	protected String lastName;

	/** Method for getting value of field {@link Person#firstName}
     * @return Returns first name
     */
	public String getFirstName() {
		return firstName;
	}
	
	/** Method for getting value of field {@link Person#lastName}
     * @return Returns last name
     */
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
