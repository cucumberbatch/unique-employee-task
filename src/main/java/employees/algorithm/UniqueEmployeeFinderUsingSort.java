package employees.algorithm;

import java.util.Arrays;

/**
 * Реализация алгоритма с предварительной сортировкой и последующим отбором
 */
public class UniqueEmployeeFinderUsingSort implements UniqueEmployeeFinderAlgorithm {
    @Override
    public int find(int[] employeeIds) {
        int length = employeeIds.length;
        boolean wasEquals = true;
        int previous = -1;

        Arrays.sort(employeeIds);

        for (int i = 0; i < length - 1; i++) {
            if (employeeIds[i] == previous) {
                if (wasEquals) {
                    return previous;
                }
                wasEquals = true;
            } else {
                if (!wasEquals) {
                    return previous;
                }
                wasEquals = false;
            }
            previous = employeeIds[i];
        }

        if (employeeIds[length - 1] != previous) {
            return employeeIds[length - 1];
        }

        return -1;
    }

}
