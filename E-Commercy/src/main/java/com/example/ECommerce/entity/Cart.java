package com.example.ECommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH , CascadeType.MERGE,
                    CascadeType.PERSIST , CascadeType.REFRESH
            })
    @JoinColumn(name = "user_id")
    private UserInfo user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
