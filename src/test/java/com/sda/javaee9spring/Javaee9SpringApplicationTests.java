package com.sda.javaee9spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Javaee9SpringApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dependencyInjectionFirstTrial() {
        Toy childToy = new Toy("Hoover");
        Child john = new Child("John", childToy);
        // dependency injection is providing all required class dependencies
        // childToy (of type Toy) is d ependency of john (of type Child)
        // during creation of objects of that class
        // john (of type Child) is dependency of jason (of type Parent)
        // dependency is actually composition, so one item is made of another
        Parent jason = new Parent("Jason", john);
    }

}
/** Composition **/
// Toy is composed of name
record Toy(String name) {}
// Child is composed of: name and toy
record Child(String name, Toy favouriteToy) { }
// Parent is made of (composed of): name and child
record Parent(String name, Child child) { }

/** Inheritance **/
class Animal {}
class Mammal extends Animal {}
class Tiger extends Mammal {}
// Tiger is Mammal
// Tiger is Animal
// We cannot say: Parent is Child(Parent don't extend Child)