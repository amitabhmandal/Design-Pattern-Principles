package design.pattern.structural.decorator;

public class ClientTester {

    public static void main(String[] args) {

        Message message = new TextMessage("This <Force> is strong with this one");
        System.out.println(message.getContent());
        
        Message decorator = new HtmlEncodedMessage(message);
        System.out.println(decorator.getContent());
        
        Message base64Decorator = new Base64EncodedMessage(message);
        System.out.println(base64Decorator.getContent());
    }

}
