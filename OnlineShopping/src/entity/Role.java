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
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;

	@OneToMany(mappedBy = "role", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<Customer> customers = new ArrayList<Customer>();

	public Role(String status) {
		super();
		this.status = status;
	}

	public Role() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);
		customer.setStatus(this);
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + ", customers=" + customers + "]";
	}

}
