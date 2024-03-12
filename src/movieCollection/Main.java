package movieCollection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        // создаём объекты Movie; помещаем их в массив или список (?); обеспечиваем сортировку; помещаем в HashMap
        Map<Long, Movie> movieMap = new HashMap<>();// коллекция фильмов.
        // @Tatjana пока выбрала для ключа - id, для значения - объекты класса Movie (как в задании)
        Manager manager = new Manager(); // через дефолтный конструктор создн объект класса Manager, чтобы вызывать на нем методы

        Person person1 = new Person("Инна Веткина", false);
        Person person2 = new Person("Евгений Велтистов", true);
        Movie movie1 = new Movie("Приключения Буратино", MovieGenre.ACTION , person1);
        Movie movie2 = new Movie("Приключения Электроника", MovieGenre.ADVENTURE , person2);
        Movie[] movies = new Movie[2];
        movies[0] = movie1;
        movies[1] = movie2;
        movieMap.put(movie1.getId(), movie1);
        movieMap.put(movie2.getId(), movie2);

//        Collections.sort(movieMap); // нужна сортировка по ключу HashMap
//
//        for (Movie movie : movies){
//        manager.addMovie(movie);
//        }
//        System.out.println(movieMap); // не сработало



        Scanner scanner = new Scanner(System.in);
        String usersLine;// строка ввода пользователя

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
                    manager.startHelpCommand();
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


