package com.ctin.parseojson;

import java.util.Map;
import java.util.Map.Entry;

import com.ctin.classes.CityChanges;
import com.ctin.classes.Proposition;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CityChanges.loadUrl();
		for (Entry<Integer, Proposition> entry : CityChanges.getPropositions().entrySet()) {
			Log.d("propositions", "Key : " + entry.getKey() + " Value : "
				+ entry.getValue().getUser().getMyPropositions().get(0).getInitiative());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
