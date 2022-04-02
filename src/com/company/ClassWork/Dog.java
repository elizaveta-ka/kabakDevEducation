package com.company.ClassWork;

public class Dog extends Animal{
    private String breed;

    public Dog(String name, int age, int weight, String breed) {
        super(name, age, weight);
        super.sayHello();
        this.breed = breed;
    }
    public String getBreed() {
        return this.breed = breed;
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }
}
