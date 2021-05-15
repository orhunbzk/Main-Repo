package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Interests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String interest;

	@ManyToOne
	public Customer customer;

	public Interests(String interest) {
		super();
		this.interest = interest;
	}

	public Interests() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Interests [id=" + id + ", interest=" + interest + ", customer=" + customer + "]";
	}

}
