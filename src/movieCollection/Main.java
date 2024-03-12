package movieCollection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Map<Long, Movie> movieMap = new HashMap<>();// коллекция фильмов.
        // @Tatjana пока выбрала для ключа - id, для значения - объекты класса Movie (как в задании)
        Manager manager = new Manager(); // через дефолтный конструктор создн объект класса Manager, чтобы вызывать на нем методы

// создаём объекты Person и Movie; помещаем их в массив;  помещаем в HashMap; обеспечиваем сортировку;
        Person person1 = new Person("Инна Веткина", false);
        Person person2 = new Person("Евгений Велтистов", true);
        Person person3 = new Person("Люк Бессон", true);
        Person person4 = new Person("David Fincher", true);
        Person person5 = new Person("Ryan Murphy", true);
        Person person6 = new Person("Fatih Akin", true);
        Person person7 = new Person("Tim Burton", true);
        Person person8 = new Person("Александр Войтинский", true);
        Movie movie1 = new Movie("Приключения Буратино", MovieGenre.ACTION , person1);
        Movie movie2 = new Movie("Приключения Электроника", MovieGenre.ADVENTURE , person2);
        Movie movie3 = new Movie("Люси",MovieGenre.ACTION, person3);
        Movie movie4 = new Movie("Gone Girl",MovieGenre.TRAGEDY, person4);
        Movie movie5 = new Movie("Dahmer-Monster", MovieGenre.HORROR, person5);
        Movie movie6 = new Movie("Gegen die Wand", MovieGenre.TRAGEDY, person6);
        Movie movie7 = new Movie("Die Insel der besonderen Kinder",MovieGenre.FANTASY, person7);
        Movie movie8 = new Movie("По щучъему велению.", MovieGenre.FANTASY, person8);
        Movie[] movies = new Movie[8];
        movies[0] = movie1;
        movies[1] = movie2;
        movies[2] = movie3;
        movies[3] = movie4;
        movies[4] = movie5;
        movies[5] = movie6;
        movies[6] = movie7;
        movies[7] = movie8;
        movieMap.put(movie1.getId(), movie1);
        movieMap.put(movie2.getId(), movie2);
        movieMap.put(movie3.getId(), movie3);
        movieMap.put(movie4.getId(), movie4);
        movieMap.put(movie5.getId(), movie5);
        movieMap.put(movie6.getId(), movie6);
        movieMap.put(movie7.getId(), movie7);
        movieMap.put(movie8.getId(), movie8);

        for (Movie movie : movies){// добавление фильмов в HashMap с помощью метода из Manager
        manager.addMovie(movie);
        }
        System.out.println(movieMap);
        //Collections.sort(movieMap); // нужна сортировка по ключу HashMap

        Scanner scanner = new Scanner(System.in);
        String usersLine;// строка ввода пользователя

        manager.setMovieMap(movieMap);// проверить???

        System.out.println("Добавили в HashMap: \n" + movieMap + "\n " );

        System.out.println("Вас приветствует MovieCollection!\n");

        do { // работу цикла надо проверить, когда напишем методы
            manager.startIntro();// выводим приветствие и набор команд. ожидаем ввод пользователя
            usersLine = scanner.nextLine();// считывание ввода пользователя
            String[] lineInParts = null;//вводим переменные для последующей обработки строк с пробелами
            String argIn = null;

            if (usersLine.contains(" ")) { //если строка с командой пользователя содержит пробел,
                lineInParts = usersLine.split(" ");//делим строку на части до и после пробела с помощью метода split.
                // Метод возвращает String[]
                // 1я часть - команда, 2я - аргумент
            }

            if (lineInParts != null && lineInParts.length == 2) {
                usersLine = lineInParts[0];// 1я часть - команда
                argIn = lineInParts[1];// 2я часть - аргумент (например, id)
            }

            switch (usersLine) {
                case "exit":
                    manager.startExitCommand();
                    break;

                case "help":
                   // manager.startHelpCommand();
                    break;

                case "info":
                    manager.startInfoCommand();
                    break;

                case "show":
                    manager.startShowCommand();
                    break;

                case "insert":
                    manager.startInsertCommand();
                    break;

                case "update":
                    manager.startUpdateCommand(argIn);
                    break;

                case "remove_key":
                    manager.startRemoveKeyCommand(argIn);
                    break;

                case "clear":
                    manager.startClearCommand();
                    break;

                case "remove_greater":
                    manager.startRemoveGreaterCommand(argIn);
                    break;

                case "remove_lower":
                    manager.startRemoveLowerCommand(argIn);
                    break;

                case "count_less_than_genre":
                    manager.startCountLessThanGenreCommand(argIn);
                    break;

                default:
                    System.out.println("Вы ввели неверную команду. Попробуйте ещё раз: ");
                    continue; //??? надо проверить
            }

        } while (!usersLine.equals("exit"));


    }
}


