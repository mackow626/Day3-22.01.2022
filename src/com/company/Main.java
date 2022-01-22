package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>();
        List<Director> directorList = new ArrayList<>();
        List<Actor> actorList = new ArrayList<>();
        Director jamesCameron = new Director("James", "Cameron", 1000, true);
        Actor leonardoDiCaprio = new Actor("Leonardo", "DiCaprio", 500, SexEnum.male);

        Movie titanic =
            new Movie("Titanic", jamesCameron, List.of(leonardoDiCaprio), LocalDate.of(1999, 10, 21), MovieTypeEnum.romantic);
        movieList.add(titanic);

        boolean shouldRunLoopAgain = true;
        while (shouldRunLoopAgain) {
            System.out.println("Wybierz z menu:\n" +
                "1: Dodaj film\n" +
                "2: Szukaj filmu po nazwie\n" +
                "0: Wyjdz z programu\n");

            Scanner scanner = new Scanner(System.in);
            String menuOption = scanner.nextLine();

            switch (menuOption) {
                case "1":
                    //todo dodaj film
                    System.out.println("dodaj film");
                    break;
                case "2":
                    //todo szukaj filmu
                    System.out.println("Podaj nazwe filmu");
                    Scanner scanner1 = new Scanner(System.in);
                    String movieName = scanner1.nextLine();
                    for (Movie movie : movieList) {
                        if (movie.getTitle().equals(movieName)) {
                            System.out.println(movie.toString());
                        }
                    }
                    break;
                case "0":
                    //todo wyjdz z programu
                    System.out.println("wyjdz z programu");
                    shouldRunLoopAgain = false;
                    break;
                default:
                    System.out.println("Niepoprawna wartość");
            }
        }
    }
}
