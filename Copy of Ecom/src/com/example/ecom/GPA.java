package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import controller.GPAController;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class GPA extends Activity {
    Button button;
    TextView tv1;
    TextView tv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button1);
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		button.setOnClickListener(
			    	new View.OnClickListener() {
			        public void onClick(View view) {
			        	double gpa = 0.0;
			    		try {
			    			GPAController GC = new GPAController();
			    			SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
			    			String studentId=sharedpreferences.getString("ID","empty");;
			    			ArrayList<String> grades = GC.SelectFinalGrade(studentId, GPA.this);
			    			Log.v("gradesSize", grades.size()+"");
			    			
			    			for(int i=0; i<grades.size(); i++){
			    				if(!grades.get(i).equals(null)){
			    				String x= grades.get(i).toString();
			    				double d = Double.parseDouble(x);
			    				//Log.v("gradesSize", grades.get(i).toString());
			    				
			    				if(d>=90.0){
			    					gpa += 4;
			    				}
			    				
			    				else if(d<90 && d>=85){
			    					gpa += 3.7;
			    				}
			    				
			    				else if(d<85 && d>=80){
			    					gpa += 3.3;
			    				}
			    				
			    				else if(d<80 && d>=75){
			    					gpa += 3;
			    				}
			    				
			    				else if(d<75 && d>=70){
			    					gpa += 2.7;
			    				}
			    				
			    				else if(d<70 && d>=65){
			    					gpa += 2.4;
			    				}
			    				
			    				else if(d<65 && d>=60){
			    					gpa += 2.2;
			    				}
			    				
			    				else if(d<60 && d>=50){
			    					gpa += 2;
			    				}
			    				}
			    				
			    			}
			    			
			    			gpa = (gpa/grades.size())*1.0 ;
			    			long factor = (long) Math.pow(10, 2);
			    			gpa = gpa * factor;
			    		    long tmp = Math.round(gpa);
			    		    gpa =  (double) tmp / factor;
			    			Log.v("gpa",gpa+"");
			    			
			    			String grad = "";
			    			
			    			if(gpa==4){
			    				grad = "A+";
			    			}
			    			
			    			else if(gpa>=3.7 && gpa<4){
			    				grad = "A";
			    			}
			    			
			    			else if(gpa>=3.3 && gpa<3.7){
			    				grad = "B+";
			    			}
			    			
			    			else if(gpa>=3 && gpa<3.3){
			    				grad = "B";
			    			}
			    			
			    			else if(gpa>=2.7 && gpa<3){
			    				grad = "C+";
			    			}
			    			
			    			else if(gpa>=2.4 && gpa<2.7){
			    				grad = "c";
			    			}
			    			
			    			else if(gpa>=2.2 && gpa<2.4){
			    				grad = "D+";
			    			}
			    			
			    			else if(gpa>=2 && gpa<2.2){
			    				grad = "D";
			    			}
			    			else{
			    				grad = "F";
			    			}
			    		tv1.setBackgroundColor(Color.rgb(200, 100, 90));
			    		tv2.setBackgroundColor(Color.rgb(200, 100, 90));
			    		tv1.setText("Grade:  "+"          "+grad.toString());
			    		tv2.setText("Points: "+"          "+gpa+"");
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
			    });
	    
			//Log.v("grad",grad+"");
		    TableLayout attTable = (TableLayout)findViewById(R.id.tblTrans);
			attTable.setStretchAllColumns(true);
			attTable.bringToFront();
			
			 TableRow trs=  new TableRow(this);
	         TextView cs13 = new TextView(this);
	         TextView cs23 = new TextView(this);
	         TextView cs34 = new TextView(this);
	         cs13.setText("");
	         cs23.setText("");
	         cs34.setText("");
	         trs.addView(cs13);
	         trs.addView(cs23);
	         trs.addView(cs34);
	         attTable.addView(trs);
	         
	         TableRow trsp3 =  new TableRow(this);
	         TextView csp13 = new TextView(this);
	         TextView csp23 = new TextView(this);
	         TextView csp34 = new TextView(this);
	         csp13.setText("");
	         csp23.setText("");
	         csp34.setText("");
	         trsp3.addView(csp13);
	         trsp3.addView(csp23);
	         trsp3.addView(csp34);
	         attTable.addView(trsp3);
	         
			 TableRow tr2 =  new TableRow(this);
	         TextView c11 = new TextView(this);
	         TextView c22 = new TextView(this);
	         TextView c33 = new TextView(this);
	         c11.setText("Points");
	         c22.setText("Grade");
	         c33.setText("Persentage");
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
	         
	         TableRow tr4 =  new TableRow(this);
	         TextView c41 = new TextView(this);
	         TextView c42 = new TextView(this);
	         TextView c43 = new TextView(this);
	         c41.setText(" 4");
	         c42.setText(" A+");
	         c43.setText(" 90%");
	         tr4.addView(c41);
	         tr4.addView(c42);
	         tr4.addView(c43);
	         attTable.addView(tr4);
	         
	         TableRow tr5 =  new TableRow(this);
	         TextView c51 = new TextView(this);
	         TextView c52 = new TextView(this);
	         TextView c53 = new TextView(this);
	         c51.setText(" 3.7");
	         c52.setText(" A");
	         c53.setText(" 85-90%");
	         tr5.addView(c51);
	         tr5.addView(c52);
	         tr5.addView(c53);
	         attTable.addView(tr5);
	         
	         TableRow tr6 =  new TableRow(this);
	         TextView c61 = new TextView(this);
	         TextView c62 = new TextView(this);
	         TextView c63 = new TextView(this);
	         c61.setText(" 3.3");
	         c62.setText(" B+");
	         c63.setText(" 80-85%");
	         tr6.addView(c61);
	         tr6.addView(c62);
	         tr6.addView(c63);
	         attTable.addView(tr6);
	         
	         TableRow tr7 =  new TableRow(this);
	         TextView c71 = new TextView(this);
	         TextView c72 = new TextView(this);
	         TextView c73 = new TextView(this);
	         c71.setText(" 3");
	         c72.setText(" B");
	         c73.setText(" 75-80%");
	         tr7.addView(c71);
	         tr7.addView(c72);
	         tr7.addView(c73);
	         attTable.addView(tr7);
	         
	         TableRow tr8 =  new TableRow(this);
	         TextView c81 = new TextView(this);
	         TextView c82 = new TextView(this);
	         TextView c83 = new TextView(this);
	         c81.setText(" 2.7");
	         c82.setText(" C+");
	         c83.setText(" 70-75%");
	         tr8.addView(c81);
	         tr8.addView(c82);
	         tr8.addView(c83);
	         attTable.addView(tr8);
	         
	         TableRow tr9 =  new TableRow(this);
	         TextView c91 = new TextView(this);
	         TextView c92 = new TextView(this);
	         TextView c93 = new TextView(this);
	         c91.setText(" 2.4");
	         c92.setText(" C");
	         c93.setText(" 65-70%");
	         tr9.addView(c91);
	         tr9.addView(c92);
	         tr9.addView(c93);
	         attTable.addView(tr9);
	         
	         TableRow tr33 =  new TableRow(this);
	         TextView c331 = new TextView(this);
	         TextView c332 = new TextView(this);
	         TextView c333 = new TextView(this);
	         c331.setText(" 2.2");
	         c332.setText(" D+");
	         c333.setText(" 60-65%");
	         tr33.addView(c331);
	         tr33.addView(c332);
	         tr33.addView(c333);
	         attTable.addView(tr33);
	         
	         TableRow tr44 =  new TableRow(this);
	         TextView c441 = new TextView(this);
	         TextView c442 = new TextView(this);
	         TextView c443 = new TextView(this);
	         c441.setText(" 2");
	         c442.setText(" D");
	         c443.setText(" 50-60%");
	         tr44.addView(c441);
	         tr44.addView(c442);
	         tr44.addView(c443);
	         attTable.addView(tr44);
	         
	         TableRow tr55 =  new TableRow(this);
	         TextView c551 = new TextView(this);
	         TextView c552 = new TextView(this);
	         TextView c553 = new TextView(this);
	         c551.setText("  ");
	         c552.setText(" f");
	         c553.setText(" 50%");
	         tr55.addView(c551);
	         tr55.addView(c552);
	         tr55.addView(c553);
	         attTable.addView(tr55);
	         
		
		
         
	}

	
}
