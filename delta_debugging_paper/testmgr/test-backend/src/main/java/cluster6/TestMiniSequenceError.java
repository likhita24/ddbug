package cluster6;

import helper.CancelOrderResult;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMiniSequenceError {
    @BeforeClass
    public void setUp() throws Exception {
        
    }

    @Test
    public void testLogin()throws Exception{

        RestTemplate restTemplate = new RestTemplate();

        
        CancelOrderResult result = restTemplate.getForObject(
                "http://10.141.211.161:30085/cancelOrder/5ad7750b-a68b-49c0-a8c0-32776b067703",
                CancelOrderResult.class);
      
        System.out.println("~~~~CancelOrderResult~~~~~ " + result.isStatus() +  "   "  + result.getMessage());
        Assert.assertEquals(result.isStatus() && result.getMessage().contains("Success.Processes Seq"),true);
    }


    @AfterClass
    public void tearDown() throws Exception {
    }
}
