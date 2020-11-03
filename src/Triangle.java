import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * triangle shape
 */
public class Triangle {
    private ArrayList<Double> slides ;
    /**
     * constructor method
     * @param side1 first side
     * @param side2 second side
     * @param side3 third side
     */
    public Triangle(double side1 ,double side2, double side3){
        slides = new ArrayList<>();
        slides.add(side1);
        slides.add(side2);
        slides.add(side3);
    }

    /**
     * getting slides
     * @return slides
     */
    public ArrayList<Double> getSlides() {
        return slides;
    }

    /**
     * check if it is Equilateral or not
     * @return boolean
     */
    public boolean isEquilateral(){
        for(Double slide : slides)
            if(!slide.equals(slides.get(0)))
                return false;
        return true;
    }
    /**
     * calculate the Perimeter of this shape
     * @return Perimeter
     */
    public double calculatePerimeter(){
        return slides.get(0) + slides.get(1) + slides.get(2);
    }
    /**
     * calculate the Area of this shape
     * @return Area
     */
    public double calculateArea(){
        double Heron = (calculatePerimeter()) / 2;
        return Math.sqrt(Heron * (Heron - slides.get(0)) * (Heron - slides.get(1)) * (Heron - slides.get(2)));
    }
    /**
     * draw method shows type , Perimeter and Area of this shape
     */
    public void draw(){
        System.out.println("type : triangle\nPerimeter : "
                + calculatePerimeter() + "\nArea : "
                + calculateArea() + "\n_____________");
    }

    /**
     * overriding equal method of object class to compare shapes
     * @param obj we want to compare
     * @return boolean result of comparison
     */
    public boolean equals(Object obj) {
        if(this  == obj)
            return true;
        if(!(obj instanceof Triangle))
            return false;
        Triangle temp = (Triangle)obj;
        return temp.slides.contains(slides.get(0))
                && temp.slides.contains(slides.get(1))
                && temp.slides.contains(slides.get(2));
    }
    /**
     * overriding to string method of object class
     * to return some information about the shape as a String
     * @return String of info
     */
    public String toString() {
        return "triangle : " + slides.get(0) + " " + slides.get(1) + " " + slides.get(2);
    }
}

