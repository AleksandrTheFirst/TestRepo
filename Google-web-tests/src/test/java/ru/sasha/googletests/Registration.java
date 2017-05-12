package ru.sasha.googletests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.sasha.googletests.NewAndConfirmPass;

public class Registration {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void Registration() {
        wd.get("https://accounts.google.com/Signup?hl=ru");
        fillFirstName("Test");
        fillLastName("Test2");
        fillNewGmailAccountField("testtesttest");
        createAndConfirmPassword(new NewAndConfirmPass("111222333111", "111222333111"));
        birthdayDate("11", "2000", "'февраль'");
        selectGender();
        submitRegister();
        confirmRegister();

    }

    private void confirmRegister() {
        wd.findElement(By.cssSelector("img.tos-scroll-button-icon")).click();
        wd.findElement(By.id("iagreebutton")).click();
    }

    private void selectGender() {
        wd.findElement(By.xpath("//div[@id='Gender']/div[1]")).click();
        wd.findElement(By.id(":f")).click();
    }

    private void submitRegister() {
        wd.findElement(By.id("submitbutton")).click();
    }

    private void createAndConfirmPassword(NewAndConfirmPass newAndConfirmPass) {
        wd.findElement(By.id("Passwd")).click();
        wd.findElement(By.id("Passwd")).clear();
        wd.findElement(By.id("Passwd")).sendKeys(newAndConfirmPass.getPass());
        wd.findElement(By.id("PasswdAgain")).click();
        wd.findElement(By.id("PasswdAgain")).clear();
        wd.findElement(By.id("PasswdAgain")).sendKeys(newAndConfirmPass.getPassAgain());
    }

    private void fillNewGmailAccountField(String accountName) {
        wd.findElement(By.id("GmailAddress")).click();
        wd.findElement(By.id("GmailAddress")).clear();
        wd.findElement(By.id("GmailAddress")).sendKeys(accountName);
    }

    private void fillLastName(String larstName) {
        wd.findElement(By.id("LastName")).click();
        wd.findElement(By.id("LastName")).clear();
        wd.findElement(By.id("LastName")).sendKeys(larstName);
    }

    private void fillFirstName(String fistName) {
        wd.findElement(By.id("FirstName")).click();
        wd.findElement(By.id("FirstName")).clear();
        wd.findElement(By.id("FirstName")).sendKeys(fistName);
    }

    private void birthdayDate(String dd, String yyyy, final String month) {
        wd.findElement(By.id("birthday-placeholder")).click();
        wd.findElement(By.id("BirthDay")).click();
        wd.findElement(By.id("BirthDay")).clear();
        wd.findElement(By.id("BirthDay")).sendKeys(dd);
        wd.findElement(By.xpath("//div[@id=':2']//div[.=" + month + "]")).click();
        wd.findElement(By.id("BirthYear")).click();
        wd.findElement(By.id("BirthYear")).clear();
        wd.findElement(By.id("BirthYear")).sendKeys(yyyy);
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
