package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ShoppingBasket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String basketName;

	@OneToMany(mappedBy = "shoppingBasket", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<Product> products = new ArrayList<Product>();

	@ManyToOne
	private Orders orders;

	public ShoppingBasket(String basketName) {
		super();
		this.basketName = basketName;
	}

	public ShoppingBasket() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBasketName() {
		return basketName;
	}

	public void setBasketName(String basketName) {
		this.basketName = basketName;
	}

	public void addProduct(Product p) {
		this.products.add(p);
		p.setShoppingBasket(this);

	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "ShoppingBasket [id=" + id + ", basketName=" + basketName + "]";
	}

}
