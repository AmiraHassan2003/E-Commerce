package com.example.ECommerce.dao;

import com.example.ECommerce.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImp implements Dao{
    @Autowired
    EntityManager entityManager;

    // ###### Relation between User And Orders #######
    @Override
    @Transactional
    public void saveUser(UserInfo user) {
        entityManager.persist(user);
    }

    @Override
    public UserInfo getUserById(int id) {
        UserInfo user = null;
        try{
            user = entityManager.find(UserInfo.class , id);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
            return user;
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        try{
            UserInfo user = this.getUserById(id);
            entityManager.remove(user);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
    }

    @Override
    @Transactional
    public void updateUser(UserInfo user) {
        entityManager.merge(user);
    }

    @Override
    public UserInfo getUserWithAllInfo(int id) {
        UserInfo user = null;
        try {
            TypedQuery<UserInfo> query = entityManager.createQuery(
                    "select u from UserInfo u " +
                            "JOIN FETCH u.orders "+
                            "JOIN u.payments " +
                            "JOIN u.account " +
                            "where u.id = :data ", UserInfo.class);
            query.setParameter("data" , id);
            user = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
        return user;
    }

    @Override
    public List<Orders> getOrdersByUserId(int id) {
        List<Orders> orders = null;
        try{
            TypedQuery<UserInfo> query = entityManager.createQuery(
                    "select u from UserInfo u " +
                            "JOIN FETCH u.orders " +
                            "where u.id = :data ", UserInfo.class);
            query.setParameter("data" , id);
            orders = query.getSingleResult().getOrders();
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
        return orders;
    }

    // ###### Relation between Category And Product #######
    @Override
    @Transactional
    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category getCategoryById(int id) {
        Category category = null;
        try{
            category = entityManager.find(Category.class , id);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
            return category;
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        try{
            Category category = this.getCategoryById(id);
            entityManager.remove(category);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

    @Override
    public List<Product> getProductByCategoryId(int id) {
        List<Product> products = null;
        try{
            TypedQuery<Category> query = entityManager.createQuery(
                    "SELECT c FROM Category c " +
                            "JOIN FETCH c.products " +
                            "WHERE c.id = :data", Category.class);
            query.setParameter("data", id);
            products = query.getSingleResult().getProducts();
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
        return products;
    }

    // ###### Relation between Orders And Product #######
    @Override
    public List<Product> getProductByOrderId(int idOfOrder) {
        List<Product> products = null;
        try{
            TypedQuery<Orders> query = entityManager.createQuery(
                    "SELECT o FROM Orders o " +
                            "JOIN FETCH o.products " +
                            "WHERE o.id = :data", Orders.class);
            query.setParameter("data", idOfOrder);
            products = query.getSingleResult().getProducts();
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
            return products;
    }

    @Override
    public List<Orders> getOrderByProductId(int idOfProduct) {
        List<Orders> orders = null;
        try{
            TypedQuery<Product> query = entityManager.createQuery(
                    "SELECT p FROM Product p " +
                            "JOIN FETCH p.orders " +
                            "WHERE p.id = :data", Product.class);
            query.setParameter("data", idOfProduct);
            orders = query.getSingleResult().getOrders();
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
        return orders;
    }

    // ###### Relation between User And Payment #######
    @Override
    public List<Payment> getPaymentByUserId(int id) {
        UserInfo user = null;
        try{
            TypedQuery<UserInfo> query = entityManager.createQuery(
                    "select u from UserInfo u " +
                            "JOIN FETCH u.payments " +
                            "where u.id = :data ", UserInfo.class);
            query.setParameter("data" , id);
            user = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
        return user.getPayments();
    }

    // ###### Account #######
    @Override
    public Account getAccountById(int id) {
        Account account = null;
        try{
            account = entityManager.find(Account.class , id);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
            return account;
    }

    @Override
    @Transactional
    public void deleteAccount(int id) {
        try{
            Account account = this.getAccountById(id);
            entityManager.remove(account);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
    }

    @Override
    @Transactional
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

    // ###### Cart #######
    @Override
    public Cart getCartById(int id) {
        Cart cart = null;
        try{
            cart = entityManager.find(Cart.class , id);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
            return cart;
    }

    @Override
    @Transactional
    public void deleteACart(int id) {
        try{
            Cart cart = this.getCartById(id);
            entityManager.remove(cart);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
    }

    @Override
    @Transactional
    public void updateCart(Cart cart) {
        entityManager.merge(cart);
    }

    // ###### Orders #######
    @Override
    public Orders getOrderById(int id) {
        Orders orders = null;
        try{
            orders = entityManager.find(Orders.class , id);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
        return orders;
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        try{
            Orders orders = this.getOrderById(id);
            entityManager.remove(orders);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
    }

    @Override
    @Transactional
    public void updateOrder(Orders orders) {
        entityManager.merge(orders);
    }

    // ###### Payment #######
    @Override
    public Payment getPaymentById(int id) {
        Payment payment = null;
        try{
            payment = entityManager.find(Payment.class , id);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
            return payment;
    }

    @Override
    @Transactional
    public void deletePayment(int id) {
        try{
        Payment payment = this.getPaymentById(id);
        entityManager.remove(payment);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
    }

    @Override
    @Transactional
    public void updatePayment(Payment payment) {
        entityManager.merge(payment);
    }

    // ###### Product #######
    @Override
    public Product getProductById(int id) {
        Product product = null;
        try{
            product = entityManager.find(Product.class , id);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
            return product;
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        Product product = null;
        try {
            product = this.getProductById(id);
            entityManager.remove(product);
        } catch (Exception e) {
            System.out.println("The Id Is invalid :(");
        }
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    // ###### Relation between User And Account #######
    @Override
    public Account getAccountByUserId(int id) {
        UserInfo user = null;
        try{
            TypedQuery<UserInfo> query = entityManager.createQuery(
                    "select u from UserInfo u " +
                            "JOIN FETCH u.account " +
                            "where u.id = :data ", UserInfo.class);
            query.setParameter("data" , id);
            user = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("The User Is not exist :(");
        }
        return user.getAccount();
    }

    // ###### Relation between User And Cart #######
    @Override
    public Cart getCartByUserId(int id) {
        UserInfo user = null;
        try{
            TypedQuery<UserInfo> query = entityManager.createQuery(
                    "select u from UserInfo u " +
                            "JOIN FETCH u.cart " +
                            "where u.id = :data ", UserInfo.class);
            query.setParameter("data" , id);
            user = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("The User Is not exist :(");
        }
            return user.getCart();
    }

}
