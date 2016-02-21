package com.example.ecom;

import java.util.ArrayList;
import model.GradeModel;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Show_resultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grades_result);
		Log.v("i'm here","here i am");
		ArrayList<GradeModel> getResult=(ArrayList<GradeModel>) getIntent().getSerializableExtra("result");     
	
		TableLayout attTable = (TableLayout)findViewById(R.id.tblTrans);
		attTable.setStretchAllColumns(true);
		attTable.bringToFront();
		
		 TableRow tr =  new TableRow(this);
         TextView c1 = new TextView(this);
         TextView c2 = new TextView(this);
         TextView c3 = new TextView(this);
         TextView c4 = new TextView(this);
         TextView c5 = new TextView(this);
         c1.setText("Course  ");
         c2.setText("term work  ");
         c3.setText("exam  ");
         c4.setText("result  ");
         c5.setText("Grade  ");
         tr.addView(c1);
         tr.addView(c2);
         tr.addView(c3);
         tr.addView(c4);
         tr.addView(c5);
         attTable.addView(tr);
         
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
         
	    for(int i = 0; i < getResult.size(); i++){
	    	Log.v("offffffff",getResult.get(i).toString());
	    	 TableRow tr2 =  new TableRow(this);
	         TextView col1 = new TextView(this);
	         TextView col2 = new TextView(this);
	         TextView col3 = new TextView(this);
	         TextView col4 = new TextView(this);
	         TextView col5 = new TextView(this);
	         col1.setText(getResult.get(i).getCourseName().toString());
	         col2.setText("    "+getResult.get(i).getTerm_work().toString());
	         col3.setText(getResult.get(i).getExam_work().toString());
	         col4.setText(getResult.get(i).getResult().toString());
	         col5.setText(getResult.get(i).getGrade().toString());
	         tr2.addView(col1);
	         tr2.addView(col2);
	         tr2.addView(col3);
	         tr2.addView(col4);
	         tr2.addView(col5);
	         attTable.addView(tr2);
		 }
	}

	

}
/* public void init(){
TableLayout ll = (TableLayout) findViewById(R.id.displayLinear);


for (int i = 0; i <2; i++) {

    TableRow row= new TableRow(this);
    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
    row.setLayoutParams(lp);
    checkBox = new CheckBox(this);
    tv = new TextView(this);
    addBtn = new ImageButton(this);
    addBtn.setImageResource(R.drawable.add);
    minusBtn = new ImageButton(this);
    minusBtn.setImageResource(R.drawable.minus);
    qty = new TextView(this);
    checkBox.setText("hello");
    qty.setText("10");
    row.addView(checkBox);
    row.addView(minusBtn);
    row.addView(qty);
    row.addView(addBtn);
    ll.addView(row,i);
*/