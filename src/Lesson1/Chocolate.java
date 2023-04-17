package Lesson1;

public class Chocolate extends Product{
  private   int cocoa;

    public int getCocoa() {
        return cocoa;
    }

    public Chocolate(String brand, String name, double price, int cocoa) {
        super(brand, name, price);
        if (cocoa >=0 && cocoa<=100) {
            this.cocoa = cocoa;
        }else {
            throw new RuntimeException("Wrong value for cocoa");
        }
    }


    public String displayInfo (){
        return String.format("%s - %s - %f - процент какао: %d", brand, name, price, cocoa);
    }
}
