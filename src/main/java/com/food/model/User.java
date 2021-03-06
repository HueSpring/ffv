package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String id;
    @JsonIgnore
    private String pwd;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private boolean active;
    private String dateCreated;
    @JsonIgnore
    private String keyCode;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Salary> salaries;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<ImportIngredient> importIngredients;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Book> books;

    @OneToMany(mappedBy = "user1")
    @JsonIgnore
    private Set<ImportStoreIngredient> importStoreIngredients1;

    @OneToMany(mappedBy = "user2")
    @JsonIgnore
    private Set<ImportStoreIngredient> importStoreIngredients2;

    public User() {
    }

    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
    }


    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode, Role role, Store store) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
        this.role = role;
        this.store = store;
    }

    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode, Role role, Store store, Set<Salary> salaries) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
        this.role = role;
        this.store = store;
        this.salaries = salaries;
    }


    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode, Role role, Store store, Set<Salary> salaries, Set<ImportIngredient> importIngredients, Set<Book> books) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
        this.role = role;
        this.store = store;
        this.salaries = salaries;
        this.importIngredients = importIngredients;
        this.books = books;
    }

    public Set<ImportStoreIngredient> getImportStoreIngredients1() {
        return importStoreIngredients1;
    }

    public void setImportStoreIngredients1(Set<ImportStoreIngredient> importStoreIngredients1) {
        this.importStoreIngredients1 = importStoreIngredients1;
    }

    public Set<ImportStoreIngredient> getImportStoreIngredients2() {
        return importStoreIngredients2;
    }

    public void setImportStoreIngredients2(Set<ImportStoreIngredient> importStoreIngredients2) {
        this.importStoreIngredients2 = importStoreIngredients2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public Set<ImportIngredient> getImportIngredients() {
        return importIngredients;
    }

    public void setImportIngredients(Set<ImportIngredient> importIngredients) {
        this.importIngredients = importIngredients;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

