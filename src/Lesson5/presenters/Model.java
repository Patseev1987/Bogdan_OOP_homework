package Lesson5.presenters;

import Lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);
    /**
     * Изменяет номер брони, если броньсуществует
     * @param oldReservation старый номер брони, которую надо изменить
     * @param reservationDate дата ноого бронирования
     * @param tableNo номер нового столика
     * @param name имя
     * @return номер новой брони
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
