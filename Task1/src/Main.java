import combobjects.*;

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

        try {
            FileWriter task1Writer = new FileWriter("task1_3.txt");
            KPerms obj3 = new KPerms(elements, k);
            writeToFile(obj3, task1Writer);
            while(obj3.hasNext()) {
                obj3.next();
                writeToFile(obj3, task1Writer);
            }
            task1Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter task1Writer = new FileWriter("task1_4.txt");
            Powerset obj4 = new Powerset(elements);
            writeToFile(obj4, task1Writer);
            while(obj4.hasNext()) {
                obj4.next();
                writeToFile(obj4, task1Writer);
            }
            task1Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter task1Writer = new FileWriter("task1_5.txt");
            Combinations obj5 = new Combinations(elements, k);
            writeToFile(obj5, task1Writer);
            while(obj5.hasNext()) {
                obj5.next();
                writeToFile(obj5, task1Writer);
            }
            task1Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
