package combobjects;

import java.util.Collections;
import java.util.List;

/**
 * Генератор всех подмножеств множества (булеан)
 */
public class Powerset<T extends Comparable<T>> extends CombObject<T> {
    private int currentPower;
    private Combinations<T> combs;

    public Powerset(List<T> alphabet) {
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
            this.combs = new Combinations<>(this.getAlphabet(), currentPower);
        }
        this.setCurrentObj(combs.getCurrentObj());
    }

    @Override
    protected List<T> getFirstObject() {
        this.currentPower = 0;
        this.combs = new Combinations<>(this.getAlphabet(), 0);
        return Collections.emptyList();
    }
}
