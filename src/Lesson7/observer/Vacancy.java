package Lesson7.observer;

public class Vacancy {
  private   VacancyType type;
   private double salary;
   private String nameCompany;

    public VacancyType getType() {
        return type;
    }

    public double getSalary() {
        return salary;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public Vacancy(VacancyType type, double salary, String name) {
        this.type = type;
        this.salary = salary;
        this.nameCompany = name;


    }
}
