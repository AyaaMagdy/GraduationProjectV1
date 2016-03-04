package com.example.ecom;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {
	Button btn;
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
    
    public void MatrialsLink(View v)
    {
    	 
  
    	Intent mIntent=new Intent(HomeActivity.this ,MatrialLinks.class);
		startActivity(mIntent);
		
    }
    
    public void GPA(View v)
    {
    	 
  
    	Intent mIntent=new Intent(HomeActivity.this ,GPA.class);
		startActivity(mIntent);
		
    }
    
    public void Agenda(View v)
    {
    	 
    	btn = (Button)findViewById(R.id.button1);
	    btn.setBackgroundColor(Color.rgb(200, 100, 90));
		String dynamicUrl = "http://www.fci.cu.edu.eg/ar/Academic_Agenda" ;
		String linkedText = String.format("<a href=\"%s\">Agenda</a> ", dynamicUrl);
		btn.setText(Html.fromHtml(linkedText));
		
    }
     
    
}
