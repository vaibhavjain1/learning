package designPatterns.builder_pattern.gpt;

class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final String phoneNumber;
    
    private Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }
    
    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private String phoneNumber;
        
        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        
        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        
        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        
        public PersonBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        public Person build() {
            return new Person(this);
        }
    }
    
    // getters
}

public class Builder{
	public static void main(String[] args) {
		Person person = new Person.PersonBuilder("John", "Doe")
                .setAge(30)
                .setAddress("123 Main St")
                .setPhoneNumber("555-1234")
                .build();
	}
}
