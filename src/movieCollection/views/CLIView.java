package movieCollection.views;

import movieCollection.*;
import movieCollection.controllers.MovieController;
import movieCollection.models.Movie;
import movieCollection.models.MovieGenre;
import movieCollection.models.Person;

import java.util.*;

public class CLIView {
    MovieController movieController;

    public void run() {
        //коллекция фильмов в виде HashMap (ключ - id, значение - объекты класса Movie)
        Map<Long, Movie> movieMap = new HashMap<>();
        //создан объект класса Manager
        movieController = new MovieController();

        // создаём объекты Person и Movie;
        Person person1 = new Person("Инна Веткина", false);
        Person person2 = new Person("Евгений Велтистов", true);
        Person person3 = new Person("Люк Бессон", true);
        Person person4 = new Person("David Fincher", true);
        Person person5 = new Person("Ryan Murphy", true);
        Person person6 = new Person("Fatih Akin", true);
        Person person7 = new Person("Tim Burton", true);
        Person person8 = new Person("Александр Войтинский", true);
        Movie movie1 = new Movie("Приключения Буратино", MovieGenre.ACTION, person1);
        Movie movie2 = new Movie("Приключения Электроника", MovieGenre.ADVENTURE, person2);
        Movie movie3 = new Movie("Люси", MovieGenre.ACTION, person3);
        Movie movie4 = new Movie("Gone Girl", MovieGenre.TRAGEDY, person4);
        Movie movie5 = new Movie("Dahmer-Monster", MovieGenre.HORROR, person5);
        Movie movie6 = new Movie("Gegen die Wand", MovieGenre.TRAGEDY, person6);
        Movie movie7 = new Movie("Die Insel der besonderen Kinder", MovieGenre.FANTASY, person7);
        Movie movie8 = new Movie("По щучъему велению.", MovieGenre.FANTASY, person8);

        movieMap.put(movie1.getId(), movie1);
        movieMap.put(movie2.getId(), movie2);
        movieMap.put(movie3.getId(), movie3);
        movieMap.put(movie4.getId(), movie4);
        movieMap.put(movie5.getId(), movie5);
        movieMap.put(movie6.getId(), movie6);
        movieMap.put(movie7.getId(), movie7);
        movieMap.put(movie8.getId(), movie8);

        // для наглядности выводим HashMap на печать
        System.out.println("Коллекция фильмов:\n " + movieMap);

        movieController.setMovieMap(movieMap);// Дарья

        // сортировка HashMap по ключу
        List<Movie> listValues = new ArrayList<>(movieMap.values());
        Collections.sort(listValues);
        // для наглядности выводим отсортированный список на печать
        System.out.println("Коллекция отсортирована:\n " + listValues + "\n ");

        //начало работы с пользовательским вводом
        Scanner scanner = new Scanner(System.in);
        String usersLine;// строка ввода пользователя

        System.out.println("Вас приветствует MovieCollection!\n");

        do { // работу цикла надо проверить, когда напишем методы
            movieController.startIntro();// выводим приветствие и набор команд. ожидаем ввод пользователя
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
                    movieController.startExitCommand();
                    break;

                case "help":
                    movieController.startHelpCommand();
                    break;

                case "info":
                    movieController.startInfoCommand();
                    break;

                case "show":
                    movieController.startShowCommand();
                    break;

                case "insert":
                    movieController.startInsertCommand();
                    break;

                case "update":
                    movieController.startUpdateCommand(argIn);
                    break;

                case "remove_key":
                    movieController.startRemoveKeyCommand(argIn);
                    break;

                case "clear":
                    movieController.startClearCommand();
                    break;

                case "remove_greater":
                    movieController.startRemoveGreaterCommand(argIn);
                    break;

                case "remove_lower":
                    movieController.startRemoveLowerCommand(argIn);
                    break;

                case "count_less_than_genre":
                    startCountLessThanGenreView(argIn);
                    break;

                default:
                    System.out.println("Вы ввели неверную команду. Попробуйте ещё раз: ");
            }

        } while (!usersLine.equals("exit"));
    }

    void startCountLessThanGenreView(String argIn) {
        //1. Ввод и проверка данных
        if (!Utils.isEnum(argIn, MovieGenre.class)) {
            System.out.println("Указанно некорректное значение");
            return;
        }

        MovieGenre targetGenre = MovieGenre.valueOf(argIn);

        //2. Вызов контроллера
        int counter = movieController.startCountLessThanGenreCommand(targetGenre);

        //3. Вывод результата
        System.out.println("Количество элементов: " + counter);
    }
}
