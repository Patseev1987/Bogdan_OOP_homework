package Lesson4.sample01;

import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * Домашняя работа, задача:
 * ========================
 * <p>
 * a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
 * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
 * подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * g. Не забываем про метод добавления фрукта в коробку.
 */
public class Homework {

    public static void main(String[] args) {

        Box<Apple> apples = new Box<>(16);
        Apple apple1 = new Apple();
        apples.addFruit(apple1);
        apples.addFruit(new Apple());
        Box<Orange> oranges = new Box<>(16);
        Orange orange1 = new Orange();
        oranges.addFruit(orange1);

        System.out.println("**********************  Add fruit in box  ****************");
        System.out.println(apples.getWeight());
        for (int i = 0; i < 5; i++) {
            oranges.addFruit(new Orange());
            apples.addFruit(new Apple());
        }
        oranges.getInfo();
        apples.getInfo();
        Box<Apple> appleBox = new Box<>(25);
        appleBox.getInfo();


        System.out.println("**********************  Boxes comparison  ****************");
        System.out.println(apples.compare(oranges));

        System.out.println("**********************  Changes of boxes  ****************");
        System.out.println("First box:");
        appleBox.getInfo();
        System.out.println("Second box:");
        apples.getInfo();
        appleBox.addFruitsInBox(apples);
        System.out.println("First box:");
        appleBox.getInfo();
        System.out.println("Second box:");
        apples.getInfo();
        System.out.println("****************************************");
        Box<Orange> orangeBox = new Box<>(16);
        for (int i = 0; i < 8; i++) {
            orangeBox.addFruit(new Orange());
        }
        System.out.println("First orange box:");
        orangeBox.getInfo();
        System.out.println("Second orange box:");
        oranges.getInfo();
        orangeBox.addFruitsInBox(oranges);
        System.out.println("First orange box:");
        orangeBox.getInfo();
        System.out.println("Second orange box:");
        oranges.getInfo();

    }

}

abstract class Fruit {

    private final float weight;

    public float getWeight() {
        return weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit {

    public Apple() {
        super(1.0f);
    }

    @Override
    public String toString() {
        return "Apple{weight - " + getWeight() + "}";
    }
}

class Orange extends Fruit {

    public Orange() {
        super(1.5f);
    }

    @Override
    public String toString() {
        return "Orange{weight - " + getWeight() + "}";
    }
}

class Box<T extends Fruit> {
    ArrayList<T> fruits;
    float weightBox;
    int weightLimit;

    public Box(int weightLimit) {
        this.weightBox = 0;
        fruits = new ArrayList<>();
        this.weightLimit = weightLimit;
    }

    public String getWeight() {
        if (!fruits.isEmpty()) {
            return String.format("Weight of box is %,.1f", weightBox);
        } else {
            return "Box is empty!";
        }
    }

    public boolean compare(Box box) {
        if (box.weightBox > this.weightBox) {
            System.out.println("That box is weighs more then this box");
            return false;
        } else if (box.weightBox == this.weightBox) {
            System.out.println("This boxes is the same!");
            return true;
        } else {
            System.out.println("This box is weighs more then that box");
            return false;
        }
    }

    public void getInfo() {
        System.out.println(getWeight());
        if (fruits.size() == 1) {
            System.out.println("There is " + fruits.size() + " fruit");
        } else if (fruits.isEmpty()) {
        } else {
            System.out.println("There are " + fruits.size() + " fruits");
        }
    }

    public void addFruit(T fruit) {
        if ((weightBox <= weightLimit && (weightBox + fruit.getWeight()) <= weightLimit) || fruits.isEmpty()) {
            fruits.add(fruit);
            weightBox += fruit.getWeight();
        } else {
            System.out.println("Box is full.We don't have space anymore!");
        }
    }

    public void addFruitsInBox(Box<T> box) {
        if ((weightBox <= weightLimit && (weightBox + box.weightBox) <= weightLimit) || fruits.isEmpty()) {
            fruits.addAll(box.fruits);
            weightBox += box.weightBox;
            box.fruits.clear();
            System.out.println("Box change was successful");
        } else {
            System.out.println("Box is full or you don't have enough space!");
        }
    }
}
