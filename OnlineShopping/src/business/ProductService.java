package business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Product;

@Stateless
public class ProductService {

	@PersistenceContext
	private EntityManager entityManager;

	public boolean addProduct(Product product) {
		entityManager.persist(product);
		return true;
	}

	public void updateProduct(Product product) {
		entityManager.merge(product);

	}

	public List<Integer> getAllProducts_id() {
		return entityManager.createQuery("select distinct p.id from Product p", Integer.class).getResultList();

	}

	public void deleteProduct(int productID) {
		Product delete = entityManager.find(Product.class, productID);
		entityManager.remove(delete);

	}

	public List<Product> getAllProducts() {
		return entityManager.createQuery("select p from Product p", Product.class).getResultList();
	}

	public List<Product> getFiltered(String category) {
		TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.category.category=?1",
				Product.class);
		List<Product> filtereds = query.setParameter(1, category).getResultList();
		return filtereds;
	}

}
