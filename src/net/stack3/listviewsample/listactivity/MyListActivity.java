package net.stack3.listviewsample.listactivity;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import net.stack3.listviewsample.customitem.CustomItem;
import net.stack3.listviewsample.customitem.CustomItemAdapter;
import android.app.ListActivity;
import android.os.Bundle;

public class MyListActivity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_list_activity);
		
		ArrayList<CustomItem> items = new ArrayList<CustomItem>();
		for (int i = 0; i < 100; i++) {
			CustomItem item = new CustomItem();
			item.setTitle(String.format("Item %d", i));
			item.setDescription(String.format("Description %d", i));
			items.add(item);
		}
		CustomItemAdapter adapter = new CustomItemAdapter(this, items);
		
		setListAdapter(adapter);	
	}
}
