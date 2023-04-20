package Lesson2;

public class Plate {
    private int food;

    public Plate(int food) {
        if (food > 15) {
            System.out.println("You called your cats for meals!");
            this.food = food;
        } else {
            throw new RuntimeException("Food must be more 15!");
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

}
