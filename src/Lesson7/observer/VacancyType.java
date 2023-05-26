package Lesson7.observer;

import java.util.Random;

public enum VacancyType {
    MASTER("Специалист"), STUDENT("Студент"), DEVELOPER("Разработчик");

    private String type;
    VacancyType(String type){
        this.type = type;
    }
    public String getVacancyType(){ return type;}


    private static final Random random = new Random();

    public static VacancyType randomVacancyType()  {
        VacancyType[] vacancyTypes = values();
        return vacancyTypes[random.nextInt(vacancyTypes.length)];
    }
}
