import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = generateWords(true);
        writeToFile(words, "task2_1.txt");
        List<String> words2 = generateWords(false);
        writeToFile(words2, "task2_2.txt");
    }

    private static List<String> generateWords(boolean bfCanRepeat) {
        List<String> words = new ArrayList<>();
        StringBuilder word;
        for (int a_pos_1 = 0; a_pos_1 <= 4; a_pos_1++) {
            for (int a_pos_2 = a_pos_1 + 1; a_pos_2 <= 4; a_pos_2++) {
                word = new StringBuilder(5);
                word.append("_____");
                word.setCharAt(a_pos_1, 'a');
                word.setCharAt(a_pos_2, 'a');

                int[] otherPos = new int[3];

                for (int i = 0, j = 0; i < 5; i++) {
                    if (i != a_pos_1 && i != a_pos_2)
                        otherPos[j++] = i;
                }

                // Ставим буквы на оставшиеся позиции
                for (char l3 = 'b'; l3 <= 'f'; l3++) {
                    for (char l4 = 'b'; l4 <= 'f'; l4++) {
                        for (char l5 = 'b'; l5 <= 'f'; l5++) {

                            if(!bfCanRepeat)
                                if (l3 == l4 || l3 == l5 || l4 == l5)
                                    continue;

                            word.setCharAt(otherPos[0], l3);
                            word.setCharAt(otherPos[1], l4);
                            word.setCharAt(otherPos[2], l5);
                            words.add(word.toString());
                        }
                    }
                }
            }
        }

        return words;
    }

    private static void writeToFile(List<String> objects, String fileName) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        lines.add("Всего объектов: " + objects.size());
        lines.addAll(objects);
        try {
            Files.write(file.toPath(), lines);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла:");
            e.printStackTrace();
        }
    }
}
