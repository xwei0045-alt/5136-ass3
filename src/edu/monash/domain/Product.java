package edu.monash.domain;
public class Product { public String id,name; public String category; public double price, memberPrice; public int stock;
  public Product(String id,String name,String category,double price,double memberPrice,int stock){
    this.id=id; this.name=name; this.category=category; this.price=price; this.memberPrice=memberPrice; this.stock=stock;
  } }
