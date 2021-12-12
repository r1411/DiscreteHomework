import java.util.ArrayList;
import java.util.List;

public class Combinatorics {

    /**
     * Возвращает все возможные размещения с повторениями по k элементов
     *
     * @param elements Множество элементов
     * @param k По сколько элементов размещать
     */
    public static <E> List<List<E>> repeatableArrangements(List<E> elements, int k) {
        List<List<E>> result = new ArrayList<>();
        int n = elements.size();

        for (int i = 0; i < Math.pow(n, k); i++) {
            int t = i;
            int insertingTo = k - 1;

            List<E> arrangement = new ArrayList<>();
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
    public static <E> List<List<E>> permutations(List<E> elements) {
        if (elements.size() == 0) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        E element = elements.get(0);
        elements = elements.subList(1, elements.size());
        List<List<E>> result = new ArrayList<>();
        List<List<E>> perms = permutations(elements);
        for (List<E> perm : perms) {
            for (int index = 0; index <= perm.size(); index++) {
                List<E> temp = new ArrayList<>(perm);
                temp.add(index, element);
                result.add(temp);
            }
        }
        return result;
    }
}
