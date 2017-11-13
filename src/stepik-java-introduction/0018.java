/**
 * Реализуйте метод, вычисляющий симметрическую разность двух множеств.
 * Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
 *
 * Пример
 * Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */
public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
    Set<T> result = new HashSet<>();
    for(T s1 : set1) {
        if (!set2.contains(s1)){
            result.add(s1);
        }
    }
    for(T s2 : set2) {
        if (!set1.contains(s2)){
            result.add(s2);
        }
    }
    return result;
}