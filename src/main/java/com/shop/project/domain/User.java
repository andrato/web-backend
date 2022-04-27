package com.shop.project.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="USERS")
@Setter
@Getter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        id;

    @NotNull(message = "FirstName is mandatory")
    @Max(50)
    private String      firstName;

    @NotNull(message = "LastName is mandatory")
    @Max(50)
    private String      lastName;

    @NotNull(message = "Email is mandatory")
    @Email
    @Max(50)
    @Column(unique = true)
    private String      email;

    private String      username;

    @NotNull(message = "Password is mandatory")
    @Min(8)
    @Max(50)
    private String      password;

    @Min(4)
    private Long        phoneNumber;

    @Max(100)
    private String      address;

    @Max(50)
    private String      city;;

    @Max(50)
    private String      country;

    private LocalDate   birth_date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @JsonManagedReference(value="user_order")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<OrderP> orders = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String city, String country, LocalDate birth_date, String address, Long phone_number) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.country = country;
        this.birth_date = birth_date;
        this.phoneNumber = phone_number;
    }

    public User(String username, String email, String password, String city, String country, LocalDate birth_date) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
        this.birth_date = birth_date;
    }
}
