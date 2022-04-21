package cluster4;

import helper.LoginInfo;
import helper.LoginResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestServiceLogin {
    @BeforeClass
    public void setUp() throws Exception {
        
        Thread.sleep(20000);
    }

    @Test
    public void testLogin()throws Exception{

        RestTemplate restTemplate = new RestTemplate();

        LoginInfo li = new LoginInfo();
        li.setPassword("DefaultPassword");
        li.setEmail("fdse_microservices@163.com");

        HttpHeaders headers = new HttpHeaders();
        List<String> cookies = new ArrayList<>();
        cookies.add("YsbCaptcha=233");
        headers.put(HttpHeaders.COOKIE,cookies);

        HttpEntity requestEntity = new HttpEntity(li, headers);
        
        ResponseEntity<LoginResult> r = restTemplate.exchange("http://10.141.211.174:31112/login", HttpMethod.POST, requestEntity, LoginResult.class);
        LoginResult result = r.getBody();
      
        System.out.println("~~~~LoginResult~~~~~ " + result.getMessage() );
        Assert.assertEquals(result.getMessage().contains("Success"),true);

    }


    @AfterClass
    public void tearDown() throws Exception {
    }
}
