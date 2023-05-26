package Lesson7.observer;

public class Student implements Observer {

    private String name;
    private double salary;

    private VacancyType vacancyType;

    public Student(String name) {
        this.name = name;
        salary = 5000;
        vacancyType = VacancyType.STUDENT;
    }

    @Override
    public void receiveOffer(String nameCompany, double salary) {
        if (this.salary < salary){
            System.out.printf("Студент %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, nameCompany, salary);
            this.salary = salary;
        }
        else{
            System.out.printf("Студент %s >>> Я найду работу получше! [%s - %f]\n",
                    name, nameCompany, salary);
        }
    }



    @Override
    public void receiveOfferBogdan(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary()){
            System.out.printf("Студент %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
        }
        else{
            System.out.printf("Студент %s >>> Я найду работу получше! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
        }
    }

    @Override
    public String getVacancyType() {
        return vacancyType.getVacancyType();
    }
}
