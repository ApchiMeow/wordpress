package DataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataProvider {
    private static final String MATRICES_PATH = "src/test/resources" + File.separator;
    private static final String TEST_DATA_SHEET_NAME = "test_data";
    private static final String TEST_NAME_COLUMN_NAME = "TestName";
    private static final String REGISTRATION_PAGE_SPREADSHEET_NAME = "RegistrationPageTests.xlsx";
    private static final DataFormatter CELL_FORMATTER = new DataFormatter();

    @DataProvider(name = "RegistrationPageDataProvider")
    public static Object[][] registrationPageDataProvider(){
        return loadDataFromMatrix(REGISTRATION_PAGE_SPREADSHEET_NAME);
    }

    private static Object[][] loadDataFromMatrix(String matrixName){
        List<Map<String,String>> allTestData = new ArrayList<>();
        try(XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(MATRICES_PATH + matrixName)))) {
            XSSFSheet testSheet = workbook.getSheet(TEST_DATA_SHEET_NAME);
            XSSFRow firstRow = testSheet.getRow(0);
            short firstRowColumnCount = firstRow.getLastCellNum();
            if(!CELL_FORMATTER.formatCellValue(firstRow.getCell(0)).equals(TEST_NAME_COLUMN_NAME)){
                throw new IllegalStateException("First column in the matrix must have " + TEST_NAME_COLUMN_NAME + " name");
            }
            int rowsCount = testSheet.getLastRowNum();
            for(int rowNumber = 1; rowNumber <= rowsCount; rowNumber++){
                XSSFRow testDataRow = testSheet.getRow(rowNumber);
                if(!CELL_FORMATTER.formatCellValue(testDataRow.getCell(0)).equals(matrixName.split("\\.")[0])){
                    continue;
                }
                Map<String,String> singleTestDate = new HashMap<>();
                for(int columnNumber = 0; columnNumber < firstRowColumnCount; columnNumber++){
                    XSSFCell keyCell = firstRow.getCell(columnNumber);
                    XSSFCell valueCell = testDataRow.getCell(columnNumber);
                    if(keyCell != null && valueCell != null){
                        String key = CELL_FORMATTER.formatCellValue(keyCell);
                        String value = CELL_FORMATTER.formatCellValue(valueCell);
                        singleTestDate.put(key,value);
                    }
                }
                allTestData.add(singleTestDate);
            }
            workbook.close();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Object[][] data = new Object[allTestData.size()][];
        for(int i = 0; i < allTestData.size(); i++){
            Map<String,String> singleTestData = allTestData.get(i);
            data[i] = new Object[]{singleTestData};
        }
        return data;
    }
}
