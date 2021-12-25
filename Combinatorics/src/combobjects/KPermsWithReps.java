package combobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Генератор размещений с повторениями
 */
public class KPermsWithReps<T extends Comparable<T>> extends CombObject<T> {

    public KPermsWithReps(List<T> alphabet, int k) {
        super(alphabet, k);
    }

    @Override
    public boolean hasNext() {
        if (this.getAlphabet().size() == 0)
            return false;

        T lastLetter = this.getAlphabet().get(this.getAlphabet().size() - 1);

        for (T c : this.getCurrentObj()) {
            if (c != lastLetter)
                return true;
        }

        return false;
    }

    @Override
    public void next() {
        T firstLetter = this.getAlphabet().get(0);
        T lastLetter = this.getAlphabet().get(this.getAlphabet().size() - 1);

        List<T> currentObj = this.getCurrentObj();
        int i = currentObj.size() - 1;
        while (currentObj.get(i).equals(lastLetter)) {
            currentObj.set(i, firstLetter);
            i--;
        }
        // После цикла i находится на позиции буквы, которую увеличиваем
        int letterIndex = this.getAlphabet().indexOf(currentObj.get(i));
        currentObj.set(i, this.getAlphabet().get(letterIndex + 1));
    }

    @Override
    protected List<T> getFirstObject() {
        if (this.getAlphabet().size() == 0)
            return Collections.emptyList();

        List<T> obj = new ArrayList<>(this.getK());
        T firstLetter = getAlphabet().get(0);
        for (int i = 0; i < this.getK(); i++) {
            obj.add(firstLetter);
        }

        return obj;
    }
}
