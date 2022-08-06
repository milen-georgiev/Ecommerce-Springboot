package com.ecommerce.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "admins")
public class Admin extends BaseEntity{

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "admins_roles",  joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private Collection<Role> roles;
}
