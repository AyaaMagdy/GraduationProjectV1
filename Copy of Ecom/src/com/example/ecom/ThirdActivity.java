package com.example.ecom;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class ThirdActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		
		Intent i1 = new Intent(this , FirstTerm.class ) ;
		i1.putExtra("Year", "three");
		
		Intent i2 = new Intent(this , SecondTerm.class ) ;
		i2.putExtra("Year", "three");
		
	    TabHost mTabHost = getTabHost();
		
	    mTabHost.addTab(mTabHost.newTabSpec("First Term").setIndicator("First Term").setContent(i1));
	    mTabHost.addTab(mTabHost.newTabSpec("Second Term").setIndicator("Second Term").setContent(i2));
	    
	    mTabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

}
