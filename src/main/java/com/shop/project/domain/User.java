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

    @Max(30)
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
    private Set<Role> roles;

    @JsonManagedReference(value="user_order")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderP> orders;
}
