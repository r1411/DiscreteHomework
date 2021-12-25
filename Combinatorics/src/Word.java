import java.util.List;

public class Word {
    private final StringBuilder wordBuilder;
    private static final char EMPTY_CHAR = '_';

    public Word(int length) {
        this.wordBuilder = new StringBuilder(length);
        for(int i = 0; i < length; i++)
            wordBuilder.append(EMPTY_CHAR);
    }

    public void setChar(char c, int... positions) {
        for (int pos : positions) {
            this.wordBuilder.setCharAt(pos, c);
        }
    }

    public void setChar(char c, List<Integer> positions) {
        for (int pos : positions) {
            this.wordBuilder.setCharAt(pos, c);
        }
    }

    public void putChars(List<Character> chars) {
        for(int i = 0, j = 0; i < this.wordBuilder.length(); i++) {
            if(wordBuilder.charAt(i) == EMPTY_CHAR) {
                this.wordBuilder.setCharAt(i, chars.get(j++));
            }
        }
    }

    @Override
    public String toString() {
        return this.wordBuilder.toString();
    }
}
