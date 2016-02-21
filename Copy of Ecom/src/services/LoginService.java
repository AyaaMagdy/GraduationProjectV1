package services;



import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.example.ecom.*;

public class LoginService extends AsyncTask<String,Void,String> {
	 AlertDialog alertDialog; 
	 Context ctx;
	 LoginService()  
	   {  
	       
	   }  
	  
	   public LoginService(Context ctx)  
	   {  
	    this.ctx =ctx;  
	   }  
	 @Override  
	   protected void onPreExecute() {  
		

	   alertDialog = new AlertDialog.Builder(ctx).create();  
	     alertDialog.setTitle("Login Information....");  
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
        DefaultHttpClient client = new DefaultHttpClient();
        
        HttpPost httpGet = new HttpPost(params[0]);
        
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        Log.v("test","URL "+params[0]);
        param.add(new BasicNameValuePair("ID",params[1]));
          
        param.add(new BasicNameValuePair("Password",params[2]));
      
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
            for(int i=0;i<param.size();i++)
            {
                Log.v("testttttt",param.get(i).getName()+" "+param.get(i).getValue());
                
            }
        
            Log.v("test",response);
            content.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.v("test",e.toString());
        }
        
       

        return response;
    }
	 @Override  
	   protected void onPostExecute(String result) {  
	    if(result.equals("Registration Success..."))  
	    {  
	      Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();  
	    }  
	     else  
	    {  
	    	
	    	if(result.contains("Login Success"))
	    	{
	    		Intent homeIntent = new Intent(MainActivity.getAppContext(),
						HomeActivity.class);
	    		
	    		
	    		homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				/* here you should initialize user entity */
				//homeIntent.putExtra("status", object.getString("Status"));
				//homeIntent.putExtra("name", object.getString("name"));
				
				MainActivity.getAppContext().startActivity(homeIntent);
	    	}
	        else{
	    	  alertDialog.setMessage("Login Failed.......Try Again..");  
	          alertDialog.show(); 
	          Intent mainIntent = new Intent(MainActivity.getAppContext(),
						MainActivity.class);
	    		
	    		
	    		mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				
				MainActivity.getAppContext().startActivity(mainIntent);
	        
	        }
	      
	    }  
	   }  

}
