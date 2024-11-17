package com.mycompany;

public class Book {
    private String title;
    private String[] authors;
    private String isbn;
    private String isbn13;
    private String language_code;
    private double num_pages;
    private double average_rating;
    private int ratings_count;

    // Null-safe getters
    public String getTitle() {
        return title != null ? title : "";
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getIsbn() {
        return isbn != null ? isbn : "";
    }

    public String getIsbn13() {
        return isbn13 != null ? isbn13 : "";
    }

    public String getLanguageCode() {
        return language_code != null ? language_code : "";
    }

    public double getNumPages() {
        return num_pages;
    }

    public double getAverageRating() {
        return average_rating;
    }

    public int getRatingsCount() {
        return ratings_count;
    }
}

