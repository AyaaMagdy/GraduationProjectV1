package com.example.ecom;

import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import controller.TermController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddingLinks extends Activity {
 EditText topicName;
 EditText link;
 Button add;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding_links);
		final String courseName = getIntent().getStringExtra("courseName");
		topicName = (EditText)findViewById(R.id.editText1);
		link = (EditText)findViewById(R.id.editText2);
		add = (Button)findViewById(R.id.button1);
		
		add.setOnClickListener(
		    	new View.OnClickListener() {
			        public void onClick(View view) {
			            Toast.makeText(view.getContext(),
			            		topicName+"  " + link, Toast.LENGTH_SHORT)
			                    .show();
			          
			          try {
			        	   String gettingTopic = topicName.getText().toString();
			      		   String gettingLink  = link.getText().toString();
			               Log.v("aaaa",gettingTopic);
			            TermController Tm = new TermController();
						Tm.AddMatrialLinks(gettingTopic, gettingLink, courseName, AddingLinks.this);
						Intent k = new Intent(AddingLinks.this,MatrialLinks.class);
						startActivity(k);
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
						   /*Intent k = new Intent(FirstTerm.this,ShowLinks.class);
						   k.putExtra("links",btn.getText());
						   startActivity(k);*/
			        }
			    });
	}

	

}
