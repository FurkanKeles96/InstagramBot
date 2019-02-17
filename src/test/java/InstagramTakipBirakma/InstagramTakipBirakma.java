/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstagramTakipBirakma;


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


public class InstagramTakipBirakma {
    
    String driverPath = "C:\\Users\\furkan\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe";
    public WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

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
        takipBirak();
        
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
    
    public void takipBirak() throws InterruptedException{
        
        takipEdilenleriAc();
        Thread.sleep(500);
        for(int i = 7; i<4410; i++){
            /*if(i==12){
                driver.navigate().refresh();
                takipEdilenleriAc();
                i=7;
                Thread.sleep(5000);
                //takipEdilenleriAc();
            }*/
            //else{
                driver.findElement(By.xpath("(//button[@type='button'])["+i+"]")).click();  //(//button[@type='button'])[7]
                Thread.sleep(3000);
                //driver.findElement(By.xpath("//div[4]/div/div/div/div[3]/button")).click();
                driver.findElement(By.cssSelector("button.aOOlW.-Cab_   ")).click();
                Thread.sleep(3000);
                
                /*//Find element by link text and store in variable "Element"        		
                WebElement Element = driver.findElement(By.cssSelector("button.aOOlW.-Cab_   "));
                

                //This will scroll the page till the element is found		
                js.executeScript("arguments[0].scrollIntoView();", Element);*/
                
                //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                
                //js.executeScript("arguments[0].scrollTop = arguments[1];",driver.findElement(By.xpath("//div[3]/div/div/div[2]")), 100);
            //}
            
        }
    }
    
    public void takipEdilenleriAc() throws InterruptedException{
        //driver.get("https://www.instagram.com/wallhero");
        
        driver.findElement(By.xpath("//span[@id='react-root']/section/nav/div[2]/div/div/div[3]/div/div[3]/a/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@id='react-root']/section/main/div/header/section/ul/li[3]/a")).click(); //Takip edilenleri açıyor.
        //driver.findElement(By.cssSelector(".Y8-fY:nth-child(3) > .-nal3")).click();
        Thread.sleep(5000);

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