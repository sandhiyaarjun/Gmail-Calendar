package demo;

import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60L));
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        String url = driver.getCurrentUrl();
        if (url.contains("calendar.")) {
            System.out.println("The URL of the Calendar homepage contains \"calendar\".");
        } else {
            System.out.println("The URL of the Calendar homepage does not contains \"calendar\".");
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@jsname='WjL7X']/div")).click();
       WebElement monthEle = driver.findElement(By.xpath("//span[text()='Month']"));
        monthEle.click();
        String monthEleText = monthEle.getText();
        if (monthEleText.equals("Month")) {
            System.out.println("Switched to Month View");
        } else {
            System.out.println("Not Switched to Month View");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='15']")).click();
        driver.findElement(By.xpath("//div[@class='mr0WL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Task']")).click();
        // driver.findElement(By.xpath("//input[@fdprocessedid='p3tlzd']")).click();
        Thread.sleep(2000);
        WebElement titleElement = driver.findElement(By.xpath("//input[@aria-label='Add title']"));
        // titleElement.click();
        titleElement.sendKeys("Crio INTV Task Automation");
        Thread.sleep(2000);
        WebElement discriptionEle = driver.findElement(By.xpath("//textarea[@aria-label='Add description']"));
        discriptionEle.click();
        discriptionEle.sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();
        Thread.sleep(6000);

        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://calendar.google.com/");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[contains(@class,'c jKgTF')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@jsaction='JIbuQc:DyVDA']")).click();
        Thread.sleep(2000);
        WebElement textareabox = driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']"));
        textareabox.click();
        textareabox.clear();
        textareabox.sendKeys(
                "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
	Thread.sleep(2000);
        String description = textareabox.getText();
        if (description.contains("web application")) {
            System.out.println("The task description is successfully updated and displayed");
        } else {
            System.out.println("The task description is not updated ");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();
        Thread.sleep(6000);

        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://calendar.google.com/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[contains(@class,'c jKgTF')]")).click();
        Thread.sleep(2000);
	WebElement taskTitle = driver.findElement(By.xpath("//div[@class='toUqff ']/span"));
        String title = taskTitle.getText();
        if (title.equals("Crio INTV Task Automation")) {
            System.out.println("task title is verified");
        } else {
            System.out.println("Task title is not verified");
        }
        driver.findElement(By.xpath("//div[@jsaction='JIbuQc:qAGoT']")).click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
        String taskDltMsg = message.getText();
        if (taskDltMsg.equals("Task deleted")) {
            System.out.println("The task is successfully deleted");
        } else {
            System.out.println("The task not deleted");
        }

    }
}

// package demo;

// import java.util.concurrent.TimeUnit;

// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeDriverService;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.logging.LogType;
// import org.openqa.selenium.logging.LoggingPreferences;
// import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import java.time.Duration;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;

// public class TestCases {
//     ChromeDriver driver;

//     public TestCases() {
//         System.out.println("Constructor: TestCases");

//         WebDriverManager.chromedriver().timeout(30).setup();
//         ChromeOptions options = new ChromeOptions();
//         LoggingPreferences logs = new LoggingPreferences();

//         // Set log level and type
//         logs.enable(LogType.BROWSER, Level.INFO);
//         logs.enable(LogType.DRIVER, Level.ALL);
//         options.setCapability("goog:loggingPrefs", logs);

//         // Connect to the chrome-window running on debugging port
//         options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

//         // Set path for log file
//         System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

//         driver = new ChromeDriver(options);

//         // Set browser to maximize and wait
//         driver.manage().window().maximize();
//         // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//     }

//     public void endTest() {
//         System.out.println("End Test: TestCases");
//         driver.close();
//         driver.quit();

//     }

//     public void testCase01() {
//         System.out.println("Start Test case: testCase01");
//         driver.get("https://calendar.google.com/");
//         String url = driver.getCurrentUrl();
//         if (url.contains("calendar.")) {
//             System.out.println("The URL of the Calendar homepage contains \"calendar\".");
//         } else {
//             System.out.println("The URL of the Calendar homepage does not contains \"calendar\".");
//         }
//         System.out.println("end Test case: testCase01");
//     }


//     // public void testCase01() throws InterruptedException {
//     //     System.out.println("Start Test case: testCase01");
//     //     driver.get("https://calendar.google.com/");
//     //     String title = driver.getCurrentUrl();
//     //     String expected = "calendar";
//     //     if (title.contains(expected)) {
//     //         System.out.println("Title contains " + expected);
//     //     }
//     //     System.out.println("end Test case: testCase01");
//     // }

//     public void testCase02() throws InterruptedException {
//         System.out.println("Start Test case: testCase02");
//         driver.get("https://calendar.google.com/");
//         Thread.sleep(3000);
//         driver.findElement(By.xpath("//div[@jsname='WjL7X']/div")).click();
//        WebElement monthEle = driver.findElement(By.xpath("//span[text()='Month']"));
//         monthEle.click();
//         String monthEleText = monthEle.getText();
//         if (monthEleText.equals("Month")) {
//             System.out.println("Switched to Month View");
//         } else {
//             System.out.println("Not Switched to Month View");
//         }
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//div[text()='15']")).click();
//         driver.findElement(By.xpath("//div[@class='mr0WL']")).click();
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//div[text()='Task']")).click();
//         // driver.findElement(By.xpath("//input[@fdprocessedid='p3tlzd']")).click();
//         Thread.sleep(2000);
//         WebElement titleElement = driver.findElement(By.xpath("//input[@aria-label='Add title']"));
//         // titleElement.click();
//         titleElement.sendKeys("Crio INTV Task Automation");
//         Thread.sleep(2000);
//         WebElement discriptionEle = driver.findElement(By.xpath("//textarea[@aria-label='Add description']"));
//         discriptionEle.click();
//         discriptionEle.sendKeys("Crio INTV Calendar Task Automation");
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();
//         Thread.sleep(6000);

//         System.out.println("end Test case: testCase02");
//     }

//     public void testCase03() throws InterruptedException {
//         System.out.println("Start Test case: testCase03");
//         driver.get("https://calendar.google.com/");
//         Thread.sleep(5000);

//         driver.findElement(By.xpath("//div[contains(@class,'c jKgTF')]")).click();
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//div[@jsaction='JIbuQc:DyVDA']")).click();
//         Thread.sleep(2000);
//         WebElement textareabox = driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']"));
//         textareabox.click();
//         textareabox.clear();
//         textareabox.sendKeys(
//                 "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
// 	Thread.sleep(2000);
//         String description = textareabox.getText();
//         if (description.contains("web application")) {
//             System.out.println("The task description is successfully updated and displayed");
//         } else {
//             System.out.println("The task description is not updated ");
//         }
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();
//         Thread.sleep(6000);

//         System.out.println("end Test case: testCase03");
//     }

//     public void testCase04() throws InterruptedException {
//         System.out.println("Start Test case: testCase04");
//         driver.get("https://calendar.google.com/");
//         Thread.sleep(2000);

//         driver.findElement(By.xpath("//div[contains(@class,'c jKgTF')]")).click();
//         Thread.sleep(2000);
// 	WebElement taskTitle = driver.findElement(By.xpath("//div[@class='toUqff ']/span"));
//         String title = taskTitle.getText();
//         if (title.equals("Crio INTV Task Automation")) {
//             System.out.println("task title is verified");
//         } else {
//             System.out.println("Task title is not verified");
//         }
//         driver.findElement(By.xpath("//div[@jsaction='JIbuQc:qAGoT']")).click();
//         Thread.sleep(2000);
//         WebElement message = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
//         String taskDltMsg = message.getText();
//         if (taskDltMsg.equals("Task deleted")) {
//             System.out.println("The task is successfully deleted");
//         } else {
//             System.out.println("The task not deleted");
//         }
//     }


// }
