package model;

import java.beans.ConstructorProperties;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity

public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String firstName;
	@Column
	private String surName;
	/*@Column
	private String phoneNumber;*/
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="customerId")
	private Set<PhoneNumber> phoneNumbers;

	private String address;
	
	/* @OneToMany says: 'one' person can have 'many' email addresses.
	 * When you store the EmailAddress objects in a Set, hibernate will 
	 * create a table called EmailAddress and insert an entry in that
	 * table for each email address.
	 *  
	 * 
	 * @JoinColumn creates an extra column in the EmailAddress table
	 * called 'customerId' and inserts the primary key from this table
	 * into that new column. E.g. Joe Bloggs' id is 1 and Joe has two
	 * email addresses, the email addresses will both have a personId
	 * of 1. personId is the foreign key. 
	 * 
	 * cascade=CascadeType.ALL
	 * If I delete a Person from the 'one' table, it will cascade into
	 * the EmailAddress table, i.e. all email address entries for that
	 * person will be deleted too.
	 * 
	 * A Set is a list that won't store duplicates. A Set is an interface,
	 * to create a Set, you should instantiate the HashSet class (which
	 * implements the Set interface).
	 * 
	 * Person
	 * id	firstname surname phoneNumber   
	 * 1    Joe       Bloggs  0862134567
	 * 
	 * EmailAddress
	 * id	email 				  personId
	 * 100  joe@bloggs.ie		  1
	 * 101  joebloggs@gmail.com   1
	 * 102	jb@me.com			  1
	 * 
	 * */
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="customerId")
	private Set<EmailAddress> emails;
	
	@Column
	private String description;
	@Column 
	private String recommendedBy;
	@Column
	private String year;
	@Column
	private String startdate;
	@Column
	private String finishdate;
	
	public Customer() {}

	public Customer(int id, String firstName, String surName, Set<PhoneNumber> phoneNumbers, String address,
			Set<EmailAddress> emails, String description, String recommendedBy, String year, String startdate,
			String finishdate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.phoneNumbers = phoneNumbers;
		this.address = address;
		this.emails = emails;
		this.description = description;
		this.recommendedBy = recommendedBy;
		this.year = year;
		this.startdate = startdate;
		this.finishdate = finishdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<EmailAddress> getEmails() {
		return emails;
	}

	public void setEmails(Set<EmailAddress> emails) {
		this.emails = emails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRecommendedBy() {
		return recommendedBy;
	}

	public void setRecommendedBy(String recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(String finishdate) {
		this.finishdate = finishdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((finishdate == null) ? 0 : finishdate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((phoneNumbers == null) ? 0 : phoneNumbers.hashCode());
		result = prime * result + ((recommendedBy == null) ? 0 : recommendedBy.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (finishdate == null) {
			if (other.finishdate != null)
				return false;
		} else if (!finishdate.equals(other.finishdate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (phoneNumbers == null) {
			if (other.phoneNumbers != null)
				return false;
		} else if (!phoneNumbers.equals(other.phoneNumbers))
			return false;
		if (recommendedBy == null) {
			if (other.recommendedBy != null)
				return false;
		} else if (!recommendedBy.equals(other.recommendedBy))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", phoneNumbers="
				+ phoneNumbers + ", address=" + address + ", emails=" + emails + ", description=" + description
				+ ", recommendedBy=" + recommendedBy + ", year=" + year + ", startdate=" + startdate + ", finishdate="
				+ finishdate + "]";
	}
	
	
	
}

	
	
	
	