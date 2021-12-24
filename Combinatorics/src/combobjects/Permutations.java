package combobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Генератор перестановок
 */
public class Permutations extends CombObject {

    public Permutations(List<Character> alphabet) {
        super(alphabet);
    }

    @Override
    public boolean hasNext() {
        int n = this.getCurrentObj().size();
        for(int i = 0; i < n; i++) {
            if (this.getCurrentObj().get(n - i - 1) != this.getAlphabet().get(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void next() {
        List<Character> obj = this.getCurrentObj();

        for (int i = obj.size() - 2; i >= 0; i--) {
            if (obj.get(i) < obj.get(i + 1)) {
                char min_val = obj.get(i + 1);
                int min_id = i + 1;
                for (int j = i + 2; j < obj.size(); j++) {
                    if (obj.get(j) > obj.get(i) && obj.get(j) < min_val) {
                        min_val = obj.get(j);
                        min_id = j;
                    }
                }
                Collections.swap(obj, i, min_id);
                Collections.sort(obj.subList(i + 1, obj.size()));
                return;
            }
        }
    }

    @Override
    protected List<Character> getFirstObject() {
        return new ArrayList<>(this.getAlphabet());
    }
}
