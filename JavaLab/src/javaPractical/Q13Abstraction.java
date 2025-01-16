package javaPractical;

abstract class Animal1 {
    // Abstract method (no implementation)
    abstract void sound();

    // Concrete method
    void sleep() {
        System.out.println("This animal is sleeping.");
    }
}

class Dog1 extends Animal1 {
    // Providing implementation of the abstract method
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat1 extends Animal1 {
    // Providing implementation of the abstract method
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Q13Abstraction {
    public static void main(String[] args) {
        Animal1 dog = new Dog1();
        dog.sound();  // Output: Dog barks
        dog.sleep();  // Output: This animal is sleeping.

        Animal1 cat = new Cat1();
        cat.sound();  // Output: Cat meows
        cat.sleep();  // Output: This animal is sleeping.
    }
}

