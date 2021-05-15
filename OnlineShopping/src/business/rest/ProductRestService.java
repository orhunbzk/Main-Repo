package business.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.Product;

@Stateless
@Path("ProductService")
public class ProductRestService {

	@PersistenceContext
	private EntityManager entityManager;

	@GET
	@Path("getProductsByCategoryId/{cid}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Product> getProduct(@PathParam("cid") int cID) {
		TypedQuery<Product> query = entityManager.createQuery("select p from Product p where category_id=?1",
				Product.class);
		List<Product> filtered = query.setParameter(1, cID).getResultList();
		return filtered;
	}

	@GET
	@Path("getAllProducts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {

		List<Product> products = entityManager.createQuery("select p from Product p", Product.class).getResultList();
		return products;
	}

	/*
	 * Example Json Structure Usage For New Product
	 * 
	 * {
	 * 
	 * "name":"Test", -> STR "price":345, -> INT "stock":45, -> INT "category":3 ->
	 * INT
	 * 
	 * }
	 */
	@POST
	@Path("addProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addProduct(JsonObject json) {

		Product product = new Product();

		try {
			product.setName(json.getString("name"));
			product.setPrice(json.getInt("price"));
			product.setStock(json.getInt("stock"));
			product.getCategory().setId(json.getInt("category"));
			entityManager.persist(product);
			return "Product Saved";
		} catch (Exception e) {
			return "Error Occured";
		}

	}

	@GET
	@Path("deleteProduct/{pid}")
	public String deleteProduct(@PathParam("pid") int pID) {
		try {
			Product remove = entityManager.find(Product.class, pID);
			entityManager.remove(remove);
			return "Product Removed";
		} catch (Exception e) {
			return "Error Occured";
		}
	}

}
