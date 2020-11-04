import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * polygon abstract class to save common methods between rectangle and triangle
 */
abstract class  Polygon extends Shape {
   ArrayList<Double> slides;

    /**
     * constructor method
     * @param slide
     */
   public Polygon(double ...slide){
       slides = new ArrayList<>();
       for(double side: slide)
           slides.add(side);
   }

    /**
     * getting slides
     * @return slide
     */
    public ArrayList<Double> getSlides() {
        return slides;
    }

    /**
     * overriding to string method
     * @return String of info
     */
    public String toString() {
        String slide = new String();
        for(int i = 0 ; i < slides.size() ; i++)
            slide += i + ":" + slides.get(i) + " ";
        return slide;
    }


}
