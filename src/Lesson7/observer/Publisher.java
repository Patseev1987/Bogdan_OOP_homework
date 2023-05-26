package Lesson7.observer;

public interface Publisher {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void sendOffer(String nameCompany, double salary);

    void sendNewOffer (Vacancy vacancy);

}
