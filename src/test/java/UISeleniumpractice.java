
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class UISeleniumpractice {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    WebDriver driver;

    @BeforeMethod
    public void testSetup() throws Exception {


        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver",path+"\\src\\test\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(2000);

    }
    @AfterMethod
    public void testEnd() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void Testcase01(){

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

driver.findElement(By.xpath("//a[@class='login']"))
        .click();

WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
email.sendKeys("testautomationselenium2020@gmail.com");
password.sendKeys("!Qwerty123");

driver.findElement(By.xpath("//button[@id='SubmitLogin']"))
        .click();

boolean username = driver.findElement(By.xpath("//span[contains(text(),'Test Selenium')]")).isDisplayed();
Assert.assertTrue(username);

driver.findElement(By.xpath("//i[@class='icon-user']"))
        .click();

String firstname = driver.findElement(By.xpath("//input[@id='firstname']"))
        .getAttribute("value");

String expectedfirstname = "Test";

        Assert.assertEquals(firstname,expectedfirstname, "Verify Firstname");

String lastname = driver.findElement(By.xpath("//input[@id='lastname']"))
        .getAttribute("value");

String expectedlastname = "Selenium";

        Assert.assertEquals(lastname,expectedlastname, "Verify Lastname");

driver.findElement(By.xpath("//a[@class='logout']"))
        .click();

boolean exists = driver.findElement(By.xpath("//a[@class='login']"))
        .isDisplayed();

Assert.assertTrue(exists, "Successfully signed out.");

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static int getRandomNumberInBetween(int lowerBound, int upperBound) {
        Random r = new Random();
        return (r.nextInt(upperBound) + lowerBound);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void Testcase02(){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@class='login']"))
                .click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        email.sendKeys("testautomationselenium2020@gmail.com");
        password.sendKeys("!Qwerty123");

        driver.findElement(By.xpath("//button[@id='SubmitLogin']"))
                .click();

        String signInCheck = driver.findElement(By.xpath("//span[contains(text(),'Test Selenium')]"))
                .getText();

        Assert.assertEquals(signInCheck, "Test Selenium");

        driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"))
                .click();

        driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//span[contains(text(),'More')]"))
                .click();

        driver.findElement(By.xpath("//span[@class='span_link no-print']"))
                .click();

        driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']"))
                .click();

        List<WebElement> size = driver.findElements(By.cssSelector("select#group_1>option"));
        size.get(getRandomNumberInBetween(1, size.size() - 1))
                .click();

        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"))
                .click();

        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']//span[1]"))
                .click();

        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//b[contains(text(),'Cart')]"));
        action.moveToElement(element)
                .perform();

        driver.findElement(By.xpath("//span[contains(text(),'Check out')]")).click();

        String availability = driver.findElement(By.xpath("//span[@class='label label-success']"))
                .getText();

        Assert.assertEquals(availability, "In stock");

        driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();

        String nameSurname = driver.findElement(By.xpath("//li[@class='address_firstname address_lastname']"))
                .getText();

        String address = driver.findElement(By.xpath("//li[@class='address_address1 address_address2']"))
                .getText();

        String city = driver.findElement(By.xpath("//li[@class='address_city address_state_name address_postcode']"))
                .getText();

        String country = driver.findElement(By.xpath("//li[@class='address_country_name']"))
                .getText();

        String phoneNumber = driver.findElement(By.xpath("//li[@class='address_phone_mobile']"))
                .getText();

        Assert.assertEquals(nameSurname, "Test Selenium");
        Assert.assertEquals(address, "Random Address 11");
        Assert.assertEquals(city, "Random, Nevada 11200");
        Assert.assertEquals(country, "United States");
        Assert.assertEquals(phoneNumber, "060111111");

        driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]"))
                .click();

        driver.findElement(By.xpath("//input[@id='cgv']"))
                .click();

        driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]"))
                .click();

        Assert.assertEquals(availability, "In stock");

        driver.findElement(By.xpath("//a[@class='bankwire']"))
                .click();

        driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"))
                .click();

        String orderComplete = driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]"))
                .getText();

        Assert.assertEquals(orderComplete, "Your order on My Store is complete.");

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String getrandomchar(int charnumber) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder rng = new StringBuilder();
        Random rnd = new Random();
        while (rng.length() < charnumber) {
            int index = (int) (rnd.nextFloat() * chars.length());
            rng.append(chars.charAt(index));
        }
        String grc = rng.toString();
        return grc;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void Testcase03(){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]"));
        action.moveToElement(element)
                .perform();

        driver.findElement(By.xpath("//li[@class='sfHover']//a[contains(text(),'Evening Dresses')]"))
                .click();

        driver.findElement(By.xpath("//i[@class='icon-eye-open']"))
                .click();

        driver.findElement(By.xpath("//div[@class='fancybox-wrap fancybox-desktop fancybox-type-iframe fancybox-opened']"))
                .click();

        List<WebElement> size = driver.findElements(By.cssSelector("select#group_1>option"));
        size.get(getRandomNumberInBetween(1, size.size() - 1))
                .click();

        driver.findElement(By.xpath("//a[@id='color_24']"))
                .click();

        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"))
                .click();

        driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='clearfix']"))
                .click();

        String quantity = driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']"))
                .getText();

        Assert.assertEquals(quantity, "1");

        driver.findElement(By.xpath(" //span[contains(text(),'Proceed to checkout')]"))
                .click();

        String availability = driver.findElement(By.xpath("//span[@class='label label-success']"))
                .getText();

        Assert.assertEquals(availability, "In stock");

        driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]"))
                .click();

        WebElement register = driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]"));

        Assert.assertTrue(register.isDisplayed());

        driver.findElement(By.xpath("//input[@id='email_create']"))
                .sendKeys(getrandomchar(10) + "@testemail.com");

        driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]"))
                .click();

        driver.findElement(By.xpath("//input[@id='id_gender1']"))
                .click();

        driver.findElement(By.xpath("//input[@id='customer_firstname']"))
                .sendKeys("John");

        driver.findElement(By.xpath("//input[@id='customer_lastname']"))
                .sendKeys("Doe");

        driver.findElement(By.xpath("//input[@id='passwd']"))
                .sendKeys(getrandomchar(5));

        List<WebElement> calendarDay = driver.findElements(By.cssSelector("select#days>option"));
        calendarDay.get(getRandomNumberInBetween(1, calendarDay.size() - 1)).click();

        List<WebElement> calendarMonth = driver.findElements(By.cssSelector("select#months>option"));
        calendarMonth.get(getRandomNumberInBetween(1, calendarMonth.size() - 1)).click();

        List<WebElement> calendarYear = driver.findElements(By.cssSelector("select#years>option"));
        calendarYear.get(getRandomNumberInBetween(1, calendarYear.size() - 1)).click();

        driver.findElement(By.xpath("//input[@id='newsletter']"))
                .click();

        driver.findElement(By.xpath("//input[@id='optin']"))
                .click();

        driver.findElement(By.xpath("//input[@id='firstname']"))
                .sendKeys("John");

        driver.findElement(By.xpath("//input[@id='lastname']"))
                .sendKeys("Doe");

        driver.findElement(By.xpath("//input[@id='address1']"))
                .sendKeys("Test Address 123");

        driver.findElement(By.xpath("//input[@id='city']"))
                .sendKeys("Test City");

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        dropdown.selectByValue(("32"));

        driver.findElement(By.xpath("//input[@id='postcode']"))
                .sendKeys("12345");

        driver.findElement(By.xpath("//input[@id='phone_mobile']"))
                .sendKeys("123456789");

        driver.findElement(By.xpath("//input[@id='alias']"))
                .sendKeys("Test Address 123");

        driver.findElement(By.xpath("//span[contains(text(),'Register')]"))
                .click();

        driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]"))
                .click();

        driver.findElement(By.xpath("//input[@id='cgv']"))
                .click();

        driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]"))
                .click();

        Assert.assertEquals(availability, "In stock");

        driver.findElement(By.xpath("//a[@class='bankwire']")).click();

        driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();

        String orderComplete = driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]"))
                .getText();

        Assert.assertEquals(orderComplete, "Your order on My Store is complete.");


    }

}

