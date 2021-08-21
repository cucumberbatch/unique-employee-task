package employees.algorithm;

import employees.io.reader.FormRecordsFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormTest {

    private final String inputFilePath1 = "src/main/resources/input1.txt";
    private final String inputFilePath2 = "src/main/resources/input2.txt";
    private final String outputFilePath = "src/main/resources/output.txt";
    private UniqueEmployeeFinderAlgorithm finderAlgorithm;

    @BeforeEach
    public void initializeAlgorithm() {
        finderAlgorithm = new UniqueEmployeeFinderUsingMap();
    }

    @Test
    public void testUniqueEmployeeWithOneRecord() {
        Assertions.assertEquals(4, finderAlgorithm.find(new int[]{4, 1, 2, 1, 2}));
        Assertions.assertEquals(4, finderAlgorithm.find(new int[]{1, 2, 4, 1, 2}));
        Assertions.assertEquals(4, finderAlgorithm.find(new int[]{1, 2, 1, 2, 4}));
    }

    @Test
    public void testUniqueEmployeeWithThreeRecords() {
        Assertions.assertEquals(42, finderAlgorithm.find(new int[]{42, 42, 67, 67, 42}));
        Assertions.assertEquals(42, finderAlgorithm.find(new int[]{42, 67, 67, 42, 42}));
        Assertions.assertEquals(42, finderAlgorithm.find(new int[]{67, 42, 42, 42, 67}));
    }

    @Test
    public void testUniqueEmployeeOddDuplicates() {
        Assertions.assertEquals(4,  finderAlgorithm.find(new int[]{4, 1, 2, 1, 2}));
        Assertions.assertEquals(42, finderAlgorithm.find(new int[]{42, 67, 67, 42, 42}));
        Assertions.assertEquals(12, finderAlgorithm.find(new int[]{67, 67, 12, 42, 54, 42, 12, 54, 8, 31, 8, 12, 9, 31, 9}));
    }

    @Test
    public void testUniqueEmployeeEvenDuplicates() {
        Assertions.assertEquals(7,  finderAlgorithm.find(new int[]{4, 1, 7, 1, 7, 7, 2, 7, 6, 2, 7, 7, 7, 6, 4, 7}));
        Assertions.assertEquals(42, finderAlgorithm.find(new int[]{42, 67, 67, 42, 42, 3, 78, 42, 78, 3}));
        Assertions.assertEquals(6,  finderAlgorithm.find(new int[]{6, 6, 6, 4, 4, 5, 5, 2, 1, 1, 9, 90, 9, 2, 90, 6}));
    }

    @Test
    public void testFormRecordsReader() {
        Assertions.assertArrayEquals(new int[]{4, 1, 2, 1, 2}, new FormRecordsFileReader(inputFilePath1).readData());
        Assertions.assertArrayEquals(new int[]{42, 67, 67, 42, 42}, new FormRecordsFileReader(inputFilePath2).readData());
    }

    @Test
    public void testComplex1() {
        FormRecordsFileReader reader = new FormRecordsFileReader(inputFilePath1);
        int[] records = reader.readData();
        Assertions.assertEquals(4, finderAlgorithm.find(records));
    }

    @Test
    public void testComplex2() {
        FormRecordsFileReader reader = new FormRecordsFileReader(inputFilePath2);
        int[] records = reader.readData();
        Assertions.assertEquals(42, finderAlgorithm.find(records));
    }
}