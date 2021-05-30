package com.tms.pages.user.booking;

import com.tms.util.common.CommonSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ManageBookingPage {
    private WebDriver driver;
    private CommonSteps commonStepsObj;


    public ManageBookingPage(WebDriver driver, CommonSteps commonStepsObj) {
        this.driver = driver;
        this.commonStepsObj = commonStepsObj;
    }

    private By cancelElement = By.xpath("//a[href='tour-history.php?bkid=135']");


    public void cancelTheTourPackage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        commonStepsObj.waitUntilNextElementAppears(cancelElement,4000);

    }


}
