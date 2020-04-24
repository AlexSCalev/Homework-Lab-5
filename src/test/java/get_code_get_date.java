import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class get_code_get_date {
    public static final String BASE_ENDPOINT = "https://api.github.com";
    CloseableHttpClient client;
    CloseableHttpResponse response;
    @BeforeMethod
    public void setup(){
        client = HttpClientBuilder.create().build();
    }
    @AfterMethod
    public void clouse_all() throws IOException {
        client.close();
    }
    @Test
    public void test_get200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/events");

        HttpResponse response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatus, 200);
    }
    @Test
    public void test_get400() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/authorizations");

        HttpResponse response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatus,401);
    }

    @Test
    public void test_get404() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/nonExistingName");
        HttpResponse response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatus,404);

    }
    @Test
    public  void test_length () throws IOException {
        HttpGet get = new HttpGet("https://api.github.com/user");
        HttpResponse response = client.execute(get);

        Header actualHeader = response.getFirstHeader("Content-Length");


        Assert.assertNotEquals(actualHeader.getValue().length(),0);
    }

    @Test
    public  void test_content_value() throws IOException {
        HttpGet get = new HttpGet("https://api.github.com/user");
        HttpResponse response = client.execute(get);

        Header actualHeader = response.getFirstHeader("Content-Length");

        Assert.assertEquals(actualHeader.getValue(),"125");
    }

}
