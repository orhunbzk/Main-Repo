package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ownerName;
	private String ownerLastName;
	private String cardNumber;
	private int cvv;

	@ManyToOne
	public Customer customer;

	public Card(String ownerName, String ownerLastName, String cardNumber, int cvv) {
		super();
		this.ownerName = ownerName;
		this.ownerLastName = ownerLastName;
		this.cvv = cvv;
		this.cardNumber = cardNumber;
	}

	public Card() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", ownerName=" + ownerName + ", ownerLastName=" + ownerLastName + ", cvv=" + cvv
				+ "]";
	}

}