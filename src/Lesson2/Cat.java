package Lesson2;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        if (name.isEmpty()) {
            throw new RuntimeException("Cat must have name!");
        } else {
            this.name = name;
        }
        if (appetite > 9) {
            this.appetite = appetite;
        } else {
            throw new RuntimeException("Appetite must be more 9!");
        }
        this.full = false;
    }

    public Cat(String name) {
        this(name, 15);
    }

    public Cat() {
        this("Bob",15);
    }

    public boolean getFull() {
        return full;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (appetite <= plate.getFood() && !full) {
            System.out.println(name + " is eating...");
            plate.setFood(plate.getFood() - appetite);
            System.out.println(name + " ate! " + name + " is full!");
            full = true;
        } else if (full) {
            System.out.println(name + " is not hungry!");

        } else {
            System.out.println(name + " can't eat because not enough food on the plate!");
        }
    }

    public String getInfo() {
        if (full) return name + " is full!";
        else return name + " is hungry!";
    }
}
