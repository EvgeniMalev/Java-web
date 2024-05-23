package com.example.animal;

public class Bird implements Animal {
    private String name;
    private int age;

    public Bird(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
