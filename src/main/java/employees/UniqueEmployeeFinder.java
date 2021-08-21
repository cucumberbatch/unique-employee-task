package employees;

import employees.algorithm.UniqueEmployeeFinderAlgorithm;
import employees.algorithm.UniqueEmployeeFinderUsingMap;
import employees.io.reader.FormRecordsFileReader;
import employees.io.writer.FormRecordsConsoleWriter;
import employees.io.writer.FormRecordsFileWriter;
import employees.io.writer.FormRecordsWriter;

public class UniqueEmployeeFinder {
    public static void main(String[] args) {
        FormRecordsFileReader         reader;
        FormRecordsWriter             writer;
        UniqueEmployeeFinderAlgorithm algorithm;
        String infoMessage =
                "Для поиска уникального сотрудника необходимо при запуске " +
                "указать путь файла с данными первым параметром!\n" +
                "Также опционально можно указать путь выходного файла вторым параметром.";

        if (args.length < 1 || args.length > 2) {
            System.out.println(infoMessage);
            return;
        }

        algorithm = new UniqueEmployeeFinderUsingMap();

        reader = new FormRecordsFileReader(args[0]);
        writer = (args.length == 1)
                ? new FormRecordsConsoleWriter()
                : new FormRecordsFileWriter(args[1]);

        writer.writeData(algorithm.find(reader.readData()));
    }
}
