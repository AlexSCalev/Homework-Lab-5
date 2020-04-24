
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;

public class author_set_post_delete_post {
    final String BASEPOINT = "https://api.github.com";
    private final CloseableHttpClient client = HttpClients.createDefault();

//    @Test
//    public void createRepo() throws AuthenticationException, IOException {
//        HttpPost post = new HttpPost(BASEPOINT+"/user/repos");
//        UsernamePasswordCredentials logut = new UsernamePasswordCredentials(new UserDate().getLogin(),new UserDate().getPassword());
//        post.addHeader(new BasicScheme().authenticate(logut,post,null));
//
//        String json = "{\n"
//                + "\t\"name\": \"kiss\",\n"
//                + "\t\"description\": \"repo\"\n"
//                + "}";
//
//        StringEntity entity = new StringEntity(json);
//        post.setEntity(entity);
//        post.setHeader("Accept","application/json");
//        post.setHeader("Content-type","application/json");
//
//        Assert.assertEquals(client.execute(post).getStatusLine().getStatusCode(),201);
//        client.close();
//    }

//    @Test
//    public void delateRepo() throws AuthenticationException, IOException {
////        Set in HttpDelete link in format {DELETE /repos/:owner/:repo}
//        HttpDelete delete = new HttpDelete(this.BASEPOINT+"/repos/AlexSCalev/kiss");
//        UsernamePasswordCredentials logout = new UsernamePasswordCredentials(new UserDate().getLogin(),new UserDate().getPassword());
//        delete.addHeader(new BasicScheme().authenticate(logout,delete,null));
//        delete.setHeader("Accept","application/json");
//        delete.setHeader("Content-type","application/json");
//
//        Assert.assertEquals(client.execute(delete).getStatusLine().getStatusCode(),204);
//    }

    @Test
    public void getDateUser() throws IOException {
//        Set your name if want get body github(/users/:username)
        HttpGet userDate=new HttpGet(this.BASEPOINT+"/users/AlexSCalev");
        String bodyElement = EntityUtils.toString(client.execute(userDate).getEntity());
        Gson gson = new Gson();
        readBody read = gson.fromJson(bodyElement,readBody.class);
        System.out.println(read.getId());
        System.out.println(read.getLogin());
        System.out.println(read.getUrl());
        Assert.assertNotEquals(read.getId(),null);
        Assert.assertNotEquals(read.getLogin(),null);
        Assert.assertNotEquals(read.getUrl(),null);
        Assert.assertEquals(client.execute(userDate).getStatusLine().getStatusCode(),200);
    }
}
