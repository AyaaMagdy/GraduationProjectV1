package com.example.ecom;

import java.util.ArrayList;

import android.inputmethodservice.Keyboard.Row;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ShowAttendanceActivity extends Activity {


Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_attendance);
		Toast.makeText(ShowAttendanceActivity.this, "No registered Courses", Toast.LENGTH_LONG).show();
	    back =  (Button)findViewById(R.id.button1);
	    back.setOnClickListener(
	    		 new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Intent i = new Intent(ShowAttendanceActivity.this,MainActivity.class);
						startActivity(i);
						
					}
				}
	);
 
	}

}
