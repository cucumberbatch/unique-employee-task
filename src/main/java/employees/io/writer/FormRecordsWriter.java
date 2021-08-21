package employees.io.writer;

public interface FormRecordsWriter {
    /**
     * Записывает идентификатор уникального сотрудника в поток вывода, определенный наследниками данного интерфейса
     *
     * @param id идентификатор уникального сотрудника
     */
    void writeData(int id);
}
