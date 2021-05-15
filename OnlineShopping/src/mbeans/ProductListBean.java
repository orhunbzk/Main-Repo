package mbeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.ProductService;
import entity.Product;

@RequestScoped
@Named
public class ProductListBean {

	@Inject
	private ProductService productService;

	private List<Product> products;

	@PostConstruct
	public void firstMethod() {
		this.products = productService.getAllProducts();
	}

	public void delete(int productID) {
		productService.deleteProduct(productID);
		firstMethod();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
