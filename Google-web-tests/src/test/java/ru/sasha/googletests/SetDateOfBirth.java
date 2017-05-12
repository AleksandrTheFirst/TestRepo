package ru.sasha.googletests;

public class SetDateOfBirth {
    private final String dd;
    private final String yyyy;
    private final String month;

    public SetDateOfBirth(String dd, String yyyy, String month) {
        this.dd = dd;
        this.yyyy = yyyy;
        this.month = month;
    }

    public String getDd() {
        return dd;
    }

    public String getYyyy() {
        return yyyy;
    }

    public String getMonth() {
        return month;
    }
}
