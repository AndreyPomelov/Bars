package com.example.contractDatabaseServer.contracts;

/** Класс, описывающий договор
 * @author Andrey Pomelov
 * @version 1.0
 */
public class Contract {

    /** Номер договора */
    private final int number;
    /** Дата заключения договора */
    private final String date;
    /** Дата обновления договора */
    private String lastUpdate;
    /** Переменная, показывающая, актуален ли договор.
     * Значение этой переменной присваивается непосредственно
     * перед отправкой клиенту сгенерированной веб-страницы.
     */
    private boolean isActual;

    /** Конструктор класса
     * @param number Номер договора
     * @param date Дата заключения договора
     * @param lastUpdate Дата обновления договора
     */
    public Contract(int number, String date, String lastUpdate) {
        this.number = number;
        this.date = date;
        this.lastUpdate = lastUpdate;
    }

    /** Далее - стандартные геттеры и сеттеры */
    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public boolean getIsActual() {
        return isActual;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }
}
