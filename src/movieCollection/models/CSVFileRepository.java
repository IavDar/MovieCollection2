package movieCollection.models;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CSVFileRepository {
    private final String filepath;


    public CSVFileRepository(String filepath) {
        this.filepath = filepath;
    }
    public void save(Collection<Movie> data) {
        // записывает данные элементов коллекции в файл в формате CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Movie movie : data) {
                String line = movie.getCSVLine();
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage()); // выводим ошибку не пользователю, а для нашего понимания
        }
    }
    public Collection<Movie> load() {
        // читает файл
        // формирует объекты
        // помещает их в список
        // и возвращает в качестве значения
        Collection<Movie> movies = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(filepath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                Movie movie = Movie.parseFromCSV(line);
                movies.add(movie);
            }
            return movies;
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return null;
        }

    }

}
