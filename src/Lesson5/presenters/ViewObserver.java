package Lesson5.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reservationDate, int tableNo, String name);


    /**
     * TODO: Доработать метод в рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения бронирования),
     * изменение бронирования столика
     *
     * @param oldReservation  старый номер бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo         номер столика
     * @param name            имя клиета
     */
    void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
