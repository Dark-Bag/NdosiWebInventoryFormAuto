package Utils;


import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;


public class ReadXSLData {
    @DataProvider(name = "testData")
    public Object[][] getData(Method method) throws FileNotFoundException {
        String excelSheetName = method.getName();
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/TestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

    }


}
