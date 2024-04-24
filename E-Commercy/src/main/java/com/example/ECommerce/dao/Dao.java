package com.example.ECommerce.dao;

import com.example.ECommerce.entity.*;

import java.util.List;

public interface Dao {
    // ###### User #######
    void saveUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);
    void updateUser(User user);
    User getUserWithAllInfo(int id);


    // ###### Relation between User And Orders #######
    User getOrdersByUserId(int id);

    // ###### Category #######
    void saveCategory(Category category);
    Category getCategoryById(int id);
    void deleteCategoryById(int id);
    void updateCategory(Category category);

    // ###### Relation between Category And Product #######
    Category getProductByCategoryId(int id);

    // ###### Relation between Orders And Product #######
    Orders getProductByOrderId(int idOfOrder);
    Product getOrderByProductId(int idOfProduct);

    // ###### Relation between User And Payment #######
    User getPaymentByUserId(int id);

    // ###### Account #######
    Account getAccountById(int id);
    void deleteAccount(int id);
    void updateAccount(Account account);

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
    User getAccountByUserId(int id);




}
