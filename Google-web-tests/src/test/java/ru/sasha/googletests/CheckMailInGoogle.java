package ru.sasha.googletests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class CheckMailInGoogle {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://www.google.ru/");
        login("alexz198380@gmail.com", "Pf[fhjd321");

    }

    private void login(String username, String password) {
        wd.findElement(By.id("gb_70")).click();
        wd.findElement(By.id("identifierId")).click();
        wd.findElement(By.id("identifierId")).clear();
        wd.findElement(By.id("identifierId")).sendKeys(username);
        wd.findElement(By.id("identifierId")).click();
        wd.findElement(By.id("identifierId")).sendKeys("\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).sendKeys("\n");
    }

    @Test
    public void testCheckMailPageInGoogle() {
        gotoMailPage();

    }

    @Test
    public void testOpenLetterInMailBox () throws InterruptedException {
        gotoMailPage();
        openEmail();
        logOut();
    }

    private void openEmail() {
        wd.findElement(By.xpath("//td[@id=':55']/div/div/div/span[2]")).click();
    }

    private void logOut() {
        wd.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
        wd.findElement(By.xpath(".//*[@id='gb_71']")).click();
    }

    private void gotoMailPage() {
        wd.findElement(By.linkText("Почта")).click();
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
