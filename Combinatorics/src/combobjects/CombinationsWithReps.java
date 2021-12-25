package combobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Генератор сочетаний по k с повторениями
 */
public class CombinationsWithReps<T extends Comparable<T>> extends CombObject<T> {
    public CombinationsWithReps(List<T> alphabet, int k) {
        super(alphabet, k);
    }

    @Override
    public boolean hasNext() {
        for (T c : this.getCurrentObj()) {
            if (c != this.getAlphabet().get(this.getAlphabet().size() - 1))
                return true;
        }

        return false;
    }

    @Override
    public void next() {
        List<T> obj = this.getCurrentObj();

        int pos = obj.size() - 1;
        while (obj.get(pos).equals(this.getAlphabet().get(this.getAlphabet().size() - 1))) {
            pos -= 1;
        }

        T nextChar = this.getAlphabet().get(this.getAlphabet().indexOf(obj.get(pos)) + 1);

        for (int i = pos; i < obj.size(); i++) {
            obj.set(i, nextChar);
        }
    }

    @Override
    protected List<T> getFirstObject() {
        List<T> obj = new ArrayList<>();
        for (int i = 0; i < this.getK(); i++) {
            obj.add(this.getAlphabet().get(0));
        }
        return obj;
    }
}
