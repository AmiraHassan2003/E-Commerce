package com.example.ECommerce.dao;

import com.example.ECommerce.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.Callable;

@Repository
public class DaoImp implements Dao{
    @Autowired
    EntityManager entityManager;

    // ###### Relation between User And Orders #######
    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class , id);
        return user;
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        User user = this.getUserById(id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserWithAllInfo(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u " +
                        "JOIN FETCH u.orders "+
                        "JOIN u.payments " +
                        "JOIN u.account " +
                        "where u.id = :data ", User.class);
        query.setParameter("data" , id);
        User user = query.getSingleResult();
        return user;
    }

    @Override
    public User getOrdersByUserId(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u " +
                        "JOIN FETCH u.orders " +
                        "where u.id = :data ", User.class);
        query.setParameter("data" , id);
        User user = query.getSingleResult();
        return user;
    }

    // ###### Relation between Category And Product #######
    @Override
    @Transactional
    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category getCategoryById(int id) {
        Category category = entityManager.find(Category.class , id);
        return category;
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        Category category = this.getCategoryById(id);
        entityManager.remove(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

    @Override
    public Category getProductByCategoryId(int id) {
        TypedQuery<Category> query = entityManager.createQuery(
                "SELECT c FROM Category c " +
                        "JOIN FETCH c.products " +
                        "WHERE c.id = :data", Category.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    // ###### Relation between Orders And Product #######
    @Override
    public Orders getProductByOrderId(int idOfOrder) {
        TypedQuery<Orders> query = entityManager.createQuery(
                "SELECT o FROM Orders o " +
                        "JOIN FETCH o.products " +
                        "WHERE o.id = :data", Orders.class);
        query.setParameter("data", idOfOrder);
        return query.getSingleResult();
    }

    @Override
    public Product getOrderByProductId(int idOfProduct) {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p " +
                        "JOIN FETCH p.orders " +
                        "WHERE p.id = :data", Product.class);
        query.setParameter("data", idOfProduct);
        return query.getSingleResult();
    }

    // ###### Relation between User And Payment #######
    @Override
    public User getPaymentByUserId(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u " +
                        "JOIN FETCH u.payments " +
                        "where u.id = :data ", User.class);
        query.setParameter("data" , id);
        User user = query.getSingleResult();
        return user;
    }

    // ###### Account #######
    @Override
    public Account getAccountById(int id) {
        Account account = entityManager.find(Account.class , id);
        return account;
    }

    @Override
    @Transactional
    public void deleteAccount(int id) {
        Account account = this.getAccountById(id);
        entityManager.remove(account);
    }

    @Override
    @Transactional
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

    // ###### Orders #######
    @Override
    public Orders getOrderById(int id) {
        Orders orders = entityManager.find(Orders.class , id);
        return orders;
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        Orders orders = this.getOrderById(id);
        entityManager.remove(orders);
    }

    @Override
    @Transactional
    public void updateOrder(Orders orders) {
        entityManager.merge(orders);
    }

    // ###### Payment #######
    @Override
    public Payment getPaymentById(int id) {
        Payment payment = entityManager.find(Payment.class , id);
        return payment;
    }

    @Override
    @Transactional
    public void deletePayment(int id) {
        Payment payment = this.getPaymentById(id);
        entityManager.remove(payment);
    }

    @Override
    @Transactional
    public void updatePayment(Payment payment) {
        entityManager.merge(payment);
    }

    // ###### Product #######
    @Override
    public Product getProductById(int id) {
        Product product = entityManager.find(Product.class , id);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        Product product = this.getProductById(id);
        entityManager.remove(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    // ###### Relation between User And Account #######
    @Override
    public User getAccountByUserId(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u " +
                        "JOIN FETCH u.account " +
                        "where u.id = :data ", User.class);
        query.setParameter("data" , id);
        User user = query.getSingleResult();
        return user;
    }

}
