package com.example.ecom;
import controller.AttendanceController;
import model.Courses;
import model.AttendanceModel;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import com.example.ecom.R;
import com.example.ecom.R.id;
import com.example.ecom.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

public class AttendanceActivity extends Activity {
Button first;
Button second;
String studentId = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attendance);
		first = (Button)findViewById(R.id.button1);
		second = (Button)findViewById(R.id.button2);
		 SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
         //String id="",pass="";
         studentId=sharedpreferences.getString("ID","empty");
		setonClik();
	}

	
	public void setonClik(){
		first.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Toast.makeText(AttendanceActivity.this, "hello", Toast.LENGTH_LONG).show();
						AttendanceController j = new AttendanceController();
						ArrayList<Courses> result = new ArrayList<Courses>();
						ArrayList<AttendanceModel> attend = new ArrayList<AttendanceModel>();
						try {	
							result = j.SelectRegisterCourses(studentId, AttendanceActivity.this,"1");
							Log.v("hnaaa",result.size()+"");
							attend = j.getAttendance(result, AttendanceActivity.this, studentId);
							Log.v("attend",attend.size()+"");
							Log.v("test2",result.size()+"");
							Intent i = new Intent(AttendanceActivity.this,Hy4oohActivity.class);
							i.putExtra("result",result);
							i.putExtra("attendance", attend);
							Log.v("test2.2",result.size()+"");
							startActivity(i);
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
						
						//Toast.makeText(AttendanceActivity.this, result.get(0).getCourseName(), Toast.LENGTH_LONG).show();
						
					}
				}
				);
		second.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						//Toast.makeText(AttendanceActivity.this, "hello", Toast.LENGTH_LONG).show();
						AttendanceController j = new AttendanceController();
						ArrayList<Courses> result = new ArrayList<Courses>();
						ArrayList<AttendanceModel> attend = new ArrayList<AttendanceModel>();
						try {
							result = j.SelectRegisterCourses(studentId, AttendanceActivity.this,"2");
							if(result.size()!=0)
							{
							Log.v("hnaaa",result.size()+"");
							attend = j.getAttendance(result, AttendanceActivity.this, studentId);
							Log.v("attend",attend.size()+"");
							Log.v("test2",result.size()+"");
							Intent i = new Intent(AttendanceActivity.this,Hy4oohActivity.class);
							i.putExtra("result",result);
							i.putExtra("attendance", attend);
							Log.v("test2.2",result.size()+"");
							startActivity(i);
							}else{
								Intent i = new Intent(AttendanceActivity.this,ShowAttendanceActivity.class);
								startActivity(i);
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
						
						//Toast.makeText(AttendanceActivity.this, result.get(0).getCourseName(), Toast.LENGTH_LONG).show();
						
					}
				});
		
	}

}
