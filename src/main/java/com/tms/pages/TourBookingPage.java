package com.tms.pages;

import com.tms.util.CommonSteps;
import com.tms.util.excelutils.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TourBookingPage {
    private WebDriver driver;
    private CommonSteps commonStepsObj;

    public TourBookingPage(WebDriver driver, CommonSteps commonStepsObj) {
        this.driver = driver;
        this.commonStepsObj = commonStepsObj;
    }

    private By detailsButtonElement = By.xpath("//a[@href=\"package-details.php?pkgid=1\"]");
    private By fromDateElement = By.id("datepicker");
    private By toDateElement = By.id("datepicker1");
    private By commentElement = By.name("comment");
    private By bookButtonElement = By.name("submit2");
    private By bookingSuccessElement = By.xpath("//*[contains(@class, 'succWrap')]");


    public void clickOnDetailsButton() {
        driver.findElement(detailsButtonElement).click();
    }

    public void clickOnFromField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        commonStepsObj.waitUntilNextElementAppears(fromDateElement,4000);
        driver.findElement(fromDateElement).click();
    }

    public void sendFromField(XSSFRow row) {
        driver.findElement(fromDateElement).sendKeys(row.getCell(0).toString());
    }

    public void clickOnToField() {
        driver.findElement(toDateElement).click();
    }

    public void sendToField(XSSFRow row) {
        driver.findElement(toDateElement).sendKeys(row.getCell(1).toString());
    }

    public void clickOnCommentField() {
        driver.findElement(commentElement).click();
    }

    public void sendCommentField(XSSFRow row) {
        driver.findElement(commentElement).sendKeys(row.getCell(2).toString());
    }

    public void clickOnBookButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        commonStepsObj.waitUntilNextElementAppears(By.name("comment"),4000);
        driver.findElement(bookButtonElement).click();
    }

//    public void bookingTheTourPackage(XSSFRow row) throws InterruptedException {
//        //
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,100)");
//        commonStepsObj.waitUntilNextElementAppears(fromDateElement,4000);
//        driver.findElement(fromDateElement).click();
//        //
//
//        driver.findElement(fromDateElement).sendKeys(row.getCell(1).toString());
//
//        driver.findElement(toDateElement).click();
//        driver.findElement(toDateElement).sendKeys(row.getCell(2).toString());
//
//      //  driver.findElement(commentElement).sendKeys(row.getCell(3).toString());
//        js.executeScript("window.scrollBy(0,1000)");
//        commonStepsObj.waitUntilNextElementAppears(bookButtonElement,4000);
//        driver.findElement(bookButtonElement).click();
//
//
//
//
//    }

    public void verifyBookingSuccessMessage() {
        String BookingMessage = driver.findElement(bookingSuccessElement).getText();
        Assert.assertEquals(BookingMessage,"SUCCESS:Booked Successfully");
    }


    public void submittingFormWithExcelData(XSSFRow row) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
        commonStepsObj.waitUntilNextElementAppears(fromDateElement,4000);
        driver.findElement(fromDateElement).click();
        driver.findElement(fromDateElement).sendKeys(row.getCell(1).toString());
        driver.findElement(toDateElement).click();
        driver.findElement(toDateElement).sendKeys(row.getCell(2).toString());
        driver.findElement(commentElement).sendKeys(row.getCell(3).toString());
        driver.findElement(bookButtonElement).click();

    }

    public void saveTestResults(int row, int column) {
        ExcelUtil.rowNumber = row ;
        ExcelUtil.columnNumber = column;

    }

}
