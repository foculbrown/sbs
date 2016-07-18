package sbsTest.bruce.dataObjects;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The POJO/data object for employees.
 * 
 * @author Bruce Brown
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String emailAddress;
	private String phoneNumber;
	private String positionCategory;
	private Date dateHired;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private boolean activeFlag;

	/** Constructor with no parameters. */
	public Employee() {

	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param middleInitial
	 * @param emailAddress
	 * @param phoneNumber
	 * @param positionCategory
	 * @param dateHired
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param activeFlag
	 */
	public Employee(Integer id, String firstName, String lastName, String middleInitial, String emailAddress,
			String phoneNumber, String positionCategory, Date dateHired, String address1, String address2, String city,
			String state, String zipCode, boolean activeFlag) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.positionCategory = positionCategory;
		this.dateHired = dateHired;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleInitial
	 */
	public String getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * @param middleInitial
	 *            the middleInitial to set
	 */
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the positionCategory
	 */
	public String getPositionCategory() {
		return positionCategory;
	}

	/**
	 * Position codes should be "Indirect", "Direct", "Program Manager",
	 * "Director, or "Executive". All other strings will cause a
	 * RuntimeException.
	 * 
	 * @param positionCategory
	 *            the positionCategory to set
	 */
	public void setPositionCategory(String positionCategory) {
		if (positionCategory.equals("Indirect") || positionCategory.equals("Direct")
				|| positionCategory.equals("Program Manager") || positionCategory.equals("Director")
				|| positionCategory.equals("Executive")) {
			this.positionCategory = positionCategory;
		} else {
			throw new RuntimeException("positionCategory incorrect");
		}
	}

	/**
	 * @return the dateHired
	 */
	public Date getDateHired() {
		return dateHired;
	}

	/**
	 * @param dateHired
	 *            the dateHired to set
	 */
	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1
	 *            the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2
	 *            the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the activeFlag
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag
	 *            the activeFlag to set
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial="
				+ middleInitial + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
				+ ", positionCategory=" + positionCategory + ", dateHired=" + dateHired + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", activeFlag=" + activeFlag + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activeFlag ? 1231 : 1237);
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dateHired == null) ? 0 : dateHired.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((positionCategory == null) ? 0 : positionCategory.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (activeFlag != other.activeFlag)
			return false;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dateHired == null) {
			if (other.dateHired != null)
				return false;
		} else if (!dateHired.equals(other.dateHired))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleInitial == null) {
			if (other.middleInitial != null)
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (positionCategory == null) {
			if (other.positionCategory != null)
				return false;
		} else if (!positionCategory.equals(other.positionCategory))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

}
