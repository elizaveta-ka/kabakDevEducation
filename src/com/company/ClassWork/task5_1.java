package com.company.ClassWork;

public class task5_1 {
    public static void main(String[] args) {
    Animal afrodita = new Animal("Afrodita",1, 10);
    Animal hermes = new Animal("Hermes",10,100);
    afrodita.sayHello();
    hermes.sayHello();
        System.out.println(afrodita.getName());
        System.out.println(hermes.getName());
        afrodita.setWeight(20);
        System.out.println(afrodita.getWeight());

        Dog pesik = new Dog("Lena", 10,30,"Shpiz");
        System.out.println(pesik.getBreed());
        pesik.sayHello();
    }
}
