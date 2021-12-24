package combobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Генератор размещений с повторениями
 */
public class KPermsWithReps extends CombObject {

    public KPermsWithReps(List<Character> alphabet, int k) {
        super(alphabet, k);
    }

    @Override
    public boolean hasNext() {
        if (this.getAlphabet().size() == 0)
            return false;

        char lastLetter = this.getAlphabet().get(this.getAlphabet().size() - 1);

        for (char c : this.getCurrentObj()) {
            if (c != lastLetter)
                return true;
        }

        return false;
    }

    @Override
    public void next() {
        char firstLetter = this.getAlphabet().get(0);
        char lastLetter = this.getAlphabet().get(this.getAlphabet().size() - 1);

        List<Character> currentObj = this.getCurrentObj();
        int i = currentObj.size() - 1;
        while (currentObj.get(i) == lastLetter) {
            currentObj.set(i, firstLetter);
            i--;
        }
        // После цикла i находится на позиции буквы, которую увеличиваем
        int letterIndex = this.getAlphabet().indexOf(currentObj.get(i));
        currentObj.set(i, this.getAlphabet().get(letterIndex + 1));
    }

    @Override
    protected List<Character> getFirstObject() {
        if (this.getAlphabet().size() == 0)
            return Collections.emptyList();

        List<Character> obj = new ArrayList<>(this.getK());
        char firstLetter = getAlphabet().get(0);
        for (int i = 0; i < this.getK(); i++) {
            obj.add(firstLetter);
        }

        return obj;
    }
}
