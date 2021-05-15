package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastname;

	private String userName;
	private String password;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<Card> cards = new ArrayList<Card>();

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<Coupon> coupons = new ArrayList<Coupon>();

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<Interests> interests = new ArrayList<Interests>();

	@OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private ShoppingBasket shoppingBasket;

	@OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private Profile profile;

	@ManyToOne
	private Role role;

	@ManyToOne
	private Orders orders;

	public Customer(String name, String lastname, String userName, String password, Profile profile) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.profile = profile;
		this.userName = userName;
		this.password = password;
	}

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void addCard(Card card) {
		this.cards.add(card);
		card.setCustomer(this);

	}

	public void addCoupon(Coupon coupon) {
		this.coupons.add(coupon);
		coupon.setCustomer(this);

	}

	public void addAddress(Address address) {
		this.addresses.add(address);
		address.setCustomer(this);

	}

	public void addInterests(Interests interest) {
		this.interests.add(interest);
		interest.setCustomer(this);

	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void setShoppingBasket(ShoppingBasket shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	public ShoppingBasket getShoppingBasket() {
		return shoppingBasket;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Role getStatus() {
		return role;
	}

	public void setStatus(Role role) {
		this.role = role;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Orders getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
	}

}
