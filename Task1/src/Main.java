import combobjects.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        writeAllObjectsToFile(new KPermsWithReps(elements, k), "task1_1.txt");
        writeAllObjectsToFile(new Permutations(elements), "task1_2.txt");
        writeAllObjectsToFile(new KPerms(elements, k), "task1_3.txt");
        writeAllObjectsToFile(new Powerset(elements), "task1_4.txt");
        writeAllObjectsToFile(new Combinations(elements, k), "task1_5.txt");
        writeAllObjectsToFile(new CombinationsWithReps(elements, k), "task1_6.txt");
    }

    private static void writeAllObjectsToFile(CombObject obj, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(obj.getCurrentObj().toString() + System.lineSeparator());
            while(obj.hasNext()) {
                obj.next();
                writer.write(obj.getCurrentObj().toString() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
