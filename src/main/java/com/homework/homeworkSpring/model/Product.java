package com.homework.homeworkSpring.model;

public class Product {
    private double price;
    private long id;
    private String name;

    public Product(double price, long id, String name) {
        this.price = price;
        this.id = id;
        this.name = name;
    }

    public Product(){}

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
