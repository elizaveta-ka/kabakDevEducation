package com.company.ClassWork;

public class Animal {
    private String name;
    private int age;
    private int weight;
    private int legsNumber;

    public void sayHello () {
        System.out.println("Hi, I'm animal. My name is " + this.name + " I'm " + this.age + " old. " + "My weight is " + this.weight);
    }
    public Animal(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public Animal(int legsNumber) {
        this.legsNumber = legsNumber;
    }
    public String getName () {
        return this.name;
    }
    public int getAge () {
        return this.age;
    }
    public int getWeight() {
        return this.weight;
    }
    public void setWeight (int weight) {
        this.weight = weight;
    }
    public void increaseAge( int age) {
        age++;
    }
}
