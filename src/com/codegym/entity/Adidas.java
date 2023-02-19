package com.codegym.entity;

public class Adidas implements Shoe {
    private String id;
    private String name;
    private double size;
    private String color;
    private int price;
    private int quantity;

    public Adidas() {
    }

    public Adidas(AdidasBuilder builder) {
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
        return "Nike{" +
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

    public static class AdidasBuilder{
        private String id;
        private String name;
        private double size;
        private String color;
        private int price;
        private int quantity;

        public AdidasBuilder() {
        }

        public AdidasBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AdidasBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AdidasBuilder size(double size) {
            this.size = size;
            return this;
        }

        public AdidasBuilder color(String color) {
            this.color = color;
            return this;
        }

        public AdidasBuilder price(int price) {
            this.price = price;
            return this;
        }

        public AdidasBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Adidas build() {
            return new Adidas(this);
        }
    }


}
