package movieCollection;
public class Manager {
    public void startIntro() { //начальное сообщение с приглашением к выбору команды
        // (вроде работает, текст можно править) @Tatjana
        System.out.println("Вас приветствует MovieCollection! Выберите команду из списка:\n" +
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
        System.out.println("");
    }

    public void startInfoCommand() {
        //Екатерина
        System.out.println("");
    }

    public void startShowCommand() {
        //Екатерина
        System.out.println("");
    }

    public void startInsertCommand() {
        //Екатерина
        System.out.println("");
    }

    public void startUpdateCommand() {
        //Татьяна
        System.out.println("");
    }

    public void startRemoveKeyCommand() {
        //Татьяна
        System.out.println("");
    }

    public void startClearCommand() {
        //Татьяна
        System.out.println("");
    }

    public void startExitCommand() {
        //Татьяна
        System.out.println("");
    }

    public void startRemoveGreaterCommand() {
        //Дарья
        System.out.println("");
    }

    public void startRemoveLowerCommand() {
        //Дарья
        System.out.println("");
    }

    public void startLessThanGenreCommand() {
        //Дарья
        System.out.println("");
    }

}



