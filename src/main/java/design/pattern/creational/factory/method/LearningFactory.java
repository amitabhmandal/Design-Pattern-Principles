package design.pattern.creational.factory.method;

public class LearningFactory {

    public static void main(String[] args) {
       Shape circleShape = new CircleFactory().getShape();
       circleShape.draw();

       Shape rectangeShape = new RectangleFactory().getShape();
       rectangeShape.draw();       

       
       Shape squareShape = new SquareFactory().getShape();
       squareShape.draw();  
    }

}

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside rectangle :: draw method :");

    }

}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside square :: draw method :");

    }

}


class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside circle :: draw method :");

    }

}

abstract class  AbstractShapeFactory {
    
    protected abstract Shape factoryMethod();
    
    public Shape getShape() {
        return factoryMethod();
    }
    
    //other default helper methods
    
}

class RectangleFactory extends AbstractShapeFactory {

    @Override
    protected Shape factoryMethod() {
        return new Rectangle();
    }
    
}

class SquareFactory extends AbstractShapeFactory {

    @Override
    protected Shape factoryMethod() {
        return new Square();
    }
    
}

class CircleFactory extends AbstractShapeFactory {

    @Override
    protected Shape factoryMethod() {
        return new Circle();
    }
    
}