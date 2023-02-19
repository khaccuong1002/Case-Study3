package com.codegym.entity;

public interface Shoe {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

     double getSize();

    void setSize(double size) ;

    String getColor();

    void setColor(String color);

    int getPrice();

    void setPrice(int price);

    int getQuantity();

    void setQuantity(int quantity) ;

    String toFile();
}
