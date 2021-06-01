package com.example.contractDatabaseServer.contracts;

public class Contract {

    private final int number;
    private final String date;
    private String lastUpdate;
    private boolean isActual;

    public Contract(int number, String date, String lastUpdate) {
        this.number = number;
        this.date = date;
        this.lastUpdate = lastUpdate;
    }

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
