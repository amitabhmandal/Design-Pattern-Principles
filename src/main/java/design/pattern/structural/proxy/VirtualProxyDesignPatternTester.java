package design.pattern.structural.proxy;


public class VirtualProxyDesignPatternTester {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("Isoceles Triangle");
        shape.setShapeName("Triangle");
        
     //   System.out.println("Shape location :"+shape.getLocation());
        System.out.println("rendering image now.....");
        shape.render();

    }

    @Override
    public String toString() {
        return "VirtualProxyDesignPatternTester [toString()=" + super.toString() + "]";
    }

}

interface Shape {

    void setShapeName(String shapeName);
    
    String getShapeName();
    
    void render();
    
}



class Triangle implements Shape {
    
    private String triangleName;
    
    public Triangle(String triangleName) {
            //Loads image from file on disk
            System.out.println("Triangle Name:"+triangleName);
            this.triangleName = triangleName;
    }
    

    public void render() {
            //renders to screen
            System.out.println("Rendered "+this.triangleName);
    }


    public void setShapeName(String shapeName) {
        this.triangleName = shapeName;
        
    }


    public String getShapeName() {
        // TODO Auto-generated method stub
        return this.triangleName;
    }


    @Override
    public String toString() {
        return "Triangle [triangleName=" + triangleName + "]";
    }
    
    
}

class ShapeFactory {
    //We'll provide proxy to caller instead of real object
    
    public static Shape getShape(String name) {
            return new ShapeProxy(name);
    }
}


class ShapeProxy implements Shape {

    private String name;
    
    private Triangle triangle;
    

    public ShapeProxy(String name) {
            System.out.println("Shape Proxy Constructor called");
            this.name = name;
    }
    
    public void setShapeName(String shapeName) {
          System.out.println("ShapeProxy Set Name called");
          this.name = shapeName;
    }


    public void render() {
        System.out.println("Shape Proxy rendering called");
        triangle.toString();
        triangle.render();
            
    }

    public String getShapeName() {
        return this.name;
    }
            
}

