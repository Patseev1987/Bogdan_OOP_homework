package Lesson7.observer;

public class Program {

    /**
     * TODO: 1.Доработать приложение, поработать с шаблоном проектирования Observer
     *   добавить новый тип соискателя.
     *   **.2 Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *   **.3 Предусмотреть тип вакансии (enum)
     * @param args
     */
    public static void main(String[] args) {

        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);

      //  Master ivanov = new Master("Ivanov");
        Master petrov = new Master("Petrov");
        Student sidorov = new Student("Sidorov");
        Developer raj = new Developer("Raj");
        Master malkov = new Master("Malkov");
        Student udin = new Student("Udin");
        Developer frolov = new Developer("Frolov");


   //     jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(raj);
        jobAgency.registerObserver(malkov);
        jobAgency.registerObserver(udin);
        jobAgency.registerObserver(frolov);

//        for(int i = 0; i < 10; i++){
//            geekBrains.needEmployee();
//            google.needEmployee();
//            yandex.needEmployee();
//        }


        for(int i = 0; i < 5; i++){
            geekBrains.needNewEmployee();
            google.needNewEmployee();
            yandex.needNewEmployee();
        }
    }

}
