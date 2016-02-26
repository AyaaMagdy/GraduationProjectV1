package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import controller.TableController;

import model.GradeModel;
import model.TableModel;
import controller.FinalGradesJParser;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TableActivity extends Activity  {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
 
       
 
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
 
        String[] items = new String[] { "Choose Day","Saturday", "Sunday", "Monday" };
 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
 
        dynamicSpinner.setAdapter(adapter);
 
        dynamicSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                String day=(String) parent.getItemAtPosition(position);
                SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                //String id="",pass="";
               String studentId=sharedpreferences.getString("ID","empty");
               Log.v("testID", studentId);
               TableController t=new TableController();
               Log.v("test", "Before");
               ArrayList<String> result = null;
               ArrayList<TableModel>satTable=new ArrayList<TableModel>();
			try {
				result = t.getCoursesAndGroups(studentId,TableActivity.this);
				  Log.v("test", "Afteer");
				  Log.v("testttt", result.toString());
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
               ////Log.v("0",result.get(0).toString());
              // Log.v("1",result.get(1).toString());
               if(day.equals("Saturday"))
                {
                	try {
                		satTable=t.saturdayTable(result, TableActivity.this);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                	Intent in = new Intent(TableActivity.this,SaturdayActivity.class);
                	in.putExtra("SatTable", satTable);
                	startActivity(in);
                }
            }
 
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}
	


