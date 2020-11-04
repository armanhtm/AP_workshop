/**
 * @author Arman Hatami
 * @version 1.0
 * shape abstract class to save common methods
 */
abstract class Shape {

    /**
     * calculate the Perimeter of this shape
     * @return Perimeter
     */
    public abstract double calculatePerimeter();
    /**
     * calculate the Area of this shape
     * @return Area
     */
    public abstract double calculateArea();

    /**
     * draw method shows type , Perimeter and Area of this shape
     */
    public void draw(){
        System.out.println("Perimeter : " + this.calculatePerimeter() + "\nArea : "
                + this.calculateArea() + "\n_____________");
    }

    /**
     * overriding equal method of object class to compare shapes
     * @param obj we want to compare
     * @return boolean result of comparison
     */
    public abstract boolean equals(Object obj);
    /**
     * overriding to string method of object class
     * to return some information about the shape as a String
     * @return String of info
     */
    public abstract String toString();
}
