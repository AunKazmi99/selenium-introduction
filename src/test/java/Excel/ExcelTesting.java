package Excel;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelTesting {

    public static void main(String[] args) throws IOException {
        DataDriven dataDriven = new DataDriven();
        ArrayList<String> list= dataDriven.getData("Add Profile");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }
}
