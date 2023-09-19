package com.baitap.model;


import java.io.Serializable;

/**
 * @author Phuong Oanh
 */
public class Person implements Serializable {
    private static int nextId = 1;
    private int id;
    private String name;
    private String birthDate;
    private String address;
    private float height;
    private float weight;

    public Person() {
    }

    public Person(String name, String birthDate, String address, float height, float weight) {
        this.id = nextId++;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Person.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
