package movieCollection;

public class Utils {

    public static boolean isLong(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catch блок
            Long.valueOf(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }

    public static boolean isEnum(String str, Class<? extends Enum<?>> enumClass) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catch блок
            enumClass.getField(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }

    public static boolean isInt(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catch блок
            Integer.valueOf(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }

    public static boolean isBoolean(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catch блок
            //noinspection ResultOfMethodCallIgnored
            Boolean.valueOf(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возращаем false
        }
    }
}

