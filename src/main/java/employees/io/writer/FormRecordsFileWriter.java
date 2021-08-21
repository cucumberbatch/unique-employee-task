package employees.io.writer;

import java.io.*;
import java.io.Writer;

public class FormRecordsFileWriter implements FormRecordsWriter {
    private final String fileName;

    public FormRecordsFileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(int id) {
        try (Writer writer = new FileWriter(fileName)) {
            writer.write(String.valueOf(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
