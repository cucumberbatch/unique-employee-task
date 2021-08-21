package employees.algorithm;

public interface UniqueEmployeeFinderAlgorithm {
    /**
     * Возвращает идентификатор сотрудника, который вписал себя отличное от остальных колличество раз
     *
     * @param employeeIds массив всех записей в бланке
     * @return возвращает идентификатор уникального сотрудника
     */
    int find(int[] employeeIds);
}
