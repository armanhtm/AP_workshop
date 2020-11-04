import java.util.ArrayList;

/**
 * @author Arman Hatami
 * @version 1.0
 * paint class to store all of shapes and show them
 */
public class Paint {
    ArrayList<Shape> shapes;
    /**
     * constructor method
     */
    public Paint(){
        shapes = new ArrayList<>();
    }

    /**
     * add a shape to shape list
     * @param shape
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }
    /**
     * print all shapes in paint class
     */
    public void printAll(){
      for(Shape shape : shapes)
        System.out.println(shape.toString());
    }

    /**
     * draw all shapes in paint class
     */
    public void drawAll(){
        for(Shape shape : shapes)
            shape.draw();
    }
}
