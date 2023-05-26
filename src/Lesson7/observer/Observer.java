package Lesson7.observer;

public interface Observer {

    void receiveOffer(String nameCompany, double salary);

    void receiveOfferBogdan ( Vacancy vacancy);

    String getVacancyType();

}
