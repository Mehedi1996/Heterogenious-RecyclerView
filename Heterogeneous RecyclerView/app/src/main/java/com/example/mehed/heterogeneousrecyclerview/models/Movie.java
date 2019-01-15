package com.example.mehed.heterogeneousrecyclerview.models;


public class Movie {
    private int movieImage;
    private String movieName;
    private String companyName;

    public Movie(String movieName, String companyName, int movieImage) {
        this.movieName = movieName;
        this.movieImage = movieImage;
        this.companyName = companyName;
    }

    public int getMovieImage() {
        return movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
