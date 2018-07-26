package design.pattern.structural.decorator;

public class TextMessage implements Message {
    
    String text;

    public TextMessage(String text) {
        this.text = text;
    }
    @Override
    public String getContent() {
        // TODO Auto-generated method stub
        return this.text;
    }
    
    public void setContent(String text) {
        this.text = text;
    }

}
