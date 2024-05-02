package com.example.ECommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//@Data
@Entity
@Table(name = "userInfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user" ,
                fetch = FetchType.LAZY ,
              cascade= CascadeType.ALL
    )
    private List<Orders> orders;

    @OneToMany(mappedBy = "user",
            fetch = FetchType.EAGER ,
            cascade = {
                    CascadeType.DETACH , CascadeType.MERGE,
                    CascadeType.PERSIST , CascadeType.REFRESH
            })
    private List<Payment> payments;

    @OneToOne(mappedBy = "user" , cascade =
            {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    private Account account;

    @OneToOne(mappedBy = "user" , cascade =
            {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    private Cart cart;

    public UserInfo(){

    }

    public UserInfo(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void addOrder(Orders orders){
        if(this.orders == null){
            this.orders = new ArrayList<>();
        }
        this.orders.add(orders);
        orders.setUser(this);
    }

    public void addPayment(Payment payment){
        if(this.payments == null){
            this.payments = new ArrayList<>();
        }
        this.payments.add(payment);
        payment.setUser(this);
    }


}
