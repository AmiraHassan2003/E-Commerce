package com.example.ECommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "username")
    private String username;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH , CascadeType.MERGE,
                    CascadeType.PERSIST , CascadeType.REFRESH
            })
    @JoinColumn(name = "user_id")
    private User user;

    public Account(){

    }

    public Account(String image, String username) {
        this.image = image;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
