package net.stack3.listviewsample;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		ArrayList<String> items = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			items.add(String.format("Item %d", i));
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.main_activity_list_item, R.id.textView, items);
		setListAdapter(adapter);
	}
}
