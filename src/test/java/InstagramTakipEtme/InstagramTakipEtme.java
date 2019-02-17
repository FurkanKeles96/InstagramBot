package InstagramTakipEtme;


/**
 *
 * @author furkan
 * 
 * Instagram'da ilk olarak kullanıcı adı ve şifre verilerek giriş yapılması sağlanıyor.
 * Sonrasında istenilen sayfa adına göre arama yapılıp ilk sonuca tıklanıyor.
 * O sayfadaki takipçiler ekranına gidip teker teker takip et butonlarına tıklıyor.
 * 
 */

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
    
    String driverPath = "C:\\Users\\furkan\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe"; //Bilgisayarınızdaki gecko driver path'ini yazmalısınız.
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
        
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/article/div/div/div/form/div/div/div/input")).sendKeys("[UserName]");
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/article/div/div/div/form/div[2]/div/div/input")).sendKeys("[Password]");
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/article/div/div/div/form/div[3]/button")).click();
        
    }
    
    public void takipEdilecekBul() throws InterruptedException{
        driver.findElement(By.xpath(".//span[@id='react-root']/section/nav/div[2]/div/div/div[2]/input")).sendKeys("Wallhero"); //Gidilecek sayfanın adı
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//span[@id='react-root']/section/nav/div[2]/div/div/div[2]/div[2]/div[2]/div/a/div/div[2]/span")).click(); 
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//span[@id='react-root']/section/main/div/header/section/ul/li[2]/a")).click();//O sayfanın takipçileri olan ekranı açıyor.
        Thread.sleep(5000);
        
        for(int i = 7; i<60; i++){
            driver.findElement(By.xpath("(//button[@type='button'])["+i+"]")).click(); //Sırayla takip et butonlarına basıyor. Instagram bir süre sonra engelliyor.
            Thread.sleep(50);
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