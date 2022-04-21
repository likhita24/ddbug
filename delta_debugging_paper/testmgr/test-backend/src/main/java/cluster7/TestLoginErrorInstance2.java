package cluster7;

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

public class TestLoginErrorInstance2 {


    @BeforeClass
    public void setUp() throws Exception {
    
        Thread.sleep(2000);
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
      
        ResponseEntity<LoginResult> r = restTemplate.exchange("http://10.141.211.162:30118/login",HttpMethod.POST, requestEntity, LoginResult.class);
        LoginResult result = r.getBody();
     
        System.out.println("~~~~LoginResult~~~~~ " + result.getMessage() );
        Assert.assertEquals(result.getMessage().contains("Success"),true);
        int loginNum = result.getLoginNum();
        if(loginNum > 0){
            ResponseEntity<LoginResult> r2 = restTemplate.exchange("http://10.141.211.162:30118/login",HttpMethod.POST, requestEntity, LoginResult.class);
            ResponseEntity<LoginResult> r3 = restTemplate.exchange("http://10.141.211.162:30118/login",HttpMethod.POST, requestEntity, LoginResult.class);
            ResponseEntity<LoginResult> r4 = restTemplate.exchange("http://10.141.211.162:30118/login",HttpMethod.POST, requestEntity, LoginResult.class);
            result = r4.getBody();
            Assert.assertEquals(result.getLoginNum(), loginNum+3);
            System.out.println(result.getLoginNum() + " VS " + (loginNum+3));
        } else {
            throw new Exception("get login number failed!");
        }
    }


    @AfterClass
    public void tearDown() throws Exception {
    }


}
