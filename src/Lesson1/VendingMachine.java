package Lesson1;

import java.util.ArrayList;
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

    /**getChocolate()
     * This method allows you to buy chocolate.
     * @param name  String
     * @param brand  String
     * @param cocoa  Integer
     * @return Chocolate or null
     */

    public Chocolate getChokolate(String name,String brand, int cocoa) {
        if (cocoa>100 || cocoa<0) {
            throw new RuntimeException("Wrong value for cocoa");
        }
        for (Product product : products) {
            if (product instanceof Chocolate) {
                Chocolate chocolate = ((Chocolate) product);
                if (chocolate.name.equalsIgnoreCase(name) && chocolate.brand.equalsIgnoreCase(brand)
                        && chocolate.getCocoa() == cocoa) {
                    Chocolate result = chocolate;
                    products.remove(products.indexOf(chocolate));
                    return result;
                }
            }
        }
        return null;
    }

}
