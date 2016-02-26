package com.example.ecom;

import java.util.ArrayList;

import model.Courses;
import model.TableModel;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class SaturdayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saturday);
		 ArrayList<TableModel> getResult=(ArrayList<TableModel>) getIntent().getSerializableExtra("SatTable");
	     Log.v("SatSize",getResult.size()+"");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.saturday, menu);
		return true;
	}

}
