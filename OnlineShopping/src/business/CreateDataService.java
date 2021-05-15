package business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Address;
import entity.Card;
import entity.Category;
import entity.Coupon;
import entity.Customer;
import entity.Interests;
import entity.Orders;
import entity.Product;
import entity.Profile;
import entity.ShoppingBasket;
import entity.Role;

@Stateless
public class CreateDataService {

	@PersistenceContext
	private EntityManager entityManager;

	public void createTestData() {

		Card c1 = new Card("holder_name", "holder_lname", "1111-1111-1111-1111", 256);
		Card c2 = new Card("holder_name1", "holder_lname2", "2222-2222-2222-2222", 136);
		Card c3 = new Card("holder_name3", "holder_name4", "3333-3333-3333-3333", 456);

		Card c4 = new Card("CARD", "TEST", "4444", 123);

		Coupon coupon1 = new Coupon("Discount", "2025", "23456789");
		Coupon coupon2 = new Coupon("Promotion", "2022", "1234567");
		Coupon coupon3 = new Coupon("Discount", "2021", "73276467");

		Address ad1 = new Address("Turkey", "Istanbul", 34841, "Ataturk", 8, "Home");
		Address ad2 = new Address("Turkey", "Eskisehir", 44332, "TunalıHilmi", 11, "Work");
		Address ad3 = new Address("Turkey", "Ankara", 345553, "Ataturk", 5, "Holiday");

		Interests interest1 = new Interests("Mobile Devices");
		Interests interest2 = new Interests("Automobile Parts");
		Interests interest3 = new Interests("Gaming");

		Role stat1 = new Role("Admin");
		Role stat2 = new Role("Member");
		Role stat3 = new Role("Member");

		Profile prf1 = new Profile("xman.jpg", "istanbul", "GMT3", 1990);
		Profile prf2 = new Profile("spider.jpg", "ankara", "GMT3", 1995);
		Profile prf3 = new Profile("smile_face.jpg", "istanbul", "GMT3", 1985);

		Customer cus1 = new Customer("customer_name", "customer_lastname", "user", "csit526", prf1);
		Customer cus2 = new Customer("customer_name1", "customer_lastname1", "user1", "23456", prf2);
		Customer cus3 = new Customer("customer_name2", "customer_lastname2", "user2", "34567", prf3);

		ShoppingBasket basket1 = new ShoppingBasket("basket1");
		ShoppingBasket basket2 = new ShoppingBasket("basket2");
		ShoppingBasket basket3 = new ShoppingBasket("basket3");

		Orders ord1 = new Orders(230000, 18);
		Orders ord2 = new Orders(110000, 18);
		Orders ord3 = new Orders(444000, 18);

		Category cat1 = new Category("Electronic");
		Category cat2 = new Category("Sport");
		Category cat3 = new Category("Outdoor");
		Category cat4 = new Category("Home");

		Product p1 = new Product("iPad", 60000, 100);
		Product p2 = new Product("Dumbell", 200, 550);
		Product p3 = new Product("Camping Set", 2500, 200);
		Product p4 = new Product("Retro Sofa", 85999, 10);

		cat1.addProduct(p1);
		cat2.addProduct(p2);
		cat3.addProduct(p3);
		cat4.addProduct(p4);

		basket1.addProduct(p3);
		basket2.addProduct(p1);
		basket3.addProduct(p2);

		basket3.addProduct(p4);

		cus1.addCard(c1);
		cus2.addCard(c2);
		cus3.addCard(c3);

		cus3.addCard(c4);

		cus1.addCoupon(coupon1);
		cus2.addCoupon(coupon3);
		cus1.addCoupon(coupon2);

		cus1.addAddress(ad2);
		cus2.addAddress(ad1);
		cus3.addAddress(ad3);

		cus1.addInterests(interest3);
		cus2.addInterests(interest2);
		cus3.addInterests(interest1);

		stat1.addCustomer(cus1);
		stat2.addCustomer(cus2);
		stat2.addCustomer(cus3);

		cus1.setShoppingBasket(basket1);
		cus2.setShoppingBasket(basket2);
		cus3.setShoppingBasket(basket3);

		ord1.addShoppingBasket(basket1);
		cus1.setOrders(ord1);

		ord2.addShoppingBasket(basket2);
		cus2.setOrders(ord2);

		ord3.addShoppingBasket(basket3);
		cus3.setOrders(ord3);

		entityManager.persist(ord1);
		entityManager.persist(ord2);
		entityManager.persist(ord3);

		entityManager.persist(cus1);
		entityManager.persist(cus2);
		entityManager.persist(cus3);

		entityManager.persist(stat1);
		entityManager.persist(stat2);

		entityManager.persist(cat1);
		entityManager.persist(cat2);
		entityManager.persist(cat3);
		entityManager.persist(cat4);

	}

}
