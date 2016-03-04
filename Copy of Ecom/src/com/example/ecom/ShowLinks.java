package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.MatrialModel;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import controller.TermController;

public class ShowLinks extends Activity {
	 RatingBar ratingBar ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_links);
		final String courseName = getIntent().getStringExtra("links");
		 Toast.makeText(ShowLinks.this,
				 courseName, Toast.LENGTH_SHORT)
                .show();
		
	     try {
	    	 
	    	 ArrayList<MatrialModel>MLink = new ArrayList<MatrialModel>();
		     TermController TC2 = new TermController();
			 MLink = TC2.SelectMatrialLinks(courseName, ShowLinks.this);
			
			 LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
			 
			 LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
			            LinearLayout.LayoutParams.WRAP_CONTENT,
			            LinearLayout.LayoutParams.WRAP_CONTENT);
			 
			    Button btn = new Button(this);
			    btn.setId(50000);
			    int id_ = btn.getId();
			    btn.setText("Add Links");
			    btn.setBackgroundColor(Color.rgb(200, 100, 90));
			    LinearLayout linear = (LinearLayout)findViewById(R.id.buttonlayout);
				ll.addView(btn, params);
			    Button btn1 = ((Button) findViewById(id_));
				Toast.makeText(ShowLinks.this,"Button clicked index = " + id_, Toast.LENGTH_SHORT).show();
			    btn1.setOnClickListener(
			    	new View.OnClickListener() {
			        public void onClick(View view) {
						   Intent k = new Intent(ShowLinks.this,AddingLinks.class);
						   k.putExtra("courseName", courseName);
						   startActivity(k);
			        }
			    });
			    
			    

			 for (int i = 0; i < MLink.size(); i++)
			  {
				 TextView tvs1 = new TextView(this);
			     tvs1.setText("");
			     tvs1.setId(i*200);
			     ll.addView(tvs1);
			     
			     TextView tv = new TextView(this);
			     tv.setText("Useful Link For " + MLink.get(i).getTopicName().toString());
			     tv.setId(i );
			     ll.addView(tv);
			    
			     TextView tv2 = new TextView(this);
			     String dynamicUrl = MLink.get(i).getLink(); // or whatever you want, it's dynamic
			     String linkedText = String.format("<a href=\"%s\">link</a> ", dynamicUrl) ;
			     tv2.setText(Html.fromHtml(linkedText));
			     tv2.setMovementMethod(LinkMovementMethod.getInstance());
			     tv2.setId(i*100);
			     ll.addView(tv2);
			     
//			     CheckBox cb = new CheckBox(getApplicationContext());
//		         cb.setText("I'm dynamic!");
//		         ll.addView(cb);
//		         Toast.makeText(ShowLinks.this,cb.getText(), Toast.LENGTH_SHORT).show(); 
//		         if(cb.isChecked()){
//		        	 
//		         }
//		     
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

	private void setupRatingBar(ViewGroup ratingBarContainer){
	     ratingBar = new RatingBar(ShowLinks.this);
	    //All methods you need to initialize the rating bar
	    //including setNumStars(), setStepSize() and layout params

	    ratingBarContainer.addView(ratingBar);
	}

}
