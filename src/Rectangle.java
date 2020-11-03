import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * rectangle shape
 */
public class Rectangle {
    private ArrayList<Double> slides;
    /**
     * constructor method
     * @param slide1 first side
     * @param slide2 second side
     * @param slide3 third side
     * @param slide4 forth side
     */
    public Rectangle(double slide1, double slide2, double slide3,double slide4){
        slides = new ArrayList<>();
        slides.add(slide1);
        slides.add(slide2);
        slides.add(slide3);
        slides.add(slide4);
    }

    /**
     * getting slides
     * @return slides
     */
    public ArrayList<Double> getSlides() {
        return slides;
    }
    /**
     * check if it is square or not
     * @return boolean
     */
    public boolean isSquare(){
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
        return slides.get(0) + slides.get(1) + slides.get(2) + slides.get(3);
    }

    /**
     * calculate the Area of this shape
     * @return Area
     */
    public double calculateArea(){
        return ((calculatePerimeter() / 2) - slides.get(0)) * slides.get(0);
    }
    /**
     * draw method shows type , Perimeter and Area of this shape
     */
    public void draw(){
        System.out.println("type : rectangle\nPerimeter : "
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
        if(!(obj instanceof Rectangle))
            return false;
        Rectangle temp = (Rectangle)obj;
        return temp.slides.contains(slides.get(0))
                && temp.slides.contains(slides.get(1))
                && temp.slides.contains(slides.get(2))
                && temp.slides.contains(slides.get(3));
    }

    /**
     * overriding to string method of object class
     * to return some information about the shape as a String
     * @return String of info
     */
    public String toString() {
        return "rectangle : " + slides.get(0) + " " + slides.get(1)
                + " " + slides.get(2) + " " + slides.get(3);
    }
}

