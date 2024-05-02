package com.example.ECommerce;

import com.example.ECommerce.dao.Dao;
import com.example.ECommerce.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(Dao dao){
		return runner-> {
//			###### Relation between User And Orders #######
//			createUser(dao);
//			getUserById(dao);
//			deleteUserById(dao);
//			updateUser(dao);
//			getUser(dao);
//			getOrdersByUserId(dao);

//			###### Relation between Category And Product #######
//			createCategory(dao);
//			getCategoryById(dao);
//			deleteCategoryById(dao);
//			updateCategory(dao);
//			getProductsByCategoryId(dao);

//			 ###### Relation between Orders And Product #######
//			getProductsByOrderId(dao);
//			getOrdersByProductId(dao);

//			###### Relation between User And Payment #######
//			getPaymentByUserId(dao);

//			##### Account ####
//			deleteAccount(dao);
//			updateAccount(dao);

			// ###### Orders #######
//			deleteOrder(dao);
//			updateOrder(dao);

			// ###### Payment #######
//			deletePayment(dao);
//			updatePayment(dao);
			getPayments(dao);

			// ###### Relation between User And Account #######
//			getAccountByUserId(dao);
		};
	}

	private void updateOrder(Dao dao) {
		int id = 2;
		Orders order = dao.getOrderById(id);
		order.setAmount(1111);
		dao.updateOrder(order);
		System.out.println("DONE!!!");
	}

	private void deleteOrder(Dao dao) {
		int id = 1;
		dao.deleteOrder(id);
		System.out.println("Done!!!");
	}

	private void getPayments(Dao dao){
		int id = 7;
		System.out.println(dao.getPaymentByUserId(id));
	}

	// ###### Relation between User And Account #######
	private void getAccountByUserId(Dao dao) {
		int id = 7;
		Account account = dao.getAccountByUserId(id);
		System.out.println("User : " + account.getUser());
		System.out.println("Account : " + account);

	}

	//			##### Account ####
	private void updateAccount(Dao dao) {
		int id = 2;
		Account account = dao.getAccountById(id);
		account.setImage("dddd");
		dao.updateAccount(account);
		System.out.println("DONE!!!");
	}

	private void deleteAccount(Dao dao) {
		int id = 1;
		dao.deleteAccount(id);
		System.out.println("Done!!!");
	}

	// ###### Relation between User And Payment #######
	private void getPaymentByUserId(Dao dao) {
		int id = 8;
		List<Payment> payments = dao.getPaymentByUserId(id);
		System.out.println("Payments : " + payments);
	}

	// ###### Relation between Orders And Product #######
	private void getOrdersByProductId(Dao dao) {
		int idOfProduct = 3;
		List<Orders> orders = dao.getOrderByProductId(idOfProduct);
		System.out.println("Orders : " + orders);
	}

	private void getProductsByOrderId(Dao dao) {
		int idOfOrder = 1;
		List<Product> products = dao.getProductByOrderId(idOfOrder);
		System.out.println("Products: " + products);
	}

	// ###### Relation between Category And Product #######
	private void getProductsByCategoryId(Dao dao) {
		int id = 2;
		List<Product> products = dao.getProductByCategoryId(id);
		System.out.println("Orders : " + products);
	}

	private void updateCategory(Dao dao) {
		Category category = new Category();
		category.setNameOfCategory("category666");
		dao.updateCategory(category);
		System.out.println("Category : " + category);
	}

	private void deleteCategoryById(Dao dao) {
		int id = 1;
		dao.deleteCategoryById(id);
		System.out.println("Done!!!");
	}

	private void getCategoryById(Dao dao) {
		int id = 1;
		Category category = dao.getCategoryById(id);
		System.out.println("CATEGORY : " + category);
	}

	private void createCategory(Dao dao) {
		Category category = new Category("category1121");
		Product product1 = new Product("pro111" , 233 , "desc1");
		Product product2 = new Product("pro222" , 233 , "desc2");
		category.addProducts(product1);
		category.addProducts(product2);
		dao.saveCategory(category);
		System.out.println("CATEGORY : " + category);
	}


	// ###### Relation between User And Order #######

	private void getOrdersByUserId(Dao dao) {
		int id = 8;
		List<Orders> orders = dao.getOrdersByUserId(id);
		System.out.println("Orders : " + orders);
	}

	private void getUser(Dao dao) {
		int id = 1;
		UserInfo user = dao.getUserWithAllInfo(id);
		System.out.println("User : " + user);
		System.out.println("Payments : " + user.getPayments());
		System.out.println("Orders : " + user.getOrders());
		System.out.println("Account : " + user.getAccount());
	}

	private void updateUser(Dao dao) {
		int id = 8;
		UserInfo user = dao.getUserById(id);
		user.setName("MORAAAAA");
		dao.updateUser(user);
		System.out.println("DONE!!!");
	}

	private void deleteUserById(Dao dao) {
		int id = 5;
		dao.deleteUserById(id);
		System.out.println("DONE!!!");
	}

	private void getUserById(Dao dao) {
		int id = 1;
		UserInfo user = dao.getUserById(id);
		System.out.println("USER : " + user);
	}

	private void createUser(Dao dao) {
		UserInfo user = new UserInfo("moraa", "moraa@123.com", "12235");
		Orders order1 = new Orders(3456, "date1" , 122 , "order1");
		Orders order2 = new Orders(1256, "date2", 122 , "order2");
		user.addOrder(order1);
		user.addOrder(order2);
		dao.saveUser(user);
		System.out.println("User : " + user);
		System.out.println("Done!!!");
	}
}