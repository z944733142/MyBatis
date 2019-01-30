package com.pojo;

public class Flower {
    private int id;
    private String name;
    private String address;

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Flower(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Flower() {
    }
}
