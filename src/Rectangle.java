/**
 * @author Arman Hatami
 * @version 1.0
 * rectangle shape
 */
public class Rectangle extends Polygon {
    /**
     * constructor method
     */
    public Rectangle(double ...slide){
        super(slide);
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
        System.out.println("type : rectangle");
        super.draw();

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
}
