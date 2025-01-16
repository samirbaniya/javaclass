package javaPractical;

class Animal {
    // Method in superclass
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Method overriding in subclass
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    // Method overriding in subclass
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Q12RunTimePolymorphism {
    public static void main(String[] args) {
        Animal animal;

        // Creating a Dog object
        animal = new Dog();
        animal.sound();  // Calls Dog's sound() method

        // Creating a Cat object
        animal = new Cat();
        animal.sound();  // Calls Cat's sound() method
    }
}

