package employees.io.writer;

public class FormRecordsConsoleWriter implements FormRecordsWriter {
    @Override
    public void writeData(int id) {
        System.out.println(id);
    }
}
