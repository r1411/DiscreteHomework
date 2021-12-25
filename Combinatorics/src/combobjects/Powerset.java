package combobjects;

import java.util.Collections;
import java.util.List;

/**
 * Генератор всех подмножеств множества (булеан)
 */
public class Powerset extends CombObject {
    private int currentPower;
    private Combinations combs;

    public Powerset(List<Character> alphabet) {
        super(alphabet);
    }

    @Override
    public boolean hasNext() {
        return !this.getCurrentObj().equals(this.getAlphabet());
    }

    @Override
    public void next() {
        if (combs.hasNext()) {
            this.combs.next();
        } else {
            currentPower += 1;
            this.combs = new Combinations(this.getAlphabet(), currentPower);
        }
        this.setCurrentObj(combs.getCurrentObj());
    }

    @Override
    protected List<Character> getFirstObject() {
        this.currentPower = 0;
        this.combs = new Combinations(this.getAlphabet(), 0);
        return Collections.emptyList();
    }
}
