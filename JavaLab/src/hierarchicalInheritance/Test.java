package hierarchicalInheritance;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat meows");
    }
}

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();  // Inherited from Animal
        dog.bark();   // Method of Dog class

        Cat cat = new Cat();
        cat.sound();  // Inherited from Animal
        cat.meow();   // Method of Cat class
    }
}
