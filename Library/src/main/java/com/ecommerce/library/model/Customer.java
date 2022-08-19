package com.ecommerce.library.model;

import java.util.Collection;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String country;
    private String phoneNumber;
    private String address;
    private String image;
    private Collection<Role> roles;
}
