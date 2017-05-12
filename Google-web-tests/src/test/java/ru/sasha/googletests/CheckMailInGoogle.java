package ru.sasha.googletests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class CheckMailInGoogle {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://www.google.ru/");
        wd.findElement(By.id("gb_70")).click();
        wd.findElement(By.id("identifierId")).click();
        wd.findElement(By.id("identifierId")).clear();
        wd.findElement(By.id("identifierId")).sendKeys("alexz198380@gmail.com");
        wd.findElement(By.id("identifierId")).click();
        wd.findElement(By.id("identifierId")).sendKeys("\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("Pf[fhjd321");
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).sendKeys("\n");

    }
    
    @Test
    public void testCheckMailInGoogle() {
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
