package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Customer;

@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;

	public Customer checkUser(String username, String password) {

		List<Customer> customers = entityManager
				.createQuery("select c from Customer c where c.userName=?1 and c.password=?2", Customer.class)
				.setParameter(1, username).setParameter(2, password).getResultList();
		if (customers.size() == 1) {
			return customers.get(0);
		}
		return null;
	}

}
