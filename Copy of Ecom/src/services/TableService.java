package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class TableService extends AsyncTask<String,Void,String> {
	Context ctx;
	 TableService()  
	   {  
	       
	   }  
	  
	 public TableService(Context ctx)  
	   {  
	    this.ctx =ctx;  
	   }  
	@Override
	protected String doInBackground(String... params) {
		String response = "" ;
		try {
			URL url = new URL(params[0]);
			String method = params[3];
			//c.execute("http://10.0.2.2/ecom/RegesteredCourses.php",ID,term,year,"getCourses");
			
			if(method.equals("getCoursesAndGroups")){
			DefaultHttpClient client = new DefaultHttpClient();
			
			HttpPost httpPost= new HttpPost(params[0]);
			
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			
	        param.add(new BasicNameValuePair("studentID",params[1]));
	        
	      
	        UrlEncodedFormEntity u=new UrlEncodedFormEntity(param,"UTF-8");
	        
	        httpPost.setEntity(u);
	        
           HttpResponse HttpRes = client.execute(httpPost);
           
           InputStream content = HttpRes.getEntity().getContent();
           
           BufferedReader buffer = new BufferedReader(new InputStreamReader(content)); 
           
           String line = "" ;
           
           while((line = buffer.readLine())!=null){
           	response += line;
           //	Log.v("responceeee",response);
           }
			}
	
			else if(method.equals("saturdayTable")){
				DefaultHttpClient client = new DefaultHttpClient();
				//Log.v("responce2","lllllllll");
				HttpPost httpPost= new HttpPost(params[0]);

				List<NameValuePair> param = new ArrayList<NameValuePair>();
				Log.v("param1",params[1]);
				Log.v("param2",params[2]);
		        param.add(new BasicNameValuePair("courseID",params[1]));
		        param.add(new BasicNameValuePair("groupNo",params[2]));
		        
		        UrlEncodedFormEntity u=new UrlEncodedFormEntity(param,"UTF-8");
		        
		        httpPost.setEntity(u);
		        
	           HttpResponse HttpRes = client.execute(httpPost);
	           
	           InputStream content = HttpRes.getEntity().getContent();
	           
	           BufferedReader buffer = new BufferedReader(new InputStreamReader(content)); 
	           
	           String line = "" ;
	           
	           while((line = buffer.readLine())!=null){
	           	response += line;
	          	//Log.v("responce2",response);
	           }
				
		//	Log.v("responce",response);
				
			}
			
		}
           
		 catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	
	}

}
