import java.util.ArrayList;
import java.util.List;

public class Combinatorics {

    /**
     * Возвращает все возможные размещения с повторениями по k элементов
     *
     * @param elements Множество элементов
     * @param k По сколько элементов размещать
     */
    public static List<String> repeatableArrangements(List<String> elements, int k) {
        List<String> result = new ArrayList<>();
        int n = elements.size();

        for (int i = 0; i < Math.pow(n, k); i++) {
            int t = i;
            int insertingTo = k - 1;

            String[] word = new String[k];
            // Создаем стандартное слово из всех первых букв
            for(int j = 0; j < k; j++) {
                word[j] = elements.get(0);
            }

            // Переводим i в n-тую систему счисления
            while (t > 0) {
                int elemIdx = t % n;
                word[insertingTo] = elements.get(elemIdx);
                insertingTo -= 1;
                t = t / n;
            }

            result.add(String.join("", word));
        }

        return result;
    }
}
