package Lesson7.observer;

public class Master implements Observer {

    private String name;
    private double salary;
    private VacancyType vacancyType;

    public Master(String name) {
        this.name = name;
        salary = 80000;
        vacancyType=VacancyType.MASTER;
    }

    @Override
    public void receiveOffer(String nameCompany, double salary) {
        if (this.salary < salary){
            System.out.printf("Специалист %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, nameCompany, salary);
            this.salary = salary;
        }
        else{
            System.out.printf("Специалист %s >>> Я найду работу получше! [%s - %f]\n",
                    name, nameCompany, salary);
        }
    }

    @Override
    public void receiveOfferBogdan(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary()){
            System.out.printf("Специалист %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
        }
        else{
            System.out.printf("Специалист %s >>> Я найду работу получше! [%s - %f]\n",
                    name, vacancy.getNameCompany(), vacancy.getSalary());
        }
    }

    @Override
    public String getVacancyType() {
        return vacancyType.getVacancyType();
    }
}
