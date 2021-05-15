package mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.ProductService;
import entity.Category;
import entity.Product;

@RequestScoped
@Named
public class ProductBean {

	@Inject
	private ProductService productService;

	private Product product = new Product();


	private int selectedCategory;

	private int selectedProductId;

	private List<Integer> products_id;

	@PostConstruct
	public void firstMethod() {
		this.products_id = productService.getAllProducts_id();
	}

	public String saveProduct()

	{
		product.getCategory().setId(selectedCategory);
		productService.addProduct(product);
		return "addproduct";
	}

	public void updateProduct() {
		product.setId(selectedProductId);
		product.getCategory().setId(selectedCategory);
		productService.updateProduct(product);

	}

	@PreDestroy
	public void destroy() {

	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setSelectedCategory(int selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public int getSelectedCategory() {
		return selectedCategory;
	}

	public List<Integer> getProducts_id() {
		return products_id;
	}

	public void setProducts_id(List<Integer> products_id) {
		this.products_id = products_id;
	}

	public void setSelectedProductId(int selectedProductId) {
		this.selectedProductId = selectedProductId;
	}

	public int getSelectedProductId() {
		return selectedProductId;
	}

}
