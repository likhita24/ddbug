package cluster7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBookErrorConfig {
    private WebDriver driver;
    private String trainType;
    private String baseUrl;
    public static void login(WebDriver driver,String username,String password){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.id("flow_one_page")));
        driver.findElement(By.id("flow_one_page")).click();
        driver.findElement(By.id("flow_preserve_login_email")).clear();
        driver.findElement(By.id("flow_preserve_login_email")).sendKeys(username);
        driver.findElement(By.id("flow_preserve_login_password")).clear();
        driver.findElement(By.id("flow_preserve_login_password")).sendKeys(password);
        driver.findElement(By.id("flow_preserve_login_button")).click();
    }
    
    public static String getRandomString(int length) {
        
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }
    @BeforeClass
    public void setUp() throws Exception {

        driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"),
                DesiredCapabilities.chrome());
        baseUrl = "http://10.141.211.162:30118";
        trainType = "0";//all
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
  
    public void testLogin()throws Exception{
        driver.get(baseUrl + "/");

  
        String username = "fdse_microservices@163.com";
        String password = "DefaultPassword";


        Thread.sleep(30000);
        login(driver,username,password);
        Thread.sleep(10000);
        if( !getLoginStatus()){
            Thread.sleep(5000);
            System.out.println("#### Oh! Give me one more time! ##########");
            login(driver,username,password);
            Thread.sleep(20000);
            if( !getLoginStatus()){
                Thread.sleep(5000);
                System.out.println("#### Oh! Give me the second time! ##########");
                login(driver,username,password);
                Thread.sleep(20000);
            }
        }


        String statusLogin = driver.findElement(By.id("flow_preserve_login_msg")).getText();
        if("".equals(statusLogin))
            System.out.println("Failed to Login! Status is Null!");
        else if(statusLogin.startsWith("Success"))
            System.out.println("Success to Login! Status:"+statusLogin);
        else
            System.out.println("Failed to Login! Status:"+statusLogin);
        Assert.assertEquals(statusLogin.startsWith("Success"),true);
    }

    @Test (dependsOnMethods = {"testLogin"})
 
    public void testBooking() throws Exception{
  
        WebElement elementBookingStartingPlace = driver.findElement(By.id("travel_booking_startingPlace"));
        elementBookingStartingPlace.clear();
        elementBookingStartingPlace.sendKeys("Shang Hai");


        WebElement elementBookingTerminalPlace = driver.findElement(By.id("travel_booking_terminalPlace"));
        elementBookingTerminalPlace.clear();
        elementBookingTerminalPlace.sendKeys("Su Zhou");

        String bookDate = "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar newDate = Calendar.getInstance();
        Random randDate = new Random();
        int randomDate = randDate.nextInt(26);
        newDate.add(Calendar.DATE, randomDate+5);
        bookDate=sdf.format(newDate.getTime());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('travel_booking_date').value='"+bookDate+"'");



        WebElement elementBookingTraintype = driver.findElement(By.id("search_select_train_type"));
        Select selTraintype = new Select(elementBookingTraintype);
        selTraintype.selectByValue(trainType); //ALL

 
        WebElement elementBookingSearchBtn = driver.findElement(By.id("travel_booking_button"));
        elementBookingSearchBtn.click();
        Thread.sleep(30000);

        List<WebElement> ticketsList = driver.findElements(By.xpath("//table[@id='tickets_booking_list_table']/tbody/tr"));
   
        if (ticketsList.size() == 0) {
            elementBookingSearchBtn.click();
            ticketsList = driver.findElements(By.xpath("//table[@id='tickets_booking_list_table']/tbody/tr"));
        }
        if(ticketsList.size() > 0) {
          
            System.out.printf("Success to search tickets，the tickets list size is:%d%n",ticketsList.size());

        }
        else
            System.out.println("Tickets search failed!!!");
        Assert.assertEquals(ticketsList.size() > 0,true);
    }

    private boolean getLoginStatus(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.id("flow_preserve_login_msg")));
        String statusLogin = driver.findElement(By.id("flow_preserve_login_msg")).getText();
        if("".equals(statusLogin))
            System.out.println("Failed to Login! Status is Null!");
        else if(statusLogin.startsWith("Success"))
            System.out.println("Success to Login! Status:"+statusLogin);
        else
            System.out.println("Failed to Login! Status:"+statusLogin);

        if(statusLogin.startsWith("Success")){
            return true;
        } else {
            return false;
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

}
