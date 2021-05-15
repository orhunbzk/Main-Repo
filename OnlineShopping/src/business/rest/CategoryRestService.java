package business.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.Category;

@Stateless
@Path("CategoryService")
public class CategoryRestService {

	@PersistenceContext
	private EntityManager entityManager;

	@GET
	@Path("getCategory/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category getCategory(@PathParam("cid") int cID) {
		return entityManager.find(Category.class, cID);
	}

	@GET
	@Path("getAllCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories() {
		List<Category> categories = entityManager.createQuery("select c from Category c", Category.class)
				.getResultList();
		return categories;
	}

	/*
	 * Example Json Structure Usage For New Category
	 * 
	 * { "category":"test" --> STR }
	 * 
	 */
	@POST
	@Path("addCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCategory(Category category) {

		try {
			entityManager.persist(category);
			return "Category Saved";
		} catch (Exception e) {
			return "Error Occured";
		}
	}

	@GET
	@Path("deleteCategory/{cid}")
	public String deleteCategory(@PathParam("cid") int cID) {
		try {
			Category remove = entityManager.find(Category.class, cID);
			entityManager.remove(remove);
			return "Category Removed";

		} catch (Exception e) {
			return "Error Occured";
		}
	}

}
