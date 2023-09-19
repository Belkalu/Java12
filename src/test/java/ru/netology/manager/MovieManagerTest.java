package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

public class MovieManagerTest {
    Movie movie1 = new Movie(1, "Бладшот", "боевик");
    Movie movie2 = new Movie(2, "Вперед", "мультфильм");
    Movie movie3 = new Movie(3, "Отель <<Белград>>", "комедия");
    Movie movie4 = new Movie(4, "Джентльмены", "боевик");
    Movie movie5 = new Movie(5, "Человек-невидимка", "ужасы");
    Movie movie6 = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    Movie movie7 = new Movie(7, "Номер один", "комедия");

    @Test
    public void addMovie() {
        MovieManager movie = new MovieManager();

        movie.addMovie(movie1);

        Movie[] actual = movie.findAll();
        Movie[] expected = {movie1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addAllMovies() {
        MovieManager movie = new MovieManager();

        movie.addMovie(movie1);
        movie.addMovie(movie2);
        movie.addMovie(movie3);
        movie.addMovie(movie4);
        movie.addMovie(movie5);
        movie.addMovie(movie6);
        movie.addMovie(movie7);

        Movie[] actual = movie.findAll();
        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLastMovies() {
        MovieManager movie = new MovieManager();

        movie.addMovie(movie1);
        movie.addMovie(movie2);
        movie.addMovie(movie3);
        movie.addMovie(movie4);
        movie.addMovie(movie5);
        movie.addMovie(movie6);
        movie.addMovie(movie7);

        Movie[] actual = movie.findLast();
        Movie[] expected = {movie7, movie6, movie5, movie4, movie3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLastThreeMovies() {
        MovieManager movie = new MovieManager(3);

        movie.addMovie(movie1);
        movie.addMovie(movie2);
        movie.addMovie(movie3);
        movie.addMovie(movie4);
        movie.addMovie(movie5);
        movie.addMovie(movie6);
        movie.addMovie(movie7);

        Movie[] actual = movie.findLast();
        Movie[] expected = {movie7, movie6, movie5};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void lessThanDefinedLimit() {
        MovieManager movie = new MovieManager();

        movie.addMovie(movie1);
        movie.addMovie(movie2);

        Movie[] actual = movie.findLast();
        Movie[] expected = {movie2, movie1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLastMovieForLimit() {
        MovieManager movie = new MovieManager();

        movie.addMovie(movie1);
        movie.addMovie(movie2);
        movie.addMovie(movie3);
        movie.addMovie(movie4);
        movie.addMovie(movie5);

        Movie[] actual = movie.findLast();
        Movie[] expected = {movie5, movie4, movie3, movie2, movie1};

        Assertions.assertArrayEquals(actual, expected);
    }
}
