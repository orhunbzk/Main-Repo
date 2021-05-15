package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// avatar path (test.jpg)
	private String avatar;
	private String location;
	private String timeZone;
	private int birthYear;

	@OneToOne(mappedBy = "profile")
	private Customer customer;

	public Profile(String avatar, String location, String timeZone, int birthYear) {
		super();
		this.avatar = avatar;
		this.location = location;
		this.timeZone = timeZone;
		this.birthYear = birthYear;
	}

	public Profile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", avatar=" + avatar + ", location=" + location + ", timeZone=" + timeZone
				+ ", birthYear=" + birthYear + ", customer=" + customer + "]";
	}

}
