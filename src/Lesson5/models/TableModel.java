package Lesson5.models;

import Lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {


    private Collection<Table> tables;


    /**
     * Получение списка всех столиков
     *
     * @return столики
     */
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());

        }
        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         номер столика
     * @param name            имя клиента
     * @return номер брони
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Невозможно забронировать столик.");
    }


    //TODO: Разработать самостоятельно в рамках домашней работы

    /**
     * Изменяет номер брони, если броньсуществует
     *
     * @param oldReservation  старый номер брони, которую надо изменить
     * @param reservationDate дата ноого бронирования
     * @param tableNo         номер нового столика
     * @param name            имя
     * @return номер новой брони
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {

        for (Table table : tables) {
            Collection<Reservation> temp = table.getReservations();
            if (!tables.isEmpty()) {
                for (Reservation reservation : temp) {
                    if (reservation.getId() == oldReservation) {
                        table.getReservations().remove(reservation);
                        return reservationTable(reservationDate, tableNo, name);
                    }
                }
            }
        }
        return -1;
    }

}
