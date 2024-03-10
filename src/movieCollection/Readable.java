package movieCollection;

import java.util.Scanner;

public interface Readable { //есть идея сделать отдельный метод для считывания пользовательского ввода;
    // еще не продумала до конца, будет видно по ходу написания методов @Tatjana
    Scanner scanner = new Scanner(System.in);
    String dataIn = scanner.nextLine();

}
