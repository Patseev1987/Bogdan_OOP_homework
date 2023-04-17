package Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        //product1.brand = "ООО Источник";
        //product1.name = "Бутылка с водой";
        //product1.price = 100.15;
//
//        System.out.println(product1.displayInfo());
//
//        Product product2 = new Product("Бутылка с молоком", 120.25);
//        product2.param2 = "..";
//        System.out.println(product2.displayInfo());
//
//        //product2.price = -60;
//        //product2.name = "______";
//        System.out.println(product2.displayInfo());
//
//        Product product3 = new Product("ss", "__", 100);
//        System.out.println(product3.displayInfo());
//        product3.setPrice(10);
//
//        Product bottleOfWater1 = new BottleOfWater("Бутылка1", 100, 2);
//        Product bottleOfMilk1 = new BottleOfMilk("Молоко", 200, 1, 10);
//        Product bottleOfWater2 = new BottleOfWater("Бутылка2", 100, 1);
//        Product bottleOfWater3 = new BottleOfWater("Бутылка3", 100, 2);
//        Product bottleOfWater4 = new BottleOfWater("Бутылка3", 100, 2);
//
//        String s = "123";
//        String aaaa = "123";
//        String s1 = new String("123");
//
        List<Product> products = new ArrayList<>();
//        products.add(bottleOfWater1);
//        products.add(bottleOfMilk1);
//        products.add(bottleOfWater2);
//        products.add(bottleOfWater3);
//        products.add(bottleOfWater4);
//
        VendingMachine vendingMachine = new VendingMachine(products);
//
//        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Бутылка2", 1);
//        if (bottleOfWaterRes != null) {
//            System.out.println("Вы купили: ");
//            System.out.println(bottleOfWaterRes.displayInfo());
//        } else {
//            System.out.println("Такой бутылки с водой нет в автомате.");
//        }


        //-----------------------------------BOGDAN--------------------------------

        Chocolate chocolate1 = new Chocolate("Mars", "Chocolate", 85.5, 35);
        Chocolate chocolate2 = new Chocolate("Snickers", "Chocolate", 85.5, 35);
        Chocolate chocolate3 = new Chocolate("Ritter SPORT", "Milk Chocolate", 135.25, 35);
        Chocolate chocolate4 = new Chocolate("Ritter SPORT", "Dark Chocolate", 170.5, 55);
        Chocolate chocolate5 = new Chocolate("Ritter SPORT", "Dark Chocolate", 210, 85);
        Chocolate chocolate6 = new Chocolate("Ritter SPORT", "White Chocolate", 135.25, 0);
        Chocolate chocolate7 = new Chocolate("Bounty", "Chocolate", 85.5, 35);
        Chocolate chocolate8 = new Chocolate("Ritter SPORT", "Dark chocolate with cookies", 85.5, 55);
        products.add(chocolate1);
        products.add(chocolate2);
        products.add(chocolate3);
        products.add(chocolate4);
        products.add(chocolate5);
        products.add(chocolate6);
        products.add(chocolate7);
        products.add(chocolate8);
        System.out.println("base list" +products);
        Chocolate chocolate = vendingMachine.getChokolate("Dark Chocolate","Ritter sport", 55);
        if (chocolate != null) {
            System.out.println("Вы купили: ");
            System.out.println(chocolate.displayInfo());
        } else {
            System.out.println("Такой шоколадки нет в автомате.");
        }

        Chocolate chocolateSnickers = vendingMachine.getChokolate("Chocolate","Snickers", 35);
        if (chocolateSnickers != null) {
            System.out.println("Вы купили: ");
            System.out.println(chocolateSnickers.displayInfo());
        } else {
            System.out.println("Такой шоколадки нет в автомате.");
        }

        Chocolate chocolateWhite = vendingMachine.getChokolate("white chocolate","Ritter", 0);
        if (chocolateWhite != null) {
            System.out.println("Вы купили: ");
            System.out.println(chocolateWhite.displayInfo());
        } else {
            System.out.println("Такой шоколадки нет в автомате.");
        }
        System.out.println("final list" +products);
    }
}