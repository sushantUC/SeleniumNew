package API;

import base.BaseTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pages.InvoicingPicklistClass;
import pages.SaleOrderPageClass;
import pages.StagingPicklistClass;

/**
 * Created by sushant on 04/02/19.
 */
public class ApiRequest extends BaseTest{

    public static String picklistDetails;
    public static String Oauth;
    public static String tokenAPI;
    public static String validItmeCode;
    public static CloseableHttpClient client = HttpClients.createDefault();
    SaleOrderPageClass objSOP = new SaleOrderPageClass();
    InvoicingPicklistClass objPicklist = new InvoicingPicklistClass();
    StagingPicklistClass obj = new StagingPicklistClass();



    public static String getOauthApi()throws ClientProtocolException, IOException{
        String test ="";
        String url="https://qa1.unicommerce.com/oauth/token?grant_type=password&client_id=my-trusted-client&username=sushant@unicommerce.com&password=skm@1990";
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(test);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(httpPost);
        BufferedReader br= new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        System.out.println("RESPONSE of Oauth:");
        Oauth=br.readLine();
            System.out.println(Oauth);
            String patern="\"access_token\":\"(.+?)\"";
        Pattern r = Pattern.compile(patern);
        Matcher matcher = r.matcher(Oauth);
        if(matcher.find()){
             tokenAPI = matcher.group(1).toString();
        }else{
            System.out.println("No access token found: ");
        }
        return tokenAPI;
    }



    public  String getPicklistDetailsInvoicing() throws  NullPointerException,IOException,InterruptedException {
        Thread.sleep(2000);
        String url = "https://qa1.unicommerce.com/services/rest/mobile/v1/picklist/detail/get";

        String picklistCodes= InvoicingPicklistClass.manualPicklistCode;
        System.out.println("picklist code get: " + picklistCodes);

        HttpPost httpPost = new HttpPost(url);
        String json = "{\"picklistCode\":"+picklistCodes+"}";
        StringEntity entity = new StringEntity(json);
        System.out.println("Sting json:" + json);
        httpPost.setEntity(entity);
        System.out.println("Sting entity:" + entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("facility", "03");
        String Auth = "Bearer"+tokenAPI;
        System.out.println("auth::: " + Auth);
        httpPost.setHeader("Authorization", Auth);
        CloseableHttpResponse response = client.execute(httpPost);
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        System.out.println("RESPONSE of Get Picklist Details:");

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            if (picklistDetails == null) {
                picklistDetails = line;
            }
            else {
                picklistDetails += line;
            }
        }

       /* String pat="\"validItemCodes\":\\[((.|\\n)*?)\\]";
        Pattern p = Pattern.compile(pat);
        Matcher matcher = p.matcher(picklistDetails);

        System.out.println("matcheer:" + matcher);
        if(matcher.find()){
            validItmeCode = matcher.group(1).toString();
            System.out.println("valid item codes: " + validItmeCode);
        }else{
            System.out.println("NO valid Item code found: ");
        }
        return validItmeCode;*/
       return picklistDetails;
    }



    public  String getPicklistDetailsStaging() throws  NullPointerException,IOException,InterruptedException {
        Thread.sleep(2000);
        picklistDetails=null;

        String url = "https://qa1.unicommerce.com/services/rest/mobile/v1/picklist/detail/get";

        String picklistCodes= StagingPicklistClass.manualPicklistCode;
        System.out.println("picklist code get: " + picklistCodes);

        HttpPost httpPost = new HttpPost(url);
        String json = "{\"picklistCode\":"+picklistCodes+"}";
        StringEntity entity = new StringEntity(json);
        System.out.println("Sting json:" + json);
        httpPost.setEntity(entity);
        System.out.println("Sting entity:" + entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("facility", "03");
        String Auth = "Bearer"+tokenAPI;
        System.out.println("auth::: " + Auth);
        httpPost.setHeader("Authorization", Auth);
        CloseableHttpResponse response = client.execute(httpPost);
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        System.out.println("RESPONSE of Get Picklist Details:");

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            if (picklistDetails == null) {
                picklistDetails = line;
            }
            else {
                picklistDetails += line;
            }
        }

       /* String pat="\"validItemCodes\":\\[((.|\\n)*?)\\]";
        Pattern p = Pattern.compile(pat);
        Matcher matcher = p.matcher(picklistDetails);

        System.out.println("matcheer:" + matcher);
        if(matcher.find()){
            validItmeCode = matcher.group(1).toString();
            System.out.println("valid item codes: " + validItmeCode);
        }else{
            System.out.println("NO valid Item code found: ");
        }
        return validItmeCode;
        */
        return picklistDetails;
    }

}


