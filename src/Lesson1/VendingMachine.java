package Lesson1;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, int volume) {
        for (Product product : products) {
            if (product instanceof BottleOfWater) {
                BottleOfWater bottle = ((BottleOfWater) product);
                if (bottle.name.equals(name) && bottle.getVolume() == volume)
                    return bottle;
            }
        }
        return null;
    }

    public Chocolate getChokolate(String brand, int cocoa) {
        for (Product product : products) {
            if (product instanceof Chocolate) {
                Chocolate chocolate = ((Chocolate) product);
                if (chocolate.brand.equalsIgnoreCase(brand) && chocolate.getCocoa() == cocoa) {
                    return chocolate;
                }
            }
        }
        return null;
    }
}
