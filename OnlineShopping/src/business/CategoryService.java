package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Category;
import entity.Product;

@Stateless
public class CategoryService {

	@PersistenceContext
	private EntityManager entityManager;

	public boolean addCategory(Category category) {
		entityManager.persist(category);
		return true;

	}

	public void updateCategory(Category category) {
		entityManager.merge(category);

	}

	// fixed bug that lists more than one unique category.
	public List<String> getAllCategories() {
		return entityManager.createQuery("select distinct c.category from Category c", String.class).getResultList();
	}

	public List<Integer> getAllCategories_id() {
		return entityManager.createQuery("select distinct c.id from Category c", Integer.class).getResultList();

	}

	public List<Product> getFiltered(String category) {
		TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.category.category=?1",
				Product.class);
		List<Product> filtereds = query.setParameter(1, category).getResultList();
		return filtereds;
	}

}
