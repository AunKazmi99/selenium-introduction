package ExcelDataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProvideTest {

    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "dataDrive")
    public void testCaseData(String greeting, String communication, String id) {
        System.out.println(greeting + " " + communication + " " + id);
    }

    /*@DataProvider(name = "dataDrive")
    public Object[][] getData() {
        return new Object[][]{{"hello", "text", "1"}, {"bye", "message", "143"}, {"solo", "call", "12"}};
    }*/
    @DataProvider(name = "dataDrive")
    public Object[][] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AunAbbas\\Desktop\\ExcelPlusDataProvider.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet firstSheet = workbook.getSheetAt(0);
        int rowCount = firstSheet.getPhysicalNumberOfRows();
        XSSFRow row = firstSheet.getRow(0);
        int columnCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount - 1][columnCount];
        for (int i = 0; i < rowCount - 1; i++)
        {
            XSSFRow currentRow = firstSheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++)
            {
                Cell cell = currentRow.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);


                /*if (currentRow.getCell(j).getCellType() == CellType.STRING)
                {
                    data[i][j] = currentRow.getCell(j).getStringCellValue();
                } else
                {
                    data[i][j] = NumberToTextConverter.toText(currentRow.getCell(j).getNumericCellValue());
                }*/
            }
        }
        return data;
    }
}
