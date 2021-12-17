import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> words1 = generateWords1();
        writeToFile(words1, "task3_1.txt");
        List<String> words2 = generateWords2();
        writeToFile(words2, "task3_2.txt");
    }

    private static List<String> generateWords1() {
        List<String> words = new ArrayList<>();
        StringBuilder word;

        for (char repChar = 'a'; repChar <= 'f'; repChar++) {
            for (int rep_pos_1 = 0; rep_pos_1 <= 4; rep_pos_1++) {
                for (int rep_pos_2 = rep_pos_1 + 1; rep_pos_2 <= 4; rep_pos_2++) {
                    word = new StringBuilder(5);
                    word.append("_____");
                    word.setCharAt(rep_pos_1, repChar);
                    word.setCharAt(rep_pos_2, repChar);

                    int[] otherPos = new int[3];
                    for (int i = 0, j = 0; i < 5; i++) {
                        if (i != rep_pos_1 && i != rep_pos_2)
                            otherPos[j++] = i;
                    }

                    // Ставим буквы на оставшиеся позиции
                    for (char l3 = 'a'; l3 <= 'f'; l3++) {
                        for (char l4 = 'a'; l4 <= 'f'; l4++) {
                            for (char l5 = 'a'; l5 <= 'f'; l5++) {
                                if (l3 == l4 || l3 == l5 || l4 == l5)
                                    continue;

                                if (l3 == repChar || l4 == repChar || l5 == repChar) {
                                    continue;
                                }

                                word.setCharAt(otherPos[0], l3);
                                word.setCharAt(otherPos[1], l4);
                                word.setCharAt(otherPos[2], l5);
                                words.add(word.toString());
                            }
                        }
                    }
                }
            }
        }

        return words;
    }

    private static List<String> generateWords2() {
        List<String> words = new ArrayList<>();
        StringBuilder word;

        for (char repChar1 = 'a'; repChar1 <= 'f'; repChar1++) {
            for (char repChar2 = (char) (repChar1 + 1); repChar2 <= 'f'; repChar2++) {
                for (int rep1_pos_1 = 0; rep1_pos_1 <= 5; rep1_pos_1++) {
                    for (int rep1_pos_2 = rep1_pos_1 + 1; rep1_pos_2 <= 5; rep1_pos_2++) {
                        for (int rep2_pos_1 = 0; rep2_pos_1 <= 5; rep2_pos_1++) {
                            for (int rep2_pos_2 = rep2_pos_1 + 1; rep2_pos_2 <= 5; rep2_pos_2++) {

                                if (rep1_pos_1 == rep1_pos_2
                                        || rep1_pos_1 == rep2_pos_1
                                        || rep1_pos_1 == rep2_pos_2
                                        || rep1_pos_2 == rep2_pos_1
                                        || rep1_pos_2 == rep2_pos_2
                                        || rep2_pos_1 == rep2_pos_2) {
                                    continue;
                                }

                                word = new StringBuilder(6);
                                word.append("______");
                                word.setCharAt(rep1_pos_1, repChar1);
                                word.setCharAt(rep1_pos_2, repChar1);
                                word.setCharAt(rep2_pos_1, repChar2);
                                word.setCharAt(rep2_pos_2, repChar2);

                                int[] otherPos = new int[2];
                                for (int i = 0, j = 0; i < 6; i++) {
                                    if (i != rep1_pos_1 && i != rep1_pos_2 && i != rep2_pos_1 && i != rep2_pos_2)
                                        otherPos[j++] = i;
                                }

                                // Ставим буквы на оставшиеся позиции
                                for (char l3 = 'a'; l3 <= 'f'; l3++) {
                                    for (char l4 = 'a'; l4 <= 'f'; l4++) {
                                        if (l3 == l4)
                                            continue;

                                        if (l3 == repChar1 || l4 == repChar1 || l3 == repChar2 || l4 == repChar2) {
                                            continue;
                                        }

                                        word.setCharAt(otherPos[0], l3);
                                        word.setCharAt(otherPos[1], l4);
                                        words.add(word.toString());
                                    }
                                }

                            }
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
