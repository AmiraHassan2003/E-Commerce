package com.example.ECommerce.dao;

import com.example.ECommerce.entity.*;

import java.util.List;

public interface Dao {
    // ###### User #######
    void saveUser(UserInfo user);
    UserInfo getUserById(int id);
    void deleteUserById(int id);
    void updateUser(UserInfo user);
    UserInfo getUserWithAllInfo(int id);


    // ###### Relation between User And Orders #######
    List<Orders> getOrdersByUserId(int id);

    // ###### Category #######
    void saveCategory(Category category);
    Category getCategoryById(int id);
    void deleteCategoryById(int id);
    void updateCategory(Category category);

    // ###### Relation between Category And Product #######
    List<Product> getProductByCategoryId(int id);

    // ###### Relation between Orders And Product #######
    List<Product> getProductByOrderId(int idOfOrder);
    List<Orders> getOrderByProductId(int idOfProduct);

    // ###### Relation between User And Payment #######
    List<Payment> getPaymentByUserId(int id);

    // ###### Account #######
    Account getAccountById(int id);
    void deleteAccount(int id);
    void updateAccount(Account account);

    // ###### Cart #######
    Cart getCartById(int id);
    void deleteACart(int id);
    void updateCart(Cart cart);

    // ###### Order #######
    Orders getOrderById(int id);
    void deleteOrder(int id);
    void updateOrder(Orders orders);

    // ###### Payment #######
    Payment getPaymentById(int id);
    void deletePayment(int id);
    void updatePayment(Payment payment);

    // ###### Product #######
    Product getProductById(int id);
    void deleteProduct(int id);
    void updateProduct(Product product);

    // ###### Relation between User And Account #######
    Account getAccountByUserId(int id);

    // ###### Relation between User And Cart #######
    Cart getCartByUserId(int id);




}
