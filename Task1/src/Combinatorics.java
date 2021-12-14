import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinatorics {

    /**
     * Возвращает все возможные размещения с повторениями по k элементов
     *
     * @param elements Множество элементов
     * @param k По сколько элементов размещать
     */
    public static <T> List<List<T>> repeatableArrangements(List<T> elements, int k) {
        List<List<T>> result = new ArrayList<>();
        int n = elements.size();

        for (int i = 0; i < Math.pow(n, k); i++) {
            int t = i;
            int insertingTo = k - 1;

            List<T> arrangement = new ArrayList<>();
            // Создаем стандартное слово из всех первых букв
            for(int j = 0; j < k; j++) {
                arrangement.add(elements.get(0));
            }

            // Переводим i в n-тую систему счисления
            while (t > 0) {
                int elemIdx = t % n;
                arrangement.set(insertingTo, elements.get(elemIdx));
                insertingTo -= 1;
                t = t / n;
            }

            result.add(arrangement);
        }
        return result;
    }

    /**
     * Возвращает все возможные перестановки из переданных элементов
     *
     * @param elements Список элементов
     */
    public static <T> List<List<T>> permutations(List<T> elements) {
        if (elements.size() == 0) {
            List<List<T>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        T element = elements.get(0);
        elements = elements.subList(1, elements.size());
        List<List<T>> result = new ArrayList<>();
        List<List<T>> perms = permutations(elements);
        for (List<T> perm : perms) {
            for (int index = 0; index <= perm.size(); index++) {
                List<T> temp = new ArrayList<>(perm);
                temp.add(index, element);
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * Возващает все возможные размещения по k элементов
     *
     * @param elements Множество элементов
     * @param k По сколько размещать
     */
    public static <T> List<List<T>> arrangements(List<T> elements, int k) {
        List<List<T>> result = new ArrayList<>();

        List<List<T>> combs = combinations(elements, k);
        for (List<T> combination : combs) {
            List<List<T>> permutations = permutations((combination));
            result.addAll(permutations);
        }

        return result;
    }

    /**
     * Возващает все возможные сочетания по k элементов
     *
     * @param elements Множество элементов
     * @param k По сколько размещать
     */
    public static <T> List<List<T>> combinations(List<T> elements, int k) {
        if (k == 0) {
            List<List<T>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        if (k == 1) {
            List<List<T>> result = new ArrayList<>();
            for (T item : elements) {
                result.add(Collections.singletonList(item));
            }
            return result;
        }

        List<List<T>> result = new ArrayList<>();
        for (int i=0; i <= elements.size() - k; i++) {
            T firstItem = elements.get(i);
            List<List<T>> additionalItems = combinations(elements.subList(i+1, elements.size()), k-1) ;
            for (List<T> additional : additionalItems) {
                List<T> combination = new ArrayList<>();
                combination.add(firstItem);
                combination.addAll(additional);
                result.add(combination);
            }
        }
        return result ;
    }

    /**
     * Возвращает все подмножества множества elements (т. е. его булеан)
     *
     * @param elements Элементы
     */
    public static <T> List<List<T>> powerSet(List<T> elements) {
        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i <= elements.size(); i++) {
            result.addAll(combinations(elements, i));
        }

        return result;
    }
}
