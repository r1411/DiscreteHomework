package combobjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Генератор размещений без повторений по K
 */
public class KPerms<T extends Comparable<T>> extends CombObject<T> {

    private Set<T> used;
    private Permutations<T> perm;

    public KPerms(List<T> alphabet, int k) {
        super(alphabet, k);
    }

    @Override
    public boolean hasNext() {
        int j = this.getAlphabet().size() - 1;
        for (T c : this.getCurrentObj()) {
            if (c != this.getAlphabet().get(j)) {
                return true;
            }
            j--;
        }
        return false;
    }

    @Override
    public void next() {
        int k = this.getK();
        int n = this.getAlphabet().size();
        List<T> currentPerm = perm.getCurrentObj();

        for (int i = this.getAlphabet().size() - 1; i >= 0; i--) {
            if (!used.contains(this.getAlphabet().get(i))) {
                currentPerm.set(k, this.getAlphabet().get(i));
                k++;
            }
        }

        Permutations<T> tempPerm = new Permutations<>(this.getAlphabet(), currentPerm);
        if (tempPerm.hasNext()) {
            tempPerm.next();
            for (int i = this.getK(); i < n; i++) {
                int index = this.getAlphabet().indexOf(currentPerm.get(i));
                used.remove(this.getAlphabet().get(index));

            }
            for (int i = 0; i < this.getK(); i++) {
                int index = this.getAlphabet().indexOf(currentPerm.get(i));
                used.add(this.getAlphabet().get(index));
            }
        }

        this.setCurrentObj(currentPerm.subList(0, this.getK()));
    }

    @Override
    protected List<T> getFirstObject() {
        this.used = new HashSet<>();
        this.perm = new Permutations<>(this.getAlphabet());
        List<T> obj = new ArrayList<>(this.getK());
        for (int i = 0; i < this.getK(); i++) {
            obj.add(this.getAlphabet().get(i));
            this.used.add(this.getAlphabet().get(i));
        }
        return obj;
    }
}
