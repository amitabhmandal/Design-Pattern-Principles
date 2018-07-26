package design.pattern.creational.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuiderDesignPattern {

    public static void main(String[] args) throws ParseException {
        User user = createUser();
        UserDTOBuilder builder = new UserWebDTOBuilder();
        UserDTO dto = directBuild(builder, user);
        System.out.println(dto);

    }

    
    //Instead of building a director entity we are continuing with a static private 
    //method which will call the builder implementation
    private static UserDTO directBuild(UserDTOBuilder builder, User user) {

        // This is what is called as method chaining which only happens when we return the reference
        // type of the interface from the method.
        // That is why the builder methods was supposed to return the reference type.
        // This is called method chaining.
        return builder.withFirstName(user.getFirstName())
            .withLastName(user.getLastName())
            .withBirthday(user.getBirthday())
            .withAddress(user.getAddress())
            .build();
    }

    public static User createUser() throws ParseException {
        User user = new User();
        user.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2018"));
        user.setFirstName("Ron");
        user.setLastName("Swanson");
        Address address = new Address();
        address.setHouseNumber("100");
        address.setStreet("State Street");
        address.setCity("Pawnee");
        address.setState("Indiana");
        address.setZipCode("47998");
        user.setAddress(address);
        return user;
    }

}

class User {
    private String firstName;
    private String lastName;
    private Date birthday;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

class Address {

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String houseNumber;
    private String street;
    private String city;
    private String zipCode;
    private String state;

}

interface UserDTO {

    String getName();

    String getAddress();

    String getAge();
}

// Product class for our builder design Pattern
class UserWebDTO implements UserDTO {

    private String name;

    private String address;

    private String age;

    public UserWebDTO(String name, String address, String age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name=" + name + "\nage=" + age + "\naddress=" + address;
    }

}

// abstract builder
// Here the methods are returning the reference itself. This allows us to method chaining.
interface UserDTOBuilder {
    // methods to build "parts" of product at a time
    UserDTOBuilder withFirstName(String fname);

    UserDTOBuilder withLastName(String lname);

    UserDTOBuilder withBirthday(Date date);

    UserDTOBuilder withAddress(Address address);

    // method to "assemble" final product
    UserDTO build();

    // (optional) method to fetch already built object
    UserDTO getUserDTO();
}

// Concrete Builder.
class UserWebDTOBuilder implements UserDTOBuilder {
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserWebDTO dto;

    public UserDTOBuilder withFirstName(String fname) {
        firstName = fname;
        return this;
    }

    public UserDTOBuilder withLastName(String lname) {
        lastName = lname;
        return this;
    }

    public UserDTOBuilder withBirthday(Date date) {
        age = "23";
        return this;
    }

    public UserDTOBuilder withAddress(Address address) {
        this.address = address.getHouseNumber() + ", " + address.getStreet() + ", " + address.getCity() + address.getState() + address.getZipCode();
        return this;
    }

    public UserDTO build() {
        dto = new UserWebDTO(firstName + " " + lastName, address, age);
        return dto;
    }

    public UserDTO getUserDTO() {
        // TODO Auto-generated method stub
        return dto;
    }

}