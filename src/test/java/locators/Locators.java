package locators;

import org.openqa.selenium.By;

public class Locators {

    public static By compareAccountsHeadings = By.xpath("//p[text()='Account is right for you?']");
    public static By compareAccountsHeadingsPopUp = By.xpath("//header[text()='Compare Accounts']");
    public static By chakraArrowLink = By.xpath("(//div[@class='chakra-1ttamnv']//button[contains(@class,'chakra-')])");
    public static By chakraArrowLinkFail = By.xpath("(//div[@class='chakra-1ttamnvoooo']//button[contains(@class,'chakra-')])");

    public static By checkbox1 = By.xpath("(//label[contains(@class, 'chakra-checkbox')])[1]//span");

    public static By checkbox2 = By.xpath("(//label[contains(@class, 'chakra-checkbox')])[2]//span");

    public static By compareButton = By.xpath("//button[text()='Compare']");

    public static By compareAccountsHeadingsRedirected = By.xpath("//p[text()='Compare Accounts']");

    public static By accountMaintenanceChargesHeading = By.xpath("//p[text()='Account Maintenance Charges']");

    public static By businessBasicAccountClosureFee = By.xpath("//p[text()='AED 150']");

    public static By businessAdvantageAccountClosureFee = By.xpath("//p[text()='AED 250']");

}
