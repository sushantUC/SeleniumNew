package util;

import base.BaseTest;
import static base.Driver.driver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Created by sushant on 18/01/19.
 */
public class TestUtil extends BaseTest {

    public static long Page_Load_TimeOut=20;
    public static long Implicit_Wait=10;
    public static String  TESTDATA_SHEET_PATH ="/Users/sushant/TestNG_Selenium01/src/main/java/testData/excelData.xlsx";
    static Workbook book;
    static Sheet sheet;


    public void switchToFream(){
        driver.switchTo().frame("mainpanel");

    }

    public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;
        try {
            file= new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        }
        catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0; i< sheet.getLastRowNum();i++){
            for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
                    data[i][k]= sheet.getRow(i+1).getCell(k).toString();
            }

        }

        return data;
    }
}
