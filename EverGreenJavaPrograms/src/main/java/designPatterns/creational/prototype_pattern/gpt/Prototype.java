package designPatterns.creational.prototype_pattern.gpt;

import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface PrototypeMain {
    PrototypeMain clone();
    String getName();
}

// Concrete prototype 1
class ConcretePrototype1 implements PrototypeMain {
    private String name;
    
    public ConcretePrototype1(String name) {
        this.name = name;
    }
    
    @Override
    public PrototypeMain clone() {
        return new ConcretePrototype1(name);
    }
    
    @Override
    public String getName() {
        return name;
    }
}

// Concrete prototype 2
class ConcretePrototype2 implements PrototypeMain {
    private String name;
    
    public ConcretePrototype2(String name) {
        this.name = name;
    }
    
    @Override
    public PrototypeMain clone() {
        return new ConcretePrototype2(name);
    }
    
    @Override
    public String getName() {
        return name;
    }
}

// Prototype registry
class PrototypeRegistry {
    private Map<String, PrototypeMain> prototypes = new HashMap<>();
    
    public PrototypeRegistry() {
        prototypes.put("ConcretePrototype1", new ConcretePrototype1("ConcretePrototype1"));
        prototypes.put("ConcretePrototype2", new ConcretePrototype2("ConcretePrototype2"));
    }
    
    public PrototypeMain createPrototype(String type) {
        return prototypes.get(type).clone();
    }
}

// Client code
public class Prototype {
    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();
        
        PrototypeMain prototype1 = registry.createPrototype("ConcretePrototype1");
        System.out.println("Prototype 1 Name: " + prototype1.getName());
        
        PrototypeMain prototype2 = registry.createPrototype("ConcretePrototype2");
        System.out.println("Prototype 2 Name: " + prototype2.getName());
    }
}