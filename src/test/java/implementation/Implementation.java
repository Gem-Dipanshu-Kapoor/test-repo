package implementation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Locators;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;

    private static ExtentReports extent;
    private static ExtentTest test;
    private ExtentTest step;

    static {
        String reportDir = System.getProperty("user.dir") + "/results";
        new File(reportDir).mkdirs();

        String reportPath = reportDir + "/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("FAB Business Account Automation Report");
        spark.config().setDocumentTitle("FAB Test Results");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public void startTest(String scenarioName) {
        test = extent.createTest(scenarioName);
    }

    public void endTest() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        extent.flush();
    }

    public void launchUrl() {
        step = test.createNode("Launch URL");
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://business.bankfab.com/");
            step.pass("URL launched successfully");
            waitForSeconds(2);
            attachScreenshot(step, "launchUrl", true);
        } catch (Exception e) {
            step.fail("Failed to launch URL");
            attachScreenshot(step, "launchUrl", false);
        }
    }

    public void scrollToSectionCompareAccounts(String sectionName) {
        step = test.createNode("Scroll to section: " + sectionName);
        waitForSeconds(2);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.compareAccountsHeadings));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            step.pass("Scrolled to section");
            attachScreenshot(step, "scrollToSection", true);
        } catch (Exception e) {
            step.fail("Scroll failed");
            attachScreenshot(step, "scrollToSection", false);
        }
    }

    public void scrollToSectionAccountMaintenanceCharges(String sectionName) {
        step = test.createNode("Scroll to section: " + sectionName);
        waitForSeconds(2);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.accountMaintenanceChargesHeading));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            step.pass("Scrolled to section");
            attachScreenshot(step, "scrollToSection", true);
        } catch (Exception e) {
            step.fail("Scroll failed");
            attachScreenshot(step, "scrollToSection", false);
        }
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickChakraArrowLink() {
        step = test.createNode("Click Chakra Arrow Link");
        try {
            WebElement chakraArrow = wait.until(ExpectedConditions.elementToBeClickable(Locators.chakraArrowLink));
            chakraArrow.click();
            step.pass("Chakra arrow clicked");
            attachScreenshot(step, "clickChakraArrowLink", true);
        } catch (Exception e) {
            step.fail("Failed to click chakra arrow");
            attachScreenshot(step, "clickChakraArrowLink", false);
        }
    }

    public void clickChakraArrowLinkFail() {
        step = test.createNode("Click Chakra Arrow Link");
        try {
            WebElement chakraArrow = wait.until(ExpectedConditions.elementToBeClickable(Locators.chakraArrowLinkFail));
            chakraArrow.click();
            step.pass("Chakra arrow clicked");
            attachScreenshot(step, "clickChakraArrowLink", true);
        } catch (Exception e) {
            step.fail("Failed to click chakra arrow");
            attachScreenshot(step, "clickChakraArrowLink", false);
        }
    }

    public void verifyRedirectionToComparisonPage() {
        step = test.createNode("Verify Redirection to Comparison Page");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(Locators.compareAccountsHeadingsPopUp));
            step.pass("Redirected successfully to comparison pop-up");
            attachScreenshot(step, "verifyComparisonPage", true);
        } catch (AssertionError | TimeoutException e) {
            step.fail("Redirection failed. URL: " + driver.getCurrentUrl());
            attachScreenshot(step, "verifyComparisonPage", false);
        }
    }

    public void clickFirstCheckbox() {
        step = test.createNode("Click First Checkbox");
        try {
            WebElement checkbox1 = wait.until(ExpectedConditions.elementToBeClickable(Locators.checkbox1));
            checkbox1.click();
            step.pass("First checkbox clicked");
            attachScreenshot(step, "clickFirstCheckbox", true);
        } catch (Exception e) {
            step.fail("Failed to click first checkbox");
            attachScreenshot(step, "clickFirstCheckbox", false);
        }
    }

    public void clickSecondCheckbox() {
        step = test.createNode("Click Second Checkbox");
        try {
            WebElement checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(Locators.checkbox2));
            checkbox2.click();
            step.pass("Second checkbox clicked");
            attachScreenshot(step, "clickSecondCheckbox", true);
        } catch (Exception e) {
            step.fail("Failed to click second checkbox");
            attachScreenshot(step, "clickSecondCheckbox", false);
        }
    }

    public void clickCompareButton() {
        step = test.createNode("Click Compare Button");
        try {
            WebElement compareBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.compareButton));
            compareBtn.click();
            step.pass("Compare button clicked");
            attachScreenshot(step, "clickCompareButton", true);
        } catch (Exception e) {
            step.fail("Failed to click compare button");
            attachScreenshot(step, "clickCompareButton", false);
        }
    }

    public void verifyRedirectionToComparisonResultsPage() {
        step = test.createNode("Verify Redirection to Comparison Results Page");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(Locators.compareAccountsHeadingsRedirected));
            step.pass("Redirected successfully to comparison results page");
            attachScreenshot(step, "verifyComparisonResultsPage", true);
        } catch (AssertionError | TimeoutException e) {
            step.fail("Redirection failed. URL: " + driver.getCurrentUrl());
            attachScreenshot(step, "verifyComparisonResultsPage", false);
        }
    }

    public void verifyBusinessBasicAccountClosureFee() {
        step = test.createNode("Verify Business Basic Account Closure Fee");
        try {
            WebElement fee = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.businessBasicAccountClosureFee));
            Assert.assertTrue(fee.isDisplayed());
            step.pass("Business Basic Account closure fee displayed");
            attachScreenshot(step, "verifyBusinessBasicFee", true);
        } catch (AssertionError | TimeoutException e) {
            step.fail("Closure fee not displayed");
            attachScreenshot(step, "verifyBusinessBasicFee", false);
        }
    }

    public void verifyBusinessAdvantageAccountClosureFee() {
        step = test.createNode("Verify Business Advantage Account Closure Fee");
        try {
            WebElement fee = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.businessAdvantageAccountClosureFee));
            Assert.assertTrue(fee.isDisplayed());
            step.pass("Business Advantage Account closure fee displayed");
            attachScreenshot(step, "verifyBusinessAdvantageFee", true);
        } catch (AssertionError | TimeoutException e) {
            step.fail("Closure fee not displayed");
            attachScreenshot(step, "verifyBusinessAdvantageFee", false);
        }
    }

    public void closeBrowser() {
        step = test.createNode("Close Browser");
        if (driver != null) {
            driver.quit();
            driver = null;
            step.pass("Browser closed");
        } else {
            step.warning("Driver was null, browser not closed");
        }
    }

    private void attachScreenshot(ExtentTest currentStep, String methodName, boolean isPass) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String folderPath = System.getProperty("user.dir") + "/screenshots";
            File folder = new File(folderPath);
            if (!folder.exists()) folder.mkdirs();

            String status = isPass ? "PASS" : "FAIL";
            String fileName = methodName + "_" + status + "_" +
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
            String fullPath = folderPath + "/" + fileName;

            File dest = new File(fullPath);
            FileUtils.copyFile(src, dest);
            currentStep.addScreenCaptureFromPath("../screenshots/" + fileName);
        } catch (IOException e) {
            currentStep.warning("Screenshot capture failed: " + e.getMessage());
        } catch (WebDriverException e) {
            currentStep.warning("WebDriver error during screenshot capture: " + e.getMessage());
        }
    }
}
