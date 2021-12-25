package combobjects;

import java.util.ArrayList;
import java.util.List;

public class Combinations extends CombObject {

    public Combinations(List<Character> alphabet, int k) {
        super(alphabet, k);
    }

    @Override
    public boolean hasNext() {
        if(this.getK() == 0)
            return false;

        List<Character> obj = this.getCurrentObj();
        int pos = obj.size() - 1;
        while (obj.get(pos) >= this.getAlphabet().get(this.getAlphabet().size() - this.getK() + pos)) {
            pos -= 1;
            if(pos < 0)
                return false;
        }
        return true;
    }

    @Override
    public void next() {
        List<Character> obj = this.getCurrentObj();

        int pos = obj.size() - 1;
        while (obj.get(pos) >= this.getAlphabet().get(this.getAlphabet().size() - this.getK() + pos)) {
            pos -= 1;
        }

        char ch = obj.get(pos);
        int alphabetIndex = this.getAlphabet().indexOf(ch);

        for (int i = pos; i < obj.size(); i++) {
            obj.set(i, this.getAlphabet().get(alphabetIndex + 1));
            alphabetIndex += 1;
        }
    }

    @Override
    protected List<Character> getFirstObject() {
        List<Character> obj = new ArrayList<>(this.getK());
        for (int i = 0; i < this.getK(); i++) {
            obj.add(this.getAlphabet().get(i));
        }
        return obj;
    }
}
