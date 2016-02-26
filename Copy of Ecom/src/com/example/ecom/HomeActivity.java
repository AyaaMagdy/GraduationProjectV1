package com.example.ecom;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      
    }
    
  
    public void  grade (View v)
    {
    	Intent mIntent=new Intent(HomeActivity.this ,FinalGradeActivity.class);
		startActivity(mIntent);
    }
    public void attendance (View v)
    {
    	Intent mIntent=new Intent(HomeActivity.this , AttendanceActivity.class);
		startActivity(mIntent);
    }
  
    public void logOut(View v)
    {
    	 
  
    	Intent mIntent=new Intent(HomeActivity.this ,MainActivity.class);
		startActivity(mIntent);
		
    }

    public void staffemails(View v)
    {
    	 
  
    	Intent mIntent=new Intent(HomeActivity.this ,Staff_emails.class);
		startActivity(mIntent);
		
    }
     
    
}
