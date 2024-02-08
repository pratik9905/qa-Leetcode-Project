package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    @SuppressWarnings("deprecation")
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String actualUrl = driver.getCurrentUrl();
        String Expected = "leetcode";
        if(actualUrl.contains(Expected)){
            System.out.println(Expected);
        }
        System.out.println("end Test case: testCase01");
    }


    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement problemsetLink = driver.findElement(By.xpath("//a[@href='/problemset/']//p[@class='link']"));
        js.executeScript("arguments[0].scrollIntoView();", problemsetLink);
        problemsetLink.click();
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "problemset";
        if(ActualUrl.contains(ExpectedUrl)){
            System.out.println(ExpectedUrl);
        }
        List<WebElement> problemList = driver.findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));

        for(int i=1;i<=5;i++){
            System.out.println(problemList.get(i).getText());
        }
        problemList.get(1).click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Two Sum";
        if(actualTitle.contains(expectedTitle)){
            System.out.println(expectedTitle);
        }
        
        System.out.println("end Test case: testCase02");
    }


    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        String actualUrl = driver.getCurrentUrl();
        String expecteddUrl = "two-sum";

        if(actualUrl.contains(expecteddUrl)){
            System.out.println(expecteddUrl);
        }

        
        System.out.println("end Test case: testCase03");
    }


    public void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        Thread.sleep(5000);
        driver.findElement(By.id("submissions_tab")).click();
      String notRegister = driver.findElement(By.xpath("//a[contains(text(),'Register or Sign In')]")).getText();
        if(notRegister.contains("Register or Sign In")){
            System.out.println("First Sign In then submit");
        }

        System.out.println("end Test case: testCase04");
    }


}
