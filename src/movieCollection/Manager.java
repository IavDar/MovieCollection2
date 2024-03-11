package movieCollection;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    private Map<Long, Movie> movieMap;

    public void setMovieMap(Map<Long, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public Manager() {
        this.movieMap = new HashMap<>();;
    }

    public void startIntro() { //начальное сообщение с приглашением к выбору команды
        // (вроде работает, текст можно править) @Tatjana
        System.out.println("Выберите команду из списка:\n" +
                "help : вывести справку по доступным командам\n" +
                "info : вывести информацию о коллекции\n" +
                "show : вывести все элементы коллекции\n" +
                "insert: добавить новый элемент \n" +
                "update {id} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_key {id} : удалить элемент из коллекции по его ключу\n" +
                "clear : очистить коллекцию\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_greater {fieldValue} : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                "remove_lower {fieldValue} : удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
                "count_less_than_genre {genre}: вывести количество элементов, значение поля genre которых меньше заданного\n");
        System.out.print("Введите выбранную команду: ");
    }

    public void startHelpCommand() {// названия команд объяснял Карлен 09/03
        //Екатерина
        System.out.println("help");
    }

    public void startInfoCommand() {
        //Екатерина (про дату инициализации Карлен сказал, можно не делать, объяснение про метод в видео с 32 минуты)
        System.out.println("info");
    }

    public void startShowCommand() {
        //Екатерина
        System.out.println("show");
    }

    public void startInsertCommand() {
        //Екатерина
        System.out.println("insert");
    }

    public void startUpdateCommand(String argIn) {
        //Татьяна
        System.out.println("update");
    }

    public void startRemoveKeyCommand(String argIn) {
        //Татьяна
        System.out.println("remove");
    }

    public void startClearCommand() {
        //Татьяна
        System.out.println("clear");
    }

    public void startExitCommand() {
        //Татьяна
        System.out.println("Программа завершена. До свидания!");
    }

    public void startRemoveGreaterCommand(String argIn) {
        //Дарья
        //1.Пройти по мап. 2.Удалить из него каждый элемент, который подходит под условие
        // 2. Условие movie.getId() > id , усли да, то map.remove(movie.getId())

        System.out.println("remove greater");
    }

    public void startRemoveLowerCommand(String argIn) {
        //Дарья
        System.out.println("remove lower");
    }

    public void startCountLessThanGenreCommand(String argIn) {
        //Дарья


        MovieGenre genre;

        switch (argIn) {
            case "ACTION":
                genre = MovieGenre.ACTION;
                break;

            case "ADVENTURE":
                genre = MovieGenre.ADVENTURE;
                break;

            //case для каждого значения енама тут

            default:
                System.out.println("Ошибка - введенный аргумент неправильный");
                return;
        }


           // MovieGenre.ADVENTURE.ordinal();

        System.out.println("count less");
    }

}



