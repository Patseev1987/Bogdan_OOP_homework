package Lesson2;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 20),
                new Cat("Bagira", 25),
                new Cat("Sherhan", 30),
                new Cat("Kot", 15),
                new Cat("Abormot", 25),
                new Cat()
        };
        Plate plate = new Plate(100);
        plate.info();
        Owner owner = new Owner("Margo", 33);
        while (!owner.checkCats(cats)){
            for (Cat cat:cats) {
                cat.eat(plate);
                plate.info();
            }
                owner.makeFood(plate,owner.checkCats(cats));
        }
        System.out.println("All cats are full!");
    }
}
