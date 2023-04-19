package Lesson2;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 20),
                new Cat("Bagira", 25),
                new Cat("Sherhan", 30),
                new Cat("Kot", 15),
                new Cat("Abormot", 25)
        };
        Plate plate = new Plate(100);
        plate.info();
        for (Cat cat : cats) {
            System.out.println(cat.getInfo());
            cat.eat(plate);
            plate.info();
            System.out.println(cat.getInfo());
        }

    }
}
