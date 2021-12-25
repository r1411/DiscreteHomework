package combobjects;

import java.util.List;

public abstract class CombObject {
    private final List<Character> alphabet;
    private List<Character> currentObj;
    private final int k;

    // Конструктор для объектов, не требующих k
    public CombObject(List<Character> alphabet) {
        this(alphabet,0);
    }

    public CombObject(List<Character> alphabet, int k) {
        this.alphabet = alphabet;
        this.k = k;
        this.currentObj = this.getFirstObject();
    }

    // Конструктор для создания конкретного комб. объекта
    CombObject(List<Character> alphabet, List<Character> currentObj, int k) {
        this.alphabet = alphabet;
        this.currentObj = currentObj;
        this.k = k;
    }

    public abstract boolean hasNext();
    public abstract void next();
    protected abstract List<Character> getFirstObject();

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public List<Character> getCurrentObj() {
        return currentObj;
    }

    public void setCurrentObj(List<Character> obj) {
        this.currentObj = obj;
    }

    public int getK() {
        return k;
    }
}
