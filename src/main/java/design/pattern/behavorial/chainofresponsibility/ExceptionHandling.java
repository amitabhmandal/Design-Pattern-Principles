package design.pattern.behavorial.chainofresponsibility;

public class ExceptionHandling {

    public static void main(String[] args) throws Exception{
        firstMethod();

    }
    
    public static void firstMethod() throws Exception {
        secondMethod();
        
    }
    
    public static void secondMethod() throws Exception{
        secondMethod();
        
    }
    
    public static void thirdMethod() throws Exception{
        
        throw new ArithmeticException();
        
    }

}
