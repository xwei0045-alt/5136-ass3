package edu.monash.domain;

/** Money balance associated with a customer account. */
public class Balance {
    private String email;
    private double amount;

    public Balance(String email, double amount){
        this.email=email; this.amount=amount;
    }
    public String getEmail(){ return email; }
    public double getAmount(){ return amount; }
    public void setAmount(double a){ this.amount=a; }
}
