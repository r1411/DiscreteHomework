package combobjects;

import java.util.ArrayList;
import java.util.List;

public class Combinations<T extends Comparable<T>> extends CombObject<T> {

    public Combinations(List<T> alphabet, int k) {
        super(alphabet, k);
    }

    @Override
    public boolean hasNext() {
        if(this.getK() == 0)
            return false;

        List<T> obj = this.getCurrentObj();
        int pos = obj.size() - 1;
        while (obj.get(pos).compareTo(this.getAlphabet().get(this.getAlphabet().size() - this.getK() + pos)) >= 0) {
            pos -= 1;
            if(pos < 0)
                return false;
        }
        return true;
    }

    @Override
    public void next() {
        List<T> obj = this.getCurrentObj();

        int pos = obj.size() - 1;
        while (obj.get(pos).compareTo(this.getAlphabet().get(this.getAlphabet().size() - this.getK() + pos)) >= 0) {
            pos -= 1;
        }

        T ch = obj.get(pos);
        int alphabetIndex = this.getAlphabet().indexOf(ch);

        for (int i = pos; i < obj.size(); i++) {
            obj.set(i, this.getAlphabet().get(alphabetIndex + 1));
            alphabetIndex += 1;
        }
    }

    @Override
    protected List<T> getFirstObject() {
        List<T> obj = new ArrayList<>(this.getK());
        for (int i = 0; i < this.getK(); i++) {
            obj.add(this.getAlphabet().get(i));
        }
        return obj;
    }
}
