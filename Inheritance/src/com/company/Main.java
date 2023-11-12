package com.company;

public class Main {

    public static void main(String[] args) {
    animal animal = new animal("unkown",1,1,5,5);
    dog dog =new dog("PUB",1,45,2,4,24,1);
    dog.eat();
        System.out.println(dog.getBody()+ dog.getName());
    }
}
