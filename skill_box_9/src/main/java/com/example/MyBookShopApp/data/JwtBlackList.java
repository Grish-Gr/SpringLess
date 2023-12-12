package com.example.MyBookShopApp.data;


import javax.persistence.*;

@Entity
@Table(name = "jwt_blacklist")
public class JwtBlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "token")
    private String token;

    public JwtBlackList(String token) {
        this.token = token;
    }

    public JwtBlackList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
