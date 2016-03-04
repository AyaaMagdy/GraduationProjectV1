package com.example.ecom;
import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class MatrialLinks extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost mTabHost = getTabHost();

	    mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("First").setContent(new Intent(this  ,FirstActivity.class )));
	    mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Second").setContent(new Intent(this , SecondActivity.class )));
	    mTabHost.addTab(mTabHost.newTabSpec("Third").setIndicator("Third").setContent(new Intent(this , ThirdActivity.class )));
	    mTabHost.addTab(mTabHost.newTabSpec("Fourth").setIndicator("Fourth").setContent(new Intent(this , FourthActivity.class )));
	    mTabHost.setCurrentTab(0);
	}

	

}

