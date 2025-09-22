package edu.monash.domain;

/** A2: Abstract user. */
public abstract class User {
    protected String email;
    protected String role; // CUSTOMER / ADMIN

    protected User(String email, String role){
        this.email = email;
        this.role = role;
    }
    public String getEmail(){ return email; }
    public String getRole(){ return role; }
}
