package design.pattern.creational.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import design.pattern.creational.builder.ProductUserDTO.ProductUserDTOBuilder;

public class BuilderDesignPatternImmutableWithoutConstructor {

    public static void main(String[] args) throws ParseException {
        User user = createUser();
        ProductUserDTO productUserDTO = directBuild(ProductUserDTO.getBuilder() , user);
        System.out.println(productUserDTO);

    }

    private static ProductUserDTO directBuild(ProductUserDTOBuilder productUserDTOBuilder, User user) {

        return productUserDTOBuilder.withFirstName(user.getFirstName())
            .withLastName(user.getLastName())
            .withBirthdat("23")
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

// This is the product class
// It does not have any constructor
// To make it immutable we have made the setters private of the class.

class ProductUserDTO {

    private String name;

    private String address;

    private String age;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ProductUserDTO [name=" + name + ", address=" + address + ", age=" + age + "]";
    }

    // Get Builder Instance
    public static ProductUserDTOBuilder getBuilder() {
        return new ProductUserDTOBuilder();
    }

    // we are going to create static inner class without our ProductUserDTO.
    // This will serve the following purpose
    // It serves as good encapsulation.
    // Secondly the static builder class can access the private methods of the DTO class.
    public static class ProductUserDTOBuilder {
        private String firstName;
        private String lastName;
        private String age;
        private String address;

        private ProductUserDTO productUserDTO;

        public ProductUserDTOBuilder withFirstName(String fname) {
            this.firstName = fname;
            return this;
        }

        public ProductUserDTOBuilder withLastName(String lname) {
            this.lastName = lname;
            return this;
        }

        public ProductUserDTOBuilder withBirthdat(String day) {
            this.age = day;
            return this;
        }

        public ProductUserDTOBuilder withAddress(Address address) {
            this.address = address.getHouseNumber() + address.getStreet() + address.getState() + address.getCity() + address.getZipCode();
            return this;
        }

        public ProductUserDTO build() {
            ProductUserDTO productUserDTO = new ProductUserDTO();
            productUserDTO.setName(firstName + lastName);
            productUserDTO.setAge(age);
            productUserDTO.setAddress(address);

            return productUserDTO;

        }

        public ProductUserDTO getUserDTO() {
            return productUserDTO;
        }

    }

}
