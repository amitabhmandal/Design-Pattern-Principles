package design.pattern.structural.decorator;

import org.apache.commons.text.StringEscapeUtils;

public class HtmlEncodedMessage implements Message{
    
    //Decorator also needs an object of the actual concrete component
    
    private Message message;
    
    public HtmlEncodedMessage(Message message) {
        this.message = message;
    }
    

    @Override
    public String getContent() {
        // TODO Auto-generated method stub
        return StringEscapeUtils.escapeHtml4(message.getContent());
    }

}
