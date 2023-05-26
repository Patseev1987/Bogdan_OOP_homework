package Lesson7.observer;

public class Developer implements Observer {

    private String name;
    private double salary;
    private VacancyType vacancyType;

    public Developer(String name) {
        this.name = name;
        salary = 100000;
        vacancyType=VacancyType.DEVELOPER;
    }

    @Override
    public void receiveOffer(String nameCompany, double salary) {
        if (this.salary < salary){
            System.out.printf("Разработчик %s >>> Мне нужна эта работа! [%s - %f]\n",
                    name, nameCompany, salary);
            this.salary = salary;
        }
        else{
            System.out.printf("Разработчик %s >>> Я найду работу получше! [%s - %f]\n",
                    name, nameCompany, salary);
        }
    }


    @Override
    public void receiveOfferBogdan(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary()){
            System.out.printf("Разработчик %s >>> Мне нужна эта работа на вакансию %s! [%s - %f]\n",
                    name,vacancy.getType().getVacancyType(), vacancy.getNameCompany(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
        }
        else{
            System.out.printf("Разработчик %s >>> Я найду работу получше с вакансией %s! [%s - %f]\n",
                    name,vacancy.getType().getVacancyType(), vacancy.getNameCompany(), vacancy.getSalary());
        }
    }

    @Override
    public String getVacancyType() {
        return vacancyType.getVacancyType();
    }

}
