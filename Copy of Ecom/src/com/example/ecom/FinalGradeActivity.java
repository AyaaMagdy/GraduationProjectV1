package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import model.GradeModel;
import controller.FinalGradesJParser;
import org.json.JSONException;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
public class FinalGradeActivity extends Activity {

    @Override         
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_grade);
    }
    public void Add(View v) throws JSONException, InterruptedException, ExecutionException {
    
    	 SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
         //String id="",pass="";
        String studentId=sharedpreferences.getString("ID","empty");
        FinalGradesJParser j=new FinalGradesJParser();
        Log.v("test", "Before");
        ArrayList<GradeModel> result=j.search_grades(studentId,"1",this);
       Intent i = new Intent(FinalGradeActivity.this,Show_resultActivity.class);
		i.putExtra("result",result);
		startActivity(i);
        Log.v("y raaab",result.get(0).toString());

 }

}
