package com.example.ecom;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;


import model.StaffEmails;


import controller.StaffEmailsJParser;

import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class Staff_emails extends Activity {
	Button showPop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_staff_emails);
		showPop = (Button) findViewById(R.id.btn);
		showPop.setOnClickListener(new showPopBtnClickListener());

	}

	class showPopBtnClickListener implements View.OnClickListener {
             
	
		public void onClick(View v) {      
			if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
				Log.v("version number", "" + Build.VERSION.SDK_INT);
			} else {
				PopupMenu myMenu = new PopupMenu(Staff_emails.this, showPop);
         
				myMenu.getMenuInflater().inflate(R.menu.staff_emails,
						myMenu.getMenu());

				myMenu.setOnMenuItemClickListener(new popMenuItemClickListner());

				myMenu.show();

			}
		}

		class popMenuItemClickListner implements
				android.widget.PopupMenu.OnMenuItemClickListener {
       
			@Override
			public boolean onMenuItemClick(MenuItem item) {
 
				//Toast.makeText(Staff_emails.this, item.getTitle(),
					//	Toast.LENGTH_SHORT).show();
				showPop.setText(item.getTitle());
				String selectedDep=item.getTitle().toString();
				StaffEmailsJParser j=new StaffEmailsJParser();
				try {
					ArrayList<StaffEmails>as=j.getDepartmentEmails(selectedDep,Staff_emails.this);
					Log.v("emails",as.get(0).getStaffName());
				
					TableLayout attTable = (TableLayout)findViewById(R.id.tblEmail);
					
					attTable.setStretchAllColumns(true);
					attTable.bringToFront();
					attTable.removeAllViews();
			         
				    for(int i = 0; i < as.size(); i++){
				    	 TableRow tr =  new TableRow(Staff_emails.this);
				    	    tr.setClickable(true);  //allows you to select a specific row
				    	    TextView col1 = new TextView(Staff_emails.this);
					         final TextView col2 = new TextView(Staff_emails.this);
					         col1.setText(as.get(i).getFlag().toString()+" "+as.get(i).getStaffName().toString());
					         col2.setText("      "+as.get(i).getStaffemail().toString());
					         tr.addView(col1);
					         tr.addView(col2);
					       
					         attTable.addView(tr);
					         col2.setOnClickListener(new View.OnClickListener() {
					             @Override
					             public void onClick(View v) {
					                 // TODO Auto-generated method stub
					            	// Toast.makeText(Staff_emails.this, "asmaa",
					 					//	Toast.LENGTH_SHORT).show();
					            	 col2.setTextColor(Color.parseColor("#A01818"));
					            	 /* Create the Intent */
										 Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

										// Fill it with Data 
										emailIntent.setType("plain/text");
										emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{col2.getText().toString()+"@fci-cu.edu.eg"});
										emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
										emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");

										// Send it off to the Activity-Chooser 
										Staff_emails.this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
										finish();
										 
					             }
					         });				        
					 }
				

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		       
				return true;

			}

		}
	}
           
}
