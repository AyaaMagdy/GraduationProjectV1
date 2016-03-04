package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.Courses;

import org.json.JSONException;

import controller.TermController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SecondTerm extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_term);

		try {
			String year = getIntent().getStringExtra("Year");
			String Term = "second";
			TermController TC = new TermController();
			ArrayList<Courses> result = new ArrayList<Courses>();
			Toast.makeText(SecondTerm.this, year,Toast.LENGTH_LONG ).show();
			result=TC.SelectRegisterCourses(Term, SecondTerm.this, year);
			Log.v("res",result.size()+"");
		    ArrayList<String> Subject = new ArrayList<String>();
			
			for(int j=0; j<result.size(); j++){
				Subject.add(result.get(j).getCourseName());
			}
			
			for (int i = 0; i < result.size(); i++) {
				
			    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
			            LinearLayout.LayoutParams.WRAP_CONTENT,
			            LinearLayout.LayoutParams.WRAP_CONTENT);
			    final Button btn = new Button(this);
			    btn.setId(i);
			    final int id_ = btn.getId();
			    final String n=result.get(i).getCourseName();
			    btn.setText(n);
			    btn.setBackgroundColor(Color.rgb(200, 100, 90));
			    LinearLayout linear = (LinearLayout)findViewById(R.id.buttonlayout);
				linear.addView(btn, params);
			    Button btn1 = ((Button) findViewById(id_));
			    
			    btn1.setOnClickListener(
			    	new View.OnClickListener() {
			        public void onClick(View view) {
			            Toast.makeText(view.getContext(),
			                    "Button clicked index = " + id_, Toast.LENGTH_SHORT)
			                    .show();
			          
						   Intent k = new Intent(SecondTerm.this,ShowLinks.class);
						   k.putExtra("links",btn.getText());
						   startActivity(k);
			        }
			    });
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
