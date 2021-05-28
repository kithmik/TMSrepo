package com.tms.admin.booking;

import com.tms.base.BaseTest;
import com.tms.pages.TourBookingPage;
import com.tms.util.CommonSteps;
import com.tms.util.excelutils.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TourBookingTest extends BaseTest {

    private CommonSteps commonStepsObj;
    private TourBookingPage tourBookingPageObj;

    @BeforeClass
    public void setup()
    {
        initialization();
    }

   @BeforeMethod
    public void login() throws Exception {
        commonStepsObj = new CommonSteps(driver);
        tourBookingPageObj = new TourBookingPage(driver, commonStepsObj);

        driver.findElement(By.xpath("//*[contains(text(),'/ Sign In')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("anuj@gmail.com");

        driver.findElement(By.xpath("//input[@id='password'][@required='']")).click();
        driver.findElement(By.xpath("//input[@id='password'][@required='']")).sendKeys("Test@123");

        driver.findElement(By.name("signin")).click();
       driver.findElement(By.xpath("//a[@href=\"package-details.php?pkgid=1\"]")).click();



   }

//    @Test
//    public void verifyThatUserCanSuccessfullyBookTheTourPackageByAddingAllFields() throws InterruptedException {
//         tourBookingPageObj.clickOnDetailsButton();
//          tourBookingPageObj.bookingTheTourPackage(ExcelUtil.getRowData(1));
//         tourBookingPageObj.saveTestResults(1,4);
//    }



    @BeforeTest
    public void setupTestData() {
        //Set Test Data Excel and Sheet
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("EnquiryData");
    }

    @Test
    public void verifySubmittingEnquiryForm() {
        tourBookingPageObj.submittingFormWithExcelData(ExcelUtil.getRowData(1));
        tourBookingPageObj.saveTestResults(1,6);

    }


}