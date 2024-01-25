package protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtobufDemo {

    public static void main(String[] args) {
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder().setName("Vaibhav").setId(123).setEmail("vj@vj.com").build();

        // Serialize object to byte array
        byte[] serializedData = person.toByteArray();

        // DeSerialize the byte array back to Person object
        try {
            PersonOuterClass.Person deserializedPerson = PersonOuterClass.Person.parseFrom(serializedData);
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Id: " + deserializedPerson.getId());
            System.out.println("Email: " + deserializedPerson.getEmail());
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }
}