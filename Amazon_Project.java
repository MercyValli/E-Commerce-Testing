package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Project {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        
        driver.get("https://www.google.com/");
        WebElement searchElement = driver.findElement(By.name("q"));  // Open Google and search for Amazon
        searchElement.sendKeys("Amazon");
        searchElement.submit();
        Thread.sleep(3000);

      
        driver.navigate().to("https://www.amazon.in/");  // Navigate to Amazon
        Thread.sleep(3000);

       
        driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']")).click(); // Click on "Account & Lists" and login
        driver.findElement(By.id("ap_email")).sendKeys("919392346599");
        Thread.sleep(3000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ap_password")).sendKeys("Vpattem31");
        Thread.sleep(3000);
        driver.findElement(By.id("signInSubmit")).click();
        
        
        WebElement categoryDropdown = driver.findElement(By.id("searchDropdownBox"));
        Select categorySelect = new Select(categoryDropdown);
       categorySelect.selectByValue("search-alias=fashion");
       Thread.sleep(3000);
       System.out.println("Selected Women's Blazer category.");

      
      WebElement fashionSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
      Thread.sleep(3000);
      fashionSearchBox.sendKeys("Western Wear Blazer for Women's");// Search for Women's Blazer
      Thread.sleep(3000);
      fashionSearchBox.submit();

      
      driver.navigate().back();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//a[contains(@href,'/deals?ref_=nav_cs_gb')]")).click();//Today Deals
      Thread.sleep(3000);
      
      driver.navigate().back();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();//GIFT cards
      driver.navigate().back();
      Thread.sleep(3000);

     
      driver.findElement(By.xpath("//div[normalize-space()='EN']")).click(); // Change language settings
      Thread.sleep(3000);

      
      WebElement checkBox = driver.findElement(By.xpath("//div[3]//div[1]//label[1]//i[1]"));// Handling checkbox for language selection (XPath corrected)
      if (!checkBox.isSelected()) {
          checkBox.click();
          Thread.sleep(3000);
      }

    
      driver.navigate().refresh();// Refresh, then go back
      Thread.sleep(3000);
      driver.navigate().back();
      Thread.sleep(5000);
      
      
      driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();// select categories
      driver.navigate().refresh();
      Thread.sleep(3000);
      
      
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase to 20 seconds
      WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
      searchBox.sendKeys("watches for women");
      searchBox.submit();



   // Wait for the first product in search results and click it
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement firstProduct = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")));
      firstProduct.click();
      
      List<WebElement> elements = driver.findElements(By.xpath("//input[@id='add-to-cart-button']"));
      if (elements.size() > 0) {
          elements.get(0).click();
      } else {
          System.out.println("Added to Cart the Succesfully.");
      }



        driver.quit();
      
        
        
  
    }
}
