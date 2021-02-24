package com.transaction.model.trasnaction.model;

import com.transaction.model.trasnaction.model.enums.UserStatus;
import com.transaction.model.trasnaction.model.enums.UserType;
import com.transaction.model.trasnaction.model.enums.converter.UserStatusConverter;
import com.transaction.model.trasnaction.model.enums.converter.UserTypeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Convert(converter = UserTypeConverter.class)
    @Column(name = "user_type_id")
    private UserType userType;

    @Convert(converter = UserStatusConverter.class)
    @Column(name = "user_status_id")
    private UserStatus userStatus;

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Account> accounts;


    public  User (){

    }

    public User(String name, String surname, String username, String password, UserType userType, UserStatus userStatus, Set<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.userStatus = userStatus;
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
