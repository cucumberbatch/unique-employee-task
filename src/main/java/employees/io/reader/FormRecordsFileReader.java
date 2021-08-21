package employees.io.reader;

import java.io.*;
import java.util.Scanner;

public class FormRecordsFileReader {
    private final String fileName;

    public FormRecordsFileReader(String fileName) {
        this.fileName = fileName;
    }

    public int[] readData() {
        int[] records = new int[]{};

        try (Scanner scanner = new Scanner(new File(fileName))) {
            int amountOfRecords = scanner.nextInt();
            records = new int[amountOfRecords];
            for (int i = 0; i < amountOfRecords; i++) {
                records[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
