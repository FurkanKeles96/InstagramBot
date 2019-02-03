package InstagramTakipEtme;

import static java.lang.Thread.sleep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InstagramTakipEtme {
    
    String driverPath = "C:\\Users\\furkan\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe";
    public WebDriver driver;
    

    @Before
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);

    }

    @Test
    public void navigateToUrl() throws InterruptedException {
        driver.get("https://www.instagram.com/");
        Thread.sleep(5000);
        girisYap();
        Thread.sleep(5000);
        kullaniciBilgileriDoldur();
        Thread.sleep(5000);
        takipEdilecekBul();
        
    }
    
    public void girisYap(){
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/article/div[2]/div[2]/p/a")).click();
        //[@id='react-root']/section/main/article/div[2]/div[2]/p/a
    }
    
    public void kullaniciBilgileriDoldur(){
        
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/article/div/div/div/form/div/div/div/input")).sendKeys("seleniumbotdeneme");
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/article/div/div/div/form/div[2]/div/div/input")).sendKeys("selenium123.");
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/article/div/div/div/form/div[3]/button")).click();
        
    }
    
    public void takipEdilecekBul() throws InterruptedException{
        driver.findElement(By.xpath(".//span[@id='react-root']/section/nav/div[2]/div/div/div[2]/input")).sendKeys("Beşiktaş");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//span[@id='react-root']/section/nav/div[2]/div/div/div[2]/div[2]/div[2]/div/a/div/div[2]/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/header/section/ul/li[2]/a")).click();
        Thread.sleep(5000);
        
        for(int i = 1; i<6; i++){
            driver.findElement(By.xpath("(//button[@type='button'])["+i+"]")).click();
            Thread.sleep(5000);
        }
    }
    
    /*public void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        
        
        
    }
    
    private static boolean isloadComplete(WebDriver driver)
    {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
                || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }*/

    /*@After
    public void endTest() {
        driver.quit();
    }*/
}