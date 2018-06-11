import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Test {
    public static void main(String[] args) {
        WebDriver driver = getDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("webinar.test@gmail.com");
        WebElement passwField = driver.findElement(By.id("passwd"));
        passwField.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement signInButton = driver.findElement(By.name("submitLogin"));
        signInButton.click();

        Actions action = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Каталог")));
        //Thread.sleep(2000);
        WebElement catalog = driver.findElement(By.linkText("Каталог"));
        //catalog.click();
        //Thread.sleep(1000);
        action.moveToElement(catalog).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("категории")));
        WebElement categories = driver.findElement(By.linkText("категории"));
        categories.click();

        WebElement addCategory = driver.findElement(By.id("page-header-desc-category-new_category"));
        addCategory.click();
        WebElement nameField = driver.findElement(By.id("name_1"));
        nameField.sendKeys("1TestCategory");
        nameField.submit();
        WebElement backButton = driver.findElement(By.id("desc-category-back"));
        backButton.click();
        //List<WebElement> filters = driver.findElements(By.xpath("//span[@class='title_box'][1]/a[2]"));
        //filters.get(3).click();
        WebElement filterButton = driver.findElement(By.xpath("(.//*[@class='title_box'])[2]/a[2]"));
        filterButton.click();
        //action.moveToElement(catalog).moveToElement(driver.findElement(By.linkText("категории"))).click().build().perform();


    }
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

}
