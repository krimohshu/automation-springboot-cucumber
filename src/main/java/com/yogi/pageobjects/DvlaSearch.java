package com.yogi.pageobjects;

import com.yogi.common.AbstratPages;
import com.yogi.common.FileScannerApi;
import com.yogi.selenium.Driver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

@Component
public class DvlaSearch extends AbstratPages {

    @Autowired
    FileScannerApi fileScannerApi;

    public  void goTo(){
        Driver.getDriver().findElement(By.xpath("//*[@id=\"get-started\"]/a")).click();
    }

    public Boolean searchCarAndVerify(String datasource, String filename){
     File myInputFile = new File(fileScannerApi.getFile( datasource,  filename).get().getPath());

      //  Workbook workbook = getWorkBook(excelPath);
        FileInputStream excelFile = null;
        Workbook workbook=null;
        Iterator<Row> rowIteratorforOrgs=null;

        try {
            excelFile = new FileInputStream(new File(fileScannerApi.getFile( datasource,  filename).get().getPath()));
            workbook = new XSSFWorkbook(excelFile);
            rowIteratorforOrgs = workbook.getSheetAt(0).iterator();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

         boolean flagColor = true;
         boolean flagMake = true;

        while (rowIteratorforOrgs.hasNext()) {
            Row currentRow = rowIteratorforOrgs.next();

            Iterator<Cell> cellIteratorForOrgs = currentRow.iterator();
           while(cellIteratorForOrgs.hasNext()){
               WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);


               Cell currentCell = cellIteratorForOrgs.next();

               if(currentCell.getColumnIndex()==0) {
                   //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Vrm")));
                   explicitWait(3);
                   Driver.getDriver().findElement(By.cssSelector("#Vrm")).sendKeys(currentCell.getStringCellValue());
                   Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/div[2]/fieldset/button")).click();
               }



               if(currentCell.getColumnIndex()==1){
                   explicitWait(3);
                //   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pr3\"]/div/ul/li[2]/span[2]")));

                   if(! currentCell.getStringCellValue().equalsIgnoreCase(Driver.getDriver().findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[2]/span[2]")).getText()))
                       flagMake = false;

               }
               if(currentCell.getColumnIndex()==2){
                   if(! currentCell.getStringCellValue().equalsIgnoreCase(Driver.getDriver().findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[3]/span[2]")).getText()))
                       flagColor = false;

                   Driver.getDriver().findElement(By.cssSelector("#content > div.back > a")).click();
               }



           }
        }
        if(flagMake && flagColor )
            return true;
        return false;
    }
}
