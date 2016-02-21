package controller;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import services.LoginService;

public class LoginController {
    public void insert_Person(String ID,String Password,Context ctx) throws JSONException
    {
        LoginService c=new LoginService(ctx);
        Log.v("test","StartJson");
        c.execute("http://10.0.2.2/ecom/login.php",ID,Password);
     
        Log.v("test","FinishJson");
        
     
    }
    
}
