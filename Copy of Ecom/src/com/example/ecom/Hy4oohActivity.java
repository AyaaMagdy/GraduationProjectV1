package com.example.ecom;

import java.util.ArrayList;
import model.AttendanceModel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import model.Courses;
public class Hy4oohActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hy4ooh);
		Intent intent;
	     ArrayList<Courses> getResult=(ArrayList<Courses>) getIntent().getSerializableExtra("result");
	     Log.v("courseSize",getResult.size()+"");
	     ArrayList<AttendanceModel> Attendance=(ArrayList<AttendanceModel>) 
	    		 getIntent().getSerializableExtra("attendance");
	     
		TableLayout attTable = (TableLayout)findViewById(R.id.tblTrans);
		attTable.setStretchAllColumns(true);
		attTable.bringToFront();
		
		 TableRow tr2 =  new TableRow(this);
         TextView c11 = new TextView(this);
         TextView c22 = new TextView(this);
         TextView c33 = new TextView(this);
         c11.setText("Courses");
         c22.setText("LabAbsent");
         c33.setText("SectionAbsent");
         tr2.addView(c11);
         tr2.addView(c22);
         tr2.addView(c33);
         attTable.addView(tr2);
         
         TableRow tr3 =  new TableRow(this);
         TextView c13 = new TextView(this);
         TextView c23 = new TextView(this);
         TextView c34 = new TextView(this);
         c13.setText("");
         c23.setText("");
         c34.setText("");
         tr3.addView(c13);
         tr3.addView(c23);
         tr3.addView(c34);
         attTable.addView(tr3);
         
	    for(int i = 0; i < 1; i++){
	    	 TableRow tr =  new TableRow(this);
	         TextView c1 = new TextView(this);
	         c1.setText(getResult.get(i).getCourseName().toString()+getResult.get(i).getCourseID().toString());
	         TextView c2 = new TextView(this);
	         c2.setText("      "+Attendance.get(i).getLab().toString());
	         TextView c3 = new TextView(this);
	         c3.setText("      "+Attendance.get(i).getSec().toString());
	         tr.addView(c1);
	         tr.addView(c2);
	         tr.addView(c3);
	         attTable.addView(tr);
		 }
	}

	

}
