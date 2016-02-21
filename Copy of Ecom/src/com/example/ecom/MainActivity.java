package com.example.ecom;

import org.json.JSONException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import controller.LoginController;
public class MainActivity extends Activity {
	
      String s="",s2="";
	 SharedPreferences sharedpreferences;
	 public static final String MyPREFERENCES = "MyPrefs" ;
	 static Context ctx;
	 private CheckBox saveLoginCheckBox;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.ctx = getApplicationContext();
        setContentView(R.layout.activity_main);  
        
   	 EditText mytext=(EditText)findViewById(R.id.ID);
     EditText mytext2=(EditText)findViewById(R.id.Password);
     SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
     
     String id="",pass="";
     id=sharedpreferences.getString("ID","empty");
     pass=sharedpreferences.getString("Password","empty");
     if(!id.equals("empty"))
     {
    	 mytext.setText(id);
    	 mytext2.setText(pass);
     }

     
       
    }
    public static  Context getAppContext() {
        return MainActivity.ctx;
    }
   

    public void Add(View v) throws JSONException {
    	
    	 EditText mytext=(EditText)findViewById(R.id.ID);
         EditText mytext2=(EditText)findViewById(R.id.Password);
         s=mytext.getText().toString();
         s2=mytext2.getText().toString();
   
         LoginController j=new LoginController();
         Log.v("test", "Before");
         j.insert_Person(s,s2,this);
         saveLoginCheckBox=(CheckBox) findViewById(R.id.saveLoginCheckBox);
     	if(saveLoginCheckBox.isChecked())
     	{
     	 sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
     	 SharedPreferences.Editor editor = sharedpreferences.edit();
     	 editor.putString("ID",s);
     	 editor.putString("Password", s2);
     	 editor.commit();
     	}

  }
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }
    
}
