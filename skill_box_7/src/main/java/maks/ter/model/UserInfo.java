package maks.ter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_nfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "date_create")
    private Date dateCreate;
}
