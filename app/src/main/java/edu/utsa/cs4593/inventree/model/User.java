package edu.utsa.cs4593.inventree.model;

public class User {

    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private String username;
    private String password;

    public User(String role, String firstName, String lastName, String email, String phoneNum, String username, String password){
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
