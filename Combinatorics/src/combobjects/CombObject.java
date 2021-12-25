package combobjects;

import java.util.List;

public abstract class CombObject<T extends Comparable<T>> {
    private final List<T> alphabet;
    private List<T> currentObj;
    private final int k;

    // Конструктор для объектов, не требующих k
    public CombObject(List<T> alphabet) {
        this(alphabet,0);
    }

    public CombObject(List<T> alphabet, int k) {
        this.alphabet = alphabet;
        this.k = k;
        this.currentObj = this.getFirstObject();
    }

    // Конструктор для создания конкретного комб. объекта
    CombObject(List<T> alphabet, List<T> currentObj, int k) {
        this.alphabet = alphabet;
        this.currentObj = currentObj;
        this.k = k;
    }

    public abstract boolean hasNext();
    public abstract void next();
    protected abstract List<T> getFirstObject();

    public List<T> getAlphabet() {
        return alphabet;
    }

    public List<T> getCurrentObj() {
        return currentObj;
    }

    public void setCurrentObj(List<T> obj) {
        this.currentObj = obj;
    }

    public int getK() {
        return k;
    }
}
