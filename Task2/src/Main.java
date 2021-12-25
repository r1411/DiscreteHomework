import combobjects.CombObject;
import combobjects.Combinations;
import combobjects.KPerms;
import combobjects.KPermsWithReps;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        generateWords(true, "task2_1.txt");
        generateWords(false, "task2_2.txt");
    }

    private static void generateWords(boolean canOtherRepeat, String fileName) {
        List<Character> remainingAlphabet = Arrays.asList('b', 'c', 'd', 'e', 'f');
        Combinations<Integer> aPositions = new Combinations<>(Arrays.asList(0, 1, 2, 3, 4), 2);
        CombObject<Character> otherSymbols;
        FileWriter writer;
        try {
            writer = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (aPositions.hasNext()) {
            otherSymbols = canOtherRepeat ? new KPermsWithReps<>(remainingAlphabet, 3) : new KPerms<>(remainingAlphabet, 3);
            while (otherSymbols.hasNext()) {
                Word word = makeWord(aPositions.getCurrentObj(), otherSymbols.getCurrentObj());
                writeWordToFile(word, writer);
                otherSymbols.next();
            }
            Word word = makeWord(aPositions.getCurrentObj(), otherSymbols.getCurrentObj());
            writeWordToFile(word, writer);
            aPositions.next();
        }

        otherSymbols = canOtherRepeat ? new KPermsWithReps<>(remainingAlphabet, 3) : new KPerms<>(remainingAlphabet, 3);
        while (otherSymbols.hasNext()) {
            Word word = makeWord(aPositions.getCurrentObj(), otherSymbols.getCurrentObj());
            writeWordToFile(word, writer);
            otherSymbols.next();
        }
        Word word = makeWord(aPositions.getCurrentObj(), otherSymbols.getCurrentObj());
        writeWordToFile(word, writer);

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Word makeWord(List<Integer> aPositions, List<Character> otherSymbols) {
        Word word = new Word(5);
        word.setChar('a', aPositions);
        word.putChars(otherSymbols);
        return word;
    }

    private static void writeWordToFile(Word word, FileWriter writer) {
        try {
            writer.write(word + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
