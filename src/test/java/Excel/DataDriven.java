package Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public ArrayList<String> getData(String testCaseName) throws IOException {

        ArrayList<String> list = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AunAbbas\\Desktop\\DemoData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++)
        {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata"))
            {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator(); //Sheet is a collection of rows
                Row firstRow = rowIterator.next();
                Iterator<Cell> cellIterator = firstRow.cellIterator(); //Row is a collection of cells
                int k = 0;
                int column = 0;
                while (cellIterator.hasNext())
                {
                    Cell value = cellIterator.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases"))
                    {
                        column = k;
                    }
                    k++;
                }
                System.out.println(column);

                while (rowIterator.hasNext())
                {
                    Row r = rowIterator.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
                    {
                        Iterator<Cell> ce = r.cellIterator();
                        while (ce.hasNext())
                        {
                            list.add(ce.next().getStringCellValue());
                        }
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
    }
}