

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.junit.Test
  public void test() throws Exception {
    driver.get(baseUrl + "/sac/cadastrocliente.xhtml;");
    driver.findElement(By.name("j_idt32:j_idt41")).clear();
    driver.findElement(By.name("j_idt32:j_idt41")).sendKeys("nestor");
    driver.findElement(By.name("j_idt32:j_idt45")).clear();
    driver.findElement(By.name("j_idt32:j_idt45")).sendKeys("124224");
    driver.findElement(By.name("j_idt32:j_idt49")).clear();
    driver.findElement(By.name("j_idt32:j_idt49")).sendKeys("458.754.456-95");
    driver.findElement(By.name("j_idt32:j_idt53")).clear();
    driver.findElement(By.name("j_idt32:j_idt53")).sendKeys("12/05/2018");
    driver.findElement(By.name("j_idt32:j_idt57")).clear();
    driver.findElement(By.name("j_idt32:j_idt57")).sendKeys("(48)3424-1488");
    driver.findElement(By.name("j_idt32:j_idt61")).clear();
    driver.findElement(By.name("j_idt32:j_idt61")).sendKeys("nestor@tedsdt.com");
    driver.findElement(By.name("j_idt32:j_idt65")).clear();
    driver.findElement(By.name("j_idt32:j_idt65")).sendKeys("rua Ps");
    driver.findElement(By.name("j_idt32:j_idt78")).clear();
    driver.findElement(By.name("j_idt32:j_idt78")).sendKeys("788885999956");
    driver.findElement(By.name("j_idt32:j_idt80")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
