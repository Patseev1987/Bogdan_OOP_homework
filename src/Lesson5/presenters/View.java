package Lesson5.presenters;

import Lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отобразить список всех столиков
     * @param tables столики
     */
    void showTables(Collection<Table> tables);

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     */
    void showReservationTableStatus(int reservationId);

    /**
     * TODO: Доработать метод в рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения бронирования),
     * изменение бронирования столика
     * @param oldReservation старый номер бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo номер столика
     * @param name имя клиета
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

    /**
     * Отобразить список всех столиков c резервами
     * @param tables столики
     */
    void showTablesWithReservations(Collection<Table> tables);
}
