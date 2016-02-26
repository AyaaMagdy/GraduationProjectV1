package services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class StaffEmailsService extends AsyncTask<String,Void,String> {
	Context ctx;
	String serviceType;
public StaffEmailsService(Context ctx) {
	// TODO Auto-generated constructor stub
this.ctx=ctx;	
}
@Override
protected String doInBackground(String... params) {
	String response = "";
	 try {
			URL url = new URL(params[0]);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	
	    serviceType = params[params.length - 1];
	    
	  
		if (serviceType.equals("getEmails"))
		{
			
       DefaultHttpClient client = new DefaultHttpClient();
       
       HttpPost httpGet = new HttpPost(params[0]);
       
       List<NameValuePair> param = new ArrayList<NameValuePair>();
       
       //Log.v("test","URL "+params[0]);
        //   Log.v("param1",params[1]);
       
         param.add(new BasicNameValuePair("dep",params[1]));
        
       try {
               UrlEncodedFormEntity u=new UrlEncodedFormEntity(param,"UTF-8");//bdef parameter 3ala URL
              httpGet.setEntity(u);
           HttpResponse HttpRes = client.execute(httpGet);
           InputStream content = HttpRes.getEntity().getContent();
           
           BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
           String s = "";
           while ((s = buffer.readLine()) != null) {
               response += s;
              
           }
           
           content.close();
       } catch (Exception e) {
           e.printStackTrace();
           Log.v("test",e.toString());
       }
       Log.v("getGrades",response);
       return response;
	    }
	
	return "";
	}
}
