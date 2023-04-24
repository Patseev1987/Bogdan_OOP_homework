package Lesson3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample02 {

    private static Random random = new Random();

    /**
     * TODO: 2. Переработать метод generateEmployee(). Метод должен возвращать
     * любого случайного сотрудника разного типа (Worker, Freelancer)
     *
     * @return
     */
    public static Employee generateEmployee() {
        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};
        int age = random.nextInt(18,55);
        int salary = random.nextInt(900, 1500);
        int salaryIndex = random.nextInt(28, 31);
        int workHoursInWeek = random.nextInt(10,41);
        boolean flag = random.nextBoolean();
        if (flag) {
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], age, salary * salaryIndex);
        }else{
            return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)],workHoursInWeek, age,salary);
        }
    }

    public static void main(String[] args) {

        //Worker worker = new Worker("Глеб", "Григорьев", 120000);
        //System.out.println(worker);

        Employee[] employees = new Employee[12];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees);

        System.out.println("\n*** Отсортированный массив сотрудников ***\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new TypeEmployee());

        System.out.println("\n*** Отсортированный массив сотрудников по типу сотрудников ***\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new AgeComparator());

        System.out.println("\n*** Отсортированный массив сотрудников по врзрасту сотрудников ***\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }
       System.out.println("\n*** Отсортированный массив сотрудников по типу и зарплате ***\n");

        Arrays.sort(employees, new CombinationSort());

        for (Employee employee : employees) {
            System.out.println(employee);
        }


        /*int a = 2;
        boolean f = true;
        String str = "Hello!";
        System.out.println(worker);
        System.out.println(a);
        System.out.println(f);
        System.out.println(str);*/

    }

}

class SalaryComparator implements Comparator<Employee> {

    // 1 0 -1
    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
        //return o1.calculateSalary() == o2.calculateSalary() ? 0 :
        //        (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
    }
}
class SurNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return o1.surName.compareTo(o2.surName);
    }
}
class TypeEmployee implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            if(o1 instanceof Worker && o2 instanceof Worker || o1 instanceof Freelancer && o2 instanceof Freelancer){
                return 0;
            }else if (o1 instanceof Worker && o2 instanceof Freelancer){
                return -1;
            }else{
                return 1;
            }
        }
}

class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.age > o2.age) {
            return 1;
        } else if (o1.age == o2.age) {
            return 0;
        } else {
            return -1;
        }
    }
}

class CombinationSort implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        int employeeTypeSort;
        int salarySort = Double.compare(o1.calculateSalary(), o2.calculateSalary());
        if(o1 instanceof Worker && o2 instanceof Worker || o1 instanceof Freelancer && o2 instanceof Freelancer){
            employeeTypeSort=0;
        } else if (o1 instanceof Worker && o2 instanceof Freelancer) {
            employeeTypeSort=-1;
        }else{
            employeeTypeSort=1;
        }
        if (employeeTypeSort!=0){
            return employeeTypeSort;
        }else{
            return salarySort;
        }
    }
}

abstract class Employee implements Comparable<Employee> {
    protected int age;
    protected String firstName;
    protected String surName;
    protected double salary;

    public Employee(String firstName, String surName, int age, double salary) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст сотрудника: %d; Ставка: %.2f; Среднемесячная заработная плата: %.2f", surName, firstName, age, salary, calculateSalary());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee {

    public Worker(String firstName, String surName, int age, double salary) {
        super(firstName, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Возраст сотрудника %d лет;\nСреднемесячная заработная плата: %.2f",
                surName, firstName, age, calculateSalary());
    }
}

/**
 * TODO: 1. Разработать самостоятельно в рамках домашней работы.
 */
class Freelancer extends Employee {
    int workHoursInWeek;

    public Freelancer(String firstName, String surName, int workHoursInWeek, int age, double salary) {
        super(firstName, surName, age, salary);
        this.workHoursInWeek = workHoursInWeek;
    }

    @Override
    public double calculateSalary() {
        if (salary >= 700) {
            return 0.25 * salary * workHoursInWeek * 4;
        }else{
            return 0.5*salary*workHoursInWeek*4;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Возраст сотрудника %d лет; Работает по %d часов в неделю;\nСреднемесячная заработная плата: %.2f",
                surName, firstName, age,workHoursInWeek, calculateSalary());
    }
}
