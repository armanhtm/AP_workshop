import java.rmi.ConnectIOException;
/**
 * @author Arman Hatami
 * @version 1.0
 * circle shape
 */
public class Circle {
    private double radius;

    /**
     * constructor method
     * @param radius
     */
    public Circle(double radius){
        this.radius = radius;
    }

    /**
     * getting radius
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * calculate the Perimeter of this shape
     * @return Perimeter
     */
    public double calculatePerimeter(){
        return Math.PI * radius * 2;
    }
    /**
     * calculate the Area of this shape
     * @return Area
     */
    public double calculateArea(){
        return Math.PI * radius * radius;
    }

    /**
     * draw method shows type , Perimeter and Area of this shape
     */
    public void draw(){
        System.out.println("type : circle\nPerimeter : "
                + this.calculatePerimeter() + "\nArea : "
                + this.calculateArea() + "\n_____________");
    }

    /**
     * overriding equal method of object class to compare shapes
     * @param obj we want to compare
     * @return boolean result of comparison
     */
    public boolean equals(Object obj) {
        if(this  == obj)
            return true;
        if(!(obj instanceof Circle))
            return false;
        Circle temp = (Circle)obj;
        return temp.radius == radius;
    }
    /**
     * overriding to string method of object class
     * to return some information about the shape as a String
     * @return String of info
     */
    public String toString() {
        return "circle : " + radius;
    }
}
