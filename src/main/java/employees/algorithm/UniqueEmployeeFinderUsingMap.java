package employees.algorithm;

import java.util.*;

/**
 * Реализация алгоритма через запись талонов в карту и последующим перебором списков дубликатов
 */
public class UniqueEmployeeFinderUsingMap implements UniqueEmployeeFinderAlgorithm {
    @Override
    public int find(int[] employeeIds) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int id : employeeIds) {
            if (map.containsKey(id)) {
                map.get(id).add(id);
            } else {
                List<Integer> duplicates = new ArrayList<>();
                duplicates.add(id);
                map.put(id, duplicates);
            }
        }

        for (List<Integer> duplicatesList : map.values()) {
            if (duplicatesList.size() != 2) {
                return duplicatesList.get(0);
            }
        }

        return -1;
    }
}
