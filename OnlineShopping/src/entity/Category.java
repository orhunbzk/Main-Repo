package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String category;

	@OneToMany(mappedBy = "category", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	@JsonIgnore
	private List<Product> products = new ArrayList<>();

	public Category(String category) {
		super();
		this.category = category;
	}

	public Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
		product.setCategory(this);

	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + ", products=" + products + "]";
	}

}
