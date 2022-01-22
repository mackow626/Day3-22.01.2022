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

        dataPreparation(movieList, directorList, actorList);

        boolean shouldRunLoopAgain = true;
        while (shouldRunLoopAgain) {
            displayMenu();

            Scanner scanner = new Scanner(System.in);
            String menuOption = scanner.nextLine();

            switch (menuOption) {
                case "1":
                    //todo dodaj film
                    System.out.println("dodaj film");
                    break;
                case "2":
                    searchMovieByTitle(movieList);
                    break;
                case "3":
                    getAllMoviesForActor(movieList, actorList);
                    break;
                case "4":
                    checkMovieCost(movieList);
                    break;
                case "5":
                    findMoviesAfterDate(movieList);
                    break;
                case "0":
                    System.out.println("wyjdz z programu");
                    shouldRunLoopAgain = false;
                    break;
                default:
                    System.out.println("Niepoprawna wartość");
            }
        }
    }

    private static void findMoviesAfterDate(List<Movie> movieList) {
        System.out.println("Podaj rok, pózniej miesiąc a pozniej dzien");
        Scanner scanner4 = new Scanner(System.in);
        int year = scanner4.nextInt();
        int month = scanner4.nextInt();
        int day = scanner4.nextInt();
        LocalDate providedDate = LocalDate.of(year, month, day);
        for (Movie movie : movieList) {
            if (movie.getPremierDate().isAfter(providedDate)) {
                System.out.println(movie.getTitle());
            }
        }
    }

    private static void checkMovieCost(List<Movie> movieList) {
        System.out.println("Podaj nazwe filmu");
        Scanner scanner3 = new Scanner(System.in);
        String movieTitle = scanner3.nextLine();
        for (Movie movie : movieList) {
            if (movie.getTitle().equals(movieTitle)) {
                double movieCost = 0;
                movieCost += movie.getDirector().getSalary();
                for (Actor actor : movie.getActorList()) {
                    movieCost += actor.getSalary();
                }
                System.out.println("Koszt filmu to " + movieCost);
            }
        }
    }

    private static void getAllMoviesForActor(List<Movie> movieList, List<Actor> actorList) {
        System.out.println("Podaj nazwisko aktora");
        Scanner scanner2 = new Scanner(System.in);
        String actorLastName = scanner2.nextLine();
        Actor searchActor = null;
        for (Actor actor : actorList) {
            if (actor.getLastName().equals(actorLastName)) {
                searchActor = actor;
            }
        }

        for (Movie movie : movieList) {
            try {
                if (movie.getActorList().contains(searchActor)) {
                    System.out.println(movie.getTitle());
                }
            } catch (NullPointerException e) {
                System.out.println("Aktor o podanym nazwisku nie został znaleziony");
            }
        }
    }

    private static void searchMovieByTitle(List<Movie> movieList) {
        System.out.println("Podaj nazwe filmu");
        Scanner scanner1 = new Scanner(System.in);
        String movieName = scanner1.nextLine();
        for (Movie movie : movieList) {
            if (movie.getTitle().equals(movieName)) {
                System.out.println(movie.toString());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Wybierz z menu:\n" +
            "1: Dodaj film\n" +
            "2: Szukaj filmu po nazwie\n" +
            "3: Sprawdz w jakich filmach grał dany aktor\n" +
            "4: Policz ile kosztowało wyprodukowanie danego filmu\n" +
            "5: Wypisz filmy po dacie\n" +
            "0: Wyjdz z programu\n");
    }

    private static void dataPreparation(List<Movie> movieList, List<Director> directorList, List<Actor> actorList) {
        Director jamesCameron = new Director("James", "Cameron", 1000, true);
        directorList.add(jamesCameron);

        Director stevenSpielberg = new Director("Steven", "Spielberg ", 300, false);
        directorList.add(stevenSpielberg);

        Actor leonardoDiCaprio = new Actor("Leonardo", "DiCaprio", 500, SexEnum.male);
        actorList.add(leonardoDiCaprio);

        Actor kateWinslet = new Actor("Kate", "Winslet", 600, SexEnum.female);
        actorList.add(kateWinslet);

        Actor sylwesterStalone = new Actor("Sylwester", "Stalone", 900, SexEnum.male);
        actorList.add(sylwesterStalone);

        Movie titanic =
            new Movie("Titanic", jamesCameron, List.of(leonardoDiCaprio, kateWinslet), LocalDate.of(1999, 10, 21), MovieTypeEnum.romantic);
        movieList.add(titanic);

        Movie rambo =
            new Movie("Rambo", stevenSpielberg, List.of(sylwesterStalone, kateWinslet), LocalDate.of(2010, 10, 21), MovieTypeEnum.action);
        movieList.add(rambo);
    }
}
