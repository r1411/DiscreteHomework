import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите элементы множества через пробел");
        String input = scan.nextLine();
        String[] parts = input.split(" ");
        List<String> elements = Arrays.asList(parts);
        System.out.println("Введите число k: ");
        int k = scan.nextInt();

        List<List<String>> repArrs = Combinatorics.repeatableArrangements(elements, k);
        writeToFile(repArrs, "task1_1.txt");
    }

    private static void writeToFile(List<List<String>> objects, String fileName) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("Всего объектов: " + objects.size());
        for(List<String> object : objects) {
            lines.add(object.toString());
        }
        try {
            Files.write(file.toPath(), lines);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла:");
            e.printStackTrace();
        }
    }
}
