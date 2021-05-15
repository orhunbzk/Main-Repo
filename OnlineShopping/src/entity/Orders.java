package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double total;
	private double vat;

	@OneToMany(mappedBy = "orders", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<ShoppingBasket> shoppingBasketList = new ArrayList<ShoppingBasket>();

	@OneToMany(mappedBy = "orders", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<Customer> customerList = new ArrayList<Customer>();

	public Orders(double total, double vat) {
		super();
		this.total = total;
		this.vat = vat;
	}

	public Orders() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public void setShoppingBasketList(List<ShoppingBasket> shoppingBasketList) {
		this.shoppingBasketList = shoppingBasketList;
	}

	public List<ShoppingBasket> getShoppingBasketList() {
		return shoppingBasketList;
	}

	public void addShoppingBasket(ShoppingBasket sbasket) {
		this.shoppingBasketList.add(sbasket);
		sbasket.setOrders(this);

	}

	public void addCustomer(Customer customer) {
		this.customerList.add(customer);
		customer.setOrders(this);

	}

}
