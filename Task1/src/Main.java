import combobjects.CombObject;
import combobjects.KPermsWithReps;
import combobjects.Permutations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите буквы через пробел");
        String input = scan.nextLine();
        List<Character> elements = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (c != ' ')
                elements.add(c);
        }

        System.out.println("Введите число k: ");
        int k = scan.nextInt();


        try {
            FileWriter task1Writer = new FileWriter("task1_1.txt");
            KPermsWithReps obj1 = new KPermsWithReps(elements, k);
            writeToFile(obj1, task1Writer);
            while(obj1.hasNext()) {
                obj1.next();
                writeToFile(obj1, task1Writer);
            }
            task1Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter task1Writer = new FileWriter("task1_2.txt");
            Permutations obj2 = new Permutations(elements);
            writeToFile(obj2, task1Writer);
            while(obj2.hasNext()) {
                obj2.next();
                writeToFile(obj2, task1Writer);
            }
            task1Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<Character>> arrs = Combinatorics.arrangements(elements, k);
        writeToFile(arrs, "task1_3.txt");

        List<List<Character>> powerSet = Combinatorics.powerSet(elements);
        writeToFile(powerSet, "task1_4.txt");

        List<List<Character>> combinations = Combinatorics.combinations(elements, k);
        writeToFile(combinations, "task1_5.txt");

        List<List<Character>> repCombs = Combinatorics.repeatableCombinations(elements, k);
        writeToFile(repCombs, "task1_6.txt");
    }

    private static <T> void writeToFile(List<List<T>> objects, String fileName) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("Всего объектов: " + objects.size());
        for(List<T> object : objects) {
            lines.add(object.toString());
        }
        try {
            Files.write(file.toPath(), lines);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла:");
            e.printStackTrace();
        }
    }

    private static void writeToFile(CombObject obj, FileWriter writer) throws IOException {
        writer.write(obj.getCurrentObj().toString() + System.lineSeparator());
    }
}
