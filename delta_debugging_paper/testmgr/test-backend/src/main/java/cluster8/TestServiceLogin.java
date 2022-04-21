package cluster8;

import helper.LoginInfo;
import helper.LoginResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestServiceLogin {
    @BeforeClass
    public void setUp() throws Exception {
        //do nothing
        Thread.sleep(20000);
    }

    @Test
    public void testLogin()throws Exception{

        RestTemplate restTemplate = new RestTemplate();

        LoginInfo li = new LoginInfo();
        li.setPassword("DefaultPassword");
        li.setEmail("iitj_ms@iitj.ac.in");

        HttpHeaders headers = new HttpHeaders();
        List<String> cookies = new ArrayList<>();
        cookies.add("YsbCaptcha=233");
        headers.put(HttpHeaders.COOKIE,cookies);

        HttpEntity requestEntity = new HttpEntity(li, headers);
        ResponseEntity<LoginResult> r = restTemplate.exchange("http://10.141.211.179:30914/login", HttpMethod.POST, requestEntity, LoginResult.class);
        LoginResult result = r.getBody();
        System.out.println("~~~~LoginResult~~~~~ " + result.getMessage() );
        Assert.assertEquals(result.getMessage().contains("Success"),true);

    }


    @AfterClass
    public void tearDown() throws Exception {
    }
}
