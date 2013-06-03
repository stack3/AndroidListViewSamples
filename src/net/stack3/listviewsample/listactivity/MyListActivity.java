package net.stack3.listviewsample.listactivity;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import net.stack3.listviewsample.customlistitem.CustomListItem;
import net.stack3.listviewsample.customlistitem.CustomListItemAdapter;
import android.app.ListActivity;
import android.os.Bundle;

public class MyListActivity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_list_activity);
		
		ArrayList<CustomListItem> items = new ArrayList<CustomListItem>();
		for (int i = 0; i < 100; i++) {
			CustomListItem item = new CustomListItem();
			item.setTitle(String.format("Item %d", i));
			item.setDescription(String.format("Description %d", i));
			items.add(item);
		}
		CustomListItemAdapter adapter = new CustomListItemAdapter(this, items);
		
		setListAdapter(adapter);	
	}
}
