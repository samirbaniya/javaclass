package q10multipleInheritance;

interface Animal {
    void sound();
}

interface Pet {
    void play();
}

class Dog implements Animal, Pet {
    public void sound() {
        System.out.println("Dog barks");
    }

    public void play() {
        System.out.println("Dog plays");
    }
}

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();  // Implemented from Animal interface
        dog.play();   // Implemented from Pet interface
    }
}

