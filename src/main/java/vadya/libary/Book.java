package vadya.libary;

import lombok.Getter;

public class Book {
    @Getter
    private String title;
    @Getter
    private String author;
    @Getter
    private int year;
    private boolean isAvailable;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true; // по умолчанию доступна
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return title + " - " + author + " (" + year + ") - " +
                (isAvailable ? "Доступна" : "Выдана");
    }
}