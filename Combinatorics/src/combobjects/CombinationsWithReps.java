package combobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Генератор сочетаний по k с повторениями
 */
public class CombinationsWithReps extends CombObject {
    public CombinationsWithReps(List<Character> alphabet, int k) {
        super(alphabet, k);
    }

    @Override
    public boolean hasNext() {
        for (char c : this.getCurrentObj()) {
            if (c != this.getAlphabet().get(this.getAlphabet().size() - 1))
                return true;
        }

        return false;
    }

    @Override
    public void next() {
        List<Character> obj = this.getCurrentObj();

        int pos = obj.size() - 1;
        while (obj.get(pos) == this.getAlphabet().get(this.getAlphabet().size() - 1)) {
            pos -= 1;
        }

        char nextChar = this.getAlphabet().get(this.getAlphabet().indexOf(obj.get(pos)) + 1);

        for (int i = pos; i < obj.size(); i++) {
            obj.set(i, nextChar);
        }
    }

    @Override
    protected List<Character> getFirstObject() {
        List<Character> obj = new ArrayList<>();
        for (int i = 0; i < this.getK(); i++) {
            obj.add(this.getAlphabet().get(0));
        }
        return obj;
    }
}
