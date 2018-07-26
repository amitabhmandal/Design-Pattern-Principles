package design.pattern.creational.factory.method;

public class FactoryMethodTester {

    public static void main(String[] args) {
        printMessage(new JsonMessageCreator());
        printMessage(new TextMessageCreator());
        

    }

    public static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println(msg.getContent());
        
    }
}

/*
 * This is our abstract Creator.
 * 
 * The abstract method createMessage() has to be immplemented by it's subclass
 * 
 * 
 */

abstract class MessageCreator {

    public Message getMessage() {
        Message msg = createMessage();

        // Then it can be followed by some default behavior

        msg.addDefaultHeaders();
        msg.encrypt();

        return msg;

    }

    // Factory method
    public abstract Message createMessage();

}

class JsonMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JsonMessage();
    }

}

class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }

}

/*
 * This class represents interface for our product which is a message implementation
 * will be specific to content type
 * 
 */
abstract class Message {

    public Message() {
        System.out.println("Message class constructor initialized");
    }

    public abstract String getContent();

    public void addDefaultHeaders() {

        System.out.println("Default Headers provided");

    }

    public void encrypt() {
        System.out.println("Encryption provided");

    }
}

class JsonMessage extends Message {

    public JsonMessage() {
        super();
        System.out.println("JsonMessage Object created");
    }

    @Override
    public String getContent() {
        // TODO Auto-generated method stub
        return "{\"Json]\":[]}";
    }

}

class TextMessage extends Message {

    public TextMessage() {
        super();
        System.out.println("TextMessage Object created");
    }

    @Override
    public String getContent() {
        return "Text";
    }

}
