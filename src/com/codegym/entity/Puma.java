package com.codegym.entity;

import java.util.Locale;

public class Puma implements Shoe {
    private String id;
    private String name;
    private double size;
    private String color;
    private int price;
    private int quantity;

    public Puma() {
    }

    public Puma(PumaBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.size = builder.size;
        this.color = builder.color;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Puma{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public String toFile() {
        return id + "," + name + "," + size + "," + color + "," + price + "," + quantity ;
    }

    public static class PumaBuilder {
        private String id;
        private String name;
        private double size;
        private String color;
        private int price;
        private int quantity;

        public PumaBuilder() {
        }

        public PumaBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PumaBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PumaBuilder size(double size) {
            this.size = size;
            return this;
        }

        public PumaBuilder color(String color) {
            this.color = color;
            return this;
        }

        public PumaBuilder price(int price) {
            this.price = price;
            return this;
        }

        public PumaBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Puma build() {
            return new Puma(this);
        }
    }

}
