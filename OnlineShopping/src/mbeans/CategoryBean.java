package mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.CategoryService;
import entity.Category;
import entity.Product;

@RequestScoped
@Named
public class CategoryBean {

	@Inject
	private CategoryService categoryService;

	private Category category = new Category();

	// for listing categories - combox
	private List<String> categories;

	private List<Integer> categories_id;

	private List<Product> filtered;

	private String selectedCategory;

	private int pickedCategory;

	@PostConstruct
	public void firstMethod() {
		this.categories = categoryService.getAllCategories();
		this.categories_id = categoryService.getAllCategories_id();
	}

	public String saveCategory() {
		categoryService.addCategory(category);
		return "productlist";
	}

	public String updateCategory() {
		category.setId(pickedCategory);
		category.setCategory(this.category.getCategory());
		categoryService.updateCategory(category);
		return "updatecategory";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String filterCategories() {
		filtered = categoryService.getFiltered(selectedCategory);
		return null;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<Product> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Product> filtered) {
		this.filtered = filtered;
	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public List<Integer> getCategories_id() {
		return categories_id;
	}

	public void setCategories_id(List<Integer> categories_id) {
		this.categories_id = categories_id;
	}

	public void setPickedCategory(int pickedCategory) {
		this.pickedCategory = pickedCategory;
	}

	public int getPickedCategory() {
		return pickedCategory;
	}

}
