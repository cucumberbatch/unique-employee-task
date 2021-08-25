package employees.algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Данная реализация подразумевает использование статичского массива на 10_000 элементов,
 * который инициализируется при каждом вызове метода поиска, что может быть экономичнее
 * чем использование алгоритма, основанном на карте при большом колличестве данных.
 */
public class UniqueEmployeeFinderUsingStaticArray implements UniqueEmployeeFinderAlgorithm {
    @Override
    public int find(int[] employeeIds) {
        int[] elements = new int[10000];

        Arrays.stream(employeeIds)
                .forEach(employeeId -> elements[employeeId]++);

        return IntStream.range(0, elements.length)
                .filter(value -> elements[value] != 0 && elements[value] != 2)
                .findFirst()
                .orElse(-1);
    }
}
