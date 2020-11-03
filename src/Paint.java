import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * paint class to store all of shapes and show them
 */
public class Paint {
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    /**
     * constructor method
     */
    public Paint(){
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * add a circle to circle list
     * @param circle
     */
    public void addCircle(Circle circle){
        circles.add(circle);
    }

    /**
     * add a triangle to triangle list
     * @param triangle
     */
    public void addTriangle(Triangle triangle){
        triangles.add(triangle);
    }

    /**
     * add a rectangle to rectangle list
     * @param rectangle
     */
    public void addRectangle(Rectangle rectangle){
        rectangles.add(rectangle);
    }

    /**
     * print all shapes in paint class
     */
    public void printAll(){
        for(Circle circle : circles)
            System.out.println(circle.toString());
        for(Triangle triangle : triangles)
            System.out.println(triangle.toString());
        for(Rectangle rectangle : rectangles)
            System.out.println(rectangle.toString());
    }

    /**
     * draw all shapes in paint class
     */
    public void drawAll(){
        for(Circle circle : circles)
            circle.draw();
        for(Triangle triangle : triangles)
            triangle.draw();
        for(Rectangle rectangle : rectangles)
            rectangle.draw();
    }
}
